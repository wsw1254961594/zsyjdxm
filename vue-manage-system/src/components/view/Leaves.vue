<!--
@author: pengjia
@date: 2020/12/22
@description:
-->
<template>
  <div>
    <el-card>
      <div slot="header">
        <span>员工请假申请</span>
      </div>
      <div>
        <el-form :model="addForm" ref="addFormRef" size="mini"
                 label-width="80px" label-position="right" :rules="addFormRules">
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="姓名">
                <el-tag>{{this.empDetail.ename}}</el-tag>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="部门">
                <el-tag>{{this.empDetail.dept}}</el-tag>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="标题" prop="ltitle">
                <el-input v-model="addForm.ltitle" clearable></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="类型" prop="itype">
                <el-select v-model="addForm.itype" clearable>
                  <el-option v-for="(item,index) in iTypeList" :key="index"
                             :label="item.label" :value="item.value"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="开始时间" prop="lbegin">
                <el-date-picker v-model="addForm.lbegin" type="datetime"
                                :picker-options="pickerOptions"
                                placeholder="选择日期时间" clearable>
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="结束时间" prop="ifinish">
                <el-date-picker v-model="addForm.ifinish" type="datetime"
                                :picker-options="pickerOptions" @change="ifinishChange"
                                placeholder="选择日期时间" clearable>
                </el-date-picker>
              </el-form-item>
            </el-col>

          </el-row>
          <el-row :gutter="20">
            <el-col :span="24">
              <el-form-item label="原因" prop="lreason">
                <el-input clearable type="textarea" v-model="addForm.lreason"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="20">
            <el-col :span="20">
              <el-form-item label="天数">
                <el-tag>{{this.diffDate}}</el-tag>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item>
                <el-button style="float: right;" @click="addClick"
                           :loading="addButtonLoading"
                           type="primary" icon="el-icon-plus">添加</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
  import {leavesHttp} from "../../api/leaves";
  import {empHttp} from "../../api/emp";

  export default {
    name: "Leaves",
    data() {
      return {
        empDetail:{
          ename:'',
          dept:''
        },
        diffDate:'',
        addForm:{
          lbegin:'',
          ifinish:'',
          lreason:'',
          ltitle:'',
          itype:'',
          reqEmpno:this.$store.state.empno
        },
        iTypeList:[
          {label:'事假',value:'事假'},
          {label:'病假',value:'病假'},
          {label:'年假',value:'年假'},
          {label:'婚假',value:'婚假'},
          {label:'丧假',value:'丧假'},
          {label:'调休',value:'调休'}
        ],
        addFormRules:{
          itype:[
            { required: true, message: '请选择请假类型', trigger: 'change' }
          ],
          lreason:[
            { required: true, message: '请填写请假原因', trigger: 'blur' }
          ],
          lbegin:[
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          ifinish:[
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ]
        },
        addButtonLoading:false,
        pickerOptions: {
          disabledDate(date){
            let zero=new Date().setHours(0, 0, 0, 0);
            if(date.getTime()<zero){
              return true;
            }
            return false;
          }
        },
      }
    },
    methods:{
      ifinishChange() {
        let endDate = new Date(this.addForm.lbegin);
        let startDate = new Date(this.addForm.ifinish);
        let days = parseInt(Math.abs(endDate - startDate) / (24 * 3600 * 1000));
        console.log(days)
        this.difference(this.addForm.lbegin,this.addForm.ifinish)
      },
      difference: function (beginTime, endTime) {
        var dateBegin = new Date(beginTime);
        var dateEnd = new Date(endTime);
        var dateDiff = dateEnd.getTime() - dateBegin.getTime();//时间差的毫秒数
        var dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));//计算出相差天数
        var leave1 = dateDiff % (24 * 3600 * 1000);    //计算天数后剩余的毫秒数
        var hours = Math.floor(leave1 / (3600 * 1000));//计算出小时数
        //计算相差分钟数
        var leave2 = leave1 % (3600 * 1000);   //计算小时数后剩余的毫秒数
        var minutes = Math.floor(leave2 / (60 * 1000)); //计算相差分钟数
        //计算相差秒数
        var leave3 = leave2 % (60 * 1000);     //计算分钟数后剩余的毫秒数
        var seconds = Math.round(leave3 / 1000);
        this.diffDate = dayDiff + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒"
      },
      initLeavesTitle() {
        this.addForm.ltitle = "员工请假流程"+"-"+this.$store.state.ename+"-"+this.dateFormat(new Date())
      },
      dateFormat(time) {
        if (time != null) {
          let date = new Date(time)
          let year = date.getFullYear()
          let month = date.getMonth()+1<10?"0"+(date.getMonth()+1) : date.getMonth()+1
          let day = date.getDate()<10?"0"+date.getDate():date.getDate()
          /*let hours = date.getHours()<10?"0"+date.getHours():date.getHours()
          let minutes = date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes()
          let seconds = date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds()*/
          //拼接
          return year+"-"+month+"-"+day
        } else {
          return ''
        }
      },
      addClick() {
        this.$refs.addFormRef.validate(valid => {
          if (!valid) return
          this.addButtonLoading = true
          leavesHttp.addLeaves(this.addForm).then(res => {
            if (res.code === 1) {
              this.$message.success("成功")
              this.$refs.addFormRef.resetFields()
              this.addButtonLoading = false
            } else {
              this.$message.error("错误")
            }
          })
        })
      },
      initEmpDetail() {
        empHttp.getEmpDetail(this.$store.state.empno).then(res => {
          this.empDetail.ename = res.obj.ename
          this.empDetail.dept = res.obj.mydept.dname
        })
      }
    },
    created() {
      this.initLeavesTitle()
      this.initEmpDetail()
    }
  }
</script>

<style scoped>

</style>
