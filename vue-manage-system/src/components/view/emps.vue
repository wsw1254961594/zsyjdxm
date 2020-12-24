<template>
  <div class="empsstyle">
	<el-button type="primary" @click="dialogForm=true">高级查询</el-button>
	<el-button type="primary" class="xinzeng" @click="selectBymgr()">新增入职员工</el-button>
    <el-table :data="emps" width="100%">
      <el-table-column label="员工编号" prop="empno"></el-table-column>
      <el-table-column label="员工姓名" prop="ename"></el-table-column>
      <el-table-column label="员工性别" prop="sex"></el-table-column>
      <el-table-column label="员工电话" prop="ephone"></el-table-column>
	  <el-table-column label="员工状态">
		  <template slot-scope="x">
			  {{x.state}}
			  <span v-if="x.row.state==1">试用期员工</span>
			  <span v-else-if="x.row.state==2">正式员工</span>
			  <span v-else-if="x.row.state==4">转岗待审批</span>
			  <span v-else>转正待审批</span>
		  </template>
	  </el-table-column>
      <el-table-column label="所属部门" prop="mydept.dname"></el-table-column>
	  <el-table-column label="所属岗位" prop="myjobmsg.jmname"></el-table-column>
      <el-table-column label="入职时间" prop="ofday"></el-table-column>
	  <el-table-column label="操作">
	    <template slot-scope="x">
	  			 <el-tooltip class="item" effect="dark" content="员工申请调岗" placement="top">
	  				<el-button size="mini" style="background-color: dodgerblue;" @click="handleEdit(x.row)">
	  				  <i class="el-icon-thumb" style="color: white;"></i>
	  				</el-button>
	  			 </el-tooltip>
				 <el-tooltip class="item" effect="dark" content="员工申请离职" placement="top">
					<el-button size="mini" style="background-color: dodgerblue;">
					  <i class="el-icon-circle-close" style="color: white;"></i>
					</el-button>
				 </el-tooltip>
	    </template>
	  </el-table-column>
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
	      <el-input autocomplete="off" class="input2" v-model="name"></el-input>
	    </el-form-item>
	    <el-form-item label="员工性别">
	       <!-- <el-input autocomplete="off" class="input2" v-model="esex"></el-input> -->
		   <el-radio v-model="esex" label="男">男</el-radio>
		     <el-radio v-model="esex" label="女">女</el-radio>
	    </el-form-item>
	   <el-form-item label="员工电话">
	        <el-input autocomplete="off" class="input2" v-model="phone"></el-input>
	    </el-form-item>
		<el-form-item label="所属部门">
		    <el-select v-model="bumen" placeholder="请选择" @change="selectdeptno">
		        <el-option
		          v-for="item in depts"
		          :key="item.deptno"
		          :label="item.dname"
		          :value="item.deptno">
		        </el-option>
		      </el-select>
		 </el-form-item>
		<el-form-item label="所属岗位" class="gw">
			<el-select v-model="gangwei" placeholder="请选择">
			    <el-option
			      v-for="item in jobmsg"
			      :key="item.jmid"
			      :label="item.jmname"
			      :value="item.jmid">
			    </el-option>
			  </el-select>
		</el-form-item>
		
		<!-- 上级编号 -->
		<el-form-item label="上级编号" class="shangji">
			<el-select v-model="mgr" placeholder="请选择">
			    <el-option
			      v-for="item in empmgrs"
			      :key="item.empno"
			      :label="item.ename"
			      :value="item.empno">
			    </el-option>
			  </el-select>
		</el-form-item>
	
	  </el-form>
	  <div slot="footer" class="dialog-footer">
	    <el-button @click="dialogFormVisible = false">取 消</el-button>
	    <el-button type="primary" @click="doInsert()">确 定</el-button>
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
	
	<!-- 员工调岗 -->
	<el-dialog title="员工调岗申请" :visible.sync="dialog">
	  <el-form>
	    <el-form-item label="调岗原由">
	     <textarea style="height: 100px; width: 85%;" class="input2" v-model="zhuangangyuanyou"></textarea>
	    </el-form-item>
		
		<!-- 原职位 -->
	   <el-form-item label="原部门" class="yzw">
	       <el-select v-model="yuanbumen" placeholder="请选择" @change="selectdeptno()" disabled>
	           <el-option
			   
	             v-for="item in depts"
	             :key="item.deptno"
	             :label="item.dname"
	             :value="item.deptno">
	           </el-option>
	         </el-select>
	    </el-form-item>
	   <el-form-item label="原岗位" class="yuanjob">
	   	<el-select v-model="yuangangwei" placeholder="请选择" disabled>
	   	    <el-option
	   	      v-for="item in jobmsg"
	   	      :key="item.jmid"
	   	      :label="item.jmname"
	   	      :value="item.jmid">
	   	    </el-option>
	   	  </el-select>
	   </el-form-item>
	   	
		<!-- 新职位 -->
		<el-form-item label="调岗部门" class="dg">
		    <el-select v-model="xbm" placeholder="请选择" @change="selectbumen()">
		        <el-option
		          v-for="item in depts"
		          :key="item.deptno"
		          :label="item.dname"
		          :value="item.deptno">
		        </el-option>
		      </el-select>
		 </el-form-item>
		<el-form-item label="调岗岗位" class="dggw">
			<el-select v-model="xgw" placeholder="请选择">
			    <el-option
			      v-for="item in jobmsg"
			      :key="item.jmid"
			      :label="item.jmname"
			      :value="item.jmid">
			    </el-option>
			  </el-select>
		</el-form-item>
	  </el-form>
	  <div slot="footer" class="dialog-footer">
	    <el-button @click="dialog = false">取 消</el-button>
	    <el-button type="primary" @click="add()">确 定</el-button>
	  </div>
	</el-dialog>
	
	
  </div>
