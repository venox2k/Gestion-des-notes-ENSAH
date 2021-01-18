package com.ensah.controller.professeur;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ensah.model.dao.ElementDAO;
import com.ensah.model.dao.EtudiantDAO;
import com.ensah.model.dao.NoteElementDAO;
import com.ensah.model.entity.Element;
import com.ensah.model.entity.Etudiant;
import com.ensah.model.entity.NoteElement;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AjouterNoteElementController implements Initializable {

	@FXML
	private AnchorPane ajouterNoteElementPane;

	@FXML
	private TextField DS;

	@FXML
	private TextField Exam;

	@FXML
	private TextField Tp;

	@FXML
	private TextField Projet;

	@FXML
	private TextField Absence;

	@FXML
	private TextField DL;

	@FXML
	private TextField Expose;

	@FXML
	private Button validerBtn;

	@FXML
	private Label nomEtudiant;

	@FXML
	private Label prenomEtudiant;

	private EtudiantDAO etudiantDAO;
	private NoteElementDAO noteElementDAO;
	private Etudiant etudiant;
	private DoubleProperty ds;
	private DoubleProperty exam;
	private DoubleProperty tp;
	private DoubleProperty projet;
	private DoubleProperty expose;
	private DoubleProperty dl;
	private DoubleProperty absence;
	private Element element;
	private ElementDAO elementDAO;

	@FXML
	void valider(ActionEvent event) {
		if (ds.get() >= 0 && ds.get() <= 20 && exam.get() >= 0 && exam.get() <= 20 && tp.get() >= 0 && tp.get() <= 20
				&& projet.get() >= 0 && projet.get() <= 20 && dl.get() >= 0 && dl.get() <= 20 && expose.get() >= 0
				&& expose.get() <= 20 && absence.get() >= 0 && absence.get() <= 20
		) {
			NoteElement newNoteElement = new NoteElement.NoteElementBuilder()
					.setElementId(element.getIdElement())
					.setIdNoteElement(noteElement.getIdNoteElement())
					.setNoteDsElement(ds.get())
					.setNoteExamElement(exam.get())
					.setNoteTpElement(tp.get())
					.setNoteExposeElement(expose.get())
					.setNoteProjectElement(projet.get())
					.setNoteDevoirLibreElement(dl.get())
					.setScenceAbsenteElement((int)absence.get())
					.setEtudiantId(etudiant.getIdEtudiant())
					.build();
			
			double notetotal = 0.0;
			if(element.getDsActive()) {
				notetotal += element.getCoefficientDs() * ds.get();
			}
			if(element.getExamActive()) {
				notetotal += element.getCoefficientExam() * exam.get();
			}
			if(element.getProjetActive()) {
				notetotal += element.getCoefficientProjet() * projet.get();
			}
			if(element.getExposeActive()) {
				notetotal += element.getCoefficientExpose() * expose.get();
			}
			if(element.getTpActive()) {
				notetotal += element.getCoefficientTp() * tp.get();
			}
			if(element.getDevoirLibreActive()) {
				notetotal += element.getCoefficientDevoirLibre() * dl.get();
			}
			if(element.getAbsenceActive()) {
				notetotal += element.getCoefficientAbsence() * absence.get();
			}
			
			newNoteElement.setNoteElement(notetotal);
			
			noteElementDAO.update(newNoteElement);
			
		}

	}

	private NoteElement noteElement;

	public AjouterNoteElementController() {
		noteElementDAO = new NoteElementDAO();
		int professeurId = 5;// professeur id
		elementDAO = new ElementDAO();
		List<Element> elements = new ArrayList<Element>(elementDAO.findProfesseur(professeurId));
		element = elements.get(0);
		ds = new SimpleDoubleProperty();
		exam = new SimpleDoubleProperty();
		tp = new SimpleDoubleProperty();
		projet = new SimpleDoubleProperty();
		expose = new SimpleDoubleProperty();
		dl = new SimpleDoubleProperty();
		absence = new SimpleDoubleProperty();
		etudiantDAO = new EtudiantDAO();
		noteElement = GestionNoteElementController.getNoteElement();
		etudiant = etudiantDAO.find(noteElement.getEtudiantId()).get();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(!element.getDsActive()) {
			DS.setDisable(true);
		}
		if(!element.getExamActive()) {
			Exam.setDisable(true);
		}
		if(!element.getProjetActive()) {
			Projet.setDisable(true);
		}
		if(!element.getExposeActive()) {
			Expose.setDisable(true);
		}
		if(!element.getTpActive()) {
			Tp.setDisable(true);
		}
		if(!element.getDevoirLibreActive()) {
			DL.setDisable(true);
		}
		if(!element.getAbsenceActive()) {
			Absence.setDisable(true);
		}
		
		nomEtudiant.setText(etudiant.getNomEtudiant());
		prenomEtudiant.setText(etudiant.getPrenomEtudiant());
		DS.setText(String.valueOf(noteElement.getNoteDsElement()));
		Exam.setText(String.valueOf(noteElement.getNoteExamElement()));
		Tp.setText(String.valueOf(noteElement.getNoteTpElement()));
		Projet.setText(String.valueOf(noteElement.getNoteProjectElement()));
		Expose.setText(String.valueOf(noteElement.getNoteExposeElement()));
		DL.setText(String.valueOf(noteElement.getNoteDevoirLibreElement()));
		Absence.setText(String.valueOf(noteElement.getScenceAbsenteElement()));
		ds.bind(new DoubleBinding() {
			{
				bind(DS.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(DS.textProperty().get());
			}
		});
		exam.bind(new DoubleBinding() {
			{
				bind(Exam.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(Exam.textProperty().get());
			}
		});
		tp.bind(new DoubleBinding() {
			{
				bind(Tp.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(Tp.textProperty().get());
			}
		});
		projet.bind(new DoubleBinding() {
			{
				bind(Projet.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(Projet.textProperty().get());
			}
		});
		expose.bind(new DoubleBinding() {
			{
				bind(Expose.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(Expose.textProperty().get());
			}
		});
		dl.bind(new DoubleBinding() {
			{
				bind(DL.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(DL.textProperty().get());
			}
		});
		absence.bind(new DoubleBinding() {
			{
				bind(Absence.textProperty());
			}

			@Override
			protected double computeValue() {
				return Double.parseDouble(Absence.textProperty().get());
			}
		});

		DS.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					DS.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		Exam.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					Exam.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		Tp.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					Tp.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		Projet.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					Projet.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		Expose.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					Expose.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		DL.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					DL.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

		Absence.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*\\.")) {
					Absence.setText(newValue.replaceAll("[^\\d\\.]", ""));
				}
			}
		});

	}

}
