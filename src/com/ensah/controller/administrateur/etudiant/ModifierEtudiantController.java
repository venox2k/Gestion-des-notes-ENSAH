package com.ensah.controller.administrateur.etudiant;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionEtudiantController;
import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.EtudiantDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Etudiant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ModifierEtudiantController implements Initializable {

	GestionEtudiantController tmp = new GestionEtudiantController();
	EtudiantDAO etd = new EtudiantDAO();
	ClasseDAO cls = new ClasseDAO();

	@FXML
	private AnchorPane modifierEtudiantPane;

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
	private Button modifierEtudiantBtn;

	@FXML
	void modifierEtudiant(ActionEvent event) {

		Etudiant etudiant = tmp.getEtudiant();
		etudiant.setCneEtudiant(cneEtudiantField.getText());
		etudiant.setCinEtudiant(cinEtudiantField.getText());
		etudiant.setNomEtudiant(nomEtudiantField.getText());
		etudiant.setPrenomEtudiant(prenomEtudiantField.getText());
		etudiant.setClasseId(classeList.getSelectionModel().getSelectedItem().getIdClasse());
		etd.update(etudiant);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{

		ObservableList<Classe> classes = FXCollections.observableList(cls.findAll());
		classeList.setItems(classes);
		Etudiant etudiant = tmp.getEtudiant();
		cneEtudiantField.setText(etudiant.getCneEtudiant());
		cinEtudiantField.setText(etudiant.getCinEtudiant());
		nomEtudiantField.setText(etudiant.getNomEtudiant());
		prenomEtudiantField.setText(etudiant.getPrenomEtudiant());
		ClasseDAO cls = new ClasseDAO();
		classeList.setValue(cls.find(etudiant.getClasseId()).get());

	}

}
