package com.ensah.controller.administrateur.filiere;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.model.dao.DepartementDAO;
import com.ensah.model.dao.FiliereDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.entity.Departement;
import com.ensah.model.entity.Filiere;
import com.ensah.model.entity.Professeur;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AjouterFiliereController implements Initializable {

	@FXML
	private AnchorPane ajouterFilierePane;

	@FXML
	private TextField designationFiliereField;

	@FXML
	private TextField noteEliminatoireFiliereField;

	@FXML
	private ComboBox<Departement> departementList;

	@FXML
	private ComboBox<Professeur> professeurList;

	@FXML
	private Button ajouterFiliereBtn;

	@FXML
	private Label designationFiliereMsg;
	@FXML
	private Label noteEliminatoireFiliereMsg;
	@FXML
	private Label departementMsg;
	@FXML
	private Label professeurMsg;

	private FiliereDAO filiereDAO;
	private DepartementDAO departementDAO;
	private ProfesseurDAO professeurDAO;
	private ObservableList<Departement> observableListDepartement;
	private ObservableList<Professeur> observableListProfesseur;
	private StringProperty designationFiliere;
	private DoubleProperty noteEliminatoireFiliere;
	private IntegerProperty professeurId;
	private IntegerProperty departementId;
	private SimpleObjectProperty<Professeur> professeurSelected;
	private SimpleObjectProperty<Departement> departementSelected;
	private final int MAX_LENGTH = 100;

	public AjouterFiliereController() {
		filiereDAO = new FiliereDAO();
		departementDAO = new DepartementDAO();
		professeurDAO = new ProfesseurDAO();
		observableListDepartement = FXCollections.observableList(departementDAO.findAll());
		observableListProfesseur = FXCollections.observableList(professeurDAO.findAll());
		designationFiliere = new SimpleStringProperty();
		noteEliminatoireFiliere = new SimpleDoubleProperty(-1);
		professeurId = new SimpleIntegerProperty();
		departementId = new SimpleIntegerProperty();
		professeurSelected = new SimpleObjectProperty<Professeur>();
		departementSelected = new SimpleObjectProperty<Departement>();
	}

	@FXML
	void ajouterFiliere(ActionEvent event) {
		if (!noteEliminatoireFiliereField.textProperty().get().isEmpty()) {
			noteEliminatoireFiliere.bind(new DoubleBinding() {
				{
					bind(noteEliminatoireFiliereField.textProperty());
				}

				@Override
				protected double computeValue() {
					return Double.parseDouble(noteEliminatoireFiliereField.textProperty().get());
				}
			});
		}
		if (!departementList.getSelectionModel().isEmpty()) {
			departementId.bindBidirectional(departementSelected.get().idDepartementProperty());
		}
		if (!professeurList.getSelectionModel().isEmpty()) {
			professeurId.bindBidirectional(professeurSelected.get().idProfesseurProperty());
		}
		if (designationFiliere.get().isEmpty()) {
			designationFiliereMsg.setText("* Ce champ est obligatoire");
			designationFiliereMsg.setVisible(true);
		} else {
			designationFiliereMsg.setVisible(false);
		}
		if (noteEliminatoireFiliere.get() == -1) {
			noteEliminatoireFiliereMsg.setText("* Ce champ est obligatoire");
			noteEliminatoireFiliereMsg.setVisible(true);
		} else {
			noteEliminatoireFiliereMsg.setVisible(false);
		}
		if (noteEliminatoireFiliere.get() > 12 || noteEliminatoireFiliere.get() < 7) {
			noteEliminatoireFiliereMsg.setText("* Note Eliminatoire Valide [7,12]");
			noteEliminatoireFiliereMsg.setVisible(true);
		} else {
			noteEliminatoireFiliereMsg.setVisible(false);
		}
		
		if (professeurId.get() == 0) {
			professeurMsg.setText("* Ce champ est obligatoire");
			professeurMsg.setVisible(true);
		} else {
			professeurMsg.setVisible(false);
		}
		if (departementId.get() == 0) {
			departementMsg.setText("* Ce champ est obligatoire");
			departementMsg.setVisible(true);
		} else {
			departementMsg.setVisible(false);
		}

		if (!designationFiliere.get().isEmpty() && noteEliminatoireFiliere.get() >= 7
				&& noteEliminatoireFiliere.get() <= 12 && professeurId.get() > 0 && departementId.get() > 0) {
			Filiere filiere = new Filiere.FiliereBuilder().setDesignationFiliere(designationFiliere.get())
					.setNoteEliminatoireFiliere(noteEliminatoireFiliere.get()).setDepartementId(departementId.get())
					.setProfesseurId(professeurId.get()).build();
			filiereDAO.insert(filiere);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		designationFiliereMsg.setVisible(false);
		noteEliminatoireFiliereMsg.setVisible(false);
		departementMsg.setVisible(false);
		professeurMsg.setVisible(false);
		departementList.setItems(observableListDepartement);
		professeurList.setItems(observableListProfesseur);
		designationFiliere.bindBidirectional(designationFiliereField.textProperty());
		professeurList.valueProperty().bindBidirectional(professeurSelected);
		departementList.valueProperty().bindBidirectional(departementSelected);
		departementId.set(0);
		professeurId.set(0);
		designationFiliereField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (designationFiliereField.getText().length() > MAX_LENGTH) {
					String s = designationFiliereField.getText().substring(0, MAX_LENGTH);
					designationFiliereField.setText(s);
				}
			}
		});
		noteEliminatoireFiliereField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					noteEliminatoireFiliereField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

	}

}
