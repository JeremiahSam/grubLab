package grubLab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInputGrub {
	public static void main(String[] args) throws SQLException{
		
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Give me a restaurant:");
	String rest = keyboard.nextLine();
	System.out.println("Give me a type:");
	String type = keyboard.nextLine();
	System.out.println("Give me a dish:");
	String dish = keyboard.nextLine();
	System.out.println("Give me a price:");
	String price = keyboard.nextLine();
	System.out.println("Give me a calories:");
	String cal = keyboard.nextLine();
	
	final String DB_URL = "jdbc:hsqldb:file:GrubDB/grub";
	
	Connection conn = DriverManager.getConnection(DB_URL);
	

	String sql = "INSERT INTO GRUB"
				 + " (Restaurant,Type,Dish,Price,Calories)"
				 + " VALUES "
				 + " (?, ?, ?, ?, ?);";
	
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	stmt.setString(1, rest);
	stmt.setString(2, type);
	stmt.setString(3, dish);
	stmt.setDouble(4, Double.parseDouble(price));
	stmt.setString(5, cal);
	stmt.executeUpdate();
	
	conn.close();
	
	System.out.println("Inserted Grub!");

	}
}