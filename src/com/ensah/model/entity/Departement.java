package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Departement {

	private final IntegerProperty idDepartement;
	private final StringProperty designationDepartement;
	private final IntegerProperty professeurId;

	{
		this.idDepartement = new SimpleIntegerProperty();
		this.designationDepartement = new SimpleStringProperty();
		this.professeurId = new SimpleIntegerProperty();
	}

	private Departement(DepartementBuilder departementBuilder) {
		this.idDepartement.set(departementBuilder.idDepartement);
		this.designationDepartement.set(departementBuilder.designationDepartement);
		this.professeurId.set(departementBuilder.professeurId);
	}

	public static class DepartementBuilder {

		private int idDepartement;
		private String designationDepartement;
		private int professeurId;

		public DepartementBuilder setIdDepartement(int idDepartement) {
			this.idDepartement = idDepartement;
			return this;
		}

		public DepartementBuilder setDesignationDepartement(String designationDepartement) {
			this.designationDepartement = designationDepartement;
			return this;
		}

		public DepartementBuilder setProfesseurId(int professeurId) {
			this.professeurId = professeurId;
			return this;
		}

		public Departement build() {
			return new Departement(this);
		}

	}

	public IntegerProperty idDepartementProperty() {
		return idDepartement;
	}

	public StringProperty designationDepartementProperty() {
		return designationDepartement;
	}

	public IntegerProperty professeurIdProperty() {
		return professeurId;
	}

	public int getIdDepartement() {
		return idDepartement.get();
	}

	public String getDesignationDepartement() {
		return designationDepartement.get();
	}

	public int getProfesseurId() {
		return professeurId.get();
	}

	public void setDesignationDepartement(String designationDepartement) {
		this.designationDepartement.set(designationDepartement);
	}

	public void setProfesseurId(int professeurId) {
		this.professeurId.set(professeurId);
	}

	@Override
	public String toString() {
		return designationDepartement.get() ;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idDepartement.get();
		hash = 61 * hash + Objects.hashCode(this.designationDepartement.get());
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
		Departement other = (Departement) obj;
		if (this.idDepartement.get() != other.idDepartement.get()) {
			return false;
		}
		if (!Objects.equals(this.designationDepartement.get(), other.designationDepartement.get())) {
			return false;
		}
		return true;
	}

}