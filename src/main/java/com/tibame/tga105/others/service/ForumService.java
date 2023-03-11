package com.tibame.tga105.others.service;

import java.util.List;

import com.tibame.tga105.others.model.entity.Forum;

public interface ForumService {
    Forum createForum(Forum forum);
    List<Forum> readForum();
    Forum readById(Integer forumNo);
    void deleteById(Integer forumNo);
    Forum updateById(Integer forumNo, Forum forum);
}
