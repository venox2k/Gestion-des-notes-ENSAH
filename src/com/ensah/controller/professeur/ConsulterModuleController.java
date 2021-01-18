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
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Module;
import com.ensah.model.entity.Semestre;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class ConsulterModuleController implements Initializable {

	@FXML
	private AnchorPane consulterModulePane;

	@FXML
	private Label designationModuleLabel;

	@FXML
	private ListView<Element> elementList;

	@FXML
	private Label semesterLabel;
	private ProfesseurDAO professeurDAO;
	private ModuleDAO moduleDAO;
	private ElementDAO elementDAO;
	private SemestreDAO semestreDAO;
	private ClasseDAO classeDAO;
	private ObservableList<Element> observableListElement;
	private Module module;
	private Semestre semestre;

	public ConsulterModuleController() {
		professeurDAO = new ProfesseurDAO();
		moduleDAO = new ModuleDAO();
		elementDAO = new ElementDAO();
		semestreDAO = new SemestreDAO();
		int professeurId = 5;// professeur id
		System.out.println(elementDAO.findProfesseur(professeurId));
		List<Element> element = new ArrayList<Element>(elementDAO.findProfesseur(professeurId));
		int moduleId = element.get(0).getModuleId();
		module = moduleDAO.find(moduleId).get();
		semestre = semestreDAO.find(module.getSemesterId()).get();
		observableListElement = FXCollections.observableList(elementDAO.findModule(moduleId));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		designationModuleLabel.setText(module.getDesignationModule());
		semesterLabel.setText(semestre.getDesignationSemestre());
		elementList.setItems(observableListElement);
	}

}