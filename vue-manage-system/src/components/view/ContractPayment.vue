<template>
	<div id="Big">
	<div id="right">
	    <div id="right_head">
	      <el-row>
	        <i class="el-icon-finished" style="font-size: 17px;margin-left: 10px;">&nbsp;付款管理</i>
	      </el-row>
	    </div>
		<div>
			 <el-tabs v-model="activeName" @tab-click="handleClick" stretch="true">
			    <el-tab-pane label="合同付款" name="second">
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
					      <!-- <el-col :span="0.5"></el-col>
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
					      </el-col> -->
				
					    </el-row>
						
						
						
						
						
					</div>
					<div id="right_body">				
					  <div class="right_body_table">
					       <el-table
					         :data="cgList"
					         stripe
					         style="width: 102%">
					         <el-table-column
					         type="selection"
					           width="60">
					       
					         </el-table-column>
					         <el-table-column
					           prop="ctitle"
					           label="合同名称"
					           >
					         </el-table-column>
					         <el-table-column
					           prop="cnumber"
					           label="合同编号"
					          >
					         </el-table-column>
					         <el-table-column
					           prop="mysupplier.sname"
					           label="供应商名称"
							  >
					         </el-table-column>
					        
					         <el-table-column
								prop="cmoney"
					           label="合同金额"
							  >					        
					         </el-table-column>
							 
							 <el-table-column						
							   label="已付金额"
							  >		
									<template slot-scope="scope">
										<span v-if="scope.row.money==null"> 
											0
										</span>
										<span v-else>
											{{scope.row.money}}
										</span>
									</template>			  
							 </el-table-column>
							 
							 <el-table-column							 
							   label="未付金额"
							  >			
								<template slot-scope="scope">
									{{scope.row.cmoney-scope.row.money}}
								</template>
							 </el-table-column>
							 
							 <el-table-column
							   label="付款进度"
							   width="230">
							   <template slot-scope="scope">								 
									<el-progress :percentage="Math.floor(scope.row.money/scope.row.cmoney*100)" style="width: 80%;float: left;"></el-progress>			
								</template>
							 </el-table-column>
							 
							 <el-table-column
							   label="状态"
							  >
							   <template slot-scope="scope">	
								<span v-if="scope.row.cstate==1"> <el-button type="primary" plain>进行中</el-button></span>
								  <span v-else-if="scope.row.cstate==2"> <el-button type="success" plain>已完成</el-button></span>
								 <span v-else-if="scope.row.cstate==3"> <el-button type="danger" plain>已解除</el-button></span>															
								</template>
							 </el-table-column>
							
					         <el-table-column
					           label="操作"
							   >
					           <template slot-scope="scope">
								   <span v-if="scope.row.cstate==1">
									   <span v-if="scope.row.cmoney-scope.row.money>0">
									   <el-button type="primary" plain @click="paymentPost(scope.row)">发起付款</el-button>
									   </span>
								   </span>
								   <span v-if="scope.row.cstate==3">
									   <el-button type="warning" plain @click="paymentPost(scope.row)">请求回款</el-button>								   
								   </span>
								  
								  
									
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
				
				
			    <el-tab-pane label="付款记录" name="first">
					<div id="rigth_select">
					     <el-row>
					   					      <el-col :span="4">
					   					        <el-input
					   					            placeholder="合同名称"
					   					            prefix-icon="el-icon-search"
					   								style="margin-left: 10px;"
					   					            clearable>
					   					        </el-input>
					   					      </el-col>
					   					      <el-col :span="0.5">&nbsp;</el-col>
					   					      <el-col :span="4">
					   					        <el-input
					   					            placeholder="合同编号"
					   					             prefix-icon="el-icon-search"
					   					        style="margin-left: 10px;"
					   					            clearable>
					   					        </el-input>
					   					      </el-col>
					   					     
					   					    </el-row>
						
						
						
						
						
					</div>
					<div id="right_body">
					  <div id="right_body_tj">
							<el-row>
							  <el-col :span="12">
							    <div class="tj_div_one">
							        <br>
							        <span class="tj_span">应付款金额</span><br/>							       
									<span class="tj_sj">
										<span v-if="cgtotal==''"> 
											0
										</span>
										<span v-else>
											{{cgtotal}}
										</span>
									
									</span>
							    </div>
							  </el-col>
							  <el-col :span="12">
							    <div class="tj_div_two">
							       <br>
							        <span class="tj_span">实际付款金额</span><br/>
							        
									<span class="tj_sj">
										<span v-if="calnum==''"> 
											0
										</span>
										<span v-else>
											{{calnum}}
										</span>
									
									</span>
							    </div>
							  </el-col>
							 
							</el-row>
					  </div>
					  <div class="right_body_table">
					       <el-table
					         :data="payments"
					         stripe
					         style="width: 102%">
					         <el-table-column
					         type="selection"
					           width="60">
					       
					         </el-table-column>
					         <el-table-column
					           prop="mycontract.ctitle"
					           label="合同名称"
					           >
					         </el-table-column>
					         <el-table-column
					           prop="pmdate"
					           label="付款时间"
					          >
					         </el-table-column>
					         <el-table-column
					           prop="pmmoney"
					           label="支付金额"
							  >
					         </el-table-column>
					        
					         <el-table-column
								prop="pmpayee"
					           label="收款单位"
								  >					        
					         </el-table-column>
					       							 
							 <el-table-column
								prop="mycontract.cnumber"
							   label="合同编号"
							  >					        
							 </el-table-column>
							 
							 <el-table-column
								prop="pmname"
							   label="付款流程"
							   width="240px"
							  >					        
							 </el-table-column>
							 
							 <
					         <el-table-column
					           label="操作"
					       							   >
					           <template slot-scope="scope">
						  
						  
						 
					       									
					           </template>
					         </el-table-column>
					       </el-table>
					       <el-pagination
					         :total="total2"
					         :current-page="current2"
					         :page-size="size2"
					         @current-change="handleCurrentChange"
					       ></el-pagination>
					   </div>
					</div>
				</el-tab-pane>
			  
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
			/* 应付款总金额 */
			cgtotal:0,
			/* 采实际付款金额 */
			calnum:0,			
			/* 采购合同 */
			cgList:[],
			sum:0,
			payments:[],
			current2:0,
			size2:5,
			total2:0,
	      };
	    },
	    methods: {		
			//跳转页面
			handleCurrentChange(c){
			  this.current = c;
			  this.getCgAll();
			},
			//跳转页面
			handleCurrentChange2(c){
			  this.current2 = c;
			  this.getPayall();
			},
			
			/* 付款 */
			paymentPost(r){
				 this.$router.push({path:'/paymentpost',query:{params:r}})
			},
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
		  }, /* 实际付款金额*/
		  getCalNum(){
			  let url="http://localhost:8888/payment/calnum";				
			  this.$axios.post(url).then(r=>{
				  this.calnum=r.data
			  }).catch(e=>{
				  alert("出错了"+e)
			  })
		  
		  }
		  ,/* 查询所有付款信息*/
		  getPayall(){
		  			  let url="http://localhost:8888/payment/all";
		  			  let param={
		  				  pageNo:this.current,
		  				  pageSize:this.size		  				
		  			  }
		  			  param = this.$Qs.stringify(param);
		  			  this.$axios.post(url,param).then(r=>{
		  				  this.payments=r.data.obj.list;
		  				  this.total2=r.data.obj.total;
		  			  }).catch(e=>{
		  				  alert("出错了"+e)
		  			  })
		  },
		  /* 查询我的所有采购合同*/
		  getCgAll(){
			  let url="http://localhost:8888/contract/cgall";
			  let param={
				  pageNo:this.current2,
				  pageSize:this.size2,
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
			 
		  }
	    },
		created(){
			this.getCgTotal();
			this.getCalNum();
			this.getCgAll();
			this.getPayall();
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
		margin-left: 10px;
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
