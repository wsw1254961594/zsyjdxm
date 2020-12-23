<template>
	<div style="width: 600px; margin-top: 15px; margin-left: 100px;">
		<el-form ref="form" :model="form" label-width="120px">
		  <el-form-item label="项目名称">
		    <el-input v-model="form.name"></el-input>
		  </el-form-item>
		  <el-form-item label="负责人编号">
		    <el-input v-model="form.empid"></el-input>
		  </el-form-item>
		  <el-form-item label="项目类型">
		    <el-select v-model="form.pes" placeholder="请选择">
		      <el-option label="产品实施类项目" value="产品实施类项目"></el-option>
		      <el-option label="工程施工类项目" value="工程施工类项目"></el-option>
			  <el-option label="采购项目" value="采购项目"></el-option>
			  <el-option label="软件开发类项目" value="软件开发类项目"></el-option>
		    </el-select>
			</el-form-item>
		  <el-form-item label="工作类型">
		    <el-select v-model="form.job" placeholder="请选择">
		      <el-option label="施工工程" value="施工工程"></el-option>
		      <el-option label="监理工程" value="监理工程"></el-option>
			  <el-option label="市场调查" value="市场调查"></el-option>
		    </el-select>
		  </el-form-item>
		  <el-form-item label="计划开始日期">
		    <el-col :span="11">
		      <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
		    </el-col>
		  </el-form-item>
		  <el-form-item label="计划结束日期">
		    <el-col :span="11">
		      <el-date-picker type="date" placeholder="选择日期" v-model="form.date2" style="width: 100%;"></el-date-picker>
		    </el-col>
		  </el-form-item>
		    <el-button type="primary" @click="onSubmit">立即创建</el-button>
		    <el-button>取消</el-button>
		  </el-form-item>
		</el-form>
	</div>
</template>

<script>
	 export default {
	     data() {
	       return {
	         form: {
	           name: '',
			   empid:0,
	           pes: '',
			   job: '',
	           date1: '',
	           date2: ''
	         }
	       }
	     },
	     methods: {
	       onSubmit() {
	         console.log('submit!');
	       }
	     }
	   }
</script>

<style>
</style>
