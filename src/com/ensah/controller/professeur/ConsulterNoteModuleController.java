package com.ensah.controller.professeur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class ConsulterNoteModuleController {

	@FXML
	private TableColumn<?, ?> nomEtudiantColumn;

	@FXML
	private TableColumn<?, ?> prenomEtudiantColumn;

	@FXML
	private TableColumn<?, ?> cneEtudiantColumn;

	@FXML
	private TableColumn<?, ?> valideAvantRattrapageColumn;

	@FXML
	private TableColumn<?, ?> valideApresRattrapageColumn;

	@FXML
	private TableColumn<?, ?> noteModuleColumn;

	@FXML
	private Label designationModuleLabel;

}
