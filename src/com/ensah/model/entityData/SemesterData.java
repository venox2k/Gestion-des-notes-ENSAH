package com.ensah.model.entityData;

public enum SemesterData {
	idSemestre("idSemestre"), designationSemestre("designationSemestre"), classeId("classeId");

	private String value;

	private SemesterData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
