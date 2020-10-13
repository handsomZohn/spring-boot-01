package com.zohn.springboot01.file.call.callcommon;

/**
 *@Description 调用硅信智能 BSS 系统第三方 配置类
 *@CreateDate 2020\10\13 0013 15:25
 *@Author z
 *@Version 1.0
 */
public class CallConfig {

    /**
     * 成功码
     */
    private static final String SUCCESS_CODE = "0";

    /**
     * 授权key
     */
    private static final String ACCESSKEY = "BE44OUmaEp";

    /**
     * 加密key
     */
    private static final String SECRETKEY = "27e4600f56a4a03a7d7ab008";

    /**
     * 接口地址
     */
    private static final String INTERFACECALLURL = "https://bss.guiji.ai:18089/";

    /**
     * 签名方式
     */
    private static final String SIGNTYPE = "MD5";

    /**
     * 随机6位
     */
    private static final String NONCE = "a12345";

    /**
     * 通话记录详情url
     */
    private static final String CALLDETAILURL = "/thirdApi/bss/findCallDetailById";

    /**
     * 通话记录列表url
     */
    private static final String CALLLISTLURL = "/thirdApi/bss/findCallDetailById";

    /**
     * 验签前参数拼接
     */
    private static final String PARAMS = "accessKey=%s&nonce=%s&timestamp=%s&secretKey=%s";

    public static String getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static String getACCESSKEY() {
        return ACCESSKEY;
    }

    public static String getSECRETKEY() {
        return SECRETKEY;
    }

    public static String getINTERFACECALLURL() {
        return INTERFACECALLURL;
    }

    public static String getSIGNTYPE() {
        return SIGNTYPE;
    }

    public static String getNONCE() {
        return NONCE;
    }

    public static String getCALLDETAILURL() {
        return CALLDETAILURL;
    }

    public static String getCALLLISTLURL() {
        return CALLLISTLURL;
    }

    public static String getPARAMS() {
        return PARAMS;
    }
}
