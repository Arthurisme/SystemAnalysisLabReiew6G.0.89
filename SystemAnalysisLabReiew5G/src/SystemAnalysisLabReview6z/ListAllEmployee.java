package SystemAnalysisLabReview6z;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ListAllEmployee extends JFrame {

	private JPanel contentPane;
	static JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 ListAllEmployee frame = new ListAllEmployee();
					 frame.setVisible(true);
					
					//home:
					//connecttoOracle("system", "liuliu");
					//school:
					//connecttoOracle("scott", "tiger");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public ListAllEmployee() throws FileNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.add(textArea);
		
		//JTextArea textArea = new JTextArea();
		//contentPane.add(textArea);
		//textArea.setBounds(10, 69, 462, 398);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
		//String testTexarea= "this";
		
		//textArea.read(new FileReader("EmpPayDetail.out"), null);
		//textArea.append(testTexarea);
		
		connecttoOracle("system", "liuliu");
		
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
               String url = "jdbc:oracle:thin:@192.168.12.23:1521:XE";
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
			ResultSet rs = s.executeQuery("select * from EMPLOYEEINFO");
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
				//test
				System.out.print(rs.getString(i));	
				System.out.print("	");
				
				textArea.append(rs.getString(i));
				textArea.append("	");
				}
			System.out.println();
			textArea.append("\n");
			
			}
			//System.out.println(rs.getDouble("amount"));
			
			// try more than one row of database:

			// end testing more:
			
			
			//drop the tested table:
			//String query3Drop = " drop table FACULTY";
			//s.executeUpdate(query3Drop);

			//end drop.
			
			//try write to the textarea:
			//String testTexarea= "this2";
			
			//textArea.read(new FileReader("EmpPayDetail.out"), null);
			//textArea.append(testTexarea);
			//
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

	}//end read from database

}
