package com.zohn.springboot01.xdvideo.service.impl;


import com.zohn.springboot01.xdvideo.config.WeChatConfig;
import com.zohn.springboot01.xdvideo.domain.User;
import com.zohn.springboot01.xdvideo.service.UserService;
import com.zohn.springboot01.xdvideo.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service("com.zohn.springboot01.xdvideo.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private WeChatConfig weChatConfig;

    /**
     * @Description 保存用户信息
     * @Author zohn
     * @Date 2020/2/9 13:59
     * @Param [code]
     * @Return net.xdclass.xdvideo.domain.User
     */
    @Override
    public User saveWechatUser(String code) {

        // 用%s替换。
        String accessTokenUrl = String.format(WeChatConfig.getOpenAsccessTokenUrl(), weChatConfig.getOpenAppid(), weChatConfig.getOpenAppsecret(),code);
        Map<String, Object> baseMap = HttpUtils.doGet(accessTokenUrl);

        if(baseMap == null && baseMap.isEmpty()) {
            return null;
        }


        String access_token = (String) baseMap.get("access_token");
        String openid = (String) baseMap.get("openid");

        /**
         * 获取用户基本信息
         */
        String userInfoUrl = String.format(WeChatConfig.getOpenUserInfoUrl(), access_token, openid);

        Map<String, Object> userBaseMap = HttpUtils.doGet(userInfoUrl);

        if (userBaseMap == null && userBaseMap.isEmpty()) {
            return null;
        }

        // 拆解
        String nickName = (String) userBaseMap.get("nickname");
        // String sex = (String) userBaseMap.get("sex");
        Double sexTemp = (Double) userBaseMap.get("sex");
        int sex = sexTemp.intValue();
        String province = (String) userBaseMap.get("province");
        String city = (String) userBaseMap.get("city");
        String country = (String) userBaseMap.get("country");
        String headimgurl = (String) userBaseMap.get("headimgurl");

        StringBuilder stringBuilder = new StringBuilder(country).append("||");

        // 转换nickName
        try {
            nickName = new String(nickName.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 赋值为nickName为final
        String finalNickName = nickName;

        // 放入信息至user实体
        User user = new User(){{
            setName(finalNickName);
            setSex(sex);
            setCity(city);
            setHeadImg(headimgurl);
        }};

        return user;
    }
}
