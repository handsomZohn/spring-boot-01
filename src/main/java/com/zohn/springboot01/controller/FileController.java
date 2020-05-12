package com.zohn.springboot01.controller;

import com.zohn.springboot01.domain.JsonDate;
import com.zohn.springboot01.domain.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 */
@Controller
/**
 * 读取配置文件的第一种方式 放在controller里面 使用@Value注解读取时 默认读取的是application.properties
 * @PropertySource({"classpath:resource.properties"})
 */
public class FileController {

    @RequestMapping("/api/v1/gopage")
    public Object index() {
        return "index";
    }

    /**
     * 上传存放文件的位置
     * 绝对路径 指的是物理机磁盘路径
     */
    @Value("${web.image_path}")
    private static String absoluteFilePath;

    @Autowired
    private ServerSetting serverSetting;

    private static final String OPPOSITE_FILE_PATH = "F:\\Workspace\\eclipseIDE\\spring-boot-01\\src\\main\\resources\\static\\images\\";

    @RequestMapping("/upload")
    @ResponseBody
    public JsonDate upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        absoluteFilePath = null == absoluteFilePath ? serverSetting.getFilePath() : absoluteFilePath;

        // 读取配置文件中上传文件的路径
        System.out.println("FilePathOfSetting:" + absoluteFilePath);

        // 读取到的文件路径 如果不存在（或者已存在但不是目录）就创建
        File filePath = new File(absoluteFilePath);
        if (!filePath.exists() || !filePath.isDirectory()){
            boolean mkdirs = filePath.mkdirs();
        }


        //file.isEmpty();// 是否为空
        //file.getSize();// 大小限制
        // 获取表单其他元素
        String name = request.getParameter("name");
        System.out.println("name:" + name);

        // 获取上传文件名字
        // 获取的是输入框的name属性值
        String fileName = file.getName();
        // 文件的名字
        fileName = file.getOriginalFilename();
        System.out.println("name of upload file:" + fileName);

        // 获取文件的后缀名字
        String suffixName = fileName.substring(fileName.indexOf("."));
        System.out.println("suffixName of upload file: " + suffixName);


        // 文件上传之后的路径 + 名字
        fileName = UUID.randomUUID() + suffixName;

        System.out.println("trans name of upload file: " + fileName);

        File dest = new File(absoluteFilePath + fileName);

        try {
            // 一行代码相当于后面的 upload()方法；
            file.transferTo(dest);
            JsonDate jsonDate = new JsonDate(0, fileName);
            return jsonDate;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        // No converter found for return value of type:
        // 原因是没有set和get方法
        return new JsonDate(-1, " upload file failed ", null);
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
