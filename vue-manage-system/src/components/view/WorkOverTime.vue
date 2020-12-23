<!--
@author: pengjia
@date: 2020/12/22
@description:
-->
<template>
  <div>
    <el-card>
      <div slot="header">
        <span>加班申请单</span>
      </div>
      <div>
        <el-form :model="addForm" label-position="right" size="mini"
                 ref="addFormRef" :rules="addFormRules" label-width="80px">
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="标题" prop="jtitle">
                <el-input v-model="addForm.jtitle" clearable></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="类型" prop="jtype">
                <el-select v-model="addForm.jtype" clearable>
                  <el-option v-for="(item,index) in jtypeList" :key="index"
                             :label="item.label" :value="item.value"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="20">
            <el-col :span="10">
              <el-form-item label="开始时间" prop="starttime">
                <el-date-picker v-model="addForm.starttime"
                                :picker-options="pickerOptions"
                                type="datetime" clearable></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="结束时间" prop="endtime">
                <el-date-picker v-model="addForm.endtime"
                                :picker-options="pickerOptions"
                                type="datetime" clearable></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-button type="primary" icon="el-icon-plus" :loading="addButtonLoading"
                         @click="addClick" style="float: right">新增</el-button>
            </el-col>
          </el-row>
          <el-row>
            <el-col>
              <el-form-item label="原因" prop="jreason">
                <el-input v-model="addForm.jreason" type="textarea" clearable></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>

  import {workHttp} from "../../api/worktime";

  export default {
    name: "WorkOverTime",
    data() {
      return {
        addForm:{
          empno:'',
          starttime:'',
          endtime:'',
          jtype:'',
          jreason:'',
          jtitle:'',
          reqEmpno:this.$store.state.empno
        },
        addButtonLoading:false,
        addFormRules: {
          jtype:[
            { required: true, message: '请选择加班类型', trigger: 'change' }
          ],
          starttime:[
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          endtime:[
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          jreason:[
            { required: true, message: '请填写请假原因', trigger: 'blur' }
          ]
        },
        jtypeList:[
          {label:'工作加班',value:'工作加班'},
          {label:'双休日加班',value:'双休日加班'},
          {label:'法定假日加班',value:'法定假日加班'},
          {label:'每天通宵',value:'每天通宵'},
        ],
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
      addClick() {
        this.$refs.addFormRef.validate(valid => {
          if (!valid) return
          this.addButtonLoading = true
          workHttp.addWork(this.addForm).then(res => {
            if (res.code === 1) {
              this.$message.success("成功")
              this.$refs.addFormRef.resetFields()
              this.addButtonLoading = false
            } else {
              this.$message.error("错误")
              this.addButtonLoading = false
            }
          })
        })
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
      initWorkTitle() {
        this.addForm.jtitle = "员工加班流程"+"-"+this.$store.state.ename+"-"+this.dateFormat(new Date())
      },
    },
    created() {
      this.initWorkTitle()
    }
  }
</script>

<style scoped>

</style>
