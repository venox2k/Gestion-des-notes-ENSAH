package com.ensah.controller.administrateur.element;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.dao.SemestreDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Module;
import com.ensah.model.entity.Professeur;
import com.ensah.model.entity.Semestre;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AjouterElementController implements Initializable {

	@FXML
	private AnchorPane ajouterElementPane;

	@FXML
	private TextField designationElementField;

	@FXML
	private ComboBox<Module> moduleList;

	@FXML
	private ComboBox<Professeur> professeurList;

	@FXML
	private ComboBox<Classe> classeList;

	@FXML
	private TextField coefficientElementField;

	@FXML
	private Button ajouterElementBtn;

	@FXML
	private Label designationMsg;

	@FXML
	private Label moduleMsg;

	@FXML
	private Label professeurMsg;

	@FXML
	private Label classeMsg;

	@FXML
	private Label coefficientMsg;

	private ElementDAO elementDAO;

	private SemestreDAO semestreDAO;

	private ModuleDAO moduleDAO;

	private ClasseDAO classeDAO;

	private ProfesseurDAO professeurDAO;

	private List<Element> elements;

	private ObservableList<Module> observableListModule;

	private ObservableList<Professeur> observableListProfesseur;

	private ObservableList<Classe> observableListClasse;

	private StringProperty designationElement;

	private IntegerProperty moduleId;

	private IntegerProperty professeurId;

	private IntegerProperty classeId;

	private DoubleProperty coefficientElement;

	private SimpleObjectProperty<Module> moduleSelected;

	private SimpleObjectProperty<Professeur> professeurSelected;

	private SimpleObjectProperty<Classe> classeSelected;

	private final int MAX_LENGTH = 45;

	public AjouterElementController() {
		elementDAO = new ElementDAO();
		moduleDAO = new ModuleDAO();
		professeurDAO = new ProfesseurDAO();
		classeDAO = new ClasseDAO();
		semestreDAO = new SemestreDAO();
		observableListModule = FXCollections.observableList(moduleDAO.findAll());
		observableListProfesseur = FXCollections.observableList(professeurDAO.findAll());
		observableListClasse = FXCollections.observableList(classeDAO.findAll());
		designationElement = new SimpleStringProperty();
		moduleId = new SimpleIntegerProperty();
		professeurId = new SimpleIntegerProperty();
		classeId = new SimpleIntegerProperty();
		coefficientElement = new SimpleDoubleProperty(-1);
		moduleSelected = new SimpleObjectProperty<Module>();
		professeurSelected = new SimpleObjectProperty<Professeur>();
		classeSelected = new SimpleObjectProperty<Classe>();
	}

	@FXML
	void classeAction(ActionEvent event) {
		classeId.bindBidirectional(classeSelected.get().idClasseProperty());
		List<Semestre> semestres = semestreDAO.findClasse(classeId.get());
		observableListModule = FXCollections.observableArrayList();
		for (Semestre semestre : semestres) {
			observableListModule.addAll(moduleDAO.findSemestre(semestre.getIdSemestre()));
		}
		moduleList.setItems(observableListModule);
	}

	@FXML
	void moduleAction(ActionEvent event) {
		moduleId.bindBidirectional(moduleSelected.get().idModuleProperty());
		elements = elementDAO.findModule(moduleId.get());
	}

	@FXML
	void ajouterElement(ActionEvent event) {
		if (!coefficientElementField.textProperty().get().isEmpty()) {
			coefficientElement.bind(new DoubleBinding() {
				{
					bind(coefficientElementField.textProperty());
				}

				@Override
				protected double computeValue() {
					return Double.parseDouble(coefficientElementField.textProperty().get());
				}
			});
		}
		if (!professeurList.getSelectionModel().isEmpty()) {
			professeurId.bindBidirectional(professeurSelected.get().idProfesseurProperty());
		}
		if (designationElement.get().isEmpty()) {
			designationMsg.setText("* Ce champ est obligatoire");
			designationMsg.setVisible(true);
		} else {
			designationMsg.setVisible(false);
		}
		if (classeId.get() == 0) {
			classeMsg.setText("* Ce champ est obligatoire");
			classeMsg.setVisible(true);
		} else {
			classeMsg.setVisible(false);
		}
		if (moduleId.get() == 0) {
			moduleMsg.setText("* Ce champ est obligatoire");
			moduleMsg.setVisible(true);
		} else {
			moduleMsg.setVisible(false);
		}
		if (professeurId.get() == 0) {
			professeurMsg.setText("* Ce champ est obligatoire");
			professeurMsg.setVisible(true);
		} else {
			professeurMsg.setVisible(false);
		}
		if (coefficientElement.get() > 1 || coefficientElement.get() < 0) {
			coefficientMsg.setText("* Coefficient Valide [0,1]");
			coefficientMsg.setVisible(true);
		} else {
			coefficientMsg.setVisible(false);
		}

		Element newElement = new Element.ElementBuilder().setDesignationElement(designationElement.get())
				.setCoefficientElement(coefficientElement.get()).setDsActive(true).setExamActive(true)
				.setTpActive(false).setProjetActive(false).setExposeActive(false).setDevoirLibreActive(false)
				.setAbsenceActive(false).setCoefficientDs(0.4).setCoefficientExam(0.6).setCoefficientTp(0.0)
				.setCoefficientProjet(0.0).setCoefficientExpose(0.0).setCoefficientDevoirLibre(0.0)
				.setCoefficientAbsence(0.0).setModuleId(moduleId.get()).setProfesseurId(professeurId.get()).build();
		elementDAO.insert(newElement);
		for (Element element : elements) {
			element.setCoefficientElement(
					element.getCoefficientElement() - (coefficientElement.get() / elements.size()));
		}
		for (Element element : elements) {
			elementDAO.updateCSV(element);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		designationMsg.setVisible(false);
		moduleMsg.setVisible(false);
		professeurMsg.setVisible(false);
		coefficientMsg.setVisible(false);
		classeMsg.setVisible(false);
		moduleList.setItems(observableListModule);
		professeurList.setItems(observableListProfesseur);
		classeList.setItems(observableListClasse);
		designationElement.bindBidirectional(designationElementField.textProperty());
		moduleList.valueProperty().bindBidirectional(moduleSelected);
		professeurList.valueProperty().bindBidirectional(professeurSelected);
		classeList.valueProperty().bindBidirectional(classeSelected);
		moduleId.set(0);
		professeurId.set(0);
		classeId.set(0);
		designationElementField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (designationElementField.getText().length() > MAX_LENGTH) {
					String s = designationElementField.getText().substring(0, MAX_LENGTH);
					designationElementField.setText(s);
				}
			}
		});
		coefficientElementField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					coefficientElementField.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

	}

}
