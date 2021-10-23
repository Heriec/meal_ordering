<form name=alipayment action=alipay.trade.page.pay.jsp method=post
      target="_blank">
  <div id="body1" class="show" name="divcontent">
    <dl class="content">
      <dt>商户订单号 ：</dt>
      <dd>
        <input id="WIDout_trade_no" name="WIDout_trade_no" />
      </dd>
      <hr class="one_line">
      <dt>用户ID ：</dt>
      <dd>
        <input id="WIDsubject" name="WIDsubject" />
      </dd>
      <hr class="one_line">
      <dt>付款金额 ：</dt>
      <dd>
        <input id="WIDtotal_amount" name="WIDtotal_amount" />
      </dd>
      <hr class="one_line">
      <dt>付款金额：</dt>
      <dd>
        <input id="WIDbody" name="WIDbody" />
      </dd>
      <hr class="one_line">
      <dt></dt>
      <dd id="btn-dd">
                        <span class="new-btn-login-sp">
                            <button class="new-btn-login" type="submit"
                                    style="text-align: center;">付 款</button>
                        </span> <span class="note-help">如果您点击“付款”按钮，即表示您同意该次的执行操作。</span>
      </dd>
    </dl>
  </div>
</form>
<!--这里的target为_blank是新打开一个窗口-->