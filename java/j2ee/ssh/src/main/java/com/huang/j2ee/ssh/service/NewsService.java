package com.huang.j2ee.ssh.service;

import com.huang.j2ee.ssh.model.News;
import com.huang.j2ee.ssh.model.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
