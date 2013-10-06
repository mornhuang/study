package com.huang.j2ee.ssh.model;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-6 下午5:49
 * Descriptions    :
 */
@Repository("newsDao")
public class NewsDaoImpl extends JpaDaoSupport implements NewsDao {
    @Override
    public News get(int id) {
        return getJpaTemplate().find(News.class, id);
    }

    @Override
    public void save(News news) {
        getJpaTemplate().persist(news);
    }

    @Override
    public void update(News news) {
        getJpaTemplate().merge(news);
    }

    @Override
    public void delete(News news) {
        getJpaTemplate().remove(news);
    }

    @Override
    public List<News> getAll() {
        return getJpaTemplate().find("from News");
    }
}
