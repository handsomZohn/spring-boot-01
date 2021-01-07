package com.zohn.springboot01.controller;


import com.zohn.springboot01.domain.JsonData;
import com.zohn.springboot01.domain.User;
import com.zohn.springboot01.utils.JsonUtils;
import com.zohn.springboot01.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: spring-boot整合redis
 * @Author: zohn
 * @CreateDate: 2019/3/24 20:50
 * @Version: 1.0
 */
@Controller
@RequestMapping("/api/v1/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisClient redisClient;

    @GetMapping("/add")
    @ResponseBody
    public Object add(){
        redisTemplate.opsForValue().set("name","zhangyifeng");
        return JsonData.buildSuccess("ok");
    }


    @GetMapping("/get")
    @ResponseBody
    public Object get() {
        String name = redisTemplate.opsForValue().get("name");
        return JsonData.buildError(name);
    }

    @GetMapping("/addUser")
    @ResponseBody
    public Object addUser() {
        User user = new User("zhangwuji", "abc", "12", "18310834045", new Date());
        String s = JsonUtils.obj2String(user);
        boolean flag = redisClient.set("redis:user:12", s);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping("/findUser")
    @ResponseBody
    public Object getUser(){
        String s = redisClient.get("redis:user:12");
        User user = JsonUtils.string2Obj(s, User.class);
        return JsonData.buildSuccess(user);
    }

    @GetMapping("/addUserList")
    @ResponseBody
    public Object addUserList() {
        User user = new User("zhangwuji", "abc", "12", "18310834045", new Date());
        User user02 = new User("zhangwuji", "abc", "12", "18310834045", new Date());
        User user03 = new User("zhangwuji", "abc", "12", "18310834045", new Date());
        List<User> userList = new ArrayList(){{
            add(user);
            add(user02);
            add(user03);
        }};
        String s = JsonUtils.obj2String(userList);
        boolean flag = redisClient.set("redis:user:list", s);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping("/getUserList")
    @ResponseBody
    public Object getUserList(){
        String s = redisClient.get("redis:user:list");
        ArrayList<User> userList = JsonUtils.string2Obj(s, ArrayList.class);
        return JsonData.buildSuccess(userList);
    }


}

/**
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　 ┃
 * 　　┃　　　━　　┃
 * 　　┃　┳┛　┗┳　 ┃
 * 　　┃　　　　　 ┃
 * 　　┃　　　┻　　┃
 * 　　┃　　　　　 ┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃ 神兽保佑
 * 　　　　┃　　　┃ 代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　┣┓
 * 　　　　┃　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * 实现一个 Java 版的 LRU
 * Created by zz on 2021\1\7 0007.
 */
class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int CACHE_SIZE;
    /**
     * 传递进来能缓存多少数据
     * @param cacheSize 缓存大小
     */
    public LRUCache(int cacheSize){
        // true表示让linkedHashMap按照访问顺序来排序，最近访问的排在头部，最先（老）访问的排在尾部
        super((int)Math.ceil(cacheSize/0.75) + 1, 0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        // 当map中的数据量大于指定的缓存的个数的时候，就自动删除最老的数据
        return size() > CACHE_SIZE;
    }
    public static void main(String[] args) {
        System.out.println(2>>>3);
    }
}
