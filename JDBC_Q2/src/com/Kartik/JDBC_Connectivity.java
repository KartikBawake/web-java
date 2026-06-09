package com.Kartik;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBC_Connectivity {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try(FileReader fr = new FileReader("src/com/Kartik/Application.properties");){
			
			prop.load(fr);
			
			String url = prop.getProperty("URL");
			String username = prop.getProperty("USERNAME");
			String pass = prop.getProperty("PASSWORD");
		
			try {
				Connection connection = DriverManager.getConnection(url, username, pass);
				Scanner sc = new Scanner(System.in);
				
				createTable(sc, connection);
			}
			catch (Exception e) {
					e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
public static void createTable(Scanner sc, Connection con) throws SQLException {
		
		int maxlen = 40;
		System.out.println("Enter the Table name");
		String tableName = sc.nextLine();
		
		StringBuilder sb = new StringBuilder("CREATE TABLE "+tableName+" ( ");
		
		String colname[] = new String[maxlen];
		String coltype[] = new String[maxlen];
		int col_index = 0;

		boolean loop = true;
		
		while(loop) {
			
			System.out.println("Enter Column Name or (Type 'done' to Exit...)");
			String name = sc.nextLine();
			
			if(name.equalsIgnoreCase("done")) {
				loop = false;
				break;
			}

			colname[col_index] = name;
			
			System.out.println("Choose Column Type: ");
			System.out.println("1) INT(20)");
			System.out.println("2) VARCHAR(50)");
			System.out.println("3) BOOLEAN");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				coltype[col_index] = "INT(20)";
				col_index = col_index + 1;
				break;
			case 2:
				coltype[col_index] = "VARCHAR(50)";
				col_index = col_index + 1;
				break;
			case 3:
				coltype[col_index] = "BOOLEAN";
				col_index = col_index + 1;
				break;
			default:
				System.out.println("Invalid Choice.");
			}
			
		}
		
		for(int i = 0; i<col_index; i++) {
			sb.append(colname[i]);
			sb.append(" ");
			sb.append(coltype[i]);
			sb.append(", ");
		}
		
		System.out.println("Select column to set as Primary Key: ");
		for(int i = 0; i < col_index; i++) {
			System.out.println(i+1 +") "+ colname[i]);
		}
		int choice = sc.nextInt();
		
		String primarykey = "";
		for(int i = 0; i < choice; i++) {
			primarykey = colname[i];
		}
		
		sb.append("PRIMARY KEY ("+ primarykey +") );");
		
		System.out.println(sb);
		String sql = sb.toString();
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.clearParameters();
		ps.executeUpdate();
		
		System.out.println("Table Created...");
		
	}
}
