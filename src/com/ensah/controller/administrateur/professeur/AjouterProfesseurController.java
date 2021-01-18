package com.ensah.controller.administrateur.professeur;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ensah.model.dao.DepartementDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.dao.UtilisateurDAO;
import com.ensah.model.entity.Departement;
import com.ensah.model.entity.Professeur;
import com.ensah.model.entity.Utilisateur;
import com.ensah.utils.PasswordUtil;

import javafx.beans.property.IntegerProperty;
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

public class AjouterProfesseurController implements Initializable {

	@FXML
	private AnchorPane ajouterProfesseurPane;

	@FXML
	private TextField nomProfesseurField;

	@FXML
	private TextField prenomProfesseurField;

	@FXML
	private TextField emailProfesseurField;

	@FXML
	private ComboBox<Departement> departementList;

	@FXML
	private Button ajouterProfesseurBtn;

	@FXML
	private Label nomProfeseurMsg;

	@FXML
	private Label prenomProfeseurMsg;

	@FXML
	private Label emailProfeseurMsg;
	
	private ProfesseurDAO professeurDAO;
	private DepartementDAO departementDAO;
	private UtilisateurDAO utilisateurDAO;
	private ObservableList<Departement> observableListDepartement;
	private StringProperty nomProfesseur;
	private StringProperty prenomProfesseur;
	private StringProperty emailProfesseur;
	private IntegerProperty departementId;
	private SimpleObjectProperty<Departement> departementSelected;
	private final String regex;
	private Pattern pattern;
	private Matcher matcher;
	private int utilisateurId;
	private String nomUtilisateur;
	private String motDePasseUtilisateur;
	private String cleUtilisateur;
	private final int MAX_LENGTH = 45;

	public AjouterProfesseurController() {
		professeurDAO = new ProfesseurDAO();
		departementDAO = new DepartementDAO();
		utilisateurDAO = new UtilisateurDAO();
		observableListDepartement = FXCollections.observableList(departementDAO.findAll());
		nomProfesseur = new SimpleStringProperty();
		prenomProfesseur = new SimpleStringProperty();
		emailProfesseur = new SimpleStringProperty();
		departementId = new SimpleIntegerProperty();
		departementSelected = new SimpleObjectProperty<Departement>();
		regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		pattern = Pattern.compile(regex);
	}


	@FXML
	void ajouterProfesseur(ActionEvent event) {
		if (!departementList.getSelectionModel().isEmpty()) {
			departementId.bindBidirectional(departementSelected.get().idDepartementProperty());
		}
		matcher = pattern.matcher(emailProfesseur.get());

		if (nomProfesseur.get().isEmpty()) {
			nomProfeseurMsg.setText("* Ce champ est obligatoire");
			nomProfeseurMsg.setVisible(true);
		} else {
			nomProfeseurMsg.setVisible(false);
		}
		if (prenomProfesseur.get().isEmpty()) {
			prenomProfeseurMsg.setText("* Ce champ est obligatoire");
			prenomProfeseurMsg.setVisible(true);

		} else {
			prenomProfeseurMsg.setVisible(false);
		}
		if (emailProfesseur.get().isEmpty()) {
			emailProfeseurMsg.setText("* Ce champ est obligatoire");
			emailProfeseurMsg.setVisible(true);
			return;

		} else {
			emailProfeseurMsg.setVisible(false);
		}

		if (!nomProfesseur.get().isEmpty() && !prenomProfesseur.get().isEmpty() && !emailProfesseur.get().isEmpty()
				&& matcher.matches()) {
			System.out.println(nomProfesseur.get() + " " + prenomProfesseur.get() + " " + emailProfesseur.get() + " "
					+ departementId.get());

			nomUtilisateur = nomProfesseur.get().concat(" ").concat(prenomProfesseur.get());
			cleUtilisateur = PasswordUtil.generateCleUtilisateur();
			motDePasseUtilisateur = PasswordUtil.generateSecureMotDePasse(nomUtilisateur, cleUtilisateur);
			Utilisateur utilisateur = new Utilisateur.UtilisateurBuilder().setNomUtilisateur(nomUtilisateur)
					.setMotDePasseUtilisateur(motDePasseUtilisateur).setCleUtilisateur(cleUtilisateur).build();
			utilisateurDAO.insert(utilisateur);
			utilisateurId = utilisateurDAO.findLastUtilisateurId();
			Professeur professeur = new Professeur.ProfesseurBuilder().setNomProfesseur(nomProfesseur.get())
					.setPrenomProfesseur(prenomProfesseur.get()).setEmailProfesseur(emailProfesseur.get())
					.setDepartementId(departementId.get()).setUtilisateurId(utilisateurId).build();
			professeurDAO.insert(professeur);
		} else {
			emailProfeseurMsg.setText("* Veuillez entrer une adresse e-mail valide ");
			emailProfeseurMsg.setVisible(true);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomProfeseurMsg.setVisible(false);
		prenomProfeseurMsg.setVisible(false);
		emailProfeseurMsg.setVisible(false);
		departementList.setItems(observableListDepartement);
		nomProfesseur.bindBidirectional(nomProfesseurField.textProperty());
		prenomProfesseur.bindBidirectional(prenomProfesseurField.textProperty());
		emailProfesseur.bindBidirectional(emailProfesseurField.textProperty());
		departementList.valueProperty().bindBidirectional(departementSelected);
		nomProfesseurField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (nomProfesseurField.getText().length() > MAX_LENGTH) {
					String s = nomProfesseurField.getText().substring(0, MAX_LENGTH);
					nomProfesseurField.setText(s);
				}
			}
		});
		prenomProfesseurField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (prenomProfesseurField.getText().length() > MAX_LENGTH) {
					String s = prenomProfesseurField.getText().substring(0, MAX_LENGTH);
					prenomProfesseurField.setText(s);
				}
			}
		});
		emailProfesseurField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (emailProfesseurField.getText().length() > MAX_LENGTH) {
					String s = emailProfesseurField.getText().substring(0, MAX_LENGTH);
					emailProfesseurField.setText(s);
				}
			}
		});

	}
}
