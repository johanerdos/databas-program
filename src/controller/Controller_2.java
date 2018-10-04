package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import dal.Task2Dal;
import dal.Task2Meta;

public class Controller_2 {
	private static Task2Dal tableDal = new Task2Dal();
	private static Task2Meta metaDal = new Task2Meta();
	
	public static void updateQualification(DefaultTableModel dt) throws SQLException{
		ResultSet rs = tableDal.getQualification();
		tableDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateRelatives(DefaultTableModel dt) throws SQLException {
		ResultSet rs = tableDal.getRelatives();
		tableDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateStatisticsGroup(DefaultTableModel dt) throws SQLException {
		ResultSet rs = tableDal.getStatisticsGroup();
		tableDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateAbsence(DefaultTableModel dt) throws SQLException {
		ResultSet rs = tableDal.getAbsence();
		tableDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updatePortalSetup(DefaultTableModel dt) throws SQLException {
		ResultSet rs = tableDal.getPortalSetup();
		tableDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateEmployee(DefaultTableModel dt) throws SQLException {
		ResultSet rs = tableDal.getEmployee();
		tableDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateColumns(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getColumns();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateColumns2(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getColumnsTwo();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateIndexes(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getIndex();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateConstraints(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getConstraints();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateTableNameMostRows(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getTableNameMostRows();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateTables(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getTables();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateTables2(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getTablesTwo();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateAllKeys(DefaultTableModel dt) throws SQLException {
		ResultSet rs = metaDal.getAllKeys();
		metaDal.mapMetaArrayVector(rs, dt);
	}
	
	public static void updateEmployeeMetaData(DefaultTableModel dt, String table) throws SQLException {
		ResultSet rs = metaDal.getEmployeeMetaData(dt, table);
		metaDal.mapMetaArrayVector(rs, dt);
	}

}
