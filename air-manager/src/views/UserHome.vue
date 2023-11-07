<template>
  <div>
    <el-container>
      <!--侧边栏-->
      <el-aside :width="asideWidth" style="min-height: 100vh;background-color: rgb(72, 84, 121);">
        <div style="height: 60px;color: #fefcfc;display: flex; align-items: center;justify-content: center;">
          <img src="@/assets/css/logo1.jpg" alt="" style="width: 40px;height: 40px;">
          <span class="logo-title" v-show="!isCollapse">波普特酒店住户系统</span>
        </div>

        <el-menu :collapse="isCollapse" :collapse-transition="false" router background-color="rgb(72, 84, 121)"
          text-color="rgba(255,255,255,0.65)" active-text-color="#fff" style="border:none;" :default-active="$route.path">

          <el-menu-item index="/">
            <i class="el-icon-house"></i>
            <span slot="title">住户界面</span>
          </el-menu-item>

        </el-menu>

      </el-aside>

      <el-container>
        <!--头部区域-->
        <el-header>

          <i :class="collapseIcon" style="font-size: 25px" @click="handleCollapse"></i>
          <el-breadcrumb separator-class="el-icon-arrow-right" style="margin-left: 20px">
            <el-breadcrumb-item :to="{ path: '/1' }">首页1</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/2' }">活动2</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/3' }">活动3</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/4' }">活动4</el-breadcrumb-item>
          </el-breadcrumb>

          <div style="flex: 1; width: 0; display: flex; align-items: center;justify-content: flex-end">
            <el-dropdown placement="bottom">
              <img src="@/assets/css/logo1.jpg" alt="" style="width: 40px;height: 40px">
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>修改密码</el-dropdown-item>
                <el-dropdown-item @click.native="$router.push('/')">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>


        </el-header>

        <!--主体区域-->
        <el-main>

          <div style="box-shadow: 0 0 10px rgba(0,0,0,.1); padding: 10px 20px; border-radius: 5px; margin-bottom: 10px;">
            文案
          </div>

          <div style="display: flex">
            <el-card style="width: 50%;margin-right: 10px;">
              <div slot="header" class="clearfix">
                <span>
                  文案
                </span>
              </div>
              <div>
                文案
                <div style="margin-top: 20px">
                  <div style="margin: 10px 0;"><strong>文案</strong></div>
                  <el-button type="primary">按钮1</el-button>
                </div>
              </div>
            </el-card>

            
            <el-card style="width: 50%;margin-right: 10px;">
              <div slot="header" class="clearfix">
                <span>展示数据库中内容</span>
              </div>

              <div>
                <el-table :data="users">
                  <el-table-column lable ="ID" prop="id"></el-table-column>
                  <el-table-column lable ="用户名" prop="username"></el-table-column>
                  <el-table-column lable ="姓名" prop="name"></el-table-column>
                </el-table>
              </div>
            </el-card>

          </div>
        </el-main>

      </el-container>


    </el-container>
  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'UserHome',
  data() {
    return {
      isCollapse: false,
      asideWidth: '200px',
      collapseIcon: 'el-icon-s-fold',
      users: []
    }
  },

  mounted(){
    request.get('/user/selectAll').then(res =>{
      this.users = res.data
    })
  },  //数据库数据读取


  methods: {
    handleCollapse() {
      this.isCollapse = !this.isCollapse
      this.asideWidth = this.isCollapse ? '55px' : '200px'
      this.collapseIcon = this.isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'
    }
  }
}
</script>


<style>
.el-menu--inline .el-menu-item {
  background-color: #2f3443 !important;
}

.el-menu-item:hover,
.el-submenu__title:hover {
  color: #fff !important;
}

.el-menu-item.is-active {
  background-color: rgb(125, 155, 191) !important;
}

.logo-title {
  margin-left: 5px;
  font-size: 15px;
  transition: all 0.3s;
}

.el-header {
  box-shadow: 2px 0 6px rgba(0, 21, 41.35);
  display: flex;
  align-items: center;
}
</style>