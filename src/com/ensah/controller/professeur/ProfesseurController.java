package com.ensah.controller.professeur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.utils.LoadUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ProfesseurController implements Initializable{

	private LoadUI loadUI;

	private String path;

	public ProfesseurController() {
		path = "/com/ensah/view/professeur/";
		loadUI = new LoadUI();
	}

	@FXML
	private AnchorPane professeurDashboard;

	@FXML
	private BorderPane borderPaneProfesseur;

	@FXML
	private Button professeurBtn;

	@FXML
	private Button gestionElementBtn;

	@FXML
	private Button gestionNoteElementBtn;

	@FXML
	private Button consulterModuleBtn;

	@FXML
	private Button consulterNoteModuleBtn;

	@FXML
	private Button consulterEtudiantBtn;

	@FXML
	private Button consulterClasseBtn;

	@FXML
	private Button consulterSemesterBtn;

	@FXML
	void professeur(ActionEvent event) {
		System.out.println("professeur");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "ProfesseurAcceuil.fxml"));
	}

	@FXML
	void consulterClasse(ActionEvent event) {
		System.out.println("consulterClasse");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "ConsulterClasse.fxml"));
	}

	@FXML
	void consulterEtudiant(ActionEvent event) {
		System.out.println("consulterEtudiant");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "ConsulterEtudiant.fxml"));
	}

	@FXML
	void consulterModule(ActionEvent event) {
		System.out.println("consulterModule");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "ConsulterModule.fxml"));
	}

	@FXML
	void consulterNoteModule(ActionEvent event) {
		System.out.println("consulterNoteModule");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "ConsulterNoteModule.fxml"));
	}

	@FXML
	void consulterSemester(ActionEvent event) {
		System.out.println("consulterSemester");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "ConsulterSemester.fxml"));
	}

	@FXML
	void gestionElement(ActionEvent event) {
		System.out.println("gestionElement");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "GestionElement.fxml"));
	}

	@FXML
	void gestionNoteElement(ActionEvent event) {
		System.out.println("gestionNoteElement");
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "GestionNoteElement.fxml"));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		borderPaneProfesseur.setCenter(loadUI.loadUI(path + "ProfesseurAcceuil.fxml"));
	}

}
