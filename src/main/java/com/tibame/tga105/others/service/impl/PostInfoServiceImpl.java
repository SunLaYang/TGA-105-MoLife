package com.tibame.tga105.others.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.others.model.dao.PostInfoRepository;
import com.tibame.tga105.others.model.entity.PostInfo;
import com.tibame.tga105.others.service.PostInfoService;

@Service
public class PostInfoServiceImpl implements PostInfoService {
	
    @Autowired
    private PostInfoRepository postInfoRepository;
    
    @Override
    public PostInfo createInfo(PostInfo postInfo) {
        return postInfoRepository.save(postInfo);
    }

    @Override
    public List<PostInfo> readInfo() {
        return postInfoRepository.findAll();
    }

    @Override
    public PostInfo readById(Integer infoId) {
        return postInfoRepository.getByInfoId(infoId);
    }

    @Override
    public void deleteById(Integer infoId) {
        postInfoRepository.deleteById(infoId);
    }

    @Override
    public PostInfo updateById(Integer infoId, PostInfo postInfo) {
        PostInfo postInfo1 = postInfoRepository.findById(infoId).get();
        if (postInfo1 != null){
            postInfo1.setInfoStatus(1);
            postInfo1.setInfoId(infoId);
            return postInfoRepository.save(postInfo1);
        }
        return null;
    }
}
