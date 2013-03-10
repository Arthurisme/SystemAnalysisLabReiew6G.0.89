package beta2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

import javax.swing.JOptionPane;


public class PositionBeanAction {

	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private int rowCount = 0;
	private String temp_sql="";
	private boolean dataValid=true;
	private DateFormat dateFormat;
	
	public void insert(String sql,PositionBean PositionBean1){
		//validation of data(1 steps)
		dataValid=true;
		//1.check the Position Id exist or not(correct result:not exist)
		temp_sql="select * from Position where PositionId="+PositionBean1.getPositionId();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//2.check there is any record of Position has the same DeptName(correct result:not exist)
		temp_sql="select * from Position where PositionId not in("+PositionBean1.getPositionId()
				+") and PosDesc='"+PositionBean1.getPositionDescription()+"'";
		connectionDB=new ConnectionDB();
				
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The other record have the same Position name!","Message", JOptionPane.PLAIN_MESSAGE);
		}
			
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.insert(sql);
		}
		
	}
	
	
	
	public PositionBean search(String sql){
		PositionBean Position1=new PositionBean();
		try {
			
			ct = new ConnectionDB().getConn();
			sm = ct.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");						
			
			rs=sm.executeQuery(sql);
			
			ct.commit();
			
            //ct.setAutoCommit(true);
            if (rs.next()) {
				
				rowCount =rs.getRow();
				Position1.setPositionId(rs.getInt(1));
				Position1.setPositionDescription(rs.getString(2));
				
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
		
		return Position1;
		
	}
	
	public void delete(String sql,PositionBean PositionBean1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Position Id exist or not(correct result:exist)
		temp_sql="select * from Position where PositionId="+PositionBean1.getPositionId();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//2.check any record in EmployeeInfo table related to this Position id(correct result:not exist)
		temp_sql="select * from EmployeeInfo where emp_position="+PositionBean1.getPositionId();
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"This Position Id relates to the records of EmployeeInfo!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.delete(sql);
		}
	}
	
	public void update(String sql,PositionBean PositionBean1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Position Id exist or not(correct result:exist)
		temp_sql="select * from Position where PositionId="+PositionBean1.getPositionId();
		ConnectionDB connectionDB=new ConnectionDB();
				
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}				
		
		//2.check there is any record of Position has the same DeptName(correct result:not exist)
		temp_sql="select * from Position where PositionId not in("+PositionBean1.getPositionId()
				+") and PosDesc='"+PositionBean1.getPositionDescription()+"'";
		connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"The other record have the same Position name!","Message", JOptionPane.PLAIN_MESSAGE);
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
