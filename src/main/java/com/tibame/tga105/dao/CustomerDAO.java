package com.tibame.tga105.dao;

import com.tibame.tga105.domain.CustomerBean;

public interface CustomerDAO {
	public abstract CustomerBean select(String custid);
	public abstract boolean update(byte[] password, String email,
			java.util.Date birth, String custid);
}