package edu.rutgers.MOST.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReactionsUpdater {

	public void updateReactionRows(ArrayList<Integer> idList, String databaseName) {
		String queryString = "jdbc:sqlite:" + databaseName + ".db";
		
		try{
			Connection conn =
				DriverManager.getConnection(queryString);
			Statement stat = conn.createStatement();

			try {
				stat.executeUpdate("BEGIN TRANSACTION");

				stat.executeUpdate("COMMIT");
			} catch (Exception e) {
				e.printStackTrace();
				stat.executeUpdate("ROLLBACK"); // throw away all updates since BEGIN TRANSACTION
			}

		}catch(SQLException e){

			e.printStackTrace();

		}
		
	}
	
}
