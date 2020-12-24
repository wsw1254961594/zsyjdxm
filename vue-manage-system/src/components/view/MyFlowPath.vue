<!--
@author: pengjia
@date: 2020/12/24
@description:
-->
<template>
  <div>
    <el-card>
      <el-table :data="tableDate" v-loading="tableLoading">
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
    name: "MyFlowPath",
    data() {
      return {
        tableDate:[],
        total:0,
        pageNum:1,
        pageSize:10,
        tableLoading:false,
        reqEmp:this.$store.state.empno
      }
    },
    methods:{
      bconditionFormat(bcondition) {
        if (bcondition === 0) {
          return '未处理'
        } else if (bcondition === 1) {
          return '已审核'
        } else {
          return '已驳回'
        }
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
      handleCurrentChange(pageIndex) {
        this.pageNum = pageIndex
        backLogHttp.listMineFlow(this.reqEmp,this.pageNum).then(res => {
          this.tableLoading = true
          if (res.code === 1) {
            this.$message.success("成功")
            this.tableDate = res.obj.list
            this.pageNum = res.obj.pageNum
            this.total = res.obj.total
            this.tableLoading = false
          } else {
            this.tableLoading = false
            this.$message.error("错误")
          }
        })
      },
      initList() {
        backLogHttp.listMineFlow(this.reqEmp,this.pageNum).then(res => {
          this.tableLoading = true
          if (res.code === 1) {
            this.$message.success("成功")
            this.tableDate = res.obj.list
            this.pageNum = res.obj.pageNum
            this.total = res.obj.total
            this.tableLoading = false
          } else {
            this.tableLoading = false
            this.$message.error("错误")
          }
        })
      }
    },
    created() {
      this.initList()
    }
  }
</script>

<style scoped>

</style>
