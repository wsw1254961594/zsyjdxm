/*
@author: pengjia
@date: 2020/12/22
@description:
*/
import {get,postJson} from "../network";

export const workHttp = {
  addWork:function (workTime) {
    let params = {
      url:'/work/add',
      data:{
        'reqEmpno':workTime.reqEmpno,
        'starttime':workTime.starttime,
        'endtime':workTime.endtime,
        'jtype':workTime.jtype,
        'jreason':workTime.jreason,
        'jtitle':workTime.jtitle
      }
    }
    return postJson(params)
  },
  getWork:function (jnid) {
    let params = {
      url:'/work',
      data:{
        'jnid':jnid
      }
    }
    return get(params)
  },
  listWork:function (jiaban,pageNum) {
    let params = {
      url:'/work/list',
      data:{
        'jtitle':jiaban.jtitle,
        'jtype':jiaban.jtype,
        'starDate':jiaban.starDate,
        'endDate':jiaban.endDate,
        'pageNum':pageNum
      }
    }
    return get(params)
  }
}
