package com.tibame.tga105.others.service;

import java.util.List;

import com.tibame.tga105.others.model.entity.PostInfo;

public interface PostInfoService {
    PostInfo createInfo(PostInfo postInfo);
    List<PostInfo> readInfo();
    PostInfo readById(Integer infoId);
    void deleteById(Integer infoId);
    PostInfo updateById(Integer infoId, PostInfo postInfo);
}
