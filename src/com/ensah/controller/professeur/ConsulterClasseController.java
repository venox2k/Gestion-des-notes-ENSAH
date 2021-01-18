package com.ensah.controller.professeur;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.FiliereDAO;
import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.dao.SemestreDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Filiere;
import com.ensah.model.entity.Module;
import com.ensah.model.entity.Semestre;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

public class ConsulterClasseController implements Initializable {

	@FXML
	private AnchorPane consulterClassePane;

	@FXML
	private Label designationClasseLabel;

	@FXML
	private Label designationFiliereLabel;

	@FXML
	private TitledPane moduleTitledPane;

	@FXML
	private ListView<Module> moduleClasseList;

	private ProfesseurDAO professeurDAO;
	private ModuleDAO moduleDAO;
	private ElementDAO elementDAO;
	private FiliereDAO filiereDAO;
	private SemestreDAO semestreDAO;
	private ClasseDAO classeDAO;
	private ObservableList<Module> observableListModule;
	private Module module;
	private Semestre semestre;
	private Classe classe;
	private Filiere filiere;

	public ConsulterClasseController() {
		professeurDAO = new ProfesseurDAO();
		moduleDAO = new ModuleDAO();
		elementDAO = new ElementDAO();
		semestreDAO = new SemestreDAO();
		classeDAO = new ClasseDAO();
		filiereDAO = new FiliereDAO();
		int professeurId = 5;// professeur id
		List<Element> element = new ArrayList<Element>(elementDAO.findProfesseur(professeurId));
		int moduleId = element.get(0).getModuleId();
		module = moduleDAO.find(moduleId).get();
		semestre = semestreDAO.find(module.getSemesterId()).get();
		classe = classeDAO.find(semestre.getClasseId()).get();
		filiere = filiereDAO.find(classe.getFiliereId()).get();
		observableListModule = FXCollections.observableList(moduleDAO.findSemestre(semestre.getIdSemestre()));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		designationClasseLabel.setText(classe.getDesignationClasse());
		designationFiliereLabel.setText(filiere.getDesignationFiliere());
		moduleClasseList.setItems(observableListModule);
	}

}
