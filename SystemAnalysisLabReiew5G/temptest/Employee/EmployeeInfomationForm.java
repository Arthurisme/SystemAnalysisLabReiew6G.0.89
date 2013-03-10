package Employee;

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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeInfomationForm extends JFrame {

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
	//static  PrintWriter outFile;
	static String string1;
	static String oldTextOfEmployee;
	int addTimes = 0;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public static void main(String[] args) throws NullPointerException,
			IOException {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfomationForm frame = new EmployeeInfomationForm();
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
	public EmployeeInfomationForm() {
		setTitle("Employee Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//
		//
	 	
		System.out.println("try");

	/*
	 *I have wirite a returnold text method which is real time 
	 *render to insteat this.
	 * 	try {
			doEmployee();
		} catch (NullPointerException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		//
*/		//

		JButton btnAddemployee = new JButton("Add Employee");
		btnAddemployee.setBounds(0, 230, 150, 30);
		btnAddemployee.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {

				//
				// check if already exist:

				// add variable:

				String fEmployee_id = textField_EmployeeID.getText();
				String fEmployee_Lname = textField_LastName.getText();
				String fEmployee_Fname = textField_FirstName.getText();
				String fSSN = textField_Ssn.getText();
				String fPosition_id = textField_Position.getText();
				String fHireDate = textField_Hiredate.getText();
				String fDep_id_of_Employee = textField_DepartmentID.getText();
				String fQual_id_of_Employee = textField_Qualification.getText();
				//

				


				 
/*here is for mere test:
				// teest on screen:
*/				
		/*		try {
					System.out.println(ReturnOldText());
				} catch (NullPointerException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				//test on temp file:
				try {
					outFile = new PrintWriter("Employee2.in");
					outFile.println(ReturnOldText());
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				outFile.close();*/

				// try buffer:

				//I have rewrite this to a method:
				/*boolean notfullAllFields;
				notfullAllFields = ((textField_EmployeeID.getText().equals(""))
						|| (textField_LastName.getText().equals(""))
						|| (textField_FirstName.getText().equals(""))
						|| (textField_Ssn.getText().equals(""))
						|| (textField_Position.getText().equals(""))
						|| (textField_Hiredate.getText().equals(""))
						|| (textField_DepartmentID.getText().equals("")) || (textField_Qualification
						.getText().equals("")));*/
				//
//
				if (TextFieldsNotAllFilled()) {
					Label_note.setText("Please fill all the testField.");
				} else {

					if (checkIfnotexist()) {

						//
						Label_note.setText("Employee is new,now added:");
						try {
							FileWriter fstream;
							fstream = new FileWriter("Employee.in", true);
							BufferedWriter fbw = new BufferedWriter(fstream);

							//Test where is the new blank is ok;
							//if the first line is empty, 
							
							//else
							// fbw.append (oldTextOfEmployee);
							String tempNewLineEmployee=
									fEmployee_id + "	" + fEmployee_Lname
							+ "	" + fEmployee_Fname + "	" + fSSN + "	"
							+ fPosition_id + "	" + fHireDate + "	"
							+ fDep_id_of_Employee + "	"
							+ fQual_id_of_Employee;
							fbw.append(tempNewLineEmployee);
							fbw.newLine();
							
							//test on screen:
							System.out.println(tempNewLineEmployee);
							 
							addTimes++;
							fbw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Label_note.setText(addTimes
								+ " Employee(s) have been added.");
					}// end noExistSearchedEmployee

					else {
						Label_note
								.setText("You can not add this employee, because this ID of employee is already used.");
					}
				}

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddemployee);

		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// deleting a employee:
				// searching what you want to delete:

				// the employee you want to search:
				Employee searchedEmployee = null;
				Employee searchedEmployee2 = null;
				// if searched:
				boolean Cope_and_noDeleteEmployee = false;
				boolean FindAndDeleted = false;

				int searchByID = Integer.parseInt(textField_EmployeeID
						.getText());

				// start search:
				Label_note
						.setText("Please enter a ID of employee you want to delete:");
				try {

					EmployeeReadintoArray tryEA2D = new EmployeeReadintoArray();

					FileWriter fstreamD;
					fstreamD = new FileWriter("Employee.in");
					BufferedWriter fbwD = new BufferedWriter(fstreamD);
					// copy:
					for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
						if (tryEA2D.get_EmployeeByIndex(i).get_Employee_id() != searchByID) {
							if (tryEA2D.get_EmployeeByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_Employee_id() == searchByID) {
								if (i < tryEA2D.NumberOfLines - 2) {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								}
							}// if the last line deleted, no newline added to
								// last second.
							else {

								if (i < tryEA2D.NumberOfLines - 1) {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								}

							}

						} else {
							FindAndDeleted = true;
							searchedEmployee2 = tryEA2D.get_EmployeeByIndex(i);
						}
					}

					// addTimes++;
					fbwD.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// if find:
				if (FindAndDeleted) {
					Label_note.setText(" The Employee have   been deleted.");

					// show on screen:
					System.out.println(searchedEmployee2.EmployeeToString());
					// show sharched on form:
					textField_EmployeeID.setText(""
							+ (searchedEmployee2.get_Employee_id()));
					textField_FirstName.setText(searchedEmployee2
							.get_Employee_Fname());
					textField_LastName.setText(searchedEmployee2
							.get_Employee_Lname());
					textField_Ssn.setText(searchedEmployee2.get_SSN());
					textField_Qualification.setText(""
							+ (searchedEmployee2.get_Qual_id_of_Employee()));
					textField_DepartmentID.setText(""
							+ (searchedEmployee2.get_Dep_id_of_Employee()));
					textField_Position.setText(""
							+ (searchedEmployee2.get_Position_id()));
					textField_Hiredate.setText(searchedEmployee2.get_HireDate());

					//

				}
				// if not find:
				else {
					Label_note.setText("This Employee not find in the file.");
					textField_FirstName.setText("");
					textField_LastName.setText("");
					textField_Ssn.setText("");
					textField_Qualification.setText("");
					textField_DepartmentID.setText("");
					textField_Position.setText("");
					textField_Hiredate.setText("");

				}

				//

				// ###################################
				// begin delete:
				// remove all text in the file:
				// FileWriter filewriter1=new FileWriter("Employee.in");
				// try:

				//

			}
		});
		btnDeleteEmployee.setBounds(150, 230, 150, 30);
		contentPane.add(btnDeleteEmployee);

		JButton btnUpdateEmployee = new JButton("update Employee");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// begin update:

				String fEmployee_id = textField_EmployeeID.getText();
				String fEmployee_Lname = textField_LastName.getText();
				String fEmployee_Fname = textField_FirstName.getText();
				String fSSN = textField_Ssn.getText();
				String fPosition_id = textField_Position.getText();
				String fHireDate = textField_Hiredate.getText();
				String fDep_id_of_Employee = textField_DepartmentID.getText();
				String fQual_id_of_Employee = textField_Qualification.getText();
				// deleting a employee:
				// searching what you want to delete:

				// the employee you want to search:
				Employee searchedEmployee = null;
				Employee searchedEmployee2 = null;
				Employee searchedEmployee3 = null;
				// if searched:
				boolean Cope_and_noDeleteEmployee = false;
				boolean FindAndupdated = false;

				int searchByID = Integer.parseInt(textField_EmployeeID
						.getText());

				// start search:
				Label_note
						.setText("Please enter a ID of employee you want to updated:");
				//check if all field is filled:
				if (TextFieldsNotAllFilled()) {
					Label_note.setText("Please fill all the testField.");
				} else//if filled all fields,this else is to the end of mouse action:
				{
				
				try {

					EmployeeReadintoArray tryEA2D = new EmployeeReadintoArray();

					FileWriter fstreamD;
					fstreamD = new FileWriter("Employee.in");
					BufferedWriter fbwD = new BufferedWriter(fstreamD);
					// copy:
					for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
						// /
						if (tryEA2D.get_EmployeeByIndex(
								tryEA2D.NumberOfLines - 1).get_Employee_id() != searchByID) {
							if (tryEA2D.get_EmployeeByIndex(i)
									.get_Employee_id() != searchByID) {

								if (i < tryEA2D.NumberOfLines - 1) {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								}

							} else {
								fbwD.append(fEmployee_id + "	"
										+ fEmployee_Lname + "	"
										+ fEmployee_Fname + "	" + fSSN + "	"
										+ fPosition_id + "	" + fHireDate + "	"
										+ fDep_id_of_Employee + "	"
										+ fQual_id_of_Employee);
								FindAndupdated = true;
								fbwD.newLine();
							}

						} else// if last line is changed:
						{

							if (tryEA2D.get_EmployeeByIndex(i)
									.get_Employee_id() != searchByID) {

								if (i < tryEA2D.NumberOfLines - 1) {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteEmployee = true;

									fbwD.append(tryEA2D.get_EmployeeByIndex(i)
											.EmployeeToString());
									fbwD.newLine();
								}

							} else {
								fbwD.append(fEmployee_id + "	"
										+ fEmployee_Lname + "	"
										+ fEmployee_Fname + "	" + fSSN + "	"
										+ fPosition_id + "	" + fHireDate + "	"
										+ fDep_id_of_Employee + "	"
										+ fQual_id_of_Employee);
								FindAndupdated = true;
								 fbwD.newLine();
							}

						}
					}

					// addTimes++;
					fbwD.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// if find:
				if (FindAndupdated) {
					Label_note.setText(" The Employee have   been updated.");

					// show on screen:

					//

				}
				// if not find:
				else {
					Label_note.setText("This Employee not find in the file.");
					textField_FirstName.setText("");
					textField_LastName.setText("");
					textField_Ssn.setText("");
					textField_Qualification.setText("");
					textField_DepartmentID.setText("");
					textField_Position.setText("");
					textField_Hiredate.setText("");

				}

				//

				// ###################################
				// begin delete:
				// remove all text in the file:
				// FileWriter filewriter1=new FileWriter("Employee.in");
				// try:

				//

				// end update
				}
			}
		});
		btnUpdateEmployee.setBounds(465, 230, 150, 30);
		contentPane.add(btnUpdateEmployee);

		JButton btnSearchEmployee = new JButton("Search Employee");
		btnSearchEmployee.addActionListener(new ActionListener() {
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
		btnSearchEmployee.setBounds(315, 230, 150, 30);
		contentPane.add(btnSearchEmployee);

		JLabel Lable_EmployeeID = new JLabel("Employee ID:");
		Lable_EmployeeID.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_EmployeeID.setBounds(0, 96, 150, 30);
		contentPane.add(Lable_EmployeeID);

		textField_EmployeeID = new JTextField();
		textField_EmployeeID.setBounds(150, 96, 150, 30);
		contentPane.add(textField_EmployeeID);
		textField_EmployeeID.setColumns(10);

		textField_FirstName = new JTextField();
		textField_FirstName.setColumns(10);
		textField_FirstName.setBounds(465, 96, 150, 30);
		contentPane.add(textField_FirstName);

		JLabel Lable_FirstName = new JLabel("Enter Employee's First Name:");
		Lable_FirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_FirstName.setBounds(315, 96, 150, 30);
		contentPane.add(Lable_FirstName);

		JLabel Lable_LastName = new JLabel("Enter Employee's Last Name:");
		Lable_LastName.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_LastName.setBounds(0, 129, 150, 30);
		contentPane.add(Lable_LastName);

		textField_LastName = new JTextField();
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(150, 129, 150, 30);
		contentPane.add(textField_LastName);

		JLabel Lable_Ssn = new JLabel("Enter Employee's SSN:");
		Lable_Ssn.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Ssn.setBounds(315, 129, 150, 30);
		contentPane.add(Lable_Ssn);

		textField_Ssn = new JTextField();
		textField_Ssn.setColumns(10);
		textField_Ssn.setBounds(465, 129, 150, 30);
		contentPane.add(textField_Ssn);

		JLabel Lable_Qualification = new JLabel(
				"Enter Employee's Qualification:");
		Lable_Qualification.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Qualification.setBounds(0, 194, 150, 30);
		contentPane.add(Lable_Qualification);

		textField_Qualification = new JTextField();
		textField_Qualification.setColumns(10);
		textField_Qualification.setBounds(150, 194, 150, 30);
		contentPane.add(textField_Qualification);

		JLabel Lable_DepartmentID = new JLabel(
				"Enter Employee's Department ID:");
		Lable_DepartmentID.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Lable_DepartmentID.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_DepartmentID.setBounds(304, 194, 161, 30);
		contentPane.add(Lable_DepartmentID);

		textField_DepartmentID = new JTextField();
		textField_DepartmentID.setColumns(10);
		textField_DepartmentID.setBounds(465, 194, 150, 30);
		contentPane.add(textField_DepartmentID);

		JLabel Lable_Position = new JLabel("Enter Employee's Position:");
		Lable_Position.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Position.setBounds(0, 161, 150, 30);
		contentPane.add(Lable_Position);

		textField_Position = new JTextField();
		textField_Position.setColumns(10);
		textField_Position.setBounds(150, 161, 150, 30);
		contentPane.add(textField_Position);

		JLabel Lable_Hiredate = new JLabel("Enter Employee's HireDate:");
		Lable_Hiredate.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_Hiredate.setBounds(315, 161, 150, 30);
		contentPane.add(Lable_Hiredate);

		textField_Hiredate = new JTextField();
		textField_Hiredate.setColumns(10);
		textField_Hiredate.setBounds(465, 161, 150, 30);
		contentPane.add(textField_Hiredate);

		Label_note = new JLabel("Employee form:");
		Label_note.setBounds(32, 23, 546, 47);
		contentPane.add(Label_note);
	}

	public  void doEmployee() throws NullPointerException, IOException {

		 EmployeeReadintoArray theEmployeeRead = new EmployeeReadintoArray();

		oldTextOfEmployee = theEmployeeRead.get_OriginalText();
		//!!!for text
		//oldTextOfEmployee = "9	9	9	9	9	9	9	9";
		// System.out.println(oldTextOfEmployee);
	}
	public  String ReturnOldText() throws NullPointerException, IOException {
//return employee.in
		 EmployeeReadintoArray theEmployeeRead = new EmployeeReadintoArray();

		String theOldTextOfEmployee = theEmployeeRead.get_OriginalText();
		
		return theOldTextOfEmployee;
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
	
	public boolean TextFieldsNotAllFilled()
	{
		/*This method is use for check if all the test fields,
		Not All Filled,or all filled.
		 if not all filled, return true:
		even if only one is empty, return true*/
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
}
