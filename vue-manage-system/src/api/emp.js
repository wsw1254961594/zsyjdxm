/*
@author: pengjia
@date: 2020/12/21
@description:
*/
import {postJson} from "../network";

export const empHttp = {
  login:function (emp) {
    let params = {
      url: '/login',
      data:{
        'ename':emp.ename
      }
    }
    return postJson(params)
  }
}
