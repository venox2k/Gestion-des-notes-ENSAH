package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.NoteModule;
import com.ensah.model.entityData.NoteModuleData;
import com.ensah.utils.ConnectionFactory;

public class NoteModuleDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public NoteModuleDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(NoteModule obj) {
		String query = "{CALL insertNoteModule(?,?,?,?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setBoolean(NoteModuleData.valideAvantRattrapage.getValue(), obj.getValideAvantRattrapage());
			stmt.setDouble(NoteModuleData.noteAvantRattrapage.getValue(), obj.getNoteAvantRattrapage());
			stmt.setBoolean(NoteModuleData.valideApresRattrapage.getValue(), obj.getValideApresRattrapage());
			stmt.setDouble(NoteModuleData.noteAvantRattrapage.getValue(), obj.getNoteApresRattrapage());
			stmt.setDouble(NoteModuleData.noteModule.getValue(), obj.getNoteModule());
			stmt.setInt(NoteModuleData.moduleId.getValue(), obj.getModuleId());
			stmt.setInt(NoteModuleData.etudiantId.getValue(), obj.getEtudiantId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(NoteModule obj) {
		String query = "{CALL deleteDepartement(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteModuleData.idNoteModule.getValue(), obj.getIdNoteModule());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(NoteModule obj) {
		String query = "{CALL updateNoteModule(?,?,?,?,?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteModuleData.idNoteModule.getValue(), obj.getIdNoteModule());
			stmt.setBoolean(NoteModuleData.valideAvantRattrapage.getValue(), obj.getValideAvantRattrapage());
			stmt.setDouble(NoteModuleData.noteAvantRattrapage.getValue(), obj.getNoteAvantRattrapage());
			stmt.setBoolean(NoteModuleData.valideApresRattrapage.getValue(), obj.getValideApresRattrapage());
			stmt.setDouble(NoteModuleData.noteAvantRattrapage.getValue(), obj.getNoteApresRattrapage());
			stmt.setDouble(NoteModuleData.noteModule.getValue(), obj.getNoteModule());
			stmt.setInt(NoteModuleData.moduleId.getValue(), obj.getModuleId());
			stmt.setInt(NoteModuleData.etudiantId.getValue(), obj.getEtudiantId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public Optional<NoteModule> find(int id) {
		String query = "{CALL findNoteModule(?)}";
		NoteModule noteModule = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteModuleData.idNoteModule.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				noteModule = new NoteModule.NoteModuleBuilder()
						.setIdNoteModule(resultSet.getInt(NoteModuleData.idNoteModule.getValue()))
						.setValideAvantRattrapage(resultSet.getBoolean(NoteModuleData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getDouble(NoteModuleData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(resultSet.getBoolean(NoteModuleData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteModuleData.noteApresRattrapage.getValue()))
						.setNoteModule(resultSet.getDouble(NoteModuleData.noteModule.getValue()))
						.setModuleId(resultSet.getInt(NoteModuleData.moduleId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteModuleData.etudiantId.getValue())).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(noteModule);
	}

	public List<NoteModule> findAll() {
		String query = "{CALL findAllNoteModule()}";
		List<NoteModule> listNoteModules = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			NoteModule noteModule = null;
			while (resultSet.next()) {
				noteModule = new NoteModule.NoteModuleBuilder()
						.setIdNoteModule(resultSet.getInt(NoteModuleData.idNoteModule.getValue()))
						.setValideAvantRattrapage(resultSet.getBoolean(NoteModuleData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getDouble(NoteModuleData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(resultSet.getBoolean(NoteModuleData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteModuleData.noteApresRattrapage.getValue()))
						.setNoteModule(resultSet.getDouble(NoteModuleData.noteModule.getValue()))
						.setModuleId(resultSet.getInt(NoteModuleData.moduleId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteModuleData.etudiantId.getValue())).build();
				listNoteModules.add(noteModule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNoteModules;

	}

	public List<NoteModule> findModule(int id) {
		String query = "{CALL findModuleNoteModule(?)}";
		List<NoteModule> listNoteModules = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteModuleData.moduleId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			NoteModule noteModule = null;
			while (resultSet.next()) {
				noteModule = new NoteModule.NoteModuleBuilder()
						.setIdNoteModule(resultSet.getInt(NoteModuleData.idNoteModule.getValue()))
						.setValideAvantRattrapage(resultSet.getBoolean(NoteModuleData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getDouble(NoteModuleData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(resultSet.getBoolean(NoteModuleData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteModuleData.noteApresRattrapage.getValue()))
						.setNoteModule(resultSet.getDouble(NoteModuleData.noteModule.getValue()))
						.setModuleId(resultSet.getInt(NoteModuleData.moduleId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteModuleData.etudiantId.getValue())).build();
				listNoteModules.add(noteModule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNoteModules;

	}
	

	public List<NoteModule> findEtudiant(int id) {
		String query = "{CALL findEtudiantNoteModule(?)}";
		List<NoteModule> listNoteModules = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteModuleData.etudiantId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			NoteModule noteModule = null;
			while (resultSet.next()) {
				noteModule = new NoteModule.NoteModuleBuilder()
						.setIdNoteModule(resultSet.getInt(NoteModuleData.idNoteModule.getValue()))
						.setValideAvantRattrapage(resultSet.getBoolean(NoteModuleData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getDouble(NoteModuleData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(resultSet.getBoolean(NoteModuleData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteModuleData.noteApresRattrapage.getValue()))
						.setNoteModule(resultSet.getDouble(NoteModuleData.noteModule.getValue()))
						.setModuleId(resultSet.getInt(NoteModuleData.moduleId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteModuleData.etudiantId.getValue())).build();
				listNoteModules.add(noteModule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNoteModules;

	}

}
