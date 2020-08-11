package com.qa.springboot.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117630806";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCewReUyX1hOKMSr75ejJ7OPFnGtQmUifdcA9KrWC4g77mKB8lB5tXNwtA9QdKoju1kDU1zBHUEKc9LmpWgxYXdTBgvc96Eg3RPaiPmRQSWMRNB1tKZ6DvBQOR0sj8YUCksFtWUmLMWxomAMAAbQHV2K45kcXeIGwICPyY87n0A10stxAkBGNV5przlsLOG4unsFYnalSZDEZ5LIcWkFGRq3LJGHIpbtFolZ1ThPR6kSzauHfEcPBdZ2jitBXvKCmZiA7S0BoKLCqhgxNninHRwMJ5tl/LZEhkVV/C44NDuEQURpEMzlZq4srAhDEsDN6j6cbCLSnWesc3RWip1gOujAgMBAAECggEAEcoxikrJ8gsWuxFWk+HOKe45YTsIR8zuGzGSegD3qlkywXT96JSlgNlD3Jlzsc/SalPTSgBF3KGSyTYZblq0FYhhbW/ej5rrfbq3KyawzOPS9J3OG9EaYR2UfD89MsxI0Nf+NxilePfmkKbQXD1s7EEVQ8wzSN097GKHNmzDNUS9p4fjZlEg8YRdWPgg7GorqJ6X/3rqI1uNQ08DAz7WitsjtsGNetu8/hwvl5OS9yWYB+r4rmdwuxNW+nC6+TzYJCsDEAB2v+SFCHWpUGeWzMGNn6al5SzpnA+f7V9byrdCQJVwN9Nu1rca3kZs4BHP2WiEoaMv+a+HV3hXtfiCgQKBgQDZnY9wcw3IVGb2rl6opLLQZMu6VvvklotU3ug5vKSx48DUas8a/D9fM5QpNzFXDhBT5iHmxQglbPS4EqN1OVuJ4CVxhs0Sp8mht7ngdSeZyvP66unTxn14NTfm9QAn9YMAOUuQfBVf3kSgHHYUEU/ISifHYzae3V/QoJSFO+vlNwKBgQC6waaM56424iLPyl8VUnamibg4b2sv4vvydLh9UwO2ptdQrw7SN4lXvjGB+11mKtjA2JylnyV5XfmCWohSEc4L4SF/Byzuex9j6EB0ebH0JlcMUpDtBaeiPGMbKNo0nGwaUseoxd/tiDxeeIzm9mnVJJBA7K9j+I2hemdquLzi9QKBgD25iD8QE1+4OQBNU0IofSPJA1RWadpbrSeklmASFvDyNfbKWPZBiEQboDHUmuUjcxQpGYKYbogXEI7Jkp2kaEeCUXyTDMX226VINKvq7xGbVHreePZ9vYcEKVgUNDghVkgQ+FMCLxnjNLnpeMCWbHfWONRAWvTSu+O0OIxWA8IfAoGANvGcH15V+d2j4kAmoy5ErBBee3QEM+1ytE00reJLeGQzepBWKvCd3oudIyGhw9odNPdFdtCQhNlp+7jI3GRSm1obsbSZunvMq2b794iKG0tgVsa/zovYWrmraqUlNU9D2qa6CORWUhq/sAeFZLngPw3nxsIbg6zvdi99138MSzUCgYBrbB0drLhUZh3LX88qc9McxyYIao8LbncPMpa+lbvauHv0oOWp7I+uiJKizfNDNlNaDNGS2qUhENo0Gd5+VgIPDRHqW+LWYFpUfLOLsa5S2Y/HkorM/+/DcakIhPR0R5Z+/Rgt9bkRfWQUoxCKZgUJAe264Sv6dt5AwAzpwk4Fdg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlFhZGh8lvpdlS921ETD5LeQOuk1vqiaSfDzarHadmJHEB0snIp2rjOCcfuTKsnxPV15YKxvtYUcNeUA93SsFMbxACGHIHElWlLyRjH8C+WrzJhl0aiMxf3Cs4pPxsxHBVAeWJnFI/DHLl5OemgqMSvq4zpKHq1JEtWDwGB3hVTIzVTrOwwXZxx8GvCW14U9u+8XjeVjlR9534S54gWW+TCmzFCAyvhHZ9okROZYnsYTxxaG9IKmDWakulLR8C2WqO3z+bypSfjS8xdkSwKvFKf2bCsUaD142GMcfMvZPKGXUkvkBQUBDql5M5353GjxkC4r7biLLX7uAz7keyLPbQwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8083/success/pay";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8083/success/pay";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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

