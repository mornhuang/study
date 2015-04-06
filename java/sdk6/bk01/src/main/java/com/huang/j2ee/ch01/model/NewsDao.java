package com.huang.j2ee.ch01.model;

import java.util.List;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-6 下午5:47
 * Descriptions    : 学习hibernate\jpa
 */
public interface NewsDao {
    News get(int id);
    void save(News news);
    void update(News news);
    void delete(News news);
    List<News> getAll();
}
