package com.ensah.controller.professeur;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ensah.model.dao.ClasseDAO;
import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.EtudiantDAO;
import com.ensah.model.dao.ModuleDAO;
import com.ensah.model.dao.NoteElementDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.dao.SemestreDAO;
import com.ensah.model.entity.Classe;
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Etudiant;
import com.ensah.model.entity.Module;
import com.ensah.model.entity.NoteElement;
import com.ensah.model.entity.Semestre;
import com.ensah.model.entityData.NoteElementData;
import com.ensah.utils.LoadUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class GestionNoteElementController implements Initializable {

	public static NoteElement noteelementSelected;

	@FXML
	private AnchorPane gestionNoteElementPane;

	@FXML
	private BorderPane gestionNoteElementBorder;

	@FXML
	private Button ajouterNoteBtn;

	@FXML
	private TableView<NoteElement> etudiantTableView;

	@FXML
	private TableColumn<NoteElement, Integer> idEtudiantColumn;

	@FXML
	private TableColumn<NoteElement, Double> noteDsColumn;

	@FXML
	private TableColumn<NoteElement, Double> noteExamColumn;

	@FXML
	private TableColumn<NoteElement, Double> noteTpColumn;

	@FXML
	private TableColumn<NoteElement, Double> noteProjetColumn;

	@FXML
	private TableColumn<NoteElement, Double> noteExposeColumn;

	@FXML
	private TableColumn<NoteElement, Double> noteDevoirLibreColumn;

	@FXML
	private TableColumn<NoteElement, Integer> seanceAbsenceColumn;

	@FXML
	private TableColumn<NoteElement, Double> noteElementColumn;

	private EtudiantDAO etudiantDAO;
	private ProfesseurDAO professeurDAO;
	private ModuleDAO moduleDAO;
	private ElementDAO elementDAO;
	private SemestreDAO semestreDAO;
	private ClasseDAO classeDAO;
	private Classe classe;
	private Element element;
	private NoteElementDAO noteElementDAO;
	private LoadUI loadUI;
	private String path;

	public GestionNoteElementController() {
		path = "/com/ensah/view/professeur/";
		loadUI = new LoadUI();
		noteElementDAO = new NoteElementDAO();
		etudiantDAO = new EtudiantDAO();
		professeurDAO = new ProfesseurDAO();
		moduleDAO = new ModuleDAO();
		elementDAO = new ElementDAO();
		semestreDAO = new SemestreDAO();
		classeDAO = new ClasseDAO();
		int professeurId = 5;// professeur id
		List<Element> elements = new ArrayList<Element>(elementDAO.findProfesseur(professeurId));
		element = elements.get(0);
		int moduleId = element.getModuleId();
		Module module = moduleDAO.find(moduleId).get();
		Semestre semestre = semestreDAO.find(module.getSemesterId()).get();
		classe = classeDAO.find(semestre.getClasseId()).get();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindPropertiesToColumns();
		etudiantTableView.setItems(getRows());
	}

	public void bindPropertiesToColumns() {
		idEtudiantColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Integer>(NoteElementData.etudiantId.getValue()));
		noteDsColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Double>(NoteElementData.noteDsElement.getValue()));
		noteExamColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Double>(NoteElementData.noteExamElement.getValue()));
		noteTpColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Double>(NoteElementData.noteTpElement.getValue()));
		noteProjetColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Double>(NoteElementData.noteProjetElement.getValue()));
		noteExposeColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Double>(NoteElementData.noteExposeElement.getValue()));
		noteDevoirLibreColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Double>(NoteElementData.noteDevoirLibreElement.getValue()));
		seanceAbsenceColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Integer>(NoteElementData.scenceAbsenteElement.getValue()));
		noteElementColumn.setCellValueFactory(
				new PropertyValueFactory<NoteElement, Double>(NoteElementData.noteElement.getValue()));
	}

	public ObservableList<NoteElement> getRows() {
		List<Etudiant> listEtudiant = new ArrayList<Etudiant>(etudiantDAO.findClasse(classe.getIdClasse()));
		List<NoteElement> listNoteElemet = new ArrayList<NoteElement>();
		NoteElement noteElement = null;
//		for (int i = 0; i < listEtudiant.size(); i++) {
//			noteElement = new NoteElement.NoteElementBuilder().setNoteDsElement(0).setNoteExamElement(0)
//					.setNoteTpElement(0).setNoteProjectElement(0).setNoteExposeElement(0).setNoteDevoirLibreElement(0)
//					.setScenceAbsenteElement(0).setNoteAvantRattrapage(0).setNoteApresRattrapage(0).setNoteElement(0)
//					.setValideAvantRattrapage(false).setValideApresRattrapage(false)
//					.setEtudiantId(listEtudiant.get(i).getIdEtudiant()).setElementId(element.getIdElement()).build();
//			noteElementDAO.insert(noteElement);
//			System.out.println(i);
//			observableListEtudiant.add(noteElement);
//		}		
		ObservableList<NoteElement> observableListEtudiant = FXCollections
				.observableList(noteElementDAO.findElement(element.getIdElement()));
		return observableListEtudiant;
	}

	@FXML
	void ajouterNote(ActionEvent event) {

		noteelementSelected = etudiantTableView.getSelectionModel().getSelectedItem();
		if(noteelementSelected!=null) {
			gestionNoteElementBorder.setCenter(loadUI.loadUI(path + "AjouterNoteElement.fxml"));
		}

	}

	public static NoteElement getNoteElement() {
		return noteelementSelected;
	}
}
