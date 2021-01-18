package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Semestre {

	private final IntegerProperty idSemestre;
	private final StringProperty designationSemestre;
	private final IntegerProperty classeId;

	{
		this.idSemestre = new SimpleIntegerProperty();
		this.designationSemestre = new SimpleStringProperty();
		this.classeId = new SimpleIntegerProperty();
	}

	private Semestre(SemestreBuilder semestreBuilder) {
		this.idSemestre.set(semestreBuilder.idSemestre);
		this.designationSemestre.set(semestreBuilder.designationSemestre);
		this.classeId.set(semestreBuilder.classeId);
	}

	public static class SemestreBuilder {

		private int idSemestre;
		private String designationSemestre;
		private int classeId;

		public SemestreBuilder setIdSemestre(int idSemestre) {
			this.idSemestre = idSemestre;
			return this;
		}

		public SemestreBuilder setDesignationSemestre(String designationSemestre) {
			this.designationSemestre = designationSemestre;
			return this;
		}

		public SemestreBuilder setClasseId(int classeId) {
			this.classeId = classeId;
			return this;
		}

		public Semestre build() {
			return new Semestre(this);
		}

	}

	public IntegerProperty idSemestreProperty() {
		return idSemestre;
	}

	public StringProperty designationSemestreProperty() {
		return designationSemestre;
	}

	public IntegerProperty classeIdProperty() {
		return classeId;
	}

	public int getIdSemestre() {
		return idSemestre.get();
	}

	public String getDesignationSemestre() {
		return designationSemestre.get();
	}

	public int getClasseId() {
		return classeId.get();
	}

	public void setDesignationSemestre(String designationSemestre) {
		this.designationSemestre.set(designationSemestre);
	}

	public void setClasseId(int classeId) {
		this.classeId.set(classeId);
	}

	@Override
	public String toString() {
		return  designationSemestre.get();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idSemestre.get();
		hash = 61 * hash + Objects.hashCode(this.designationSemestre.get());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Semestre other = (Semestre) obj;
		if (this.idSemestre.get() != other.idSemestre.get()) {
			return false;
		}
		if (!Objects.equals(this.designationSemestre.get(), other.designationSemestre.get())) {
			return false;
		}
		return true;
	}

}