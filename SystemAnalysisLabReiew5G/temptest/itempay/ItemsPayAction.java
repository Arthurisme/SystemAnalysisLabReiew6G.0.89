package itempay;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

import javax.swing.JOptionPane;


public class ItemsPayAction {

	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private int rowCount = 0;
	private String temp_sql="";
	private boolean dataValid=true;
	private DateFormat dateFormat;
	
	public void insert(String sql,ItemsPay ItemsPay1){
		//validation of data(1 steps)
		dataValid=true;
		//1.check the Item Id exist or not(correct result:not exist)
		temp_sql="select * from ItemsPay where ItemPay_No="+ItemsPay1.get_ItemPay_No();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)>0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Item Id exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}		
		

	//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			//System.out.println(sql);
			connectionDB.insert(sql);
		}
		
	}
	
	
	
	public ItemsPay search(String sql){
		ItemsPay Item1=new ItemsPay();
		try {
			
			ct = new ConnectionDB().getConn();
			sm = ct.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");
			
			
			
			rs=sm.executeQuery(sql);
			
			ct.commit();
			
            //ct.setAutoCommit(true);
            if (rs.next()) {
				
				rowCount =rs.getRow();
				
				Item1.set_ItemPay_No(rs.getInt(1));
				Item1.set_ItemPay_Title(rs.getString(2));
				Item1.set_ItemPay_DeductionPer(rs.getDouble(3));
	
				
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
		
		return Item1;
		
	}
	
	public void delete(String sql,ItemsPay ItemsPay1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Item Id exist or not(correct result:exist)
		temp_sql="select * from ItemsPay where ItemPay_No="+ItemsPay1.get_ItemPay_No();
		ConnectionDB connectionDB=new ConnectionDB();
		
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Item Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
		//2.check any record in EmpPayDetail table related to this Item id(correct result:not exist)
		
		
		
		//insert the data into the database
		if(dataValid){
			connectionDB=new ConnectionDB();
			connectionDB.delete(sql);
		}
	}
	
	public void update(String sql,ItemsPay ItemsPay1){
		//validation of data(5 steps)
		dataValid=true;
		//1.check the Item Id exist or not(correct result:exist)
		temp_sql="select * from ItemsPay where ItemPay_No="+ItemsPay1.get_ItemPay_No();
		ConnectionDB connectionDB=new ConnectionDB();
				
		if(connectionDB.search(temp_sql)==0){
			dataValid=false;
			JOptionPane.showMessageDialog(null,"Item Id does not exist!","Message", JOptionPane.PLAIN_MESSAGE);
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
