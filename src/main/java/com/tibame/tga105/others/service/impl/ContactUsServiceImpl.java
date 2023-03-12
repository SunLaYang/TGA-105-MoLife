package com.tibame.tga105.others.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.others.model.dao.ContactUsRepository;
import com.tibame.tga105.others.model.entity.ContactUs;
import com.tibame.tga105.others.service.ContactUsService;

@Service
public class ContactUsServiceImpl implements ContactUsService {
	
    @Autowired

    private ContactUsRepository contactUsRepository;

    @Override
    public ContactUs createMsg(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }

    @Override
    public List<ContactUs> readMsg() {
        return contactUsRepository.findAll();
    }

    @Override
    public ContactUs readById(Integer msgId) {
        return contactUsRepository.getByMsgId(msgId);
    }

    @Override
    public void deleteById(Integer msgId) {
        contactUsRepository.deleteById(msgId);
    }

    @Override
    public ContactUs updateById(Integer msgId, ContactUs contactUs) {
        ContactUs contactUs1 = contactUsRepository.findById(msgId).get();
        if(contactUs1 != null){
            contactUs1.setMemberId(contactUs.getMemberId());
            contactUs1.setName(contactUs.getName());
            contactUs1.setEmail(contactUs.getEmail());
            contactUs1.setChatTitle(contactUs.getChatTitle());
            contactUs1.setChatContent(contactUs.getChatContent());
            contactUs1.setReplyStatus(1);
            contactUs1.setCreateTime(new Date());
            contactUs1.setResponse(contactUs.getResponse());
            contactUs1.setMsgId(msgId);
        }
        return contactUsRepository.save(contactUs1);
    }
    
}
