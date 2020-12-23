<template>
	<div id="Big">
	<div id="right">
	    <div id="right_head">
	      <el-row>
	        <i class="el-icon-finished" style="font-size: 17px;margin-left: 10px;">&nbsp;我的合同</i>
	      </el-row>
	    </div>
		<div>
			 <el-tabs v-model="activeName" @tab-click="handleClick" stretch="true" >
			    <el-tab-pane label="采购类合同" name="second">
					<div id="rigth_select">
					    <el-row>
					      <el-col :span="4">
					        <el-input
					            placeholder="合同名称"
					            prefix-icon="el-icon-search"
								style="margin-left: 10px;"
								v-model="ctitle"
								@change="getCgByLike()"
					            clearable>
					        </el-input>
					      </el-col>
					      <el-col :span="0.5">1</el-col>
					      <el-col :span="4">
					        <el-input
					            placeholder="合同编号"
					             prefix-icon="el-icon-search"
								v-model="cnumber"
					            clearable
								@change="getCgByLike()">
					        </el-input>
					      </el-col>
					       <el-col :span="0.5"></el-col>
					      <el-col :span="4">
					         <el-select v-model="cstate"  clearable  placeholder="合同状态" @change="getCgByLike()">
					            <el-option
					              v-for="item in options"
					              :key="item.value"
					              :label="item.label"
					              :value="item.value"
								  style="margin-left: 20px;"
								>
					            </el-option>
					          </el-select>
					      </el-col>
				
					    </el-row>
						
						
						
						
						
					</div>
					<div id="right_body">
					  <div id="right_body_tj">
					    <el-row>
					      <el-col :span="6">
					        <div class="tj_div_one">
					            <br>
					            <span class="tj_span">合同总数</span><br/>
					            <span class="tj_sj">{{cgList.length}}</span>
					        </div>
					      </el-col>
					      <el-col :span="5">
					        <div class="tj_div_two">
					           <br>
					            <span class="tj_span">合同总金额</span><br/>
					            <span class="tj_sj">{{cgtotal}}</span>
					        </div>
					      </el-col>
						  <el-col :span="5">
						    <div class="tj_div_two">
						        <br>
						        <span class="tj_span">进行中合同金额</span><br/>
						        <span class="tj_sj">{{cgtotalnow}}</span>
						    </div>
						  </el-col>
						  <el-col :span="6">
						    <div class="tj_div_two">
						       <br>
						        <span class="tj_span">已完成合同金额</span><br/>
						        <span class="tj_sj">{{cgtotalend}}</span>
						    </div>
						  </el-col>
					    </el-row>
						
					  </div>
					  <div class="right_body_table">
					       <el-table
					         :data="cgList"
					         stripe
					         style="width: 102%">
					         <el-table-column
					         type="selection"
					           width="120">
					       
					         </el-table-column>
					         <el-table-column
					           prop="ctitle"
					           label="合同名称"
					           width="180">
					         </el-table-column>
					         <el-table-column
					           prop="cnumber"
					           label="合同编号"
					           width="200">
					         </el-table-column>
					         <el-table-column
					           prop="cbody"
					           label="签约公司"
							   width="180">
					         </el-table-column>
					        
					         <el-table-column
					           label="状态"
							   width="170">
					           <template slot-scope="scope">
					             <span v-if="scope.row.cstate==1"> <el-button type="primary" plain>进行中</el-button></span>
					             <span v-else-if="scope.row.cstate==2"> <el-button type="success" plain>已完成</el-button></span>
					            <span v-else-if="scope.row.cstate==3"> <el-button type="danger" plain>已解除</el-button></span>
					           </template>
					         </el-table-column>
							 
							 <el-table-column
							   label="付款进度"
							   width="260">
							   <template slot-scope="scope">
									<el-progress :percentage="Math.floor(scope.row.money/scope.row.cmoney*100)" style="width: 80%;float: left;"></el-progress>			
								</template>
							 </el-table-column>
							
					         <el-table-column
					           label="操作"
							   width="140">
					           <template slot-scope="scope">
					             <el-dropdown  style="float: left;margin-top: 5px;">
					                 <span class="el-dropdown-link">
					                   <i class="el-icon-s-operation" style="font-size: 20px;float: right;margin-right: 0px;"></i>
					                 </span>
					               <el-dropdown-menu slot="dropdown" style="font-size: 17px;margin-right: -70px;width: 100px;text-align: center;float: right;">
					                 	<el-dropdown-item @click.native="edit()"><i class="el-icon-info" style="color: #E6A23C;font-size: 13px;">查看合同</i></el-dropdown-item>
					                 	
										<span v-if="scope.row.cstate!=2">
											
											<span v-if="Math.floor(scope.row.money/scope.row.cmoney*100)==100">
											<el-dropdown-item @click.native="consucc(scope.row)"><i class="el-icon-check" style="color: #67C23A;font-size: 13px;">合同结项</i></el-dropdown-item>
											</span>
											<span v-else>
												<el-dropdown-item @click.native="condel(scope.row)"><i class="el-icon-close" style="color: #d93e34;font-size: 13px;">合同解除</i></el-dropdown-item>																						
											</span>
											
										</span>
											</el-dropdown-menu>
					               </el-dropdown>
					           </template>
					         </el-table-column>
					       </el-table>
						   <el-pagination
						     :total="total"
						     :current-page="current"
						     :page-size="size"
						     @current-change="handleCurrentChange"
						   ></el-pagination>
					   </div>
					</div>
				</el-tab-pane>
			 <!--   <el-tab-pane label="销售类合同" name="first">
					<div id="rigth_select">
					     <el-row>
					   					      <el-col :span="4">
					   					        <el-input
					   					            placeholder="岗位名称"
					   					            prefix-icon="el-icon-search"
					   								style="margin-left: 10px;"
					   					            clearable>
					   					        </el-input>
					   					      </el-col>
					   					      <el-col :span="0.5">&nbsp;</el-col>
					   					      <el-col :span="4">
					   					        <el-input
					   					            placeholder="职位名称"
					   					             prefix-icon="el-icon-search"
					   					        style="margin-left: 10px;"
					   					            clearable>
					   					        </el-input>
					   					      </el-col>
					   					       <el-col :span="0.5">&nbsp;</el-col>
					   					      <el-col :span="4">
					   					        <el-input
					   					            placeholder="部门名称"
					   					            prefix-icon="el-icon-search"
					   					         style="margin-left: 10px;"
					   					            clearable>
					   					        </el-input>
					   					      </el-col>
					   					       <el-col :span="0.5">&nbsp;</el-col>
					   					       <el-col :span="4">
					   					          <el-button type="primary" @click="getPostBy" icon="el-icon-search" style="margin-left: 10px;width: 70px;height: 31px; color: white;">搜索</el-button>
					   					       </el-col>
					   					    </el-row>
						
						
						
						
						
					</div>
					<div id="right_body">
					  <div id="right_body_tj">
							<el-row>
							  <el-col :span="6">
							    <div class="tj_div_one">
							        <br>
							        <span class="tj_span">岗位数量</span><br/>
							        <span class="tj_sj">1</span>
							    </div>
							  </el-col>
							  <el-col :span="5">
							    <div class="tj_div_two">
							       <br>
							        <span class="tj_span">岗位需求人数</span><br/>
							        <span class="tj_sj">2</span>
							    </div>
							  </el-col>
							  <el-col :span="5">
							    <div class="tj_div_two">
							        <br>
							        <span class="tj_span">岗位数量</span><br/>
							        <span class="tj_sj">1</span>
							    </div>
							  </el-col>
							  <el-col :span="6">
							    <div class="tj_div_two">
							       <br>
							        <span class="tj_span">岗位需求人数</span><br/>
							        <span class="tj_sj">2</span>
							    </div>
							  </el-col>
							</el-row>
					  </div>
					  <div class="right_body_table">
					       
					   </div>
					</div>
				</el-tab-pane> -->
			  
			  </el-tabs>
		</div>
	   
	</div>
	
	   
	</div>
