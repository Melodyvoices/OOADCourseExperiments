<template>
  <div>
    <el-row :gutter="20">
      <el-table :data="categoryList" style="width: 100%">
        <el-table-column
          prop="categoryId"
          label="类别编号"
          align="center"
          width="100"
        ></el-table-column>
        <el-table-column
          prop="categoryName"
          label="类别名称"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="createTime"
          label="创建日期"
          width="200"
          align="center"
        ></el-table-column>
      </el-table>
    </el-row>

    <el-button
      type="primary"
      v-if="!dialogVisible"
      @click="dialogVisible = true"
      >点击打开 Dialog</el-button
    >
    <el-dialog
      title="类别表单"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose"
    >
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="类别名称" prop="categoryName">
          <el-input v-model="form.categoryName"></el-input>
        </el-form-item>
        <el-form-item label="选择类别" prop="categoryId">
          <el-select v-model="form.categoryId" placeholder="请选择">
            <el-option
              v-for="item in categoryList"
              :key="item.categoryId"
              :label="item.categoryName"
              :value="item.categoryId"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker
            v-model="form.createTime"
            type="date"
            placeholder="选择日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio :label="0">正常</el-radio>
            <el-radio :label="1">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm('form')">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { listAll } from "@/api/category";

export default {
  name: "Category",
  data() {
    return {
      categoryList: [],
      dialogVisible: false,
      form: {
        categoryName: "",
        categoryId: "",
        createTime: "",
        status: "",
      },
      rules: {
        categoryName: [
          { required: true, message: "请输入类别名称", trigger: "blur" },
          { min: 2, max: 5, message: "长度在 2 到 5 个字符", trigger: "blur" },
        ],
        categoryId: [
          { required: true, message: "请选择类别ID", trigger: "change" },
        ],
      },
    };
  },
  methods: {
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$alert(this.form);
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    getCategoryList() {
      listAll().then((response) => {
        this.categoryList = response.data;
      });
    },
  },
  created() {
    this.getCategoryList();
  },
};
</script>