package com.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/webSocket/{tokenvalue}") //核心,前端用这个路径访问
@Slf4j
@Component
public class WebSocket {
    //这里用的是线程安全的map集合,我juc里面有讲
    private static Map<String, WebSocket> webSocketSet = new ConcurrentHashMap<String, WebSocket>();
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("tokenvalue") String tokenvalue, Session session) {
        System.out.println(tokenvalue);
        this.session = session;
//        onlineCount.incrementAndGet(); //在线数加1
        webSocketSet.put(tokenvalue, this);     //加入set中
        log.info("有新窗口,开始监听:" + tokenvalue + ",当前在线人数为" + webSocketSet.size());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        Collection<WebSocket> col = webSocketSet.values();
        while (true == col.contains(this)) {
            col.remove(this);
        }
        log.info("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口 的信息:" + message);
        if ("heart".equals(message)) {
            try {
                sendMessage("heartOk");
            } catch (IOException e) {
            }
        }
    }

    /**
     * 发生错误
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        Collection<WebSocket> col = webSocketSet.values();
        while (true == col.contains(this)) {
            col.remove(this);
        }
        log.info("有一连接关闭！当前在线人数为" + webSocketSet.size());
        log.error("发生错误");
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) throws IOException {
        webSocketSet.forEach((k, v) -> {
            try {
                v.sendMessage(message);
                log.info("推送消息到窗口" + "，推送内容:" + message);
            } catch (IOException e) {
            }
        });
    }

    /**
     * 指定某个用户发送信息
     *
     * @param message
     */
    public static void setsendInfo(String name, String message) {
        webSocketSet.forEach((k, v) -> {
            if (name.equals(k)) {
                try {
                    v.sendMessage(message);
                    log.info("发送了信息:" + message + ",给:" + name);
                } catch (IOException e) {
                }
            }
        });
    }

}
