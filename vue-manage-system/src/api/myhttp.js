import http from './http.js'
import {Message} from 'element-ui'

let myhttp={
  //用于处理增删改
  //url  请求的地址
  //param  请求的参数
  //handler  回调函数，可以没有
  update(url,param,handler){
    //调用axios的put请求。r的参数，等同于原来的r.data
    http.put(url,param).then(r=>{
      if(r.code===1){
        if(typeof(handler)==="function"){
            handler();//调用回调函数，没有传参
        }else{
            Message.success({message:'操作成功!'});
        }
      }else{
        //Message.error({message:r.msg});
      }
    })
  },
  updatePost(url,param,handler){
    //调用axios的Post请求。r的参数，等同于原来的r.data
    http.post(url,param).then(r=>{
      if(r.code===1){
        if(typeof(handler)==="function"){
            handler();//调用回调函数，没有传参
        }else{
            Message.success({message:'操作成功!'});
        }
      }else{
        //Message.error({message:r.msg});
      }
    })
  },
  //接收后台返回单个对象的响应
  //url   请求到后台的地址
  //param  请求到后台的参数
  //handler  会调函数。会在then执行之后被调用
  getObj(url,param,handler){
    //调用封装之后的axios的put方法
    http.put(url,param)
    .then(r=>{
      //此处的r，等同于r.data
      if(r.code===1){
         if(typeof(handler)==="function"){
           handler(r.obj);//回调函数，把当前的结果传递给它；
         }else{
           Message.success({message:'操作成功....'});
         }
      }else{
        Message.error({message:r.msg});
      }
    })
  },
  //接收后台返回的List响应
  getObjs(url,param,handler){
    //调用封装之后的axios的方法
    http.put(url,param,handler)
    .then(res=>{
      if(res.code===1){
        if(typeof(handler)==='function'){
          handler(res.objs);//回调函数,把后台的List对象响应给前台
        }else{
          Message.success({message:"操作成功!!!"});
        }
      }else{
        Message.error({message:res.msg});
      }
    })
  },
  updateAndReturn(url,param,handler){
    //调用封装之后的axios的方法
    http.post(url,param,handler)
    .then(res=>{
      if(res.code===1){
        if(typeof(handler)==='function'){
          handler(res.obj);//回调函数,把整个对象返回出去
        }else{
          Message.success({message:"操作成功!!!"});
        }
      }else{
        Message.error({message:res.msg});
      }
    })
  },
  
}

export default myhttp;
