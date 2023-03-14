package com.tibame.tga105.others.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.others.model.entity.ForumReport;

@Repository
public interface ForumReportRepository extends JpaRepository<ForumReport,Integer> {
    List<ForumReport> findAll();

    @Query(value = "select * from forum_article_report where forum_article_report_no = ?", nativeQuery = true)
    ForumReport getByReportId(Integer forumArticleReportNo);
}
