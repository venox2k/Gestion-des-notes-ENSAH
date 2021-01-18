package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Filiere;
import com.ensah.model.entityData.FiliereData;
import com.ensah.utils.ConnectionFactory;

public class FiliereDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public FiliereDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}
	
	public boolean insertCSV(Filiere obj) {
		String query = "{CALL insertCSVFiliere(?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(FiliereData.designationFiliere.getValue(), obj.getDesignationFiliere());
			stmt.setDouble(FiliereData.noteEliminatoireFiliere.getValue(), obj.getNoteEliminatoireFiliere());
			stmt.setInt(FiliereData.departementId.getValue(), obj.getDepartementId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean insert(Filiere obj) {
		String query = "{CALL insertFiliere(?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(FiliereData.designationFiliere.getValue(), obj.getDesignationFiliere());
			stmt.setDouble(FiliereData.noteEliminatoireFiliere.getValue(), obj.getNoteEliminatoireFiliere());
			stmt.setInt(FiliereData.departementId.getValue(), obj.getDepartementId());
			stmt.setInt(FiliereData.professeurId.getValue(), obj.getProfesseurId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Filiere obj) {
		String query = "{CALL deleteFiliere(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(FiliereData.idFiliere.getValue(), obj.getIdFiliere());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Filiere obj) {
		String query = "{CALL updateFiliere(?,?,?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(FiliereData.idFiliere.getValue(), obj.getIdFiliere());
			stmt.setString(FiliereData.designationFiliere.getValue(), obj.getDesignationFiliere());
			stmt.setDouble(FiliereData.noteEliminatoireFiliere.getValue(), obj.getNoteEliminatoireFiliere());
			stmt.setInt(FiliereData.departementId.getValue(), obj.getDepartementId());
			stmt.setInt(FiliereData.professeurId.getValue(), obj.getProfesseurId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Filiere> find(int id) {
		String query = "{CALL findFiliere(?)}";
		Filiere filiere = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(FiliereData.idFiliere.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				filiere = new Filiere.FiliereBuilder().setIdFiliere(resultSet.getInt(FiliereData.idFiliere.getValue()))
						.setDesignationFiliere(resultSet.getString(FiliereData.designationFiliere.getValue()))
						.setNoteEliminatoireFiliere(resultSet.getDouble(FiliereData.noteEliminatoireFiliere.getValue()))
						.setDepartementId(resultSet.getInt(FiliereData.departementId.getValue())).build();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(filiere);
	}

	public List<Filiere> findAll() {
		String query = "{CALL findAllFiliere()}";
		List<Filiere> listFilieres = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			Filiere filiere = null;
			while (resultSet.next()) {
				filiere = new Filiere.FiliereBuilder().setIdFiliere(resultSet.getInt(FiliereData.idFiliere.getValue()))
						.setDesignationFiliere(resultSet.getString(FiliereData.designationFiliere.getValue()))
						.setNoteEliminatoireFiliere(resultSet.getDouble(FiliereData.noteEliminatoireFiliere.getValue()))
						.setDepartementId(resultSet.getInt(FiliereData.departementId.getValue())).build();
				listFilieres.add(filiere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFilieres;
	}

	public List<Filiere> findDepartement(int id) {
		String query = "{CALL findDepartementFiliere(?)}";
		Filiere filiere = null;
		List<Filiere> listFilieres = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(FiliereData.departementId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				filiere = new Filiere.FiliereBuilder().setIdFiliere(resultSet.getInt(FiliereData.idFiliere.getValue()))
						.setDesignationFiliere(resultSet.getString(FiliereData.designationFiliere.getValue()))
						.setNoteEliminatoireFiliere(resultSet.getDouble(FiliereData.noteEliminatoireFiliere.getValue()))
						.setDepartementId(resultSet.getInt(FiliereData.departementId.getValue())).build();
				listFilieres.add(filiere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFilieres;
	}

}
