package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Classe;
import com.ensah.model.entityData.ClasseData;
import com.ensah.utils.ConnectionFactory;

public class ClasseDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public ClasseDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(Classe obj) {
		String query = "{CALL insertClasse(?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(ClasseData.designationClasse.getValue(), obj.getDesignationClasse());
			stmt.setInt(ClasseData.filiereId.getValue(), obj.getFiliereId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Classe obj) {
		String query = "{CALL deleteClasse(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ClasseData.idClasse.getValue(), obj.getIdClasse());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Classe obj) {
		String query = "{CALL UpdateClasse(?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ClasseData.idClasse.getValue(), obj.getIdClasse());
			stmt.setString(ClasseData.designationClasse.getValue(), obj.getDesignationClasse());
			stmt.setInt(ClasseData.filiereId.getValue(), obj.getFiliereId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Classe> find(int id) {
		String query = "{CALL findClasse(?)}";
		Classe classe = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ClasseData.idClasse.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				classe = new Classe.ClasseBuilder().setIdClasse(resultSet.getInt(ClasseData.idClasse.getValue()))
						.setDesignationClasse(resultSet.getString(ClasseData.designationClasse.getValue()))
						.setFiliereId(resultSet.getInt(ClasseData.filiereId.getValue())).build();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(classe);
	}

	public List<Classe> findAll() {
		String query = "{CALL findAllClasse()}";
		List<Classe> listClasses = new ArrayList<Classe>();
		Classe classe = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				classe = new Classe.ClasseBuilder().setIdClasse(resultSet.getInt(ClasseData.idClasse.getValue()))
						.setDesignationClasse(resultSet.getString(ClasseData.designationClasse.getValue()))
						.setFiliereId(resultSet.getInt(ClasseData.filiereId.getValue())).build();
				listClasses.add(classe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClasses;
	}

	public List<Classe> findFiliere(int id) {
		String query = "{CALL findFiliereClasse(?)}";
		List<Classe> listClasses = new ArrayList<Classe>();
		Classe classe = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ClasseData.filiereId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				classe = new Classe.ClasseBuilder().setIdClasse(resultSet.getInt(ClasseData.idClasse.getValue()))
						.setDesignationClasse(resultSet.getString(ClasseData.designationClasse.getValue()))
						.setFiliereId(resultSet.getInt(ClasseData.filiereId.getValue())).build();
				listClasses.add(classe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClasses;
	}

}