<!--
@author: pengjia
@date: 2020/12/14
@description:
-->
<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">后台管理系统</div>
      <el-form :model="param" :rules="rules" ref="login"
               label-width="0px" class="ms-content">
        <el-form-item prop="ename">
          <el-input v-model="param.ename" placeholder="username">
            <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="password"
                    v-model="param.password" @keyup.enter.native="submitForm">
            <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
          </el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
  import {empHttp} from "../../api/emp";

  export default {
    name: "Login",
    data() {
      return {
        param : {
          ename : '',
          password : ''
        },
        rules : {
          ename : [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password : [{required: true, message: '请输入密码', trigger: 'blur'}]
        }
      }
    },
    methods : {
      submitForm() {
        this.$refs.login.validate(async valid => {
          /*if(valid) {
            this.$message.success("登录成功")
            localStorage.setItem('ms_username',this.param.username)
            this.$router.push('/')
          } else {
            this.$message.error('请输入账号和密码')
            return false
          }*/
          if (!valid) return
          empHttp.login(this.param).then(res => {
            if (res.code === 1) {
              const emp = {
                empno:res.obj.empno,
                ename:res.obj.ename,
                ephone:res.obj.ephone,
                mgr:res.obj.mgr
              }
              this.$store.commit('addEmp',emp)
              this.$router.push('/dashboard')
            } else {
              this.$message({
                message:"报错了",
                type:"error"
              })
            }
          })
        })
      }
    }
  }
</script>

<style scoped>
  .login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url("../../assets/img/login-bg.jpg");
    background-size: 100%;
  }
  .ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
  }
  .ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255,255,255,0.3);
    overflow: hidden;
  }
  .ms-content {
    padding: 30px 30px;
  }
  .login-btn {
    text-align: center;
  }
  .login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
  }

</style>
