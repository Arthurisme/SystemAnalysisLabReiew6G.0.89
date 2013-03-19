package SystemAnalysisLabReiew6G;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class EmployeeAction {
	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private int rowCount = 0;
	private String temp_sql="";
	private boolean dataValid=true;
	private DateFormat dateFormat;
	
	public void insert(String sql,Employee Employee1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the EmployeeId exist or not(correct result:not exist)
		temp_sql="select * from EmployeeInfo where emp_id="+Employee1.get_Employee_id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Employee Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}		
		
		//2.check the Position id exist or not(correct result:exist)
		temp_sql="select * from Position where PositionId="+Employee1.get_Position_id();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//3.check the Qualification id exist or not(correct result:exist)
		temp_sql="select * from Qualification where QualId="+Employee1.get_Qual_id_of_Employee();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Qualification Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		//4.check the Department Id exist or not(correct result:exist)
		temp_sql="select * from Department where d_id="+Employee1.get_Dep_id_of_Employee();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Department Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		//5.check the HireDate is correct format or not(correct result(DD-MM-YYYY))
		try{
			
			dateFormat= new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			dateFormat.parse(Employee1.get_HireDate());
		}catch(Exception e){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The format of HireDate is not correct!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.insert(sql);
		}
		
	}
	
	
	
	public Employee search(String sql){
		Employee eI1=new Employee();
		try {
			
			ct = new ConnectionDB().getConn();
			sm = ct.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");
			
			
			
			rs=sm.executeQuery(sql);
			
			ct.commit();
			
            //ct.setAutoCommit(true);
            if (rs.next()) {
				
				rowCount =rs.getRow();
				eI1.set_Employee_id(rs.getInt(1));
				eI1.set_Employee_Fname(rs.getString(2));
				eI1.set_Employee_Lname(rs.getString(3));
				eI1.Set_SSN(rs.getString(4));
				eI1.set_Position_id(rs.getInt(5));
				//System.out.println(rs.getDate(6).toGMTString());
				dateFormat= new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);				
				String dateString= dateFormat.format(rs.getDate(6));
				eI1.set_HireDate(dateString);
				eI1.set_Qual_id_of_Employee(rs.getInt(7));
				eI1.set_Dep_id_of_Employee(rs.getInt(8));
				
				
				
			}
            else{
            	eI1=null;
            	JOptionPane.showMessageDialog(null,"No Record","Message", JOptionPane.PLAIN_MESSAGE);
            }
            //System.out.println(rowCount);
            
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close();
			
			
		}
		
		return eI1;
		
	}
	
	public void delete(String sql,Employee Employee1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the EmployeeId exist or not(correct result:exist)
		temp_sql="select * from EmployeeInfo where emp_id="+Employee1.get_Employee_id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Employee Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}		
		
		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.delete(sql);
		}
	}
	
	public void update(String sql,Employee Employee1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the EmployeeId exist or not(correct result: exist)
		temp_sql="select * from EmployeeInfo where emp_id="+Employee1.get_Employee_id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)<1){
			
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Employee Id  does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}		
		
		//2.check the Position id exist or not(correct result:exist)
		temp_sql="select * from Position where PositionId="+Employee1.get_Position_id();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//3.check the Qualification id exist or not(correct result:exist)
		temp_sql="select * from Qualification where QualId="+Employee1.get_Qual_id_of_Employee();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Qualification Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		//4.check the Department Id exist or not(correct result:exist)
		temp_sql="select * from Department where d_id="+Employee1.get_Dep_id_of_Employee();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Department Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		//5.check the HireDate is correct format or not(correct result(DD-MM-YYYY))
		try{
			
			dateFormat= new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			dateFormat.parse(Employee1.get_HireDate());
		}catch(Exception e){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The format of HireDate is not correct!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.update(sql);
		}
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
			if (ct != null) {
				ct.close();
				ct = null;
			}
		} catch (Exception e) {
			e.printStackTrace();// 打印异常，以便修改
		}
	}
}
