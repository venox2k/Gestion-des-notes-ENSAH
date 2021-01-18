package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Utilisateur;
import com.ensah.model.entityData.UtilisateurData;
import com.ensah.utils.ConnectionFactory;

public class UtilisateurDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public UtilisateurDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(Utilisateur obj) {
		String query = "{CALL insertUtilisateur(?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(UtilisateurData.nomUtilisateur.getValue(), obj.getNomUtilisateur());
			stmt.setString(UtilisateurData.motDePasseUtilisateur.getValue(), obj.getMotDePasseUtilisateur());
			stmt.setString(UtilisateurData.cleUtilisateur.getValue(), obj.getCleUtilisateur());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Utilisateur obj) {
		String query = "{CALL deleteUtilisateur(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(UtilisateurData.idUtilisateur.getValue(), obj.getIdUtilisateur());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Utilisateur obj) {
		String query = "{CALL updateUtilisateur(?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(UtilisateurData.idUtilisateur.getValue(), obj.getIdUtilisateur());
			stmt.setString(UtilisateurData.nomUtilisateur.getValue(), obj.getNomUtilisateur());
			stmt.setString(UtilisateurData.motDePasseUtilisateur.getValue(), obj.getMotDePasseUtilisateur());
			stmt.setString(UtilisateurData.cleUtilisateur.getValue(), obj.getCleUtilisateur());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Utilisateur> find(int id) {
		String query = "{CALL findUtilisateur(?)}";
		Utilisateur utilisateur = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(UtilisateurData.idUtilisateur.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				utilisateur = new Utilisateur.UtilisateurBuilder()
						.setIdUtilisateur(resultSet.getInt(UtilisateurData.idUtilisateur.getValue()))
						.setNomUtilisateur(resultSet.getString(UtilisateurData.nomUtilisateur.getValue()))
						.setMotDePasseUtilisateur(resultSet.getString(UtilisateurData.motDePasseUtilisateur.getValue()))
						.setCleUtilisateur(resultSet.getString(UtilisateurData.cleUtilisateur.getValue())).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(utilisateur);
	}

	public List<Utilisateur> findAll() {
		String query = "{CALL findAllUtilisateur()}";
		List<Utilisateur> listUtilisateurs = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			Utilisateur utilisateur = null;
			while (resultSet.next()) {
				utilisateur = new Utilisateur.UtilisateurBuilder()
						.setIdUtilisateur(resultSet.getInt(UtilisateurData.idUtilisateur.getValue()))
						.setNomUtilisateur(resultSet.getString(UtilisateurData.nomUtilisateur.getValue()))
						.setMotDePasseUtilisateur(resultSet.getString(UtilisateurData.motDePasseUtilisateur.getValue()))
						.setCleUtilisateur(resultSet.getString(UtilisateurData.cleUtilisateur.getValue())).build();
				listUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUtilisateurs;
	}
	
	public int findLastUtilisateurId() {
		String query = "{CALL findLastUtilisateurId()}";
		int i = 0;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				i = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	public ResultSet authentificate() throws SQLException
//	{
//	   Statement stmt =  connection.createStatement();
//	   String query ="SELECT idUtilisateur,nomUtilisateur,motDePasseUtilisateur FROM utilisateur " ;
//	   ResultSet rs = stmt.executeQuery(query);
//	   
//	   return rs ;
//	}
}
