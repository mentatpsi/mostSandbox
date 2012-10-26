package edu.rutgers.MOST.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.rutgers.MOST.config.LocalConfig;
import edu.rutgers.MOST.presentation.GraphicalInterface;
import edu.rutgers.MOST.presentation.GraphicalInterfaceConstants;

public class ReactionsUpdater {

	public void updateReactionRows(ArrayList<Integer> rowList, ArrayList<Integer> reacIdList, String databaseName) {
		String queryString = "jdbc:sqlite:" + databaseName + ".db";
		
		try{
			Connection conn =
				DriverManager.getConnection(queryString);
			Statement stat = conn.createStatement();

			try {
				stat.executeUpdate("BEGIN TRANSACTION");

				for (int i = 0; i < rowList.size(); i++) {
					
					String knockout = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.KO_COLUMN);
					if (knockout.length() == 0) {
						knockout = GraphicalInterfaceConstants.KO_DEFAULT;
					}
					Double fluxValue = GraphicalInterfaceConstants.FLUX_VALUE_DEFAULT;
					if (GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.FLUX_VALUE_COLUMN) != null) {
						try {
							fluxValue = Double.valueOf((String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.FLUX_VALUE_COLUMN));
						}
					    catch ( NumberFormatException nfe ) {
					       System.out.println( "Number format exception" );
					    }				
					} 
					
					//if strings contain ' (single quote), it will not execute insert statement
					//this code escapes ' as '' - sqlite syntax for escaping '
					String reactionAbbreviation = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_ABBREVIATION_COLUMN);
					if (reactionAbbreviation.contains("'")) {
						reactionAbbreviation = reactionAbbreviation.replaceAll("'", "''");
					}
					String reactionName = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_NAME_COLUMN);
					if (reactionName.contains("'")) {
						reactionName = reactionName.replaceAll("'", "''");
					}
					String reactionString = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_STRING_COLUMN);
					if (reactionString.contains("'")) {
						reactionString = reactionString.replaceAll("'", "''");
					}
					
					String reversible = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REVERSIBLE_COLUMN);
					
					Double lowerBound = GraphicalInterfaceConstants.LOWER_BOUND_DEFAULT;
					if (GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.LOWER_BOUND_COLUMN) != null) {
						try {
							lowerBound = Double.valueOf((String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.LOWER_BOUND_COLUMN));
						}
					    catch ( NumberFormatException nfe ) {
					       System.out.println( "Number format exception" );
					    }				
					} 
					Double upperBound = GraphicalInterfaceConstants.UPPER_BOUND_DEFAULT;
					if (GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.UPPER_BOUND_COLUMN) != null) {
						try {
							upperBound = Double.valueOf((String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.UPPER_BOUND_COLUMN));
						}
					    catch ( NumberFormatException nfe ) {
					       System.out.println( "Number format exception" );
					    }				
					} 
					Double objective = GraphicalInterfaceConstants.BIOLOGICAL_OBJECTIVE_DEFAULT;
					if (GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.BIOLOGICAL_OBJECTIVE_COLUMN) != null) {
						try {
							objective = Double.valueOf((String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.BIOLOGICAL_OBJECTIVE_COLUMN));
						}
					    catch ( NumberFormatException nfe ) {
					       System.out.println( "Number format exception" );
					    }				
					} 
					
					String meta1 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META1_COLUMN);
					if (meta1.contains("'")) {
						meta1 = meta1.replaceAll("'", "''");
					}
					String meta2 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META2_COLUMN);
					if (meta2.contains("'")) {
						meta2 = meta2.replaceAll("'", "''");
					}
					String meta3 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META3_COLUMN);
					if (meta3.contains("'")) {
						meta3 = meta3.replaceAll("'", "''");
					}
					String meta4 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META4_COLUMN);
					if (meta4.contains("'")) {
						meta4 = meta4.replaceAll("'", "''");
					}
					String meta5 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META5_COLUMN);
					if (meta5.contains("'")) {
						meta5 = meta5.replaceAll("'", "''");
					}
					String meta6 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META6_COLUMN);
					if (meta6.contains("'")) {
						meta6 = meta6.replaceAll("'", "''");
					}
					String meta7 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META7_COLUMN);
					if (meta7.contains("'")) {
						meta7 = meta7.replaceAll("'", "''");
					}
					String meta8 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META8_COLUMN);
					if (meta8.contains("'")) {
						meta8 = meta8.replaceAll("'", "''");
					}
					String meta9 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META9_COLUMN);
					if (meta9.contains("'")) {
						meta9 = meta9.replaceAll("'", "''");
					}
					String meta10 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META10_COLUMN);
					if (meta10.contains("'")) {
						meta10 = meta10.replaceAll("'", "''");
					}
					String meta11 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META11_COLUMN);
					if (meta11.contains("'")) {
						meta11 = meta11.replaceAll("'", "''");
					}
					String meta12 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META12_COLUMN);
					if (meta12.contains("'")) {
						meta12 = meta12.replaceAll("'", "''");
					}
					String meta13 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META13_COLUMN);
					if (meta13.contains("'")) {
						meta13 = meta13.replaceAll("'", "''");
					}
					String meta14 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META14_COLUMN);
					if (meta14.contains("'")) {
						meta14 = meta14.replaceAll("'", "''");
					}
					String meta15 = (String) GraphicalInterface.reactionsTable.getModel().getValueAt(rowList.get(i), GraphicalInterfaceConstants.REACTION_META15_COLUMN);
					if (meta15.contains("'")) {
						meta15 = meta15.replaceAll("'", "''");
					}
	
					String update = "update reactions set knockout='" + knockout + "', flux_value=" + fluxValue + ", reaction_abbreviation='" + reactionAbbreviation + "', reaction_name='" + reactionName + "', "
					 	+ " reaction_string='" + reactionString + "', reversible='" + reversible + "', lower_bound=" + lowerBound + ", upper_bound=" + upperBound + ", biological_objective=" + objective + ", "
						+ " meta_1='" + meta1 + "', meta_2='" + meta2 + "', meta_3='" + meta3 + "', meta_4='" + meta4 + "', meta_5='" + meta5 + "', "
						+ " meta_6='" + meta6 + "', meta_7='" + meta7 + "', meta_8='" + meta8 + "', meta_9='" + meta9 + "', meta_10='" + meta10 + "', "
						+ " meta_11='" + meta11 + "', meta_12='" + meta12 + "', meta_13='" + meta13 + "', meta_14='" + meta14 + "', meta_15='" + meta15 + "' where id=" + reacIdList.get(i) + ";";
					stat.executeUpdate(update);
				}
				
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
