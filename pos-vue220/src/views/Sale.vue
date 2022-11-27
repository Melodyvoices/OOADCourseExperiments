<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!-- 左侧商品、支付信息录入表单 -->
      <el-col :span="6" :xs="24">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>商品录入</span>
          </div>
          <el-form
            :model="enterItemForm"
            ref="enterItemForm"
            size="small"
            label-width="68px"
          >
            <el-form-item label="商品编码" prop="itemSn">
              <el-input
                v-model="enterItemForm.itemSn"
                placeholder="请输入条码"
                clearable
                @keyup.enter.native="enterItem"
              />
            </el-form-item>
            <el-form-item label="订购数量" prop="quantity">
              <el-input
                v-model="enterItemForm.quantity"
                clearable
                @keyup.enter.native="enterItem"
              />
            </el-form-item>
            <el-row :gutter="10">
              <el-col :span="12">
                <el-button
                  type="primary"
                  size="mini"
                  :disabled="step !== 2"
                  @click="enterItemHandle"
                  >ENTER ITEM</el-button
                >
              </el-col>
              <el-col :span="12">
                <el-button
                  type="warning"
                  size="mini"
                  :disabled="step !== 2 || saleItemList.length == 0"
                  @click="endSaleHandle"
                  >END SALE</el-button
                >
              </el-col>
            </el-row>
          </el-form>
        </el-card>

        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>订单支付</span>
          </div>
          <el-form
            :model="makePaymentForm"
            ref="makePaymentForm"
            size="small"
            label-width="68px"
          >
            <el-form-item label="付款金额" prop="cashTendered">
              <el-input v-model="makePaymentForm.cashTendered"></el-input>
            </el-form-item>
            <el-form-item label="找零">
              <el-input v-model="changeDue" disabled></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                type="danger"
                size="mini"
                :disabled="step !== 4"
                @click="makePaymentHandle"
                >MAKE PAYMENT</el-button
              >
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>

      <!-- 左侧商品、支付信息录入表单 -->
      <el-col :span="18" :xs="24">
        <el-descriptions border>
          <template slot="extra">
            <el-button
              type="success"
              size="small"
              round
              :disabled="step !== 1"
              @click="makeNewSaleHandle"
              >Make NEW SALE</el-button
            >
          </template>
          <el-descriptions-item label="会员">张三</el-descriptions-item>
          <el-descriptions-item label="订单号">{{
            orderInfo.saleNo
          }}</el-descriptions-item>
          <el-descriptions-item label="总金额">{{
            orderInfo.total
          }}</el-descriptions-item>
          <el-descriptions-item label="总件数">{{
            orderInfo.quantity
          }}</el-descriptions-item>
          <el-descriptions-item label="状态"
            ><el-tag size="small">{{
              orderInfo.status
            }}</el-tag></el-descriptions-item
          >
          <el-descriptions-item label="备注">暂无</el-descriptions-item>
        </el-descriptions>
        <br />
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>订单明细</span>
          </div>
          <el-table :data="saleItemList" :row-class-name="rowSaleItemIndex">
            <el-table-column
              label="序号"
              align="center"
              prop="index"
              width="55"
            />
            <el-table-column label="商品编号" align="center" prop="itemSn" />
            <el-table-column
              label="商品名称"
              align="center"
              prop="productName"
            />
            <el-table-column label="价格" align="center" prop="price" />
            <el-table-column label="数量" align="center" prop="quantity">
              <template slot-scope="scope">
                <el-input-number
                  size="mini"
                  :disabled="step !== 2"
                  v-model="scope.row.quantity"
                  @change="handleChangeQuantity(scope.row)"
                  :min="1"
                  :max="10"
                ></el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="操作"
              align="center"
              class-name="small-padding fixed-width"
            >
              <template slot-scope="scope">
                <el-button
                  size="small"
                  type="text"
                  :disabled="step !== 2"
                  icon="el-icon-delete"
                  @click="handleDelete(scope.row)"
                  >删除</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
