import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/dashboard'
  },
  {
    path: '/',
    component: () => import('../components/common/Home'),
    meta: {title: '自述文件'},
    children: [
      {
        path: '/dashboard',
        component: () => import('../components/page/Dashboard'),
        meta: {title: '系统首页'}
      },
      {
        path: '/403',
        component: () => import('../components/page/403'),
        meta: {title: '403'}
      },
      {
        path: '404',
        component: () => import('../components/page/404'),
        meta: {title: '404'}
      },
      {
        path: '/xinjianliucheng',
        component: () => import('../components/HelloWorld'),
        meta: {title: '新建流程'}
      },
      {
        path: '/editor',
        component: () => import('../components/page/Test'),
        meta: {title: '编辑'}
      },  
	  {
        path: '/contractmenu',
        component: () => import('../components/view/ContractMenu'),
        meta: {title: '合同首页'}
      },
	  {
	    path: '/mycontract',
	    component: () => import('../components/view/MyContract'),
	    meta: {title: '我的合同'}
	  },{
	    path: '/empregular',
	    component: () => import('../components/view/Empregular'),
	    meta: {title: '员工转正'}
	  },
	  {
	    path: '/emps',
	    component: () => import('../components/view/emps'),
	    meta: {title: '员工入职'}
	  },
	  {
	    path: '/property',
	    component: () => import('../components/view/Property'),
	    meta: {title: '我的资产'}
	  },
	  {
	    path: '/asset',
	    component: () => import('../components/view/Asset'),
	    meta: {title: '资产类别'}
	  },
	  {
	    path: '/prreturn',
	    component: () => import('../components/view/Prreturn'),
	    meta: {title: '资产归还'}
	  },
	  {
	    path: '/borrow',
	    component: () => import('../components/view/Borrow'),
	    meta: {title: '资产借用'}
	  },
	  {
	    path: '/cxzc',
	    component: () => import('../components/view/Cxzc'),
	    meta: {title: '资产借用'}
	  },
	  {
	    path: '/dizhi',
	    component: () => import('../components/view/Dizhi'),
	    meta: {title: '会议室使用详情'}
	  } ,{
	    path: '/contractadd',
	    component: () => import('../components/view/ContractAdd'),
	    meta: {title: '合同起草'}
	  },{
	    path: '/changes',
	    component: () => import('../components/view/ContractChange'),
	    meta: {title: '变更申请'}
	  },{
	    path: '/contractbacklog',
	    component: () => import('../components/view/ContractBacklog'),
	    meta: {title: '我的申请'}
	  },{
	    path: '/contractpayment',
	    component: () => import('../components/view/ContractPayment'),
	    meta: {title: '付款管理'}
	  },{
	    path: '/cgpost',
	    component: () => import('../components/view/ContractCgPost'),
	    meta: {title: '采购合同申请'}
	  },{
	    path: '/contractchanges',
	    component: () => import('../components/view/Changes'),
	    meta: {title: '采购合同申请'}
	  },

        {
            path: '/leaves',
            component: () => import('../components/view/Leaves'),
            meta: {title: '请假'}
        },
        {
            path: '/workovertime',
            component: () => import('../components/view/WorkOverTime'),
            meta: {title: '加班'}
        }
	  ,
	  {
	    path: '/project',
	    component: () => import('../components/view/project'),
	    meta: {title: '项目执行'}
	  },{
	    path: '/chaxunhy',
	    component: () => import('../components/view/Chaxunhy'),
	    meta: {title: '查询会议'}
	  },
	  {
	    path: '/huiyitianjia',
	    component: () => import('../components/view/Huiyitianjia'),
	    meta: {title: '会议使用情况'}
	  },
	  {
	    path: '/tianjiahuiyi',
	    component: () => import('../components/view/Tianjiahuiyi'),
	    meta: {title: '添加会议'}
	  },
	  {
	    path: '/newitem',
	    component: () => import('../components/view/Newitem'),
	    meta: {title: '新建项目'}
	  }	,
      {
        path: '/daiban',
        component: () => import('../components/view/BackLog'),
        meta: {title: '我的待办'}
      },{
	    path: '/paymentpost',
	    component: () => import('../components/view/PaymentAdd'),
	    meta: {title: '新建付款'}
	  
      },
	   {
	    path: '/taskexecution',
	    component: () => import('../components/view/taskexecution'),
	    meta: {title: '任务执行'}
	  },
	  {
	    path: '/acceptance',
	    component: () => import('../components/view/Acceptance'),
	    meta: {title: '项目验收'}
	  } ,
	  {
	    path: '/queryitem',
	    component: () => import('../components/view/Queryitem'),
	    meta: {title: '查询项目'}
	  } 
    ]
  },
  {
    path: '/login',
    component: () => import('../components/page/Login'),
    meta: {title: '登录'}
  },
  {
    path: '*',
    redirect: '/404'
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
