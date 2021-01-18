package com.ensah.model.entity;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class NoteModule {

	private final IntegerProperty idNoteModule;
	private final BooleanProperty valideAvantRattrapage;
	private final DoubleProperty noteAvantRattrapage;
	private final BooleanProperty valideApresRattrapage;
	private final DoubleProperty noteApresRattrapage;
	private final DoubleProperty noteModule;
	private final IntegerProperty moduleId;
	private final IntegerProperty etudiantId;

	{
		this.idNoteModule = new SimpleIntegerProperty();
		this.valideAvantRattrapage = new SimpleBooleanProperty();
		this.noteAvantRattrapage = new SimpleDoubleProperty();
		this.valideApresRattrapage = new SimpleBooleanProperty();
		this.noteApresRattrapage = new SimpleDoubleProperty();
		this.noteModule = new SimpleDoubleProperty();
		this.moduleId = new SimpleIntegerProperty();
		this.etudiantId = new SimpleIntegerProperty();
	}

	private NoteModule(NoteModuleBuilder noteModuleBuilder) {
		this.idNoteModule.set(noteModuleBuilder.idNoteModule);
		this.valideAvantRattrapage.set(noteModuleBuilder.valideAvantRattrapage);
		this.noteAvantRattrapage.set(noteModuleBuilder.noteAvantRattrapage);
		this.valideApresRattrapage.set(noteModuleBuilder.valideApresRattrapage);
		this.noteApresRattrapage.set(noteModuleBuilder.noteApresRattrapage);
		this.noteModule.set(noteModuleBuilder.noteModule);
		this.moduleId.set(noteModuleBuilder.moduleId);
		this.etudiantId.set(noteModuleBuilder.etudiantId);
	}

	public static class NoteModuleBuilder {

		private int idNoteModule;
		private boolean valideAvantRattrapage;
		private double noteAvantRattrapage;
		private boolean valideApresRattrapage;
		private double noteApresRattrapage;
		private double noteModule;
		private int moduleId;
		private int etudiantId;

		public NoteModuleBuilder setIdNoteModule(int idNoteModule) {
			this.idNoteModule = idNoteModule;
			return this;
		}

		public NoteModuleBuilder setValideAvantRattrapage(boolean valideAvantRattrapage) {
			this.valideAvantRattrapage = valideAvantRattrapage;
			return this;
		}

		public NoteModuleBuilder setNoteAvantRattrapage(double noteAvantRattrapage) {
			this.noteAvantRattrapage = noteAvantRattrapage;
			return this;
		}

		public NoteModuleBuilder setValideApresRattrapage(boolean valideApresRattrapage) {
			this.valideApresRattrapage = valideApresRattrapage;
			return this;
		}

		public NoteModuleBuilder setNoteApresRattrapage(double noteApresRattrapage) {
			this.noteApresRattrapage = noteApresRattrapage;
			return this;
		}

		public NoteModuleBuilder setNoteModule(double noteModule) {
			this.noteModule = noteModule;
			return this;
		}

		public NoteModuleBuilder setModuleId(int moduleId) {
			this.moduleId = moduleId;
			return this;
		}

		public NoteModuleBuilder setEtudiantId(int etudiantId) {
			this.etudiantId = etudiantId;
			return this;
		}

		public NoteModule build() {
			return new NoteModule(this);
		}

	}

	public IntegerProperty idNoteModuleProperty() {
		return idNoteModule;
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

	public DoubleProperty noteModuleProperty() {
		return noteModule;
	}

	public IntegerProperty moduleIdProperty() {
		return moduleId;
	}

	public IntegerProperty etudiantIdProperty() {
		return etudiantId;
	}

	public int getIdNoteModule() {
		return idNoteModule.get();
	}

	public boolean getValideAvantRattrapage() {
		return valideAvantRattrapage.get();
	}

	public Double getNoteAvantRattrapage() {
		return noteAvantRattrapage.get();
	}

	public boolean getValideApresRattrapage() {
		return valideApresRattrapage.get();
	}

	public Double getNoteApresRattrapage() {
		return noteApresRattrapage.get();
	}

	public Double getNoteModule() {
		return noteModule.get();
	}

	public int getModuleId() {
		return moduleId.get();
	}

	public int getEtudiantId() {
		return etudiantId.get();
	}

	public void setValideAvantRattrapage(boolean valideAvantRattrapage) {
		this.valideAvantRattrapage.set(valideAvantRattrapage);
	}

	public void setNoteAvantRattrapage(double noteAvantRattrapage) {
		this.noteAvantRattrapage.set(noteAvantRattrapage);
	}

	public void setValideApresRattrapage(boolean valideApresRattrapage) {
		this.valideApresRattrapage.set(valideApresRattrapage);
	}

	public void setNoteApresRattrapage(double noteApresRattrapage) {
		this.noteApresRattrapage.set(noteApresRattrapage);
	}

	public void setNoteModule(double noteModule) {
		this.noteModule.set(noteModule);
	}

	public void setModuleId(int moduleId) {
		this.moduleId.set(moduleId);
	}

	public void setEtudiantId(int etudiantId) {
		this.etudiantId.set(etudiantId);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " : " + idNoteModule.get();
	}

}
