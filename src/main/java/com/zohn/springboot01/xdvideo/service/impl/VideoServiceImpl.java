package com.zohn.springboot01.xdvideo.service.impl;


import com.zohn.springboot01.xdvideo.domain.Video;
import com.zohn.springboot01.xdvideo.mapper.VideoMapper;
import com.zohn.springboot01.xdvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;


    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(int id) {
        return videoMapper.findById(id);
    }

    @Override
    public int update(Video video) {
       return videoMapper.update(video);
    }

    @Override
    public int delete(int id) {
       return videoMapper.delete(id);
    }

    @Override
    public int save(Video video) {
        int rows = videoMapper.save(video);
        System.out.println("保存对象的id= "+video.getId());

        return rows;
    }

    @Override
    public List<Video> fuzzyQuery(Video video) {
        List<Video> videos = videoMapper.fuzzyQuery(video);
        /*if (videos != null && videos.size() > 0){
            //videos.forEach(x -> StringHelper.ntos(x));
            videos.forEach(StringHelper::ntos);
        }*/
        // return videoMapper.fuzzyQuery(video);
        return videos;
    }
}
