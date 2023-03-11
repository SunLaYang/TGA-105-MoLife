package com.tibame.tga105.others.controller;

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

import com.tibame.tga105.mem.model.MemVO;
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
    public String addMsg(ContactUs contactUs, MemVO mem){
        ContactUs contactUs1 = new ContactUs();
        contactUs1.setName(contactUs.getName());
        contactUs1.setEmail(contactUs.getEmail());
//        if(contactUs.getEmail().equals(mem.getMemEmail())) {
//        	contactUs1.setMemberId(mem.getMemId());
//        }else {
//        	contactUs1.setMemberId(null);
//        }			
        contactUs1.setMemberId(1);
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
        contactUsService.updateById(contactUs.getMsgId(),contactUs);
        if(contactUs.getMemberId() == null){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("lindali0715a@gmail.com");
            message.setTo(contactUs.getEmail());
            message.setSubject("MoLife: 聯絡我們表單回覆");
            message.setText(contactUs.getResponse());
            javaMailSender.send(message);
        }
        return "redirect:/page/others/24admin.chatroom.html";
    }

    //後台刪除已回覆留言
    @RequestMapping("/deleteMsg/{msgId}")
    public String deleteMsg(@PathVariable Integer msgId){
        contactUsService.deleteById(msgId);
        return "redirect:/page/others/24admin.chatroom.html";
    }

}
