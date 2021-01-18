package com.ensah.model.entityData;

public enum ElementData {

	idElement("idElement"), designationElement("designationElement"), coefficientElement("coefficientElement"),
	dsActive("dsActive"), examActive("examActive"), tpActive("tpActive"), projetActive("projetActive"),
	exposeActive("exposeActive"), devoirLibreActive("devoirLibreActive"), absenceActive("absenceActive"),
	coefficientDs("coefficientDs"), coefficientExam("coefficientExam"), coefficientTp("coefficientTp"),
	coefficientProjet("coefficientProjet"), coefficientExpose("coefficientExpose"),
	coefficientDevoirLibre("coefficientDevoirLibre"), coefficientAbsence("coefficientAbsence"), moduleId("moduleId"),
	professeurId("professeurId");

	private String value;

	private ElementData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
