<template>
    <div id="Big">
    <div id="right">
        <div id="right_head">
          <el-row>
            <i class="el-icon-finished" style="font-size: 17px;margin-left: 20px;">&nbsp;合同变更</i>
          </el-row>
        </div>
        <div id="rigth_select">
            <el-row>
              <el-col :span="4">
                <el-input
                    placeholder="岗位名称"
                    prefix-icon="el-icon-search"                 
                    @change="getPostBy"
                    clearable>
                </el-input>
              </el-col>
              <el-col :span="0.5">&nbsp;</el-col>
              <el-col :span="4">
                <el-input
                    placeholder="职位名称"
                     prefix-icon="el-icon-search"
                  
                    @change="getPostBy"
                    clearable>
                </el-input>
              </el-col>
               <el-col :span="0.5">&nbsp;</el-col>
              <el-col :span="4">	
                <el-input
                    placeholder="部门名称"
                    prefix-icon="el-icon-search"
                 
                    @change="getPostBy"
                    clearable>
                </el-input>
              </el-col>            
            </el-row>





        </div>
        <div id="right_body">       
          <div class="right_body_table">
				<el-table
				  :data="changes"
				  stripe
				  style="width: 102%">
				  <el-table-column
				  type="selection"
				    width="60">
				
				  </el-table-column>
				  
				  <el-table-column
				    prop="mycontract.cnumber"
				    label="合同编号"
				   >
				  </el-table-column>
				  
				  <el-table-column
				    prop="mycontract.ctitle"
				    label="合同名称"
				    >
				  </el-table-column>
				  
				  <el-table-column
				    prop="chday"
				    label="变更日期"
					  >
				  </el-table-column>
				 
				  <el-table-column
					prop="chcause"
				    label="变更事由"
					  width="240px">					        
				  </el-table-column>
					 
					 <el-table-column
						prop="chtitle"
					   label="变更流程"
					   width="240px">					        
					 </el-table-column>
					 
					 <el-table-column							 
					   label="变更类型"
					  >			
						<template slot-scope="scope">
							<span v-if="scope.row.chtype=='合同解除'">
								
								<el-button type="danger" plain>{{scope.row.chtype}}</el-button>
							</span>
							<span v-if="scope.row.chtype=='合同结项'">
								<el-button type="success" plain>{{scope.row.chtype}}</el-button>
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
    </div>

   
    </div>
</template>

<script>
  export default{
    data(){
      return{
		changes:[],
		current:0,
		size:8,
		total:0,
      }
    },methods:{
		/* 查询所有变更信息*/
		getChanges(){
					  let url="http://localhost:8888/changes/all";
					  let param={
						  pageNo:this.current,
						  pageSize:this.size		  				
					  }
					  param = this.$Qs.stringify(param);
					  this.$axios.post(url,param).then(r=>{
						  this.changes=r.data.obj.list;
						  this.total=r.data.obj.total;
					  }).catch(e=>{
						  alert("出错了"+e)
					  })
		},
		
    },created(){
     this.getChanges();
    }
    }
</script>

<style scoped="scoped">


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
  }

  #right_body_tj{
    width: 100%;
    height: 100px;
    background: #efeff4;
  }

  #rigth_select{
    border: 1px solid #eaeaea;
    width: 100%;
    height: 70px;
    background: white;
    line-height: 70px;

  }

  .tj_div_one{
    margin-top: 10px;
    width:98%;
    height: 80px;
    background: white;

  }


  .tj_div_two{
    margin-top: 10px;
    width:98%;
    height: 80px;
    background: white;

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
