<template>
	<div>
		<p style="float: left;">
			<el-button type="primary" v-on:click="readyInsert">借用资产</el-button>
			<el-button type="primary" v-on:click="isAdquery=!isAdquery">高级查询</el-button>
		</p>
		<el-form :inline="true" class="demo-form-inline adquery" v-show="isAdquery">
			<el-form-item label="名称">
				<el-input v-model="pname" placeholder="名称" />
			</el-form-item>
			<el-form-item label="领取日期">
				<el-input v-model="pget" placeholder="领取日期" />
			</el-form-item>
			<el-form-item label="价格">
				<el-input v-model="pvalue" placeholder="价格" />
			</el-form-item>
			
			<el-form-item>
				<el-button type="primary" @click="selecstProperty">查询</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="deptDatadg" style="width: 100%">
			<el-table-column label="编号id" prop="cpid"></el-table-column>
			<el-table-column label="编号" prop="pserial"></el-table-column>
			<el-table-column label="名称" prop="pname"></el-table-column>			
			<el-table-column label="数量" prop="pquantity"></el-table-column>
			<el-table-column label="计算单位" prop="punits"></el-table-column>
			<el-table-column label="入库日期" prop="pstorage"></el-table-column>
			<el-table-column label="领取日期" prop="pget"></el-table-column>
			<el-table-column label="价格" prop="pvalue"></el-table-column>
			
			<el-table-column label="状态" prop="pstate"></el-table-column>
			<el-table-column label="备注" prop="premark"></el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button type="primary" v-on:click="readyUpdate(scope.row)">查看</el-button>
					
				</template>
			</el-table-column>
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
				deptDatadg: [],
				
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
				di_diTitle: '',
				pname: '',
				pget: '',
				pvalue: '',
				
				isPageAdquery: false, //是否是高级分页查询
				isCFquery: 0 //高级查询次数，大于1则是重复高级查询
			}
		},
		methods: {
			//currentPage 改变时会触发
			handleCurrentChange(current) {
				this.current = current;
				if(this.isPageAdquery)
					this.selecstProperty();
				else
					this.loadData();
			},
			//pageSize 改变时会触发
			handleSizeChange(pageSize) {
				this.pageSize = pageSize;
				if(this.isPageAdquery)
					this.selecstProperty();
				else
					this.loadData();
			},
			loadData() {
				let param = {
					pageNo: this.current,
					pageSize: this.pageSize,
					empno:this.$store.state.empno
				};
				myhttp.getObj("property/page", param, (res) => {
					console.log("查询我的资产：", res);
					this.deptDatadg = res.list;
					this.total = res.total;
					this.isSelectNotAdquery = true;
				})
				/*propertyHttp.list(this.current,this.pageSize).then(res =>{
					console.log(res)
				})*/
			},
			//高级查询
			selecstProperty() {
				//高级查询为true
				this.isPageAdquery = true;
				if(this.pname.length < 1 && this.pget.length < 1 && this.pvalue.length < 1) {
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
					if(this.pname.length > 0) param.pname = this.pname;
					if(this.pget.length > 0) param.pget = this.pget;
					if(this.pvalue.length > 0) param.pvalue = this.pvalue;
					myhttp.getObj("property/pages", param, (res) => {
						this.deptDatadg = res.list;
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