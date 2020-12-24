<template>
	<div>
		<p style="float: left;">
			
			<el-button type="primary" v-on:click="isAdquery=!isAdquery">高级查询</el-button>
		</p>
		<el-form :inline="true" class="demo-form-inline adquery" v-show="isAdquery">
			<el-form-item label="名称">
				<el-input v-model="atname" placeholder="名称" />
			</el-form-item>
			<el-form-item label="型号">
				<el-input v-model="atmodel" placeholder="型号" />
			</el-form-item>
			<el-form-item label="价格">
				<el-input v-model="aunits" placeholder="价格" />
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="selectsAsset">查询</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="deptData" style="width: 100%">
			<el-table-column label="编号id" prop="atid"></el-table-column>
			<el-table-column label="名称" prop="atname" ></el-table-column>
			<el-table-column label="型号" prop="atmodel"></el-table-column>
			<el-table-column label="数量" prop="atnum"></el-table-column>
			<el-table-column label="状态" prop="atstate"></el-table-column>
			<el-table-column label="计算单位" prop="aunits"></el-table-column>
			<el-table-column label="入库日期" prop="astorage"></el-table-column>
			<el-table-column label="价格" prop="price"></el-table-column>
			<el-table-column label="编号" prop="myassets.aserial"></el-table-column>
			
			
		</el-table>
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="current" :page-sizes="[1, 2, 3, 4]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
		</el-pagination>

		
	</div>

</template>
<script>
	/*单独引用http.js封装类*/
	import http from '../../api/http.js';
	import myhttp from '../../api/myhttp.js';
	export default {
		data() {
			return {
				//分页
				pageSize: 3,
				current: 1,
				total: 0,
				//初始数据
				deptData: [],
				deptdialog: false,
				deptisadd: false,
				idept: {},
				deptrules: {
					exDate: [{
						required: true,
						message: "请选择日期！",
						trigger: "blur"
					}],
					exOpinion: [{
						required: true,
						message: "审批意见！",
						trigger: "blur"
					}],
					exResult: [{
						required: true,
						message: "审批结果！",
						trigger: "blur"
					}]
				},
				startdept: '',
				enddept: '',

				//高级查询
				isAdquery: false,
				atname: '',
				atmodel: '',
				aunits: '',

				isPageAdquery: false, //是否是高级分页查询
				isCFquery: 0 //高级查询次数，大于1则是重复高级查询
			}
		},
		methods: {
			//currentPage 改变时会触发
			handleCurrentChange(current) {
				this.current = current;
				if(this.isPageAdquery)
					this.selectsAsset();
				else
					this.loadData();
			},
			//pageSize 改变时会触发
			handleSizeChange(pageSize) {
				this.pageSize = pageSize;
				if(this.isPageAdquery)
					this.selectsAsset();
				else
					this.loadData();
			},
			loadData() {
				let param = {
					pageNo: this.current,
					pageSize: this.pageSize
				};
				myhttp.getObj("asset/page", param, (res) => {
					console.log("查询的所有部门：", res);
					this.deptData = res.list;
					this.total = res.total;
					this.isSelectNotAdquery = true;
				})
			},
			readyInsert() {
				this.deptisadd = true;
				this.deptdialog = true;
				this.idept = {};
			},
			readyUpdate(row) {
				console.log("即将操作的行数据：", row);
				this.idept = { ...row
				};
				this.deptdialog = true;
				this.deptisadd = false;
				this.startdept = this.idept.dName;
			},

			//取消
			cancel() {
				this.deptdialog = false;
				this.idept = {};
			},
			//确定
			ensure() {
				this.$refs['deptrefs'].validate(v => {
					if(v) {
						if(this.deptisadd) {
							let param = { ...this.idept
							};
							console.log("新建--参数：", param);
							myhttp.updatePost("property/insert", param, (res) => {
								this.loadData();
								this.deptdialog = false;
							});
						} else {
							let param = { ...this.idept
							};
							console.log("修改--当前的参数为：", param);
							this.$myhttp.updatePost("formalapply/update", param, (res) => {
								this.loadData();
								this.deptdialog = false;
							});
						}
					}
				})
			},
			//高级查询
			selectsAsset() {
				//高级查询为true
				this.isPageAdquery = true;
				if(this.atname.length < 1 && this.atmodel.length < 1 && this.aunits.length < 1) {
					this.$message({
						message: "至少输入一个条件进行查询！",
						type: 'warning'
					});
					this.current = 1;
					this.isCFquery = 0;
					this.isPageAdquery = false;
					this.loadData();
				} else {
					this.isCFquery++;
					this.current = (this.isCFquery > 1) ? this.current : 1;
					let param = {
						pageNo: this.current,
						pageSize: this.pageSize
					};
					if(this.atname.length > 0) param.atname = this.atname;
					if(this.atmodel.length > 0) param.atmodel = this.atmodel;
					if(this.aunits.length > 0) param.aunits = this.aunits;
					myhttp.getObj("asset/pages", param, (res) => {
						this.deptData = res.list;
						this.total = res.total;
					})
				}
			}
		},
		created() {
			this.loadData();
		}
	}
</script>

<style scoped>
	.inputs {
		width: 60% !important;
	}
	
	.adquery {
		background: #FFFFFF;
		width: 100%;
		margin-top: 20px;
		overflow: hidden;
	}
</style>