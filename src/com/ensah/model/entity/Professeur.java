package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Professeur {

	private final IntegerProperty idProfesseur;
	private final StringProperty nomProfesseur;
	private final StringProperty prenomProfesseur;
	private final StringProperty emailProfesseur;
	private final IntegerProperty utilisateurId;
	private final IntegerProperty departementId;

	{
		this.idProfesseur = new SimpleIntegerProperty();
		this.nomProfesseur = new SimpleStringProperty();
		this.prenomProfesseur = new SimpleStringProperty();
		this.emailProfesseur = new SimpleStringProperty();
		this.utilisateurId = new SimpleIntegerProperty();
		this.departementId = new SimpleIntegerProperty();
	}

	private Professeur(ProfesseurBuilder professeurBuilder) {
		this.idProfesseur.set(professeurBuilder.idProfesseur);
		this.nomProfesseur.set(professeurBuilder.nomProfesseur);
		this.prenomProfesseur.set(professeurBuilder.prenomProfesseur);
		this.emailProfesseur.set(professeurBuilder.emailProfesseur);
		this.utilisateurId.set(professeurBuilder.utilisateurId);
		this.departementId.set(professeurBuilder.departementId);
	}

	public static class ProfesseurBuilder {

		private int idProfesseur;
		private String nomProfesseur;
		private String prenomProfesseur;
		private String emailProfesseur;
		private int utilisateurId;
		private int departementId;

		public ProfesseurBuilder setIdProfesseur(int idProfesseur) {
			this.idProfesseur = idProfesseur;
			return this;
		}

		public ProfesseurBuilder setNomProfesseur(String nomProfesseur) {
			this.nomProfesseur = nomProfesseur;
			return this;
		}

		public ProfesseurBuilder setPrenomProfesseur(String prenomProfesseur) {
			this.prenomProfesseur = prenomProfesseur;
			return this;
		}

		public ProfesseurBuilder setEmailProfesseur(String emailProfesseur) {
			this.emailProfesseur = emailProfesseur;
			return this;
		}

		public ProfesseurBuilder setUtilisateurId(int utilisateurId) {
			this.utilisateurId = utilisateurId;
			return this;
		}

		public ProfesseurBuilder setDepartementId(int departementId) {
			this.departementId = departementId;
			return this;
		}

		public Professeur build() {
			return new Professeur(this);
		}

	}

	public IntegerProperty idProfesseurProperty() {
		return idProfesseur;
	}

	public StringProperty nomProfesseurProperty() {
		return nomProfesseur;
	}

	public StringProperty prenomProfesseurProperty() {
		return prenomProfesseur;
	}

	public StringProperty emailProfesseurProperty() {
		return emailProfesseur;
	}

	public IntegerProperty utilisateurIdProperty() {
		return utilisateurId;
	}

	public IntegerProperty departementIdProperty() {
		return departementId;
	}

	public int getIdProfesseur() {
		return idProfesseur.get();
	}

	public String getNomProfesseur() {
		return nomProfesseur.get();
	}

	public String getPrenomProfesseur() {
		return prenomProfesseur.get();
	}

	public String getEmailProfesseur() {
		return emailProfesseur.get();
	}

	public int getUtilisateurId() {
		return utilisateurId.get();
	}

	public int getDepartementId() {
		return departementId.get();
	}

	public void setNomProfesseur(String nomProfesseur) {
		this.nomProfesseur.set(nomProfesseur);
	}

	public void setPrenomProfesseur(String prenomProfesseur) {
		this.prenomProfesseur.set(prenomProfesseur);
	}

	public void setEmailProfesseur(String emailProfesseur) {
		this.emailProfesseur.set(emailProfesseur);
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId.set(utilisateurId);
	}

	public void setDepartementId(int departementId) {
		this.departementId.set(departementId);
	}

	@Override
	public String toString() {
		return nomProfesseur.get() + " " + prenomProfesseur.get() ;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idProfesseur.get();
		hash = 61 * hash + Objects.hashCode(this.emailProfesseur.get());
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
		Professeur other = (Professeur) obj;
		if (this.idProfesseur.get() != other.idProfesseur.get()) {
			return false;
		}
		if (!Objects.equals(this.emailProfesseur.get(), other.emailProfesseur.get())) {
			return false;
		}
		return true;
	}

}
