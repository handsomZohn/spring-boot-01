package com.zohn.springboot01.workingfolder.yuqing;

/**
 * 舆情信息
 */
public class HitsVO {

    /**
     * 新闻摘要
     */
    private String doc_content_brief;

    /**
     * 相似度，值相同，则表示为相似新闻
     */
    private String doc_content_sign;

    /**
     * 新闻唯一ID
     */
    private String doc_id;

    /**
     * 发布时间时间戳，精确到ms
     */
    private String doc_publish_time;

    /**
     * 新闻标题
     */
    private String doc_title;

    /**
     * 原文url
     */
    private String doc_url;

    /**
     * 提及企业
     */
    private String[] entity_name;

    /**
     * 媒体的影响力得分，范围[0,10]
     */
    private String media_influence_score;

    /**
     * 媒体来源
     */
    private String media_name;

    /**
     * 指该条新闻到目前为止传播量得分，范围[0,10]
     */
    private String media_propagation_score;

    /**
     * 内容相关性，与项目所配置的关键词匹配度，范围[0,10]
     */
    private String relevance_score_fmt;

    public String getDoc_content_brief() {
        return doc_content_brief;
    }

    public void setDoc_content_brief(String doc_content_brief) {
        this.doc_content_brief = doc_content_brief;
    }

    public String getDoc_content_sign() {
        return doc_content_sign;
    }

    public void setDoc_content_sign(String doc_content_sign) {
        this.doc_content_sign = doc_content_sign;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getDoc_publish_time() {
        return doc_publish_time;
    }

    public void setDoc_publish_time(String doc_publish_time) {
        this.doc_publish_time = doc_publish_time;
    }

    public String getDoc_title() {
        return doc_title;
    }

    public void setDoc_title(String doc_title) {
        this.doc_title = doc_title;
    }

    public String getDoc_url() {
        return doc_url;
    }

    public void setDoc_url(String doc_url) {
        this.doc_url = doc_url;
    }

    public String[] getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String[] entity_name) {
        this.entity_name = entity_name;
    }

    public String getMedia_influence_score() {
        return media_influence_score;
    }

    public void setMedia_influence_score(String media_influence_score) {
        this.media_influence_score = media_influence_score;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public String getMedia_propagation_score() {
        return media_propagation_score;
    }

    public void setMedia_propagation_score(String media_propagation_score) {
        this.media_propagation_score = media_propagation_score;
    }

    public String getRelevance_score_fmt() {
        return relevance_score_fmt;
    }

    public void setRelevance_score_fmt(String relevance_score_fmt) {
        this.relevance_score_fmt = relevance_score_fmt;
    }
}
