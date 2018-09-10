package com.zohn.springboot01.controller;

import com.zohn.springboot01.domain.JsonDate;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 */
@Controller
public class FileController {

    @RequestMapping("/api/v1/gopage")
    public Object index() {
        return "index";
    }

    // 上传存放文件的位置
    private static final String absoluteFilePath = "D:/sysfiles/";
    private static final String oppositeFilePath = "F:\\Workspace\\eclipseIDE\\spring-boot-01\\src\\main\\resources\\static\\images\\";

    @RequestMapping("/upload")
    @ResponseBody
    public JsonDate upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        //file.isEmpty();// 是否为空
        //file.getSize();// 大小限制
        // 获取表单其他元素
        String name = request.getParameter("name");
        System.out.println("name:" + name);

        // 获取上传文件名字
        String fileName = file.getName(); // 获取的是输入框的name属性值
        fileName = file.getOriginalFilename();// 文件的名字
        System.out.println("上传的文件名字为：" + fileName);

        // 获取文件的后缀名字
        String suffixName = fileName.substring(fileName.indexOf("."));
        System.out.println("上传的文件的后缀名字是：" + suffixName);


        // 文件上传之后的路径 + 名字
        fileName = UUID.randomUUID() + suffixName;

        System.out.println("转换后的文件名称:" + fileName);

        File dest = new File(absoluteFilePath + fileName);

        try {
            file.transferTo(dest);// 一行代码相当于后面的一堆 upload()方法；
            JsonDate jsonDate = new JsonDate(0, fileName);
            return jsonDate;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // No converter found for return value of type:
        // 原因是没有set和get方法
        return new JsonDate(-1, " upload file failed", null);
    }
}


/**
 * 文件上传至服务器磁盘[绝对路径]
 *
 * @param uploadFile FB获取页面传来的文件
 * @param filePath 文件要存储的位置
 * @return
 */
/*
    private String upload(FormFile uploadFile, String filePath) {
        String wjid = GenerateId.getGenerateId();// 文件id 文件名字的组成部分
        if (uploadFile != null && StringHelper.isNotEmpty(filePath) && StringHelper.isNotEmpty(wjid)) {
            try {
                String suffix = "";// 保存文件的后缀名字
                if (uploadFile.getFileName().lastIndexOf(".") != -1) {
                    suffix = uploadFile.getFileName().substring(uploadFile.getFileName().indexOf("."));
                }
                // 文件夹不存在 创建
                File dirs = new File(filePath);
                if (!dirs.exists() && !dirs.isDirectory()) {
                    dirs.mkdirs();
                }
                // 写文件
                FileOutputStream fos = new FileOutputStream(filePath + wjid + suffix);
                byte[] data = uploadFile.getFileData();
                fos.write(data);
                fos.close();
                uploadFile.destroy();
                return wjid + suffix;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }*/
