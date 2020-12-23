/*
@author: pengjia
@date: 2020/12/23
@description:
*/
import {get,postJson} from "../network";
export const backLogHttp = {
  listPage:function (backLog,pageNum) {
    let params = {
      url:'/backlog/list',
      data:{
        'btetle':backLog.btetle,
        'bcondition':backLog.bcondition,
        'empid':backLog.empid,
        'pageNum':pageNum
      }
    }
    return get(params)
  },
  rejectBackLog:function (blid) {
    let params = {
      url:'/backlog/reject',
      data:{
        'blid':blid,
        'bcondition':2
      }
    }
    return postJson(params)
  },
  agreeBackLog:function (blid) {
    let params = {
      url:'/backlog/agree',
      data:{
        'blid':blid,
        'bcondition':1
      }
    }
    return postJson(params)
  }
}
