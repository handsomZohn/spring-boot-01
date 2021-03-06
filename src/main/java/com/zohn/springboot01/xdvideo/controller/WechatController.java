package com.zohn.springboot01.xdvideo.controller;

import com.zohn.springboot01.xdvideo.config.WeChatConfig;
import com.zohn.springboot01.xdvideo.domain.JsonData;
import com.zohn.springboot01.xdvideo.domain.User;
import com.zohn.springboot01.xdvideo.service.UserService;
import com.zohn.springboot01.xdvideo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("api/v1/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private UserService userService;

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
        // 用String.format方法把，OpenQrcodeUrl中的%s被全部替换掉
        String qrcodeUrl = String.format(WeChatConfig.getOpenQrcodeUrl(), weChatConfig.getOpenAppid(), callbackurl, accessPage);

        return JsonData.buildSuccess(qrcodeUrl);
    }

    @GetMapping("login_url_red")
    public String loginUrlRed(@RequestParam(value = "access_page", required = true) String accessPage) throws UnsupportedEncodingException {

        // 开放平台重定向地址
        String redirectUrl = weChatConfig.getOpenRedirectUrl();

        // 对开放平台重定向地址进行编码（urlEncode）
        String callbackurl = URLEncoder.encode(redirectUrl, "UTF-8");

        // 获取生成二维码地址返回的地址肯定包含微信的域名
        String qrcodeUrl = String.format(WeChatConfig.getOpenQrcodeUrl(), weChatConfig.getOpenAppid(), callbackurl, accessPage);

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
    public void wechatUserCallBack(@RequestParam(value = "code", required = true) String code, String state, HttpServletResponse response) throws IOException {
        User user = userService.saveWechatUser(code);
        if (user != null) {
            //生成jwt
            String token = JwtUtils.geneJsonWebToken(user);
            // state 当前用户的页面地址，需要拼接 http://  这样才不会站内跳转
            response.sendRedirect(state + "?token=" + token + "&head_img=" + user.getHeadImg() + "&name=" + URLEncoder.encode(user.getName(), "UTF-8"));
        }
    }
}
