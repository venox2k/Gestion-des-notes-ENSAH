package com.ensah.controller.professeur;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.EtudiantDAO;
import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.dao.SemestreDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Etudiant;
import com.ensah.model.entity.Module;
import com.ensah.model.entity.Semestre;
import com.ensah.model.entityData.EtudiantData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ConsulterEtudiantController implements Initializable {

	@FXML
	private AnchorPane consulterEtudiantPane;

	@FXML
	private TableView<Etudiant> etudiantTableView;

	@FXML
	private TableColumn<Etudiant, String> cneEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, String> cinEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, String> nomEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, String> prenomEtudiantColumn;

	private EtudiantDAO etudiantDAO;
	private Label semesterLabel;
	private ProfesseurDAO professeurDAO;
	private ModuleDAO moduleDAO;
	private ElementDAO elementDAO;
	private SemestreDAO semestreDAO;
	private ClasseDAO classeDAO;
	private Classe classe;

	public ConsulterEtudiantController() {
		etudiantDAO = new EtudiantDAO();
		professeurDAO = new ProfesseurDAO();
		moduleDAO = new ModuleDAO();
		elementDAO = new ElementDAO();
		semestreDAO = new SemestreDAO();
		classeDAO = new ClasseDAO();
		int professeurId = 5;// professeur id
		List<Element> element = new ArrayList<Element>(elementDAO.findProfesseur(professeurId));
		int moduleId = element.get(0).getModuleId();
		Module module = moduleDAO.find(moduleId).get();
		Semestre semestre = semestreDAO.find(module.getSemesterId()).get();
		classe = classeDAO.find(semestre.getClasseId()).get();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		etudiantTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		cneEtudiantColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, String>(EtudiantData.cneEtudiant.getValue()));
		cinEtudiantColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, String>(EtudiantData.cinEtudiant.getValue()));
		nomEtudiantColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, String>(EtudiantData.nomEtudiant.getValue()));
		prenomEtudiantColumn.setCellValueFactory(
				new PropertyValueFactory<Etudiant, String>(EtudiantData.prenomEtudiant.getValue()));
	}

	public ObservableList<Etudiant> getRows() {
		ObservableList<Etudiant> observableListEtudiant = FXCollections.observableArrayList();
		observableListEtudiant.addAll(etudiantDAO.findClasse(classe.getIdClasse()));
		return observableListEtudiant;
	}

}
