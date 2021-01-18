package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Professeur;
import com.ensah.model.entityData.ProfesseurData;
import com.ensah.utils.ConnectionFactory;

public class ProfesseurDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public ProfesseurDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(Professeur obj) {
		String query = "{CALL insertProfesseur(?,?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(ProfesseurData.nomProfesseur.getValue(), obj.getNomProfesseur());
			stmt.setString(ProfesseurData.prenomProfesseur.getValue(), obj.getPrenomProfesseur());
			stmt.setString(ProfesseurData.emailProfesseur.getValue(), obj.getEmailProfesseur());
			stmt.setInt(ProfesseurData.utilisateurId.getValue(), obj.getUtilisateurId());
			stmt.setInt(ProfesseurData.departementId.getValue(), obj.getDepartementId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Professeur obj) {
		String query = "{CALL deleteProfesseur(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ProfesseurData.idProfesseur.getValue(), obj.getIdProfesseur());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Professeur obj) {
		String query = "{CALL updateProfesseur(?,?,?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ProfesseurData.idProfesseur.getValue(), obj.getIdProfesseur());
			stmt.setString(ProfesseurData.nomProfesseur.getValue(), obj.getNomProfesseur());
			stmt.setString(ProfesseurData.prenomProfesseur.getValue(), obj.getPrenomProfesseur());
			stmt.setString(ProfesseurData.emailProfesseur.getValue(), obj.getEmailProfesseur());
			stmt.setInt(ProfesseurData.utilisateurId.getValue(), obj.getUtilisateurId());
			stmt.setInt(ProfesseurData.departementId.getValue(), obj.getDepartementId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Professeur> find(int id) {
		String query = "{CALL findProfesseur(?)}";
		Professeur professeur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ProfesseurData.idProfesseur.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				professeur = new Professeur.ProfesseurBuilder()
						.setIdProfesseur(resultSet.getInt(ProfesseurData.idProfesseur.getValue()))
						.setNomProfesseur(resultSet.getString(ProfesseurData.nomProfesseur.getValue()))
						.setPrenomProfesseur(resultSet.getString(ProfesseurData.prenomProfesseur.getValue()))
						.setEmailProfesseur(resultSet.getString(ProfesseurData.emailProfesseur.getValue()))
						.setUtilisateurId(resultSet.getInt(ProfesseurData.utilisateurId.getValue()))
						.setDepartementId(resultSet.getInt(ProfesseurData.departementId.getValue())).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(professeur);
	}

	public List<Professeur> findAll() {
		String query = "{CALL findAllProfesseur()}";
		List<Professeur> professeurs = new ArrayList<>();
		Professeur professeur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				professeur = new Professeur.ProfesseurBuilder()
						.setIdProfesseur(resultSet.getInt(ProfesseurData.idProfesseur.getValue()))
						.setNomProfesseur(resultSet.getString(ProfesseurData.nomProfesseur.getValue()))
						.setPrenomProfesseur(resultSet.getString(ProfesseurData.prenomProfesseur.getValue()))
						.setEmailProfesseur(resultSet.getString(ProfesseurData.emailProfesseur.getValue()))
						.setUtilisateurId(resultSet.getInt(ProfesseurData.utilisateurId.getValue()))
						.setDepartementId(resultSet.getInt(ProfesseurData.departementId.getValue())).build();
				professeurs.add(professeur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professeurs;
	}

	public List<Professeur> findUtilisateur(int id) {
		String query = "{CALL findUtilisateurProfesseur(?)}";
		List<Professeur> professeurs = new ArrayList<>();
		Professeur professeur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ProfesseurData.utilisateurId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				professeur = new Professeur.ProfesseurBuilder()
						.setIdProfesseur(resultSet.getInt(ProfesseurData.idProfesseur.getValue()))
						.setNomProfesseur(resultSet.getString(ProfesseurData.nomProfesseur.getValue()))
						.setPrenomProfesseur(resultSet.getString(ProfesseurData.prenomProfesseur.getValue()))
						.setEmailProfesseur(resultSet.getString(ProfesseurData.emailProfesseur.getValue()))
						.setUtilisateurId(resultSet.getInt(ProfesseurData.utilisateurId.getValue()))
						.setDepartementId(resultSet.getInt(ProfesseurData.departementId.getValue())).build();
				professeurs.add(professeur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professeurs;
	}

	public List<Professeur> findDepartement(int id) {
		String query = "{CALL findDepartementProfesseur(?)}";
		List<Professeur> professeurs = new ArrayList<>();
		Professeur professeur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ProfesseurData.departementId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				professeur = new Professeur.ProfesseurBuilder()
						.setIdProfesseur(resultSet.getInt(ProfesseurData.idProfesseur.getValue()))
						.setNomProfesseur(resultSet.getString(ProfesseurData.nomProfesseur.getValue()))
						.setPrenomProfesseur(resultSet.getString(ProfesseurData.prenomProfesseur.getValue()))
						.setEmailProfesseur(resultSet.getString(ProfesseurData.emailProfesseur.getValue()))
						.setUtilisateurId(resultSet.getInt(ProfesseurData.utilisateurId.getValue()))
						.setDepartementId(resultSet.getInt(ProfesseurData.departementId.getValue())).build();
				professeurs.add(professeur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professeurs;
	}

}
