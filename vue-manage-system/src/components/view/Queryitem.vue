<template>
	<div>
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
			<span style="margin-left: 150px;">
			项目状态：<el-select style="width: 380px;"  v-model="input2" 
			slot="prepend" placeholder="请选择">
			      <el-option label="正常" value="正常"></el-option>
			      <el-option label="冻结" value="冻结"></el-option>
			      <el-option label="延期" value="延期"></el-option>
				  <el-option label="完成" value="完成"></el-option>
			    </el-select>
			</span>
			</div>
			<div style="margin-top: 35px;">
					<span style="margin-left: 480px;">
					<el-button type="primary" @click="onSubmit">搜索</el-button>
					<el-button>取消</el-button>
					</span>
				</div>
			</div>
	<div style="width: 1200px; margin-top: 5px; margin-left: 40px;">
	<el-table :data="List">
	      <el-table-column label="项目名称" prop="pname"></el-table-column>
		  <el-table-column label="项目状态" prop="status"></el-table-column>
	      <el-table-column label="计划开始日期" prop="planstartdate"></el-table-column>
	      <el-table-column label="计划结束日期" prop="planenddate"></el-table-column>
		  <el-table-column label="项目进度" prop="progress"></el-table-column>
	</el-table>
	    <!-- current-page	当前页数，支持 .sync 修饰符-->
	    <el-pagination
		style="margin-left: 720px;"
	          @size-change="handleSizeChange"
	          @current-change="handleCurrentChange"
	          :current-page="current"
	          :page-sizes="[5, 10, 20, 40]"
	          :page-size="pageSize"
	          layout="total, sizes, prev, pager, next, jumper"
	          :total="total">
	        </el-pagination>
	
	  </div>
	  </div>
</template>

<script>
	export default {
	    data() {
	      return {
				 List:[],
				 input1:"",
				 input2:"", 
				 select1:"",
				 select2:"",
				 current:1,
				 pageSize:5
	      }
	    },
	    methods: {
	      onSubmit(){
				   let param={
					 no:this.current,
					 size:this.pageSize,
				     pname:this.input1,
				     types:this.select1,
					 status:this.input2,
					 jobtype:this.select2
				   };
				   let ppp = this.$Qs.stringify(param);
				  this.$axios.post("http://localhost:8888/Itemlist/Ss",ppp)
				   .then(r=>{
				     if(r.status===200){
				       this.List = r.data.list
				       this.total = r.data.total;
				       console.log(this.List)
				     }
				   }).catch(e=>{
				  	  alert(e)
				  })
				  
				   },
					  handleCurrentChange(pagerindex){
							        //参数是当前页码
							        this.current = pagerindex;
							        this.onSubmit();
							      },
							      /* pageSize 改变时会触发*/
							   handleSizeChange(pagesize){
							          this.pageSize=pagesize;
							         this.onSubmit();
							      }
	    }
	  }
</script>

<style>
</style>
