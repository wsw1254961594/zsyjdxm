<template>
  <div class="empsstyle">
	<el-button type="primary" @click="dialogForm=true">高级查询</el-button>
	<el-button type="primary" class="xinzeng" @click="dialogFormVisible=true">新增入职员工</el-button>
    <el-table :data="emps" width="100%">
      <el-table-column label="员工编号" prop="empno"></el-table-column>
      <el-table-column label="员工姓名" prop="ename"></el-table-column>
      <el-table-column label="员工性别" prop="sex"></el-table-column>
      <el-table-column label="员工电话" prop="ephone"></el-table-column>
      <el-table-column label="所属部门" prop="mydept.dname"></el-table-column>
	  <el-table-column label="所属岗位" prop="myjobmsg.jmname"></el-table-column>
      <el-table-column label="入职时间" prop="ofday"></el-table-column>
    </el-table>

    <el-pagination
     @size-change="handleSizeChange"
     @current-change="handleCurrentChange"
     :current-page="current"
     :page-sizes="[1, 2, 3, 4]"
     :page-size="pageSize"
     layout="total, sizes, prev, pager, next, jumper"
     :total="total">
    </el-pagination>
	
	<el-dialog title="新增入职员工" :visible.sync="dialogFormVisible">
	  <el-form>
	    <el-form-item label="员工名称">
	      <el-input autocomplete="off" class="input2"></el-input>
	    </el-form-item>
	    <el-form-item label="员工性别">
	        <el-input autocomplete="off" class="input2"></el-input>
	    </el-form-item>
	   <el-form-item label="员工电话">
	        <el-input autocomplete="off" class="input2"></el-input>
	    </el-form-item>
		<el-form-item label="所属部门">
		    <el-select v-model="bumen" placeholder="请选择">
		        <el-option
		          v-for="item in depts"
		          :key="item.deptno"
		          :label="item.dname"
		          :value="item.deptno">
		        </el-option>
		      </el-select>
		 </el-form-item>
		<el-form-item label="所属岗位">
			  <!-- <el-input autocomplete="off" class="input2"></el-input> -->
			<!-- <el-select v-model="value2" placeholder="请选择">
			    <el-option
			      v-for="item in options"
			      :key="item.value"
			      :label="item.label"
			      :value="item.value">
			    </el-option>
			  </el-select> -->
		</el-form-item>
		<el-form-item label="入职日期">
			 <el-date-picker
			       v-model="value1"
				   class="rzrq"
			       type="date"
			       placeholder="选择日期">
			     </el-date-picker>
		</el-form-item>
	
	  </el-form>
	  <div slot="footer" class="dialog-footer">
	    <el-button @click="dialogFormVisible = false">取 消</el-button>
	    <el-button type="primary">确 定</el-button>
	  </div>
	</el-dialog>
	
	<!-- 高级查询弹窗 -->
	<el-dialog title="搜索入职员工" :visible.sync="dialogForm">
	  <el-form>
	    <el-form-item label="员工名称">
	      <el-input autocomplete="off" v-model="ename" class="input1"></el-input>
	    </el-form-item>
	    <el-form-item label="员工性别">
			 <el-radio v-model="sex" label="男">男</el-radio>
			  <el-radio v-model="sex" label="女">女</el-radio>
	    </el-form-item>
	   <el-form-item label="员工电话">
	        <el-input autocomplete="off" v-model="ephone" class="input1"></el-input>
	    </el-form-item>
		<el-form-item label="入职日期">
			 <el-date-picker
			       v-model="ofday"
			       type="daterange"
				   class="rili"
			       range-separator="至"
			       start-placeholder="开始日期"
			       end-placeholder="结束日期">
			     </el-date-picker>
		</el-form-item>
	
	  </el-form>
	  <div slot="footer" class="dialog-footer">
	    <el-button @click="dialogForm = false">取 消</el-button>
	    <el-button type="primary" @click="selectmohu()">确 定</el-button>
	  </div>
	</el-dialog>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        emps:[],
        current:1,
        pageSize:3,
        total:0,
		dialogFormVisible:false,
		dialogForm:false,
		ename:'',
		sex:'',
		ephone:'',
		ofday:'',
		value1:'',
		value2:'',
		value:'',
		depts: [],
		bumen:''
      }
    },
    methods:{
      /* 查询所有记录*/
        getList(){
          let param={
            no:this.current,
            size:this.pageSize
          };
          let ppp = this.$Qs.stringify(param);
         this.$axios.post("http://localhost:8089/emps/pages",ppp)
          .then(r=>{
            if(r.data.code){
              console.log(r.data);
              this.emps = r.data.obj.list;
              this.total = r.data.obj.total;
            }
          })
      },
	  /* 查询所有部门*/
	  selectdept(){
	     this.$axios.post("http://localhost:8089/depts/all")
	     .then(r=>{
	       if(r.data.code){
			 console.log(r.data.objs,"数据")
	         this.depts=r.data.objs;
	       }
	     })
	  },
	  /* 高级查询*/
	  selectmohu(){
		  let param={
		    ename:this.ename,
		    ephone:this.ephone,
		    sex:this.sex,
		    ofday:this.ofday,
		    no:this.current,
		    size:this.pageSize
		  };
		  console.log(this.sex);
		  let ppp = this.$Qs.stringify(param);
		  this.$axios.post("http://localhost:8089/emps/mohu",ppp)
		  .then(r=>{
		    console.log(r.data);
			this.dialogForm=false;
		    this.emps=r.data.obj.list;
		    this.total = r.data.obj.total;
		  }).catch(e=>{
		    alert("查询失败！！")
		  })
	  },
      handleSizeChange(pagesize){
           this.pageSize=pagesize;
           this.getList();
       },
      handleCurrentChange(pagerindex){
        this.current = pagerindex;
        this.getList();
      }
     },
    created() {
      this.getList();
	  this.selectdept();
    }
  }
</script>

<style>
	.empsstyle .el-table .cell {
	    box-sizing: border-box;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: normal;
	    word-break: break-all;
	    line-height: 23px;
	    padding-right: 10px;
	    text-align: center;
	}
	.empsstyle .xinzeng{
		margin-bottom: 10px;
	}
	.empsstyle .input1{
		position: relative;
		font-size: 14px;
		display: inline-block;
		width: 85%;
	}
	.empsstyle .input2{
		position: relative;
		font-size: 14px;
		display: inline-block;
		width: 85%;
	}
	.empsstyle .rili{
		width: 85%;
	}
	.empsstyle .rzrq{
		width: 85%;
	}
</style>
