package com.ensah.model.entityData;

public enum NoteElementData {
	idNoteElement("idNoteElement"), noteDsElement("noteDsElement"), noteExamElement("noteExamElement"),
	noteTpElement("noteTpElement"), noteProjetElement("noteProjetElement"), noteExposeElement("noteExposeElement"),
	noteDevoirLibreElement("noteDevoirLibreElement"), scenceAbsenteElement("seanceAbsenteElement"),
	valideAvantRattrapage("valideAvantRattrapage"), noteAvantRattrapage("noteAvantRattrapage"),
	valideApresRattrapage("valideApresRattrapage"), noteApresRattrapage("noteApresRattrapage"),
	noteElement("noteElement"), elementId("elementId"), etudiantId("etudiantId");

	private String value;

	private NoteElementData(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
