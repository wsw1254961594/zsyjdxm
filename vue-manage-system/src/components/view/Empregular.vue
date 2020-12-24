<template>
	<div class="pregularstyle">
		<el-table :data="empspregular" width="100%">
		  <el-table-column label="员工编号" prop="empno"></el-table-column>
		  <el-table-column label="员工姓名" prop="ename"></el-table-column>
		  <el-table-column label="员工性别" prop="sex"></el-table-column>
		  <el-table-column label="员工电话" prop="ephone"></el-table-column>
		  <el-table-column label="员工状态">
		 		  <template slot-scope="x">
		 			  {{x.state}}
		 			  <span v-if="x.row.state==1">试用期员工</span>
		 			  <span v-else-if="x.row.state==2">正式员工</span>
					  <span v-else>转正待审批</span>
		 		  </template>
		  </el-table-column>
		  <el-table-column label="所属部门" prop="mydept.dname"></el-table-column>
		  <el-table-column label="所属岗位" prop="myjobmsg.jmname"></el-table-column>
		  <el-table-column label="入职时间" prop="ofday"></el-table-column>
		  
		  <el-table-column label="操作">
		    <template slot-scope="x">
			 <el-tooltip class="item" effect="dark" content="申请员工转正" placement="top">
				<el-button size="mini" style="background-color: dodgerblue;" @click="handleEdit(x.row)">
				  <i class="el-icon-position" style="color: white;"></i>
				</el-button>
			 </el-tooltip>
		     
		    </template>
		  </el-table-column>
		</el-table>
		
		<!-- 申请转正 -->
		<el-dialog title="申请转正" :visible.sync="dialogFormVisible">
		  <el-form>
		    <el-form-item label="员工名称">
		      <el-input autocomplete="off" class="input2" v-model="mingzi" disabled></el-input>
		    </el-form-item>
		   <el-form-item label="转正说明">
		          <textarea style="height: 100px; width: 85%;" class="input2" v-model="shuoming"></textarea>
		    </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="dialogFormVisible = false">取 消</el-button>
		    <el-button type="primary" @click="doInsert()">确 定</el-button>
		  </div>
		</el-dialog>
		<el-pagination
		 @size-change="handleSizeChange"
		 @current-change="handleCurrentChange"
		 :current-page="current"
		 :page-sizes="[1, 2, 3, 4]"
		 :page-size="pageSize"
		 layout="total, sizes, prev, pager, next, jumper"
		 :total="total">
		</el-pagination>
	</div>
</template>

<script>
	export default {
	  data(){
	    return{
	      empspregular:[],
	      current:1,
	      pageSize:3,
	      total:0,
		  dialogFormVisible:false,
		  mingzi:'',
		  shuoming:'',
		  eid:''
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
	       this.$axios.post("http://localhost:8888/emps/Bystate",ppp)
	        .then(r=>{
	          if(r.data.code){
	            console.log(r.data);
	            this.empspregular = r.data.obj.list;
	            this.total = r.data.obj.total;
	          }
	        })
	    },
		handleEdit(row){
		 this.dialogFormVisible = true;
		  console.log(row,'row');
		  this.mingzi=row.ename;
		  this.eid=row.empno;
		},
		doInsert(){
			var e={
			  prequire:this.shuoming,
			  empno:this.eid
			};
			console.log(e,'e')
			var qq=this.$Qs.stringify(e);
			this.$axios.post("http://localhost:8888/positives/add",qq)
			.then(r=>{
			  if(r.data.code){
			    this.dialogFormVisible = false;
			    this.shuoming="";
			    this.getList();
			  }else{
			    alert("操作失败")
			  }
			}).catch(e=>{
			    console.log(e)
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
	  }
	}
</script>

<style>
	.pregularstyle .el-table .cell {
	    box-sizing: border-box;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: normal;
	    word-break: break-all;
	    line-height: 23px;
	    padding-right: 10px;
	    text-align: center;
	}
	.pregularstyle .input2{
		position: relative;
		font-size: 14px;
		display: inline-block;
		width: 85%;
	}
	.pregularstyle textarea{
	  resize:none
	  }
	  .pregularstyle .el-form-item--small .el-form-item__content, .el-form-item--small .el-form-item__label {
	      line-height: 50px;
	  }
</style>
