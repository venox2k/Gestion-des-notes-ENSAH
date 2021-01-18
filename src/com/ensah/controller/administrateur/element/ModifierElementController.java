package com.ensah.controller.administrateur.element;

import java.net.URL;


import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionElementController;
import com.ensah.controller.administrateur.GestionModuleController;
import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Professeur;
import com.ensah.model.entity.Module;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ModifierElementController implements Initializable{

   GestionElementController tmp = new GestionElementController();
     ModuleDAO mod = new ModuleDAO();
	  ProfesseurDAO prof = new ProfesseurDAO();
    
	
    @FXML
    private AnchorPane modifierElementPane;

    @FXML
    private TextField designationElementField;

    @FXML
    private ComboBox<Module> moduleList;

    @FXML
    private ComboBox<Professeur> professeurList;

    @FXML
    private TextField coefficientElement;

    @FXML
    private Button modifierElementBtn;

    @FXML
    void modifierElement(ActionEvent event) {
   	 Element element = tmp.getElement();
     element.setDesignationElement(designationElementField.getText());
     element.setCoefficientElement(Double.valueOf(coefficientElement.getText()));
     element.setProfesseurId((professeurList.getSelectionModel().getSelectedItem()).getIdProfesseur());
     element.setModuleId((moduleList.getSelectionModel().getSelectedItem()).getIdModule());
     ElementDAO ele = new ElementDAO();
     ele.update1(element);
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	  
		ObservableList<Module> mods = FXCollections.observableList(mod.findAll());
		ObservableList<Professeur> profs = FXCollections.observableList(prof.findAll());
		moduleList.setItems(mods);
		professeurList.setItems(profs);
		
		
	 Element element = tmp.getElement();
	  designationElementField.setText(element.getDesignationElement());
	  coefficientElement.setText(String.valueOf(element.getCoefficientElement()));
	 
	  moduleList.setValue(mod.find(element.getModuleId()).get());
	  professeurList.setValue(prof.find(element.getProfesseurId()).get());
	  
	}

}
