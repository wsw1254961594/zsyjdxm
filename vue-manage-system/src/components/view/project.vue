<template>
	<div>
		<div >
			<el-button style=" margin-left: 40px;"
			 type="primary" @click="loadData()" >返回</el-button>
		  <el-input style="width: 500px;  margin-left: 700px;"
		   placeholder="请输入要查找的项目" v-model="input" class="">
		    <el-select style="width: 100px;"  v-model="select" slot="prepend" placeholder="请选择">
		      <el-option label="名称" value="1"></el-option>
		      <el-option label="类型" value="2"></el-option>
		      <el-option label="状态" value="3"></el-option>
		    </el-select>
		    <el-button slot="append" icon="el-icon-search" @click="open"></el-button>
		  </el-input>
		</div>
		<div style="width: 1200px; margin-top: 5px; margin-left: 40px;">
		<el-table :data="List">
		      <el-table-column label="项目名称" prop="pname"></el-table-column>
			  <el-table-column label="项目类型" prop="types"></el-table-column>
		      <el-table-column label="项目进度" prop="progress"></el-table-column>
			  <el-table-column label="项目状态" prop="status"></el-table-column>
		      <el-table-column label="计划开始日期" prop="planstartdate"></el-table-column>
		      <el-table-column label="计划结束日期" prop="planenddate"></el-table-column>
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
	              this.$axios.post("http://localhost:8888/Itemlist/page",ppp)
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
							  pname:this.input
					        };
					        let ppp = this.$Qs.stringify(param);
					          this.$axios.post("http://localhost:8888/Itemlist/Pname",ppp)
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
					         types:this.input
					       };
					        let ppp = this.$Qs.stringify(param);
					          this.$axios.post("http://localhost:8888/Itemlist/Types",ppp)
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
					         status:this.input
					       };
					        let ppp = this.$Qs.stringify(param);
					          this.$axios.post("http://localhost:8888/Itemlist/Status",ppp)
					          .then(r=>{
					            if(r.status===200){
					              this.List = r.data.list;
					              this.total = r.data.total;
					            }
					          })
					      }
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
