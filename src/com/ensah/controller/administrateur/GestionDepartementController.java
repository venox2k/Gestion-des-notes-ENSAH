package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.DepartementDAO;
import com.ensah.model.entity.Departement;
import com.ensah.model.entityData.DepartementData;
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

public class GestionDepartementController implements Initializable {

	private static Departement departement ;

	private DepartementDAO departementDAO;

	private LoadUI loadUI;

	private String path;

	public GestionDepartementController() {
		departementDAO = new DepartementDAO();
		path = "/com/ensah/view/administrateur/departement/";
		loadUI = new LoadUI();
	}

	@FXML
	private AnchorPane gestionDepartementPane;

	@FXML
	private BorderPane gestionDepartementBorder;

	@FXML
	private TableView<Departement> departementTableView;

	@FXML
	private TableColumn<Departement, Integer> idDepartementColumn;

	@FXML
	private TableColumn<Departement, String> designationDepartementColumn;

	@FXML
	private TableColumn<Departement, Integer> professeurIdColumn;

	@FXML
	void ajouterDepartement(MouseEvent event) {
		System.out.println("ajouterDepartement");
		gestionDepartementBorder.setCenter(loadUI.loadUI(path + "AjouterDepartement.fxml"));
	}

	@FXML
	void modifierDepartement(MouseEvent event) {
		departement = departementTableView.getSelectionModel().getSelectedItem();
		gestionDepartementBorder.setCenter(loadUI.loadUI(path + "ModifierDepartement.fxml"));
	}

	@FXML
	void supprimerDepartement(MouseEvent event) {
		int x = departementTableView.getSelectionModel().getSelectedIndex();
		Departement  y = departementTableView.getSelectionModel().getSelectedItem();
		departementTableView.getItems().remove(x);
        departementDAO.delete(y);	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		departementTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idDepartementColumn.setCellValueFactory(
				new PropertyValueFactory<Departement, Integer>(DepartementData.idDepartement.getValue()));
		designationDepartementColumn.setCellValueFactory(
				new PropertyValueFactory<Departement, String>(DepartementData.designationDepartement.getValue()));
		professeurIdColumn.setCellValueFactory(
				new PropertyValueFactory<Departement, Integer>(DepartementData.professeurId.getValue()));
	}

	public ObservableList<Departement> getRows() {
		ObservableList<Departement> observableListDepartement = FXCollections.observableArrayList();
		observableListDepartement.addAll(departementDAO.findAll());
		return observableListDepartement;
	}
	public Departement getDepartement()
	{
		return departement ;
	}

}
