package com.ensah.model.entityData;

public enum ClasseData {
	idClasse("idClasse"), designationClasse("designationClasse"), filiereId(
			"filiereId");
	private String value;

	private ClasseData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}