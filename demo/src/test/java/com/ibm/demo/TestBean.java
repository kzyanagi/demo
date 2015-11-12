package com.ibm.demo;

import java.io.Serializable;

public class TestBean implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String aa;
	private String bb;
	public TestBean(String string, String string2) {
		aa=string;
		bb=string2;
	}
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		this.aa = aa;
	}
	public String getBb() {
		return bb;
	}
	public void setBb(String bb) {
		this.bb = bb;
	}

}
