package com.he.util;

import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.he.config.AlipayConfig;

public class AlipayUtil {

    public static String pay(HttpServletResponse response,Integer id,Integer userid,Integer menuid,Integer menusum) throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		 alipayRequest.setBizContent("{\"id\":\""+ id +"\","
                + "\"userid\":\""+ userid +"\","
                + "\"menuid\":\""+ menuid +"\","
                + "\"menusum\":\""+ menusum +"\","
                + "}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //返回
        return result;
    }
}
