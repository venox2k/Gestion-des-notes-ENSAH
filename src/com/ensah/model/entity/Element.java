package com.ensah.model.entity;

import java.util.Objects;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Element {

	private final IntegerProperty idElement;
	private final StringProperty designationElement;
	private final DoubleProperty coefficientElement;
	private final BooleanProperty dsActive;
	private final BooleanProperty examActive;
	private final BooleanProperty tpActive;
	private final BooleanProperty projetActive;
	private final BooleanProperty exposeActive;
	private final BooleanProperty devoirLibreActive;
	private final BooleanProperty absenceActive;
	private final DoubleProperty coefficientDs;
	private final DoubleProperty coefficientExam;
	private final DoubleProperty coefficientTp;
	private final DoubleProperty coefficientProjet;
	private final DoubleProperty coefficientExpose;
	private final DoubleProperty coefficientDevoirLibre;
	private final DoubleProperty coefficientAbsence;
	private final IntegerProperty moduleId;
	private final IntegerProperty professeurId;

	{
		this.idElement = new SimpleIntegerProperty();
		this.designationElement = new SimpleStringProperty();
		this.coefficientElement = new SimpleDoubleProperty();
		this.dsActive = new SimpleBooleanProperty();
		this.examActive = new SimpleBooleanProperty();
		this.tpActive = new SimpleBooleanProperty();
		this.projetActive = new SimpleBooleanProperty();
		this.exposeActive = new SimpleBooleanProperty();
		this.devoirLibreActive = new SimpleBooleanProperty();
		this.absenceActive = new SimpleBooleanProperty();
		this.coefficientDs = new SimpleDoubleProperty();
		this.coefficientExam = new SimpleDoubleProperty();
		this.coefficientTp = new SimpleDoubleProperty();
		this.coefficientProjet = new SimpleDoubleProperty();
		this.coefficientExpose = new SimpleDoubleProperty();
		this.coefficientDevoirLibre = new SimpleDoubleProperty();
		this.coefficientAbsence = new SimpleDoubleProperty();
		this.moduleId = new SimpleIntegerProperty();
		this.professeurId = new SimpleIntegerProperty();
	}

	private Element(ElementBuilder elementBuilder) {
		{
			this.idElement.set(elementBuilder.idElement);
			this.designationElement.set(elementBuilder.designationElement);
			this.coefficientElement.set(elementBuilder.coefficientElement);
			this.dsActive.set(elementBuilder.dsActive);
			this.examActive.set(elementBuilder.examActive);
			this.tpActive.set(elementBuilder.tpActive);
			this.projetActive.set(elementBuilder.projetActive);
			this.exposeActive.set(elementBuilder.exposeActive);
			this.devoirLibreActive.set(elementBuilder.devoirLibreActive);
			this.absenceActive.set(elementBuilder.absenceActive);
			this.coefficientDs.set(elementBuilder.coefficientDs);
			this.coefficientExam.set(elementBuilder.coefficientExam);
			this.coefficientTp.set(elementBuilder.coefficientTp);
			this.coefficientProjet.set(elementBuilder.coefficientProjet);
			this.coefficientExpose.set(elementBuilder.coefficientExpose);
			this.coefficientDevoirLibre.set(elementBuilder.coefficientDevoirLibre);
			this.coefficientAbsence.set(elementBuilder.coefficientAbsence);
			this.moduleId.set(elementBuilder.moduleId);
			this.professeurId.set(elementBuilder.professeurId);
		}
	}

	public static class ElementBuilder {

		private int idElement;
		private String designationElement;
		private double coefficientElement;
		private boolean dsActive;
		private boolean examActive;
		private boolean tpActive;
		private boolean projetActive;
		private boolean exposeActive;
		private boolean devoirLibreActive;
		private boolean absenceActive;
		private double coefficientDs;
		private double coefficientExam;
		private double coefficientTp;
		private double coefficientProjet;
		private double coefficientExpose;
		private double coefficientAbsence;
		private double coefficientDevoirLibre;
		private int moduleId;
		private int professeurId;

		public ElementBuilder setIdElement(int idElement) {
			this.idElement = idElement;
			return this;
		}

		public ElementBuilder setDesignationElement(String designationElement) {
			this.designationElement = designationElement;
			return this;
		}

		public ElementBuilder setCoefficientElement(Double coefficientElement) {
			this.coefficientElement = coefficientElement;
			return this;
		}

		public ElementBuilder setDsActive(boolean dsActive) {
			this.dsActive = dsActive;
			return this;
		}

		public ElementBuilder setExamActive(boolean examActive) {
			this.examActive = examActive;
			return this;
		}

		public ElementBuilder setTpActive(boolean tpActive) {
			this.tpActive = tpActive;
			return this;
		}

		public ElementBuilder setProjetActive(boolean projetActive) {
			this.projetActive = projetActive;
			return this;
		}

		public ElementBuilder setExposeActive(boolean exposeActive) {
			this.exposeActive = exposeActive;
			return this;
		}

		public ElementBuilder setDevoirLibreActive(boolean devoirLibreActive) {
			this.devoirLibreActive = devoirLibreActive;
			return this;
		}

		public ElementBuilder setAbsenceActive(boolean absenceActive) {
			this.absenceActive = absenceActive;
			return this;
		}
		
		public ElementBuilder setCoefficientDs(double coefficientDs) {
			this.coefficientDs = coefficientDs;
			return this;
		}

		public ElementBuilder setCoefficientExam(double coefficientExam) {
			this.coefficientExam = coefficientExam;
			return this;
		}

		public ElementBuilder setCoefficientTp(double coefficientTp) {
			this.coefficientTp = coefficientTp;
			return this;
		}

		public ElementBuilder setCoefficientProjet(double coefficientProjet) {
			this.coefficientProjet = coefficientProjet;
			return this;
		}

		public ElementBuilder setCoefficientExpose(double coefficientExpose) {
			this.coefficientExpose = coefficientExpose;
			return this;
		}

		public ElementBuilder setCoefficientDevoirLibre(double coefficientDevoirLibre) {
			this.coefficientDevoirLibre = coefficientDevoirLibre;
			return this;
		}

		public ElementBuilder setCoefficientAbsence(double coefficientAbsence) {
			this.coefficientAbsence = coefficientAbsence;
			return this;
		}

		public ElementBuilder setModuleId(int moduleId) {
			this.moduleId = moduleId;
			return this;
		}

		public ElementBuilder setProfesseurId(int professeurId) {
			this.professeurId = professeurId;
			return this;
		}

		public Element build() {
			return new Element(this);
		}

	}

	public IntegerProperty idElementProperty() {
		return idElement;
	}

	public StringProperty designationElementProperty() {
		return designationElement;
	}

	public DoubleProperty coefficientElementProperty() {
		return coefficientElement;
	}

	public BooleanProperty dsActiveProperty() {
		return dsActive;
	}

	public BooleanProperty examActiveProperty() {
		return examActive;
	}

	public BooleanProperty tpActiveProperty() {
		return tpActive;
	}

	public BooleanProperty ProjetActiveProperty() {
		return projetActive;
	}

	public BooleanProperty exposeActiveProperty() {
		return exposeActive;
	}

	public BooleanProperty devoirLibreActiveProperty() {
		return devoirLibreActive;
	}

	public BooleanProperty absenceActiveProperty() {
		return absenceActive;
	}

	public DoubleProperty coefficientDsProperty() {
		return coefficientDs;
	}

	public DoubleProperty coefficientExamProperty() {
		return coefficientExam;
	}

	public DoubleProperty coefficientTpProperty() {
		return coefficientTp;
	}

	public DoubleProperty coefficientProjetProperty() {
		return coefficientProjet;
	}

	public DoubleProperty coefficientExposeProperty() {
		return coefficientExpose;
	}

	public DoubleProperty coefficientDevoirLibreProperty() {
		return coefficientDevoirLibre;
	}

	public DoubleProperty coefficientAbsenceProperty() {
		return coefficientAbsence;
	}

	public IntegerProperty moduleIdProperty() {
		return moduleId;
	}

	public IntegerProperty professeurProperty() {
		return professeurId;
	}

	public int getIdElement() {
		return idElement.get();
	}

	public String getDesignationElement() {
		return designationElement.get();
	}

	public Double getCoefficientElement() {
		return coefficientElement.get();
	}

	public boolean getDsActive() {
		return dsActive.get();
	}

	public boolean getExamActive() {
		return examActive.get();
	}

	public boolean getTpActive() {
		return tpActive.get();
	}

	public boolean getProjetActive() {
		return projetActive.get();
	}

	public boolean getExposeActive() {
		return exposeActive.get();
	}

	public boolean getDevoirLibreActive() {
		return devoirLibreActive.get();
	}

	public boolean getAbsenceActive() {
		return absenceActive.get();
	}

	public double getCoefficientDs() {
		return coefficientDs.get();
	}

	public double getCoefficientExam() {
		return coefficientExam.get();
	}

	public double getCoefficientTp() {
		return coefficientTp.get();
	}

	public double getCoefficientProjet() {
		return coefficientProjet.get();
	}

	public double getCoefficientExpose() {
		return coefficientExpose.get();
	}

	public double getCoefficientDevoirLibre() {
		return coefficientDevoirLibre.get();
	}

	public double getCoefficientAbsence() {
		return coefficientAbsence.get();
	}

	public int getModuleId() {
		return moduleId.get();
	}

	public int getProfesseurId() {
		return professeurId.get();
	}

	public void setDesignationElement(String designationElement) {
		this.designationElement.set(designationElement);
	}

	public void setCoefficientElement(Double coefficientElement) {
		this.coefficientElement.set(coefficientElement);
	}

	public void setDsActive(boolean dsActive) {
		this.dsActive.set(dsActive);
	}

	public void setExamActive(boolean examActive) {
		this.examActive.set(examActive);
	}

	public void setTpActive(boolean tpActive) {
		this.tpActive.set(tpActive);
	}

	public void setProjetActive(boolean projetActive) {
		this.projetActive.set(projetActive);
	}

	public void setExposeActive(boolean exposeActive) {
		this.exposeActive.set(exposeActive);
	}

	public void setDevoirLibreActive(boolean devoirLibreActive) {
		this.devoirLibreActive.set(devoirLibreActive);
	}

	public void setAbsenceActive(boolean absenceActive) {
		this.absenceActive.set(absenceActive);
	}

	public void setCoefficientDs(double coefficientDs) {
		this.coefficientDs.set(coefficientDs);
	}

	public void setCoefficientExam(double coefficientExam) {
		this.coefficientExam.set(coefficientExam);
	}

	public void setCoefficientTp(double coefficientTp) {
		this.coefficientTp.set(coefficientTp);
	}

	public void setCoefficientProjet(double coefficientProjet) {
		this.coefficientProjet.set(coefficientProjet);
	}

	public void setCoefficientExpose(double coefficientExpose) {
		this.coefficientExpose.set(coefficientExpose);
	}

	public void setCoefficientDevoirLibre(double coefficientDevoirLibre) {
		this.coefficientDevoirLibre.set(coefficientDevoirLibre);
	}

	public void setCoefficientAbsence(Double coefficientAbsence) {
		this.coefficientDs.set(coefficientAbsence);
	}

	public void setModuleId(int moduleId) {
		this.moduleId.set(moduleId);
	}

	public void setProfesseurId(int professeurId) {
		this.professeurId.set(professeurId);
	}

	@Override
	public String toString() {
		return  designationElement.get();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + this.idElement.get();
		hash = 61 * hash + Objects.hashCode(this.designationElement.get());
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
		Element other = (Element) obj;
		if (this.idElement.get() != other.idElement.get()) {
			return false;
		}
		if (!Objects.equals(this.designationElement.get(), other.designationElement.get())) {
			return false;
		}
		return true;
	}

}
