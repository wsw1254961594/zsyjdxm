<template>
	<div>
		<div >
			<el-button style=" margin-left: 40px;"
			 type="primary" @click="loadData()" >返回</el-button>
		  <el-input style="width: 500px;  margin-left: 700px;"
		   placeholder="请输入要查找的任务" v-model="input" class="">
		    <el-select style="width: 100px;"  v-model="select" slot="prepend" placeholder="请选择">
		      <el-option label="名称" value="1"></el-option>
		      <el-option label="阶段" value="2"></el-option>
		      <el-option label="所属项目" value="3"></el-option>
		    </el-select>
		    <el-button slot="append" icon="el-icon-search" @click="open"></el-button>
		  </el-input>
		</div>
		<div style="width: 1200px; margin-top: 5px; margin-left: 40px;">
		<el-table :data="List">
		      <el-table-column label="任务名称" prop="mname"></el-table-column>
			  <el-table-column label="所属项目" prop="myitemlist.pname"></el-table-column>
			  <el-table-column label="阶段" prop="stage"></el-table-column>
		      <el-table-column label="计划开始日期" prop="startingtime"></el-table-column>
		      <el-table-column label="计划结束日期" prop="endtime"></el-table-column>
			  <el-table-column label="操作" >
			    <template slot-scope="s">
					<el-popover
					  placement="right"
					  trigger="click">
					  <el-button  @click="sc(s.row)" >删除</el-button>
					  <el-button slot="reference">...</el-button>
					</el-popover>
				</template>
			</el-table-column>
		</el-table>
		    <!-- current-page	当前页数，支持 .sync 修饰符-->
		    <el-pagination
			style="margin-left: 720px;"
		          @size-change="handleSizeChange"
		          @current-change="handleCurrentChange"
		          :current-page="current"
		          :page-sizes="[5, 10, 20, 40]"
		          :page-size="pageSize"
		          layout="total, sizes, prev, pager, next, jumper"
		          :total="total">
		        </el-pagination>
		  </div>
	</div>
</template>

<script>
	export default {
	    data() {
	      return {
			 input: '',
			 select: '',
	         List:[],
	         current:1,
	         pageSize:5,
	         total:0
	      }
	    },
	    methods: {
	      loadData(){
	              let param={
	                no:this.current,
	                size:this.pageSize
	              };
	              let ppp = this.$Qs.stringify(param);
	              this.$axios.post("http://localhost:8888/Tasklist/page",ppp)
	              .then(r=>{
	                if(r.status===200){
	                  this.List = r.data.list;
	                  this.total = r.data.total;
	                  console.log(this.List)
	                }
	              }).catch(e=>{
					  alert(e)
				  })
	            },
		  open() {  
			  if(this.select=='1'){
			     let param={
			       no:this.current,
			       size:this.pageSize,
				   mname:this.input
			     };
			     let ppp = this.$Qs.stringify(param);
			       this.$axios.post("http://localhost:8888/Tasklist/Mname",ppp)
			       .then(r=>{
			         if(r.status===200){
			           this.List = r.data.list;
			           this.total = r.data.total;
			         }
			       })
			   }
			   if(this.select=='2'){
			    let param={
			      no:this.current,
			      size:this.pageSize,
			      stage:this.input
			    };
			     let ppp = this.$Qs.stringify(param);
			       this.$axios.post("http://localhost:8888/Tasklist/Stage",ppp)
			       .then(r=>{
			         if(r.status===200){
			           this.List = r.data.list;
			           this.total = r.data.total;
			         }
			       })
			   }
			   if(this.select=='3'){
			    let param={
			      no:this.current,
			      size:this.pageSize,
			      pname:this.input
			    };
			     let ppp = this.$Qs.stringify(param);
			       this.$axios.post("http://localhost:8888/Tasklist/Pname",ppp)
			       .then(r=>{
			         if(r.status===200){
			           this.List = r.data.list;
			           this.total = r.data.total;
			         }
			       })
			   }
		  },
		  sc(row) {
		  		 let param={
		  			   iid:row.tid
		  			 };
		  		 let ppp = this.$Qs.stringify(param);
		  		 this.$axios.post("http://localhost:8888/Tasklist/doDelete",ppp)
		  				.then(r=>{
		  					if(r.status===200){
		  						 this.loadData();
		  						 this.$message("删除成功")
		  					 }
		  			 })
		  },
	               handleCurrentChange(pagerindex){
	                    //参数是当前页码
	                    this.current = pagerindex;
	                    if(this.select==''){
	                    this.loadData();
	                    }else{
	                      this.open();
	                    }
	                  },
	                  /* pageSize 改变时会触发*/
	               handleSizeChange(pagesize){
	                      this.pageSize=pagesize;
	                     if(this.select==''){
	                     this.loadData();
	                     }else{
	                       this.open();
	                     }
	                  }
	      },
	        mounted() {
	            this.loadData();
	          }
	  }
</script>

<style>
</style>
