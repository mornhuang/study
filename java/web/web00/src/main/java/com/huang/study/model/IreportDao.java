package com.huang.study.model;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class IreportDao extends HibernateDaoSupport implements IIreportDao {

	@Override
	public Ireport get(int id) {
		return (Ireport)getHibernateTemplate().get(Ireport.class, id);
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

	@Override
	public List<Ireport> getAll() {
		return (List<Ireport>)getHibernateTemplate().find("from Ireport");
	}

}
