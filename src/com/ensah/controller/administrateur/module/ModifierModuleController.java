package com.ensah.controller.administrateur.module;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionModuleController;
import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.dao.SemestreDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Module;
import com.ensah.model.entity.Semestre;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
public class ModifierModuleController implements Initializable {

	    GestionModuleController tmp = new GestionModuleController();
	    ClasseDAO classe = new ClasseDAO();
	    SemestreDAO semestre = new SemestreDAO();
	    ModuleDAO mdl =new ModuleDAO();

	      Module module = tmp.getModule();

    @FXML
    private AnchorPane modifierModulePane;

    @FXML
    private TextField designationModuleField;

    @FXML
    private ComboBox<Classe> classeList;

    @FXML
    private ComboBox<Semestre> semestreList;

    @FXML
    private Button modifierModuleBtn;

    @FXML
    void modifierModule(ActionEvent event) {
        module.setDesignationModule(designationModuleField.getText());
        module.setSemesterId((semestreList.getSelectionModel().getSelectedItem()).getIdSemestre());
        mdl.update(module);
    	 
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Classe> clss = FXCollections.observableList(classe.findAll());
		ObservableList<Semestre> sems =FXCollections.observableList(semestre.findAll());
	  classeList.setItems(clss)	;
	  semestreList.setItems(sems);
      Module module = tmp.getModule();

      System.out.println(module);
      designationModuleField.setText(module.getDesignationModule());
      Semestre sem = (semestre.find(module.getSemesterId())).get();
      Classe cls = classe.find(sem.getClasseId()).get();
      classeList.setValue(cls);
      semestreList.setValue(sem);
      
      
      
      
		
	}

}
