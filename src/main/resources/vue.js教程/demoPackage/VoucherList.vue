<!--
  - Copyright (c) 2018.
  - 北京九思金信科技有限公司对该文件内容保留所有权利。
  - 未经许可，不得私自拷贝、传播、发布、引用该文件内容，违者将被追究法律责任。
  -->

<template>
  <el-card class="joys-voucher-list">
    <ft-pagination :total="total" :current-page="pageIndex" @pageChange="loadVoucherList">
      <div slot="toolbar" class="voucher-list__toolbar">
        <el-button size="small" type="primary" icon="joys-icon-refresh" @click="loadVoucherList(pageIndex,pageSize)">
          刷新
        </el-button>
        <el-button size="small" type="primary" icon="joys-icon-accruedcharges" :loading="fnLoading" @click="sendFn()">
          发送财务
        </el-button>
        <!--新加-->
        <el-button size="small" type="primary" :loading="fnLoading" @click="reCreateVoucher()">
          重新生成
        </el-button>
        <busi-sys-select style="margin-left: 12px" v-model="cond.busiSys" @change="onBusiSysChange"/>
        <acc-md-select style="margin-left: 12px" type="org" v-model="cond.accOrgId" placeholder="请选择组织机构"
                       @change="onOrgChange"/>
        <ft-advanced-query style="margin-left: 12px;" title="请输入凭证号" @packup="packup" @load="search"/>
      </div>
      <el-row v-if="this.showQueryPanel" style="margin-bottom: 20px">
        <!--高级查询-->
        <voucher-manage-form v-model="cond" @query="search" @change="queryChange"></voucher-manage-form>
      </el-row>
      <el-table :data="voucherList" ref="voucherRef">
        <el-table-column
            type="selection"
            :disabled="false"
            width="55">
        </el-table-column>
        <el-table-column label="凭证号">
          <template slot-scope="scope">
            <el-button type="text" style="padding-left: 0;margin-left: 0" @click="showVoucher(scope.$index)">
              {{ scope.row.voucherCode }}
            </el-button>
          </template>
        </el-table-column>
        <el-table-column label="业务场景" prop="busiScenarioName"></el-table-column>
        <el-table-column label="记账日期" prop="busiDate"></el-table-column>
        <el-table-column label="借方合计（本币）" prop="debitLocalAmt" align="right">
          <template slot-scope="scope">
            <ft-number-input v-model="scope.row.debitLocalAmt" :editable="false"></ft-number-input>
          </template>
        </el-table-column>
        <el-table-column label="贷方合计（本币）" prop="creditLocalAmt" align="right">
          <template slot-scope="scope">
            <ft-number-input v-model="scope.row.creditLocalAmt" :editable="false"></ft-number-input>
          </template>
        </el-table-column>
        <el-table-column label="凭证状态" prop="voucherStatus">
          <template slot-scope="scope">
            <ft-enum-select v-model="scope.row.voucherStatus" service-name="joys-acc-engine" type-name="VoucherStatus"
                            :editing="false">
            </ft-enum-select>
          </template>
        </el-table-column>
        <el-table-column label="凭证校验" prop="voucherCheckInfo">
          <template slot-scope="scope">
            <span v-if="scope.row.voucherCheckInfo==null">
              正确
            </span>
            <span v-else style="color: red;">
              {{ scope.row.voucherCheckInfo }}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="同步标识">
          <template slot-scope="scope">
            <span v-if="scope.row.voucherStatus==='created'">
              已同步
            </span>
            <span v-else>
              未同步
            </span>
          </template>
        </el-table-column>
      </el-table>
    </ft-pagination>
  </el-card>
</template>

<script>
import AccMdSelect from "../masterData/AccMdSelect";
import BusiSysSelect from "../profile/BusiSysSelect";
import BusiScenSelect from "../profile/BusiScenSelect";
import VoucherManageForm from "./VoucherManageForm";

