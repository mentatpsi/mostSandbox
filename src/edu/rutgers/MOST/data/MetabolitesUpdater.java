package edu.rutgers.MOST.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.rutgers.MOST.config.LocalConfig;
import edu.rutgers.MOST.presentation.GraphicalInterface;
import edu.rutgers.MOST.presentation.GraphicalInterfaceConstants;

public class MetabolitesUpdater {

	public void updateMetaboliteRows(ArrayList<Integer> idList, String databaseName) {
		String queryString = "jdbc:sqlite:" + databaseName + ".db";
		
		try{
			Connection conn =
				DriverManager.getConnection(queryString);
			Statement stat = conn.createStatement();

			try {
				stat.executeUpdate("BEGIN TRANSACTION");

				for (int i = 0; i < idList.size(); i++) {
					
					//if strings contain ' (single quote), it will not execute insert statement
					//this code escapes ' as '' - sqlite syntax for escaping '
					String metaboliteAbbreviation = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_ABBREVIATION_COLUMN);
					if (metaboliteAbbreviation.contains("'")) {
						metaboliteAbbreviation = metaboliteAbbreviation.replaceAll("'", "''");
					}
					String metaboliteName = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_NAME_COLUMN);
					if (metaboliteName.contains("'")) {
						metaboliteName = metaboliteName.replaceAll("'", "''");
					}
					String charge = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.CHARGE_COLUMN);
					String compartment = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.COMPARTMENT_COLUMN);
					if (compartment.contains("'")) {
						compartment = compartment.replaceAll("'", "''");
					}
					String boundary = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.BOUNDARY_COLUMN);
					String meta1 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta1.contains("'")) {
						meta1 = meta1.replaceAll("'", "''");
					}
					String meta2 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta2.contains("'")) {
						meta2 = meta2.replaceAll("'", "''");
					}
					String meta3 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta3.contains("'")) {
						meta3 = meta3.replaceAll("'", "''");
					}
					String meta4 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta4.contains("'")) {
						meta4 = meta4.replaceAll("'", "''");
					}
					String meta5 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta5.contains("'")) {
						meta5 = meta5.replaceAll("'", "''");
					}
					String meta6 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta6.contains("'")) {
						meta6 = meta6.replaceAll("'", "''");
					}
					String meta7 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta7.contains("'")) {
						meta7 = meta7.replaceAll("'", "''");
					}
					String meta8 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta8.contains("'")) {
						meta8 = meta8.replaceAll("'", "''");
					}
					String meta9 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta9.contains("'")) {
						meta9 = meta9.replaceAll("'", "''");
					}
					String meta10 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta10.contains("'")) {
						meta10 = meta10.replaceAll("'", "''");
					}
					String meta11 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta11.contains("'")) {
						meta11 = meta11.replaceAll("'", "''");
					}
					String meta12 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta12.contains("'")) {
						meta12 = meta12.replaceAll("'", "''");
					}
					String meta13 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta13.contains("'")) {
						meta13 = meta13.replaceAll("'", "''");
					}
					String meta14 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta14.contains("'")) {
						meta14 = meta14.replaceAll("'", "''");
					}
					String meta15 = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.METABOLITE_META1_COLUMN);
					if (meta15.contains("'")) {
						meta15 = meta15.replaceAll("'", "''");
					}
					String used = (String) GraphicalInterface.metabolitesTable.getModel().getValueAt(idList.get(i), GraphicalInterfaceConstants.USED_COLUMN);
					
					String update = "update metabolites set metabolite_abbreviation='" + metaboliteAbbreviation + "', metabolite_name='" + metaboliteName + "', charge='" + charge + "', " 
						+ " compartment='" + compartment + "', boundary='" + boundary + "', meta_1='" + meta1 + "', meta_2='" + meta2 + "', meta_3='" + meta3 + "', meta_4='" + meta4 + "', meta_5='" + meta5 + "', "
						+ " meta_6='" + meta6 + "', meta_7='" + meta7 + "', meta_8='" + meta8 + "', meta_9='" + meta9 + "', meta_10='" + meta10 + "', "
						+ " meta_11='" + meta11 + "', meta_12='" + meta12 + "', meta_13='" + meta13 + "', meta_14='" + meta14 + "', meta_15='" + meta15 + "', used='" + used + "' where id=" + (idList.get(i) + 1) + ";";
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
	
}
