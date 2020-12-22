<template>
	<div>
		<div style="width: 1100px; margin-top: 35px; margin-left: 100px;">
		<el-table :data="List">
		      <el-table-column label="项目名称" prop="pname"></el-table-column>
		      <el-table-column label="项目进度" prop="progress"></el-table-column>
		      <el-table-column label="计划开始日期" prop="planstartdate"></el-table-column>
		      <el-table-column label="计划结束日期" prop="planenddate"></el-table-column>
		</el-table>
		    <!-- current-page	当前页数，支持 .sync 修饰符-->
		    <el-pagination
			style="margin-left: 650px;"
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
	              })
	            },
	                  handleCurrentChange(pagerindex){
	                    //参数是当前页码
	                    this.current = pagerindex;
	                    this.loadData();
	                  },
	                  /* pageSize 改变时会触发*/
	                  handleSizeChange(pagesize){
	                      this.pageSize=pagesize;
	                      this.loadData();
	                  }
	      },
	        mounted() {
	            this.loadData();
	          }
	  }
</script>

<style>
</style>
