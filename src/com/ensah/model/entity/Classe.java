package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Classe {

	private final IntegerProperty idClasse;
	private final StringProperty designationClasse;
	private final IntegerProperty filiereId;

	{
		this.idClasse = new SimpleIntegerProperty();
		this.designationClasse = new SimpleStringProperty();
		this.filiereId = new SimpleIntegerProperty();
	}

	private Classe(ClasseBuilder classeBuilder) {
		this.idClasse.set(classeBuilder.idClasse);
		this.designationClasse.set(classeBuilder.designationClasse);
		this.filiereId.set(classeBuilder.filiereId);
	}

	public static class ClasseBuilder {

		private int idClasse;
		private String designationClasse;
		private int filiereId;

		public ClasseBuilder setIdClasse(int idClasse) {
			this.idClasse = idClasse;
			return this;
		}

		public ClasseBuilder setDesignationClasse(String designationClasse) {
			this.designationClasse = designationClasse;
			return this;
		}

		public ClasseBuilder setFiliereId(int filiereId) {
			this.filiereId = filiereId;
			return this;
		}

		public Classe build() {
			return new Classe(this);
		}

	}

	public IntegerProperty idClasseProperty() {
		return idClasse;
	}

	public StringProperty designationClasseProperty() {
		return designationClasse;
	}

	public IntegerProperty filiereIdProperty() {
		return filiereId;
	}

	public int getIdClasse() {
		return idClasse.get();
	}

	public String getDesignationClasse() {
		return designationClasse.get();
	}

	public int getFiliereId() {
		return filiereId.get();
	}

	public void setDesignationClasse(String designationClasse) {
		this.designationClasse.set(designationClasse);
	}

	public void setFiliereId(int filiereId) {
		this.filiereId.set(filiereId);
	}

	@Override
	public String toString() {
		return designationClasse.get() ;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idClasse.get();
		hash = 61 * hash + Objects.hashCode(this.designationClasse.get());
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
		Classe other = (Classe) obj;
		if (this.idClasse.get() != other.idClasse.get()) {
			return false;
		}
		if (!Objects.equals(this.designationClasse.get(), other.designationClasse.get())) {
			return false;
		}
		return true;
	}

}