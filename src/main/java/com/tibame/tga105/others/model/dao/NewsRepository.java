package com.tibame.tga105.others.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.others.model.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {

    List<News> findAll();

    @Query(value = "select * from news where news_id = ?", nativeQuery = true)
    News getByNewsId(Integer newsId);

}
