package SystemAnalysisLabReiew6G;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class A_This_is_Run_Here_PayRollSystem_Main_Run extends JFrame implements
        ActionListener{

    /**
     * @param args the command line arguments
     */
    private JLabel EmployeeId,EmployeeLastNameLa,EmployeeFirstNameLa, EmployeeSSNLa, NumberWorkedHourLa, HourlyRateLa, TotalIncomeLa, NetIncomeLa
    				,EmployeePositionIdLa,EmployeeQualificationIdLa,EmployeeDepartmentIdLa,EmployeeHireDateLa;
    

    private JTextField EmployeeLastName_TF,EmployeeFirstName_TF,EmployeeSSN_TF,NumberWorkedHour_TF,HourRate_TF,TotalIncome_TF,NetIncome_TF,EmployeeId_TF
    				,EmployeePositionId_TF,EmployeeQualificationId_TF,EmployeeDepartmentId_TF,EmployeeHireDate_TF;

    private JButton calculateBu, exitBu;

    private calculateButtonHandler calculateHandler;
    private ExitButtonHandler ebHandler;

    private JMenuBar menuMB =
            new JMenuBar(); //create the menu bar
    private JMenu InputDataM, OutputDataM;
    private JMenuItem EmployeeI, DepartmentI, PositionI, QualificationI, ItemsPayI;
    EmployeeSalaryPayDetails salary=new EmployeeSalaryPayDetails();

    java.text.DecimalFormat decimal2Places_format=new java.text.DecimalFormat("0.00");

    private static final int WIDTH =600;
    private static final int HEIGHT = 600;
    private String sql="",temp;
    private JMenuItem mntmOutputpaystubA;
    private JMenuItem mntmListallemployeepaystubA;

    public A_This_is_Run_Here_PayRollSystem_Main_Run(){
//        double d5=19.00;
//        System.out.println(String.format("%.2f",d5));
//        BigDecimal a = new BigDecimal(19.5001);
//        double t1=a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println("a.setScale(2,2)=" + a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
//        java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.00");
//        System.out.println("a.setScale(2,2)=" + myformat.format(t1));
    	EmployeeId = new JLabel("Enter Employee's ID: ",SwingConstants.RIGHT);
    	EmployeeId.setBounds(0, 0, 292, 41); EmployeeFirstNameLa = new
    	JLabel("Enter Employee's First Name: ",SwingConstants.RIGHT);
    	EmployeeFirstNameLa.setBounds(0, 41, 292, 41); EmployeeLastNameLa = new
    	JLabel("Enter Employee's Last Name: ",SwingConstants.RIGHT);
    	EmployeeLastNameLa.setBounds(0, 82, 292, 41);
        EmployeeSSNLa = new JLabel("Enter Employee's SSN: ",SwingConstants.RIGHT);
        EmployeeSSNLa.setBounds(0, 123, 292, 41);
        EmployeePositionIdLa= new JLabel("Enter Employee's Position ID: ",SwingConstants.RIGHT);
        EmployeePositionIdLa.setBounds(0, 164, 292, 41);
        EmployeeQualificationIdLa= new JLabel("Enter Employee's Qualification Id: ",SwingConstants.RIGHT);
        EmployeeQualificationIdLa.setBounds(0, 205, 292, 41);
        EmployeeDepartmentIdLa= new JLabel("Enter Employee's Department ID: ",SwingConstants.RIGHT);
        EmployeeDepartmentIdLa.setBounds(0, 246, 292, 41);
        EmployeeHireDateLa=new JLabel("Enter Employee's Hire Date: ",SwingConstants.RIGHT);
        EmployeeHireDateLa.setBounds(0, 287, 292, 41);
        NumberWorkedHourLa = new JLabel("Enter Number of Worked Hour: ",SwingConstants.RIGHT);
        NumberWorkedHourLa.setBounds(0, 328, 292, 41);
        HourlyRateLa = new JLabel("Enter the Rate Hour: ",SwingConstants.RIGHT);
        HourlyRateLa.setBounds(0, 369, 292, 41);
        TotalIncomeLa = new JLabel("Total Income: ",SwingConstants.RIGHT);
        TotalIncomeLa.setBounds(0, 410, 292, 41);
        NetIncomeLa = new JLabel("Net Amount: ",SwingConstants.RIGHT);
        NetIncomeLa.setBounds(0, 451, 292, 41);
        
         //Create the four text fields
        EmployeeId_TF=new JTextField(10);
        EmployeeId_TF.setBounds(292, 0, 292, 41);
        EmployeeId_TF.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) {
        		getEmployeeInfo();
        	}
        }); EmployeeFirstName_TF = new JTextField(10);
        EmployeeFirstName_TF.setBounds(292, 41, 292, 41); EmployeeLastName_TF =
        new JTextField(10); EmployeeLastName_TF.setBounds(292, 82, 292, 41);
        EmployeeSSN_TF = new JTextField(10); EmployeeSSN_TF.setBounds(292, 123,
        292, 41); EmployeePositionId_TF= new JTextField(10);
        EmployeePositionId_TF.setBounds(292, 164, 292, 41);
        EmployeeQualificationId_TF= new JTextField(10);
        EmployeeQualificationId_TF.setBounds(292, 205, 292, 41);
        EmployeeDepartmentId_TF= new JTextField(10);
        EmployeeDepartmentId_TF.setBounds(292, 246, 292, 41);
        EmployeeHireDate_TF=new JTextField(10);
        EmployeeHireDate_TF.setBounds(292, 287, 292, 41); NumberWorkedHour_TF =
        new JTextField(10); NumberWorkedHour_TF.setBounds(292, 328, 292, 41);
        HourRate_TF = new JTextField(10); HourRate_TF.setBounds(292, 369, 292,
        41); TotalIncome_TF = new JTextField(10); TotalIncome_TF.setBounds(292,
        410, 292, 41); NetIncome_TF = new JTextField(10);
        NetIncome_TF.setBounds(292, 451, 292, 41);

       
        setJMenuBar(menuMB);
        setInputDataMenu();
        setOutputDataMenu();


             //Create Calculate Button
        calculateBu = new JButton("Calculate");
        calculateBu.setBounds(0, 492, 140, 41);
        calculateHandler = new calculateButtonHandler();
        calculateBu.addActionListener(calculateHandler);

             //Create Exit Button
        exitBu = new JButton("Exit");
        exitBu.setBounds(292, 492, 292, 41);
        ebHandler = new ExitButtonHandler();
        exitBu.addActionListener(ebHandler);

             //Set the title of the window
        setTitle("Pay Roll Application");

                 //Get the container
        Container pane = getContentPane();
      getContentPane().setLayout(null);

             //Place the components in the pane
      pane.add(EmployeeId);
      pane.add(EmployeeId_TF);
      pane.add(EmployeeFirstNameLa);
      pane.add(EmployeeFirstName_TF);
      pane.add(EmployeeLastNameLa);
      pane.add(EmployeeLastName_TF);
      pane.add(EmployeeSSNLa);
      pane.add(EmployeeSSN_TF);
      pane.add(EmployeePositionIdLa);
      pane.add(EmployeePositionId_TF);
      pane.add(EmployeeQualificationIdLa);
      pane.add(EmployeeQualificationId_TF);
      pane.add(EmployeeDepartmentIdLa);
      pane.add(EmployeeDepartmentId_TF);
      pane.add(EmployeeHireDateLa);
      pane.add(EmployeeHireDate_TF);
      pane.add(NumberWorkedHourLa);
      pane.add(NumberWorkedHour_TF);
      pane.add(HourlyRateLa);
      pane.add(HourRate_TF);
      pane.add(TotalIncomeLa);
      pane.add(TotalIncome_TF);
      pane.add(NetIncomeLa);
      pane.add(NetIncome_TF);
      pane.add(calculateBu);
      pane.add(exitBu);
      
      JButton CalcFromDatebaseBu = new JButton("Calculate");
      CalcFromDatebaseBu.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		//This is calculator form database:

            

            try{
               //create a instance of Employee
           	Employee Employee1b=new Employee();
           	Employee1b.set_Employee_id(Integer.parseInt(EmployeeId_TF.getText().trim()));
           	Employee1b.set_Employee_Fname(EmployeeFirstName_TF.getText());
           	Employee1b.set_Employee_Lname(EmployeeLastName_TF.getText());
           	Employee1b.Set_SSN(EmployeeSSN_TF.getText());
           	Employee1b.set_Position_id(Integer.parseInt(EmployeePositionId_TF.getText()));
           	Employee1b.set_Qual_id_of_Employee(Integer.parseInt(EmployeeQualificationId_TF.getText()));
           	Employee1b.set_Dep_id_of_Employee(Integer.parseInt(EmployeeDepartmentId_TF.getText()));
           	Employee1b.set_HireDate(EmployeeHireDate_TF.getText());
           	
               salary.set_EmployeeInfo(Employee1b);
               salary.set_HourlyRate(Double.parseDouble(HourRate_TF.getText()));
               salary.set_NumberWorkedHour(Double.parseDouble(NumberWorkedHour_TF.getText()));
               //read and write from database:
               salary.CalculateNetIncome();// database written.
               
               //read from class, not from database:
               TotalIncome_TF.setText(""+salary.get_TotalIncome()+"$");
               NetIncome_TF.setText(""+salary.get_NetIncome()+"$");
               
               
            }catch(NumberFormatException e1){
                System.out.println("You input the wrong data!");
            }
            
            
            
         //end calculator
      		
      		
      	}
      });
      CalcFromDatebaseBu.setBounds(152, 492, 140, 41);
      getContentPane().add(CalcFromDatebaseBu);

             //Set the size of the window and display it
      setSize(WIDTH, HEIGHT);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

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
        InputDataM = new JMenu("InputData");
        menuMB.add(InputDataM);
        EmployeeI = new JMenuItem("Employee");
        InputDataM.add(EmployeeI);
        EmployeeI.addActionListener(this);

        DepartmentI = new JMenuItem("Department");
        InputDataM.add(DepartmentI);
        DepartmentI.addActionListener(this);
        PositionI = new JMenuItem("Position");
        InputDataM.add(PositionI);
        PositionI.addActionListener(this);

        QualificationI = new JMenuItem("Qualification");
        InputDataM.add(QualificationI);
        QualificationI.addActionListener(this);

        ItemsPayI = new JMenuItem("Items Pay");
        InputDataM.add(ItemsPayI);
        ItemsPayI.addActionListener(this);
    }

    private void setOutputDataMenu() {// private JMenuItem OutputPayStubI, ListAllEmployeePayStubI;
        OutputDataM = new JMenu("OutputData");
        menuMB.add(OutputDataM);
        
        mntmOutputpaystubA = new JMenuItem("OutputPayStub A");
        mntmOutputpaystubA.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		//outputPay Stub here:
        		OutputPayStubForm theOutputPayStubForm=new OutputPayStubForm();
        		 theOutputPayStubForm.setVisible(true);
        		
        	}
        });
        OutputDataM.add(mntmOutputpaystubA);
        
        mntmListallemployeepaystubA = new JMenuItem("ListAllEmployeePayStub A");
        mntmListallemployeepaystubA.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		//alll list begin:
        		
        		;
				try {
					ListAllEmployeePayStub theListAllEmployeePayStub = new ListAllEmployeePayStub();
				
	        		theListAllEmployeePayStub.setVisible(true);

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		//all list end
        	}
        });
        OutputDataM.add(mntmListallemployeepaystubA);

    }

    private class calculateButtonHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         

         try{
            //create a instance of Employee
        	Employee Employee1=new Employee();
        	Employee1.set_Employee_id(Integer.parseInt(EmployeeId_TF.getText().trim()));
        	Employee1.set_Employee_Fname(EmployeeFirstName_TF.getText());
        	Employee1.set_Employee_Lname(EmployeeLastName_TF.getText());
        	Employee1.Set_SSN(EmployeeSSN_TF.getText());
        	Employee1.set_Position_id(Integer.parseInt(EmployeePositionId_TF.getText()));
        	Employee1.set_Qual_id_of_Employee(Integer.parseInt(EmployeeQualificationId_TF.getText()));
        	Employee1.set_Dep_id_of_Employee(Integer.parseInt(EmployeeDepartmentId_TF.getText()));
        	Employee1.set_HireDate(EmployeeHireDate_TF.getText());
        	
            salary.set_EmployeeInfo(Employee1);
            salary.set_HourlyRate(Double.parseDouble(HourRate_TF.getText()));
            salary.set_NumberWorkedHour(Double.parseDouble(NumberWorkedHour_TF.getText()));
            salary.CalculateNetIncome();
            TotalIncome_TF.setText(""+salary.get_TotalIncome()+"$");
            NetIncome_TF.setText(""+salary.get_NetIncome()+"$");
            
            
         }catch(NumberFormatException e1){
             System.out.println("You input the wrong data!");
         }
         
         
         
      }
   }

   private class ExitButtonHandler implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
       {
           System.exit(0);
       }
   }

    public static void main(String[] args) {
        // TODO code application logic here

        A_This_is_Run_Here_PayRollSystem_Main_Run dia1=new A_This_is_Run_Here_PayRollSystem_Main_Run();
       // dia1.setVisible(true);
        
    }
    
    public void getEmployeeInfo(){
    	try{
    		if((EmployeeId_TF.getText().trim()).equals("")){
    			System.out.println("No ID!");
    		}else{
    			sql="";
    			sql="select * from EmployeeInfo where emp_id="+Integer.parseInt(EmployeeId_TF.getText());
    			EmployeeAction eA1=new EmployeeAction();
    			Employee searchResult=new Employee();
    			searchResult=eA1.search(sql);
    			if(searchResult==null){
    				EmployeeId_TF.setText("");
    			}else{
    				EmployeeFirstName_TF.setText(searchResult.get_Employee_Fname());
        			EmployeeHireDate_TF.setText(searchResult.get_HireDate());
        			EmployeeLastName_TF.setText(searchResult.get_Employee_Lname());
        			EmployeeSSN_TF.setText(searchResult.get_SSN());
        			EmployeePositionId_TF.setText(""+searchResult.get_Position_id());
        			EmployeeQualificationId_TF.setText(""+searchResult.get_Qual_id_of_Employee());
        			EmployeeDepartmentId_TF.setText(""+searchResult.get_Dep_id_of_Employee());
    			}
    			
    		}
    	}catch(Exception e){
    		
    	}
    }
}
