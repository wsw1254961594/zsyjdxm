<template>
	<div>
		<div>
			  <el-button type="primary"  @click="d()">添加新会议室</el-button>
		</div>
		<el-table :data="tableData.list" style="width: 100%" :default-sort="{prop: 'date', order: 'descending'}">
			<el-table-column prop="dzid" label="编号" sortable>
			</el-table-column>
			<el-table-column prop="leixingname" label="会议室" sortable>
			</el-table-column>
			
			</el-table-column>
		</el-table>

		<el-pagination background @size-change="handleSizeChange" :page-size="tableData.pageSize" @current-change="handleCurrentChange"
		 :current-page="tableData.pageNum" layout="prev, pager, next" :total="tableData.total">
		</el-pagination>
		<div>
			
			<el-dialog title="添加" :visible.sync="dialogFormVisible">
			<el-form :model="row">

						 <div style="margin-top:10px">
						 	 </h1>新会议室名字</h1>
						 		<el-input
						 	placeholder="请输入内容"
							   v-model="row.leixingname"
						 	   >
							 </el-input>
						 </div>
						
			  </el-form>
						  
			  <div slot="footer" class="dialog-footer">
			    <el-button @click="dialogFormVisible = false">取 消</el-button>
			    <el-button type="primary" @click="dizhitj()">确 定</el-button>
			  </div>
					
			</el-dialog>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				pageNum: 1,
				pageSize: 5,
				total: 0,
				dialogFormVisible: false,
				row:{}
			}
		},
		methods: {
			formatter(row, column) {
				return row.address;
			},
			dizhi() {
			let url = "http://localhost:8888/huiyi/dizhi?pageSize=" + this.pageSize + "&pageNum=" + this.pageNum;
			this.$axios.get(url).then(r => {
				this.tableData = r.data
			}).catch(e => {
				alert(e)
			
			});

			},
			
			dizhitj(){
				this.dialogFormVisible = false;
				this.$axios.post("http://localhost:8888/huiyi/tj",this.row)
					.then(r => {
						this.dizhi()
						
					}).catch(e => {
				
					});
			},

			handleSizeChange(p) {
				console.log(p);
				this.pageSize = p;
				this.dizhi();
			},
			handleCurrentChange(p) {
				console.log(p);
				this.pageNum = p;
				this.dizhi();
			},
			d(r){
			
				this.dialogFormVisible = true;
				
			},
			
			
		},
		
		created() {
			this.dizhi();
			
		}
	}
</script>

<style>
</style>
