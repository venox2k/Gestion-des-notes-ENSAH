package com.ensah.model.entityData;

public enum UtilisateurData {

	idUtilisateur("idUtilisateur"), nomUtilisateur("nomUtilisateur"), motDePasseUtilisateur("motDePasseUtilisateur"),
	cleUtilisateur("cleUtilisateur");

	private String value;

	private UtilisateurData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
