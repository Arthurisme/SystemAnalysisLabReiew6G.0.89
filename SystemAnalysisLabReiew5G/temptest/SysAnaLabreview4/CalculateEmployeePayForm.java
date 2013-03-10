package SysAnaLabreview4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.Scanner;

public class CalculateEmployeePayForm extends JFrame {

	private JLabel Label_note;
	private JPanel contentPane;
	private JTextField textField_EmployeeID;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_Ssn;
	private JTextField textField_Qualification;
	private JTextField textField_DepartmentID;
	private JTextField textField_Position;
	private JTextField textField_Hiredate;
	static Scanner inFile;
	// static PrintWriter outFile;
	static String string1;
	static String oldTextOfEmployee;
	int addTimes = 0;
	private JTextField textField_EmployeesWorkingHours;
	private JTextField textField_EmployeeRateHour;
	private JTextField textField_TotalIncome;
	private JTextField textField_TotalNet;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public static void main(String[] args) throws NullPointerException,
			IOException {

		//

		//
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateEmployeePayForm frame = new CalculateEmployeePayForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculateEmployeePayForm() {
		setTitle("Calculate Employee pay");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// test:
		/*
		 * try { outFile = new PrintWriter("Employee2.in"); } catch
		 * (FileNotFoundException e2) { // TODO Auto-generated catch block
		 * e2.printStackTrace(); } System.out.println("try");
		 */

		contentPane.setLayout(null);

		JLabel Lable_EmployeeID = new JLabel("Employee ID:");
		Lable_EmployeeID.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_EmployeeID.setBounds(0, 34, 150, 30);
		contentPane.add(Lable_EmployeeID);

		textField_EmployeeID = new JTextField();
		textField_EmployeeID.setBounds(150, 34, 150, 30);
		contentPane.add(textField_EmployeeID);
		textField_EmployeeID.setColumns(10);

		textField_FirstName = new JTextField();
		textField_FirstName.setColumns(10);
		textField_FirstName.setBounds(450, 96, 150, 30);
		contentPane.add(textField_FirstName);

		JLabel Lable_FirstName = new JLabel("Enter Employee's First Name:");
		Lable_FirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_FirstName.setBounds(300, 96, 150, 30);
		contentPane.add(Lable_FirstName);

		JLabel Lable_LastName = new JLabel("Enter Employee's Last Name:");
		Lable_LastName.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_LastName.setBounds(0, 96, 150, 30);
		contentPane.add(Lable_LastName);

		textField_LastName = new JTextField();
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(150, 96, 150, 30);
		contentPane.add(textField_LastName);

		JLabel Lable_Ssn = new JLabel("Enter Employee's SSN:");
		Lable_Ssn.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Ssn.setBounds(0, 126, 150, 30);
		contentPane.add(Lable_Ssn);

		textField_Ssn = new JTextField();
		textField_Ssn.setColumns(10);
		textField_Ssn.setBounds(150, 126, 150, 30);
		contentPane.add(textField_Ssn);

		JLabel Lable_Qualification = new JLabel(
				"Enter Employee's Qualification:");
		Lable_Qualification.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Qualification.setBounds(300, 156, 150, 30);
		contentPane.add(Lable_Qualification);

		textField_Qualification = new JTextField();
		textField_Qualification.setColumns(10);
		textField_Qualification.setBounds(450, 156, 150, 30);
		contentPane.add(textField_Qualification);

		JLabel Lable_DepartmentID = new JLabel(
				"Enter Employee's Department ID:");
		Lable_DepartmentID.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Lable_DepartmentID.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_DepartmentID.setBounds(0, 189, 150, 30);
		contentPane.add(Lable_DepartmentID);

		textField_DepartmentID = new JTextField();
		textField_DepartmentID.setColumns(10);
		textField_DepartmentID.setBounds(150, 189, 150, 30);
		contentPane.add(textField_DepartmentID);

		JLabel Lable_Position = new JLabel("Enter Employee's Position:");
		Lable_Position.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Position.setBounds(300, 126, 150, 30);
		contentPane.add(Lable_Position);

		textField_Position = new JTextField();
		textField_Position.setColumns(10);
		textField_Position.setBounds(450, 126, 150, 30);
		contentPane.add(textField_Position);

		JLabel Lable_Hiredate = new JLabel("Enter Employee's HireDate:");
		Lable_Hiredate.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Hiredate.setBounds(0, 156, 150, 30);
		contentPane.add(Lable_Hiredate);

		textField_Hiredate = new JTextField();
		textField_Hiredate.setColumns(10);
		textField_Hiredate.setBounds(150, 156, 150, 30);
		contentPane.add(textField_Hiredate);

		Label_note = new JLabel("Employee form:");
		Label_note.setBounds(24, 0, 546, 22);
		contentPane.add(Label_note);

		JButton btnSearchEmployee_1 = new JButton("Search Employee");
		btnSearchEmployee_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// the employee you want to search:
				Employee searchedEmployee = null;
				// if searched:
				boolean notSearched = true;

				int searchByID = Integer.parseInt(textField_EmployeeID
						.getText());

				// start search:
				Label_note.setText("Searching from  Employee forms:");
				try {

					EmployeeReadintoArray tryEA2 = new EmployeeReadintoArray();

					for (int i = 0; i < tryEA2.lineCounter("Employee.in"); i++) {
						if (tryEA2.get_EmployeeByIndex(i).get_Employee_id() == searchByID) {
							searchedEmployee = tryEA2.get_EmployeeByIndex(i);
							notSearched = false;// if searched any one time:

						}
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// if find:
				if (notSearched) {
					Label_note.setText(" Employee(s) have not been Search.");

					textField_FirstName.setText("");
					textField_LastName.setText("");
					textField_Ssn.setText("");
					textField_Qualification.setText("");
					textField_DepartmentID.setText("");
					textField_Position.setText("");
					textField_Hiredate.setText("");

				}
				// if not find:
				else {
					Label_note.setText(" Employee(s) have been Search.");
					// show on screen:
					System.out.println(searchedEmployee.EmployeeToString());
					// show sharched on form:
					textField_EmployeeID.setText(""
							+ (searchedEmployee.get_Employee_id()));
					textField_FirstName.setText(searchedEmployee
							.get_Employee_Fname());
					textField_LastName.setText(searchedEmployee
							.get_Employee_Lname());
					textField_Ssn.setText(searchedEmployee.get_SSN());
					textField_Qualification.setText(""
							+ (searchedEmployee.get_Qual_id_of_Employee()));
					textField_DepartmentID.setText(""
							+ (searchedEmployee.get_Dep_id_of_Employee()));
					textField_Position.setText(""
							+ (searchedEmployee.get_Position_id()));
					textField_Hiredate.setText(searchedEmployee.get_HireDate());

				}

				//

			}
		});
		btnSearchEmployee_1.setBounds(321, 38, 115, 23);
		contentPane.add(btnSearchEmployee_1);

		JLabel Lable_EmployeesWorkingHours = new JLabel(
				"Employee's Worling Hours:");
		Lable_EmployeesWorkingHours
				.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_EmployeesWorkingHours.setBounds(0, 271, 150, 30);
		contentPane.add(Lable_EmployeesWorkingHours);

		textField_EmployeesWorkingHours = new JTextField();
		textField_EmployeesWorkingHours.setColumns(10);
		textField_EmployeesWorkingHours.setBounds(150, 271, 150, 30);
		contentPane.add(textField_EmployeesWorkingHours);

		JLabel Lable_EmployeeRateHour = new JLabel(
				"Employee's Rate Hour:");
		Lable_EmployeeRateHour.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_EmployeeRateHour.setBounds(300, 271, 150, 30);
		contentPane.add(Lable_EmployeeRateHour);

		textField_EmployeeRateHour = new JTextField();
		textField_EmployeeRateHour.setColumns(10);
		textField_EmployeeRateHour.setBounds(450, 271, 150, 30);
		contentPane.add(textField_EmployeeRateHour);

		JLabel Lable_TotalIncome = new JLabel("Total Income:");
		Lable_TotalIncome.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_TotalIncome.setBounds(0, 312, 150, 30);
		contentPane.add(Lable_TotalIncome);

		textField_TotalIncome = new JTextField();
		textField_TotalIncome.setColumns(10);
		textField_TotalIncome.setBounds(150, 312, 150, 30);
		contentPane.add(textField_TotalIncome);

		JLabel lblTotalNet = new JLabel("Total Net:");
		lblTotalNet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalNet.setBounds(300, 312, 150, 30);
		contentPane.add(lblTotalNet);

		textField_TotalNet = new JTextField();
		textField_TotalNet.setColumns(10);
		textField_TotalNet.setBounds(450, 312, 150, 30);
		contentPane.add(textField_TotalNet);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show total income:

				// if fields of hours is not filled both:
				if (Row_HourAndRate_TextFieldsNotAllFilled()
						|| Row_up_TextFieldsNotAllFilled()) {
					Label_note
							.setText("Please fill both  Hours and Hourrate field:");
				} else// if both hours textfields is filled:
				{
					textField_TotalIncome.setText("" + getTotalIncome());
					try {
						textField_TotalNet.setText("" + getTotalNet());
					} catch (NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						OutPutToFile_EmpPayDetail();
					} catch (NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnCalculate.setBounds(150, 353, 89, 23);
		contentPane.add(btnCalculate);
	}

	public static void doEmployee() throws NullPointerException, IOException {

		EmployeeReadintoArray theEmployeeRead = new EmployeeReadintoArray();

		oldTextOfEmployee = theEmployeeRead.get_OriginalText();
		// System.out.println(oldTextOfEmployee);
	}

	public String ReturnOldText() throws NullPointerException, IOException {
		// return Department.in
		DepartmentReadintoArray theDepartmentRead = new DepartmentReadintoArray();

		String theOldTextOfDepartment = theDepartmentRead.get_OriginalText();

		return theOldTextOfDepartment;
	}

	public boolean checkIfnotexist() {

		boolean isSearched = false;

		// the employee you want to search:
		Employee searchedEmployee = null;
		// if searched:
		boolean notSearched = true;

		int searchByID = Integer.parseInt(textField_EmployeeID.getText());

		// start search:
		Label_note.setText("Searching from  Employee forms:");
		try {

			EmployeeReadintoArray tryEA2 = new EmployeeReadintoArray();

			for (int i = 0; i < tryEA2.NumberOfLines; i++) {
				if (tryEA2.get_EmployeeByIndex(i).get_Employee_id() == searchByID) {
					searchedEmployee = tryEA2.get_EmployeeByIndex(i);
					notSearched = false;
					isSearched = true;

				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// if find:
		if (notSearched) {
			Label_note.setText(" Employee(s) have not been Search.");

		}
		// if not find:
		else {
			Label_note.setText(" Employee(s) have been Search.");
			// show on screen:
			System.out.println(searchedEmployee.EmployeeToString());
			// show sharched on form:
			textField_EmployeeID.setText(""
					+ (searchedEmployee.get_Employee_id()));
			textField_FirstName.setText(searchedEmployee.get_Employee_Fname());
			textField_LastName.setText(searchedEmployee.get_Employee_Lname());
			textField_Ssn.setText(searchedEmployee.get_SSN());
			textField_Qualification.setText(""
					+ (searchedEmployee.get_Qual_id_of_Employee()));
			textField_DepartmentID.setText(""
					+ (searchedEmployee.get_Dep_id_of_Employee()));
			textField_Position.setText(""
					+ (searchedEmployee.get_Position_id()));
			textField_Hiredate.setText(searchedEmployee.get_HireDate());

		}

		//

		return notSearched;
	}

	public void cleanAndWriteEmployeeToFile() {

	}

	public boolean Row_up_TextFieldsNotAllFilled() {
		/*
		 * This method is use for check if all the test fields, Not All
		 * Filled,or all filled. if not all filled, return true: even if only
		 * one is empty, return true
		 */
		boolean notfullAllFields;
		notfullAllFields = ((textField_EmployeeID.getText().equals(""))
				|| (textField_LastName.getText().equals(""))
				|| (textField_FirstName.getText().equals(""))
				|| (textField_Ssn.getText().equals(""))
				|| (textField_Position.getText().equals(""))
				|| (textField_Hiredate.getText().equals(""))
				|| (textField_DepartmentID.getText().equals("")) || (textField_Qualification
				.getText().equals("")));

		return notfullAllFields;
		//
	}

	public boolean Row_HourAndRate_TextFieldsNotAllFilled() {
		/*
		 * This method is use for check if all the test fields, Not All
		 * Filled,or all filled. if not all filled, return true: even if only
		 * one is empty, return true
		 */
		boolean notfullAllFields;
		notfullAllFields = ((textField_EmployeesWorkingHours.getText()
				.equals("")) || (textField_EmployeeRateHour.getText()
				.equals("")));

		return notfullAllFields;
		//
	}

	public int getLinesNumberItemsPay() throws NullPointerException,
			IOException {
		ItemsPayReadintoArray tempItemsPayArray = new ItemsPayReadintoArray();
		// tempItemsPayArray.lineCounter()
		return 23;
	}

	public double getTotalIncome() {
		double TotalIncomeDouble;
		double WorkingHours, RateHour;
		WorkingHours = Double.parseDouble(textField_EmployeesWorkingHours
				.getText());

		RateHour = Double.parseDouble(textField_EmployeeRateHour.getText());
		TotalIncomeDouble = WorkingHours * RateHour;

		String bigD = new java.text.DecimalFormat("0.00")
				.format(TotalIncomeDouble);
		Double bigD_Double = Double.parseDouble(bigD);
		return bigD_Double;
	}

	public double getTotalNet() throws NullPointerException, IOException {
		double TotalIncomeDouble = getTotalIncome();
		double AllDecucationRate = 0;
		ItemsPayReadintoArray tempItemsPayArray = new ItemsPayReadintoArray();

		int NumberOfLinesPayItems = lineCounter("ItemsPay.in");

		for (int i = 0; i < NumberOfLinesPayItems; i++) {

			double ALineOfDecucationRate = Double.parseDouble(tempItemsPayArray
					.get_ItemsPayByIndex(i).get_ItemPay_DeductionPer());
			AllDecucationRate = AllDecucationRate + ALineOfDecucationRate;
		}
		double TotalNet = TotalIncomeDouble * (1 - (AllDecucationRate / 100));

		String bigD = new java.text.DecimalFormat("0.00").format(TotalNet);
		Double bigD_Double = Double.parseDouble(bigD);
		return bigD_Double;
	}

	public void OutPutToFile_EmpPayDetail() throws NullPointerException,
			IOException {
		// get month and year:
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		int yearSc = calendar.get(java.util.Calendar.YEAR);
		int monthSc = calendar.get(java.util.Calendar.MONTH) + 1;

		// define variables:
		String cfEmployee_id = textField_EmployeeID.getText();
		String cfEmployee_Lname = textField_LastName.getText();
		String cfEmployee_Fname = textField_FirstName.getText();
		String cfSSN = textField_Ssn.getText();
		String cfPosition_id = textField_Position.getText();
		String cfHireDate = textField_Hiredate.getText();
		String cfDep_id_of_Employee = textField_DepartmentID.getText();
		String cfQual_id_of_Employee = textField_Qualification.getText();
		String cfWorkingHours = (textField_EmployeesWorkingHours.getText());

		String cfRateHour = (textField_EmployeeRateHour.getText());

		// write to file:
		EmployeeReadintoArray tryEA2Dc = new EmployeeReadintoArray();

		FileWriter fstreamDc;
		fstreamDc = new FileWriter("EmpPayDetail.out", true);
		BufferedWriter fbwDc = new BufferedWriter(fstreamDc);

		// from itemPay,wirte each itemPay:
		double TotalIncomeDouble = getTotalIncome();
		double TotalIncomeNet = getTotalNet();
		double AllDecucationRate = 0;
		ItemsPayReadintoArray tempItemsPayArray = new ItemsPayReadintoArray();

		int NumberOfLinesPayItems = lineCounter("ItemsPay.in");

		// Title of each employee detatil:

		//
		String OutputTitleOfEmpPay = String
				.format("%15s %15s %10s %15s %15s %15s %15s", "EmployeeId",
						"ItemPay_no", "NHhr", "ItemPay_Rate", "Amount",
						"Month", "Year");

		fbwDc.append(OutputTitleOfEmpPay);
		fbwDc.newLine();
		// put out 100 item
		String this100ItemPay = String
				.format("%15s %15s %10s %15s %15s %15s %15s",  
						cfEmployee_id, 100,	cfWorkingHours, 100, TotalIncomeDouble, monthSc, yearSc);

		fbwDc.append(this100ItemPay);
		fbwDc.newLine();
		// out put 200-300 item
		for (int i = 0; i < NumberOfLinesPayItems; i++) {

			int AlineOfItemPay_No = (tempItemsPayArray.get_ItemsPayByIndex(i)
					.get_ItemPay_No());
			double ALineOfDecucationRate = Double.parseDouble(tempItemsPayArray
					.get_ItemsPayByIndex(i).get_ItemPay_DeductionPer());
			AllDecucationRate = AllDecucationRate + ALineOfDecucationRate;
			Double AmountThisItemOfALine = TotalIncomeDouble
					* (ALineOfDecucationRate / 100);

			String bigD_AmountThisItemOfALine = new java.text.DecimalFormat(
					"0.00").format(AmountThisItemOfALine);
			Double bigD_Double_AmountThisLine = Double
					.parseDouble(bigD_AmountThisItemOfALine);

			String tempOut = String
					.format("%15s %15s %10s %15s %15s %15s %15s",  

					cfEmployee_id,	AlineOfItemPay_No, cfWorkingHours, ALineOfDecucationRate,
					bigD_Double_AmountThisLine, monthSc, yearSc);

			fbwDc.append(tempOut);
			fbwDc.newLine();
		}
		// put out 101 item
		String this101ItemPay = String
				.format("%15s %15s %10s %15s %15s %15s %15s",  

				cfEmployee_id, 101,
				cfWorkingHours, (100 - AllDecucationRate), TotalIncomeNet,
				monthSc, yearSc);

		fbwDc.append(this101ItemPay);
		fbwDc.newLine();
		fbwDc.close();
		// double TotalNet=TotalIncomeDouble*(1-(AllDecucationRate/100));

	}

	private int s(String string, String string2, String string3,
			String string4, String string5, String string6, String string7) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lineCounter(String filename) throws IOException,
			NullPointerException {
		int lineCount_int = 0;
		File inFile = new File(filename);
		try {
			Scanner file = new Scanner(inFile);
			while ((file.hasNext())) {
				String t = file.nextLine();
				lineCount_int++;
			}
		} catch (IOException e) {
		}
		return lineCount_int;
	}

}
