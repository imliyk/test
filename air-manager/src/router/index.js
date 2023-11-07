import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    name: 'Chooselogin',
    component:()=>import('../views/ChooseLogin.vue')
  },
  {
    path: '/workerhome',
    name: 'WorkerHome',
    component:()=>import('../views/WorkerHome.vue')
  }, 
  {
    path: '/userhome',
    name: 'userhome',
    component:()=>import('../views/UserHome.vue')
  },
  {
    path:'/userlogin',
    name:'UserLogin',
    component:()=>import('../views/UserLogin.vue')
  },
  {
    path:'/userregister',
    name:'UserRegister',
    component:()=>import('../views/UserRegister.vue')
  },
  {
    path:'/workerlogin',
    name:'WorkerLogin',
    component:()=>import('../views/WorkerLogin.vue')
  },
  {
    path:'/workerregister',
    name:'WorkerRegister',
    component:()=>import('../views/WorkerRegister.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
