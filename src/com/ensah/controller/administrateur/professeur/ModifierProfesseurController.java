package com.ensah.controller.administrateur.professeur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionProfesseurController;
import com.ensah.model.dao.DepartementDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.entity.Departement;
import com.ensah.model.entity.Professeur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ModifierProfesseurController implements Initializable{

	GestionProfesseurController tmp = new GestionProfesseurController();
	DepartementDAO dep = new DepartementDAO();
	ProfesseurDAO prf = new ProfesseurDAO();

	
    @FXML
    private AnchorPane modifierProfesseurPane;

    @FXML
    private TextField nomProfesseurField;

    @FXML
    private TextField prenomProfesseurField;

    @FXML
    private TextField emailProfesseurField;

    @FXML
    private ComboBox<Departement> departementList;

    @FXML
    private Button modifierProfesseurBtn;

    @FXML
    void modifierProfesseur(ActionEvent event) {
        
		Professeur prof = tmp.getProf();
		prof.setNomProfesseur(nomProfesseurField.getText());
		prof.setPrenomProfesseur(prenomProfesseurField.getText());
		prof.setEmailProfesseur(emailProfesseurField.getText());
		prof.setDepartementId((departementList.getSelectionModel().getSelectedItem()).getIdDepartement());
		prf.update(prof);
		
        
    	
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<Departement> deps = FXCollections.observableList(dep.findAll());
        departementList.setItems(deps);
        
		Professeur prof = tmp.getProf();
		nomProfesseurField.setText(prof.getNomProfesseur());
		prenomProfesseurField.setText(prof.getPrenomProfesseur());
		emailProfesseurField.setText(prof.getEmailProfesseur());
		departementList.setValue(dep.find(prof.getDepartementId()).get());
		
	}

}
