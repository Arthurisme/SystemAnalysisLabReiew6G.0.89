package beta2;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ContEd Student
 */
public class EmployeeInfo {
    private int Employee_SSN;
    private String Employee_Name;

    public EmployeeInfo(int w_EmployeeSSN,String w_EmployeeName){
        this.Employee_SSN=w_EmployeeSSN;
        this.Employee_Name=w_EmployeeName;
    }

    EmployeeInfo() {
        
    }

    public void set_EmployeeSSN(int w_EmployeeSSN){
        this.Employee_SSN=w_EmployeeSSN;
    }

    public void set_EmployeeName(String w_EmployeeName){
        this.Employee_Name=w_EmployeeName;
    }

    public int get_EmployeeSSN(){
        return this.Employee_SSN;
    }

    public String get_EmployeeName(){
        return this.Employee_Name;
    }
}
