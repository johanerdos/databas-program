package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import databaseConnection.DBConnection;

public class Task2Dal {

	private Connection conn = null;
	private PreparedStatement ps = null;

	private ResultSet runExecuteQuery(String sqlString) throws SQLException {
		conn = DBConnection.getCronusConnection();
		ps = conn.prepareStatement(sqlString);
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	// Hämtar resultsettets kolumnnamn
	public Vector<String> getColumnNames(ResultSet rs) throws SQLException {
		Vector<String> colNames = new Vector<String>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();
		for (int i = 1; i <= col; i++) {
			String name = rsmd.getColumnName(i);
			colNames.add(name);
		}
		return colNames;
	}

	// Skapar lägger in resultsettet i tablen
	public void mapMetaArrayVector(ResultSet rs, DefaultTableModel dt) throws SQLException {
		ArrayList<Vector<String>> list = new ArrayList<Vector<String>>();
		Vector<String> columns = getColumnNames(rs);
		dt.setColumnIdentifiers(columns);
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();

		while (rs.next()) {
			Vector<String> tmp = new Vector<String>();
			for (int i = 1; i <= col; i++) {
				tmp.add(rs.getString(i));
			}
			list.add(tmp);
		}
		for (Vector<String> tmp : list) {
			dt.addRow(tmp);
		}
		ps.close();
		conn.close();
	}

	// 1. hämta Qualification
	public ResultSet getQualification() throws SQLException {
		String sqlString = "SELECT [Employee No_], [Line No_], [Qualification Code], [timestamp], [Employee Status] FROM [CRONUS Sverige AB$Employee Qualification]";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// 2.Hämta relatives
	public ResultSet getRelatives() throws SQLException {
		String sqlString = "SELECT [timestamp], [Relative Code], [First Name], [Last Name], [Birth Date] FROM [CRONUS Sverige AB$Employee Relative]";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// 3.Hämta statistics group
	public ResultSet getStatisticsGroup() throws SQLException {
		String sqlString = "SELECT [timestamp], [Code], [Description] FROM [CRONUS Sverige AB$Employee Statistics Group]";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// 4.Hämta absence
	public ResultSet getAbsence() throws SQLException {
		String sqlString = "SELECT [timestamp], [Entry No_], [From Date], [To Date], [Description] FROM [CRONUS Sverige AB$Employee Absence]";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// 5.Hämta Portal Setup
	public ResultSet getPortalSetup() throws SQLException {
		String sqlString = "SELECT [timestamp], [Search Limit], [Temp_ Key Index], [Temp_ Table No_], [Temp_ Option Value] FROM [CRONUS Sverige AB$Employee Portal Setup]";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// 6.hämta Employee
	public ResultSet getEmployee() throws SQLException {
		String sqlString = "SELECT [timestamp], [No_], [First Name], [Last Name], [Job Title] FROM [CRONUS Sverige AB$Employee]";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

}