// import * as saleFun from "@/api/sale";
import {
  makeNewSale,
  enterItem,
  endSale,
  makePayment,
  changeQuantity,
  deleteSaleItem,
} from "@/api/sale";
export default {
  name: "Sale",
  // 定义属性
  data() {
    return {
      // 当前步骤，用于控制按钮是否可用
      step: 1,
      enterItemForm: {},
      makePaymentForm: {},
      orderInfo: {},
      changeDue: 0,
      saleItemList: [],
    };
  },
  // 计算属性
  computed: {},
  // 监控data变化
  watch: {},
  // 生命周期-创建完成
  created() {},
  // 生命周期-挂载完成
  mounted() {},
  // 方法集合
  methods: {
    getSumQuantity() {
      var sum = 0;
      for (var item of this.saleItemList) {
        sum += item.quantity;
      }
      return sum;
    },
    getTotal() {
      var total = 0;
      for (var item of this.saleItemList) {
        total += item.quantity * item.price;
      }
      return total;
    },
    updateSale() {
      this.orderInfo.quantity = this.getSumQuantity();
      this.orderInfo.total = this.getTotal();
    },
    //步骤1：创建订单
    makeNewSaleHandle() {
      makeNewSale().then((response) => {
        this.clear();
        this.step = 2;
        //initialize data
        this.orderInfo = {
          saleNo: response.data.saleNo,
          total: 0,
          quantity: 0,
          status: response.data.status,
        };
      });
    },
    // 步骤2：提交输入商品
    enterItemHandle() {
      enterItem(this.enterItemForm).then((response) => {
        var saleItem = response.data;
        this.addNewSale(saleItem);
        this.updateSale();
        this.enterItemCleaner();
      });
    },
    addNewSale(saleItem) {
      //check input
      if (saleItem != null) {
        if (!this.checkIsEnteredAndMerge(saleItem.itemSn, saleItem.quantity)) {
          //if is not entered,add the new item
          this.saleItemList.push({
            itemSn: saleItem.itemSn,
            productName: saleItem.productName,
            price: saleItem.price,
            quantity: saleItem.quantity,
          });
        }
      } else {
        this.$message.warning("输入有误，请输入正确的商品编码");
      }
    },
    // check whether the item is enterd,and than merge if the items are same
    checkIsEnteredAndMerge(itemSn, newQuantity) {
      var isEnteredFlag = false;
      for (var item of this.saleItemList) {
        if (itemSn == item.itemSn) {
          isEnteredFlag = true;
          var quantity = item.quantity;
          item.quantity = quantity + newQuantity;
          break;
        }
      }
      return isEnteredFlag;
    },
    enterItemCleaner() {
      this.enterItemForm = {
        itemSn: null,
        quantity: null,
      };
    },
    // 步骤3：结束输入
    endSaleHandle() {
      this.step = 4;
      endSale().then((response) => {
        this.orderInfo = {
          saleNo: response.data.saleNo,
          total: this.getTotal(),
          quantity: this.getSumQuantity(),
          status: response.data.status,
        };
      });
    },
    // 步骤4：提交支付
    makePaymentHandle() {
      makePayment(this.makePaymentForm.cashTendered).then((response) => {
        var pay = this.makePaymentForm.cashTendered;
        var total = this.getTotal();
        var changeDue = pay - total;
        if (changeDue > 0) {
          this.makePaymentForm.changeDue = changeDue;
          this.orderInfo.status = response.data.status;
          this.step = 1;
          this.$message.success("支付成功");
        } else {
          this.$message.warning("金额不足，请重新输入");
        }
      });
    },
    // 清空界面数据
    clear() {
      this.orderInfo = {};
      this.saleItemList = [];
      this.enterItemForm = {
        itemSn: "",
        quantity: 1,
      };
      this.makePaymentForm = {
        cashTendered: 0,
      };
      this.changeDue = 0;
      this.step = 1;
    },
    //为table订单明细添加序号
    rowSaleItemIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    //change quantity
    handleChangeQuantity(row) {
      changeQuantity(row.itemSn, row.quantity);
      this.updateSale();
      this.orderInfo.quantity = this.getSumQuantity();
      this.orderInfo.total = this.getTotal();
    },
    //delete one line sale item
    handleDelete(row) {
      const productName = row.productName;
      this.$confirm('是否确认删除商品"' + productName, "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.saleItemList.splice(row.index - 1, 1);
          deleteSaleItem(row.itemSn);
          this.updateSale();
          this.$message.success("删除成功");
        })
        .catch(() => {
          this.$message.error("删除失败");
        });
    },
  },
};
</script>

<style scoped>
</style>