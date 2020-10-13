package com.zohn.springboot01.file.call.callcommon;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.List;

public class MD5Utils {
    private static HashFunction HASH_FUNCTION = Hashing.md5();
    private static Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public MD5Utils() {
    }

    public static String md5(String plainText) {
        return HASH_FUNCTION.newHasher().putString(plainText, DEFAULT_CHARSET).hash().toString();
    }

    public static <T> String md5(List<T> objLst, Cover<T> cover) {
        return md5(objLst, cover, DEFAULT_CHARSET);
    }

    public static <T> String md5(List<T> objLst, Cover<T> cover, Charset charset) {
        if(objLst != null) {
            Hasher hasher = HASH_FUNCTION.newHasher();
            Charset realCharset = charset == null?DEFAULT_CHARSET:charset;
            objLst.stream().forEach((obj) -> {
                hasher.putString(cover.toString(obj), realCharset);
            });
            return hasher.hash().toString();
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(md5("111"));
    }

    public interface Cover<T> {
        String toString(T var1);
    }
}
