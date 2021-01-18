package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Module {

	private final IntegerProperty idModule;
	private final StringProperty designationModule;
	private final IntegerProperty semesterId;

	{
		this.idModule = new SimpleIntegerProperty();
		this.designationModule = new SimpleStringProperty();
		this.semesterId = new SimpleIntegerProperty();
	}

	private Module(ModuleBuilder moduleBuilder) {
		this.idModule.set(moduleBuilder.idModule);
		this.designationModule.set(moduleBuilder.designationModule);
		this.semesterId.set(moduleBuilder.semesterId);
	}

	public static class ModuleBuilder {

		private int idModule;
		private String designationModule;
		private int semesterId;

		public ModuleBuilder setIdModule(int idModule) {
			this.idModule = idModule;
			return this;
		}

		public ModuleBuilder setDesignationModule(String designationModule) {
			this.designationModule = designationModule;
			return this;
		}

		public ModuleBuilder setSemesterId(int semesterId) {
			this.semesterId = semesterId;
			return this;
		}

		public Module build() {
			return new Module(this);
		}

	}

	public IntegerProperty idModuleProperty() {
		return idModule;
	}

	public StringProperty designationModuleProperty() {
		return designationModule;
	}

	public IntegerProperty semesterIdProperty() {
		return semesterId;
	}

	public int getIdModule() {
		return idModule.get();
	}

	public String getDesignationModule() {
		return designationModule.get();
	}

	public int getSemesterId() {
		return semesterId.get();
	}

	public void setDesignationModule(String designationModule) {
		this.designationModule.set(designationModule);
	}

	public void setSemesterId(int semesterId) {
		this.semesterId.set(semesterId);
	}

	@Override
	public String toString() {
		return designationModule.get();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idModule.get();
		hash = 61 * hash + Objects.hashCode(this.designationModule.get());
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
		Module other = (Module) obj;
		if (this.idModule.get() != other.idModule.get()) {
			return false;
		}
		if (!Objects.equals(this.designationModule.get(), other.designationModule.get())) {
			return false;
		}
		return true;
	}

}