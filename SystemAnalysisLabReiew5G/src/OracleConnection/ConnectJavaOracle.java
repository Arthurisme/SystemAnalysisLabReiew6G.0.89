package OracleConnection;

import java.sql.*;

public class ConnectJavaOracle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connect to oracle here:
		//home:
				 ConnecttoOracle("system", "liuliu");
		//school:
		//ConnecttoOracle("scott", "tiger");
	}

	public static void ConnecttoOracle(String username, String password) {
		// Declare a null Connection:
		Connection c = null;

		try {// try begin:
			System.out.println("  ********************************  ");
			System.out.println("  CREATION OF TABLES FOR LAB REVIEW 5  ");
			System.out.println("  ********************************  ");

			System.out.println("* Loading the driver  *");

			// declare the connection:
			// Set driver name:
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// home url:
			String url = "jdbc:oracle:thin:@localhost:1521:XM";
			// school url:
			// String url = "jdbc:oracle:thin:@ E10818:1521:orcl";

			c = DriverManager.getConnection(url, username, password);

			// what is means of this line, i need to ask:##__##__1
			c.setAutoCommit(true);

			// declare a stactement s from Connection c:
			Statement s = c.createStatement();
			System.out.println("****** Creating Faculty table  ******");
			String query = "CREATE TABLE faculty";
			query = query
					+ "(f_id number (5), f_last VARCHAR2 (30), f_first VARCHAR2 (30), "
					+ "CONSTRAINT faculty_f_id_pk PRIMARY KEY (f_id))";
			// execute query:
			s.executeUpdate(query);

			System.out.println("****** inserting into Faculty table  ******");
			System.out.println("******  1  -   Roberton - Myra  ******");
			System.out.println(" ******** 1 - Robertson - Myra ********");
			query = "INSERT INTO faculty ";
			query = query + "(f_id, f_last, f_first ) ";
			query = query + "values";
			query = query + "(1, 'Robertson', 'Myra') ";
			s.executeUpdate(query);
			c.commit();
			c.setAutoCommit(true);
			c.close();

		}// try end.
		catch (Exception e) {

			try {
				c.rollback();
			}

			catch (Exception ee) {

				System.out.println("Error !");
			}
			System.out
					.println("Error - Database Management for creating tables () : "
							+ e);
		}

		 
	}

}
