package com.huang.study.web.model;

import java.util.List;


public interface IIreportDao {
	Ireport get(int id);
	void save(Ireport test);
	void update(Ireport test);
	void delete(Ireport test);
	List<Ireport> getAll();
}
