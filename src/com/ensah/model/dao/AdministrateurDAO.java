package com.ensah.model.dao;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Administrateur;
import com.ensah.model.entityData.AdministrateurData;
import com.ensah.utils.ConnectionFactory;

public class AdministrateurDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public AdministrateurDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(Administrateur obj) {
		String query = "{CALL insertAdministrateur(?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(AdministrateurData.utilisateurId.getValue(), obj.getUtilisateurId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Administrateur obj) {
		String query = "{CALL deleteAdministrateur(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(AdministrateurData.idAdministrateur.getValue(), obj.getIdAdministrateur());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Administrateur obj) {
		String query = "{CALL updateAdministrateur(?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(AdministrateurData.idAdministrateur.getValue(), obj.getIdAdministrateur());
			stmt.setInt(AdministrateurData.utilisateurId.getValue(), obj.getUtilisateurId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Administrateur> find(int id) {
		String query = "{CALL findAdministrateur(?)}";
		Administrateur administrateur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(AdministrateurData.idAdministrateur.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				administrateur = new Administrateur.AdministrateurBuilder()
						.setIdAdministrateur(resultSet.getInt(AdministrateurData.idAdministrateur.getValue()))
						.setUtilisateurId(resultSet.getInt(AdministrateurData.utilisateurId.getValue())).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(administrateur);
	}

	public List<Administrateur> findAll() {
		String query = "{CALL findAllAdministrateur()}";
		List<Administrateur> administrateurs = new ArrayList<>();
		Administrateur administrateur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				administrateur = new Administrateur.AdministrateurBuilder()
						.setIdAdministrateur(resultSet.getInt(AdministrateurData.idAdministrateur.getValue()))
						.setUtilisateurId(resultSet.getInt(AdministrateurData.utilisateurId.getValue())).build();
				administrateurs.add(administrateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return administrateurs;
	}

	public List<Administrateur> findUtilisateur(int id) {
		String query = "{CALL findUtilisateurAdministrateur(?)}";
		List<Administrateur> administrateurs = new ArrayList<>();
		Administrateur administrateur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(AdministrateurData.utilisateurId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				administrateur = new Administrateur.AdministrateurBuilder()
						.setIdAdministrateur(resultSet.getInt(AdministrateurData.idAdministrateur.getValue()))
						.setUtilisateurId(resultSet.getInt(AdministrateurData.utilisateurId.getValue())).build();
				administrateurs.add(administrateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return administrateurs;
	}
	
	public ResultSet findId() throws SQLException
	{
		Statement stmt = connection.createStatement();
		String query =  "SELECT utilisateurId FROM administrateur ";
		ResultSet rs = stmt.executeQuery(query);
		 return rs  ;
	}

}
