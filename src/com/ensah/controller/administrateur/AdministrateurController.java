package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.utils.LoadUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AdministrateurController implements Initializable {

	private LoadUI loadUI ;
	private String path ;
	
	public AdministrateurController() {
		
		path = "/com/ensah/view/administrateur/";
		loadUI = new LoadUI();
	}

	@FXML
	private AnchorPane administrateurDashboard;

	@FXML
	private BorderPane borderPaneAdministrateur;

	@FXML
	private Button administrateurBtn;

	@FXML
	private Button gestionProfesseurBtn;

	@FXML
	private Button gestionUtilisateurBtn;

	@FXML
	private Button gestionModuleBtn;

	@FXML
	private Button gestionElementBtn;

	@FXML
	private Button gestionClasseBtn;

	@FXML
	private Button gestionEtudiantBtn;

	@FXML
	private Button gestionDepartementBtn;

	@FXML
	private Button gestionFiliereBtn;

	@FXML
	void administrateur(ActionEvent event) {
		System.out.println("administrateur");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "AdministrateurAcceuil.fxml"));
	}

	@FXML
	void gestionProfesseur(ActionEvent event) {
		System.out.println("gestionProfesseur");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionProfesseur.fxml"));
	}

	@FXML
	void gestionClasse(ActionEvent event) {
		System.out.println("gestionClasse");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionClasse.fxml"));
	}

	@FXML
	void gestionDepartement(ActionEvent event) {
		System.out.println("gestionDepartement");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionDepartement.fxml"));
	}

	@FXML
	void gestionElement(ActionEvent event) {
		System.out.println("gestionElement");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionElement.fxml"));
	}

	@FXML
	void gestionEtudiant(ActionEvent event) {
		System.out.println("gestionEtudiant");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionEtudiant.fxml"));
	}

	@FXML
	void gestionFiliere(ActionEvent event) {
		System.out.println("gestionFiliere");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionFiliere.fxml"));
	}

	@FXML
	void gestionModule(ActionEvent event) {
		System.out.println("gestionModule");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionModule.fxml"));
	}

	@FXML
	void gestionUtilisateur(ActionEvent event) {
		System.out.println("gestionUtilisateur");
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "GestionUtilisateur.fxml"));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		borderPaneAdministrateur.setCenter(loadUI.loadUI(path + "AdministrateurAcceuil.fxml"));
		
	}

}
