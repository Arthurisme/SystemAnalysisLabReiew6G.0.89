package beta2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

import javax.swing.JOptionPane;


public class QualificationBeanAction {
	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private int rowCount = 0;
	private String temp_sql="";
	private boolean dataValid=true;
	private DateFormat dateFormat;
	
	public void insert(String sql,QualificationBean QualificationBean1){
		//validation of data(1 steps)
		dataValid=true;
		//1.check the Qualification Id exist or not(correct result:not exist)
		temp_sql="select * from Qualification where QualId="+QualificationBean1.getQualificaiton_Id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Qualification Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}		
		//2.check there is any record of Qualification has the same DeptName(correct result:not exist)
		temp_sql="select * from Qualification where QualId not in("+QualificationBean1.getQualificaiton_Id()
				+") and QualDesc='"+QualificationBean1.getQualification_description()+"'";
		connectionDB=new ConnectionDB();
				
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The other record have the same Qualification name!","Message", JOptionPane.PLAIN_MESSAGE);
		}

		

		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.insert(sql);
		}
		
	}
	
	
	
	public QualificationBean search(String sql){
		QualificationBean Qualification1=new QualificationBean();
		try {
			
			ct = new ConnectionDB().getConn();
			sm = ct.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");
			
			
			
			rs=sm.executeQuery(sql);
			
			ct.commit();
			
            //ct.setAutoCommit(true);
            if (rs.next()) {
				
				rowCount =rs.getRow();
				
				Qualification1.setQualificaiton_Id(rs.getInt(1));
				Qualification1.setQualification_description(rs.getString(2));
				
				
				
				
				
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
		
		return Qualification1;
		
	}
	
	public void delete(String sql,QualificationBean QualificationBean1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Qualification Id exist or not(correct result:exist)
		temp_sql="select * from Qualification where QualId="+QualificationBean1.getQualificaiton_Id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Qualification Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//2.check any record in EmployeeInfo table related to this Qualification id(correct result:not exist)
		temp_sql="select * from EmployeeInfo where emp_QualId="+QualificationBean1.getQualificaiton_Id();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"This Qualification Id relates to the records of EmployeeInfo!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.delete(sql);
		}
	}
	
	public void update(String sql,QualificationBean QualificationBean1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Qualification Id exist or not(correct result:exist)
		temp_sql="select * from Qualification where QualId="+QualificationBean1.getQualificaiton_Id();
		ConnectionDB connectionDB=new ConnectionDB();
				
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Qualification Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}				
		
		//2.check there is any record of Qualification has the same DeptName(correct result:not exist)
		temp_sql="select * from Qualification where QualId not in("+QualificationBean1.getQualificaiton_Id()
				+") and QualDesc='"+QualificationBean1.getQualification_description()+"'";
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The other record have the same Qualification name!","Message", JOptionPane.PLAIN_MESSAGE);
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