</template>

<script>
  export default {
    data(){
      return{
		empmgrs:[],
		mgr:'',
		zhuangangyuanyou:'',
		xbm:'',
		xgw:'',
		yuanbumen:'',
		yuangangwei:'',
        emps:[],
        current:1,
        pageSize:3,
        total:0,
		dialog:false,
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
		bumen:'',
		gangwei:'',
		jobmsg:[],
		deptno:'',
		value3:'',
		name:'',
		esex:'',
		phone:'',
		eid:'',
		drawer: false,
		direction: 'rtl',
		dname:'',
		jmname:'',
		bumenid:'',
		gangweiid:''
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
         this.$axios.post("http://localhost:8888/emps/pages",ppp)
          .then(r=>{
            if(r.data.code){
              console.log(r.data);
              this.emps = r.data.obj.list;
              this.total = r.data.obj.total;
            }
          })
      },
	  /* 根据id查询所有员工*/
	  selectBymgr(){
		  this.dialogFormVisible=true;
		  let e={
				eid:this.mgr
		   };
		  console.log('e',e)
		  this.$axios.post("http://localhost:8888/emps/all",this.$Qs.stringify(e))
		  .then(r=>{
		    if(r.data.code){
		  	  console.log(r.data.objs,"dddd数据")
		      this.empmgrs=r.data.objs;
		    }
		  })
	  },
	  /* 查询所有部门*/
	  selectdept(){
	     this.$axios.post("http://localhost:8888/depts/all")
	     .then(r=>{
	       if(r.data.code){
			 console.log(r.data.objs,"数据")
	         this.depts=r.data.objs;
	       }
	     })
	  },
	  selectdeptno(){
		  let e={
			  deptno:this.yuanbumen
		  };
		  console.log('aaaa',e)
	     this.$axios.post("http://localhost:8888/jobmsg/bydeptno",this.$Qs.stringify(e))
	     .then(r=>{
	       if(r.data.code){
	  		 console.log(r.data.objs,"dddd数据")
	         this.jobmsg=r.data.objs;
	       }
	     })
	  },
	  selectbumen(){
	  		  let e={
	  			  deptno:this.xbm
	  		  };
	  		  console.log('aaaa',e)
	     this.$axios.post("http://localhost:8888/jobmsg/bydeptno",this.$Qs.stringify(e))
	     .then(r=>{
	       if(r.data.code){
	  		 console.log(r.data.objs,"dddd数据")
	         this.jobmsg=r.data.objs;
	       }
	     })
	  },
	  handleEdit(row){
	   this.dialog= true;
	    console.log(row,'row');
	    this.eid=row.empno;
		this.yuanbumen=row.mydept.dname;
		this.bumenid=row.mydept.deptno;
		this.gangweiid=row.myjobmsg.jmid;
		console.log("岗位id",row.myjobmsg.jmid);
		console.log("11111111111",row.mydept.deptno);
		this.yuangangwei=row.myjobmsg.jmname;
	  },
	  add(){
		  var e={
		    pcause:this.zhuangangyuanyou,
		    yuanpost:this.gangweiid,
		    xinpost:this.xgw,
		    yuandept:this.bumenid,
		    xindept:this.xbm,
			empno:this.eid
		  };
		  console.log(e,'e')
		  var qq=this.$Qs.stringify(e);
		  this.$axios.post("http://localhost:8888/postsc/insert",qq)
		  .then(r=>{
		    if(r.data.code){
		      this.dialog=false;
		      this.getList();
		      this.zhuangangyuanyou="";
		      this.yuangangwei="";
		      this.xgw="";
		      this.yuanbumen="";
		  	  this.xbm="";
		    }else{
		      alert("操作失败")
		    }
		  }).catch(e=>{
		      console.log(e)
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
		  this.$axios.post("http://localhost:8888/emps/mohu",ppp)
		  .then(r=>{
		    console.log(r.data);
			this.dialogForm=false;
		    this.emps=r.data.obj.list;
		    this.total = r.data.obj.total;
		  }).catch(e=>{
		    alert("查询失败！！")
		  })
	  },
	  doInsert(){
		  var e={
		    ename:this.name,
		    sex:this.esex,
		    ephone:this.phone,
		    deptno:this.bumen,
		    jmid:this.gangwei
		  };
		   console.log(e,'e')
		   var qq=this.$Qs.stringify(e);
		   this.$axios.post("http://localhost:8888/emps/add",qq)
		   .then(r=>{
		     if(r.data.code){
		       this.dialogFormVisible=false;
		       this.getList();
		       this.name="";
		       this.esex="";
		       this.phone="";
		       this.bumen="";
			   this.gangwei="";
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
	  this.selectdept();
	  this.selectdeptno();
    }
  }
</script>

<style>
	.empsstyle .shangji{
		position: relative;
		bottom: 50px;
	}
	.empsstyle textarea{
	  resize:none
	  }
	.empsstyle .dggw {
	    position: relative;
	    bottom: 90px;
	    left: 328px;
	}
	.empsstyle .dg {
	    position: relative;
	    bottom: 43px;
	    left: 2px;
	}
	.empsstyle .yzw{
	  position: relative;
	  left: 15px;
	}
	.empsstyle .yuanjob {
	    position: relative;
	    left: 340px;
	    bottom: 50px;
	}
	.empsstyle .gw {
	    position: relative;
	    left: 320px;
	    bottom: 50px;
	}
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
	.empsstyle .yuanjob {
	    position: relative;
	    left: 340px;
	    bottom: 50px;
	}
</style>
