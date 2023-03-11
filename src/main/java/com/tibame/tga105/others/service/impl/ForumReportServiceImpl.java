package com.tibame.tga105.others.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.others.model.dao.ForumReportRepository;
import com.tibame.tga105.others.model.entity.ForumReport;
import com.tibame.tga105.others.service.ForumReportService;

@Service
public class ForumReportServiceImpl implements ForumReportService {
	
    @Autowired
    private ForumReportRepository forumReportRepository;
    
    @Override
    public ForumReport createReport(ForumReport forumReport) {
        return forumReportRepository.save(forumReport);
    }

    @Override
    public List<ForumReport> readReport() {
        return forumReportRepository.findAll();
    }

    @Override
    public ForumReport readById(Integer forumArticleReportNo) {
        return forumReportRepository.getByReportId(forumArticleReportNo);
    }

    @Override
    public void deleteById(Integer forumArticleReportNo) {
        forumReportRepository.deleteById(forumArticleReportNo);
    }

    @Override
    public ForumReport updateById(Integer forumArticleReportNo, ForumReport forumReport) {
        ForumReport forumReport1 = forumReportRepository.findById(forumArticleReportNo).get();
        if(forumReport1 != null){
            forumReport1.setAdminId(forumReport.getAdminId());
            forumReport1.setForumArticleStatus(1);
            forumReport1.setForumArticleReportStatus(1);
            forumReport1.setForumArticleReportNo(forumArticleReportNo);
            return forumReportRepository.save(forumReport1);
        }
        return null;
    }
}
