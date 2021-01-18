package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.NoteElement;
import com.ensah.model.entityData.NoteElementData;
import com.ensah.utils.ConnectionFactory;

public class NoteElementDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public NoteElementDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insert(NoteElement obj) {
		String query = "{CALL insertNoteElement(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setDouble(NoteElementData.noteDsElement.getValue(), obj.getNoteDsElement());
			stmt.setDouble(NoteElementData.noteExamElement.getValue(), obj.getNoteExamElement());
			stmt.setDouble(NoteElementData.noteTpElement.getValue(), obj.getNoteTpElement());
			stmt.setDouble(NoteElementData.noteProjetElement.getValue(), obj.getNoteProjectElement());
			stmt.setDouble(NoteElementData.noteExposeElement.getValue(), obj.getNoteExposeElement());
			stmt.setDouble(NoteElementData.noteDevoirLibreElement.getValue(), obj.getNoteDevoirLibreElement());
			stmt.setInt(NoteElementData.scenceAbsenteElement.getValue(), obj.getScenceAbsenteElement());
			stmt.setBoolean(NoteElementData.valideAvantRattrapage.getValue(), obj.getValideAvantRattrapage());
			stmt.setDouble(NoteElementData.noteAvantRattrapage.getValue(), obj.getNoteAvantRattrapage());
			stmt.setBoolean(NoteElementData.valideApresRattrapage.getValue(), obj.getValideApresRattrapage());
			stmt.setDouble(NoteElementData.noteApresRattrapage.getValue(), obj.getNoteApresRattrapage());
			stmt.setDouble(NoteElementData.noteElement.getValue(), obj.getNoteElement());
			stmt.setInt(NoteElementData.elementId.getValue(), obj.getElementId());
			stmt.setInt(NoteElementData.etudiantId.getValue(), obj.getEtudiantId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(NoteElement obj) {
		String query = "{CALL deleteNoteElement(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteElementData.idNoteElement.getValue(), obj.getIdNoteElement());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(NoteElement obj) {
		String query = "{CALL updateNoteElement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteElementData.idNoteElement.getValue(), obj.getIdNoteElement());
			stmt.setDouble(NoteElementData.noteDsElement.getValue(), obj.getNoteDsElement());
			stmt.setDouble(NoteElementData.noteExamElement.getValue(), obj.getNoteExamElement());
			stmt.setDouble(NoteElementData.noteTpElement.getValue(), obj.getNoteTpElement());
			stmt.setDouble(NoteElementData.noteProjetElement.getValue(), obj.getNoteProjectElement());
			stmt.setDouble(NoteElementData.noteExposeElement.getValue(), obj.getNoteExposeElement());
			stmt.setDouble(NoteElementData.noteDevoirLibreElement.getValue(), obj.getNoteDevoirLibreElement());
			stmt.setInt(NoteElementData.scenceAbsenteElement.getValue(), obj.getScenceAbsenteElement());
			stmt.setBoolean(NoteElementData.valideAvantRattrapage.getValue(), obj.getValideAvantRattrapage());
			stmt.setDouble(NoteElementData.noteAvantRattrapage.getValue(), obj.getNoteAvantRattrapage());
			stmt.setBoolean(NoteElementData.valideApresRattrapage.getValue(), obj.getValideApresRattrapage());
			stmt.setDouble(NoteElementData.noteApresRattrapage.getValue(), obj.getNoteApresRattrapage());
			stmt.setDouble(NoteElementData.noteElement.getValue(), obj.getNoteElement());
			stmt.setInt(NoteElementData.elementId.getValue(), obj.getElementId());
			stmt.setInt(NoteElementData.etudiantId.getValue(), obj.getEtudiantId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public Optional<NoteElement> find(int id) {
		String query = "{CALL findNoteElement(?)}";
		NoteElement noteelement = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteElementData.idNoteElement.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				noteelement = new NoteElement.NoteElementBuilder()
						.setIdNoteElement(resultSet.getInt(NoteElementData.idNoteElement.getValue()))
						.setNoteDsElement(resultSet.getDouble(NoteElementData.noteDsElement.getValue()))
						.setNoteExamElement(resultSet.getDouble(NoteElementData.noteExamElement.getValue()))
						.setNoteTpElement(resultSet.getDouble(NoteElementData.noteTpElement.getValue()))
						.setNoteProjectElement(resultSet.getDouble(NoteElementData.noteProjetElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteExposeElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteDevoirLibreElement.getValue()))
						.setScenceAbsenteElement(resultSet.getInt(NoteElementData.scenceAbsenteElement.getValue()))
						.setValideAvantRattrapage(
								resultSet.getBoolean(NoteElementData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getInt(NoteElementData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(
								resultSet.getBoolean(NoteElementData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteElementData.noteApresRattrapage.getValue()))
						.setNoteElement(resultSet.getDouble(NoteElementData.noteElement.getValue()))
						.setElementId(resultSet.getInt(NoteElementData.elementId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteElementData.etudiantId.getValue())).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(noteelement);
	}

	public List<NoteElement> findAll() {
		String query = "{CALL findAllNoteElement()}";
		List<NoteElement> noteelements = new ArrayList<>();
		NoteElement noteelement = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				noteelement = new NoteElement.NoteElementBuilder()
						.setIdNoteElement(resultSet.getInt(NoteElementData.idNoteElement.getValue()))
						.setNoteDsElement(resultSet.getDouble(NoteElementData.noteDsElement.getValue()))
						.setNoteExamElement(resultSet.getDouble(NoteElementData.noteExamElement.getValue()))
						.setNoteTpElement(resultSet.getDouble(NoteElementData.noteTpElement.getValue()))
						.setNoteProjectElement(resultSet.getDouble(NoteElementData.noteProjetElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteExposeElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteDevoirLibreElement.getValue()))
						.setScenceAbsenteElement(resultSet.getInt(NoteElementData.scenceAbsenteElement.getValue()))
						.setValideAvantRattrapage(
								resultSet.getBoolean(NoteElementData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getInt(NoteElementData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(
								resultSet.getBoolean(NoteElementData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteElementData.noteApresRattrapage.getValue()))
						.setNoteElement(resultSet.getDouble(NoteElementData.noteElement.getValue()))
						.setElementId(resultSet.getInt(NoteElementData.elementId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteElementData.etudiantId.getValue())).build();
				noteelements.add(noteelement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noteelements;
	}

	public List<NoteElement> findElement(int id) {
		String query = "{CALL findElementNoteElement(?)}";
		List<NoteElement> noteelements = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteElementData.elementId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			NoteElement noteelement = null;
			while (resultSet.next()) {
				noteelement = new NoteElement.NoteElementBuilder()
						.setIdNoteElement(resultSet.getInt(NoteElementData.idNoteElement.getValue()))
						.setNoteDsElement(resultSet.getDouble(NoteElementData.noteDsElement.getValue()))
						.setNoteExamElement(resultSet.getDouble(NoteElementData.noteExamElement.getValue()))
						.setNoteTpElement(resultSet.getDouble(NoteElementData.noteTpElement.getValue()))
						.setNoteProjectElement(resultSet.getDouble(NoteElementData.noteProjetElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteExposeElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteDevoirLibreElement.getValue()))
						.setScenceAbsenteElement(resultSet.getInt(NoteElementData.scenceAbsenteElement.getValue()))
						.setValideAvantRattrapage(
								resultSet.getBoolean(NoteElementData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getInt(NoteElementData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(
								resultSet.getBoolean(NoteElementData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteElementData.noteApresRattrapage.getValue()))
						.setNoteElement(resultSet.getDouble(NoteElementData.noteElement.getValue()))
						.setElementId(resultSet.getInt(NoteElementData.elementId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteElementData.etudiantId.getValue())).build();
				noteelements.add(noteelement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noteelements;
	}

	public List<NoteElement> findEtudiant(int id) {
		String query = "{CALL findEtudiantNoteElement(?)}";
		List<NoteElement> noteelements = new ArrayList<>();
		NoteElement noteelement = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(NoteElementData.etudiantId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				noteelement = new NoteElement.NoteElementBuilder()
						.setIdNoteElement(resultSet.getInt(NoteElementData.idNoteElement.getValue()))
						.setNoteDsElement(resultSet.getDouble(NoteElementData.noteDsElement.getValue()))
						.setNoteExamElement(resultSet.getDouble(NoteElementData.noteExamElement.getValue()))
						.setNoteTpElement(resultSet.getDouble(NoteElementData.noteTpElement.getValue()))
						.setNoteProjectElement(resultSet.getDouble(NoteElementData.noteProjetElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteExposeElement.getValue()))
						.setNoteExposeElement(resultSet.getDouble(NoteElementData.noteDevoirLibreElement.getValue()))
						.setScenceAbsenteElement(resultSet.getInt(NoteElementData.scenceAbsenteElement.getValue()))
						.setValideAvantRattrapage(
								resultSet.getBoolean(NoteElementData.valideAvantRattrapage.getValue()))
						.setNoteAvantRattrapage(resultSet.getInt(NoteElementData.noteAvantRattrapage.getValue()))
						.setValideApresRattrapage(
								resultSet.getBoolean(NoteElementData.valideApresRattrapage.getValue()))
						.setNoteApresRattrapage(resultSet.getDouble(NoteElementData.noteApresRattrapage.getValue()))
						.setNoteElement(resultSet.getDouble(NoteElementData.noteElement.getValue()))
						.setElementId(resultSet.getInt(NoteElementData.elementId.getValue()))
						.setEtudiantId(resultSet.getInt(NoteElementData.etudiantId.getValue())).build();
				noteelements.add(noteelement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noteelements;
	}

}
