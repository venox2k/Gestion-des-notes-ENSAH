package com.ensah.controller.administrateur.classe;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionClasseController;
import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.FiliereDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Filiere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ModifierClasseController implements Initializable {

	GestionClasseController tmp = new GestionClasseController();
	FiliereDAO fil = new FiliereDAO();
	ClasseDAO cls = new ClasseDAO();
	
	@FXML
	private AnchorPane modifierClassePane;

	@FXML
	private TextField designationClasseField;

	@FXML
	private ComboBox<Filiere> filiereList;

	@FXML
	private Button modifierClasseBtn;

	@FXML
	void modifierClasse(ActionEvent event) {
	     Classe classe = tmp.getClasse();
         classe.setDesignationClasse(designationClasseField.getText());
         classe.setFiliereId(filiereList.getSelectionModel().getSelectedItem().getIdFiliere());
         cls.update(classe);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
     Classe classe = tmp.getClasse();
     designationClasseField.setText(classe.getDesignationClasse());
     filiereList.setValue(fil.find(classe.getFiliereId()).get());
		
	}

}
