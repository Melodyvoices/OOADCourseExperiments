import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import Layout from '@/layout'
Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/Login.vue')
  },
  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [{
      path: '/home',
      name: 'home',
      component: HomeView,
      meta: { title: '首页', access: 0, affix: true }
    }]
  },
  {
    path: '/about',
    component: Layout,
    children: [{
      path: "/about",
      name: 'about',
      component: () => import('@/views/AboutView.vue'),
      meta: { title: '关于', access: 0 }
    }]
    
  },
  {
    path: '/product',
    component: Layout,
    redirect: '/product/category',
    meta: { title: '产品管理' },
    children: [{
      path: '/product/category',
      name: 'category',
      component: () => import('@/views/Category.vue'),
      meta: { title: '类别', access: 0, affix: true }
    },
    {
      path: '/product/item',
      name: 'product',
      component: () => import('@/views/Product.vue'),
      meta: { title: '产品', access: 0, affix: true }
    }]
  }
]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
  