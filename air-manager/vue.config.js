const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{
    port:8300
  },
  chainWebpack:config=>{
    config.plugin('html')
    .tap(args=>{
      args[0].title = "酒店温控管理系统";
      return args;
    })
  }
})
