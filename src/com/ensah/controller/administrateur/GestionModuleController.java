package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.entity.Module;
import com.ensah.model.entityData.ModuleData;
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

public class GestionModuleController implements Initializable {

	public static Module module = null ;

	private ModuleDAO moduleDAO ;

	private LoadUI loadUI;

	private String path;

	public GestionModuleController() {
		moduleDAO = new ModuleDAO();
		path = "/com/ensah/view/administrateur/module/";
		loadUI = new LoadUI();
	}

	@FXML
	private AnchorPane gestionModulePane;
	@FXML
	private BorderPane gestionModuleBorder;
	@FXML
	private TableView<Module> moduleTableView;

	@FXML
	private TableColumn<Module, Integer> idModuleColumn;

	@FXML
	private TableColumn<Module, String> designationModuleColumn;

	@FXML
	private TableColumn<Module, Integer> semesterIdColumn;

	@FXML
	void ajouterModule(MouseEvent event) {
		System.out.println("ajouterModule");
		gestionModuleBorder.setCenter(loadUI.loadUI(path + "AjouterModule.fxml"));

	}

	@FXML
	void modifierModule(MouseEvent event) {
		module = moduleTableView.getSelectionModel().getSelectedItem();
		gestionModuleBorder.setCenter(loadUI.loadUI(path + "ModifierModule.fxml"));

	}

	@FXML
	void supprimerModule(MouseEvent event) {
		int x = moduleTableView.getSelectionModel().getSelectedIndex();
		Module  y = moduleTableView.getSelectionModel().getSelectedItem();
		moduleTableView.getItems().remove(x);
        moduleDAO.delete(y);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		moduleTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idModuleColumn.setCellValueFactory(new PropertyValueFactory<Module, Integer>(ModuleData.idModule.getValue()));
		designationModuleColumn
				.setCellValueFactory(new PropertyValueFactory<Module, String>(ModuleData.designationModule.getValue()));
		semesterIdColumn
				.setCellValueFactory(new PropertyValueFactory<Module, Integer>(ModuleData.semesterId.getValue()));
	}

	public ObservableList<Module> getRows() {
		ObservableList<Module> observableListModule = FXCollections.observableArrayList();
		observableListModule.addAll(moduleDAO.findAll());
		return observableListModule;
	}
	
	public Module getModule()
	{
		return module ;
	}
}