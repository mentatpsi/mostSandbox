package edu.rutgers.MOST.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.rutgers.MOST.config.LocalConfig;

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
	
	public void deleteRows(ArrayList<Integer> idList, String databaseName) {

		String queryString = "jdbc:sqlite:" + databaseName + ".db";
		
		try{
			Connection conn =
				DriverManager.getConnection(queryString);
			Statement stat = conn.createStatement();

			try {
				stat.executeUpdate("BEGIN TRANSACTION");

				for (int i = 0; i < idList.size(); i++) {
					String delete = "delete from reactions where id = " + idList.get(i) + ";";
					stat.executeUpdate(delete);
					String rrDelete = "delete from reaction_reactants where reaction_id = " + idList.get(i) + ";";
					stat.executeUpdate(rrDelete);
					String rpDelete = "delete from reaction_products where reaction_id = " + idList.get(i) + ";";
					stat.executeUpdate(rpDelete);
				}
				
				stat.executeUpdate("COMMIT");
			} catch (Exception e) {
				e.printStackTrace();
				stat.executeUpdate("ROLLBACK"); // throw away all updates since BEGIN TRANSACTION
			}

		}catch(SQLException e){

			e.printStackTrace();

		}
		/*
		for (int d = 0; d < deleteAbbreviations.size(); d++) {
			if (LocalConfig.getInstance().getMetaboliteUsedMap().containsKey(deleteAbbreviations.get(d))) {
				int usedCount = (Integer) LocalConfig.getInstance().getMetaboliteUsedMap().get(deleteAbbreviations.get(d));
				if (usedCount > 1) {
					LocalConfig.getInstance().getMetaboliteUsedMap().put(deleteAbbreviations.get(d), new Integer(usedCount + 1));
					System.out.println(deleteAbbreviations.get(d) + " " + LocalConfig.getInstance().getMetaboliteUsedMap().get(deleteAbbreviations.get(d)));									
				} else {
					LocalConfig.getInstance().getMetaboliteUsedMap().remove(deleteAbbreviations.get(d));
				}				
			} 
		}
		System.out.println(LocalConfig.getInstance().getMetaboliteUsedMap());
		*/
		
	}
	
}
