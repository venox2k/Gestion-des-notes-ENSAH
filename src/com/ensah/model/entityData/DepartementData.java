package com.ensah.model.entityData;

public enum DepartementData {
	idDepartement("idDepartement"), designationDepartement("designationDepartement"),
	 professeurId("professeurId");

	private String value;

	private DepartementData(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
