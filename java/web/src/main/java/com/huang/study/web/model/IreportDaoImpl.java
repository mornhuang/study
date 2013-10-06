package com.huang.study.web.model;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class IreportDaoImpl extends HibernateDaoSupport implements IreportDao {

	@Override
	public Ireport get(int id) {
		return getHibernateTemplate().get(Ireport.class, id);
	}

	@Override
	public void save(Ireport test) {
		getHibernateTemplate().save(test);

	}

	@Override
	public void update(Ireport test) {
		getHibernateTemplate().update(test);

	}

	@Override
	public void delete(Ireport test) {
		getHibernateTemplate().delete(test);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ireport> getAll() {
		return (List<Ireport>)getHibernateTemplate().find("from Ireport");
	}

}
