package com.ensah.model.entityData;

public enum AdministrateurData {

	idAdministrateur("idAdministrateur"), utilisateurId("utilisateurId");

	private String value;

	private AdministrateurData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
