<template>
		<div>
			 <el-tabs v-model="activeName" @tab-click="handleClick">
			    <el-tab-pane label="项目验收" name="first">
					<div style="width: 1200px; margin-top: 5px; margin-left: 40px;">
					<el-table :data="List">
					      <el-table-column label="项目名称" prop="pname"></el-table-column>
						  <el-table-column label="项目类型" prop="types"></el-table-column>
					      <el-table-column label="项目进度" prop="progress"></el-table-column>
						  <el-table-column label="项目状态" prop="status"></el-table-column>
					      <el-table-column label="计划开始日期" prop="planstartdate"></el-table-column>
					      <el-table-column label="计划结束日期" prop="planenddate"></el-table-column>
						  <el-table-column label="操作" >
						      <template slot-scope="s">
						  		<el-popover
						  		  placement="right"
						  		  trigger="click">
						  		  <el-button  @click="" >项目验收</el-button>
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
					</el-tab-pane>
			    <el-tab-pane label="项目验收单" name="second">
					<div style="width: 1200px; margin-top: 5px; margin-left: 40px;">
					<el-table :data="Lists">
					      <el-table-column label="验收项目名称" prop="pname"></el-table-column>
						  <el-table-column label="验收状态" prop="approvalstatus"></el-table-column>
						  <el-table-column label="操作" >
						      <template slot-scope="s">
						  		<el-popover
						  		  placement="right"
						  		  trigger="click">
						  		  <el-button  @click="" >删除</el-button>
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
					</el-tab-pane>
			  </el-tabs>
		</div>
</template>

<script>
	export default {
	    data() {
	      return {
	         List:[],
			 Lists:[],
	         current:1,
	         pageSize:5,
	         total:0,
			 activeName: 'first'
	      }
	    },
	    methods: {
	      loadData(){
	              let param={
	                no:this.current,
	                size:this.pageSize
	              };
	              let ppp = this.$Qs.stringify(param);
	              this.$axios.post("http://localhost:8888/Itemlist/Stageof",ppp)
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
				loadDatas(){
				        let param={
				          no:this.current,
				          size:this.pageSize
				        };
				        let ppp = this.$Qs.stringify(param);
				        this.$axios.post("http://localhost:8888/Acceptancesheet/page",ppp)
				        .then(r=>{
				          if(r.status===200){
				            this.Lists = r.data.list;
				            this.total = r.data.total;
				            console.log(this.List)
				          }
				        }).catch(e=>{
									  alert(e)
								  })
				      }
				,
	               handleCurrentChange(pagerindex){
	                    //参数是当前页码
	                    this.current = pagerindex; 
	                    this.loadData();
	                    this.loadDatas();
	                  },
	                  /* pageSize 改变时会触发*/
	               handleSizeChange(pagesize){
	                      this.pageSize=pagesize;
	                     this.loadData();
	                     this.loadDatas();
	                  }
	      },
	        mounted() {
	            this.loadData();
				this.loadDatas();
	          }
	  }
</script>

<style>
</style>
