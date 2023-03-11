package com.tibame.tga105.others.service;

import java.util.List;

import com.tibame.tga105.others.model.entity.News;

public interface NewsService {
    News createNews(News news);
    List<News> readNews();
    News readById(Integer newsId);

    void deleteById(Integer newsId);
    News updateById(Integer newsId,News news);


}
