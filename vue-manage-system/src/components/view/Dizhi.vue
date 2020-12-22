<template>
	<div>
		<el-table :data="tableData.list" style="width: 100%" :default-sort="{prop: 'date', order: 'descending'}">
			<el-table-column prop="dzid" label="编号" sortable>
			</el-table-column>
			<el-table-column prop="leixingname" label="会议室" sortable>
			</el-table-column>
			<el-table-column prop="" label="状态" sortable>
				<template slot-scope="scope">
									
				<span v-if="scope.row.hyzt==0">
					空闲
				</span>
				<span v-if="scope.row.hyzt==1">
					已占用
				</span>
							
		
				</template>
			</el-table-column>
			</el-table-column>
		</el-table>

		<el-pagination background @size-change="handleSizeChange" :page-size="tableData.pageSize" @current-change="handleCurrentChange"
		 :current-page="tableData.PageNum" layout="prev, pager, next" :total="tableData.total">
		</el-pagination>
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
				
			}
		},
		methods: {
			formatter(row, column) {
				return row.address;
			},
			dizhi() {
			let url = "http://localhost:8888/huiyi/dizhi";
			this.$axios.get(url).then(r => {
				this.tableData = r.data
			}).catch(e => {
				alert(e)
			
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
			
		},
		
		created() {
			this.dizhi();
			
		}
	}
</script>

<style>
</style>
