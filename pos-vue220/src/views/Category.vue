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
          <el-form-item label="id" prop="categoryId">
            <el-input
              v-model="queryParams.categoryId"
              placeholder="请输入类别id"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="名称" prop="categoryName">
            <el-input
              v-model="queryParams.categoryName"
              placeholder="请输入类别名称"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"
            />
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
            <el-button
              type="primary"
              icon="el-icon-plus"
              size="small"
              @click="handleAdd"
              >新增</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              icon="el-icon-edit"
              size="small"
              :disabled="single"
              @click="handleUpdate"
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
            prop="categoryId"
            width="55"
          />
          <el-table-column label="名称" align="center" prop="categoryName" />
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
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryParams.pageNum"
          :page-sizes="[5, 10, 20, 50]"
          :page-size="queryParams.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
        >
        </el-pagination>
      </el-col>
    </el-row>

    <!-- 新增/修改对话框 默认不显示 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="id" prop="categoryId" v-show="idShow">
          <el-input
            v-model="form.categoryId"
            placeholder="请输入id"
          />
        </el-form-item>
        <el-form-item label="名称" prop="categoryName">
          <el-input v-model="form.categoryName" placeholder="请输入名称" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listCategoryByPage,
  delCategory,
  getCategory,
  addCategory,
  updateCategory,
} from "@/api/category";
export default {
  name: "Category",
  // 定义属性
  data() {
    return {
      idShow: true,

      // 遮罩层
      loading: false,
      // 表格数据
      dataList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 5,
        categoryId: null,
        categoryName: null,
      },
      // 下拉框选项数据
      categoryOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 总条数
      total: 0,
      // 表单
      form: {},
      // 表单校验
      rules: {
        categoryName: [
          { required: true, message: "名称不能为空", trigger: "blur" },
        ],
      },
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
      listCategoryByPage(this.queryParams).then((response) => {
        this.dataList = response.data.list;
        this.total = response.data.total;
        this.loading = false;
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
    /** 删除按钮操作 */
    handleDelete(row) {
      const categoryId = row.categoryId || this.ids;
      this.$confirm('是否确认删除ID为"' + categoryId + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return delCategory(categoryId);
        })
        .then(() => {
          this.getList(); // 刷新数据
          this.$message.success("删除成功");
        })
        .catch(() => {});
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.categoryId);
      this.single = selection.length !== 1;
    },
    /** 表单初始化 */
    resetForm() {
      // 可进行数据初始化工作
      this.form = {
        categoryId: null,
        categoryName: null,
      };
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.resetForm();
      this.idShow = false;
      this.open = true;
      this.title = "添加数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.resetForm();
      this.idShow = true;
      const categoryId = row.categoryId || this.ids;
      getCategory(categoryId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改数据";
      });
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.idShow == true) {
            updateCategory(this.form).then((response) => {
              this.$message.success(response.msg);
              this.getList();
              this.cancel();
            });
          } else {
            addCategory(this.form).then((response) => {
              this.$message.success(response.msg);
              this.getList();
              this.cancel();
            });
          }
        }
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.title = "";
      this.resetForm();
    },
    /** 处理分页 */
    handleSizeChange(val) {
      this.queryParams.pageSize = val;
      this.getList();
    },
    handleCurrentChange(val) {
      this.queryParams.pageNum = val;
      this.getList();
    },
  },
};
</script>

<style scoped lang="scss">
</style>