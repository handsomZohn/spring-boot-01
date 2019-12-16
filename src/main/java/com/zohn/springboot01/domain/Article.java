package com.zohn.springboot01.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Description:elasticsearch 文章对象
 * @Author: zohn  光标放到Article类名上 Alt + Enter
 * @CreateDate: 2019/4/24 20:48
 * @Version: 1.0
 */
@Document(indexName = "blog", type = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1454460712815109249L;

    private long id;

    private String title;

    private String summary;

    private String content;

    private int pv;


    /**
     * @Description 获取id
     * @Author zohn
     * @Date 2019/4/27 6:34
     * @Param []
     * @Return long
     */
    public long getId() {
        return id;
    }

    /**
     * @Description 设置id
     * @Author zohn
     * @Date 2019/4/27 6:34
     * @Param [id]
     * @Return void
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @Description 获取文章标题
     * @Author zohn
     * @Date 2019/4/27 6:35
     * @Param []
     * @Return java.lang.String
     */
    public String getTitle() {
        return title;
    }

    /**
     * @Description 设置文章标题
     * @Author zohn
     * @Date 2019/4/27 6:35
     * @Param [title]
     * @Return void
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @Description 获取摘要
     * @Author zohn
     * @Date 2019/4/27 6:36
     * @Param []
     * @Return java.lang.String
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @Description 设置摘要
     * @Author zohn
     * @Date 2019/4/27 6:36
     * @Param [summary]
     * @Return void
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @Description 获取内容
     * @Author zohn
     * @Date 2019/4/27 6:37
     * @Param []
     * @Return java.lang.String
     */
    public String getContent() {
        return content;
    }

    /**
     * @Description 设置内容
     * @Author zohn
     * @Date 2019/4/27 6:37
     * @Param [content]
     * @Return void
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @Description getPV
     * @Author zohn
     * @Date 2019/4/27 6:38
     * @Param []
     * @Return int
     */
    public int getPv() {
        return pv;
    }

    /**
     * @Description setPV
     * @Author zohn
     * @Date 2019/4/27 6:38
     * @Param [pv]
     * @Return void
     */
    public void setPv(int pv) {
        this.pv = pv;
    }
}
