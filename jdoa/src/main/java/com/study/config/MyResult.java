package com.study.config;

/*封装的统一响应对象
* 1、Controller的返回类型,全部要变成MyResult
*/

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class MyResult implements Serializable {
    private Integer code;//表示返回的结果(1表示正常,非1表示其他意思)
    private String msg;//表示返回的文本提示(一般用于错误信息提示)
    private Object obj;//返回到前台是一个实体对象
    private List<?> objs;//返回到前台的是一个集合对象

    public MyResult(){
        code=1;
    }
   //有code值和信息需要返回
   public MyResult(Integer code,String msg){
       this.code=code;
       this.msg=msg;
   }
   //有实体类需要返回的,code等于1
   public MyResult(Object obj){
       this.code=1;
       this.obj=obj;
   }
   //有集合类型需要返回的,code等于1
   public MyResult(List<?> objs){
       this.code=1;
       this.objs=objs;
   }


    /** 成功并携带分页集合数据
     * @param list
     * @return
     */
    public  static  MyResult okAndpage(PageInfo<?> list){
        return new MyResult(list);
    }


   //当代码发生错误时调用
   public static MyResult ERROR(String msg){
       return new MyResult(-1,msg);
   }

   //代码需要返回一个实体类对象时调用
   public static MyResult returnObj(Object obj){
       return new MyResult(obj);
   }

    //代码需要返回一个集合对象时调用
    public static MyResult returnObjs(List<?> objs){
        return new MyResult(objs);
    }
    //当代码成功的时候调用
    public static MyResult SUCCESS=new MyResult();//code默认等于1


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public List<?> getObjs() {
        return objs;
    }

    public void setObjs(List<?> objs) {
        this.objs = objs;
    }

    @Override
    public String toString() {
        return "MyResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                ", objs=" + objs +
                '}';
    }
}
