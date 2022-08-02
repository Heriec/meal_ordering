package com.he.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *作者：AAA_有梦想一起实现
 */

public class AlipayConfig{

    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000118617828";//例：2016082600317257

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCYX8CP2Hho5TOD8v+aTHtpTabOsRKnEpMQXvRi/pQd5Dc+NB1ZGLAghG7SuetR1o+IRp1IrxlILLZ7ABub4toiNktXMYGlwMzxsX7LR/ZtGcKtKR/uhjeQYNPaeF3o2xeDKiEzAYKFiHO/5lCFTVMmejAj9IAM7p0J8wOsWS2Q0rfK7iCxeqoOKXAr+a8NVcV5OjIs+ZU4Dz17tnhkq6F1G1hhVpTOH14Ia9wiiORuUAxDIBz5cuemrgdKCEX3mV/5nulvi1Kwpsp+eDTdJ3gf7IsoOTYIqWpYthIUOTfg02Xe528fYrivmuSP4fmUeKVGDZcq8Xj36XMVLgweVaa/AgMBAAECggEAY0EsLAc0GBAFCJSHTzk2wpdkawsJPW9qAKX5x2pRjU8VdR15aIoeYHAjyHx2/u4mvPxShAAbFdqaW3DsixSwRszbMsb6zr/SQDYAg+YybUr0dtttA3DGTPPlzE/PzFi67iPJUHJRVS5XR8987/g4i73YEfO4XbQo80wrPl8wwT6fOi97OD0ZtG6ctM8f+s3thrLun9jHXbzLVC01B1aDPZLEUrv4Qhp/AC1hyHMDznsmiIqAyOwxwll+9+ZlgKR3PdJbIyth7F31oXcGFaBS1P70b63YBGfMAY1nftQErHK63GEiuFX8qeyet1kUvzBa4rDccOEk9SsZrgj4lmdC8QKBgQDYe4J/BMDMkMuu0bWQaSONKnksIodeh3XTcXiSWHcr2g6i4++w7FOmOL0+7emOV7fpcmtDY8EQgnvWCF0tXcRAe6Uzb+moYPldeaCB+2nHOdLHmbkPLtrDv8gu8kLNOvjrK7NEAPXB3AawIbpsCMNvVza3RzkGgTFRoePf40g4LQKBgQC0MGCNnIJMx5d8IUMkvAcW7RayYcMQ7m++G7N2jao1IN9Wn+3k9gMe/7CFcpNjp+asyibdFxwrj1mVPMpzVkkf0G7I/7+SA5d9Z8jXcibMfOIqa6uChvUoxB8EoQMSmela9W58Zs1D+ATwdrHuw1CY5YWfzFLjPHd+MFakaKDiGwKBgGKnVn7gAaS3z7qpYt6eq07nrjTIv3v6q11idpnqqtRXGRhuW4r7B9vWO5fz/92YZ/2A4RTi3tbRP/H3+c50zry8HDrmo0rSdpF8ngLeOgRKe53ulgEvTw6p1WZfjMXOPCWf0qAI9/YSeRHHLReSns2cpxi64mfudDVJW3lqMD05AoGAaqn0jf+m1mKUVuOtxnIT1Et20xOyEDTFKwlk2/oSVq7l5nZ3scC7qj77tJNVknmSwJhOFzSV9Wc/RWueAFaEpPOSkSNruLitlYu5RWgKdaQ7kZb5CSRwvbgTEH9rvTgk/jYpODT2r5SDAAGTZN5zuH6t8iFWs7NYnPdqYpqZGh8CgYBL6S19m5LfDf0aGTm8T/v54DLLVqknX+taipeIkC58RwLbObKbBpM0zrubPSUtV3rCMEQhlQ7wtBncvjvXrpxb/RBj8IwG2YElqhs20ZzxET6+JXgh73G0QOTwffN3OHQUPRiF9eqhkznaHtObwEgrDwNZnfrlBG7XUgMxMfRgYQ==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
    // 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmF/Aj9h4aOUzg/L/mkx7aU2mzrESpxKTEF70Yv6UHeQ3PjQdWRiwIIRu0rnrUdaPiEadSK8ZSCy2ewAbm+LaIjZLVzGBpcDM8bF+y0f2bRnCrSkf7oY3kGDT2nhd6NsXgyohMwGChYhzv+ZQhU1TJnowI/SADO6dCfMDrFktkNK3yu4gsXqqDilwK/mvDVXFeToyLPmVOA89e7Z4ZKuhdRtYYVaUzh9eCGvcIojkblAMQyAc+XLnpq4HSghF95lf+Z7pb4tSsKbKfng03Sd4H+yLKDk2CKlqWLYSFDk34NNl3udvH2K4r5rkj+H5lHilRg2XKvF49+lzFS4MHlWmvwIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 返回的时候此页面不会返回到用户页面，只会执行你写到控制器里的地址
     */
    public static String notify_url = "http://localhost:8080/orders/alipaySum";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 此页面是同步返回用户页面，也就是用户支付后看到的页面，上面的notify_url是异步返回商家操作，谢谢
     * 要是看不懂就找度娘，或者多读几遍，或者去看支付宝第三方接口API，不看API直接拿去就用，遇坑不怪别人
     */
    public static String return_url = " http://localhost:8080/menus/qiantai/allMenus";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "gbk";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 日志地址
    public static String log_path = "E:\\Study Language\\JavaProject\\MyProject\\mymeal_ordering";
    // ↑↑↑↑↑↑↑↑↑↑请在这~~
    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_"
                    + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}