package com.huang.j2ee.ch01.model;

import java.util.List;


public interface IreportDao {
	Ireport get(int id);
	void save(Ireport test);
	void update(Ireport test);
	void delete(Ireport test);
	List<Ireport> getAll();
}
