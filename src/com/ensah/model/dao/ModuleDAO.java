package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Module;
import com.ensah.model.entityData.ModuleData;
import com.ensah.utils.ConnectionFactory;

public class ModuleDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public ModuleDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(Module obj) {
		String query = "{CALL insertModule(?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(ModuleData.designationModule.getValue(), obj.getDesignationModule());
			stmt.setInt(ModuleData.semesterId.getValue(), obj.getSemesterId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Module obj) {
		String query = "{CALL deleteModule(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ModuleData.idModule.getValue(), obj.getIdModule());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Module obj) {
		String query = "{CALL updateModule(?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ModuleData.idModule.getValue(), obj.getIdModule());
			stmt.setString(ModuleData.designationModule.getValue(), obj.getDesignationModule());
			stmt.setInt(ModuleData.semesterId.getValue(), obj.getSemesterId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<Module> find(int id) {
		String query = "{CALL findModule(?)}";
		Module module = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ModuleData.idModule.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				module = new Module.ModuleBuilder().setIdModule(resultSet.getInt(ModuleData.idModule.getValue()))
						.setDesignationModule(resultSet.getString(ModuleData.designationModule.getValue()))
						.setSemesterId(resultSet.getInt(ModuleData.semesterId.getValue())).build();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(module);
	}

	public List<Module> findAll() {
		String query = "{CALL findAllModule()}";
		List<Module> listModules = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			Module module = null;
			while (resultSet.next()) {
				module = new Module.ModuleBuilder().setIdModule(resultSet.getInt(ModuleData.idModule.getValue()))
						.setDesignationModule(resultSet.getString(ModuleData.designationModule.getValue()))
						.setSemesterId(resultSet.getInt(ModuleData.semesterId.getValue())).build();
				listModules.add(module);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listModules;
	}

	public List<Module> findSemestre(int id) {
		String query = "{CALL findSemesterModule(?)}";
		List<Module> listModules = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ModuleData.semesterId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			Module module = null;
			while (resultSet.next()) {
				module = new Module.ModuleBuilder().setIdModule(resultSet.getInt(ModuleData.idModule.getValue()))
						.setDesignationModule(resultSet.getString(ModuleData.designationModule.getValue()))
						.setSemesterId(resultSet.getInt(ModuleData.semesterId.getValue())).build();
				listModules.add(module);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listModules;
	}


	public int findLastModuleId() {
		String query = "{CALL findLastModuleId()}";
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
	
}
