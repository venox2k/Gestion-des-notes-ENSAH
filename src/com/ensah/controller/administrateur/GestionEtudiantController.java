package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.EtudiantDAO;
import com.ensah.model.entity.Etudiant;
import com.ensah.model.entityData.EtudiantData;
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

public class GestionEtudiantController implements Initializable {

	private static Etudiant etudiant ;

	private EtudiantDAO etudiantDAO ;
	
	private LoadUI loadUI;

	private String path;

	public GestionEtudiantController() {
		etudiantDAO = new EtudiantDAO();
		path = "/com/ensah/view/administrateur/etudiant/";
		loadUI = new LoadUI();
	}

	
	@FXML
	private AnchorPane gestionEtudiantPane;

	@FXML
	private BorderPane gestionEtudiantBorder;
	
	@FXML
	private TableView<Etudiant> etudiantTableView;

	@FXML
	private TableColumn<Etudiant, Integer> idEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, String> cneEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, String> cinEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, String> nomEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, String> prenomEtudiantColumn;

	@FXML
	private TableColumn<Etudiant, Integer> classeIdColumn;

	@FXML
	void ajouterEtudiant(MouseEvent event) {
		System.out.println("ajouterEtudiant");
		gestionEtudiantBorder.setCenter(loadUI.loadUI(path + "AjouterEtudiant.fxml"));
	}

	@FXML
	void modifierEtudiant(MouseEvent event) {
		etudiant = etudiantTableView.getSelectionModel().getSelectedItem();
		gestionEtudiantBorder.setCenter(loadUI.loadUI(path + "ModifierEtudiant.fxml"));
	}

	@FXML
	void supprimerEtudiant(MouseEvent event) {
		int x = etudiantTableView.getSelectionModel().getSelectedIndex();
		Etudiant  y = etudiantTableView.getSelectionModel().getSelectedItem();
        etudiantTableView.getItems().remove(x);
        etudiantDAO.delete(y);	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		etudiantTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idEtudiantColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>(EtudiantData.idEtudiant.getValue()));
		cneEtudiantColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, String>(EtudiantData.cneEtudiant.getValue()));
		cinEtudiantColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, String>(EtudiantData.cinEtudiant.getValue()));
		nomEtudiantColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, String>(EtudiantData.nomEtudiant.getValue()));
		prenomEtudiantColumn.setCellValueFactory(
				new PropertyValueFactory<Etudiant, String>(EtudiantData.prenomEtudiant.getValue()));
		classeIdColumn
				.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>(EtudiantData.classeId.getValue()));
	}

	public ObservableList<Etudiant> getRows() {
		ObservableList<Etudiant> observableListEtudiant = FXCollections.observableArrayList();
		observableListEtudiant.addAll(etudiantDAO.findAll());
		return observableListEtudiant;
	}
	public Etudiant getEtudiant()
	{
		return etudiant ;
	}

}