export default {
  name: "VoucherList",
  components: {VoucherManageForm, BusiScenSelect, BusiSysSelect, AccMdSelect},
  data() {
    return {
      cond: {
        accOrgId: null,
        accOrgCode: null,
        accOrgName: null,
        busiSys: null,
        busiScen: null,
        voucherCode: null,
      },
      showQueryPanel: false,
      querParam: {busiSys: null, busiScen: null, accPeriod: null, voucherStatus: null},
      voucherList: [],
      fnLoading: false,
      total: 0,
      pageIndex: 1,
      pageSize: 8,
      selectionDate: [],
      vouchers: [],
      voucherIndex: 0
    }
  },
  methods: {
    onOrgChange(org) {
      this.cond.accOrgCode = org.itemCode
      this.cond.accOrgNmae = org.itemName
      this.loadVoucherList()
    },
    onBusiSysChange() {
      this.loadVoucherList()
    },
    loadVoucherList(pageIndex, pageSize) {
      this.voucherList = []
      this.pageIndex = pageIndex || this.pageIndex || 1
      this.pageSize = pageSize || this.pageSize || 8
      const url = '/joys-rest/joys-acc-engine/voucher/list'
      this.$http.get(url, {
        params: {
          accOrgCode: this.cond.accOrgCode,
          busiSys: this.querParam.busiSys,
          busiScen: this.querParam.busiScen,
          code: this.querParam.filter,
          accPeriod: this.querParam.accPeriod,
          voucherStatus: this.querParam.voucherStatus,
          pageIndex: this.pageIndex,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.total = resp.body.total
        this.voucherList = resp.body.rows
      }, resp => {
        this.$message.error(resp.body.message)
      })
    },
    showVoucher(rowIndex) {
      this.$emit('showCard', this.voucherList[rowIndex])
    },
    packup(showQueryPanel) {
      this.showQueryPanel = showQueryPanel
    },
    queryChange(querParam) {
      this.querParam = querParam
      this.currentPage = 1
    },
    search(querParam) {
      this.querParam = querParam
      this.currentPage = 1
      this.loadVoucherList(this.currentPage, this.pageSize)
    },
    // 由于列表前面选择按钮和重新生成要共用，所以将:selectable='checkboxT' 放开
    checkboxT(row, rowIndex) {
      if (row.voucherStatus == 'created' || row.voucherCheckInfo === '错误') {
        return false;
      }
      return true;
    },
    sendFn() {
      this.selectionDate = this.$refs.voucherRef.selection
      if (this.selectionDate.length == 0) {
        this.$message.warning('请选择凭证数据!')
        return
      }
      this.vouchers = this.$refs.voucherRef.selection;
      // 由于列表前面选择按钮和重新生成要共用，所以将:selectable='checkboxT' 放开
      // 在此方法内部做判断 选中的数据中，已经发送过的和凭证校验错误的不能发送
      let voucherCodesError = [];
      let voucherCodesAlreadySend = [];
      this.selectionDate.forEach(item => {
        if (item.voucherStatus === 'created') {
          voucherCodesAlreadySend.push(item.voucherCode);
        }
        if (item.voucherCheckInfo === '错误') {
          voucherCodesError.push(item.voucherCode);
        }
      });

      if (voucherCodesError.length != 0) {
        this.$message.warning(voucherCodesError + '号凭证校验错误，不能发送财务!')
        return;
      }

      if (voucherCodesAlreadySend.length != 0) {
        this.$message.warning(voucherCodesAlreadySend + '号凭证已发送财务!')
        return;
      }

      this.$confirm('此操作将发送所选凭证到财务系统(<span style="color: #d62f17">财务系统凭证请自行作废</span>), 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        dangerouslyUseHTMLString: true,
        type: 'warning'
      }).then(() => {
        this.fnLoading = true;
        const url = '/joys-rest/joys-acc-engine/voucher/synchro/finance/' + this.vouchers[this.voucherIndex].voucherId;
        this.sendFnMethod(url);
      });

    },
    // 新加--重新生成凭证  前台循环生成 所选的全部生成完提示成功 中间有报错就提示是否继续=============================================
    reCreateVoucher() {
      // 判断是否勾选数据
      this.vouchers = this.$refs.voucherRef.selection;
      if (this.vouchers.length == 0) {
        this.$message.warning('请选择凭证数据！');
        return;
      }
      // 重新生成动作
      this.$confirm('此操作将重新生成选中的业务凭证, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        dangerouslyUseHTMLString: true,
        type: 'warning'
      }).then(() => {
        this.fnLoading = true;
        const url = '/joys-rest/joys-acc-engine/voucher/reCreate/byId';
        this.reCreateVoucherMethod(url);
      }).catch(() => {});
    },
    // 新加 重新生成凭证
    reCreateVoucherMethod: function (url) {
      this.$http.post(url, null, {
        params: {
          busiSys: this.vouchers[this.voucherIndex].busiSysType,
          busiScen: this.vouchers[this.voucherIndex].busiScenario,
          busiId: this.vouchers[this.voucherIndex].busiId,
          voucherId: this.vouchers[this.voucherIndex].voucherId
        }
      }).then(res => {

        //请求成功
        if (res.status === 200) {
          if (this.voucherIndex == this.vouchers.length - 1) {
            this.$message.success('所选凭证重新生成执行完毕！');
            this.fnLoading = false;
            this.voucherIndex = 0;
            this.vouchers = [];
            this.loadVoucherList(this.pageIndex, this.pageSize);
            return;
          }
          this.voucherIndex += 1;
          this.reCreateVoucherMethod(url)
        }
      }).catch(err => {
        if (err.body.message != '') {
          //请求失败提示
          this.fnLoading = false;
          this.$confirm(this.vouchers[this.voucherIndex].voucherCode + '号凭证生成失败，是否继续执行其他?', '提示', {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.fnLoading = true;
            //确认继续请求
            if (this.voucherIndex == this.vouchers.length - 1) {
              this.$message.success('所选凭证重新生成执行完毕！');
              this.fnLoading = false;
              this.voucherIndex = 0;
              this.vouchers = [];
              this.loadVoucherList(this.pageIndex, this.pageSize);
              return;
            }
            this.voucherIndex += 1;
            this.reCreateVoucherMethod(url)
          })
        }
      });
    },

    // 新加 发送凭证
    sendFnMethod(url) {
      this.$http.post(url, null, {}).then(res => {
        if (res.status === 200) {
          // 发送成功更新状态
          this.vouchers[this.voucherIndex].voucherCode = res.body.voucherCode
          this.vouchers[this.voucherIndex].voucherStatus = res.body.voucherStatus
          if (this.voucherIndex == this.vouchers.length - 1) {
            this.$message.success('所选凭证发送财务执行完毕！');
            this.fnLoading = false;
            this.voucherIndex = 0;
            this.vouchers = [];
            return;
          }
          this.voucherIndex += 1;
          this.sendFnMethod('/joys-rest/joys-acc-engine/voucher/synchro/finance/' + this.vouchers[this.voucherIndex].voucherId)
        }
      }).catch(err => {
        if (err.body.message != '') {
          this.fnLoading = false;
          //请求失败提示
          this.$confirm(this.vouchers[this.voucherIndex].voucherCode + '号凭证发送财务失败，是否继续执行其他?', '提示', {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.fnLoading = true;
            //确认继续请求
            if (this.voucherIndex == this.vouchers.length - 1) {
              this.$message.success('所选凭证发送财务执行完毕！');
              this.fnLoading = false;
              this.voucherIndex = 0;
              this.vouchers = [];
              return;
            }
            this.voucherIndex += 1;
            this.sendFnMethod('/joys-rest/joys-acc-engine/voucher/synchro/finance/' + this.vouchers[this.voucherIndex].voucherId)
          })
        }
      });
    },
  }
}
</script>

<style lang="less">
.joys-voucher-list {
  .voucher-list__toolbar {
    display: flex;
    justify-content: flex-start;
    align-items: center;
  }

  .row-bg {
    height: 50px;
    background-color: #E4E8EB;
    font-size: 13px;
    padding-left: 20px;
  }

  .el-card__body {
    padding-top: 0;
  }
}
</style>
