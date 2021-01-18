package com.ensah.controller.administrateur.etudiant;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.EtudiantDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Etudiant;

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

public class AjouterEtudiantController implements Initializable {

	@FXML
	private AnchorPane ajouterEtudiantPane;

	@FXML
	private TextField cneEtudiantField;

	@FXML
	private TextField cinEtudiantField;

	@FXML
	private TextField nomEtudiantField;

	@FXML
	private TextField prenomEtudiantField;

	@FXML
	private ComboBox<Classe> classeList;

	@FXML
	private Button ajouterEtudiantBtn;

	@FXML
	private Label cneMsg;
	@FXML
	private Label cinMsg;
	@FXML
	private Label nomMsg;
	@FXML
	private Label prenomMsg;
	@FXML
	private Label classeMsg;

	private EtudiantDAO etudiantDAO;
	private ClasseDAO classeDAO;
	private ObservableList<Classe> observableListClasse;
	private StringProperty cinEtudiant;
	private StringProperty cneEtudiant;
	private StringProperty nomEtudiant;
	private StringProperty prenomEtudiant;
	private IntegerProperty classeId;
	private SimpleObjectProperty<Classe> classeSelected;
	private final int MAX_LENGTH_CIN_CNE = 11;
	private final int MAX_LENGTH = 45;

	public AjouterEtudiantController() {
		etudiantDAO = new EtudiantDAO();
		classeDAO = new ClasseDAO();
		observableListClasse = FXCollections.observableList(classeDAO.findAll());
		cinEtudiant = new SimpleStringProperty();
		cneEtudiant = new SimpleStringProperty();
		nomEtudiant = new SimpleStringProperty();
		prenomEtudiant = new SimpleStringProperty();
		classeId = new SimpleIntegerProperty();
		classeSelected = new SimpleObjectProperty<Classe>();
	}

	@FXML
	void ajouterEtudiant(ActionEvent event) {
		if (!classeList.getSelectionModel().isEmpty()) {
			classeId.bindBidirectional(classeSelected.get().idClasseProperty());
		}
		if (cinEtudiant.get().isEmpty()) {
			cinMsg.setText("* Ce champ est obligatoire");
			cinMsg.setVisible(true);
		} else {
			cinMsg.setVisible(false);
		}
		if (cneEtudiant.get().isEmpty()) {
			cneMsg.setText("* Ce champ est obligatoire");
			cneMsg.setVisible(true);
		} else {
			cneMsg.setVisible(false);
		}
		if (nomEtudiant.get().isEmpty()) {
			nomMsg.setText("* Ce champ est obligatoire");
			nomMsg.setVisible(true);
		} else {
			nomMsg.setVisible(false);
		}
		if (prenomEtudiant.get().isEmpty()) {
			prenomMsg.setText("* Ce champ est obligatoire");
			prenomMsg.setVisible(true);
		} else {
			prenomMsg.setVisible(false);
		}
		if (classeId.get() == 0) {
			classeMsg.setText("* Ce champ est obligatoire");
			classeMsg.setVisible(true);
		} else {
			classeMsg.setVisible(false);
		}
		if (!cinEtudiant.get().isEmpty() && !cneEtudiant.get().isEmpty() && !nomEtudiant.get().isEmpty()
				&& !prenomEtudiant.get().isEmpty() && classeId.get() > 0) {
			Etudiant etudiant = new Etudiant.EtudiantBuilder().setCinEtudiant(cinEtudiant.get())
					.setCneEtudiant(cneEtudiant.get()).setNomEtudiant(nomEtudiant.get())
					.setPrenomEtudiant(prenomEtudiant.get()).setClasseId(classeId.get()).build();
			etudiantDAO.insert(etudiant);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cneMsg.setVisible(false);
		cinMsg.setVisible(false);
		nomMsg.setVisible(false);
		prenomMsg.setVisible(false);
		classeMsg.setVisible(false);
		classeList.setItems(observableListClasse);
		cneEtudiant.bindBidirectional(cneEtudiantField.textProperty());
		cinEtudiant.bindBidirectional(cinEtudiantField.textProperty());
		nomEtudiant.bindBidirectional(nomEtudiantField.textProperty());
		prenomEtudiant.bindBidirectional(prenomEtudiantField.textProperty());
		classeList.valueProperty().bindBidirectional(classeSelected);
		classeId.set(0);
		cneEtudiantField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (cneEtudiantField.getText().length() > MAX_LENGTH_CIN_CNE) {
					String s = cneEtudiantField.getText().substring(0, MAX_LENGTH_CIN_CNE);
					cneEtudiantField.setText(s);
				}
			}
		});
		cinEtudiantField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (cinEtudiantField.getText().length() > MAX_LENGTH_CIN_CNE) {
					String s = cinEtudiantField.getText().substring(0, MAX_LENGTH_CIN_CNE);
					cinEtudiantField.setText(s);
				}
			}
		});

		nomEtudiantField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (nomEtudiantField.getText().length() > MAX_LENGTH_CIN_CNE) {
					String s = nomEtudiantField.getText().substring(0, MAX_LENGTH);
					nomEtudiantField.setText(s);
				}
			}
		});
		prenomEtudiantField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (prenomEtudiantField.getText().length() > MAX_LENGTH_CIN_CNE) {
					String s = prenomEtudiantField.getText().substring(0, MAX_LENGTH);
					prenomEtudiantField.setText(s);
				}
			}
		});
	}

}
