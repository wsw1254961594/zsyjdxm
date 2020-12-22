<template>

    <div class="JobPost">
      <el-header style="border-bottom:1px solid #e6e6e6;padding-top: 10px;height: 80px;">
        <div class="juzhong">
			<br>
              <span class="L0">召集会议</span>
            <p>APPROVAL OF UNPRODUCTIVE PURCHASE CONTRACT FORM</p>
        </div>
      </el-header>

       <el-form ref="form" :model="contract"  label-width="80px" style="margin-top: 10px; width: 100%;border:1px solid #e6e6e6;background-color: #FFFFFF;margin-top: 20px;">
         <div style="margin-left: 30px;width: 1000px;">
           <el-form-item>
                 <div style="background-color: #EFEFEF;width: 100%;height: 30px;line-height: 30px;">
                   <span style="margin-left: 0px; font-weight: 800;">|&nbsp会议信息</span></div>
           </el-form-item>
		   <el-row>
			   <el-col :span="24">
				   <el-form-item label="会议标题" label-width="100px">				  
				     <el-input ></el-input>			    
				   </el-form-item>
				</el-col>
		   </el-row>
           
		   <el-row>
			   <el-col :span="11">
			   <el-form-item label="会议内容" label-width="100px">			      
			      <el-input></el-input>			      
			    </el-form-item>
				</el-col>
				
				<el-col :span="11" style="margin-left: 80px;">			
			   <el-form-item label="发布人" label-width="100px">			     
			      <el-input v-model="row.fbr"></el-input>
			    </el-form-item>
				  </el-col>
		   </el-row>
		   
		   <el-row>
		   			   <el-col :span="11">
		   			   <el-form-item label="开始时间" label-width="100px">			      
		   			     <div class="block">
		   			         <el-date-picker
		   			           v-model="value1"
		   			           type="datetime"
		   			           placeholder="选择日期时间">
		   			         </el-date-picker>
		   			       </div>		      
		   			    </el-form-item>
		   				</el-col>
		   				
		   				<el-col :span="11" style="margin-left: 80px;" label-width="100px">			
		   			   <el-form-item label="结束时间" label-width="100px">			     
		   			     		<div class="block">
		   			     		    
		   			     		    <el-date-picker
		   			     		      v-model="value2"
		   			     		      type="datetime"
		   			     		      placeholder="选择日期时间">
		   			     		    </el-date-picker>
		   			     		  </div>    
		   			    </el-form-item>
		   				  </el-col>
		   </el-row>
		   
		   <el-row>
		   			   <el-col :span="11">
		   			   <el-form-item label="会议类型" label-width="100px">			      
		   			     
		   			         <el-select  v-model="row.xueli" placeholder="请选择活动区域">
		   			           <el-option label="部门会议" value="部门会议"></el-option>
		   			           <el-option label="临时会议" value="临时会议"></el-option>
		   			      	 <el-option label="项目会议" value="项目会议"></el-option>
		   			      	 <el-option label="办公室会议" value="办公室会议"></el-option>
		   			         </el-select>
		   			     		      
		   			    </el-form-item>
		   				</el-col>
		   				
		   				<el-col :span="11" style="margin-left: 80px;">			
		   			   <el-form-item label="会议室" label-width="100px">			     
<<<<<<< HEAD
		   			   
									 <el-select v-model="value3" placeholder="请选择">
									     <el-option
									       v-for="item in dz"
									       :key="item.dzid"
									       :label="item.leixingname"
									       :value="item.leixingname">
									     </el-option>
									   </el-select>
=======
		   			      <el-input></el-input>			    
>>>>>>> origin/master
		   			    </el-form-item>
		   				  </el-col>
		   </el-row>
		   
		   <el-row>
		   			   <el-col :span="11">
		   			   <el-form-item label="人员" label-width="100px">			      
<<<<<<< HEAD
		   			      <el-select v-model="value4" multiple placeholder="请选择">
		   			          <el-option
		   			            v-for="item in yg"
		   			            :key="item.empno"
		   			            :label="item.ename"
		   			            :value="item.ename">
		   			          </el-option>
		   			        </el-select>		      
=======
		   			      <el-input></el-input>			      
>>>>>>> origin/master
		   			    </el-form-item>
		   				</el-col>
		   				
		   				
		   </el-row>
           
           <el-form-item>
				<el-button type="primary" style="color: white;" @click="addupd()">发布</el-button>
                 <router-link to="/job"><el-button >返回</el-button></router-link>
           </el-form-item>
         </div>
       </el-form>
<<<<<<< HEAD
=======
     
>>>>>>> origin/master
    </div>
</template>

<script>
  export default{
      data(){
        return {
<<<<<<< HEAD
		value3:'',
		value4:'',
=======
>>>>>>> origin/master
		contract:[],
         tableData: [],
		 value1: '',
		  value2: '',
		  row:{},
		  dz:[],
<<<<<<< HEAD
		  huiyi:{},
		  list:[],
		  yg:[],
=======
>>>>>>> origin/master
        }
        },methods:{
			      handleDelete(index) {
			          this.tableData.splice(index, 1)
			         
			      },
				 huiyishi(){
<<<<<<< HEAD
					 this.row.fbz=this.$store.state.ename;
					this.$axios.post("http://localhost:8888/huiyi/xla").then(r => {
						this.dz = r.data;
						console.log("11" ,r)
					}).catch(e => {
					
					});
					this.$axios.post("http://localhost:8888/huiyi/yuangong").then(r => {
						this.yg = r.data;
						console.log("11" ,r)
					}).catch(e => {
					
					});
=======
					 let url = "http://localhost:8888/huiyi/dizhi";
					 this.$axios.get(url).then(r => {
					 	this.dz=r.data
					 }).catch(e => {
					 	alert(e)
					 
					 });
>>>>>>> origin/master
				 } 
         
        }, created() {
			this.huiyishi();
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
