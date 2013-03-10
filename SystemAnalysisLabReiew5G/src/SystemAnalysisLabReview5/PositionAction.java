package SystemAnalysisLabReview5;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

import javax.swing.JOptionPane;


public class PositionAction {

	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private int rowCount = 0;
	private String temp_sql="";
	private boolean dataValid=true;
	private DateFormat dateFormat;
	
	public void insert(String sql,Position Position1){
		//validation of data(1 steps)
		dataValid=true;
		//1.check the Position Id exist or not(correct result:not exist)
		temp_sql="select * from Position where PositionId="+Position1.get_Position_id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//2.check there is any record of Position has the same DeptName(correct result:not exist)
		temp_sql="select * from Position where PositionId not in("+Position1.get_Position_id()
				+") and PosDesc='"+Position1.get_Position_Desc()+"'";
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
	
	
	
	public Position search(String sql){
		Position Position1=new Position();
		try {
			
			ct = new ConnectionDB().getConn();
			sm = ct.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");						
			
			rs=sm.executeQuery(sql);
			
			ct.commit();
			
            //ct.setAutoCommit(true);
            if (rs.next()) {
				
				rowCount =rs.getRow();
				Position1.set_Position_id(rs.getInt(1));
				Position1.set_Position_Desc(rs.getString(2));
				
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
	
	public void delete(String sql,Position Position1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Position Id exist or not(correct result:exist)
		temp_sql="select * from Position where PositionId="+Position1.get_Position_id();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//2.check any record in EmployeeInfo table related to this Position id(correct result:not exist)
		temp_sql="select * from EmployeeInfo where emp_position="+Position1.get_Position_id();
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
	
	public void update(String sql,Position Position1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Position Id exist or not(correct result:exist)
		temp_sql="select * from Position where PositionId="+Position1.get_Position_id();
		ConnectionDB connectionDB=new ConnectionDB();
				
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Position Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}				
		
		//2.check there is any record of Position has the same DeptName(correct result:not exist)
		temp_sql="select * from Position where PositionId not in("+Position1.get_Position_id()
				+") and PosDesc='"+Position1.get_Position_Desc()+"'";
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
