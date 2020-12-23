<template>
	<div>
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
					<span style="margin-left: 135px;">
					负责人编号：<el-input
					  placeholder="请输入负责人编号"
					  style="width: 380px;"
					  v-model="input2"
					  clearable>
					</el-input>
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
					  v-model="input1"
					  clearable>
					</el-input>
					</span>	
					<span style="margin-left: 150px;">
					所属阶段：<el-select style="width: 380px;"  v-model="select2" 
					slot="prepend" placeholder="请选择">
					      <el-option label="施工工程" value="施工工程"></el-option>
					      <el-option label="监理工程" value="监理工程"></el-option>
					      <el-option label="市场调查" value="市场调查"></el-option>
					    </el-select>
					</span>
					</div>
					<div style="margin-top: 25px;">
					<span style="margin-left: 20px;">
					所属项目编号：<el-input
					  placeholder="请输入所属项目编号"
					  style="width: 380px;"
					  v-model="input2"
					  clearable>
					</el-input>
					</span>
					</div>
					<div style="margin-top: 25px;">
					<span style="margin-left: 20px;">
					计划开始时间：<el-date-picker
					   v-model="value1"
					    style="width: 380px;"
					   type="date"
					   placeholder="选择日期">
					</el-date-picker>
					</span>
					<span style="margin-left: 120px;">
					计划结束时间：<el-date-picker
					   v-model="value2"
					    style="width: 380px;"
					   type="date"
					   placeholder="选择日期">
					</el-date-picker>
					</span>
					</div>
					<div style="margin-top: 35px;">
						<span style="margin-left: 480px;">
						<el-button type="primary" @click="">立即创建</el-button>
						<el-button>取消</el-button>
						</span>
					</div>
				</div></el-tab-pane>
				</el-tab-pane>
		  </el-tabs>
	</div>
	
	</div>
</template>

<script>
	 export default {
	     data() {
	       return {
	         input1:"",
			 input2:"",
			 select1:"",
			 select2:"",
			 value1:"",
			 value2:"",
			 activeName: 'first'
	       }
	     },
	     methods: {
	       onSubmit(){
			   let param={
			     pname:this.input1,
			     types:this.select1,
				 j:this.select2,
				 p1:this.value1,
				 p2:this.value2,
				 empid:this.input2
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
			    handleClick(tab, event) {
			           console.log(tab, event);
			         }
	     }
	   }
</script>

<style>
</style>
