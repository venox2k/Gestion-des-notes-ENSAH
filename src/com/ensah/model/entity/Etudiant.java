package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Etudiant {

	private final IntegerProperty idEtudiant;
	private final StringProperty cneEtudiant;
	private final StringProperty cinEtudiant;
	private final StringProperty nomEtudiant;
	private final StringProperty prenomEtudiant;
	private final IntegerProperty classeId;

	{
		idEtudiant = new SimpleIntegerProperty();
		cneEtudiant = new SimpleStringProperty();
		cinEtudiant = new SimpleStringProperty();
		nomEtudiant = new SimpleStringProperty();
		prenomEtudiant = new SimpleStringProperty();
		classeId = new SimpleIntegerProperty();
	}

	private Etudiant(EtudiantBuilder etudiantBuilder) {
		this.idEtudiant.set(etudiantBuilder.idEtudiant);
		this.cneEtudiant.set(etudiantBuilder.cneEtudiant);
		this.cinEtudiant.set(etudiantBuilder.cinEtudiant);
		this.nomEtudiant.set(etudiantBuilder.nomEtudiant);
		this.prenomEtudiant.set(etudiantBuilder.prenomEtudiant);
		this.classeId.set(etudiantBuilder.classeId);
	}

	public static class EtudiantBuilder {

		private int idEtudiant;
		private String cneEtudiant;
		private String cinEtudiant;
		private String nomEtudiant;
		private String prenomEtudiant;
		private int classeId;

		public EtudiantBuilder setIdEtudiant(int idEtudiant) {
			this.idEtudiant = idEtudiant;
			return this;
		}

		public EtudiantBuilder setCneEtudiant(String cneEtudiant) {
			this.cneEtudiant = cneEtudiant;
			return this;
		}

		public EtudiantBuilder setCinEtudiant(String cinEtudiant) {
			this.cinEtudiant = cinEtudiant;
			return this;
		}

		public EtudiantBuilder setNomEtudiant(String nomEtudiant) {
			this.nomEtudiant = nomEtudiant;
			return this;
		}

		public EtudiantBuilder setPrenomEtudiant(String prenomEtudiant) {
			this.prenomEtudiant = prenomEtudiant;
			return this;
		}

		public EtudiantBuilder setClasseId(int classeId) {
			this.classeId = classeId;
			return this;
		}

		public Etudiant build() {
			return new Etudiant(this);
		}

	}

	public IntegerProperty dEtudiantProperty() {
		return idEtudiant;
	}

	public StringProperty cneEtudiantProperty() {
		return cneEtudiant;
	}

	public StringProperty cinEtudiantProperty() {
		return cinEtudiant;
	}

	public StringProperty nomEtudiantProperty() {
		return nomEtudiant;
	}

	public StringProperty prenomEtudiantProperty() {
		return prenomEtudiant;
	}

	public IntegerProperty classeIdProperty() {
		return classeId;
	}

	public int getIdEtudiant() {
		return idEtudiant.get();
	}

	public String getCneEtudiant() {
		return cneEtudiant.get();
	}

	public String getCinEtudiant() {
		return cinEtudiant.get();
	}

	public String getNomEtudiant() {
		return nomEtudiant.get();
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant.get();
	}

	public int getClasseId() {
		return classeId.get();
	}

	public void setCneEtudiant(String cneEtudiant) {
		this.cneEtudiant.set(cneEtudiant);
	}

	public void setCinEtudiant(String cinEtudiant) {
		this.cinEtudiant.set(cinEtudiant);
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant.set(nomEtudiant);
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant.set(prenomEtudiant);
	}

	public void setClasseId(int classeId) {
		this.classeId.set(classeId);
	}

	@Override
	public String toString() {
		return  nomEtudiant.get() + " " + prenomEtudiant.get();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idEtudiant.get();
		hash = 61 * hash + Objects.hashCode(this.cinEtudiant.get());
		hash = 61 * hash + Objects.hashCode(this.cneEtudiant.get());
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
		Etudiant other = (Etudiant) obj;
		if (this.idEtudiant.get() != other.idEtudiant.get()) {
			return false;
		}
		if (!Objects.equals(this.cinEtudiant.get(), other.cinEtudiant.get())) {
			return false;
		}
		if (!Objects.equals(this.cneEtudiant.get(), other.cneEtudiant.get())) {
			return false;
		}
		return true;
	}

}