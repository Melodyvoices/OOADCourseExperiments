<template>
  <!-- template中只允许有一对<div>标签，其他标签需要在这一对里面 -->
  <div>
    <el-row>
      <el-col :span="8">
        <span>调用后端接口</span>
      </el-col>
      <el-col :span="8">
        <!-- 加入Element UI 输入框 显示后端文本Hello SpringBoot -->
        <el-input v-model="info" class="input-text"></el-input>
      </el-col>
      <el-col :span="8">
         <!-- 加入Element UI 按钮 -->
        <el-button type="primary" @click="getInfo">点击按钮读取</el-button>
      </el-col>
    </el-row>
  </div> 
</template>

<script>
// 导入api接口，即about.js中的hello
import { hello } from "@/api/about";
export default {
  name: 'AboutView',
  data() {
    return {
      // 定义一个变量info
      info: "This is an about page",
    };
  },
  //vue生命周期钩子函数。vue实例被创建时调用
  created() {
    // this.getInfo();
  },
  // 所有的方法都写在methods中。
  methods: {
    getInfo() {
      hello().then((response) => {
        // 查看后端json数据，"Hello SpringBoot" 是在response.data.data中;
        // 但因为request.js将response = response.data，所以此处只需要写response.data;
        this.info = response.data;  
      });
    },
  },
};
</script>

<style scoped lang="scss">
  .input-text {
    font-size: 24px;
  }
</style>