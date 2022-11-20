<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <!-- 搜索表单 -->
        <el-form
          :model="queryParams"
          ref="queryForm"
          :inline="true"
          label-width="68px"
        >
          <el-form-item label="编号" prop="productSn">
            <el-input
              v-model="queryParams.productSn"
              placeholder="请输入产品编号"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="名称" prop="productName">
            <el-input
              v-model="queryParams.productName"
              placeholder="请输入产品名称"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="类别" prop="categoryId">
            <el-select v-model="queryParams.categoryId" placeholder="请选择">
              <el-option
                v-for="item in categoryOptions"
                :key="item.categoryId"
                :label="item.categoryName"
                :value="item.categoryId"
              />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              icon="el-icon-search"
              size="mini"
              @click="handleQuery"
              >搜索</el-button
            >
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
              >重置</el-button
            >
          </el-form-item>
        </el-form>

        <!-- 数据操作按钮 -->
        <el-row :gutter="10">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="small"
              >新增</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" icon="el-icon-edit" size="small"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="small"
              :disabled="single"
              @click="handleDelete"
              >删除</el-button
            >
          </el-col>
        </el-row>

        <!-- 数据展示Table -->
        <el-table
          v-loading="loading"
          :data="dataList"
          @selection-change="handleSelectionChange"
        >
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column
            label="ID"
            align="center"
            prop="productId"
            width="55"
          />
          <el-table-column label="编号" align="center" prop="productSn" />
          <el-table-column label="名称" align="center" prop="productName" />
          <el-table-column label="价格" align="center" prop="price" />
          <el-table-column
            label="类别"
            align="center"
            prop="category.categoryName"
          />
          <el-table-column
            label="操作"
            align="center"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button
                size="small"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                >修改</el-button
              >
              <el-button
                size="small"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>

        <!-- 分页加载 -->
        <el-pagination> </el-pagination>
      </el-col>
    </el-row>

    <!-- 新增/修改对话框 默认不显示 -->
    <el-dialog> </el-dialog>
  </div>
</template>

<script>
import { listProductByPage, delProduct } from "@/api/product";
import { listAll } from "@/api/category";
export default {
  name: "Product",
  // 定义属性
  data() {
    return {
      // 遮罩层
      loading: false,
      // 表格数据
      dataList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productSn: null,
        productName: null,
        categoryId: null,
      },
      // 下拉框选项数据
      categoryOptions: [],
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
    };
  },
  // 计算属性，可选
  computed: {},
  // 监控data变化，可选
  watch: {},
  // 生命周期-创建完成，可选
  created() {
    this.getList();
    this.getCategoryOptions();
  },
  // 生命周期-挂载完成，可选
  mounted() {},

  // 方法集合
  methods: {
    /** 查询数据列表 */
    getList() {
      this.loading = true;
      // 结果赋值this.dataList
      listProductByPage(this.queryParams).then((response) => {
        this.dataList = response.data.list;
        this.loading = false;
      });
    },
    /** 查询下拉列表选型 */
    getCategoryOptions() {
      // 访问后端接口，查外键所有对象
      // 结果赋值this.categoryOptions
      listAll().then((response) => {
        this.categoryOptions = response.data;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },

    /** 重置按钮操作 */
    resetQuery() {
      this.$refs.queryForm.resetFields();
      this.getList();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {},
    /** 删除按钮操作 */
    handleDelete(row) {
      const productId = row.productId || this.ids;
      this.$confirm('是否确认删除ID为"' + productId + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return delProduct(productId);
        })
        .then(() => {
          this.getList(); // 刷新数据
          this.$message.success("删除成功");
        })
        .catch(() => {});
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.productId);
      this.single = selection.length !== 1;
    },
  },
};
</script>

<style scoped lang="scss">
</style>