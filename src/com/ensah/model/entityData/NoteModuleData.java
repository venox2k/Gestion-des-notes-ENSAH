package com.ensah.model.entityData;

public enum NoteModuleData {

	idNoteModule("idNoteModule"), valideAvantRattrapage("valideAvantRattrapage"),
	noteAvantRattrapage("noteAvantRattrapage"), valideApresRattrapage("valideApresRattrapage"),
	noteApresRattrapage("noteApresRattrapage"), noteModule("noteModule"), moduleId("moduleId"),
	etudiantId("etudiantId");

	private String value;

	private NoteModuleData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
