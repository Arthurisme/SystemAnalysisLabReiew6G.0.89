package SystemAnalysisLabReview5;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




public class ConnectionDB {
	private Connection connection = null;
	private String JDBCConnector="";
	private String dbName="";
	private String dbUser="";
	private String dbPIN="";
	private Statement sm = null;
	private ResultSet rs = null;
	
	
	public Connection getConn(){
		//setDBInfo();
		 
	    try { 
	    	 
            Class.forName ("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					 "jdbc:oracle:thin:@192.168.12.2:1521:XE", "system", "liuliu");
			connection.setAutoCommit(false);
		} catch (Exception e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return connection;
 
		}
          
 
		return connection;
	}
	


	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
		}
	
	public void insert(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			//System.out.println("Connection created!");
			
			
			//System.out.println(sql);
			//System.out.println(sm.getClass());
			if(sm.executeUpdate(sql)==1){
				JOptionPane.showMessageDialog(null,"Insertion Compelted!","Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			connection.commit();
			
			//connection.setAutoCommit(true);
			//System.out.println("insertion completed!");
		} catch (Exception e) {
			try{
				connection.rollback();
			}catch(Exception ee){
				System.out.println("DataBase Error!  Data Insertion!");
			}
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insertion Failed","Message", JOptionPane.PLAIN_MESSAGE);
		} finally {
			this.close();
			//System.out.println("Connection closed!");
		}
	}
	
	public void insertForSalary(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			//System.out.println("Connection created!");
			
			
			//System.out.println(sql);
			//System.out.println(sm.getClass());
			if(sm.executeUpdate(sql)==1){
				//JOptionPane.showMessageDialog(null,"Insertion Compelted!","Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			connection.commit();
			
			//connection.setAutoCommit(true);
			//System.out.println("insertion completed!");
		} catch (Exception e) {
			try{
				connection.rollback();
			}catch(Exception ee){
				System.out.println("DataBase Error!  Data Insertion!");
			}
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null,"Insertion Failed","Message", JOptionPane.PLAIN_MESSAGE);
		} finally {
			this.close();
			//System.out.println("Connection closed!");
		}
	}
	
	public void delete(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			//System.out.println("Connection created!");
			
			
			//System.out.println(sql);
			//System.out.println(sm.getClass());
			if(sm.executeUpdate(sql)>0){
				JOptionPane.showMessageDialog(null,"Deletion Compelted!","Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			connection.commit();
			
			//connection.setAutoCommit(true);
			//System.out.println("insertion completed!");
		} catch (Exception e) {
			try{
				connection.rollback();
			}catch(Exception ee){
				System.out.println("DataBase Error!  Data Deletion!");
			}
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Deletion Failed","Message", JOptionPane.PLAIN_MESSAGE);
		} finally {
			this.close();
			//System.out.println("Connection closed!");
		}
	}
	
	public void update(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			//System.out.println("Connection created!");
			
			
			//System.out.println(sql);
			//System.out.println(sm.getClass());
			if(sm.executeUpdate(sql)>0){
				JOptionPane.showMessageDialog(null,"Update Compelted!","Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			connection.commit();
			
			//connection.setAutoCommit(true);
			//System.out.println("insertion completed!");
		} catch (Exception e) {
			try{
				connection.rollback();
			}catch(Exception ee){
				System.out.println("DataBase Error!  Data Update!");
			}
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Update Failed","Message", JOptionPane.PLAIN_MESSAGE);
		} finally {
			this.close();
			//System.out.println("Connection closed!");
		}
	}	
	//return the total number of the records in the resultSet
	public int search(String sql){
		int temp_int=0;
		try {
			
			this.getConn();
			sm = connection.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");
			
			
			
			rs=sm.executeQuery(sql);
			
			connection.commit();
			
            
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				

				
				//System.out.println("-");
				
				while(rs.next()){
					temp_int=rs.getRow();
				}
				
				//System.out.println(temp_int);
				
				
				this.close();
				
			} catch (Exception e) {
				e.printStackTrace();// 打印异常，以便修改
			}
			
			
		}
		
		return temp_int;
		
	}
	
	public void close() { 
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (sm != null) {
				sm.close();
				sm = null;
			} 
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (Exception e) {
			e.printStackTrace();// 打印异常，以便修改
		}
	}




}
