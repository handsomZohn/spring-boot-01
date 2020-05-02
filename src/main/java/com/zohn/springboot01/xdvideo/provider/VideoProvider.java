package com.zohn.springboot01.xdvideo.provider;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.zohn.springboot01.xdvideo.domain.Video;
import com.zohn.springboot01.xdvideo.utils.StringHelper;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description Video构建动态sql语句
 * @Author zohn
 * @Date 2020/2/1 17:09
 * @Param
 * @Return 
 */
public class VideoProvider {

    /**
     * @Description 动态查询语句
     * @Author zohn
     * @Date 2020/2/1 17:44
     * @Param [video]
     * @Return java.lang.String
     */
    public String fuzzyQuery(final Video video){
        return new SQL(){{
            SELECT("id, title, summary, price, point");
            FROM("video");

            /**
             * 根据标题模糊查询
             */
            if (StringHelper.isNotEmpty(video.getTitle())){
                WHERE("title like '%' #{title} '%'");
            }

            /**
             * 根据概要模糊查询
             */
            if(StringHelper.isNotEmpty(video.getSummary())){
                WHERE("summary like '%' #{summary} '%'");
            }

        }}.toString();
    }
    /**
     * @Description 动态修改语句
     * @Author zohn
     * @Date 2020/2/1 17:43
     * @Param [video]
     * @Return java.lang.String
     */
    public String updateVideo(final Video video){
        return new SQL(){{
            UPDATE("video");

            /**
             * 条件写法
             */

            /**
             * 视频标题
             */
            if(video.getTitle()!= null){
                SET("title=#{title}");
            }

            /**
             * 概述
             */
            if(video.getSummary()!= null){
                SET("summary=#{summary}");
            }

            /**
             * 封面图
             */
            if(video.getCoverImg()!= null){
                SET("cover_img=#{coverImg}");
            }

            /**
             * 观看数
             */
            if(video.getViewNum()!= null){
                SET("view_num=#{viewNum}");
            }

            /**
             * 价格
             */
            if(video.getPrice()!= null){
                SET("price=#{price}");
            }

            /**
             * 发布时间
             */
            if(video.getCreateTime()!= null){
                SET("create_time=#{createTime}");
            }

            /**
             * 是否上线
             */
            if(video.getOnline()!= null){
                SET("online=#{online}");
            }

            /**
             * 评分
             */
            if(video.getPoint()!= null){
                SET("point=#{point}");
            }

            WHERE("id=#{id}");
        }}.toString();
    }

}
