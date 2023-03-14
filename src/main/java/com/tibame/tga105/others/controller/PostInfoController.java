package com.tibame.tga105.others.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.tga105.others.model.entity.PostInfo;
import com.tibame.tga105.others.service.PostInfoService;

@Controller
@RequestMapping("/page/others")
public class PostInfoController {

   @Autowired
    private PostInfoService postInfoService;

   //前台通知信頁面(讀取資料庫)
   @GetMapping("/24post_info.html")
    public String getInfo(Model model){
      List<PostInfo> postInfoList = postInfoService.readInfo();
      model.addAttribute("postInfoList", postInfoList);
      return "24post_info";
   }

    //前台進入查閱通知信頁面(讀取資料庫)
    @GetMapping ("/24post_info.check.html")
    public String getInfoById(Integer infoId, Model model) throws ChangeSetPersister.NotFoundException {
        PostInfo postInfo = postInfoService.readById(infoId);
        if(postInfo != null){
            model.addAttribute("postInfo",postInfo);
            return "24post_info.check";
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    //前台讀取通知信更新狀態
    @RequestMapping("/updateInfo")
    public String updateInfo(PostInfo postInfo){
       postInfoService.updateById(postInfo.getInfoId(), postInfo);
       return "redirect:/page/others/24post_info.html";
    }

    //前台刪除已讀通知信
    @RequestMapping("/deleteInfo/{infoId}")
    public String deleteMsg(@PathVariable Integer infoId){
        postInfoService.deleteById(infoId);
        return "redirect:/page/others/24post_info.html";
    }

}
