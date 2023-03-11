package com.tibame.tga105.others.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.others.model.dao.ForumRepository;
import com.tibame.tga105.others.model.entity.Forum;
import com.tibame.tga105.others.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
	
    @Autowired
    private ForumRepository forumRepository;
    
    @Override
    public Forum createForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public List<Forum> readForum() {
        return forumRepository.findAll();
    }

    @Override
    public Forum readById(Integer forumNo) {
        return forumRepository.getByForumId(forumNo);
    }

    @Override
    public void deleteById(Integer forumNo) {
        forumRepository.deleteById(forumNo);
    }

    @Override
    public Forum updateById(Integer forumNo, Forum forum) {
        Forum forum1 = forumRepository.findById(forumNo).get();
        if(forum1 != null){
            forum1.setMemberId(forum.getMemberId());
            forum1.setForumTitle(forum.getForumTitle());
            forum1.setForumContent(forum.getForumContent());
            forum1.setForumCreateTime(new Date());
            forum1.setForumStatus(0);
        }
        return forumRepository.save(forum1);
    }
}
