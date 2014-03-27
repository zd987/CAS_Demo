package org.demo.user.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {
	private String username;
	
	private String app_attribute_1;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApp_attribute_1() {
		return app_attribute_1;
	}

	public void setApp_attribute_1(String app_attribute_1) {
		this.app_attribute_1 = app_attribute_1;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
