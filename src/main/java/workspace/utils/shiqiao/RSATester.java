package workspace.utils.shiqiao;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @ClassName RSATester
 * @Description 测试类
 * @Date 2022/3/5 11:39
 * @Version 1.0
 **/
public class RSATester {
    static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{
        testSign();
    }



    public static void testSign() throws Exception{
        String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCv4ZEZYxId22hr+GEdhER6zHJ47DkD6fxVsMsea+JlqQcK+CULrfRQTA5RD2i/JKIkRse1xXTH/RYFhEJ8rtrB0KZbJE9/UEGa522VtA7F++pXdDUDRVSsWOrXt2O3ZPllDn1pmzpNRIWclyr6HkqqAt0ke11Yt1Z6sAJPDF+GCQIDAQAB";
        String privKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK/hkRljEh3baGv4YR2ERHrMcnjsOQPp/FWwyx5r4mWpBwr4JQut9FBMDlEPaL8koiRGx7XFdMf9FgWEQnyu2sHQplskT39QQZrnbZW0DsX76ld0NQNFVKxY6te3Y7dk+WUOfWmbOk1EhZyXKvoeSqoC3SR7XVi3VnqwAk8MX4YJAgMBAAECgYB5vYWE8AlTN1KxIYx/NNV9tlQqFUBl0ClEWwpNdVmRCo2Ab0CdM/xfNDXYr/TOEZpVx9RmolVyNGFw0hp/WTy7M1Zq0itfq3uMox2XhlTJo+6OAIzWuDtcm6onai+uEms2Am/Poupj8rYJue28I8CMDKVveFekLs6jLA+zIman/QJBANg6nuGzUeMCw8Nz49hwqaJ4MusayOrUEWQqvhdXFqrKK3lfu57V96NZEC2/vfkexowaxwGFjBD1H2u1pLfyQXcCQQDQOx9fDqMY7TyU+J/iWqIX1cKBCfqq8UPEEnKYuUSqn8YXzlbR7Op+z8fGSJQiQW4tPvs1kxU0QtwhDT59elR/AkBU3Z0iRHktOhaPjdqtRnqt07NYZyjYUeeJguUc0AeLfNHXT2WaD6ykJf6dlhX/wr52msPkqv+wYCS255IAyEo9AkEAwxYhFhXIiBn7oDYu1QrEwj/qsqp+xpizPIdsBdnNk22NUdBnVtX3/Eb+i66D2nQinRFcmZzrSMM7KVwXJ8fsUQJAbEHSEBR1dh5Zaj9+z1d+MKsuDXr8NPjQIWOT7mewSKBr5MJT+74+KEXx6ecEBQx2r/b89D2LpE22uC0H4kx6qg==";
        System.err.println("私钥加密——公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, pubKey);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSAUtils.sign(encodedData, privKey);
        System.err.println("签名:\r" + sign);
        boolean status = RSAUtils.verify(encodedData, pubKey, sign);
        System.err.println("验证结果:\r" + status);
    }
}
