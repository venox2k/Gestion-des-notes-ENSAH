package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Utilisateur {

	private final IntegerProperty idUtilisateur;
	private final StringProperty nomUtilisateur;
	private final StringProperty motDePasseUtilisateur;
	private final StringProperty cleUtilisateur;

	{
		this.idUtilisateur = new SimpleIntegerProperty();
		this.nomUtilisateur = new SimpleStringProperty();
		this.motDePasseUtilisateur = new SimpleStringProperty();
		this.cleUtilisateur = new SimpleStringProperty();
	}

	private Utilisateur(UtilisateurBuilder administrateurBuilder) {
		this.idUtilisateur.set(administrateurBuilder.idUtilisateur);
		this.nomUtilisateur.set(administrateurBuilder.nomUtilisateur);
		this.motDePasseUtilisateur.set(administrateurBuilder.motDePasseUtilisateur);
		this.cleUtilisateur.set(administrateurBuilder.cleUtilisateur);
	}

	public static class UtilisateurBuilder {

		private int idUtilisateur;
		private String nomUtilisateur;
		private String motDePasseUtilisateur;
		private String cleUtilisateur;

		public UtilisateurBuilder setIdUtilisateur(int idUtilisateur) {
			this.idUtilisateur = idUtilisateur;
			return this;
		}

		public UtilisateurBuilder setNomUtilisateur(String nomUtilisateur) {
			this.nomUtilisateur = nomUtilisateur;
			return this;
		}

		public UtilisateurBuilder setMotDePasseUtilisateur(String motDePasseUtilisateur) {
			this.motDePasseUtilisateur = motDePasseUtilisateur;
			return this;
		}

		public UtilisateurBuilder setCleUtilisateur(String cleUtilisateur) {
			this.cleUtilisateur = cleUtilisateur;
			return this;
		}

		public Utilisateur build() {
			return new Utilisateur(this);
		}

	}

	public IntegerProperty idUtilisateurProperty() {
		return idUtilisateur;
	}

	public StringProperty nomUtilisateurProperty() {
		return nomUtilisateur;
	}

	public StringProperty motDePasseUtilisateurProperty() {
		return motDePasseUtilisateur;
	}

	public StringProperty cleUtilisateurProperty() {
		return cleUtilisateur;
	}

	public int getIdUtilisateur() {
		return idUtilisateur.get();
	}

	public String getNomUtilisateur() {
		return nomUtilisateur.get();
	}

	public String getMotDePasseUtilisateur() {
		return motDePasseUtilisateur.get();
	}

	public String getCleUtilisateur() {
		return cleUtilisateur.get();
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur.set(nomUtilisateur);
	}

	public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
		this.motDePasseUtilisateur.set(motDePasseUtilisateur);
	}

	public void setCleUtilisateur(String cleUtilisateur) {
		this.cleUtilisateur.set(cleUtilisateur);
	}

	@Override
	public String toString() {
		return nomUtilisateur.get();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idUtilisateur.get();
		hash = 61 * hash + Objects.hashCode(this.nomUtilisateur.get());
		hash = 61 * hash + Objects.hashCode(this.motDePasseUtilisateur.get());
		hash = 61 * hash + Objects.hashCode(this.cleUtilisateur.get());
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
		Utilisateur other = (Utilisateur) obj;
		if (this.idUtilisateur.get() != other.idUtilisateur.get()) {
			return false;
		}
		if (!Objects.equals(this.nomUtilisateur.get(), other.nomUtilisateur.get())) {
			return false;
		}
		if (!Objects.equals(this.motDePasseUtilisateur.get(), other.motDePasseUtilisateur.get())) {
			return false;
		}
		if (!Objects.equals(this.cleUtilisateur.get(), other.cleUtilisateur.get())) {
			return false;
		}
		return true;
	}
}
