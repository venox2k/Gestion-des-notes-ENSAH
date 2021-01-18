package com.ensah.model.entityData;

public enum ModuleData {

	idModule("idModule"), designationModule("designationModule"), semesterId("semesterId");

	private String value;

	private ModuleData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
