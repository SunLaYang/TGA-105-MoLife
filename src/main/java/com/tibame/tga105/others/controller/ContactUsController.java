package com.tibame.tga105.others.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.tga105.others.model.dao.ContactUsRepository;
import com.tibame.tga105.others.model.entity.ContactUs;
import com.tibame.tga105.others.model.entity.PostInfo;
import com.tibame.tga105.others.service.ContactUsService;
import com.tibame.tga105.others.service.PostInfoService;

@Controller
@RequestMapping("/page/others")
public class ContactUsController {
	
    @Autowired
    private ContactUsService contactUsService;

    @Autowired
    private PostInfoService postInfoService;
    
    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    //後台留言管理首頁(讀取資料庫資料)
    @GetMapping("/24admin.chatroom.html")
    public String getAll(Model model){
        List<ContactUs> contactUsList = contactUsService.readMsg();
        model.addAttribute("contactUsList", contactUsList);
        return "24admin.chatroom";
    }

    //後台點擊回覆表單按鈕跳轉到回覆表單頁面
    @GetMapping("/24admin.reply_chatroom.html")
    public String getMsgById(Integer msgId,Model model) throws ChangeSetPersister.NotFoundException {
        ContactUs contactUs = contactUsService.readById(msgId);
        if(contactUs != null){
            model.addAttribute("contactUs",contactUs);
            return "24admin.reply_chatroom";
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    //前台聯絡我們頁面(新增表單)
    @PostMapping("/addMsg")
    public String addMsg(ContactUs contactUs){
        ContactUs contactUs1 = new ContactUs();
        contactUs1.setName(contactUs.getName());
        contactUs1.setEmail(contactUs.getEmail());

//      List<MemVO> mem = new ArrayList<MemVO>();
//      for(int i = 0; i < mem.size(); i++) {
//         if(mem.get(i).getMemEmail().equals(contactUs.getEmail())) {
//            Integer memId = contactUsRepository.getIdByEmail(contactUs.getEmail());
//            contactUs1.setMemberId(memId);
//         }else {
//            contactUs1.setMemberId(null);
//         }    
//      }

        if(contactUs.getName().equals("耿鬼")) {
        	contactUs1.setMemberId(2);
        }else {
        	contactUs1.setMemberId(null);
        }
        
        contactUs1.setChatTitle(contactUs.getChatTitle());
        contactUs1.setChatContent(contactUs.getChatContent());
        contactUs1.setCreateTime(new Date());
        contactUs1.setReplyStatus(0);
        contactUsService.createMsg(contactUs1);
        return "24contact";
    }

    //後台回覆留言表單並傳送通知信給會員
    @PostMapping("/replyMsg")
    public String updateMsg(ContactUs contactUs, PostInfo postInfo){
        if(contactUs.getMemberId() == null){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("lindali0715a@gmail.com");
            message.setTo(contactUs.getEmail());
            message.setSubject("MoLife: 聯絡我們表單回覆");
            message.setText(contactUs.getResponse());
            javaMailSender.send(message);
        }else {
        	postInfo = new PostInfo();
            postInfo.setMemberId(2);
            postInfo.setAdminId(1);
            postInfo.setInfoTitle("聯絡我們");
            postInfo.setContent(contactUs.getResponse());
            postInfo.setInfoDate(new Date());
            postInfo.setInfoStatus(0);
            postInfo.setInfoType(5);
            postInfoService.createInfo(postInfo);
        }
        contactUsService.updateById(contactUs.getMsgId(),contactUs);
        return "redirect:/page/others/24admin.chatroom.html";
    }

    //後台刪除已回覆留言
    @RequestMapping("/deleteMsg/{msgId}")
    public String deleteMsg(@PathVariable Integer msgId){
        contactUsService.deleteById(msgId);
        return "redirect:/page/others/24admin.chatroom.html";
    }

}
