<template>

	<div class="JobPost">
		<el-header style="border-bottom:1px solid #e6e6e6;padding-top: 10px;height: 80px;">
			<div class="juzhong">
				<br>
				<span class="L0">非生产性采购合同申请</span>
				<p>APPROVAL OF UNPRODUCTIVE PURCHASE CONTRACT FORM</p>
			</div>
		</el-header>

		<el-form ref="form" :model="contract" label-width="80px" style="margin-top: 10px; width: 100%;border:1px solid #e6e6e6;background-color: #FFFFFF;margin-top: 20px;">
			<div style="margin-left: 30px;width: 1000px;">
				<el-form-item>
					<div style="background-color: #EFEFEF;width: 100%;height: 30px;line-height: 30px;">
						<span style="margin-left: 0px; font-weight: 800;">|&nbsp合同信息</span></div>
				</el-form-item>
				<el-row>
					<el-col :span="24">
						<el-form-item label="编号" label-width="100px">
							<el-input v-model="contract.pserial"></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="11">
						<el-form-item label="名称" label-width="100px">
							<el-input v-model="contract.pname"></el-input>
						</el-form-item>
					</el-col>

					<el-col :span="11" style="margin-left: 80px;">
						<el-form-item label="状态" label-width="100px">
							<el-input v-model="contract.pstate"></el-input>
						</el-form-item>
					</el-col>
				</el-row>

			<!--	<el-row>
					<el-col :span="11">
						<el-form-item label="合同金额" label-width="100px">
							<el-input v-model="sumMoney"></el-input>
						</el-form-item>
					</el-col>

					<el-col :span="11" style="margin-left: 80px;" label-width="100px">
						<el-form-item label="经办人" label-width="100px">
							<el-input v-model="this.$store.state.ename"></el-input>
						</el-form-item>
					</el-col>
				</el-row>-->

				<el-row>
					<el-col :span="11">
						<el-form-item label="开始时间" label-width="100px">
							<el-date-picker v-model="contract.pstorage" type="date" placeholder="选择日期" style="width: 100%;">
							</el-date-picker>
						</el-form-item>
					</el-col>
						<el-col :span="11">
						<el-form-item label="领取日期" label-width="100px">
							<el-date-picker v-model="contract.pget" type="date" placeholder="选择日期" style="width: 100%;">
							</el-date-picker>
						</el-form-item>
					</el-col>
					<el-col :span="11" style="margin-left: 80px;" label-width="100px">
						<el-form-item label="数量" label-width="100px">
							<el-input v-model="contract.pquantity"></el-input>
						</el-form-item>
					</el-col>
				</el-row>

			

				<el-row>
					<el-col :span="11">
						<el-form-item label="单位" label-width="100px">
							<el-input v-model="contract.punits"></el-input>
						</el-form-item>
					</el-col>

					<el-col :span="11" style="margin-left: 80px;">
						<el-form-item label="价格" label-width="100px">
							<el-input v-model="contract.pvalue"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="11" style="margin-left: 80px;">
						<el-form-item label="备注" label-width="100px">
							<el-input v-model="contract.premark"></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<el-form-item>

				</el-form-item>
			</div>
		</el-form>
		<el-form ref="jobmsg" label-width="80px" style="width: 100%;border:1px solid #e6e6e6;background-color: #FFFFFF;margin-top: 20px;">
			<div style="margin-left: 30px;width: 1000px;">

				<el-form-item label="">
					<div style="background-color: #EFEFEF;width: 100%;height: 30px;line-height: 30px;">
						<span style="margin-left: 0px; font-weight: 800;">|&nbsp合同明细信息</span></div>
				</el-form-item>
				<el-form-item label="">
					<div style="background-color: #EFEFEF;width: 100%;height: 30px;" v-show="false">
						<el-input></el-input>
					</div>
				</el-form-item>
				<el-form-item>

					<el-button @click="addshow()">添加</el-button>
					<el-table :data="tableData" border style="width: 100%">
						<el-table-column label="序号" width="80">
							<template slot-scope="scope">
								{{scope.$index+1}}
							</template>
						</el-table-column>
						<el-table-column prop="atname" label="名称">
						</el-table-column>
						<el-table-column prop="atmodel" label="型号">
						</el-table-column>
						<el-table-column prop="aunits" label="单位">
						</el-table-column>
						<el-table-column prop="price" label="价格">
						</el-table-column>
						<el-table-column prop="num" label="数量">
						</el-table-column>
						<el-table-column label="合计">
							<template slot-scope="scope">
								{{scope.row.sum=scope.row.price*scope.row.num}}
							</template>
						</el-table-column>
					</el-table>
				</el-form-item>
				<el-row>
					<span style="float: right;font-size: 14px;">总计：
				<span style="color: #F02D2D;font-size: 16px;">￥{{sumMoney}}</span>
					</span>
				</el-row>
				<el-form-item style="padding-bottom: 40px;">
					<el-button type="primary" style="color: white;" @click="addContract()">发布</el-button>
					<router-link to="/job">
						<el-button>返回</el-button>
					</router-link>
				</el-form-item>
			</div>

		</el-form>

		<el-dialog title="产品信息" :visible.sync="dialogVisible" width="50%">
			<el-table :data="productcg" stripe>
				<el-table-column label="名称" prop="atname">
				</el-table-column>

				<el-table-column label="型号" prop="atmodel">
				</el-table-column>

				<el-table-column label="单位" prop="aunits">
				</el-table-column>

				<el-table-column label="数量">
					<template slot-scope="scope">
						<el-input v-model="scope.row.num"></el-input>
					</template>
				</el-table-column>

				<el-table-column label="价格" prop="price">
				</el-table-column>

				<el-table-column label="操作">
					<template slot-scope="scope">
						<el-button type="primary" plain @click="handleAdd(scope.row)">添加</el-button>
					</template>
				</el-table-column>
			</el-table>
			<span slot="footer" class="dialog-footer">
		    <el-button @click="dialogVisible = false">取 消</el-button>
		    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
	var moment = require('moment');
	export default {
		data() {
			return {

				dialogVisible: false,
				contract: {
					
					myemp: {

					},
					mysupplier: {},
					asser: []

				},
				tableData: [],
				productcg: [],
				options: [{
					value: 'A',
					label: 'A'
				}, {
					value: 'B',
					label: 'B'
				}, {
					value: 'C',
					label: 'C'
				}, {
					value: 'D',
					label: 'D'
				}, {
					value: 'E',
					label: 'E'
				}]
			}
		},
		methods: {
			//添加合同信息
			addContract() {
				this.contract.cmoney = this.sumMoney;
				this.contract.myemp.empno = this.$store.state.empno;
				this.tableData.forEach(i => {
					console.log("21", i)
					console.log("22", i.num);
					this.contract.asser.push({
						pnum: i.num,
						myproductcg: i
					})
				})

				let url = "http://localhost:8888/property/insert";
				this.$axios.post(url, this.contract).then(r => {
					alert("叼你妈的成功了");
				}).catch(e => {
					alert(e)
				})
			},

			//查询产品信息
			getPrlist() {
				let url = "http://localhost:8888/asset/all";
				this.$axios.get(url).then(r => {
					this.productcg = r.data;
				}).catch(e => {
					alert("出错了" + e)
				})
			},
			//打开产品列表
			addshow() {
				this.getPrlist();
				this.dialogVisible = true;
			},
			// 添加点击按钮
			handleAdd(r) {
				this.tableData.push(r);
				this.dialogVisible = false;
			},
			handleDelete(index) {
				this.tableData.splice(index, 1)

			},
			tt(time) {
				time = moment(time).unix();
				return time;
			},

		},
		created() {
			this.sumMoney()

		},
		computed: {
			sumMoney() {
				var summon = this.tableData.map(
					row => row.num * row.price).reduce(
					(acc, cur) => (parseFloat(cur) + acc), 0)
				this.contract.cmoney = summon;

				return summon;
			}
		}

	}
</script>

<style scoped="scoped">
	* {
		margin: 0 auto;
		padding: 0;
		color: #585856;
	}
	
	.el-button {
		width: 70px;
		height: 38px;
	}
	
	.JobPost {
		width: 100%;
		height: 100%;
		background-color: #EFEFEF;
	}
	
	.L0 {
		font-size: 30px;
		margin-top: 30px;
	}
	
	.juzhong {
		text-align: center;
		background: white;
		height: 100px;
	}
	
	.el-form-item {
		margin-top: 20px;
	}
</style>