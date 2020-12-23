<template>
	<div class="pregularstyle">
		<el-table :data="empspregular" width="100%">
		  <el-table-column label="员工编号" prop="empno"></el-table-column>
		  <el-table-column label="员工姓名" prop="ename"></el-table-column>
		  <el-table-column label="员工性别" prop="sex"></el-table-column>
		  <el-table-column label="员工电话" prop="ephone"></el-table-column>
		 <el-table-column label="员工状态">
		 		  <template slot-scope="x">
		 			  {{x.state}}
		 			  <span v-if="x.row.state==1">试用期员工</span>
		 			  <span v-else-if="x.row.state==2">正式员工</span>
		 		  </template>
		 </el-table-column>
		  <el-table-column label="所属部门" prop="mydept.dname"></el-table-column>
		  <el-table-column label="所属岗位" prop="myjobmsg.jmname"></el-table-column>
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
	</div>
</template>

<script>
	export default {
	  data(){
	    return{
	      empspregular:[],
	      current:1,
	      pageSize:3,
	      total:0
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
	       this.$axios.post("http://localhost:8888/emps/Bystate",ppp)
	        .then(r=>{
	          if(r.data.code){
	            console.log(r.data);
	            this.empspregular = r.data.obj.list;
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
</style>
