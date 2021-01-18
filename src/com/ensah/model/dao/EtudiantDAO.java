package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Etudiant;
import com.ensah.model.entityData.EtudiantData;
import com.ensah.utils.ConnectionFactory;

public class EtudiantDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public EtudiantDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(Etudiant obj) {
		String query = "{CALL insertEtudiant(?,?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(EtudiantData.cneEtudiant.getValue(), obj.getCneEtudiant());
			stmt.setString(EtudiantData.cinEtudiant.getValue(), obj.getCinEtudiant());
			stmt.setString(EtudiantData.nomEtudiant.getValue(), obj.getNomEtudiant());
			stmt.setString(EtudiantData.prenomEtudiant.getValue(), obj.getPrenomEtudiant());
			stmt.setInt(EtudiantData.classeId.getValue(), obj.getClasseId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Etudiant obj) {
		String query = "{CALL deleteEtudiant(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(EtudiantData.classeId.getValue(), obj.getClasseId());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Etudiant obj) {
		String query = "{CALL updateEtudiant(?,?,?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(EtudiantData.idEtudiant.getValue(), obj.getIdEtudiant());
			stmt.setString(EtudiantData.cneEtudiant.getValue(), obj.getCneEtudiant());
			stmt.setString(EtudiantData.cinEtudiant.getValue(), obj.getCinEtudiant());
			stmt.setString(EtudiantData.nomEtudiant.getValue(), obj.getNomEtudiant());
			stmt.setString(EtudiantData.prenomEtudiant.getValue(), obj.getPrenomEtudiant());
			stmt.setInt(EtudiantData.classeId.getValue(), obj.getClasseId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Etudiant> find(int id) {
		String query = "{CALL findEtudiant(?)}";
		Etudiant etudiant = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(EtudiantData.idEtudiant.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				etudiant = new Etudiant.EtudiantBuilder()
						.setIdEtudiant(resultSet.getInt(EtudiantData.idEtudiant.getValue()))
						.setCneEtudiant(resultSet.getString(EtudiantData.cneEtudiant.getValue()))
						.setCinEtudiant(resultSet.getString(EtudiantData.cinEtudiant.getValue()))
						.setNomEtudiant(resultSet.getString(EtudiantData.nomEtudiant.getValue()))
						.setPrenomEtudiant(resultSet.getString(EtudiantData.prenomEtudiant.getValue()))
						.setClasseId(resultSet.getInt(EtudiantData.classeId.getValue())).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(etudiant);
	}

	public List<Etudiant> findAll() {
		String query = "{CALL findAllEtudiant()}";
		List<Etudiant> listEtudiants = new ArrayList<>();
		Etudiant etudiant = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				etudiant = new Etudiant.EtudiantBuilder()
						.setIdEtudiant(resultSet.getInt(EtudiantData.idEtudiant.getValue()))
						.setCneEtudiant(resultSet.getString(EtudiantData.cneEtudiant.getValue()))
						.setCinEtudiant(resultSet.getString(EtudiantData.cinEtudiant.getValue()))
						.setNomEtudiant(resultSet.getString(EtudiantData.nomEtudiant.getValue()))
						.setPrenomEtudiant(resultSet.getString(EtudiantData.prenomEtudiant.getValue()))
						.setClasseId(resultSet.getInt(EtudiantData.classeId.getValue())).build();

				listEtudiants.add(etudiant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiants;
	}

	public List<Etudiant> findClasse(int id) {
		String query = "{CALL findClasseEtudiant(?)}";
		List<Etudiant> listEtudiants = new ArrayList<>();
		Etudiant etudiant = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(EtudiantData.classeId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				etudiant = new Etudiant.EtudiantBuilder()
						.setIdEtudiant(resultSet.getInt(EtudiantData.idEtudiant.getValue()))
						.setCneEtudiant(resultSet.getString(EtudiantData.cneEtudiant.getValue()))
						.setCinEtudiant(resultSet.getString(EtudiantData.cinEtudiant.getValue()))
						.setNomEtudiant(resultSet.getString(EtudiantData.nomEtudiant.getValue()))
						.setPrenomEtudiant(resultSet.getString(EtudiantData.prenomEtudiant.getValue()))
						.setClasseId(resultSet.getInt(EtudiantData.classeId.getValue())).build();
				listEtudiants.add(etudiant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiants;
	}

}
