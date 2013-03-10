package beta2;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class DepartmentBeanAction {
	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private int rowCount = 0;
	private String temp_sql="";
	private boolean dataValid=true;
	private DateFormat dateFormat;
	
	public void insert(String sql,DepartmentBean DepartmentBean1){
		//validation of data(1 steps)
		dataValid=true;
		//1.check the Department Id exist or not(correct result:not exist)
		temp_sql="select * from Department where d_id="+DepartmentBean1.getDepartment_id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Department Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}		
		//2.check there is any record of Department has the same DeptName(correct result:not exist)
		temp_sql="select * from Department where d_id not in("+DepartmentBean1.getDepartment_id()
				+") and d_name='"+DepartmentBean1.getDepartment_name()+"'";
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The other record have the same department name!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		

		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.insert(sql);
		}
		
	}
	
	
	
	public DepartmentBean search(String sql){
		DepartmentBean Department1=new DepartmentBean();
		try {
			
			ct = new ConnectionDB().getConn();
			sm = ct.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");
			
			
			
			rs=sm.executeQuery(sql);
			
			ct.commit();
			
            //ct.setAutoCommit(true);
            if (rs.next()) {
				
				rowCount =rs.getRow();
				Department1.setDepartment_id(rs.getInt(1));
				Department1.setDepartment_name(rs.getString(2));
				Department1.setDepartment_location(rs.getString(3));
				
				
				
				
			}
            else{
            	JOptionPane.showMessageDialog(null,"No Record","Message", JOptionPane.PLAIN_MESSAGE);
            }
            //System.out.println(rowCount);
            
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close();
			
			
		}
		
		return Department1;
		
	}
	
	public void delete(String sql,DepartmentBean DepartmentBean1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Department Id exist or not(correct result:exist)
		temp_sql="select * from Department where d_id="+DepartmentBean1.getDepartment_id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Department Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//2.check any record in EmployeeInfo table related to this department id(correct result:not exist)
		temp_sql="select * from EmployeeInfo where d_id="+DepartmentBean1.getDepartment_id();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"This Department Id relates to the records of EmployeeInfo!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.delete(sql);
		}
	}
	
	public void update(String sql,DepartmentBean DepartmentBean1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Department Id exist or not(correct result:exist)
		temp_sql="select * from Department where d_id="+DepartmentBean1.getDepartment_id();
		ConnectionDB connectionDB=new ConnectionDB();
				
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Department Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}		
		
		//2.check there is any record of Department has the same DeptName(correct result:not exist)
		temp_sql="select * from Department where d_id not in("+DepartmentBean1.getDepartment_id()
				+") and d_name='"+DepartmentBean1.getDepartment_name()+"'";
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The other record have the same department name!","Message", JOptionPane.PLAIN_MESSAGE);
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
