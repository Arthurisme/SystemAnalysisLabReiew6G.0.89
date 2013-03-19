package SystemAnalysisLabReiew6G;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ContEd Student
 */
public class TaxRate {

    public static double ProvincialTax_rate=0.09;
    public static double FederalTax_rate=0.07;
    public static double QPIP_rate=0.0055;
    public static double EI_rate=0.014;
    public static double QPP_rate=0.045;
    public static double UnionFees_rate=0.0165;
    
    private ArrayList<ItemsPay> deductionList=new ArrayList<ItemsPay>();
    private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private ItemsPay currentItemsPay;
    
    public ArrayList<ItemsPay> getDeductionList(){
    	String sql="select * from ItemsPay";
    	
    	try {
			
			ct = new ConnectionDB().getConn();
			sm = ct.createStatement();
			sm.executeQuery("ALTER SESSION SET NLS_language=american");
			
			
			
			rs=sm.executeQuery(sql);
			
			ct.commit();
			
            //ct.setAutoCommit(true);

            
            while(rs.next()){
            	currentItemsPay=new ItemsPay();
            	currentItemsPay.set_ItemPay_No(rs.getInt("ItemPay_No"));
            	currentItemsPay.set_ItemPay_Title(rs.getString("ItemPay_title"));
            	currentItemsPay.set_ItemPay_DeductionPer(rs.getDouble("ItemPay_rate"));
            	deductionList.add(currentItemsPay);
            	
            }
			
		} catch (Exception e) {
			//deductionList=null;
			e.printStackTrace();
		} finally {
			this.close();
			
			
		}
    	
    	return deductionList;
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
