package com.zohn.springboot01.xdvideo.controller.admin;

import com.zohn.springboot01.xdvideo.domain.Video;
import com.zohn.springboot01.xdvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/adminVideo")
public class AdminVideoController {
    @Autowired
    private VideoService videoService;

    /**
     * @Description 根据id删除
     * @Author zohn
     * @Date 2020/2/1 16:25
     * @Param [videoId]
     * @Return java.lang.Object
     */
    @DeleteMapping("del_by_id")
    public Object delById(@RequestParam(value = "video_id", required = true) int videoId) {
        return videoService.delete(videoId);
    }


    /**
     * 用 @RequestBody的时候需要
     * 需要指定http头为 content-type为application/json charset=utf-8
     *
     */

    /**
     * @Description 修改
     * @Author zohn
     * @Date 2020/2/1 16:26
     * @Param [video02]
     * @Return java.lang.Object
     */
    @PutMapping("update_by_id")
    public Object update(@RequestBody Video video02) {
        return videoService.update(video02);
    }


    /**
     * @Description 保存
     * @Author zohn
     * @Date 2020/2/1 16:27
     * @Param [title]
     * @Return java.lang.Object
     */
    @PostMapping("save")
    public Object save(@RequestBody Video video02) {
        return videoService.save(video02);
    }


}
