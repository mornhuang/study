package com.huang.study.web.model;

import java.util.List;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-6 下午5:47
 * Descriptions    :
 */
public interface NewsDao {
    News get(int id);
    void save(News news);
    void update(News news);
    void delete(News news);
    List<News> getAll();
}
