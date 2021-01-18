package com.ensah.controller;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ensah.model.dao.AdministrateurDAO;
import com.ensah.model.dao.ProfesseurDAO;
import com.ensah.model.dao.UtilisateurDAO;
import com.ensah.model.entity.Professeur;
import com.ensah.model.entity.Utilisateur;
import com.ensah.utils.PasswordUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthentifiactionController {

	public static Professeur prof;

	@FXML
	private TextField nomUtilisateur;

	@FXML
	private Label authentification_errone;

	@FXML
	private TextField motDePasseUtilisateur;

	@FXML
	private Button authentifier;

	@FXML
	void authentification(ActionEvent event) throws SQLException {
		System.out.println("Authenticate");
		Parent root = null;

		ProfesseurDAO prof = new ProfesseurDAO();

		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		AdministrateurDAO admin = new AdministrateurDAO();

		String Username = nomUtilisateur.getText();
		String Password = motDePasseUtilisateur.getText();
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>(utilisateurDAO.findAll());
		Iterator<Utilisateur> iterator = listUtilisateur.iterator();
		while (iterator.hasNext()) {
			Utilisateur users = iterator.next();

			if ((users.getNomUtilisateur()).equals(Username) && PasswordUtil.verifierMotDePasse(Password,
					users.getMotDePasseUtilisateur(), users.getCleUtilisateur())) {
				ResultSet admins = admin.findId();
				while (admins.next()) {
					if (admins.getInt(1) == users.getIdUtilisateur()) {
						try {
							root = FXMLLoader
									.load(getClass().getResource("/com/ensah/view/administrateur/Administrateur.fxml"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						Scene scene = new Scene(root);
						Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						appStage.setScene(scene);

					} else {
						System.out.print("dommage");
						try {
							root = FXMLLoader
									.load(getClass().getResource("/com/ensah/view/professeur/Professeur.fxml"));
							prof.findUtilisateur(users.getIdUtilisateur());

						} catch (IOException e) {
							e.printStackTrace();
						}

						Scene scene = new Scene(root);
						Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						appStage.setScene(scene);

					}

				}

			} else {
				authentification_errone.setVisible(true);
			}
		}

	}

	public Professeur getProf() {
		return prof;
	}
}
