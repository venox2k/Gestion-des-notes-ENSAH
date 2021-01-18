package com.ensah.controller.administrateur.departement;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionDepartementController;
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

public class ModifierDepartementController implements Initializable {

	GestionDepartementController tmp = new GestionDepartementController();
    ProfesseurDAO prof = new ProfesseurDAO();

	
    @FXML
    private AnchorPane modifierDepartementPane;

    @FXML
    private TextField designationDepartementField;

    @FXML
    private ComboBox<Professeur> professeurList;

    @FXML
    private Button modifierDepartementBtn;

    @FXML
    void modifierDepartement(ActionEvent event) {
        Departement departement = tmp.getDepartement();
        departement.setDesignationDepartement(designationDepartementField.getText());
        departement.setProfesseurId(professeurList.getSelectionModel().getSelectedItem().getIdProfesseur());
        DepartementDAO dpt = new DepartementDAO();
        dpt.update(departement);
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Professeur> prfs = FXCollections.observableList(prof.findAll());
		professeurList.setItems(prfs);
       Departement departement = tmp.getDepartement();
       designationDepartementField.setText(departement.getDesignationDepartement());
       professeurList.setValue(prof.find(departement.getProfesseurId()).get());
		
		
	}

}
