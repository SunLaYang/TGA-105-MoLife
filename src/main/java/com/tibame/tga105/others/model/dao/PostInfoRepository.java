package com.tibame.tga105.others.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.others.model.entity.PostInfo;

@Repository
public interface PostInfoRepository extends JpaRepository<PostInfo,Integer> {

    List<PostInfo> findAll();
   
    @Query(value = "select * from post_info where info_id = ?", nativeQuery = true)
    PostInfo getByInfoId(Integer infoId);

}
