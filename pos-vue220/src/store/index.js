import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    username: 'Jack',
    token: ''
  },
  getters: {
    fullName: state =>  state.username + ' Chan',
    username: state =>  state.username,
    token: state =>  state.token
  },
  mutations: {
    SET_NAME: (state, username) => {
      state.username = username
    },
    SET_TOKEN: (state, token) => {
      state.token = token
    }
  },
  actions: {
    updateUserName({ commit }, newName) {
      commit('SET_NAME', newName)
    },
    login({ commit }, userInfo) {
      // 项目后期进行ajxa进行登录验证
      const { username, password } = userInfo
      commit('SET_NAME', username)
      commit('SET_TOKEN', 'admin_token')
    },

  },
  modules: {

  }
})
