package com.huang.study.model;


/**
 * TestIreport entity. @author MyEclipse Persistence Tools
 */
public class Ireport extends AbsIreport implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Ireport() {
	}

	/** minimal constructor */
	public Ireport(Integer id) {
		super(id);
	}

	/** full constructor */
	public Ireport(Integer id, String name, String sex, Integer age,
			String clsd) {
		super(id, name, sex, age, clsd);
	}

}
