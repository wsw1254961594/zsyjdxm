<template>
	<div>
		
		<div>
			  <el-button type="primary" @click="cc()" >召集会议</el-button>
			  <el-select v-model="cxdz" clearable placeholder="根据会议室查询" @change="duocx()">
			      <el-option
			        v-for="item in dz"
			       :key="item.dzid"
			       :label="item.leixingname"
			       :value="item.leixingname">
			      </el-option>
			    </el-select>
				<el-select v-model="cxdz1" clearable placeholder="根据名字查询" @change="duocx()">
				    <el-option
				      v-for="item in yg"
				      :key="item.empno"
				      :label="item.ename"
				      :value="item.ename">
				    </el-option>
				  </el-select>
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
									
				<span v-if="Date.parse(scope.row.kaishitimedate) < new Date() && Date.parse(scope.row.jieshutime) > new Date() && scope.row.mydizhi.hyzt==1 && scope.row.myshiyong.zt==1">
					已开始
				</span>
				<span v-if="Date.parse(scope.row.kaishitimedate) > new Date() && scope.row.mydizhi.hyzt==1 && scope.row.myshiyong.zt==1 || Date.parse(scope.row.kaishitimedate) > new Date() && scope.row.mydizhi.hyzt==0 && scope.row.myshiyong.zt==1">
					未开始
				</span>
				<span v-if=" Date.parse(scope.row.jieshutime) < new Date() && scope.row.mydizhi.hyzt==1 && scope.row.myshiyong.zt==0 ||  Date.parse(scope.row.jieshutime) < new Date() && scope.row.mydizhi.hyzt==0 && scope.row.myshiyong.zt==1 || 
				 Date.parse(scope.row.jieshutime) < new Date() && scope.row.mydizhi.hyzt==0 && scope.row.myshiyong.zt==0 ||  Date.parse(scope.row.jieshutime) < new Date() && scope.row.mydizhi.hyzt==1 && scope.row.myshiyong.zt==1">
					已结束
				</span>
				

				</template>
			</el-table-column>
			<el-table-column label="操作" prop="name" width="160px;">
				<template slot-scope="scope">
					
					<span v-if="Date.parse(scope.row.jieshutime) < new Date() && scope.row.mydizhi.hyzt==1 && scope.row.myshiyong.zt==1 ">
						<el-button size="mini" @click="jie(scope.row)">结束会议</el-button>
					</span>
					
				</template>
			
			</el-table-column>
			</el-table-column>
		</el-table>

		<el-pagination background @size-change="handleSizeChange" :page-size="tableData.pageSize" @current-change="handleCurrentChange"
		 :current-page="tableData.pageNum" layout="prev, pager, next" :total="tableData.total">
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
				cxdz:'',
				dz:[],
				yg:[],
				cxdz1:'',
			}
		},
		methods: {
			formatter(row, column) {
				return row.address;
			},
			dizhi() {
			let url = "http://localhost:8888/huiyi/xiangqing?pageSize=" + this.pageSize + "&pageNum=" + this.pageNum;
			this.$axios.get(url).then(r => {
				this.tableData = r.data
			}).catch(e => {
				alert(e)
			
			});

			},
			xiala(){
				this.$axios.post("http://localhost:8888/huiyi/xla").then(r => {
					this.dz = r.data;
					console.log("11" ,r)
				}).catch(e => {
				
				});
				this.$axios.post("http://localhost:8888/huiyi/yuangong").then(r => {
					this.yg = r.data;
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
			tt(time){
				time = moment(time).unix();
				       return time;
			},
			jie(row){
			
				this.dzid=row.mydizhi.dzid;
				this.$axios.post("http://localhost:8888/huiyi/jieshu?ids="+this.dzid)
						.then(r => {
						this.dizhi();
						}).catch(e => {
				
						});
						console.log("id",row.myshiyong.xqid)
						this.syid=row.myshiyong.xqid;
						this.$axios.post("http://localhost:8888/huiyi/xiugaishiyong?syid="+this.syid)
								.then(r => {
								this.dizhi();
								}).catch(e => {
						
								});
			},
			cc(r){
				this.$router.push({path:'/Tianjiahuiyi',query:{params:r}})
			},
			duocx(){
				console.log("cxdz",this.cxdz)
				this.dzid=this.cxdz;
				if(this.cxdz=="" & this.cxdz1==""){
				this.dizhi();
				}else{
				let url="http://localhost:8888/huiyi/mohuhy";
				let param={
				hyname:this.cxdz,
				empname:this.cxdz1,
				pageNo:this.pageNum,
				pageSize:this.pageSize
			}
			 param=this.$Qs.stringify(param);  
			 this.$axios.post(url,param).then(r=>{
				   this.tableData=r.data;
					 }).catch(e=>{
					  alert(e) 
				 });
								 
					}
				  },
		},
		
		created() {
			this.dizhi();
			this.xiala();
		}
	}
</script>

<style>
</style>
