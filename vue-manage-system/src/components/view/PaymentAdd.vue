<template>

    <div class="JobPost">
      <el-header style="border-bottom:1px solid #e6e6e6;padding-top: 10px;height: 80px;">
        <div class="juzhong">
			<br>
              <span class="L0">合同付款申请</span>
              <p>CONTRACT PAYMENT</p>
        </div>
      </el-header>

       <el-form ref="form" :model="payment"  label-width="80px" style="margin-top: 10px; width: 100%;border:1px solid #e6e6e6;background-color: #FFFFFF;margin-top: 20px;">
         <div style="margin-left: 30px;width: 1000px;">
           <el-form-item>
                 <div style="background-color: #EFEFEF;width: 100%;height: 30px;line-height: 30px;">
                   <span style="margin-left: 0px; font-weight: 800;">|&nbsp基础信息</span></div>
           </el-form-item>
		   <el-row>
			   <el-col :span="24">
				   <el-form-item label="标题" label-width="100px">				  
				     <el-input v-model="payment.pmname"></el-input>			    
				   </el-form-item>
				</el-col>
		   </el-row>
           
		   <el-row>
			   <el-col :span="11">
			   <el-form-item label="申请人" label-width="100px">			      
			      <el-input v-model="contract.myemp.ename"></el-input>			      
			    </el-form-item>
				</el-col>
				
				<el-col :span="11" style="margin-left: 80px;">			
			   <el-form-item label="申请部门" label-width="100px">			     
			      <el-input  v-model="contract.myemp.mydept.dname"></el-input>			    
			    </el-form-item>
				  </el-col>
		   </el-row>
		   		 
           
           <el-form-item>

           </el-form-item>
         </div>
       </el-form>
       <el-form ref="jobmsg"  label-width="80px"  style="width: 100%;border:1px solid #e6e6e6;background-color: #FFFFFF;margin-top: 20px;">
         <div style="margin-left: 30px;width: 1000px;">

           <el-form-item label="">
                 <div style="background-color: #EFEFEF;width: 100%;height: 30px;line-height: 30px;">
                   <span style="margin-left: 0px; font-weight: 800;">|&nbsp业务信息</span></div>
           </el-form-item>
          <el-form-item label="" >
                 <div style="background-color: #EFEFEF;width: 100%;height: 30px;" v-show="false">
                <el-input ></el-input>
                </div>
           </el-form-item>
	
				
			<el-row>
			   <el-col :span="11">
			   <el-form-item label="相关合同编号" label-width="100px">			      
				  <el-input v-model="contract.cnumber"></el-input>			      
				</el-form-item>
				</el-col>
				
				<el-col :span="11" style="margin-left: 80px;">			
			   <el-form-item label="供应商名称" label-width="100px">			     
				  <el-input v-model="contract.mysupplier.sname"></el-input>			    
				</el-form-item>
				  </el-col>
			</el-row>	
			
			<el-row>
						   <el-col :span="11">
						   <el-form-item label="合同金额" label-width="100px">			      
						      <el-input v-model="contract.cmoney"></el-input>			      
						    </el-form-item>
							</el-col>
							
							<el-col :span="11" style="margin-left: 80px;">			
						   <el-form-item label="未付款金额" label-width="100px">			     
						      <el-input v-model="wmoney"></el-input>			    
						    </el-form-item>
							  </el-col>
			</el-row>
			
			<el-row>
						   <el-col :span="11">
						   <el-form-item label="开户账号" label-width="100px">			      
						      <el-input v-model="contract.mysupplier.opening"></el-input>			      
						    </el-form-item>
							</el-col>
							
							<el-col :span="11" style="margin-left: 80px;">			
						   <el-form-item label="付款金额" label-width="100px">			     
						      <el-input v-model="pmmoney"></el-input>			    
						    </el-form-item>
							  </el-col>
			</el-row>
			    <el-form-item style="padding-bottom: 40px;">
			                <el-button type="primary" style="color: white;" @click="addPay()">付款</el-button>
			                 <router-link to="/job"><el-button >返回</el-button></router-link>
			              </el-form-item>
			           </div>
       </el-form>
	
    </div>
</template>

<script>
	var moment = require('moment');
  export default{
      data(){
        return {	
			/* 未付款金额 */
			wmoney:0,
			contract:{},
			payment:{
				pmname:''
			},
			/* 付款金额 */
			pmmoney:''
		}
        },methods:{	
			getPost(){
				this.contract=this.$route.query.params;
				this.payment.pmname="合同付款流程-"+this.$route.query.params.myemp.ename+"-"+new Date().getFullYear()+"-"+new Date().getMonth()+"-"+new Date().getDate();
				this.wmoney=this.$route.query.params.cmoney-this.$route.query.params.money;					
			},
			/*添加付款记录  */
			addPay(){
				this.payment.mycontract=this.contract
				this.payment.myemp=this.contract.myemp;
				this.payment.pmmoney=this.pmmoney;
				this.payment.pmpayee=this.contract.mysupplier.sname;
				let url="http://localhost:8888/payment/addpay";
				this.$axios.post(url,this.payment).then(r=>{
					this.$message.success("付款申请成功");
					this.$router.push({path:'/contractpayment'})
				}).catch(e=>{
					alert(e)
				});
				
			}
        }, created() {
			this.getPost();
          },
		 
		  
       }
</script>

<style scoped="scoped">
  *{
    margin: 0 auto;
    padding: 0;
    color: #585856;
  }

  .el-button{
    width: 70px;
    height: 38px;
  }

  .JobPost{
    width: 100%;
    height: 100%;
    background-color: #EFEFEF;
  }

  .L0{
      font-size: 30px;
      margin-top: 30px;
  }
  .juzhong{
    text-align: center;
	background: white;
	height: 100px;
	
  }

  .el-form-item{
    margin-top: 20px;
    }
</style>
