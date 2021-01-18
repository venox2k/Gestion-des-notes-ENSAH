package com.ensah.model.entityData;

public enum EtudiantData {
	idEtudiant("idEtudiant"), cneEtudiant("cneEtudiant"), cinEtudiant("cinEtudiant"), nomEtudiant("nomEtudiant"),
	prenomEtudiant("prenomEtudiant"), classeId("classeId");

	private String value;

	private EtudiantData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
