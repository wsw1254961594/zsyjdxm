<template>
    <div id="Big">
    <div id="right">
        <div id="right_head">
          <el-row>
            <i class="el-icon-finished" style="font-size: 17px;margin-left: 20px;">&nbsp;合同起草</i>
          </el-row>
        </div>
       
        <div id="right_body">
          <div class="right_body_table">
				<div class="adddiv" @click="CgPost()">
					<span class="addindex">1</span>
					<span class="addcont">采购合同申请</span>
				</div>
				
				<div class="adddiv">
					<span class="addindex">2</span>
					<span class="addcont">销售合同申请</span>
				</div>
          </div>
        </div>
    </div>

   
    </div>
</template>

<script>
  export default{
    data(){
      return{
       
      }
    },methods:{
     //采购合同申请
     CgPost(){
       this.$router.push({path:'/cgpost',query:{params:1}})
     },
    },created(){
     
    }
    }
</script>

<style scoped="scoped">
	
	.adddiv{
			margin-left: 30px;
			margin-top: 20px;
		    width: 29.3%;
		    float: left;
		    font-size: 14px;
		    color: #666;
		    padding: 20px 2% 20px;
	}
	
	.adddiv:hover{
		    background: #f5f5f5;
		    border-radius: 5px;
					cursor: pointer;
	}
	
	.addindex{
		display: block;
		width: 30px;
		height: 30px;
		text-align: center;
		line-height: 30px;
		background: #20A0FF;
		border-radius: 15px;
		float: left;
	}
	
	.addcont{
		float: left;
		margin-top: 5px;
		margin-left: 10px;
	}
	
  *{
    margin: 0 auto;
    padding: 0;
    color: #585856;
  }

  #Big{
    width: 100%;
    height: 97%;
    background: #f3f4f7;
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
