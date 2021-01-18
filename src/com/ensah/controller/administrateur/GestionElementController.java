package com.ensah.controller.administrateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.ElementDAO;
import com.ensah.model.entity.Element;
import com.ensah.model.entityData.ElementData;
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

public class GestionElementController implements Initializable {

	public static Element element ;

	private ElementDAO elementDAO ;
	
	private LoadUI loadUI;

	private String path;

	public GestionElementController() {
		elementDAO = new ElementDAO();
		path = "/com/ensah/view/administrateur/element/";
		loadUI = new LoadUI();
	}
	
	@FXML
	private AnchorPane gestionElementPane;
	
	@FXML
	private BorderPane gestionElementBorder;

	@FXML
	private TableView<Element> elementTableView;

	@FXML
	private TableColumn<Element, Integer> idElementColumn;

	@FXML
	private TableColumn<Element, String> designationElementColumn;

	@FXML
	private TableColumn<Element, Double> coefficientElementColumn;

	@FXML
	private TableColumn<Element, Boolean> dsActiveColumn;

	@FXML
	private TableColumn<Element, Boolean> examActiveColumn;

	@FXML
	private TableColumn<Element, Boolean> tpActiveColumn;

	@FXML
	private TableColumn<Element, Boolean> projetActiveColumn;

	@FXML
	private TableColumn<Element, Boolean> exposeActiveColumn;

	@FXML
	private TableColumn<Element, Boolean> devoirLibreActiveColumn;

	@FXML
	private TableColumn<Element, Boolean> absenceActiveColumn;

	@FXML
	private TableColumn<Element, Double> coefficientDsColumn;

	@FXML
	private TableColumn<Element, Double> coefficientExamColumn;

	@FXML
	private TableColumn<Element, Double> coefficientTpColumn;

	@FXML
	private TableColumn<Element, Double> coefficientProjetColumn;

	@FXML
	private TableColumn<Element, Double> coefficientExposeColumn;

	@FXML
	private TableColumn<Element, Double> coefficientDevoirLibreColumn;

	@FXML
	private TableColumn<Element, Double> coefficientAbsenceColumn;

	@FXML
	private TableColumn<Element, Integer> moduleIdColumn;

	@FXML
	private TableColumn<Element, Integer> professeurIdColumn;

	@FXML
	void ajouterElement(MouseEvent event) {
		System.out.println("ajouterElement");
		gestionElementBorder.setCenter(loadUI.loadUI(path + "AjouterElement.fxml"));
	}

	@FXML
	void modifierElement(MouseEvent event) {
		element = elementTableView.getSelectionModel().getSelectedItem();
		gestionElementBorder.setCenter(loadUI.loadUI(path + "ModifierElement.fxml"));
	}

	@FXML
	void supprimerElement(MouseEvent event) {
		int x = elementTableView.getSelectionModel().getSelectedIndex();
		Element  y = elementTableView.getSelectionModel().getSelectedItem();
		y.getIdElement();
		elementTableView.getItems().remove(x);
        elementDAO.delete(y);	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		elementTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idElementColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Integer>(ElementData.idElement.getValue()));
		designationElementColumn.setCellValueFactory(
				new PropertyValueFactory<Element, String>(ElementData.designationElement.getValue()));
		coefficientElementColumn.setCellValueFactory(
				new PropertyValueFactory<Element, Double>(ElementData.coefficientElement.getValue()));
		dsActiveColumn.setCellValueFactory(new PropertyValueFactory<Element, Boolean>(ElementData.dsActive.getValue()));
		examActiveColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Boolean>(ElementData.examActive.getValue()));
		tpActiveColumn.setCellValueFactory(new PropertyValueFactory<Element, Boolean>(ElementData.tpActive.getValue()));
		projetActiveColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Boolean>(ElementData.projetActive.getValue()));
		exposeActiveColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Boolean>(ElementData.exposeActive.getValue()));
		devoirLibreActiveColumn.setCellValueFactory(
				new PropertyValueFactory<Element, Boolean>(ElementData.devoirLibreActive.getValue()));
		absenceActiveColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Boolean>(ElementData.absenceActive.getValue()));
		coefficientDsColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Double>(ElementData.coefficientDs.getValue()));
		coefficientExamColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Double>(ElementData.coefficientExam.getValue()));
		coefficientTpColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Double>(ElementData.coefficientTp.getValue()));
		coefficientProjetColumn.setCellValueFactory(
				new PropertyValueFactory<Element, Double>(ElementData.coefficientProjet.getValue()));
		coefficientExposeColumn.setCellValueFactory(
				new PropertyValueFactory<Element, Double>(ElementData.coefficientExpose.getValue()));
		coefficientDevoirLibreColumn.setCellValueFactory(
				new PropertyValueFactory<Element, Double>(ElementData.coefficientDevoirLibre.getValue()));
		coefficientAbsenceColumn.setCellValueFactory(
				new PropertyValueFactory<Element, Double>(ElementData.coefficientAbsence.getValue()));
		moduleIdColumn.setCellValueFactory(new PropertyValueFactory<Element, Integer>(ElementData.moduleId.getValue()));
		professeurIdColumn
				.setCellValueFactory(new PropertyValueFactory<Element, Integer>(ElementData.professeurId.getValue()));
	}

	public ObservableList<Element> getRows() {
		ObservableList<Element> observableListElement = FXCollections.observableArrayList();
		observableListElement.addAll(elementDAO.findAll());
		return observableListElement;

	}
	public Element getElement()
	{
		return element ;
	}
}