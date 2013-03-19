package SystemAnalysisLabReiew6G;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 *
 * @author ContEd Student
 */
public class EmployeeSalaryPayDetails {

    private int Salary_ID;
    private Employee Employee1=new Employee();
    private double Number_workedHour;
    private double Hourly_rate;
    private double Total_income;
    private double Net_income;
    private double Deductions;
    private double FedTax_Deduction;
    private double ProvincalTax_Deduction;
    private double QPIP_Deduction;
    private double EI_Deduction;
    private double QPP_Deduction;
    private double UnionFee_Deduction;
    private ArrayList<ItemsPay> deductionList;
    private boolean dataValid;
    private String temp_sql,sql;
    private ConnectionDB connectionDB;
    private int pay_month,pay_year;

    
    public ArrayList<ItemsPay> getDeductionList(){
    	return deductionList;
    }
    
    public void set_EmployeeInfo(Employee Employee2){
    	this.Employee1=Employee2;
    }
    
   

    public void set_HourlyRate(double w_HourlyRate){
        this.Hourly_rate=w_HourlyRate;
    }

    public void set_NumberWorkedHour(double w_NumberWorkedHour){
        this.Number_workedHour=w_NumberWorkedHour;
    }
    
    public void CalculateDeductions(){
/*        this.FedTax_Deduction=this.Total_income*TaxRate.FederalTax_rate;
        this.ProvincalTax_Deduction=this.Total_income*TaxRate.ProvincialTax_rate;
        this.QPIP_Deduction=this.Total_income*TaxRate.QPIP_rate;
        this.EI_Deduction=this.Total_income*TaxRate.EI_rate;
        this.UnionFee_Deduction=this.Total_income*TaxRate.UnionFees_rate;
        this.QPP_Deduction=this.Total_income*TaxRate.QPP_rate;*/
        
        deductionList=new ArrayList<ItemsPay>();
        deductionList=new TaxRate().getDeductionList();
        double total_deductionRate=0;
        double current_deductionRate=0;
        
        //calculate the deduction amount
        for(int i=0;i<deductionList.size();i++){
        	current_deductionRate=deductionList.get(i).get_ItemPay_DeductionPer();
        	if(deductionList.get(i).get_ItemPay_No()==100 || deductionList.get(i).get_ItemPay_No()==101){
        		if(deductionList.get(i).get_ItemPay_No()==100){
        			deductionList.get(i).setItemPay_amount(this.Total_income);
        		}
        	}else{
        		deductionList.get(i).setItemPay_amount(this.Total_income*current_deductionRate);
        	}
        	
        	total_deductionRate=total_deductionRate+current_deductionRate;
        }

        
        

        this.Deductions=this.Total_income*total_deductionRate;
        
    }
    
    public void CalculateTotalIncome(){
        this.Total_income=this.Hourly_rate*this.Number_workedHour;
    }

    public void CalculateNetIncome(){//read and insert into database
        this.CalculateTotalIncome();
        this.CalculateDeductions();
        this.Net_income=this.Total_income-this.Deductions;
        for(int i=0;i<deductionList.size();i++){
        	
        	if(deductionList.get(i).get_ItemPay_No()==101){
        		deductionList.get(i).setItemPay_amount(this.Net_income);    		
        	}
        	
        }
        //insert into the DataBase
        Date date =new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        pay_year = cal.get(Calendar.YEAR);
        pay_month = cal.get(Calendar.MONTH)+1;
        
        for(int i=0;i<deductionList.size();i++){
        //data validation
        //check the same record exist in the table of EmpPayDetail(correct: not exist)	
        	dataValid=true;
    		//1.check the Position Id exist or not(correct result:not exist)
    		temp_sql="select * from EmpPayDetails where EmployeeId="+this.Employee1.get_Employee_id()
    				+"and ItemPay_No="+deductionList.get(i).get_ItemPay_No()
    				+"and pay_month="+pay_month+" and pay_year="+pay_year;
    		connectionDB=new ConnectionDB();
    		
    		if(connectionDB.search(temp_sql)>0){
    			dataValid=false;
    			System.out.println("The record exist!(Insertion into EmpPayDetails)");
    		}
    		sql="insert into EmpPayDetails values("+this.Employee1.get_Employee_id()
    				+","+deductionList.get(i).get_ItemPay_No()
    				+","+this.Number_workedHour
    				+","+this.Hourly_rate
    				+","+deductionList.get(i).get_ItemPay_DeductionPer()
    				+","+deductionList.get(i).getItemPay_amount()
    				+","+pay_month+","+pay_year+")";
    		
    		//insert the data into the database
    		if(dataValid){
    			connectionDB=new ConnectionDB();
    			connectionDB.insertForSalary(sql);
    		}	
        //insert the data	
        }
    }

    public double get_TotalIncome(){
        return this.get_2DecimalPlaces(this.Total_income);
    }

    public double get_NetIncome(){
        return this.get_2DecimalPlaces(this.Net_income);
    }

    public double get_FedTaxDeduction(){
        return this.get_2DecimalPlaces(this.FedTax_Deduction);
    }

    public double get_ProvicalTaxDeduction(){
        return this.get_2DecimalPlaces(this.ProvincalTax_Deduction);
    }

    public double get_QppDeduction(){
        return this.get_2DecimalPlaces(this.QPP_Deduction);
    }

    public double get_QpipDeduction(){
        return this.get_2DecimalPlaces(this.QPIP_Deduction);
    }

    public double get_EI_Deduction(){
        return this.get_2DecimalPlaces(this.EI_Deduction);
    }

    public double get_UnionFee_Deduction(){
        return this.get_2DecimalPlaces(this.UnionFee_Deduction);
    }

    public double get_TotalDeduction(){
        return this.get_2DecimalPlaces(this.Deductions);
    }

    public double get_2DecimalPlaces(double d1){
        BigDecimal a = new BigDecimal(d1);
        //.out.println(d1);
        //System.out.println("a.setScale(2,2)=" + a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

        return a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        
    }

}
