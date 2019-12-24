package com.zohn.springboot01.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zohn.springboot01.domain.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zohn.springboot01.domain.User;

/**
 * 测试http协议的get请求
 *
 * @author zzohn
 */
@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>();

    /**
     * 功能描述：路径中获取值
     * @param cityId
     * @param userId
     * @return
     */
	/*@RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
	public Object findUser01(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId) {
		params.clear();
		params.put("cityId", cityId);
		params.put("userId", userId);
		return params;
	}*/

    // 与上面冲突
	/*@GetMapping(path = "/{city_id}/{user_id}")
	public Object findUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId) {
		params.clear();
		params.put("cityId", cityId);
		params.put("userId", userId);
		return params;
	}*/

    /**
     * 用于取代@RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
     * 测试getMapping
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping("/v1/page_user1")
    public Object pageUser(int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("通过触发器控制~~");
        System.out.println("通过触发器控制热部署~~");
        return params;
    }

    /**
     * 默认值 ；是否是必须参数
     * 用于分页
     *
     * @param
     * @param
     * @return
     * @RequestParam(name = "")
     * name的属性值，等于url里面的=前面的属性名称
     * 若前台传递参数的名字与后台所访问方法的方法参数一致， 就不用写name=""
     * 默认值可以自己手动设定 比如分页的默认第一条开始分页 1-12为第一页
     * 默认12条数据为一页
     * 前台的url是这样写的
     * <p>
     * localhost:8080/v1/page_user2?startRows=1&pageSize=12
     */
    @GetMapping("/v1/page_user2")
    public Object pageUser2(@RequestParam(defaultValue = "1") int startRows, @RequestParam(defaultValue = "12") int pageSize) {
        params.clear();
        params.put("startRows", startRows);
        params.put("pageSize", pageSize);
        return params;
    }

    /**
     * requestbody的应用
     * bean对象传参
     * 注意：1.需要指定：http的头为application/json
     * 2.使用body传输数据
     *
     * @param user
     * @return
     */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user) {
        params.clear();
        params.put("user", user);
        return params;
    }

    /**
     * 测试获取http头信息
     *
     * @param accessToken
     * @param id
     * @return
     * @RequestHeader
     */
    @GetMapping("v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }

    /**
     * @param request
     * @return
     */
    @GetMapping("/v1/requestTest")
    public Object httpServletRequestTest(HttpServletRequest request) {
        params.clear();
        String id = request.getParameter("id");// 看着是不是超级熟悉啊 张一峰 哈哈哈
        params.put("id", id);
        return params;
    }


    @Autowired
    private  ServerSetting serverSetting;

    /**
     * @param request
     * @return
     */
    @GetMapping("/v1/serverSettingTest")
    public Object serverSettingTest(HttpServletRequest request) throws InterruptedException {
        String appName = serverSetting.getAppName();
        String da = serverSetting.getDomainAddress();

        System.out.println("Start processing----------------------------------");
        long start = System.currentTimeMillis();// 当前毫秒数::
        Thread.sleep(10000);
        System.out.println("Processed, spend time "+ (System.currentTimeMillis()-start) +"ms,return right now----------------------------------");
        // 猜测处理时间会在：假设处理一个请求需要2300ms
        // 则加上系统睡眠了10000ms
        // 预计15万ms
        // 令我没想到的是：只花费了一毫秒----------额滴歌神啊
        // 处理器处理完毕，本次处理耗时：10001毫秒，马上返回----------------------------------

        return serverSetting;
    }

    /**
     * @param request
     * @return
     */
    @GetMapping("filter/v1/serverSettingTest")
    public Object serverSettingTestFilter(HttpServletRequest request) {
        String appName = serverSetting.getAppName();
        String da = serverSetting.getDomainAddress();
        return serverSetting;
    }

    @GetMapping("api2/v1/account")
    public Object account () {
        params.put("money", 1000);
        System.out.println("GetController的account方法对应api是：：api2/v1/account");
        return params;
    }

}
