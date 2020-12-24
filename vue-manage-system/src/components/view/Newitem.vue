<template>
	<div>
	
		 <el-tabs v-model="activeName" @tab-click="handleClick">
		    <el-tab-pane label="新建项目" name="first">
				<div style="width: 1200px; margin-top: 25px; margin-left: 40px; ">
					<div style="margin-top: 25px;">
					<span style="margin-left: 50px;">
					项目名称：<el-input
					  placeholder="请输入项目名称"
					  style="width: 380px;"
					  v-model="input1"
					  clearable>
					</el-input>
					</span>
					<span style="margin-left: 150px;">
					项目类型：<el-select style="width: 380px;"  v-model="select1" 
					slot="prepend" placeholder="请选择">
					      <el-option label="产品实施类项目" value="产品实施类项目"></el-option>
					      <el-option label="工程施工类项目" value="工程施工类项目"></el-option>
					      <el-option label="软件开发类项目" value="软件开发类项目"></el-option>
					    </el-select>
					</span>
					</div>
					<div style="margin-top: 25px;">
					<span style="margin-left: 50px;">
					工作类型：<el-select style="width: 380px;"  v-model="select2" 
					slot="prepend" placeholder="请选择">
					      <el-option label="施工工程" value="施工工程"></el-option>
					      <el-option label="监理工程" value="监理工程"></el-option>
					      <el-option label="市场调查" value="市场调查"></el-option>
					    </el-select>
					</span>
					<span style="margin-left: 165px;">
					负责人：<el-select style="width: 380px;"  v-model="input2" 
					slot="prepend" placeholder="请选择">
					      <el-option
					        v-for="item in List"
					        :key="item.empno"
					        :label="item.ename"
					        :value="item.empno">
					      </el-option>
					    </el-select>
					</span>
					</div>
					<div style="margin-top: 25px;">
					<span style="margin-left: 20px;">
					计划开始日期：<el-date-picker
					   v-model="value1"
					    style="width: 380px;"
					   type="date"
					   placeholder="选择日期">
					</el-date-picker>
					</span>
					<span style="margin-left: 120px;">
					计划结束日期：<el-date-picker
					   v-model="value2"
					    style="width: 380px;"
					   type="date"
					   placeholder="选择日期">
					</el-date-picker>
					</span>
					</div>
					<div style="margin-top: 25px;">
						<span style="margin-left: 50px;">
					项目成员：<el-select style="width: 120px;"  v-model="select4" 
						slot="prepend" placeholder="请选择">
					      <el-option
					        v-for="item in List"
					        :key="item.empno"
					        :label="item.ename"
					        :value="item.empno">
					      </el-option>
					    </el-select>
						</span>
						<span style="margin-left: 10px;">
						<el-select style="width: 120px;"  v-model="select5"
						slot="prepend" placeholder="请选择">
						      <el-option
						        v-for="item in List"
						        :key="item.empno"
						        :label="item.ename"
						        :value="item.empno">
						      </el-option>
						    </el-select>
							</span>
							<span style="margin-left: 10px;">
							<el-select style="width: 120px;"  v-model="select6"
							slot="prepend" placeholder="请选择">
							      <el-option
							        v-for="item in List"
							        :key="item.empno"
							        :label="item.ename"
							        :value="item.empno">
							      </el-option>
							    </el-select>
						  </span>
					</div>
					<div style="margin-top: 35px;">
						<span style="margin-left: 480px;">
						<el-button type="primary" @click="onSubmit">立即创建</el-button>
						<el-button>取消</el-button>
						</span>
					</div>
				</div></el-tab-pane>
		    <el-tab-pane label="新建任务" name="second">
				<div style="width: 1200px; margin-top: 25px; margin-left: 40px; ">
					<div style="margin-top: 25px;">
					<span style="margin-left: 50px;">
					任务名称：<el-input
					  placeholder="请输入任务名称"
					  style="width: 380px;"
					  v-model="input3"
					  clearable>
					</el-input>
					</span>	
					<span style="margin-left: 180px;">
					阶段：<el-select style="width: 380px;"  v-model="select3" 
					slot="prepend" placeholder="请选择">
					      <el-option label="项目准备" value="项目准备"></el-option>
					      <el-option label="需求调研" value="需求调研"></el-option>
					      <el-option label="系统搭建" value="系统搭建"></el-option>
					    </el-select>
					</span>
					</div>
					<div style="margin-top: 25px;">
					<span style="margin-left: 20px;">
					所属项目编号：<el-input
					  placeholder="请输入所属项目编号"
					  style="width: 380px;"
					  v-model="input4"
					  clearable>
					</el-input>
					</span>
					</div>
					<div style="margin-top: 25px;">
					<span style="margin-left: 20px;">
					计划开始时间：<el-date-picker
					   v-model="value3"
					    style="width: 380px;"
					   type="date"
					   placeholder="选择日期">
					</el-date-picker>
					</span>
					<span style="margin-left: 120px;">
					计划结束时间：<el-date-picker
					   v-model="value4"
					    style="width: 380px;"
					   type="date"
					   placeholder="选择日期">
					</el-date-picker>
					</span>
					</div>
					<div style="margin-top: 25px;">
						<span style="margin-left: 50px;">
						任务说明：<el-input
						  type="textarea"
						  style="width: 420px;"
						  :rows="2"
						  placeholder="请输入任务说明"
						  v-model="textarea">
						</el-input>
						</span>
					</div>
					<div style="margin-top: 35px;">
						<span style="margin-left: 480px;">
						<el-button type="primary" @click="rw">立即创建</el-button>
						<el-button>取消</el-button>
						</span>
					</div>
				</div>
				</el-tab-pane>
		  </el-tabs>
	</div>
