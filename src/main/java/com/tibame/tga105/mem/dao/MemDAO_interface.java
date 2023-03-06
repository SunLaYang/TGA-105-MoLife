package com.tibame.tga105.mem.dao;

import java.util.List;

import com.tibame.tga105.mem.model.MemVO;

public interface MemDAO_interface {
  void insert(MemVO paramMemVO);
  
  void update(MemVO paramMemVO);
  
  void delete(Integer paramInteger);
  
  MemVO findByPrimaryKey(Integer paramInteger);
  
  List<MemVO> getAll();
  
  MemVO login(String memEmail, String memPsd);
  
  
}