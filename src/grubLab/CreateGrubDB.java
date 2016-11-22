package grubLab;
import java.sql.*;
public class CreateGrubDB {
	public static void main(String[] args) throws Exception{

		final String DB_URL = "jdbc:hsqldb:file:GrubDB/grub";

		try {
			Connection conn = DriverManager.getConnection(DB_URL);

			dropTables(conn);

			buildGrubTable(conn);

			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	public static void dropTables(Connection conn) {
		System.out.println("Checking for existing tables.");

		try {
			Statement stmt = conn.createStatement();
			;

			try {
				stmt.execute("DROP TABLE Grub");
				System.out.println("Grub table dropped.");
			} catch (SQLException ex) {
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void buildGrubTable(Connection conn) {
		try {
			Statement stmt = conn.createStatement();

			stmt.execute("CREATE TABLE Grub (" + 
						"Restaurant CHAR(25), " + 
						"Type CHAR(10), " +
						"Dish CHAR(25), " + 
						"Price DOUBLE, " + 
						"Calories DOUBLE, " + 
						"ID int NOT NULL PRIMARY KEY" +
						")");


			stmt.execute("INSERT INTO Grub VALUES ( " + "'Olive Garden', " + "'Italian', " + "'Stuffed Mushrooms', " + "7.79, " + "380,1 )");

			stmt.execute("INSERT INTO Grub VALUES ( " + "'Denny''s', " + "'American', " + "'Pot Roast Melt', " + "6.99, " + "710,2 )");

			stmt.execute("INSERT INTO Grub VALUES ( " + "'Taco Bell', " + "'Mexican', " + "'Steakhouse Burrito', " + "5.79, " + "1020,3 )");

			stmt.execute("INSERT INTO Grub VALUES ( " + "'Forbidden City', " + "'Chinese', " + "'Lemon Chicken', " + "8.95, " + "670,4 )");

			stmt.execute("INSERT INTO Grub VALUES ( " + "'Olive Garden', " + "'Italian', " + "'Fried Mozzarella', " + "5.99, " + "860,5 )");

			

			System.out.println("GRUB table created.");
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}
