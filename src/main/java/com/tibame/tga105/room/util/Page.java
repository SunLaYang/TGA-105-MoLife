package com.tibame.tga105.room.util;

import java.util.List;
import java.util.Map;

//util套件是放一些比較通用的類

//分頁用的class
public class Page<T> {

    private Integer limit;
    private Integer offset;
    private Integer total;
    private List<T> results;
    private List<Map<String, Object>> results1;
    
    
    
    
	public List<Map<String, Object>> getResults1() {
		return results1;
	}
	public void setResults1(List<Map<String, Object>> results1) {
		this.results1 = results1;
	}
	
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

    
	
}
