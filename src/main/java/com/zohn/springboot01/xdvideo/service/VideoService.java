package com.zohn.springboot01.xdvideo.service;





import com.zohn.springboot01.xdvideo.domain.Video;

import java.util.List;

/**
 * 视频业务类接口
 */
public interface VideoService {

    List<Video> findAll();

    Video findById(int id);

    int update(Video Video);

    int delete(int id);

    int save(Video video);

    List<Video> fuzzyQuery(Video video);
}
