package com.ensah.controller.administrateur.filiere;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionFiliereController;
import com.ensah.model.dao.DepartementDAO;
import com.ensah.model.dao.FiliereDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.entity.Departement;
import com.ensah.model.entity.Filiere;
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

public class ModifierFiliereController implements Initializable {

	GestionFiliereController tmp = new GestionFiliereController();
	DepartementDAO dpt = new DepartementDAO();
	ProfesseurDAO prof = new ProfesseurDAO();
	
	
    @FXML
    private AnchorPane modifierFilierePane;

    @FXML
    private TextField designationFiliereField;

    @FXML
    private TextField noteEliminatoireFiliereField;

    @FXML
    private ComboBox<Departement> departementList;

    @FXML
    private ComboBox<Professeur> professeurList;

    @FXML
    private Button modifierFiliereBtn;

    @FXML
    void modifierFiliere(ActionEvent event) {
		Filiere filiere = tmp.getfiliere();
        filiere.setDepartementId(departementList.getSelectionModel().getSelectedItem().getIdDepartement());
        filiere.setDesignationFiliere(designationFiliereField.getText());
        filiere.setProfesseurId(professeurList.getSelectionModel().getSelectedItem().getIdProfesseur());
        filiere.setNoteEliminatoireFiliere(Double.valueOf(noteEliminatoireFiliereField.getText()));
        FiliereDAO fil = new FiliereDAO();
        fil.update(filiere);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Departement> dpts = FXCollections.observableList(dpt.findAll());
		ObservableList<Professeur> profs =FXCollections.observableList(prof.findAll());
			
		departementList.setItems(dpts);
		professeurList.setItems(profs);
		
		Filiere filiere = tmp.getfiliere();
		designationFiliereField.setText(filiere.getDesignationFiliere());
		noteEliminatoireFiliereField.setText(String.valueOf(filiere.getNoteEliminatoireFiliere()));
		
		departementList.setValue(dpt.find(filiere.getDepartementId()).get());
		professeurList.setValue(prof.find(filiere.getProfesseurId()).get());
		
	}

}
