package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entityData.ClasseData;
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

public class GestionClasseController implements Initializable {

	private static Classe classe ;  

	private ClasseDAO classeDAO;

	private LoadUI loadUI;

	private String path;

	public GestionClasseController() {
		classeDAO = new ClasseDAO();
		path = "/com/ensah/view/administrateur/classe/";
		loadUI = new LoadUI();
	}

	@FXML
	private AnchorPane gestionClassePane;
	
	@FXML
	private BorderPane gestionClasseBoreder;
	
	@FXML
	private TableView<Classe> classeTableView;

	@FXML
	private TableColumn<Classe, Integer> idClasseColumn;

	@FXML
	private TableColumn<Classe, String> designationClasseColumn;

	@FXML
	private TableColumn<Classe, Integer> filiereIdColumn;

	@FXML
	void ajouterClasse(MouseEvent event) {
		System.out.println("ajouterClasse");
		gestionClasseBoreder.setCenter(loadUI.loadUI(path + "AjouterClasse.fxml"));
	}

	@FXML
	void modifierClasse(MouseEvent event) {
		classe = classeTableView.getSelectionModel().getSelectedItem();
		gestionClasseBoreder.setCenter(loadUI.loadUI(path + "ModifierClasse.fxml"));
	}

	@FXML
	void supprimerClasse(MouseEvent event) {
		int x = classeTableView.getSelectionModel().getSelectedIndex();
		Classe  y = classeTableView.getSelectionModel().getSelectedItem();
		classeTableView.getItems().remove(x);
        classeDAO.delete(y);	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		classeTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idClasseColumn.setCellValueFactory(new PropertyValueFactory<Classe, Integer>(ClasseData.idClasse.getValue()));
		designationClasseColumn
				.setCellValueFactory(new PropertyValueFactory<Classe, String>(ClasseData.designationClasse.getValue()));
		filiereIdColumn.setCellValueFactory(new PropertyValueFactory<Classe, Integer>(ClasseData.filiereId.getValue()));
	}

	public ObservableList<Classe> getRows() {
		ObservableList<Classe> observableListClasse = FXCollections.observableArrayList();
		observableListClasse.addAll(classeDAO.findAll());
		return observableListClasse;
	}
	public Classe getClasse()
	{
		return classe ;
	}

}
