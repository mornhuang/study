package com.huang.j2ee.ssh.model;

/**
 * AbstractTestIreport entity provides the base persistence definition of the
 * TestIreport entity. @author MyEclipse Persistence Tools
 */

public class IreportAbs implements java.io.Serializable {
	private static final long serialVersionUID = -3055576906053527652L;
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private String clsd;

	// Constructors

	/** default constructor */
	public IreportAbs() {
	}

	/** minimal constructor */
	public IreportAbs(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public IreportAbs(Integer id, String name, String sex,
                      Integer age, String clsd) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.clsd = clsd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getClsd() {
		return clsd;
	}

	public void setClsd(String clsd) {
		this.clsd = clsd;
	}

}