package SystemAnalysisLabReview5;

import java.sql.*;

public class X_tryCRUDfromDetailsTables {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		// Connect to oracle here:
		// home:
		connecttoOracle("system", "liuliu");
		// school:
		// connecttoOracle("scott", "tiger");
	}

	public static void connecttoOracle(String username, String password) {
		Connection c = null;

		try {
			System.out.println(" **************************************");
			System.out.println(" * CREATION OF TABLES FOR LAB REVIEW 5 * ");
			System.out.println(" **************************************");

			System.out.println(" * Loading the driver *");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//set url of oracle database:
            //  String url = "jdbc:oracle:thin:@ E10818:1521:orcl";
            
           // home url:
               String url = "jdbc:oracle:thin:@192.168.12.2:1521:XE";
        //or:
  			//String url = "jdbc:oracle:thin:@localhost:1521:XE";
  			// school url:
  			 //String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			//
			c = DriverManager.getConnection(url, username, password);

			c.setAutoCommit(true);

			Statement s = c.createStatement();
		/*	System.out.println(" ******** CREATING FACULTY TABLE ********");
			String query = "CREATE TABLE faculty";
			query = query
					+ "(f_id number (5), f_last VARCHAR2 (30), f_first VARCHAR2 (30), "
					+ "CONSTRAINT faculty_f_id_pk PRIMARY KEY (f_id))";

			s.executeUpdate(query);

			System.out
					.println(" ******** INSERTING INTO FACULTY TABLE ********");

			System.out.println(" ******** 1 - Robertson - Myra ********");
			query = "INSERT INTO faculty ";
			query = query + "(f_id, f_last, f_first ) ";
			query = query + "values";
			query = query + "(1, 'Robertson', 'Myra') ";
			s.executeUpdate(query);
			String query2 = " INSERT INTO faculty  (f_id, f_last, f_first )  values (2, 'Robertson2', 'Myra2')";
			s.executeUpdate(query2);*/

			// Begin testing more:
			ResultSet rs = s.executeQuery("select * from emppaydetails");
			/*rs.next();
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getDouble(2));
			rs.next();
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(8));*/
			while(rs.next())
			{
			//rs.next();
			//try a line:
			for(int i=1;i<9;i++)
			{
				System.out.print(rs.getString(i));	
				System.out.print("	");
			}
			System.out.println();
			
			}
			//System.out.println(rs.getDouble("amount"));
			
			// try more than one row of database:

			// end testing more:
			
			
			//drop the tested table:
			//String query3Drop = " drop table FACULTY";
			//s.executeUpdate(query3Drop);

			//end drop.
			c.commit();
			c.setAutoCommit(true);
			c.close();

		} catch (Exception e) {
			try {
				c.rollback();
			} catch (Exception ee) {
				System.out.println("Error !");
			}
			System.out
					.println("Error - Database Management for creating tables () : "
							+ e);
		}

	}

}

///TRY X
