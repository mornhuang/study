package com.huang.j2ee.ch01.service;

import com.huang.j2ee.ch01.model.News;
import com.huang.j2ee.ch01.model.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-6 下午6:02
 * Descriptions    :
 */
@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public List<News> getAll() {
        return newsDao.getAll();
    }
}
