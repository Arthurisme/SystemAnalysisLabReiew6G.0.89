package SystemAnalysisLabReview5;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ContEd Student
 */
public class OutputPayStubForm extends JFrame implements
        ActionListener{

    /**
     * @param args the command line arguments
     */
	
	private static OutputPayStubForm theDia1Output;
    private JLabel EmployeeIdL,EmployeeLastNameL,EmployeeFirstNameL, EmployeeSSNL, NumberWorkedHourL, HourlyRateL, TotalIncomeL, NetIncomeL
    				,EmployeePositionIdL,EmployeeQualificationIdL,EmployeeDepartmentIdL,EmployeeHireDateL;
    

    private JTextField EmployeeLastNameTF,EmployeeFirstNameTF,EmployeeSSNTF,NumberWorkedHourTF,HourlyRateTF,TotalIncomeTF,NetIncomeTF,EmployeeIdTF
    				,EmployeePositionIdTF,EmployeeQualificationIdTF,EmployeeDepartmentIdTF,EmployeeHireDateTF;

    private JButton calculateB, exitB;

    private calculateButtonHandler calculateHandler;
    private ExitButtonHandler ebHandler;

    private JMenuBar menuMB =
            new JMenuBar(); //create the menu bar
    EmployeeSalaryPayDetails salary=new EmployeeSalaryPayDetails();

    java.text.DecimalFormat decimal2Places_format=new java.text.DecimalFormat("0.00");

    private static final int WIDTH =600;
    private static final int HEIGHT = 600;
    private String sql="",temp;
    private JButton btnOutputpaystub;

    public OutputPayStubForm(){
//        double d5=19.00;
//        System.out.println(String.format("%.2f",d5));
//        BigDecimal a = new BigDecimal(19.5001);
//        double t1=a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println("a.setScale(2,2)=" + a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
//        java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.00");
//        System.out.println("a.setScale(2,2)=" + myformat.format(t1));
    	EmployeeIdL = new JLabel("Enter Employee's ID: ",SwingConstants.RIGHT);
    	EmployeeIdL.setBounds(0, 0, 292, 41);
    	EmployeeFirstNameL = new JLabel("Enter Employee's First Name: ",SwingConstants.RIGHT);
    	EmployeeFirstNameL.setBounds(0, 41, 292, 41);
    	EmployeeLastNameL = new JLabel("Enter Employee's Last Name: ",SwingConstants.RIGHT);
    	EmployeeLastNameL.setBounds(0, 82, 292, 41);
        EmployeeSSNL = new JLabel("Enter Employee's SSN: ",SwingConstants.RIGHT);
        EmployeeSSNL.setBounds(0, 123, 292, 41);
        EmployeePositionIdL= new JLabel("Enter Employee's Position ID: ",SwingConstants.RIGHT);
        EmployeePositionIdL.setBounds(0, 164, 292, 41);
        EmployeeQualificationIdL= new JLabel("Enter Employee's Qualification Id: ",SwingConstants.RIGHT);
        EmployeeQualificationIdL.setBounds(0, 205, 292, 41);
        EmployeeDepartmentIdL= new JLabel("Enter Employee's Department ID: ",SwingConstants.RIGHT);
        EmployeeDepartmentIdL.setBounds(0, 246, 292, 41);
        EmployeeHireDateL=new JLabel("Enter Employee's Hire Date: ",SwingConstants.RIGHT);
        EmployeeHireDateL.setBounds(0, 287, 292, 41);
        NumberWorkedHourL = new JLabel("Enter Number of Worked Hour: ",SwingConstants.RIGHT);
        NumberWorkedHourL.setBounds(0, 328, 292, 41);
        HourlyRateL = new JLabel("Enter the Rate Hour: ",SwingConstants.RIGHT);
        HourlyRateL.setBounds(0, 369, 292, 41);
        TotalIncomeL = new JLabel("Total Income: ",SwingConstants.RIGHT);
        TotalIncomeL.setBounds(0, 410, 292, 41);
        NetIncomeL = new JLabel("Net Amount: ",SwingConstants.RIGHT);
        NetIncomeL.setBounds(0, 451, 292, 41);
        
         //Create the four text fields
        EmployeeIdTF=new JTextField(10);
        EmployeeIdTF.setBounds(292, 0, 292, 41);
        EmployeeIdTF.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) {
        		getEmployeeInfo();
        	}
        });
        EmployeeFirstNameTF = new JTextField(10);
        EmployeeFirstNameTF.setBounds(292, 41, 292, 41);
        EmployeeLastNameTF = new JTextField(10);
        EmployeeLastNameTF.setBounds(292, 82, 292, 41);
        EmployeeSSNTF = new JTextField(10);
        EmployeeSSNTF.setBounds(292, 123, 292, 41);
        EmployeePositionIdTF= new JTextField(10);
        EmployeePositionIdTF.setBounds(292, 164, 292, 41);
        EmployeeQualificationIdTF= new JTextField(10);
        EmployeeQualificationIdTF.setBounds(292, 205, 292, 41);
        EmployeeDepartmentIdTF= new JTextField(10);
        EmployeeDepartmentIdTF.setBounds(292, 246, 292, 41);
        EmployeeHireDateTF=new JTextField(10);
        EmployeeHireDateTF.setBounds(292, 287, 292, 41);
        NumberWorkedHourTF = new JTextField(10);
        NumberWorkedHourTF.setBounds(292, 328, 292, 41);
        HourlyRateTF = new JTextField(10);
        HourlyRateTF.setBounds(292, 369, 292, 41);
        TotalIncomeTF = new JTextField(10);
        TotalIncomeTF.setBounds(292, 410, 292, 41);
        NetIncomeTF = new JTextField(10);
        NetIncomeTF.setBounds(292, 451, 292, 41);

       
        setJMenuBar(menuMB);
        setInputDataMenu();
        setOutputDataMenu();


             //Create Calculate Button
        calculateB = new JButton("Calculate");
        calculateB.setBounds(0, 492, 22, 41);
        calculateHandler = new calculateButtonHandler();
        calculateB.addActionListener(calculateHandler);

             //Create Exit Button
        exitB = new JButton("Exit");
        exitB.setBounds(292, 492, 195, 41);
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);

             //Set the title of the window
        setTitle("Pay Roll Application");

                 //Get the container
        Container pane = getContentPane();
        
      getContentPane().setLayout(null);

             //Place the components in the pane
      pane.add(EmployeeIdL);
      pane.add(EmployeeIdTF);
      pane.add(EmployeeFirstNameL);
      pane.add(EmployeeFirstNameTF);
      pane.add(EmployeeLastNameL);
      pane.add(EmployeeLastNameTF);
      pane.add(EmployeeSSNL);
      pane.add(EmployeeSSNTF);
      pane.add(EmployeePositionIdL);
      pane.add(EmployeePositionIdTF);
      pane.add(EmployeeQualificationIdL);
      pane.add(EmployeeQualificationIdTF);
      pane.add(EmployeeDepartmentIdL);
      pane.add(EmployeeDepartmentIdTF);
      pane.add(EmployeeHireDateL);
      pane.add(EmployeeHireDateTF);
      pane.add(NumberWorkedHourL);
      pane.add(NumberWorkedHourTF);
      pane.add(HourlyRateL);
      pane.add(HourlyRateTF);
      pane.add(TotalIncomeL);
      pane.add(TotalIncomeTF);
      pane.add(NetIncomeL);
      pane.add(NetIncomeTF);
      pane.add(calculateB);
      pane.add(exitB);
      
      JButton CalcFromDatebaseB = new JButton("Calculate");
      CalcFromDatebaseB.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		//This is calculator form database:

            

            try{
               //create a instance of Employee
           	Employee Employee1b=new Employee();
           	Employee1b.set_Employee_id(Integer.parseInt(EmployeeIdTF.getText().trim()));
           	Employee1b.set_Employee_Fname(EmployeeFirstNameTF.getText());
           	Employee1b.set_Employee_Lname(EmployeeLastNameTF.getText());
           	Employee1b.Set_SSN(EmployeeSSNTF.getText());
           	Employee1b.set_Position_id(Integer.parseInt(EmployeePositionIdTF.getText()));
           	Employee1b.set_Qual_id_of_Employee(Integer.parseInt(EmployeeQualificationIdTF.getText()));
           	Employee1b.set_Dep_id_of_Employee(Integer.parseInt(EmployeeDepartmentIdTF.getText()));
           	Employee1b.set_HireDate(EmployeeHireDateTF.getText());
           	
               salary.set_EmployeeInfo(Employee1b);
               salary.set_HourlyRate(Double.parseDouble(HourlyRateTF.getText()));
               salary.set_NumberWorkedHour(Double.parseDouble(NumberWorkedHourTF.getText()));
               //read and write from database:
               salary.CalculateNetIncome();// database written.
               
               //read from class, not from database:
               TotalIncomeTF.setText(""+salary.get_TotalIncome()+"$");
               NetIncomeTF.setText(""+salary.get_NetIncome()+"$");
               
               
            }catch(NumberFormatException e1){
                System.out.println("You input the wrong data!");
            }
            
            
            
         //end calculator
      		
      		
      	}
      });
      CalcFromDatebaseB.setBounds(32, 492, 92, 41);
      getContentPane().add(CalcFromDatebaseB);
      
      btnOutputpaystub = new JButton("outputPaystub");
      btnOutputpaystub.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnOutputpaystub.setBounds(155, 492, 109, 41);
      getContentPane().add(btnOutputpaystub);

             //Set the size of the window and display it
      setSize(513, 600);
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("OutputPayStub")){
/*            JOptionPane.showMessageDialog(null, "===========================================================\n" +
                    "|      The Total Earning is " +decimal2Places_format.format(salary.get_TotalIncome())  + "$|\n" +
                    "|      The Fed_Tax Deduction is " + decimal2Places_format.format(salary.get_FedTaxDeduction()) + "$|\n" +
                    "|      The Prv_Tax Deduction is " + decimal2Places_format.format(salary.get_ProvicalTaxDeduction()) + "$|\n" +
                    "|      The QP_Ins Deduction is " + decimal2Places_format.format(salary.get_QpipDeduction()) + "$|\n" +
                    "|      The E_Ins deduction is " + decimal2Places_format.format(salary.get_EI_Deduction()) + "$|\n" +
                    "|      The Qpp deduction is " + decimal2Places_format.format(salary.get_QppDeduction()) + "$|\n" +
                    "|      The Union_d deduction is " + decimal2Places_format.format(salary.get_UnionFee_Deduction()) + "$|\n" +
                    "|      The Total deduction is " + decimal2Places_format.format(salary.get_TotalDeduction()) + "$|\n" +
                    "\n" +
                    "|      The Total Net Amount is " + decimal2Places_format.format(salary.get_NetIncome()) + "$\n" +
                    "===========================================================\n",
                    "OutputPayStub", JOptionPane.PLAIN_MESSAGE);*/
        	temp="===========================================================\n";
        	ArrayList<ItemsPay> deductionList=salary.getDeductionList();
        	for(int i=0;i<deductionList.size();i++){
        		temp=temp+"|      "+deductionList.get(i).get_ItemPay_Title()+" is "
        				+decimal2Places_format.format(deductionList.get(i).getItemPay_amount()) + "$|\n";
        	}
        	temp=temp+"|      The Total deduction is " + decimal2Places_format.format(salary.get_TotalDeduction()) + "$|\n";
        	temp=temp+"===========================================================\n";
            JOptionPane.showMessageDialog(null, temp,
                    "OutputPayStub", JOptionPane.PLAIN_MESSAGE);
            
        }
        
        if(e.getActionCommand().equals("Employee")){
        	EmployeeForm eForm1=new EmployeeForm();
        	eForm1.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Department")){
        	DepartmentForm DepartmentForm1=new DepartmentForm();
        	DepartmentForm1.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Qualification")){
        	QualificationForm QualificationForm1=new QualificationForm();
        	QualificationForm1.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Position")){
        	PositionForm PositionForm1=new PositionForm();
        	PositionForm1.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Items Pay")){
        	ItemForm ItemForm1=new ItemForm();
        	ItemForm1.setVisible(true);
        }
      
        
    }

    private void setInputDataMenu() {
    }

    private void setOutputDataMenu() {

    }

    private class calculateButtonHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         

         try{
            //create a instance of Employee
        	Employee Employee1=new Employee();
        	Employee1.set_Employee_id(Integer.parseInt(EmployeeIdTF.getText().trim()));
        	Employee1.set_Employee_Fname(EmployeeFirstNameTF.getText());
        	Employee1.set_Employee_Lname(EmployeeLastNameTF.getText());
        	Employee1.Set_SSN(EmployeeSSNTF.getText());
        	Employee1.set_Position_id(Integer.parseInt(EmployeePositionIdTF.getText()));
        	Employee1.set_Qual_id_of_Employee(Integer.parseInt(EmployeeQualificationIdTF.getText()));
        	Employee1.set_Dep_id_of_Employee(Integer.parseInt(EmployeeDepartmentIdTF.getText()));
        	Employee1.set_HireDate(EmployeeHireDateTF.getText());
        	
            salary.set_EmployeeInfo(Employee1);
            salary.set_HourlyRate(Double.parseDouble(HourlyRateTF.getText()));
            salary.set_NumberWorkedHour(Double.parseDouble(NumberWorkedHourTF.getText()));
            salary.CalculateNetIncome();
            TotalIncomeTF.setText(""+salary.get_TotalIncome()+"$");
            NetIncomeTF.setText(""+salary.get_NetIncome()+"$");
            
            
         }catch(NumberFormatException e1){
             System.out.println("You input the wrong data!");
         }
         
         
         
      }
   }

   private class ExitButtonHandler implements ActionListener
   {
        public void actionPerformed(ActionEvent e)
       {
           //System.exit(0);
    	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	  //heListAllEmployeePayStub.
    	   theDia1Output.setVisible(false);
    	   
    	   
    	    
       }
   }

    public static void main(String[] args) {
        // TODO code application logic here

          theDia1Output=new OutputPayStubForm();
        theDia1Output.setVisible(true);
        
    }
    
    public void getEmployeeInfo(){
    	try{
    		if((EmployeeIdTF.getText().trim()).equals("")){
    			System.out.println("No ID!");
    		}else{
    			sql="";
    			sql="select * from EmployeeInfo where emp_id="+Integer.parseInt(EmployeeIdTF.getText());
    			EmployeeAction eA1=new EmployeeAction();
    			Employee searchResult=new Employee();
    			searchResult=eA1.search(sql);
    			if(searchResult==null){
    				EmployeeIdTF.setText("");
    			}else{
    				EmployeeFirstNameTF.setText(searchResult.get_Employee_Fname());
        			EmployeeHireDateTF.setText(searchResult.get_HireDate());
        			EmployeeLastNameTF.setText(searchResult.get_Employee_Lname());
        			EmployeeSSNTF.setText(searchResult.get_SSN());
        			EmployeePositionIdTF.setText(""+searchResult.get_Position_id());
        			EmployeeQualificationIdTF.setText(""+searchResult.get_Qual_id_of_Employee());
        			EmployeeDepartmentIdTF.setText(""+searchResult.get_Dep_id_of_Employee());
    			}
    			
    		}
    	}catch(Exception e){
    		
    	}
    }
}
