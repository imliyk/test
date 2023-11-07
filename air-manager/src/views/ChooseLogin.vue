<template>
        <div style="height: 100vh; display: flex; align-items: center; justify-content: center; background-color: rgb(53, 131, 208);">
        <div style="display: flex;background-color: rgb(255, 255, 255); width: 50%;">
            <div style="flex: 1;">
                <img src ="@/assets/css/logo1.jpg" alt="" style="width:45vh;">
            </div>
            <div style="flex: 1;display: flex;align-items: center;justify-content: center;">
                <el-form :model="user" style="width: 80%" :rules="rules" ref="loginRef">
                    <div style="font-size: 20px; font-weight: bold;text-align: center;margin-bottom: 20px;">欢迎进入波普特酒店官网</div>
                    <div style="font-size: 20px;text-align: center;margin-bottom: 20px;">请选择您的身份</div>
                    <el-form-item>
                        <el-button type="primary" style="width: 100%" @click="$router.push('/userlogin')">住 户</el-button>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" style="width: 100%" @click="$router.push('/workerlogin')">工作人员</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: "ChooseLogin",
    data() {
        return{}
    },
    created() {

    },
    methods: {

    }
}
</script>

<style scoped>

</style>