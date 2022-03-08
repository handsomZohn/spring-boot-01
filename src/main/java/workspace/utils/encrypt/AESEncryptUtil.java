package workspace.utils.encrypt;

import org.apache.commons.codec.binary.Base64;
import workspace.utils.signandencrypt.RSAUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;

/**
 * @ClassName AESEncryptUtil
 * @Description TODO
 * @Date 2022/3/8 9:15
 * @Version 1.0
 **/
public class AESEncryptUtil {

    static Random random = new Random();
    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";


    /**
     * 生成AES16位随机密钥  这个就是后面几个方法里面的 pwd
     *
     * @return
     */
    public static String getAESRandomKey() {
        long l = random.nextLong();
        return String.format("%016x", l);
    }





    /**
     * 使用公钥对 AES 随机密钥进行加密生成 randomKey 调用这个方法生成 randomKey
     *
     * @param pwd
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static String encryptByRSA(String pwd, String pubKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(pubKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        byte[] bytes = encryptByRSA(pwd.getBytes(), publicK);
        String string = Base64.encodeBase64String(bytes);
        return string;
    }

    public static byte[] encryptByRSA(byte[] inputBytes, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] outputBytes = cipher.doFinal(inputBytes);
        return outputBytes;
    }

    /**
     * 使用私钥对randomKey解密获取AES密钥，这个就是pwd，那个生成的随机的密钥
     *
     * @param randomKey 传入的
     * @param privKey   私钥
     * @return pwd 随机密钥
     * @throws Exception
     */
    public static String decryptByRSA(String randomKey, String privKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        byte[] decodeRandomKey = Base64.decodeBase64(randomKey);
        byte[] pwdBytes = decryptByRSA(decodeRandomKey, privateK);
        String pwd = new String(pwdBytes);
        return pwd;
    }

    public static byte[] decryptByRSA(byte[] input, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] outputBytes = cipher.doFinal(input);
        return outputBytes;
    }





    /**
     * 使用随机密钥对业务数据加密得到 加密后字符串
     *
     * @param inputStr 要加密的字符串
     * @param pwd      AES 16位随机密钥
     * @return strEData 加密后的数据
     * @throws Exception
     */
    public static String encryptByAES(String inputStr, String pwd) throws Exception {
        byte[] byteData = inputStr.getBytes();
        byte[] bytePassword = pwd.getBytes();
        byte[] bytesEData = encryptByAES(byteData, bytePassword);
        String strEData = Base64.encodeBase64String(bytesEData);
        return strEData;
    }

    public static byte[] encryptByAES(byte[] data, byte[] pwd) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec(pwd, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] ret = cipher.doFinal(data);
        return ret;
    }


    /**
     * 使用AES密钥对加密的业务字段 解密 得到业务数据
     * @param strEData 要解密的字符串
     * @param pwd 随机密钥
     * @return strDData 解密后的数据
     * @throws Exception
     */
    public static String decryptByAESPadding(String strEData, String pwd) throws Exception{
        byte[] byteEData = Base64.decodeBase64(strEData);
        byte[] bytePwd = pwd.getBytes();
        byte[] byteDData = decryptByAESPKCS5(byteEData, bytePwd);
        String strDData = new String(byteDData);
        return strDData;
    }

    public static byte[] decryptByAESPKCS5(byte[] data, byte[] pwd) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(pwd, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] ret = cipher.doFinal(data);
        return ret;
    }
}
