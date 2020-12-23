<template>
	<div>
		
		<div>
			  <el-button type="primary" @click="cc()" >召集会议</el-button>
		</div>
		<el-table :data="tableData.list" style="width: 100%" :default-sort="{prop: 'date', order: 'descending'}">
			<el-table-column prop="hyrw" label="会议标题" sortable>
			</el-table-column>
			<el-table-column prop="mydizhi.leixingname" label="会议室" sortable>
				
			</el-table-column>
			<el-table-column prop="kaishitimedate" label="开始时间" sortable>
			<template slot-scope="scope">
			{{ scope.row.kaishitimedate | dateFormat }}
			</template>
			</el-table-column>
			<el-table-column prop="jieshutime" label="结束时间" sortable>
				<template slot-scope="scope">
				{{ scope.row.jieshutime | dateFormat }}
				</template>
			</el-table-column>
			<el-table-column prop="ese.ename" label="负责人" sortable>
			</el-table-column>
			<el-table-column prop="" label="状态" sortable>
				<template slot-scope="scope">
									
				<span v-if="tt(scope.row.kaishitimedate)>tt(new Date()) && tt(scope.row.jieshutime)<tt(new Date()) && scope.row.myshiyong.zt==1">
					已开始
				</span>
				<span v-if="tt(scope.row.kaishitimedate)<tt(new Date()) && tt(scope.row.jieshutime)>tt(new Date()) && scope.row.myshiyong.zt==1">
					未开始
				</span>
				<span v-if="tt(scope.row.jieshutime)<tt(new Date()) && scope.row.myshiyong.zt==1">
					已结束
				</span>
				<span v-if="scope.row.myshiyong.zt==2">
					待审批
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
	var moment = require('moment');
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
				this.dizhi();
			},
			handleCurrentChange(p) {
				console.log(p);
				this.pageNum = p;
				this.dizhi();
			},
			tt(time){
				time = moment(time).unix();
				       return time;
			},
			cc(r){
				this.$router.push({path:'/Tianjiahuiyi',query:{params:r}})
			},
		},
		
		created() {
			
			this.dizhi();
			
		}
	}
</script>

<style>
</style>
