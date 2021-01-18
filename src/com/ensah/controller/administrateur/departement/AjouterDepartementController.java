package com.ensah.controller.administrateur.departement;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.DepartementDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.entity.Departement;
import com.ensah.model.entity.Professeur;

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

public class AjouterDepartementController implements Initializable {

	@FXML
	private AnchorPane ajouterDepartementPane;

	@FXML
	private TextField designationDepartementField;

	@FXML
	private ComboBox<Professeur> professeurList;

	@FXML
	private Button ajouterDepartementBtn;

	@FXML
	private Label designationDepartementMsg;

	@FXML
	private Label professeurMsg;

	private DepartementDAO departementDAO;
	private ProfesseurDAO professeurDAO;
	private ObservableList<Professeur> observableListProfesseur;
	private StringProperty designationDepartement;
	private IntegerProperty professeurId;
	private SimpleObjectProperty<Professeur> professeurSelected;
	private final int MAX_LENGTH = 100;

	public AjouterDepartementController() {
		departementDAO = new DepartementDAO();
		professeurDAO = new ProfesseurDAO();
		observableListProfesseur = FXCollections.observableList(professeurDAO.findAll());
		designationDepartement = new SimpleStringProperty();
		professeurId = new SimpleIntegerProperty();
		professeurSelected = new SimpleObjectProperty<Professeur>();
	}

	@FXML
	void ajouterDepartement(ActionEvent event) {
		if (!professeurList.getSelectionModel().isEmpty()) {
			professeurId.bindBidirectional(professeurSelected.get().idProfesseurProperty());
		}
		if (designationDepartement.get().isEmpty()) {
			designationDepartementMsg.setText("* Ce champ est obligatoire");
			designationDepartementMsg.setVisible(true);
		} else {
			designationDepartementMsg.setVisible(false);
		}
		if (professeurId.get() == 0) {
			professeurMsg.setText("* Ce champ est obligatoire");
			professeurMsg.setVisible(true);
		} else {
			professeurMsg.setVisible(false);
		}
		if (!designationDepartement.get().isEmpty() && professeurId.get() > 0) {
			Departement departement = new Departement.DepartementBuilder()
					.setDesignationDepartement(designationDepartement.get()).setProfesseurId(professeurId.get())
					.build();
			departementDAO.insert(departement);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		designationDepartementMsg.setVisible(false);
		professeurMsg.setVisible(false);
		professeurList.setItems(observableListProfesseur);
		designationDepartement.bindBidirectional(designationDepartementField.textProperty());
		professeurList.valueProperty().bindBidirectional(professeurSelected);
		professeurId.set(0);
		designationDepartementField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (designationDepartementField.getText().length() > MAX_LENGTH) {
					String s = designationDepartementField.getText().substring(0, MAX_LENGTH);
					designationDepartementField.setText(s);
				}
			}
		});
	}

}
