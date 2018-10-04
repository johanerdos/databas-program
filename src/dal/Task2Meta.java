package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import databaseConnection.DBConnection;

public class Task2Meta {

	private Connection conn = null;
	private PreparedStatement ps = null;

	private ResultSet runExecuteQuery(String sqlString) throws SQLException {
		conn = DBConnection.getCronusConnection();
		ps = conn.prepareStatement(sqlString);
		ResultSet rs = ps.executeQuery();

		return rs;
	}
	//hämtar metadatan från employee 
	public ResultSet getEmployeeMetaData(DefaultTableModel dtm, String table) throws SQLException {
		String sqlString = "SELECT [TABLE_CATALOG], [TABLE_SCHEMA], [TABLE_NAME],[ORDINAL_POSITION],[DATA_TYPE] FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee "
				+ table + "'";
		ResultSet rs = runExecuteQuery(sqlString);
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

	// ArrayList<Vector<String>>
	public void mapMetaArrayVector(ResultSet rs, DefaultTableModel dtm) throws SQLException {
		ArrayList<Vector<String>> list = new ArrayList<Vector<String>>();
		Vector<String> columns = getColumnNames(rs);
		dtm.setColumnIdentifiers(columns);
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
			dtm.addRow(tmp);
		}
		ps.close();
		conn.close();
	}

	// HÄMTA ALLA KOLUMNER 1
	public ResultSet getColumns() throws SQLException {
		String sqlString = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'CRONUS Sverige AB$Employee'";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;

	}

	// HÄMTA KOLUMNER 2
	public ResultSet getColumnsTwo() throws SQLException {
		String sqlString = "SELECT * FROM sys.columns WHERE object_id = object_id('CRONUS Sverige AB$Employee')";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// HÄMTA ALLA INDEX
	public ResultSet getIndex() throws SQLException {
		String sqlString = "SELECT * FROM sys.indexes";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// HÄMTA ALLA TABLES 1
	public ResultSet getTables() throws SQLException {
		String sqlString = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// HÄMTA ALLA TABLES 2
	public ResultSet getTablesTwo() throws SQLException {
		String sqlString = "SELECT * FROM sys.tables";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// HÄMTA ALLA CONSTRAINTS
	public ResultSet getConstraints() throws SQLException {
		String sqlString = "SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// HÄMTA TABELLNAMN FRÅN TABELL MED FLEST RADER
	public ResultSet getTableNameMostRows() throws SQLException {
		String sqlString = "SELECT TOP 1 [TableName] = so.name, [RowCount] = MAX(si.rows) FROM sysobjects so, sysindexes si WHERE so.xtype = 'U' AND si.id = object_id(so.name) GROUP BY so.name ORDER BY 2 DESC;";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}

	// HÄMTAR ALLA NYCKLAR
	public ResultSet getAllKeys() throws SQLException {
		String sqlString = "SELECT * FROM sys.key_constraints";
		ResultSet rs = runExecuteQuery(sqlString);
		return rs;
	}
}