</template>

<script>
	 export default {
	    data() {
	      return {
			  options: [{
			            value: '1',
			            label: '进行中'
			          }, {
			            value: '2',
			            label: '已完成'
			          }, {
			            value: '3',
			            label: '已解除'
			          }],
			cstate:'',
			  ctitle:'',
			cnumber:'',
			 current:0,
			 size:5,
			 total:0,
	        activeName: 'second',
			/* 采购合同总金额 */
			cgtotal:0,
			/* 采购合同进行中金额 */
			cgtotalnow:0,
			/* 采购合同已完成金额 */
			cgtotalend:0,
			/* 采购合同 */
			cgList:[],
			sum:0
	      };
	    },
	    methods: {		
	      handleClick(tab, event) {
	        console.log(tab, event);
	      },
		  /* 查询采购合同总金额*/
		  getCgTotal(){
			  let url="http://localhost:8888/contract/cgmoney";
			  let param={
				  empno:this.$store.state.empno
			  }
			  param = this.$Qs.stringify(param);
			  this.$axios.post(url,param).then(r=>{
				  this.cgtotal=r.data
			  }).catch(e=>{
				  alert("出错了"+e)
			  })
		  }, /* 查询采购合同总金额*/
		  getCgTotalNow(){
			  let url="http://localhost:8888/contract/cgmoneynow";
			  let param={
				  empno:this.$store.state.empno
			  }
			  param = this.$Qs.stringify(param);
			  this.$axios.post(url,param).then(r=>{
				  this.cgtotalnow=r.data
			  }).catch(e=>{
				  alert("出错了"+e)
			  })
		  }, /* 查询采购合同总金额*/
		  getCgTotalEnd(){
			  let url="http://localhost:8888/contract/cgmoneyend";
			  let param={
				  empno:this.$store.state.empno
			  }
			  param = this.$Qs.stringify(param);
			  this.$axios.post(url,param).then(r=>{
				  this.cgtotalend=r.data
			  }).catch(e=>{
				  alert("出错了"+e)
			  })
		  }, /* 查询我的所有采购合同*/
		  getCgAll(){
			  let url="http://localhost:8888/contract/cgall";
			  let param={
				  pageNo:this.current,
				  pageSize:this.size,
				  empno:this.$store.state.empno
			  }
			  param = this.$Qs.stringify(param);
			  this.$axios.post(url,param).then(r=>{
				  this.cgList=r.data.obj.list;
				  this.total=r.data.obj.total;
			  }).catch(e=>{
				  alert("出错了"+e)
			  })
		  }, /* 多条件查询采购合同*/
		  getCgByLike(){
			  if(this.ctitle==''&&this.cnumber==''&&this.cstate==''){
				  this.getCgAll();
			  }else{		 
				 let url="http://localhost:8888/contract/cgbylike";
				 let param={
				 				  ctitle:this.ctitle,
				 				  cnumber:this.cnumber,
				 				  cstate:this.cstate,
				 				  pageNo:this.current,
				 				  pageSize:this.size,
				 				  empno:this.$store.state.empno
				 }
				 param = this.$Qs.stringify(param);
				 this.$axios.post(url,param).then(r=>{
				 				  this.cgList=r.data.obj.list;
				 				  this.total=r.data.obj.total;
				 }).catch(e=>{
				 				  alert("出错了"+e)
				 }) 
			  }
			 
		  },/* 合同结项 */
		  consucc(r){
			  let url="http://localhost:8888/contract/consucc"
			  let param={
				  cid:r.cid
			  }
			  param = this.$Qs.stringify(param);
			  this.$axios.post(url,param).then(r=>{
			  		this.$message.success("合同结项成功");
			  		this.getCgAll();
					this.getCgTotalEnd();
			  }).catch(e=>{
			  	alert("出错了"+e)
			  }) 
		  },/* 合同解除 */
		  condel(r){
			  let url="http://localhost:8888/contract/condel"
			  let param={
				  cid:r.cid
			  }
			  param = this.$Qs.stringify(param);
			  this.$axios.post(url,param).then(r=>{
			  		this.$message.success("合同解除成功");
			  		this.getCgAll();
			  }).catch(e=>{
			  	alert("出错了"+e)
			  }) 
		  }
	    },
		created(){
			this.getCgTotal();
			this.getCgTotalNow();
			this.getCgTotalEnd();
			this.getCgAll();
		}
	  };
