package com.ensah.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoadUI {

	public Parent loadUI(String ui) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(ui));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}
}
