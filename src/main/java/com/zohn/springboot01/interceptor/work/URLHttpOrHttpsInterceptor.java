package com.zohn.springboot01.interceptor.work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Description 内容拦截 http或者https
 * @CreateDate 2020\6\29 0029 9:38
 * @Author z
 * @Version 1.0
 */
public class URLHttpOrHttpsInterceptor implements HandlerInterceptor {

    /**
     * 日志组件
     */
    private final Logger log = LoggerFactory.getLogger(URLHttpOrHttpsInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[preHandle] executing... request uri is {}", request.getRequestURI());


        // 只对post请求做拦截校验
        String mName = "POST";
        if (mName.equals(request.getMethod())) {
            if (isJson(request)) {
                // 获取json字符串
                String jsonParam = new URLRequestWrapper(request).getBodyString();
                log.info("[preHandle] json data: {}", jsonParam);
                jsonParam = jsonParam.replaceAll("\\t", "");
                System.out.println("======^_^======variable jsonParam value is : " + jsonParam + ", " + " current method and class name is : URLHttpOrHttpsInterceptor.preHandle()");
                // 返回的json对象
                JSONObject retJson = JSON.parseObject(jsonParam);
                // 对值做校验 包含http或者https的要返回提示信息：表示不允许包含

                // boolean flag = false;

                List<String> vList = new ArrayList<>();
                retJson.forEach((k, v) -> {

                    // System.out.println(v.toString().contains("http") || v.toString().contains("http"));

                    // boolean http = v.toString().indexOf("http") != -1 || v.toString().indexOf("https") != -1;

                    // System.out.println("======^_^======variable http value is : " + http + ", " + " current method and class name is : URLHttpOrHttpsInterceptor.preHandle()");


                    //if (v.toString().contains("http") || v.toString().contains("https")) {

                    //}
                    vList.add((String) v);

                });
                // 校验验信息逻辑
                // boolean anyMatch = vList.stream().anyMatch(v -> Objects.equals(v, "http") || Objects.equals(v, "https"));
                boolean anyMatch = vList.stream().anyMatch(v -> true == isURL(v));
                if (anyMatch) {
                    //重置response
                    response.reset();
                    //设置编码格式
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json;charset=UTF-8");

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("code", "-10");
                    jsonObject.put("msg", "contains https or http");
                    jsonObject.put("success", "false");

                    PrintWriter pw = response.getWriter();
                    pw.write(jsonObject.toString());
                    pw.flush();
                    pw.close();
                    return false;
                }
            }
        }




        log.info("preHandle");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 判断本次请求的数据类型是否为json
     *
     * @param request request
     * @return boolean
     */
    private boolean isJson(HttpServletRequest request) {
        if (request.getContentType() != null) {
            return request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) ||
                    request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE);
        }

        return false;
    }

    /**
     * @Description 判断是不是网址 邮箱地址要放行
     * @Author z
     * @Date 2020\6\29 0029 13:34
     * @Param [URL]
     * @Return boolean
     */
    private boolean isURL(String URL){
        // String reg = "^(?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*([\\?&]\\w+=\\w*)*$";
        // String reg = "((?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*([\\?&]\\w+=\\w*)*)*";
        // boolean isMatch = Pattern.matches(reg, URL);

        StringBuilder builder = new StringBuilder(1024);
        // 网址协议开头
        builder.append("((https|http|ftp|rtsp|mms)?://)");
        // ftp的user@
        builder.append("(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?");
        // ----域名开始
        builder.append("(");
        // IP形式的URL
        builder.append("([0-9]{1,3}\\.){3}[0-9]{1,3}");
        // 匹配IP和DOMAIN（域名   *.*.*），不匹配*.*
        builder.append("|");
        // 域名- www.
        builder.append("([0-9a-z_!~*'()-]+\\.)+");
        // 二级域名
        builder.append("([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.");
        builder.append("[a-z]{2,6}");
        builder.append(")");
        // ----域名结束
        // 端口
        builder.append("(:[0-9]{1,4})?");

        builder.append("(");
        builder.append("(/?)");
        builder.append("|");
        builder.append("(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?");
        builder.append(")");

        String reg = builder.toString();
        boolean isMatch = Pattern.compile(reg).matcher(URL).find();
        return isMatch;
    }

    /**
     * @Description 测试main方法
     * @Author z
     * @Date 2020\6\29 0029 14:46
     * @Param [args]
     * @Return void
     */
    public static void main(String[] args) {
//        String reg = "((?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*([\\?&]\\w+=\\w*)*)";
//        boolean matches = Pattern.matches(reg, "汉字https://www.baidu.com汉字");
//        System.out.println("======^_^======variable matches value is : " + matches + ", " + " current method and class name is : URLHttpOrHttpsInterceptor.main()");
//        String url = "汉字https://www.baidu.com汉字";
//        boolean b = Pattern.compile(reg).matcher(url).find();
//        System.out.println("======^_^======variable b value is : " + b + ", " + " current method and class name is : URLHttpOrHttpsInterceptor.main()");

        /*String regex =
                "((https|http|ftp|rtsp|mms)?://)" //
                        + "?"
                        + "(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
                        + "("
                        +  "([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
                        +  "|" // 匹配IP和DOMAIN（域名   *.*.*），不匹配*.*
                        +  "([0-9a-z_!~*'()-]+\\.)+" // 域名- www.
                        +  "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
                        +  "[a-z]{2,6}"

                        +  ")" // first level domain- .com or .museum

                        +  "(:[0-9]{1,4})?"// 端口- :80
                        +  "("
                        +  "(/?)"
                        +   "|" // a slash isn't required if there is no file name
                        +   "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?"
                        +  ")";*/

        StringBuilder builder = new StringBuilder(1024);
        //
        builder.append("(((https|http|ftp|rtsp|mms)?://)");
        builder.append("?");
        // ftp的user@
        builder.append("(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?");
        // ----域名开始
        builder.append("(");
        // IP形式的URL
        builder.append("([0-9]{1,3}\\.){3}[0-9]{1,3}");
        // 匹配IP和DOMAIN（域名   *.*.*），不匹配*.*
        builder.append("|");
        // 域名- www.
        builder.append("([0-9a-z_!~*'()-]+\\.)+");
        // 二级域名
        builder.append("([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.");
        builder.append("[a-z]{2,6}");
        builder.append(")");
        // ----域名结束
        // 端口
        builder.append("(:[0-9]{1,4})?");

        builder.append("(");
        builder.append("(/?)");
        builder.append("|");
        builder.append("(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?");
        builder.append("))(?!.*.jpg.jpg)");

        String gsjj = "公司网址，www.baidu.com,请访问查看详情";

        String reg = builder.toString();

        String url = "sadfasdfasdfdsaf.jpg.jpg";
        String url02 = "18310834045@163.com";

        // 有这种的不过滤
        String regex = "^.*?(?<!.jpg.jpg)$";

        boolean b = Pattern.compile(reg).matcher(url).find();
        System.out.println("======^_^======variable b value is : " + b + ", " + " current method and class name is : URLHttpOrHttpsInterceptor.main()");

        boolean b1 = Pattern.compile(regex).matcher(url).find();

        System.out.println("======^_^======variable b1 value is : " + b1 + ", " + " current method and class name is : URLHttpOrHttpsInterceptor.main()");

        boolean b02 = Pattern.compile(reg).matcher(url02).find();
        
        System.out.println("======^_^======variable b02 value is : " + b02 + ", " + " current method and class name is : URLHttpOrHttpsInterceptor.main()");
    }
}
