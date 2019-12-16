<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index.ftl</title>
</head>
<body>

<a href="https://blog.csdn.net/achilles12345/article/details/41820507">阅读原文</a>
index.html页面
<h2>
    前端的代码写的着实花哨~~~~
    我们看他们看不懂，他们看我们像是一样：：：：：：
</h2>

<#-- 注释模板  -->
<h3>用dollar符号＋花括号的方式取值</h3>

${r'${serverSetting.appName}'}
<h2>${serverSetting.appName}</h2>
<h2>${serverSetting.domainAddress}</h2>

<h1>显示freemarker源码</h1>
<h2>第一种方式：显示html源码，不让浏览器解析这些源码</h2>
比如显示img标签。${'<img src="picture.jpg">'?html} 这样就不会被解析

<h2>第二种方式：显示html源码 用freemarker的标签</h2>
${r'${serverSetting.appName}'}

    <#--<h2>第三种方式：显示自定义标签的</h2>
        &lt;#&ndash;<@cfw.column></@cfw.column>&ndash;&gt;

    如果要显示源码，结束的那个符号是显示不出来的，这个时候可以采用字符转义的方式，比如：

    ${'</@cfw.column'}，这样显示的结果就是：-->

</body>
</html>