package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Departement;
import com.ensah.model.entityData.DepartementData;
import com.ensah.utils.ConnectionFactory;

public class DepartementDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public DepartementDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insertCSV(Departement obj) {
		String query = "{CALL insertCSVDepartement(?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(DepartementData.designationDepartement.getValue(), obj.getDesignationDepartement());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean insert(Departement obj) {
		String query = "{CALL insertDepartement(?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(DepartementData.designationDepartement.getValue(), obj.getDesignationDepartement());
			stmt.setInt(DepartementData.professeurId.getValue(), obj.getProfesseurId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Departement obj) {
		String query = "{CALL deleteDepartement(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(DepartementData.idDepartement.getValue(), obj.getIdDepartement());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Departement obj) {
		String query = "{CALL updateDepartement(?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(DepartementData.idDepartement.getValue(), obj.getIdDepartement());
			stmt.setString(DepartementData.designationDepartement.getValue(), obj.getDesignationDepartement());
			stmt.setInt(DepartementData.professeurId.getValue(), obj.getProfesseurId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Departement> find(int id) {
		String query = "{CALL findDepartement(?)}";
		Departement departement = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(DepartementData.idDepartement.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				departement = new Departement.DepartementBuilder()
						.setIdDepartement(resultSet.getInt(DepartementData.idDepartement.getValue()))
						.setDesignationDepartement(
								resultSet.getString(DepartementData.designationDepartement.getValue()))
						.setProfesseurId(resultSet.getInt(DepartementData.professeurId.getValue())).build();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(departement);
	}

	public List<Departement> findAll() {
		String query = "{CALL findAllDepartement()}";
		List<Departement> listDepartements = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			Departement departement = null;
			while (resultSet.next()) {
				departement = new Departement.DepartementBuilder()
						.setIdDepartement(resultSet.getInt(DepartementData.idDepartement.getValue()))
						.setDesignationDepartement(
								resultSet.getString(DepartementData.designationDepartement.getValue()))
						.setProfesseurId(resultSet.getInt(DepartementData.professeurId.getValue())).build();
				listDepartements.add(departement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDepartements;
	}

}