</template>

<script>
	 export default {
	     data() {
	       return {
			 List:[],
	         input1:"",
			 input2:"",
			 input3:"",
			 input4:"",
			 select1:"",
			 select2:"",
			 select3:"",
			 select4:"",
			 select5:"",
			 select6:"",
			 value1:"",
			 value2:"",
			 value3:"",
			 value4:"",
			 current:1,
			 pageSize:20,
			 activeName: 'first',
			  textarea: ''
	       }
	     },
	     methods: {
			 loadData(){
			         let param={
			           no:this.current,
			           size:this.pageSize
			         };
			         let ppp = this.$Qs.stringify(param);
			         this.$axios.post("http://localhost:8888/emps/pages",ppp)
			         .then(r=>{
			           if(r.status===200){
			             this.List = r.data.obj.list
			             this.total = r.data.total;
			             console.log(this.List)
			           }
			         }).catch(e=>{
			 			  alert(e)
			 				  })
			       },
	       onSubmit(){
			   let param={
			     pname:this.input1,
			     types:this.select1,
				 j:this.select2,
				 p1:this.value1,
				 p2:this.value2,
				 empid:this.input2,
				 em1:this.select4,
				 em2:this.select5,
				 em3:this.select6
			   };
			   let ppp = this.$Qs.stringify(param);
			   this.$axios.post("http://localhost:8888/Itemlist/doInsert",ppp)
			   .then(r=>{
			     if(r.status===200){
					 this.$message('新增成功');
			     }
			   }).catch(e=>{
			   		alert(e)
			   })
			   },
			   a(){
				   
			   },
			   rw(){
				   let param={
					 iid:this.input4,
				     mname:this.input3,
				     stage:this.select3,
				   	 ingtime:this.value3,
				   	 endtime:this.value4,
				   	 taskdescription:this.textarea
				   };
				   let ppp = this.$Qs.stringify(param);
				   this.$axios.post("http://localhost:8888/Tasklist/doInsert",ppp)
				   .then(r=>{
				     if(r.status===200){
				   	 this.$message('新增成功');
				     }
				   }).catch(e=>{
				   		alert(e)
				   })
			   },
			    handleClick(tab, event) {
			           console.log(tab, event);
			         }
	     },
		   mounted() {
		       this.loadData();
		     }
	   }
</script>

<style>
</style>
