package com.ensah.model.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Administrateur {

	private final IntegerProperty idAdministrateur;
	private final IntegerProperty utilisateurId;

	{
		this.idAdministrateur = new SimpleIntegerProperty();
		this.utilisateurId = new SimpleIntegerProperty();
	}

	private Administrateur(AdministrateurBuilder administrateurBuilder) {
		this.idAdministrateur.set(administrateurBuilder.idAdministrateur);
		this.utilisateurId.set(administrateurBuilder.utilisateurId);
	}

	public static class AdministrateurBuilder {

		private int idAdministrateur;
		private int utilisateurId;

		public AdministrateurBuilder setIdAdministrateur(int idAdministrateur) {
			this.idAdministrateur = idAdministrateur;
			return this;
		}

		public AdministrateurBuilder setUtilisateurId(int utilisateurId) {
			this.utilisateurId = utilisateurId;
			return this;
		}

		public Administrateur build() {
			return new Administrateur(this);
		}

	}

	public IntegerProperty idAdministrateurProperty() {
		return idAdministrateur;
	}

	public IntegerProperty utilisateurIdProperty() {
		return idAdministrateur;
	}

	public int getIdAdministrateur() {
		return idAdministrateur.get();
	}

	public int getUtilisateurId() {
		return utilisateurId.get();
	}

	public void setIdAdministrateur(int idAdministrateur) {
		this.idAdministrateur.set(idAdministrateur);
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId.set(utilisateurId);
	}

	@Override
	public String toString() {
		return utilisateurId.get() + " [ " + idAdministrateur.get() + " ] ";
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idAdministrateur.get();
		hash = 61 * hash + this.utilisateurId.get();
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
		Administrateur other = (Administrateur) obj;
		if (this.idAdministrateur.get() != other.idAdministrateur.get()) {
			return false;
		}
		if (this.utilisateurId.get() != other.utilisateurId.get()) {
			return false;
		}
		return true;
	}

}
