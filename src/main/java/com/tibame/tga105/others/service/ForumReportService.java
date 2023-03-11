package com.tibame.tga105.others.service;


import java.util.List;

import com.tibame.tga105.others.model.entity.ForumReport;

public interface ForumReportService {
    ForumReport createReport(ForumReport forumReport);
    List<ForumReport> readReport();
    ForumReport readById(Integer forumArticleReportNo);
    void deleteById(Integer forumArticleReportNo);
    ForumReport updateById(Integer forumArticleReportNo, ForumReport forumReport);
}
