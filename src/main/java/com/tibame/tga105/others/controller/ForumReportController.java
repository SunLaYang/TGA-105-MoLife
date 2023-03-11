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
import com.tibame.tga105.others.model.entity.PostInfo;
import com.tibame.tga105.others.service.ForumReportService;
import com.tibame.tga105.others.service.PostInfoService;

@Controller
@RequestMapping("/page/others")
public class ForumReportController {
	
    @Autowired
    private ForumReportService forumReportService;
    
    @Autowired
    private PostInfoService postInfoService;

    //後台論壇管理讀取檢舉文章(讀資料庫)
    @GetMapping("/24admin.forum.html")
    public String getReport(Model model){
        List<ForumReport> forumReportList = forumReportService.readReport();
        model.addAttribute("forumReportList", forumReportList);
        return "24admin.forum";
    }

    //後台論壇管理審核檢舉
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

    //前台新增檢舉
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

    //後台論壇管理檢舉成立
    @RequestMapping("/acceptReport")
    public String acceptReport(ForumReport forumReport, PostInfo postInfo){
    	forumReport.setForumArticleStatus(1);
        forumReportService.updateById(3, forumReport);
        
        postInfo = new PostInfo();
        postInfo.setMemberId(1);
        postInfo.setAdminId(1);
        postInfo.setInfoTitle("寵物論壇");
        postInfo.setContent("您的文章因違反規定被檢舉,已下架您的文章!");
        postInfo.setInfoDate(new Date());
        postInfo.setInfoStatus(0);
        postInfo.setInfoType(1);
        postInfoService.createInfo(postInfo);
        return "redirect:/page/others/24admin.forum.html";
    }

    //後台論壇管理檢舉不成立
    @RequestMapping("/refuseReport")
    public String refuseReport(ForumReport forumReport){
        forumReport.setForumArticleStatus(0);
        forumReportService.updateById(forumReport.getForumArticleReportNo(), forumReport);
        return "redirect:/page/others/24admin.forum.html";
    }

    //後台論壇管理下架已審核之文章 
    @RequestMapping("/deleteReport/{forumArticleReportNo}")
    public String deleteReport(@PathVariable Integer forumArticleReportNo){
        forumReportService.deleteById(forumArticleReportNo);
        return "redirect:/page/others/24admin.forum.html";
    }
}
