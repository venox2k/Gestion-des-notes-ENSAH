package com.ensah.model.entityData;

public enum FiliereData {

	idFiliere("idFiliere"), designationFiliere("designationFiliere"),
	noteEliminatoireFiliere("noteEliminatoireFiliere"), departementId("departementId"), professeurId("professeurId");

	private String value;

	private FiliereData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
