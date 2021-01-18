package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.entity.Professeur;
import com.ensah.model.entityData.ProfesseurData;
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

public class GestionProfesseurController implements Initializable {

	private ProfesseurDAO professeurDAO ;
	public static Professeur prof ;


	private LoadUI loadUI;

	private String path;

	public GestionProfesseurController() {
		professeurDAO = new ProfesseurDAO();
		path = "/com/ensah/view/administrateur/professeur/";
		loadUI = new LoadUI();
	}

	@FXML
	private AnchorPane gestionProfesseurPane;
	@FXML
	private BorderPane gestionProfesseurBorder;
	@FXML
	private TableView<Professeur> professeurTableView;
	@FXML
	private TableColumn<Professeur, Integer> idProfesseurColumn;
	@FXML
	private TableColumn<Professeur, String> nomProfesseurColumn;
	@FXML
	private TableColumn<Professeur, String> prenomProfesseurColumn;
	@FXML
	private TableColumn<Professeur, String> emailProfesseurColumn;
	@FXML
	private TableColumn<Professeur, Integer> departementIdColumn;

	@FXML
	void ajouterProfesseur(MouseEvent event) {
		System.out.println("ajouterProfesseur");
		gestionProfesseurBorder.setCenter(loadUI.loadUI(path + "AjouterProfesseur.fxml"));
	}

	@FXML
	void modifierProfesseur(MouseEvent event) {
		prof = professeurTableView.getSelectionModel().getSelectedItem();
		gestionProfesseurBorder.setCenter(loadUI.loadUI(path + "ModifierProfesseur.fxml"));
	}

	@FXML
	void supprimerProfesseur(MouseEvent event) {
		int x = professeurTableView.getSelectionModel().getSelectedIndex();
		Professeur  y = professeurTableView.getSelectionModel().getSelectedItem();
		y.getIdProfesseur();
		professeurTableView.getItems().remove(x);
        professeurDAO.delete(y);	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		professeurTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idProfesseurColumn.setCellValueFactory(
				new PropertyValueFactory<Professeur, Integer>(ProfesseurData.idProfesseur.getValue()));
		nomProfesseurColumn.setCellValueFactory(
				new PropertyValueFactory<Professeur, String>(ProfesseurData.nomProfesseur.getValue()));
		prenomProfesseurColumn.setCellValueFactory(
				new PropertyValueFactory<Professeur, String>(ProfesseurData.prenomProfesseur.getValue()));
		emailProfesseurColumn.setCellValueFactory(
				new PropertyValueFactory<Professeur, String>(ProfesseurData.emailProfesseur.getValue()));
		departementIdColumn.setCellValueFactory(
				new PropertyValueFactory<Professeur, Integer>(ProfesseurData.departementId.getValue()));
	}

	public ObservableList<Professeur> getRows() {
		ObservableList<Professeur> observableListProfesseur = FXCollections.observableArrayList();
		observableListProfesseur.addAll(professeurDAO.findAll());
		return observableListProfesseur;
	}
	public Professeur getProf()
	{
		return prof ;
	}

}