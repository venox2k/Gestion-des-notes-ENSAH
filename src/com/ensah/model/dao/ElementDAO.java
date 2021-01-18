package com.ensah.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensah.model.entity.Element;
import com.ensah.model.entityData.ElementData;
import com.ensah.utils.ConnectionFactory;

public class ElementDAO {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public ElementDAO() {
		connectionFactory = ConnectionFactory.getInstance();
		connection = connectionFactory.getConnection();
	}

	public boolean insertCSV(Element obj) {
		String query = "{CALL insertElementCSV(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(ElementData.designationElement.getValue(), obj.getDesignationElement());
			stmt.setDouble(ElementData.coefficientElement.getValue(), obj.getCoefficientElement());
			stmt.setBoolean(ElementData.dsActive.getValue(), obj.getDsActive());
			stmt.setBoolean(ElementData.examActive.getValue(), obj.getExamActive());
			stmt.setBoolean(ElementData.tpActive.getValue(), obj.getTpActive());
			stmt.setBoolean(ElementData.projetActive.getValue(), obj.getProjetActive());
			stmt.setBoolean(ElementData.exposeActive.getValue(), obj.getExposeActive());
			stmt.setBoolean(ElementData.devoirLibreActive.getValue(), obj.getDevoirLibreActive());
			stmt.setBoolean(ElementData.absenceActive.getValue(), obj.getAbsenceActive());
			stmt.setDouble(ElementData.coefficientDs.getValue(), obj.getCoefficientDs());
			stmt.setDouble(ElementData.coefficientExam.getValue(), obj.getCoefficientExam());
			stmt.setDouble(ElementData.coefficientTp.getValue(), obj.getCoefficientTp());
			stmt.setDouble(ElementData.coefficientProjet.getValue(), obj.getCoefficientProjet());
			stmt.setDouble(ElementData.coefficientExpose.getValue(), obj.getCoefficientExpose());
			stmt.setDouble(ElementData.coefficientDevoirLibre.getValue(), obj.getCoefficientDevoirLibre());
			stmt.setDouble(ElementData.coefficientAbsence.getValue(), obj.getCoefficientAbsence());
			stmt.setInt(ElementData.moduleId.getValue(), obj.getModuleId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean insert(Element obj) {
		String query = "{CALL insertElement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		boolean isCreated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setString(ElementData.designationElement.getValue(), obj.getDesignationElement());
			stmt.setDouble(ElementData.coefficientElement.getValue(), obj.getCoefficientElement());
			stmt.setBoolean(ElementData.dsActive.getValue(), obj.getDsActive());
			stmt.setBoolean(ElementData.examActive.getValue(), obj.getExamActive());
			stmt.setBoolean(ElementData.tpActive.getValue(), obj.getTpActive());
			stmt.setBoolean(ElementData.projetActive.getValue(), obj.getProjetActive());
			stmt.setBoolean(ElementData.exposeActive.getValue(), obj.getExposeActive());
			stmt.setBoolean(ElementData.devoirLibreActive.getValue(), obj.getDevoirLibreActive());
			stmt.setBoolean(ElementData.absenceActive.getValue(), obj.getAbsenceActive());
			stmt.setDouble(ElementData.coefficientDs.getValue(), obj.getCoefficientDs());
			stmt.setDouble(ElementData.coefficientExam.getValue(), obj.getCoefficientExam());
			stmt.setDouble(ElementData.coefficientTp.getValue(), obj.getCoefficientTp());
			stmt.setDouble(ElementData.coefficientProjet.getValue(), obj.getCoefficientProjet());
			stmt.setDouble(ElementData.coefficientExpose.getValue(), obj.getCoefficientExpose());
			stmt.setDouble(ElementData.coefficientDevoirLibre.getValue(), obj.getCoefficientDevoirLibre());
			stmt.setDouble(ElementData.coefficientAbsence.getValue(), obj.getCoefficientAbsence());
			stmt.setInt(ElementData.moduleId.getValue(), obj.getModuleId());
			stmt.setInt(ElementData.professeurId.getValue(), obj.getProfesseurId());
			isCreated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean delete(Element obj) {
		String query = "{CALL deleteElement(?)}";
		boolean isDeleted = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ElementData.idElement.getValue(), obj.getIdElement());
			isDeleted = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean update(Element obj) {
		String query = "{CALL updateElement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ElementData.idElement.getValue(), obj.getIdElement());
			stmt.setString(ElementData.designationElement.getValue(), obj.getDesignationElement());
			stmt.setDouble(ElementData.coefficientElement.getValue(), obj.getCoefficientElement());
			stmt.setBoolean(ElementData.dsActive.getValue(), obj.getDsActive());
			stmt.setBoolean(ElementData.examActive.getValue(), obj.getExamActive());
			stmt.setBoolean(ElementData.tpActive.getValue(), obj.getTpActive());
			stmt.setBoolean(ElementData.projetActive.getValue(), obj.getProjetActive());
			stmt.setBoolean(ElementData.exposeActive.getValue(), obj.getExposeActive());
			stmt.setBoolean(ElementData.devoirLibreActive.getValue(), obj.getDevoirLibreActive());
			stmt.setBoolean(ElementData.absenceActive.getValue(), obj.getAbsenceActive());
			stmt.setDouble(ElementData.coefficientDs.getValue(), obj.getCoefficientDs());
			stmt.setDouble(ElementData.coefficientExam.getValue(), obj.getCoefficientExam());
			stmt.setDouble(ElementData.coefficientTp.getValue(), obj.getCoefficientTp());
			stmt.setDouble(ElementData.coefficientProjet.getValue(), obj.getCoefficientProjet());
			stmt.setDouble(ElementData.coefficientExpose.getValue(), obj.getCoefficientExpose());
			stmt.setDouble(ElementData.coefficientDevoirLibre.getValue(), obj.getCoefficientDevoirLibre());
			stmt.setDouble(ElementData.coefficientAbsence.getValue(), obj.getCoefficientAbsence());
			stmt.setInt(ElementData.moduleId.getValue(), obj.getModuleId());
			stmt.setInt(ElementData.professeurId.getValue(), obj.getProfesseurId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public boolean updateCSV(Element obj) {
		String query = "{CALL updateCSVElement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ElementData.idElement.getValue(), obj.getIdElement());
			stmt.setString(ElementData.designationElement.getValue(), obj.getDesignationElement());
			stmt.setDouble(ElementData.coefficientElement.getValue(), obj.getCoefficientElement());
			stmt.setBoolean(ElementData.dsActive.getValue(), obj.getDsActive());
			stmt.setBoolean(ElementData.examActive.getValue(), obj.getExamActive());
			stmt.setBoolean(ElementData.tpActive.getValue(), obj.getTpActive());
			stmt.setBoolean(ElementData.projetActive.getValue(), obj.getProjetActive());
			stmt.setBoolean(ElementData.exposeActive.getValue(), obj.getExposeActive());
			stmt.setBoolean(ElementData.devoirLibreActive.getValue(), obj.getDevoirLibreActive());
			stmt.setBoolean(ElementData.absenceActive.getValue(), obj.getAbsenceActive());
			stmt.setDouble(ElementData.coefficientDs.getValue(), obj.getCoefficientDs());
			stmt.setDouble(ElementData.coefficientExam.getValue(), obj.getCoefficientExam());
			stmt.setDouble(ElementData.coefficientTp.getValue(), obj.getCoefficientTp());
			stmt.setDouble(ElementData.coefficientProjet.getValue(), obj.getCoefficientProjet());
			stmt.setDouble(ElementData.coefficientExpose.getValue(), obj.getCoefficientExpose());
			stmt.setDouble(ElementData.coefficientDevoirLibre.getValue(), obj.getCoefficientDevoirLibre());
			stmt.setDouble(ElementData.coefficientAbsence.getValue(), obj.getCoefficientAbsence());
			stmt.setInt(ElementData.moduleId.getValue(), obj.getModuleId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	
	public Optional<Element> find(int id) {
		String query = "{CALL findElement(?)}";
		Element element = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ElementData.idElement.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				element = new Element.ElementBuilder().setIdElement(resultSet.getInt(ElementData.idElement.getValue()))
						.setDesignationElement(resultSet.getString(ElementData.designationElement.getValue()))
						.setCoefficientElement(resultSet.getDouble(ElementData.coefficientElement.getValue()))
						.setDsActive(resultSet.getBoolean(ElementData.dsActive.getValue()))
						.setExamActive(resultSet.getBoolean(ElementData.examActive.getValue()))
						.setTpActive(resultSet.getBoolean(ElementData.tpActive.getValue()))
						.setProjetActive(resultSet.getBoolean(ElementData.projetActive.getValue()))
						.setExposeActive(resultSet.getBoolean(ElementData.exposeActive.getValue()))
						.setDevoirLibreActive(resultSet.getBoolean(ElementData.devoirLibreActive.getValue()))
						.setAbsenceActive(resultSet.getBoolean(ElementData.absenceActive.getValue()))
						.setCoefficientDs(resultSet.getDouble(ElementData.coefficientDs.getValue()))
						.setCoefficientExam(resultSet.getDouble(ElementData.coefficientExam.getValue()))
						.setCoefficientTp(resultSet.getDouble(ElementData.coefficientTp.getValue()))
						.setCoefficientProjet(resultSet.getDouble(ElementData.coefficientProjet.getValue()))
						.setCoefficientExpose(resultSet.getDouble(ElementData.coefficientExpose.getValue()))
						.setCoefficientDevoirLibre(resultSet.getDouble(ElementData.coefficientDevoirLibre.getValue()))
						.setCoefficientAbsence(resultSet.getDouble(ElementData.coefficientAbsence.getValue()))
						.setModuleId(resultSet.getInt(ElementData.moduleId.getValue()))
						.setProfesseurId(resultSet.getInt(ElementData.professeurId.getValue())).build();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(element);
	}

	public List<Element> findAll() {
		String query = "{CALL findAllElement()}";
		List<Element> listElements = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(query)) {
			ResultSet resultSet = stmt.executeQuery();
			Element element = null;
			while (resultSet.next()) {
				element = new Element.ElementBuilder().setIdElement(resultSet.getInt(ElementData.idElement.getValue()))
						.setDesignationElement(resultSet.getString(ElementData.designationElement.getValue()))
						.setCoefficientElement(resultSet.getDouble(ElementData.coefficientElement.getValue()))
						.setDsActive(resultSet.getBoolean(ElementData.dsActive.getValue()))
						.setExamActive(resultSet.getBoolean(ElementData.examActive.getValue()))
						.setTpActive(resultSet.getBoolean(ElementData.tpActive.getValue()))
						.setProjetActive(resultSet.getBoolean(ElementData.projetActive.getValue()))
						.setExposeActive(resultSet.getBoolean(ElementData.exposeActive.getValue()))
						.setDevoirLibreActive(resultSet.getBoolean(ElementData.devoirLibreActive.getValue()))
						.setAbsenceActive(resultSet.getBoolean(ElementData.absenceActive.getValue()))
						.setCoefficientDs(resultSet.getDouble(ElementData.coefficientDs.getValue()))
						.setCoefficientExam(resultSet.getDouble(ElementData.coefficientExam.getValue()))
						.setCoefficientTp(resultSet.getDouble(ElementData.coefficientTp.getValue()))
						.setCoefficientProjet(resultSet.getDouble(ElementData.coefficientProjet.getValue()))
						.setCoefficientExpose(resultSet.getDouble(ElementData.coefficientExpose.getValue()))
						.setCoefficientDevoirLibre(resultSet.getDouble(ElementData.coefficientDevoirLibre.getValue()))
						.setCoefficientAbsence(resultSet.getDouble(ElementData.coefficientAbsence.getValue()))
						.setModuleId(resultSet.getInt(ElementData.moduleId.getValue()))
						.setProfesseurId(resultSet.getInt(ElementData.professeurId.getValue())).build();
				listElements.add(element);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listElements;
	}

	public List<Element> findModule(int id) {
		String query = "{CALL findModuleElement(?)}";
		List<Element> listElements = new ArrayList<>();
		Element element = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ElementData.moduleId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				element = new Element.ElementBuilder().setIdElement(resultSet.getInt(ElementData.idElement.getValue()))
						.setDesignationElement(resultSet.getString(ElementData.designationElement.getValue()))
						.setCoefficientElement(resultSet.getDouble(ElementData.coefficientElement.getValue()))
						.setDsActive(resultSet.getBoolean(ElementData.dsActive.getValue()))
						.setExamActive(resultSet.getBoolean(ElementData.examActive.getValue()))
						.setTpActive(resultSet.getBoolean(ElementData.tpActive.getValue()))
						.setProjetActive(resultSet.getBoolean(ElementData.projetActive.getValue()))
						.setExposeActive(resultSet.getBoolean(ElementData.exposeActive.getValue()))
						.setDevoirLibreActive(resultSet.getBoolean(ElementData.devoirLibreActive.getValue()))
						.setAbsenceActive(resultSet.getBoolean(ElementData.absenceActive.getValue()))
						.setCoefficientDs(resultSet.getDouble(ElementData.coefficientDs.getValue()))
						.setCoefficientExam(resultSet.getDouble(ElementData.coefficientExam.getValue()))
						.setCoefficientTp(resultSet.getDouble(ElementData.coefficientTp.getValue()))
						.setCoefficientProjet(resultSet.getDouble(ElementData.coefficientProjet.getValue()))
						.setCoefficientExpose(resultSet.getDouble(ElementData.coefficientExpose.getValue()))
						.setCoefficientDevoirLibre(resultSet.getDouble(ElementData.coefficientDevoirLibre.getValue()))
						.setCoefficientAbsence(resultSet.getDouble(ElementData.coefficientAbsence.getValue()))
						.setModuleId(resultSet.getInt(ElementData.moduleId.getValue()))
						.setProfesseurId(resultSet.getInt(ElementData.professeurId.getValue())).build();
				listElements.add(element);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listElements;
	}
	
	public List<Element> findProfesseur(int id) {
		String query = "{CALL findProfesseurElement(?)}";
		List<Element> listElements = new ArrayList<>();
		Element element = null;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ElementData.professeurId.getValue(), id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				element = new Element.ElementBuilder().setIdElement(resultSet.getInt(ElementData.idElement.getValue()))
						.setDesignationElement(resultSet.getString(ElementData.designationElement.getValue()))
						.setCoefficientElement(resultSet.getDouble(ElementData.coefficientElement.getValue()))
						.setDsActive(resultSet.getBoolean(ElementData.dsActive.getValue()))
						.setExamActive(resultSet.getBoolean(ElementData.examActive.getValue()))
						.setTpActive(resultSet.getBoolean(ElementData.tpActive.getValue()))
						.setProjetActive(resultSet.getBoolean(ElementData.projetActive.getValue()))
						.setExposeActive(resultSet.getBoolean(ElementData.exposeActive.getValue()))
						.setDevoirLibreActive(resultSet.getBoolean(ElementData.devoirLibreActive.getValue()))
						.setAbsenceActive(resultSet.getBoolean(ElementData.absenceActive.getValue()))
						.setCoefficientDs(resultSet.getDouble(ElementData.coefficientDs.getValue()))
						.setCoefficientExam(resultSet.getDouble(ElementData.coefficientExam.getValue()))
						.setCoefficientTp(resultSet.getDouble(ElementData.coefficientTp.getValue()))
						.setCoefficientProjet(resultSet.getDouble(ElementData.coefficientProjet.getValue()))
						.setCoefficientExpose(resultSet.getDouble(ElementData.coefficientExpose.getValue()))
						.setCoefficientDevoirLibre(resultSet.getDouble(ElementData.coefficientDevoirLibre.getValue()))
						.setCoefficientAbsence(resultSet.getDouble(ElementData.coefficientAbsence.getValue()))
						.setModuleId(resultSet.getInt(ElementData.moduleId.getValue()))
						.setProfesseurId(resultSet.getInt(ElementData.professeurId.getValue())).build();
				listElements.add(element);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listElements;
	}

	public boolean update1(Element obj) {
		String query = "{CALL update_Element(?,?,?,?,?)}";
		boolean isUpdated = false;
		try (CallableStatement stmt = connection.prepareCall(query)) {
			stmt.setInt(ElementData.idElement.getValue(), obj.getIdElement());
			stmt.setString(ElementData.designationElement.getValue(), obj.getDesignationElement());
			stmt.setDouble(ElementData.coefficientElement.getValue(), obj.getCoefficientElement());
			stmt.setInt(ElementData.moduleId.getValue(), obj.getModuleId());
			stmt.setInt(ElementData.professeurId.getValue(), obj.getProfesseurId());
			isUpdated = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}


}
