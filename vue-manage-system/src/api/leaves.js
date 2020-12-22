/*
@author: pengjia
@date: 2020/12/22
@description:
*/
import {postJson} from "../network";
export const leavesHttp = {
  addLeaves:function (leaves) {
    let params = {
      url:'/leaves/add',
      data:{
        'empno':leaves.empno,
        'lbegin':leaves.lbegin,
        'ifinish':leaves.ifinish,
        'lreason':leaves.lreason,
        'ltitle':leaves.ltitle,
        'itype':leaves.itype,
        'reqEmpno':leaves.reqEmpno
      }
    }
    return postJson(params)
  }
}
