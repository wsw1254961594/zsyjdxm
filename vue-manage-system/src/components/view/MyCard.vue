<template>
	<div class="mycardstyle">
		<div style="border: 1px solid red; height: 80px;">
			
		</div>
		<div class="kapian">
			<el-tabs type="border-card">
			  <el-tab-pane label="我的卡片">
				  <div class="info" style="height: 500px; width: 20%;">
					  <div class="headimg">
						 <img src="../../assets/img/lm.png" width="220px" height="200px"/>
					  </div>
					
					  <div class="xinxi">
						  <el-divider><i class="el-icon-s-custom" style="font-size: 20px;"></i></el-divider>
						<el-row>
						  <el-col :span="8">员工名称:</el-col>
						  <el-col :span="12">廖苗</el-col>
						</el-row>
						<el-row>
						  <el-col :span="8">员工岗位:</el-col>
						  <el-col :span="12">boss</el-col>
						</el-row>
					  </div>
					  
					  <div class="infodesatil" style="border: 1px solid blue">
						  <el-row>
						    <el-col :span="12">sdb</el-col>
						    <el-col :span="12">sdfsdgf</el-col>
						  </el-row>
						  <el-row>
						    <el-col :span="12">guh</el-col>
						    <el-col :span="12">ko</el-col>
						  </el-row>
						  <el-row>
						    <el-col :span="12">ppp</el-col>
						    <el-col :span="12">ds</el-col>
						  </el-row>
					  </div>
				  </div>
			  </el-tab-pane>
			  <el-tab-pane label="基本信息">
				  
			  </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
	export default {
	  data(){
	    return{
	    }
	  },
	  methods:{
	   
	 },
	  created() {
	   
	  }
	}
</script>

<style>
	.mycardstyle .xinxi{
		margin-top: 20px;
		color: slategrey;
		font-size: 15px;
		line-height: 40px;
	}
	.mycardstyle .headimg{
		margin-left: 20px;
	}
	.mycardstyle .infodesatil{
		position: relative;
		left: 350px;
		bottom: 340px;
		height: 500px;
		width: 800px;
		
	}
</style>
