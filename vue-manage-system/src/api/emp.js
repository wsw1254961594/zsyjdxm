/*
@author: pengjia
@date: 2020/12/21
@description:
*/
import {get,postJson} from "../network";

export const empHttp = {
  login:function (emp) {
    let params = {
      url: '/login',
      data:{
        'ename':emp.ename,
        'password':emp.password
      }
    }
    return postJson(params)
  },
  getEmpDetail:function (empno) {
    let params = {
      url:'/emp_detail',
      data:{
        'empno':empno
      }
    }
    return get(params)
  }
}
