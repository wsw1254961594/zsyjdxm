<template>
    <div id="Big">
    <div id="right">
        <div id="right_head">
          <el-row>
            <i class="el-icon-finished" style="font-size: 17px;margin-left: 20px;">&nbsp;我的申请</i>
          </el-row>
        </div>
        <div id="rigth_select">
            <el-row>
              <el-col :span="4">
                <el-input
                    placeholder="合同名称"
                    prefix-icon="el-icon-search"
                   
                    @change="getPostBy"
                    clearable>
                </el-input>
              </el-col>
              <el-col :span="0.5">&nbsp;</el-col>
              <el-col :span="4">
                <el-input
                    placeholder="合同编号"
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
                 :data="contract"
                 stripe
                 style="width: 102%">
                 <el-table-column
                 type="selection"
                   width="60">
               
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
                   label="合同类型"
               		width="180">
					<template slot-scope="scope">
						<span v-if="scope.row.ctype==1">
							非生产性采购合同
						</span>
						<span v-if="scope.row.ctype==2">
							产品销售合同
						</span>
					</template>
                 </el-table-column>
                
                 <el-table-column
                   label="申请人"
               		prop="myemp.ename">
                
                 </el-table-column>
				 
				 <el-table-column
				   label="申请部门"
				   prop="myemp.mydept.dname">				  
				 </el-table-column>
               							
                 <el-table-column
                   label="申请日期"
					prop="cday">               
                 </el-table-column>
				 
				 <el-table-column
				   label="当前状态"
					>   
					<span><el-button type="warning" plain>拟稿待审核</el-button></span>
					
				 </el-table-column>
				 
				 <el-table-column
				   label="操作"
				 >   
				 <template slot-scope="scope">
					 <el-button type="primary" plain>查看拟稿文件</el-button>
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
		contract:[],
		current:0,
		size:8,
		total:0,
      }
    },methods:{
		getContract(){
			let url="http://localhost:8888/contract/logcontract";
			let param={
				empno:this.$store.state.empno,
				pageNo:this.current,
				pageSize:this.size
			}
			param=this.$Qs.stringify(param);
			this.$axios.post(url,param).then(r=>{
				this.contract=r.data.obj.list;
				this.total=r.data.obj.total;
			}).catch(e=>{
				alert(e)
			})
		}
    },created(){
     this.getContract();
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
