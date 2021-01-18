package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.UtilisateurDAO;
import com.ensah.model.entity.Utilisateur;
import com.ensah.model.entityData.UtilisateurData;
import com.ensah.utils.LoadUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class GestionUtilisateurController implements Initializable {

	private  static Utilisateur user ;

	private UtilisateurDAO utilisateurDAO;

	private LoadUI loadUI;

	private String path;

	public GestionUtilisateurController() {
		utilisateurDAO = new UtilisateurDAO();
		path = "/com/ensah/view/administrateur/utilisateur/";
		loadUI = new LoadUI();
	}

	@FXML
	private AnchorPane gestionUtilisateurPane;

	@FXML
	private BorderPane gestionUtilisateurBorder;

	@FXML
	private TableView<Utilisateur> utilisateurTableView;

	@FXML
	private TableColumn<Utilisateur, Integer> idUtilisateurColumn;

	@FXML
	private TableColumn<Utilisateur, String> nomUtilisateurColumn;

	@FXML
	private TableColumn<Utilisateur, String> motDePasseUtilisateurColumn;

	@FXML
	private TableColumn<Utilisateur, String> cleUtilisateurColumn;

	@FXML
	void ajouterUtilisateur(MouseEvent event) {
		System.out.println("ajouterUtilisateur");
		gestionUtilisateurBorder.setCenter(loadUI.loadUI("/com/ensah/view/administrateur/professeur/" + "AjouterProfesseur.fxml"));
		
	}

	@FXML
	void modifierUtilisateur(MouseEvent event) {
		user = utilisateurTableView.getSelectionModel().getSelectedItem();		
		gestionUtilisateurBorder.setCenter(loadUI.loadUI(path + "ModifierUtilisateur.fxml"));
	}

	@FXML
	void supprimerUtilisateur(MouseEvent event) {
		System.out.println("supprimerUtilisateur");
		int x = utilisateurTableView.getSelectionModel().getSelectedIndex();
		Utilisateur y = utilisateurTableView.getSelectionModel().getSelectedItem();
		utilisateurTableView.getItems().remove(x);
		utilisateurDAO.delete(y);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		utilisateurTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idUtilisateurColumn.setCellValueFactory(
				new PropertyValueFactory<Utilisateur, Integer>(UtilisateurData.idUtilisateur.getValue()));
		nomUtilisateurColumn.setCellValueFactory(
				new PropertyValueFactory<Utilisateur, String>(UtilisateurData.nomUtilisateur.getValue()));
		motDePasseUtilisateurColumn.setCellValueFactory(
				new PropertyValueFactory<Utilisateur, String>(UtilisateurData.motDePasseUtilisateur.getValue()));
		cleUtilisateurColumn.setCellValueFactory(
				new PropertyValueFactory<Utilisateur, String>(UtilisateurData.cleUtilisateur.getValue()));
	}

	public ObservableList<Utilisateur> getRows() {
		ObservableList<Utilisateur> observableListUtilisateur = FXCollections.observableArrayList();
		observableListUtilisateur.addAll(utilisateurDAO.findAll());
		return observableListUtilisateur;
	}
	public Utilisateur getUser() {
		return user;
	}

}
