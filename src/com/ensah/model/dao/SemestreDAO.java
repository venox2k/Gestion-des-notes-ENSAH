package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Semestre;
import com.ensah.model.entityData.SemesterData;
import com.ensah.utils.ConnectionFactory;

public class SemestreDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public SemestreDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(Semestre obj) {
		String query = "{CALL insertSemestre(?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(SemesterData.designationSemestre.getValue(), obj.getDesignationSemestre());
			stmt.setInt(SemesterData.classeId.getValue(), obj.getClasseId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Semestre obj) {
		String query = "{CALL deleteSemestre(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(SemesterData.idSemestre.getValue(), obj.getIdSemestre());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Semestre obj) {
		String query = "{CALL updateSemestre(?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(SemesterData.idSemestre.getValue(), obj.getIdSemestre());
			stmt.setString(SemesterData.designationSemestre.getValue(), obj.getDesignationSemestre());
			stmt.setInt(SemesterData.classeId.getValue(), obj.getClasseId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Semestre> find(int id) {
		String query = "{CALL findSemestre(?)}";
		Semestre semester = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(SemesterData.idSemestre.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				semester = new Semestre.SemestreBuilder()
						.setIdSemestre(resultSet.getInt(SemesterData.idSemestre.getValue()))
						.setDesignationSemestre(resultSet.getString(SemesterData.designationSemestre.getValue()))
						.setClasseId(resultSet.getInt(SemesterData.classeId.getValue())).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(semester);
	}

	public List<Semestre> findAll() {
		String query = "{CALL findAllSemestre()}";
		List<Semestre> listSemesters = new ArrayList<>();
		Semestre semester = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				semester = new Semestre.SemestreBuilder()
						.setIdSemestre(resultSet.getInt(SemesterData.idSemestre.getValue()))
						.setDesignationSemestre(resultSet.getString(SemesterData.designationSemestre.getValue()))
						.setClasseId(resultSet.getInt(SemesterData.classeId.getValue())).build();
				listSemesters.add(semester);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSemesters;
	}

	public List<Semestre> findClasse(int id) {
		String query = "{CALL findClasseSemestre(?)}";
		List<Semestre> listSemesters = new ArrayList<>();
		Semestre semester = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(SemesterData.classeId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				semester = new Semestre.SemestreBuilder()
						.setIdSemestre(resultSet.getInt(SemesterData.idSemestre.getValue()))
						.setDesignationSemestre(resultSet.getString(SemesterData.designationSemestre.getValue()))
						.setClasseId(resultSet.getInt(SemesterData.classeId.getValue())).build();
				listSemesters.add(semester);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSemesters;
	}

}
