package com.huang.study.web.service;

import com.huang.study.web.model.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-6 下午6:02
 * Descriptions    :
 */
@Transactional
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public List getAll() {
        return newsDao.getAll();
    }
}
