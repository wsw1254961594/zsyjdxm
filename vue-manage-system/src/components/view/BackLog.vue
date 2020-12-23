<!--
@author: pengjia
@date: 2020/12/23
@description:
-->
<template>
  <div>
    <el-card>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-input v-model="searchForm.btetle" style="width: 400px"
                    placeholder="请输入标题查询" size="mini" clearable>
            <el-select v-model="searchForm.bcondition" slot="prepend"
                       style="width: 100px" placeholder="请选择">
              <el-option label="待审核" value="0"></el-option>
              <el-option label="已审核" value="1"></el-option>
              <el-option label="已驳回" value="2"></el-option>
            </el-select>
            <el-button @click="searchInputClick" slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
      </el-row>

      <el-table :data="listForm" style="margin-top: 20px" align="center" v-loading="tableLoading">
        <el-table-column label="类型" prop="btetle"></el-table-column>
        <el-table-column label="状态" prop="bcondition">
          <template slot-scope="scope">
            {{bconditionFormat(scope.row.bcondition)}}
          </template>
        </el-table-column>
        <el-table-column label="申请日期" prop="baccept">
          <template slot-scope="scope">
            {{dateFormat(scope.row.baccept)}}
          </template>
        </el-table-column>
        <el-table-column label="申请人" prop="applicantResp"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="text" size="mini" icon="el-icon-edit"
                       :disabled="!scope.row.bcondition == 0"
                       @click="handleBackLogAgree(scope.row.blid)">同意</el-button>
            <el-button type="text" size="mini" icon="el-icon-error"
                       :disabled="!scope.row.bcondition == 0"
                       @click="handleBackLogReject(scope.row.blid)">驳回</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination background style="margin-top: 10px"
                     @current-change="handleCurrentChange"
                     :current-page="pageNum" :page-sizes="[1,2,5,10]"
                     :page-size="pageSize" :total="total"
                     layout="prev, pager, next, jumper, total">
      </el-pagination>
    </el-card>
  </div>
</template>

<script>
  import {backLogHttp} from "../../api/backlog";

  export default {
    name: "BackLog",
    data() {
      return {
        tableLoading:false,
        searchForm:{
          bcondition:'',
          btetle:'',
          empid:this.$store.state.empno
        },
        listForm:[],
        total:0,
        pageNum:1,
        pageSize:10
      }
    },
    methods:{
      initBackLog() {
        backLogHttp.listPage(this.searchForm,this.pageNum).then(res => {
          this.listForm = res.obj.list
          this.total = res.obj.total
          this.pageNum = res.obj.pageNum
        })
      },
      handleCurrentChange(pageIndex) {
        this.pageNum = pageIndex
        backLogHttp.listPage(this.searchForm,this.pageNum).then(res => {
          this.listForm = res.obj.list
          this.total = res.obj.total
          this.pageNum = res.obj.pageNum
        })
      },
      searchInputClick(){
        backLogHttp.listPage(this.searchForm,this.pageNum).then(res => {
          this.listForm = res.obj.list
          this.total = res.obj.total
          this.pageNum = res.obj.pageNum
        })
      },
      handleBackLogAgree(blid) {
        this.$confirm('是否继续','提示',{
          confirmButtonText:'确定',
          cancelButtonText:'取消',
          type:'warning'
        }).then(() => {
          this.tableLoading = true
          backLogHttp.agreeBackLog(blid).then(res => {
            if (res.code === 1) {
              this.$message.success("成功")
              this.initBackLog()
              this.tableLoading = false
            } else {
              this.$message.error("失败")
              this.initBackLog()
              this.tableLoading = false
            }
          })
        })
      },
      handleBackLogReject(blid) {
        this.$confirm('是否继续','提示',{
          confirmButtonText:'确定',
          cancelButtonText:'取消',
          type:'warning'
        }).then(() => {
          this.tableLoading = true
          backLogHttp.rejectBackLog(blid).then(res => {
            if (res.code === 1) {
              this.$message.success("成功")
              this.initBackLog()
              this.tableLoading = false
            } else {
              this.$message.error("失败")
              this.initBackLog()
              this.tableLoading = false
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
      bconditionFormat(bcondition) {
        if (bcondition === 0) {
          return '未处理'
        } else if (bcondition === 1) {
          return '已审核'
        } else {
          return '已驳回'
        }
      }
    },
    created() {
      this.initBackLog()
    }
  }
</script>

<style scoped>
  .el-select .el-input {
    width: 130px;
  }
</style>
