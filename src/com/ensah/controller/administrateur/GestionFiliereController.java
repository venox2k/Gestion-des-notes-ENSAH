package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.FiliereDAO;
import com.ensah.model.entity.Filiere;
import com.ensah.model.entityData.FiliereData;
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

public class GestionFiliereController implements Initializable {

	private static Filiere filiere ;

	private FiliereDAO filiereDAO ;
	
	private LoadUI loadUI;

	private String path;

	public GestionFiliereController() {
		filiereDAO = new FiliereDAO();
		path = "/com/ensah/view/administrateur/filiere/";
		loadUI = new LoadUI();
	}
	
	@FXML
	private AnchorPane gestionFilierePane;
	
	@FXML
	private BorderPane gestionFiliereBorder;

	@FXML
	private TableView<Filiere> filiereTableView;

	@FXML
	private TableColumn<Filiere, Integer> idFiliereColumn;

	@FXML
	private TableColumn<Filiere, String> designationFiliereColumn;

	@FXML
	private TableColumn<Filiere, String> descriptionFiliereColumn;

	@FXML
	private TableColumn<Filiere, Double> noteEliminatoireFiliereColumn;

	@FXML
	private TableColumn<Filiere, Integer> professeurIdColumn;

	@FXML
	void ajouterFiliere(MouseEvent event) {
		System.out.println("ajouterFiliere");
		gestionFiliereBorder.setCenter(loadUI.loadUI(path + "AjouterFiliere.fxml"));
	}

	@FXML
	void modifierFiliere(MouseEvent event) {
		filiere = filiereTableView.getSelectionModel().getSelectedItem();
		gestionFiliereBorder.setCenter(loadUI.loadUI(path + "ModifierFiliere.fxml"));
	}

	@FXML
	void supprimerFiliere(MouseEvent event) {
		int x = filiereTableView.getSelectionModel().getSelectedIndex();
		Filiere  y = filiereTableView.getSelectionModel().getSelectedItem();
		filiereTableView.getItems().remove(x);
        filiereDAO.delete(y);	
        }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		filiereTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idFiliereColumn
				.setCellValueFactory(new PropertyValueFactory<Filiere, Integer>(FiliereData.idFiliere.getValue()));
		designationFiliereColumn.setCellValueFactory(
				new PropertyValueFactory<Filiere, String>(FiliereData.designationFiliere.getValue()));
//		descriptionFiliereColumn.setCellValueFactory(
//				new PropertyValueFactory<Filiere, String>(FiliereData.descriptionFiliere.getValue()));
		noteEliminatoireFiliereColumn.setCellValueFactory(
				new PropertyValueFactory<Filiere, Double>(FiliereData.noteEliminatoireFiliere.getValue()));
		professeurIdColumn
				.setCellValueFactory(new PropertyValueFactory<Filiere, Integer>(FiliereData.professeurId.getValue()));
	}

	public ObservableList<Filiere> getRows() {
		ObservableList<Filiere> observableListFiliere = FXCollections.observableArrayList();
		observableListFiliere.addAll(filiereDAO.findAll());
		return observableListFiliere;
	}
   
	public Filiere getfiliere()
	{
		return filiere  ;
	}
}
