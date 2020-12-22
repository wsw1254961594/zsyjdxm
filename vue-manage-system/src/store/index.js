import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  empno:'',
  ename:'',
  ephone:'',
  mgr:''
}

const mutations = {
  addEmp(state,payload) {
    state.empno = payload.empno
    state.ename = payload.ename
    state.ephone = payload.ephone
    state.mgr = payload.mgr
  },
  clearAll(state) {
    state.empno = ''
    state.ename = ''
    state.ephone = ''
    state.mgr = ''
  }
}

const store = new Vuex.Store({
  state,mutations
})

export default store

/*export default new Vuex.Store({
  state: {
    empno:'',
    ename:'',
    ephone:'',
    deptno:''
  },
  mutations: {
    addEmp(state,payload) {
      state.empno = payload.empno
      state.ename = payload.ename
      state.ephone = payload.ephone
      state.deptno = payload.deptno
    },
    clearAll(state) {
      state.empno = ''
      state.ename = ''
      state.ephone = ''
      state.deptno = ''
    }
  },
  actions: {
  },
  modules: {
  }
})*/
