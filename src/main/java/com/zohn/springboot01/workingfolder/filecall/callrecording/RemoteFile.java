package com.zohn.springboot01.workingfolder.filecall.callrecording;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *@Description 下载互联网上的文件demo
 *@CreateDate 2020\10\12 0012 17:26
 *@Author z
 *@Version 1.0
 */
public class RemoteFile {


    public static void main(String[] args) throws Exception{
        String url = "https://guiyu-java-bss-alls.oss-cn-hangzhou.aliyuncs.com/fed67e961ad741539776ea8789576d431314408595303583744.wav";
        String filePath = "E:/";
        String method = "GET";
        // saveUrlAs(url, filePath, method);
        String fileName = url.substring(url.lastIndexOf("/") + 1);
        System.out.println("======^_^======variable fileName value is : " + fileName + ", " + " current method and class name is : RemoteFile.main()");
    }

    /**
     * @功能 下载临时素材接口
     * @param filePath 文件将要保存的目录
     * @param method 请求方法，包括POST和GET
     * @param url 请求的路径
     * @return
     */

    public static String saveUrlAs(String url,String filePath,String method) throws Exception {
        //System.out.println("fileName---->"+filePath);
        //创建不同的文件夹目录
        File file=new File(filePath);
        //判断文件夹是否存在
        if (!file.exists())
        {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        String savePath = null ;
        try
        {
            // 建立链接
            URL httpUrl=new URL(url);
            conn=(HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream=conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {

                filePath += "/";

            }
            String filePathDir =  "fed67e961ad741539776ea8789576d431314408595303583744";
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            savePath = filePath+filePathDir+".wav";
            fileOut = new FileOutputStream(savePath);
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[4096];
            int length = bis.read(buf);
            //保存文件
            while(length != -1)
            {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new  Exception(e.getMessage());
        }
        return savePath;
    }
}
