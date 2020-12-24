<template>
    <div id="Big">
    <div id="right">
        <div id="right_head">
          <el-row>
            <i class="el-icon-finished" style="font-size: 17px;margin-left: 20px;">&nbsp;统计报表</i>
          </el-row>
        </div>
        <div id="right_body">     
          <div class="right_body_table">
               <div  style="width: 100%;background: white;float: left;margin-top: 20px;text-align: center;">
                   <p style="margin-top: 40px;"><span style="font-size: 16px;font-weight: 600;">合同的实际金额与已付金额</span></p>
                   <div style="margin-top: 20px; width:95%;height:537px;margin-left: 0px;margin-bottom: 100px;" ref="conpeytj"></div>
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
		conpey:[],
		contract:[],
		cmoney:[],
		smoney:[],
      }
    },methods:{  
      //应聘与离职统计
     getConPay(){
       let url="http://localhost:8888/statis/conpay";
       this.$axios.post(url).then(r=>{
           this.conpey=r.data;
          if(this.conpey && this.conpey.length>0){
            this.conpey.forEach((item)=>{
              for(var k in item){
                if(k=="ctitle"){
                  this.contract.push(item[k]);
                }if(k=="cmoney"){
					this.cmoney.push(item[k]);
				}if(k=="smoney"){
					
						 this.smoney.push(item[k]);
					
                 
                }
              }
     
            })
			
            this.drawLine();
          }
     
       });  
     },drawLine(){
			console.log(this.smoney);
          // 基于准备好的dom，初始化echarts实例
          let myChart = this.$echarts.init(this.$refs.conpeytj);
          myChart.setOption({
            toolbox: {
                show: true,
                feature: {

                    magicType: {show: true, type: ['line', 'bar']},

                    saveAsImage: {show: true}
                }
            },
               tooltip: {
                     trigger: 'axis',
                     axisPointer: {
                         type: 'shadow'
                     }
                 },
                legend: {
                    data: ['合同金额', '已付金额']
                },
                 grid: {
                       left: '3%',
                       right: '4%',
                       bottom: '3%',
                       containLabel: true
                   },
                xAxis: [
                    {
                        type: 'value',

                    }
                ],
                yAxis: [
                    {
                        type: 'category',
                        data: this.contract
                    }
                ],
                series: [
                  {
                     name: '合同金额',
                      type: 'bar',
                      data: this.cmoney
                  },
                  {
                     name: '已付金额',
                      type: 'bar',
                      data: this.smoney
                  }
                ]
          });
        }
    },mounted() {
		this.getConPay();
  }
    }
</script>

<style scoped="scoped">
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
