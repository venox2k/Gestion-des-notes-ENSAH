package com.ensah.controller.administrateur.module;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.dao.SemestreDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Module;
import com.ensah.model.entity.Semestre;

import javafx.beans.property.IntegerProperty;
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

public class AjouterModuleController implements Initializable {

	private ModuleDAO moduleDAO;
	private ElementDAO elementDAO;
	private SemestreDAO semestreDAO;
	private ClasseDAO classeDAO;
	private ObservableList<Classe> observableListClasse;
	private ObservableList<Semestre> observableListSemestre;
	private StringProperty designationModule;
	private IntegerProperty classeId;
	private IntegerProperty semestreId;
	private SimpleObjectProperty<Classe> classeSelected;
	private SimpleObjectProperty<Semestre> semestreSelected;
	private final int MAX_LENGTH = 100;

	public AjouterModuleController() {
		moduleDAO = new ModuleDAO();
		elementDAO = new ElementDAO();
		semestreDAO = new SemestreDAO();
		classeDAO = new ClasseDAO();
		observableListClasse = FXCollections.observableList(classeDAO.findAll());
		observableListSemestre = FXCollections.observableList(semestreDAO.findAll());
		designationModule = new SimpleStringProperty();
		classeId = new SimpleIntegerProperty();
		semestreId = new SimpleIntegerProperty();
		classeSelected = new SimpleObjectProperty<Classe>();
		semestreSelected = new SimpleObjectProperty<Semestre>();
	}

	@FXML
	private AnchorPane ajouterModulePane;

	@FXML
	private TextField designationModuleField;

	@FXML
	private ComboBox<Classe> classeList;

	@FXML
	private ComboBox<Semestre> semestreList;

	@FXML
	private Button ajouterModuleBtn;

	@FXML
	private Label desigationModuleMsg;

	@FXML
	private Label classeMsg;

	@FXML
	void ajouterModule(ActionEvent event) {
		if (!classeList.getSelectionModel().isEmpty()) {
			semestreId.bindBidirectional(semestreSelected.get().idSemestreProperty());
		}

		if (designationModule.get().isEmpty()) {
			desigationModuleMsg.setText("* Ce champ est obligatoire");
			desigationModuleMsg.setVisible(true);
		} else {
			desigationModuleMsg.setVisible(false);
		}

		if (classeId.get() == 0) {
			classeMsg.setText("* Ce champ est obligatoire");
			classeMsg.setVisible(true);
		} else {
			classeMsg.setVisible(false);
		}
		if (!designationModule.get().isEmpty() && classeId.get() > 0 && semestreId.get() > 0) {
			Module module = new Module.ModuleBuilder().setDesignationModule(designationModule.get())
					.setSemesterId(semestreId.get()).build();
			moduleDAO.insert(module);
			Element element = new Element.ElementBuilder().setDesignationElement(designationModule.get())
					.setCoefficientElement(1.0).setDsActive(true).setExamActive(true).setTpActive(false)
					.setProjetActive(false).setExposeActive(false).setDevoirLibreActive(false).setAbsenceActive(false)
					.setCoefficientDs(0.4).setCoefficientExam(0.6).setCoefficientTp(0.0).setCoefficientProjet(0.0)
					.setCoefficientExpose(0.0).setCoefficientDevoirLibre(0.0).setCoefficientAbsence(0.0)
					.setModuleId(moduleDAO.findLastModuleId()).build();
			elementDAO.insertCSV(element);
		}
	}

	@FXML
	void classeAction(ActionEvent event) {
		classeId.bindBidirectional(classeSelected.get().idClasseProperty());
		observableListSemestre = FXCollections.observableList(semestreDAO.findClasse(classeId.get()));
		semestreList.setItems(observableListSemestre);
		semestreList.getSelectionModel().selectFirst();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		desigationModuleMsg.setVisible(false);
		classeMsg.setVisible(false);
		classeList.setItems(observableListClasse);
		semestreList.setItems(observableListSemestre);
		designationModule.bindBidirectional(designationModuleField.textProperty());
		classeList.valueProperty().bindBidirectional(classeSelected);
		semestreList.valueProperty().bindBidirectional(semestreSelected);
		classeId.set(0);
		semestreId.set(0);

		designationModuleField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (designationModuleField.getText().length() > MAX_LENGTH) {
					String s = designationModuleField.getText().substring(0, MAX_LENGTH);
					designationModuleField.setText(s);
				}
			}
		});

	}

}
