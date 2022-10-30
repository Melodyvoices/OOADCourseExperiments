<template>
  <div class="about">
    <!-- 插值语法 -->
    <h1>父组件</h1>
    <input v-model="info" />
    <h4>收到子组件1传递数据为: {{ childMsg }}</h4>
    <input v-model="value" />
    <br />
    <h4>收到子组件2修改的数据为: {{ value }}</h4>
    <el-row>
      <el-col :span="12">
        <hello-son :msg="info" @out="receiveMsgFromChild"></hello-son>
      </el-col>
      <el-col :span="12">
        <hello-child v-model="value"></hello-child>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        323232
        <product-image-information :products="products"></product-image-information>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import HelloSon from "@/components/HelloSon.vue";
import HelloChild from "@/components/HelloChild.vue";
import ProductImageInformation from "@/details/ProductImageInformation.vue";
export default {
  name: "AboutView",
  components: {
    HelloSon,
    HelloChild,
    ProductImageInformation,
  },
  data() {
    return {
      info: "TO子组件1: 在做什么？",
      childMsg: "",
      value: "TO子组件2: 天气很好",
      products: [
        {
          src: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          productName: "红颈小鸟",
          price: "82.50",
          url: "/about",
        },
        {
          src: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          productName: "美丽的红颈小鸟",
          price: "820.50",
          url: "/about",
        },
        {
          src: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          productName: "韭菜畅享至尊版红颈小鸟Pro plus",
          price: "8820.50",
          url: "/about",
        },
      ],
    };
  },
  methods: {
    receiveMsgFromChild(value) {
      this.childMsg = value;
    },
  },
};
</script>
<style scoped>
.about {
  background-color: antiquewhite;
}
</style>