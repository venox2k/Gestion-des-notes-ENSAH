package com.ensah.model.entityData;

public enum ConnectionData {
	driverClassName("com.mysql.jdbc.Driver"), connectionUrl("jdbc:mysql://localhost/ensah"), dbUser("root"), dbPwd("");

	private final String value;

	private ConnectionData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
