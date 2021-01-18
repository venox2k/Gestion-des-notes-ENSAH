package com.ensah.controller.professeur;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.entity.Element;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GestionElementController implements Initializable {

	@FXML
	private AnchorPane gestionElementPane;

	@FXML
	private TextField coefficientElementField;

	@FXML
	private TextField coefficientDsField;

	@FXML
	private TextField coefficientExamField;

	@FXML
	private TextField coefficientTpField;

	@FXML
	private TextField coefficientProjectField;

	@FXML
	private TextField coefficientExposeField;

	@FXML
	private TextField coefficientDevoirLibreField;

	@FXML
	private TextField coefficientAbsenceField;

	@FXML
	private CheckBox dsActiveCheckBox;

	@FXML
	private CheckBox examActiveCheckBox;

	@FXML
	private CheckBox tpActiveCheckBox;

	@FXML
	private CheckBox projectActiveCheckBox;

	@FXML
	private CheckBox exposeActiveCheckBox;

	@FXML
	private CheckBox devoireLibreActiveCheckBox;

	@FXML
	private CheckBox absenceActiveCheckBox;

	@FXML
	private Label errorMsg;

	private DoubleProperty coefficientElement;

	private DoubleProperty coefficientDs;

	private DoubleProperty coefficientExam;

	private DoubleProperty coefficientTp;

	private DoubleProperty coefficientProjet;

	private DoubleProperty coefficientExpose;

	private DoubleProperty coefficientDevoirLibre;

	private DoubleProperty coefficientAbsence;

	private BooleanProperty dsActive;

	private BooleanProperty examActive;

	private BooleanProperty tpActive;

	private BooleanProperty projetActive;

	private BooleanProperty exposeActive;

	private BooleanProperty devoirLibreActive;

	private BooleanProperty absenceActive;

	@FXML
	private Button valideBtn;

	@FXML
	private Label designationElementLabel;

	private ProfesseurDAO professeurDAO;

	private ElementDAO elementDAO;

	private Element element;

	public GestionElementController() {
		professeurDAO = new ProfesseurDAO();
		elementDAO = new ElementDAO();
		int professeurId = 10;// professeur id
		List<Element> elements = new ArrayList<Element>(elementDAO.findProfesseur(professeurId));
		element = elements.get(0);
		coefficientElement = new SimpleDoubleProperty();
		coefficientDs = new SimpleDoubleProperty();
		coefficientExam = new SimpleDoubleProperty();
		coefficientTp = new SimpleDoubleProperty();
		coefficientProjet = new SimpleDoubleProperty();
		coefficientExpose = new SimpleDoubleProperty();
		coefficientDevoirLibre = new SimpleDoubleProperty();
		coefficientAbsence = new SimpleDoubleProperty();
		dsActive = new SimpleBooleanProperty();
		examActive = new SimpleBooleanProperty();
		tpActive = new SimpleBooleanProperty();
		projetActive = new SimpleBooleanProperty();
		exposeActive = new SimpleBooleanProperty();
		devoirLibreActive = new SimpleBooleanProperty();
		absenceActive = new SimpleBooleanProperty();
	}

	@FXML
	void valide(ActionEvent event) {
		double totalCoefficient = coefficientDs.get() + coefficientExam.get() + coefficientTp.get()
				+ coefficientProjet.get() + coefficientExpose.get() + coefficientDevoirLibre.get()
				+ coefficientAbsence.get();
		if (totalCoefficient == 1.0) {
			errorMsg.setVisible(false);
			Element element = new Element.ElementBuilder().setIdElement(this.element.getIdElement())
					.setCoefficientElement(this.element.getCoefficientElement())
					.setDesignationElement(this.element.getDesignationElement()).setDsActive(dsActive.get())
					.setCoefficientDs(coefficientDs.get()).setExamActive(examActive.get())
					.setCoefficientExam(coefficientExam.get()).setProjetActive(projetActive.get())
					.setCoefficientProjet(coefficientProjet.get()).setExposeActive(exposeActive.get())
					.setCoefficientExpose(coefficientExpose.get()).setTpActive(tpActive.get())
					.setCoefficientTp(coefficientTp.get()).setDevoirLibreActive(devoirLibreActive.get())
					.setCoefficientDevoirLibre(coefficientDevoirLibre.get()).setAbsenceActive(absenceActive.get())
					.setCoefficientAbsence(coefficientAbsence.get()).setModuleId(this.element.getModuleId())
					.setProfesseurId(this.element.getProfesseurId())
					.build();
			elementDAO.update(element);
		} else {
			errorMsg.setText("* Total coeffient invalide > 100%");
			errorMsg.setVisible(true);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		errorMsg.setVisible(false);
		coefficientElementField.setDisable(true);
		designationElementLabel.setText(element.getDesignationElement());
		coefficientElementField.setText(String.valueOf(element.getCoefficientElement()));
		coefficientDsField.setText(String.valueOf(element.getCoefficientDs()));
		coefficientExamField.setText(String.valueOf(element.getCoefficientExam()));
		coefficientTpField.setText(String.valueOf(element.getCoefficientTp()));
		coefficientProjectField.setText(String.valueOf(element.getCoefficientProjet()));
		coefficientExposeField.setText(String.valueOf(element.getCoefficientExpose()));
		coefficientDevoirLibreField.setText(String.valueOf(element.getCoefficientDevoirLibre()));
		coefficientAbsenceField.setText(String.valueOf(element.getCoefficientAbsence()));
		coefficientElement.bind(new DoubleBinding() {
			{
				bind(coefficientElementField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientElementField.textProperty().get());
			}
		});

		coefficientDs.bind(new DoubleBinding() {
			{
				bind(coefficientDsField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientDsField.textProperty().get());
			}
		});

		coefficientExam.bind(new DoubleBinding() {
			{
				bind(coefficientExamField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientExamField.textProperty().get());
			}
		});

		coefficientTp.bind(new DoubleBinding() {
			{
				bind(coefficientTpField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientTpField.textProperty().get());
			}
		});

		coefficientProjet.bind(new DoubleBinding() {
			{
				bind(coefficientProjectField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientProjectField.textProperty().get());
			}
		});

		coefficientExpose.bind(new DoubleBinding() {
			{
				bind(coefficientExposeField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientExposeField.textProperty().get());
			}
		});

		coefficientDevoirLibre.bind(new DoubleBinding() {
			{
				bind(coefficientDevoirLibreField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientDevoirLibreField.textProperty().get());
			}
		});

		coefficientAbsence.bind(new DoubleBinding() {
			{
				bind(coefficientAbsenceField.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(coefficientAbsenceField.textProperty().get());
			}
		});

		dsActiveCheckBox.selectedProperty().bindBidirectional(dsActive);
		examActiveCheckBox.selectedProperty().bindBidirectional(examActive);
		tpActiveCheckBox.selectedProperty().bindBidirectional(tpActive);
		projectActiveCheckBox.selectedProperty().bindBidirectional(projetActive);
		exposeActiveCheckBox.selectedProperty().bindBidirectional(exposeActive);
		devoireLibreActiveCheckBox.selectedProperty().bindBidirectional(devoirLibreActive);
		absenceActiveCheckBox.selectedProperty().bindBidirectional(absenceActive);

		dsActiveCheckBox.setSelected(element.getDsActive());
		examActiveCheckBox.setSelected(element.getExamActive());
		tpActiveCheckBox.setSelected(element.getTpActive());
		projectActiveCheckBox.setSelected(element.getProjetActive());
		exposeActiveCheckBox.setSelected(element.getExposeActive());
		devoireLibreActiveCheckBox.setSelected(element.getDevoirLibreActive());
		absenceActiveCheckBox.setSelected(element.getAbsenceActive());

		coefficientElementField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientElementField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		coefficientDsField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientDsField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		coefficientExamField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientExamField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		coefficientTpField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientTpField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		coefficientExposeField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientExposeField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		coefficientProjectField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientProjectField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		coefficientDevoirLibreField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientDevoirLibreField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		coefficientAbsenceField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientAbsenceField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

	}

}
