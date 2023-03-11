package com.tibame.tga105.others.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.tga105.others.model.entity.Forum;
import com.tibame.tga105.others.model.entity.ForumReport;
import com.tibame.tga105.others.service.ForumReportService;

@Controller
@RequestMapping("/page/others")
public class ForumReportController {
	
    @Autowired
    private ForumReportService forumReportService;

    @GetMapping("/24admin.forum.html")
    public String getReport(Model model){
        List<ForumReport> forumReportList = forumReportService.readReport();
        model.addAttribute("forumReportList", forumReportList);
        return "24admin.forum";
    }

    @GetMapping("/24admin.forum_review.html")
    public String getReportById(Integer forumArticleReportNo, Model model) throws ChangeSetPersister.NotFoundException {
        ForumReport forumReport = forumReportService.readById(forumArticleReportNo);
        if(forumReport != null){
            model.addAttribute("forumReport",forumReport);
            return "24admin.forum_review";
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @PostMapping("/addReport")
    public ForumReport addReport(Forum forum){
        ForumReport forumReport = new ForumReport();
        forumReport.setAdminId(null);
        forumReport.setForumArticleNo(forum.getForumNo());
        forumReport.setMemberId(forum.getMemberId());
        forumReport.setForumArticleReportReasonNo(forumReport.getForumArticleReportReasonNo());
        forumReport.setForumArticleReportTime(new Date());
        forumReport.setForumArticleReportStatus(0);
        forumReport.setForumArticleStatus(0);
        return forumReportService.createReport(forumReport);
    }

    @RequestMapping("/acceptReport")
    public String acceptReport(ForumReport forumReport){
    	forumReport.setForumArticleStatus(1);
        forumReportService.updateById(3, forumReport);
        return "redirect:/page/others/24admin.forum.html";
    }

    @RequestMapping("/refuseReport")
    public String refuseReport(ForumReport forumReport){
        forumReport.setForumArticleStatus(0);
        forumReportService.updateById(forumReport.getForumArticleReportNo(), forumReport);
        return "redirect:/page/others/24admin.forum.html";
    }

    @RequestMapping("/deleteReport/{forumArticleReportNo}")
    public String deleteReport(@PathVariable Integer forumArticleReportNo){
        forumReportService.deleteById(forumArticleReportNo);
        return "redirect:/page/others/24admin.forum.html";
    }
}
