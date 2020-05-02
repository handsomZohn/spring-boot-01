package com.zohn.springboot01.xdvideo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zohn.springboot01.xdvideo.domain.Video;
import com.zohn.springboot01.xdvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * @Description 分页接口
     * @Author zohn
     * @Date 2020/2/1 16:13
     * @Param [page, size]
     * @Return java.lang.Object
     */
    @GetMapping("page")
    public Object pageVideo(@RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "size", defaultValue = "10") int size) {
        /**
         * 加入分页
         */
        PageHelper.startPage(page, size);

        List<Video> all = videoService.findAll();

        PageInfo<Video> videoPageInfo = new PageInfo<>(all);

        // 放入map
        Map<String, Object> data = new HashMap<>();

        return new HashMap(){{
            put("total_size", videoPageInfo.getTotal());// 总条数
            put("total_page", videoPageInfo.getPages());// 总页数
            put("current_page", page);
            put("data", videoPageInfo.getList());
        }};

        // return videoPageInfo;
    }


    /**
     * @Description 根据id查询
     * @Author zohn
     * @Date 2020/2/1 16:14
     * @Param [videoId]
     * @Return java.lang.Object
     */
    @GetMapping("find_by_id")
    public Object findById(@RequestParam(value = "video_id", required = true) int videoId) {
        return videoService.findById(videoId);
    }

    /**
     * @Description 模糊查询
     * @Author zohn
     * @Date 2020/2/1 18:22
     * @Param [video]
     * @Return java.lang.Object
     */
    @GetMapping("fuzzyQuery")
    public Object fuzzyQuery(@RequestBody Video video){
        return videoService.fuzzyQuery(video);
    }
}