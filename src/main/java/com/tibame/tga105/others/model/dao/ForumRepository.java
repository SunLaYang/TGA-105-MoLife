package com.tibame.tga105.others.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.others.model.entity.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer> {
    List<Forum> findAll();

    @Query(value = "select * from forum_document where forum_no = ?", nativeQuery = true)
    Forum getByForumId(Integer forumNo);
}
