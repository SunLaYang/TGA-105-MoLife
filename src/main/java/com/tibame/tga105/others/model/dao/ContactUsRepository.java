package com.tibame.tga105.others.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.others.model.entity.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Integer> {
    List<ContactUs> findAll();

    @Query(value = "select * from contact_us where msg_id = ?", nativeQuery = true)
    ContactUs getByMsgId(Integer msgId);

    @Query(value = "select member_id from member where member_email = ?", nativeQuery = true)
    Integer getIdByEmail(String memEmail);
}
