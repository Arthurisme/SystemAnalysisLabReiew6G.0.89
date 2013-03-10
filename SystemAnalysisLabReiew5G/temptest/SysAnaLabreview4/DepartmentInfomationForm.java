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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.Scanner;

public class DepartmentInfomationForm extends JFrame {

	private JLabel lblDepartmentForm;
	private JPanel contentPane;
	private JTextField textField_DepDepartmentID;
	private JTextField textField_DepartmentName;
	private JTextField textField_DepartmentLocation;
	static Scanner inFile;
	//static PrintWriter outFile;
	static String string1;
	static String oldTextOfDepartment;
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
					DepartmentInfomationForm frame = new DepartmentInfomationForm();
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
	public DepartmentInfomationForm() {
		setTitle("Department Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.setBounds(0, 230, 150, 30);
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//
				// check if already exist:

				// add variable:

				String fDepartment_id = textField_DepDepartmentID.getText();
				String fDepartment_Lname = textField_DepartmentLocation
						.getText();
				String fDepartment_Fname = textField_DepartmentName.getText();

				//
				System.out.println("try");

				// add Department here:

				// teest on screen:
				/*try {
					System.out.println(ReturnOldText());
				} catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					outFile = new PrintWriter("Department2.in");
					outFile.println(ReturnOldText());
				} catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}// test on temp file.
*/
				//outFile.close();

				// try buffer:

				//
				if (TextFieldsNotAllFilled()) {
					lblDepartmentForm.setText("Please fill all the testField.");
				} else {

					if (checkIfnotexist()) {

						//
						lblDepartmentForm
								.setText("Department is new,now added:");
						try {
							FileWriter fstream;
							fstream = new FileWriter("Department.in", true);
							BufferedWriter fbw = new BufferedWriter(fstream);
							String TempDepartmentString = fDepartment_id + "	"
									+ fDepartment_Lname + "	"
									+ fDepartment_Fname;

							fbw.append(TempDepartmentString);
							fbw.newLine();
							System.out.println(TempDepartmentString);

							addTimes++;
							fbw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lblDepartmentForm.setText(addTimes
								+ " Department(s) have been added.");
					}// end noExistSearchedDepartment

					else {
						lblDepartmentForm
								.setText("You can not add this Department, because this ID of Department is already used.");
					}
				}

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddDepartment);

		JButton btnDeleteDepartment = new JButton("Delete Department");
		btnDeleteDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// deleting a Department:
				// searching what you want to delete:

				// the Department you want to search:
				Department searchedDepartment = null;
				Department searchedDepartment2 = null;
				// if searched:
				boolean Cope_and_noDeleteDepartment = false;
				boolean FindAndDeleted = false;

				int searchByID = Integer.parseInt(textField_DepDepartmentID
						.getText());

				// start search:
				lblDepartmentForm
						.setText("Please enter a ID of Department you want to delete:");
				try {

					DepartmentReadintoArray tryEA2D = new DepartmentReadintoArray();

					FileWriter fstreamD;
					fstreamD = new FileWriter("Department.in");//rewrite every thing
					BufferedWriter fbwD = new BufferedWriter(fstreamD);
					// copy:
					for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
						if (tryEA2D.get_DepartmentByIndex(i)
								.get_Department_id() != searchByID) {
							if (tryEA2D.get_DepartmentByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_Department_id() == searchByID) {
								if (i < tryEA2D.NumberOfLines - 2) {
									Cope_and_noDeleteDepartment = true;

									fbwD.append(tryEA2D
											.get_DepartmentByIndex(i)
											.DepartmentToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteDepartment = true;

									fbwD.append(tryEA2D
											.get_DepartmentByIndex(i)
											.DepartmentToString());
									fbwD.newLine();
								}
							}// if the last line deleted, no newline added to
								// last second.
							else {

								if (i < tryEA2D.NumberOfLines - 1) {
									Cope_and_noDeleteDepartment = true;

									fbwD.append(tryEA2D
											.get_DepartmentByIndex(i)
											.DepartmentToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteDepartment = true;

									fbwD.append(tryEA2D
											.get_DepartmentByIndex(i)
											.DepartmentToString());
									fbwD.newLine();
								}

							}

						} else {
							FindAndDeleted = true;
							searchedDepartment2 = tryEA2D
									.get_DepartmentByIndex(i);
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
					lblDepartmentForm
							.setText(" The Department have   been deleted.");

					// show on screen:
					System.out.println(searchedDepartment2.DepartmentToString());
					// show sharched on form:
					textField_DepDepartmentID.setText(""
							+ (searchedDepartment2.get_Department_id()));
					textField_DepartmentName.setText(searchedDepartment2
							.get_Department_Name());
					textField_DepartmentLocation.setText(searchedDepartment2
							.get_Department_Location());

					//

				}
				// if not find:
				else {
					lblDepartmentForm
							.setText("This Department not find in the file.");
					textField_DepartmentName.setText("");
					textField_DepartmentLocation.setText("");

				}

				//

				// ###################################
				// begin delete:
				// remove all text in the file:
				// FileWriter filewriter1=new FileWriter("Department.in");
				// try:

				//

			}
		});
		btnDeleteDepartment.setBounds(150, 230, 150, 30);
		contentPane.add(btnDeleteDepartment);

		JButton btnUpdateDepartment = new JButton("update Department");
		btnUpdateDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// begin update:

				String fDepartment_id = textField_DepDepartmentID.getText();
				String fDepartment_Lname = textField_DepartmentLocation
						.getText();
				String fDepartment_Fname = textField_DepartmentName.getText();

				// deleting a Department:
				// searching what you want to delete:

				// the Department you want to search:
				Department searchedDepartment = null;
				Department searchedDepartment2 = null;
				Department searchedDepartment3 = null;
				// if searched:
				boolean Cope_and_noDeleteDepartment = false;
				boolean FindAndupdated = false;

				int searchByID = Integer.parseInt(textField_DepDepartmentID
						.getText());

				// start search:
				lblDepartmentForm
						.setText("Please enter a ID of Department you want to updated:");
				// check if all field is filled:
				if (TextFieldsNotAllFilled()) {
					lblDepartmentForm.setText("Please fill all the testField.");
				} else// if filled all fields,this else is to the end of mouse
						// action:
				{

					try {

						DepartmentReadintoArray tryEA2D = new DepartmentReadintoArray();

						FileWriter fstreamD;
						fstreamD = new FileWriter("Department.in");
						BufferedWriter fbwD = new BufferedWriter(fstreamD);
						// copy:
						for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
							// /
							if (tryEA2D.get_DepartmentByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_Department_id() != searchByID) {
								if (tryEA2D.get_DepartmentByIndex(i)
										.get_Department_id() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeleteDepartment = true;

										fbwD.append(tryEA2D
												.get_DepartmentByIndex(i)
												.DepartmentToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeleteDepartment = true;

										fbwD.append(tryEA2D
												.get_DepartmentByIndex(i)
												.DepartmentToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fDepartment_id + "	"
											+ fDepartment_Lname + "	"
											+ fDepartment_Fname);
									FindAndupdated = true;
									fbwD.newLine();
								}

							} else// if last line is changed:
							{

								if (tryEA2D.get_DepartmentByIndex(i)
										.get_Department_id() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeleteDepartment = true;

										fbwD.append(tryEA2D
												.get_DepartmentByIndex(i)
												.DepartmentToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeleteDepartment = true;

										fbwD.append(tryEA2D
												.get_DepartmentByIndex(i)
												.DepartmentToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fDepartment_id + "	"
											+ fDepartment_Lname + "	"
											+ fDepartment_Fname);
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
						lblDepartmentForm
								.setText(" The Department have   been updated.");

						// show on screen:

						//

					}
					// if not find:
					else {
						lblDepartmentForm
								.setText("This Department not find in the file.");
						textField_DepartmentName.setText("");
						textField_DepartmentLocation.setText("");

					}

					//

					// ###################################
					// begin delete:
					// remove all text in the file:
					// FileWriter filewriter1=new FileWriter("Department.in");
					// try:

					//

					// end update
				}
			}
		});
		btnUpdateDepartment.setBounds(450, 230, 150, 30);
		contentPane.add(btnUpdateDepartment);

		JButton btnSearchDepartment = new JButton("Search Department");
		btnSearchDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// the Department you want to search:
				Department searchedDepartment = null;
				// if searched:
				boolean notSearched = true;

				int searchByID = Integer.parseInt(textField_DepDepartmentID
						.getText());

				// start search:
				lblDepartmentForm.setText("Searching from  Department forms:");
				try {

					DepartmentReadintoArray tryEA2 = new DepartmentReadintoArray();

					for (int i = 0; i < tryEA2.lineCounter("Department.in"); i++) {
						if (tryEA2.get_DepartmentByIndex(i).get_Department_id() == searchByID) {
							searchedDepartment = tryEA2
									.get_DepartmentByIndex(i);
							notSearched = false;// if searched any one time:

						}
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// if find:
				if (notSearched) {
					lblDepartmentForm
							.setText(" Department(s) have not been Search.");

					textField_DepartmentName.setText("");
					textField_DepartmentLocation.setText("");

				}
				// if not find:
				else {
					lblDepartmentForm
							.setText(" Department(s) have been Search.");
					// show on screen:
					System.out.println(searchedDepartment.DepartmentToString());
					// show sharched on form:
					textField_DepDepartmentID.setText(""
							+ (searchedDepartment.get_Department_id()));
					textField_DepartmentName.setText(searchedDepartment
							.get_Department_Name());
					textField_DepartmentLocation.setText(searchedDepartment
							.get_Department_Location());

				}

				//

			}
		});
		btnSearchDepartment.setBounds(300, 230, 150, 30);
		contentPane.add(btnSearchDepartment);

		JLabel Lable_DepDepartmentID = new JLabel("Department ID:");
		Lable_DepDepartmentID.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_DepDepartmentID.setBounds(150, 96, 150, 30);
		contentPane.add(Lable_DepDepartmentID);

		textField_DepDepartmentID = new JTextField();
		textField_DepDepartmentID.setBounds(300, 96, 150, 30);
		contentPane.add(textField_DepDepartmentID);
		textField_DepDepartmentID.setColumns(10);

		textField_DepartmentName = new JTextField();
		textField_DepartmentName.setColumns(10);
		textField_DepartmentName.setBounds(300, 137, 150, 30);
		contentPane.add(textField_DepartmentName);

		JLabel Lable_DepartmentName = new JLabel("Enter Department's Name:");
		Lable_DepartmentName.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_DepartmentName.setBounds(150, 137, 150, 30);
		contentPane.add(Lable_DepartmentName);

		JLabel Lable_DepartmentLocation = new JLabel(
				"Enter Department's Loacation:");
		Lable_DepartmentLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_DepartmentLocation.setBounds(129, 181, 171, 30);
		contentPane.add(Lable_DepartmentLocation);

		textField_DepartmentLocation = new JTextField();
		textField_DepartmentLocation.setColumns(10);
		textField_DepartmentLocation.setBounds(300, 181, 150, 30);
		contentPane.add(textField_DepartmentLocation);

		lblDepartmentForm = new JLabel("Department form:");
		lblDepartmentForm.setBounds(32, 23, 546, 47);
		contentPane.add(lblDepartmentForm);
	}

	public static void doDepartment() throws NullPointerException, IOException {

		DepartmentReadintoArray theDepartmentRead = new DepartmentReadintoArray();

		oldTextOfDepartment = theDepartmentRead.get_OriginalText();
		// !!!for text
		// oldTextOfDepartment = "9	9	9	9	9	9	9	9";
		// System.out.println(oldTextOfDepartment);
	}

	public String ReturnOldText() throws NullPointerException, IOException {
		// return Department.in
		DepartmentReadintoArray theDepartmentRead = new DepartmentReadintoArray();

		String theOldTextOfDepartment = theDepartmentRead.get_OriginalText();

		return theOldTextOfDepartment;
	}

	public boolean checkIfnotexist() {

		boolean isSearched = false;

		// the Department you want to search:
		Department searchedDepartment = null;
		// if searched:
		boolean notSearched = true;

		int searchByID = Integer.parseInt(textField_DepDepartmentID.getText());

		// start search:
		lblDepartmentForm.setText("Searching from  Department forms:");
		try {

			DepartmentReadintoArray tryEA2 = new DepartmentReadintoArray();

			for (int i = 0; i < tryEA2.NumberOfLines; i++) {
				if (tryEA2.get_DepartmentByIndex(i).get_Department_id() == searchByID) {
					searchedDepartment = tryEA2.get_DepartmentByIndex(i);
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
			lblDepartmentForm.setText(" Department(s) have not been Search.");

		}
		// if not find:
		else {
			lblDepartmentForm.setText(" Department(s) have been Search.");
			// show on screen:
			System.out.println(searchedDepartment.DepartmentToString());
			// show sharched on form:
			textField_DepDepartmentID.setText(""
					+ (searchedDepartment.get_Department_id()));
			textField_DepartmentName.setText(searchedDepartment
					.get_Department_Name());
			textField_DepartmentLocation.setText(searchedDepartment
					.get_Department_Location());

		}

		//

		return notSearched;
	}

	public void cleanAndWriteDepartmentToFile() {

	}

	public boolean TextFieldsNotAllFilled() {
		/*
		 * This method is use for check if all the test fields, Not All
		 * Filled,or all filled. if not all filled, return true: even if only
		 * one is empty, return true
		 */
		boolean notfullAllFields;
		notfullAllFields = ((textField_DepDepartmentID.getText().equals(""))
				|| (textField_DepartmentLocation.getText().equals("")) || (textField_DepartmentName
				.getText().equals("")));

		return notfullAllFields;
		//
	}
}
