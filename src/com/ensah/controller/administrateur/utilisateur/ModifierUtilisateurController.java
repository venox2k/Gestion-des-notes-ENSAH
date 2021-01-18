package com.ensah.controller.administrateur.utilisateur;

import java.net.URL;
import java.util.ResourceBundle;

import com.ensah.controller.administrateur.GestionUtilisateurController;
import com.ensah.model.dao.UtilisateurDAO;
import com.ensah.model.entity.Utilisateur;
import com.ensah.utils.PasswordUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ModifierUtilisateurController implements Initializable {

	GestionUtilisateurController tmp = new GestionUtilisateurController();
	
	@FXML
	private AnchorPane modifierUtilisateurPane;

	@FXML
	private TextField nomUtilisateurField;

	@FXML
	private CheckBox reinitialiseMotDePasseCheckBox;

	@FXML
	private Button modifierUtilisateurBtn;

	@FXML
	void modifierUtilisateur(ActionEvent event) {
		 String cle = null ;
		 String password = null;
          String username = nomUtilisateurField.getText();
          if(reinitialiseMotDePasseCheckBox.isSelected())
          {
        	 cle =PasswordUtil.generateCleUtilisateur();
        	  password = PasswordUtil.generateSecureMotDePasse(nomUtilisateurField.getText(), cle);
           }
  		Utilisateur user2 = tmp.getUser();
  		user2.setCleUtilisateur(cle);
  		user2.setMotDePasseUtilisateur(password);
  		user2.setNomUtilisateur(username);
  		UtilisateurDAO userDAO = new UtilisateurDAO();
  		userDAO.update(user2);
  		

		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Utilisateur user2 = tmp.getUser();
        nomUtilisateurField.setText(user2.getNomUtilisateur());		
	}

}
