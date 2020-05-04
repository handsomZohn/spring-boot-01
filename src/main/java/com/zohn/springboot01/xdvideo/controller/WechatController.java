package com.zohn.springboot01.xdvideo.controller;

import com.zohn.springboot01.xdvideo.config.WeChatConfig;
import com.zohn.springboot01.xdvideo.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("api/v1/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;

    /**
     * @Description 拼装微信扫一扫登录URL
     * @Author zohn
     * @Date 2020/2/3 16:22
     * @Param [accessPage]
     * @Return net.xdclass.xdvideo.domain.JsonData
     */
    @GetMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page", required = true) String accessPage) throws UnsupportedEncodingException {

        // 开放平台重定向地址
        String redirectUrl = weChatConfig.getOpenRedirectUrl();

        // 对开放平台重定向地址进行编码（urlEncode）
        String callbackurl = URLEncoder.encode(redirectUrl, "UTF-8");

        // 获取生成二维码地址返回的地址肯定包含微信的域名
        String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(), weChatConfig.getOpenAppid(), callbackurl, accessPage);

        return JsonData.buildSuccess(qrcodeUrl);
    }

    @GetMapping("login_url_red")
    public String loginUrlRed(@RequestParam(value = "access_page", required = true) String accessPage) throws UnsupportedEncodingException {

        // 开放平台重定向地址
        String redirectUrl = weChatConfig.getOpenRedirectUrl();

        // 对开放平台重定向地址进行编码（urlEncode）
        String callbackurl = URLEncoder.encode(redirectUrl, "UTF-8");

        // 获取生成二维码地址返回的地址肯定包含微信的域名
        String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(), weChatConfig.getOpenAppid(), callbackurl, accessPage);

        return "redirect:qrcodeUrl";
    }

    /**
     * @Description 扫码登录之后的回调
     * @Author zohn
     * @Date 2020/2/9 13:36
     * @Param [code微信返回的, state, response]
     * @Return void
     */
    @GetMapping("/user/callback")
    public void wechatUserCallBack(@RequestParam(value = "code", required = true) String code, String state, HttpServletResponse response) {
        System.out.println("======^_^======变量code值为: " + code + ", 变量state值为: " + state + ", 当前类以及方法名字是: WechatController.wechatUserCallBack()");
        // 默认成功吧

        // 通过code获取access_token

    }
}
