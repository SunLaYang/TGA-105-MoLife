package com.tibame.tga105.others.service;

import java.util.List;

import com.tibame.tga105.others.model.entity.ContactUs;

public interface ContactUsService {
    ContactUs createMsg(ContactUs contactUs);
    
    List<ContactUs> readMsg();
    
    ContactUs readById(Integer msgId);
    
    void deleteById(Integer msgId);
    
    ContactUs updateById(Integer msgId, ContactUs contactUs);
}
