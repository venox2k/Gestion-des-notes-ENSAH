package com.ensah.controller.administrateur.classe;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.FiliereDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Filiere;

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

public class AjouterClasseController implements Initializable {

	@FXML
	private AnchorPane ajouterClassePane;

	@FXML
	private TextField designationClasseField;

	@FXML
	private ComboBox<Filiere> filiereList;

	@FXML
	private Button ajouterClasseBtn;

	@FXML
	private Label filiereMsg;

	@FXML
	private Label designationClasseMsg;

	private ClasseDAO classeDAO;
	
	private FiliereDAO filiereDAO;
	
	private ObservableList<Filiere> observableListFiliere;
	
	private StringProperty designationClasse;
	
	private IntegerProperty filiereId;
	
	private SimpleObjectProperty<Filiere> filiereSelected;
	
	private final int MAX_LENGTH = 5;

	public AjouterClasseController() {
		classeDAO = new ClasseDAO();
		filiereDAO = new FiliereDAO();
		observableListFiliere = FXCollections.observableList(filiereDAO.findAll());
		designationClasse = new SimpleStringProperty();
		filiereId = new SimpleIntegerProperty();
		filiereSelected = new SimpleObjectProperty<Filiere>();
	}

	@FXML
	void ajouterClasse(ActionEvent event) {
		if (!filiereList.getSelectionModel().isEmpty()) {
			filiereId.bindBidirectional(filiereSelected.get().idFiliereProperty());
		}
		if (designationClasse.get().isEmpty()) {
			designationClasseMsg.setText("* Ce champ est obligatoire");
			designationClasseMsg.setVisible(true);
		} else {
			designationClasseMsg.setVisible(false);
		}
		if (filiereId.get() == 0) {
			filiereMsg.setText("* Ce champ est obligatoire");
			filiereMsg.setVisible(true);
		} else {
			filiereMsg.setVisible(false);
		}
		if (!designationClasse.get().isEmpty() && filiereId.get() > 0) {
			Classe classe = new Classe.ClasseBuilder().setDesignationClasse(designationClasse.get())
					.setFiliereId(filiereId.get()).build();
			classeDAO.insert(classe);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		designationClasseMsg.setVisible(false);
		filiereMsg.setVisible(false);
		filiereList.setItems(observableListFiliere);
		designationClasse.bindBidirectional(designationClasseField.textProperty());
		filiereList.valueProperty().bindBidirectional(filiereSelected);
		filiereId.set(0);
		designationClasseField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (designationClasseField.getText().length() > MAX_LENGTH) {
					String s = designationClasseField.getText().substring(0, MAX_LENGTH);
					designationClasseField.setText(s);
				}
			}
		});
	}

}
