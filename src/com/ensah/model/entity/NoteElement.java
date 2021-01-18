package com.ensah.model.entity;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class NoteElement {

	private final IntegerProperty idNoteElement;
	private final DoubleProperty noteDsElement;
	private final DoubleProperty noteExamElement;
	private final DoubleProperty noteTpElement;
	private final DoubleProperty noteProjetElement;
	private final DoubleProperty noteExposeElement;
	private final DoubleProperty noteDevoirLibreElement;
	private final IntegerProperty seanceAbsenteElement;
	private final BooleanProperty valideAvantRattrapage;
	private final DoubleProperty noteAvantRattrapage;
	private final BooleanProperty valideApresRattrapage;
	private final DoubleProperty noteApresRattrapage;
	private final DoubleProperty noteElement;
	private final IntegerProperty elementId;
	private final IntegerProperty etudiantId;

	{
		this.idNoteElement = new SimpleIntegerProperty();
		this.noteDsElement = new SimpleDoubleProperty();
		this.noteExamElement = new SimpleDoubleProperty();
		this.noteTpElement = new SimpleDoubleProperty();
		this.noteProjetElement = new SimpleDoubleProperty();
		this.noteExposeElement = new SimpleDoubleProperty();
		this.noteDevoirLibreElement = new SimpleDoubleProperty();
		this.seanceAbsenteElement = new SimpleIntegerProperty();
		this.valideAvantRattrapage = new SimpleBooleanProperty();
		this.noteAvantRattrapage = new SimpleDoubleProperty();
		this.valideApresRattrapage = new SimpleBooleanProperty();
		this.noteApresRattrapage = new SimpleDoubleProperty();
		this.noteElement = new SimpleDoubleProperty();
		this.elementId = new SimpleIntegerProperty();
		this.etudiantId = new SimpleIntegerProperty();
	}

	private NoteElement(NoteElementBuilder noteElementBuilder) {
		this.idNoteElement.set(noteElementBuilder.idNoteElement);
		this.noteDsElement.set(noteElementBuilder.noteDsElement);
		this.noteExamElement.set(noteElementBuilder.noteExamElement);
		this.noteTpElement.set(noteElementBuilder.noteTpElement);
		this.noteProjetElement.set(noteElementBuilder.noteProjetElement);
		this.noteExposeElement.set(noteElementBuilder.noteExposeElement);
		this.noteDevoirLibreElement.set(noteElementBuilder.noteDevoirLibreElement);
		this.seanceAbsenteElement.set(noteElementBuilder.seanceAbsenteElement);
		this.valideAvantRattrapage.set(noteElementBuilder.valideAvantRattrapage);
		this.noteAvantRattrapage.set(noteElementBuilder.noteAvantRattrapage);
		this.valideApresRattrapage.set(noteElementBuilder.valideApresRattrapage);
		this.noteApresRattrapage.set(noteElementBuilder.noteApresRattrapage);
		this.noteElement.set(noteElementBuilder.noteElement);
		this.elementId.set(noteElementBuilder.elementId);
		this.etudiantId.set(noteElementBuilder.etudiantId);
	}

	public static class NoteElementBuilder {

		private int idNoteElement;
		private double noteDsElement;
		private double noteExamElement;
		private double noteTpElement;
		private double noteProjetElement;
		private double noteExposeElement;
		private double noteDevoirLibreElement;
		private int seanceAbsenteElement;
		private boolean valideAvantRattrapage;
		private double noteAvantRattrapage;
		private boolean valideApresRattrapage;
		private double noteApresRattrapage;
		private double noteElement;
		private int elementId;
		private int etudiantId;

		public NoteElementBuilder setIdNoteElement(int idNoteElement) {
			this.idNoteElement = idNoteElement;
			return this;
		}

		public NoteElementBuilder setNoteDsElement(double noteDsElement) {
			this.noteDsElement = noteDsElement;
			return this;
		}

		public NoteElementBuilder setNoteExamElement(double noteExamElement) {
			this.noteExamElement = noteExamElement;
			return this;
		}

		public NoteElementBuilder setNoteTpElement(double noteTpElement) {
			this.noteTpElement = noteTpElement;
			return this;
		}

		public NoteElementBuilder setNoteProjectElement(double noteProjetElement) {
			this.noteProjetElement = noteProjetElement;
			return this;
		}

		public NoteElementBuilder setNoteExposeElement(double noteExposeElement) {
			this.noteExposeElement = noteExposeElement;
			return this;
		}

		public NoteElementBuilder setNoteDevoirLibreElement(double noteDevoirLibreElement) {
			this.noteDevoirLibreElement = noteDevoirLibreElement;
			return this;
		}

		public NoteElementBuilder setScenceAbsenteElement(int seanceAbsenteElement) {
			this.seanceAbsenteElement = seanceAbsenteElement;
			return this;
		}

		public NoteElementBuilder setValideAvantRattrapage(boolean valideAvantRattrapage) {
			this.valideAvantRattrapage = valideAvantRattrapage;
			return this;
		}

		public NoteElementBuilder setNoteAvantRattrapage(double noteAvantRattrapage) {
			this.noteAvantRattrapage = noteAvantRattrapage;
			return this;
		}

		public NoteElementBuilder setValideApresRattrapage(boolean valideApesRattrapage) {
			this.valideApresRattrapage = valideApesRattrapage;
			return this;
		}

		public NoteElementBuilder setNoteApresRattrapage(double noteApresRattrapage) {
			this.noteApresRattrapage = noteApresRattrapage;
			return this;
		}

		public NoteElementBuilder setNoteElement(double noteElement) {
			this.noteElement = noteElement;
			return this;
		}

		public NoteElementBuilder setElementId(int elementId) {
			this.elementId = elementId;
			return this;
		}

		public NoteElementBuilder setEtudiantId(int etudiantId) {
			this.etudiantId = etudiantId;
			return this;
		}

		public NoteElement build() {
			return new NoteElement(this);
		}

	}

	public IntegerProperty idNoteElementProperty() {
		return idNoteElement;
	}

	public DoubleProperty noteDsElementProperty() {
		return noteDsElement;
	}

	public DoubleProperty noteExamElementProperty() {
		return noteExamElement;
	}

	public DoubleProperty noteTpElementProperty() {
		return noteTpElement;
	}

	public DoubleProperty noteProjetElementProperty() {
		return noteProjetElement;
	}

	public DoubleProperty noteExposeElementProperty() {
		return noteExposeElement;
	}

	public DoubleProperty NoteDevoirLibreElementProperty() {
		return noteDevoirLibreElement;
	}

	public IntegerProperty seanceAbsenteElementProperty() {
		return seanceAbsenteElement;
	}

	public BooleanProperty valideAvantRattrapageProperty() {
		return valideAvantRattrapage;
	}

	public DoubleProperty noteAvantRattrapageProperty() {
		return noteAvantRattrapage;
	}

	public BooleanProperty valideApresRattrapageProperty() {
		return valideApresRattrapage;
	}

	public DoubleProperty noteApresRattrapageProperty() {
		return noteApresRattrapage;
	}

	public DoubleProperty noteElementProperty() {
		return noteElement;
	}

	public IntegerProperty elementIdProperty() {
		return elementId;
	}

	public IntegerProperty etudiantIdProperty() {
		return etudiantId;
	}

	public int getIdNoteElement() {
		return idNoteElement.get();
	}

	public double getNoteDsElement() {
		return noteDsElement.get();
	}

	public double getNoteExamElement() {
		return noteExamElement.get();
	}

	public double getNoteTpElement() {
		return noteTpElement.get();
	}

	public double getNoteProjectElement() {
		return noteProjetElement.get();
	}

	public double getNoteExposeElement() {
		return noteExposeElement.get();
	}

	public double getNoteDevoirLibreElement() {
		return noteDevoirLibreElement.get();
	}

	public int getScenceAbsenteElement() {
		return seanceAbsenteElement.get();
	}

	public boolean getValideAvantRattrapage() {
		return valideAvantRattrapage.get();
	}

	public double getNoteAvantRattrapage() {
		return noteAvantRattrapage.get();
	}

	public boolean getValideApresRattrapage() {
		return valideApresRattrapage.get();
	}

	public double getNoteApresRattrapage() {
		return noteApresRattrapage.get();
	}

	public double getNoteElement() {
		return noteElement.get();
	}

	public int getElementId() {
		return elementId.get();
	}

	public int getEtudiantId() {
		return etudiantId.get();
	}

	public void setNoteDsElement(double noteDsElement) {
		this.noteDsElement.set(noteDsElement);
	}

	public void setNoteExamElement(double noteExamElement) {
		this.noteExamElement.set(noteExamElement);
	}

	public void setNoteTpElement(double noteTpElement) {
		this.noteTpElement.set(noteTpElement);
	}

	public void setNoteProjectElement(double noteProjetElement) {
		this.noteProjetElement.set(noteProjetElement);
	}

	public void setNoteExposeElement(double noteExposeElement) {
		this.noteExposeElement.set(noteExposeElement);
	}

	public void setNoteDevoirLibreElement(double noteDevoirLibreElement) {
		this.noteDevoirLibreElement.set(noteDevoirLibreElement);
	}

	public void setScenceAbsenteElement(int seanceAbsenteElement) {
		this.seanceAbsenteElement.set(seanceAbsenteElement);
	}

	public void setValideAvantRattrapage(boolean valideAvantRattrapage) {
		this.valideAvantRattrapage.set(valideAvantRattrapage);
	}

	public void setNoteAvantRattrapage(double noteAvantRattrapage) {
		this.noteAvantRattrapage.set(noteAvantRattrapage);
	}

	public void setValideApresRattrapage(boolean valideApesRattrapage) {
		this.valideApresRattrapage.set(valideApesRattrapage);
	}

	public void setNoteApresRattrapage(double noteApresRattrapage) {
		this.noteApresRattrapage.set(noteApresRattrapage);
	}

	public void setNoteElement(double noteElement) {
		this.noteElement.set(noteElement);
	}

	public void setElementId(int elementId) {
		this.elementId.set(elementId);
	}

	public void setEtudiantId(int etudiantId) {
		this.etudiantId.set(etudiantId);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " : " + idNoteElement.get();
	}

}