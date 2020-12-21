<template>
  <div class="empsstyle">
	<el-button type="primary" class="xinzeng" >新增入职员工</el-button>
    <el-table :data="emps" width="100%">
      <el-table-column label="员工编号" prop="empno"></el-table-column>
      <el-table-column label="员工姓名" prop="ename"></el-table-column>
      <el-table-column label="员工性别" prop="sex"></el-table-column>
      <el-table-column label="员工电话" prop="ephone"></el-table-column>
      <el-table-column label="所属部门" prop="mydept.deptno"></el-table-column>
     <!-- <el-table-column label="所属岗位" prop=""></el-table-column> -->
      <el-table-column label="入职时间" prop="ofday"></el-table-column>
    </el-table>

    <el-pagination
     @size-change="handleSizeChange"
     @current-change="handleCurrentChange"
     :current-page="current"
     :page-sizes="[1, 2, 3, 4]"
     :page-size="pageSize"
     layout="total, sizes, prev, pager, next, jumper"
     :total="total">
    </el-pagination>
	
	<el-dialog title="新增入职员工" :visible.sync="dialogFormVisible">
	  <el-form>
	    <el-form-item label="员工名称" :label-width="formLabelWidth">
	      <el-input autocomplete="off"></el-input>
	    </el-form-item>
	    <el-form-item label="员工性别" :label-width="formLabelWidth">
	        <el-input autocomplete="off"></el-input>
	    </el-form-item>
	   <el-form-item label="员工电话" :label-width="formLabelWidth">
	        <el-input autocomplete="off"></el-input>
	    </el-form-item>
		<el-form-item label="所属部门" :label-width="formLabelWidth">
		     <el-input autocomplete="off"></el-input>
		 </el-form-item>
		<el-form-item label="所属岗位" :label-width="formLabelWidth">
			  <el-input autocomplete="off"></el-input>
		</el-form-item>
		<el-form-item label="入职日期" :label-width="formLabelWidth">
			  <el-input autocomplete="off"></el-input>
		</el-form-item>
	
	  </el-form>
	  <div slot="footer" class="dialog-footer">
	    <el-button @click="dialogFormVisible = false" class="ttbut">取 消</el-button>
	    <el-button type="primary" @click="selectBymohu" class="ttbut">确 定</el-button>
	  </div>
	</el-dialog>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        emps:[],
        current:1,
        pageSize:3,
        total:0,
		dialogFormVisible:false
      }
    },
    methods:{
      /* 查询所有记录*/
        getList(){
          let param={
            no:this.current,
            size:this.pageSize
          };
          let ppp = this.$Qs.stringify(param);
         this.$axios.post("http://localhost:8888/emps/pages",ppp)
          .then(r=>{
            if(r.data.code){
              console.log(r.data);
              this.emps = r.data.obj.list;
              this.total = r.data.obj.total;
            }
          })
      },
      handleSizeChange(pagesize){
           this.pageSize=pagesize;
           this.getList();
       },
      handleCurrentChange(pagerindex){
        this.current = pagerindex;
        this.getList();
      }
     },
    created() {
      this.getList();
    }
  }
</script>

<style>
	.empsstyle .el-table .cell {
	    box-sizing: border-box;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: normal;
	    word-break: break-all;
	    line-height: 23px;
	    padding-right: 10px;
	    text-align: center;
	}
	.empsstyle .xinzeng{
		margin-bottom: 10px;
	}
</style>
