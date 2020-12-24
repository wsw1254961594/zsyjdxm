<template>
	<div>
		<p style="float: left;">
			
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
			
			<el-table-column label="编号" prop="myasset.myassets.aserial"></el-table-column>
			<el-table-column label="名称" prop="myasset.atname"></el-table-column>			
			<el-table-column label="领取人" prop="myemp.ename"></el-table-column>
			<el-table-column label="部门" prop="myemp.mydept.dname"></el-table-column>
			<el-table-column label="计算单位" prop="myasset.aunits"></el-table-column>
			<el-table-column label="领取日期" prop="pget"></el-table-column>
			<el-table-column label="价格" prop="myasset.price"></el-table-column>
			
			<el-table-column label="状态" prop="pstate"></el-table-column>
			<el-table-column label="备注" prop="premark"></el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button type="primary" v-on:click="readyUpdate(scope.row)">资产归还</el-button>
					
				</template>
			</el-table-column>
		</el-table>
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="current" :page-sizes="[1, 2, 3, 4]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
		</el-pagination>
		<el-dialog :title="deptisadd?'资产归还':'资产归还'" :visible.sync="deptdialog">
			<el-form :model="idept" :rules="deptrules" ref="deptrefs">
				
				<el-form-item label="归还" prop="pstate" label-width="100px">
					<el-input v-model="idept.pstate" class="inputs" />
				</el-form-item>
				<el-form-item label="归还日期" prop="pstorage" label-width="100px">
					<el-date-picker v-model="idept.pstorage" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="开始时间">
					</el-date-picker>
				</el-form-item>
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="cancel">取 消</el-button>
				<el-button type="primary" @click="ensure">确 定</el-button>
			</div>
		</el-dialog>
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
				pageSize: 1,
				current: 1,
				total: 0,
				//初始数据
				deptDatadg: [],
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
							this.$myhttp.updatePost("property/insert", param, (res) => {
								this.loadData();
								this.deptdialog = false;
							});
						} else {
							let param = { ...this.idept
							};
							console.log("修改--当前的参数为：", param);
							this.$myhttp.updatePost("property/update", param, (res) => {
								this.loadData();
								this.deptdialog = false;
							});
						}
					}
				})
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