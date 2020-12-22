<template>
	<div>
		 <el-table
		    :data="tableData.list"
		    style="width: 100%">
		    <el-table-column type="expand">
		      <template slot-scope="props">
		        <el-form label-position="left" inline class="demo-table-expand">
		          <el-form-item label="开始时间">
		            <span>{{ props.row.kaishitimedate | dateFormat }}</span>
					
		          </el-form-item>
		          <el-form-item label="结束时间">
		            <span>{{ props.row.jieshutime | dateFormat}}
					
					</span>
					
		          </el-form-item>
		          <el-form-item label="会议任务">
		            <span>{{ props.row.neirong }}</span>
		          </el-form-item>
		         
		        </el-form>
		      </template>
		    </el-table-column>
		    <el-table-column
		      label="会议室"
		      prop="mydizhi.leixingname">
			 
		    </el-table-column>
		    <el-table-column
		      label="会议主题"
		      prop="hyrw">
		    </el-table-column>
		    <el-table-column
		      label="发布人"
		      prop="ese.ename">
		    </el-table-column>
			<el-table-column prop="" label="状态" sortable>
				<template slot-scope="scope">
									
				<span v-if="scope.row.myshiyong.zt==0">
					未开始
				</span>
				<span v-if="scope.row.myshiyong.zt==1">
					已结束
				</span>
				<span v-if="scope.row.myshiyong.zt==2">
					待审批
				</span>	
					
				</template>
			</el-table-column>
			<el-table-column
				  prop=""
				  label="操作"
				  show-overflow-tooltip>
			<template slot-scope="scope">
					
						<el-button
						  size="mini"
						  @click="d(scope.row)">查看人员</el-button>		
	
			</template>
				</el-table-column>
		  </el-table>
		  <el-pagination background @size-change="handleSizeChange" :page-size="tableData.pageSize" @current-change="handleCurrentChange"
		   :current-page="tableData.PageNum" layout="prev, pager, next" :total="tableData.total">
		  </el-pagination>
		  <div>
			  <el-dialog title="人员详情" :visible.sync="dialogFormVisible1">
			  	<el-table
			  	      :data="tableData1"
			  	      style="width: 100%">
			  	      <el-table-column
			  	        prop="empsss.ename"
			  	        label="姓名"
			  	        width="180">
			  	      </el-table-column>
			  	      <el-table-column
			  	        prop="empsss.mydept.dname"
			  	        label="部门"
			  	        width="180">
			  	      </el-table-column>
			  	      <el-table-column
			  	        prop="empsss.myjobmsg.jmname"
			  	        label="职位">
			  	      </el-table-column>
			  	    </el-table>
			  		
			  </el-dialog>
		  </div>
		  
	</div>
</template>

<script>
	  export default {
	    data() {
	      return {
	        tableData: [],
			 tableData1: [],
			pageNum: 1,
			pageSize: 5,
			total: 0,
			dialogFormVisible1: false,
			
	      }
	    },
		methods: {
			huiyi() {
			let url = "http://localhost:8888/huiyi/xiangqing";
			this.$axios.get(url).then(r => {
				this.tableData = r.data
			}).catch(e => {
				alert(e)
			
			});
			
			},
			handleSizeChange(p) {
				console.log(p);
				this.pageSize = p;
				this.huiyi();
			},
			handleCurrentChange(p) {
				console.log(p);
				this.pageNum = p;
			this.huiyi();
			},
			d(r){
				console.log(r);
				this.hydzid=r.hydzid;
				this.dialogFormVisible1 = true;
				this.$axios.post("http://localhost:8888/huiyi/yg?hydzid="+this.hydzid)
					.then(r => {
				this.tableData1=r.data
					}).catch(e => {
				
					});
			},
			
		},
		created() {
			this.huiyi();
			
		}
	  }
</script>

<style>
	.demo-table-expand {
	    font-size: 0;
	  }
	  .demo-table-expand label {
	    width: 90px;
	    color: #99a9bf;
	  }
	  .demo-table-expand .el-form-item {
	    margin-right: 0;
	    margin-bottom: 0;
	    width: 50%;
	  }
</style>
