package com.study.services;

import com.study.model.mdao.IPostsMapper;
import com.study.pojo.Positive;
import com.study.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServices {
    @Autowired
    IPostsMapper mapper;

    //员工调岗
    public Integer insertpost(Posts posts){
            try {
                return mapper.insertpost(posts);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }

    }

    public Integer selectmax(){
        Integer list=mapper.selectmax();
        return list;
    }
}
