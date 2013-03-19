package SystemAnalysisLabReiew6G;
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
	 
 
	private Statement sm = null;
	private ResultSet rs = null;
	
	
	public Connection getConn(){
		//setDBInfo();
		 
	    try { 
	    	 
            Class.forName ("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					 "jdbc:oracle:thin:@192.168.12.23:1521:XE", "system", "liuliu");
			connection.setAutoCommit(false);
		} catch (Exception e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return connection;
 
		}
          
 
		return connection;
	}
	


	 
	
	public void insert(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			 
			if(sm.executeUpdate(sql)==1){
				JOptionPane.showMessageDialog(null,"Insertion Compelted!","Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			connection.commit();
			 
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
 		}
	}
	
	public void insertForSalary(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			 
			if(sm.executeUpdate(sql)==1){
 			}
			
			connection.commit();
			
		 
		} catch (Exception e) {
			try{
				connection.rollback();
			}catch(Exception ee){
				System.out.println("DataBase Error!  Data Insertion!");
			}
			e.printStackTrace();
 		} finally {
			this.close();
 		}
	}
	
	public void delete(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			 
			if(sm.executeUpdate(sql)>0){
				JOptionPane.showMessageDialog(null,"Deletion Compelted!","Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			connection.commit();
			
		 
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
 		}
	}
	
	public void update(String sql){
		try {
			this.getConn();
			sm = connection.createStatement();
			 
			if(sm.executeUpdate(sql)>0){
				JOptionPane.showMessageDialog(null,"Update Compelted!","Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			connection.commit();
			
			 
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
				e.printStackTrace();// 
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
			e.printStackTrace();// 
		}
	}




}