</script>

<style scoped>
	.el-tabs__nav {
	    white-space: nowrap;
	    position: relative;
	    transition: transform .3s;
	    float: left;
	    z-index: 2;
	    margin-left: 20px;
	}
	

	
	#Big{
	  width: 100%;
	  height: 97%;
	  background: #f3f4f7;
	  margin: 0 auto;
	  padding: 0;
	  color: #585856;
	}
	
	
	
	#right{
	  width: 100%;
	  height: 100%;
	  background: white;
	  float: left;
	}
	
	
	
	#right_head{
	  width: 100%;
	  height: 45px;
	  background: #f9f9f9;
	  border: 1px solid #eaeaea;
	  line-height: 45px;
	}
	
	
	
	#right_body{
	  height: 82%;
	  width: 100%;
	  margin-left: -10px;
	}
	
	#right_body_tj{
	  width: 110%;
	  height: 100px;
	  margin-left: -20px;
	  background: #efeff4;
	}
	
	#rigth_select{
	  border: 1px solid #eaeaea;
	  width: 100%;
	  height: 50px;
	  background: white;
	  line-height: 50px;
	
	}
	
	.tj_div_one{
	  margin-top: 10px;
	  width:94%;
	  height: 80px;
	  background: white;
	  padding-left: 10px;
	  margin-left: 30px;
	}
	
	
	.tj_div_two{
	  margin-top: 10px;
	  width:94%;
	  height: 80px;
	  background: white;
	  padding-left: 10px;
		margin-left: 30px;
	}
	
	
	.tj_span{
	  margin-left: 30px;
	}
	
	.tj_sj{
	  margin-left: 30px;
	  font-size: 20px;
	}
	
	 .el-dropdown-link {
	    cursor: pointer;
	    color: #409EFF;
	  }
	  .el-icon-arrow-down {
	    font-size: 12px;
	  }
</style>
