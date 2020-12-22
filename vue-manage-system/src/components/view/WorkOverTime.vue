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
                <el-date-picker v-model="addForm.starttime" type="datetime" clearable></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="结束时间" prop="endtime">
                <el-date-picker v-model="addForm.endtime" type="datetime" clearable></el-date-picker>
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
          jtitle:''
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
          ]
        },
        jtypeList:[
          {label:'工作加班',value:'工作加班'},
          {label:'双休日加班',value:'双休日加班'},
          {label:'法定假日加班',value:'法定假日加班'},
          {label:'每天通宵',value:'每天通宵'},
        ]
      }
    },
    methods:{
      addClick() {
        this.$refs.addFormRef.validate(valid => {
          if (!valid) return

        })
      }
    }
  }
</script>

<style scoped>

</style>
