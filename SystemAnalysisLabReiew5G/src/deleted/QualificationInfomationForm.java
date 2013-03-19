package deleted;

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

import SystemAnalysisLabReiew6G.Qualification;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.Scanner;

public class QualificationInfomationForm extends JFrame {

	private JLabel lblQualificationForm;
	private JPanel contentPane;
	private JTextField textField_QualificationID;
	private JTextField textField_QualificationDesc;
	static Scanner inFile;
	//static PrintWriter outFile;
	static String string1;
	static String oldTextOfQualification;
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
					QualificationInfomationForm frame = new QualificationInfomationForm();
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
	public QualificationInfomationForm() {
		setTitle("Qualification Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAddQualification = new JButton("Add Qualification");
		btnAddQualification.setBounds(0, 150, 150, 30);
		btnAddQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//
				// check if already exist:

				// add variable:

				String fQualification_id = textField_QualificationID.getText();

				String fQualification_Desc = textField_QualificationDesc.getText();

				//
				System.out.println("try");

				// add Qualification here:

				// teest on screen:
/*				try {
					System.out.println(ReturnOldText());
				} catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					outFile = new PrintWriter("Qualification2.in");
					outFile.println(ReturnOldText());
				} catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}// test on temp file.

				outFile.close();*/

				// try buffer:

				//
				if (TextFieldsNotAllFilled()) {
					lblQualificationForm.setText("Please fill all the testField.");
				} else {

					if (checkIfnotexist()) {

						//
						lblQualificationForm.setText("Qualification is new,now added:");
						try {
							FileWriter fstream;
							fstream = new FileWriter("Qualification.in", true);
							BufferedWriter fbw = new BufferedWriter(fstream);
							String TempQualificationString = fQualification_id + "	"
									 + fQualification_Desc;

							fbw.append(TempQualificationString);
							fbw.newLine();
							System.out.println(TempQualificationString);

							addTimes++;
							fbw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lblQualificationForm.setText(addTimes
								+ " Qualification(s) have been added.");
					}// end noExistSearchedQualification

					else {
						lblQualificationForm
								.setText("You can not add this Qualification, because this ID of Qualification is already used.");
					}
				}

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddQualification);

		JButton btnDeleteQualification = new JButton("Delete Qualification");
		btnDeleteQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// deleting a Qualification:
				// searching what you want to delete:

				// the Qualification you want to search:
				Qualification searchedQualification = null;
				Qualification searchedQualification2 = null;
				// if searched:
				boolean Cope_and_noDeleteQualification = false;
				boolean FindAndDeleted = false;

				int searchByID = Integer.parseInt(textField_QualificationID
						.getText());

				// start search:
				lblQualificationForm
						.setText("Please enter a ID of Qualification you want to delete:");
				try {

					QualificationReadintoArray tryEA2D = new QualificationReadintoArray();

					FileWriter fstreamD;
					fstreamD = new FileWriter("Qualification.in");
					BufferedWriter fbwD = new BufferedWriter(fstreamD);
					// copy:
					for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
						if (tryEA2D.get_QualificationByIndex(i).get_Qualification_id() != searchByID) {
							if (tryEA2D.get_QualificationByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_Qualification_id() == searchByID) {
								if (i < tryEA2D.NumberOfLines - 2) {
									Cope_and_noDeleteQualification = true;

									fbwD.append(tryEA2D.get_QualificationByIndex(i)
											.QualificationToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteQualification = true;

									fbwD.append(tryEA2D.get_QualificationByIndex(i)
											.QualificationToString());
									fbwD.newLine();
								}
							}// if the last line deleted, no newline added to
								// last second.
							else {

								if (i < tryEA2D.NumberOfLines - 1) {
									Cope_and_noDeleteQualification = true;

									fbwD.append(tryEA2D.get_QualificationByIndex(i)
											.QualificationToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteQualification = true;

									fbwD.append(tryEA2D.get_QualificationByIndex(i)
											.QualificationToString());
									fbwD.newLine();
								}

							}

						} else {
							FindAndDeleted = true;
							searchedQualification2 = tryEA2D.get_QualificationByIndex(i);
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
					lblQualificationForm
							.setText(" The Qualification have   been deleted.");

					// show on screen:
					System.out.println(searchedQualification2.QualificationToString());
					// show sharched on form:
					textField_QualificationID.setText(""
							+ (searchedQualification2.get_Qualification_id()));
					textField_QualificationDesc.setText(searchedQualification2
							.get_Qualification_Desc());

					//

				}
				// if not find:
				else {
					lblQualificationForm
							.setText("This Qualification not find in the file.");
					textField_QualificationDesc.setText("");

				}

				//

				// ###################################
				// begin delete:
				// remove all text in the file:
				// FileWriter filewriter1=new FileWriter("Qualification.in");
				// try:

				//

			}
		});
		btnDeleteQualification.setBounds(150, 150, 150, 30);
		contentPane.add(btnDeleteQualification);

		JButton btnUpdateQualification = new JButton("update Qualification");
		btnUpdateQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// begin update:

				String fQualification_id = textField_QualificationID.getText();

				String fQualification_Desc = textField_QualificationDesc.getText();

				// deleting a Qualification:
				// searching what you want to delete:

				// the Qualification you want to search:
				Qualification searchedQualification = null;
				Qualification searchedQualification2 = null;
				Qualification searchedQualification3 = null;
				// if searched:
				boolean Cope_and_noDeleteQualification = false;
				boolean FindAndupdated = false;

				int searchByID = Integer.parseInt(textField_QualificationID
						.getText());

				// start search:
				lblQualificationForm
						.setText("Please enter a ID of Qualification you want to updated:");
				// check if all field is filled:
				if (TextFieldsNotAllFilled()) {
					lblQualificationForm.setText("Please fill all the testField.");
				} else// if filled all fields,this else is to the end of mouse
						// action:
				{

					try {

						QualificationReadintoArray tryEA2D = new QualificationReadintoArray();

						FileWriter fstreamD;
						fstreamD = new FileWriter("Qualification.in");
						BufferedWriter fbwD = new BufferedWriter(fstreamD);
						// copy:
						for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
							// /
							if (tryEA2D.get_QualificationByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_Qualification_id() != searchByID) {
								if (tryEA2D.get_QualificationByIndex(i)
										.get_Qualification_id() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeleteQualification = true;

										fbwD.append(tryEA2D
												.get_QualificationByIndex(i)
												.QualificationToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeleteQualification = true;

										fbwD.append(tryEA2D
												.get_QualificationByIndex(i)
												.QualificationToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fQualification_id + "	"

									+ fQualification_Desc);
									FindAndupdated = true;
									fbwD.newLine();
								}

							} else// if last line is changed:
							{

								if (tryEA2D.get_QualificationByIndex(i)
										.get_Qualification_id() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeleteQualification = true;

										fbwD.append(tryEA2D
												.get_QualificationByIndex(i)
												.QualificationToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeleteQualification = true;

										fbwD.append(tryEA2D
												.get_QualificationByIndex(i)
												.QualificationToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fQualification_id + "	"

									+ fQualification_Desc);
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
						lblQualificationForm
								.setText(" The Qualification have   been updated.");

						// show on screen:

						//

					}
					// if not find:
					else {
						lblQualificationForm
								.setText("This Qualification not find in the file.");
						textField_QualificationDesc.setText("");

					}

					//

					// ###################################
					// begin delete:
					// remove all text in the file:
					// FileWriter filewriter1=new FileWriter("Qualification.in");
					// try:

					//

					// end update
				}
			}
		});
		btnUpdateQualification.setBounds(450, 150, 150, 30);
		contentPane.add(btnUpdateQualification);

		JButton btnSearchQualification = new JButton("Search Qualification");
		btnSearchQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// the Qualification you want to search:
				Qualification searchedQualification = null;
				// if searched:
				boolean notSearched = true;

				int searchByID = Integer.parseInt(textField_QualificationID
						.getText());

				// start search:
				lblQualificationForm.setText("Searching from  Qualification forms:");
				try {

					QualificationReadintoArray tryEA2 = new QualificationReadintoArray();

					for (int i = 0; i < tryEA2.lineCounter("Qualification.in"); i++) {
						if (tryEA2.get_QualificationByIndex(i).get_Qualification_id() == searchByID) {
							searchedQualification = tryEA2.get_QualificationByIndex(i);
							notSearched = false;// if searched any one time:

						}
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// if find:
				if (notSearched) {
					lblQualificationForm
							.setText(" Qualification(s) have not been Search.");

					textField_QualificationDesc.setText("");

				}
				// if not find:
				else {
					lblQualificationForm.setText(" Qualification(s) have been Search.");
					// show on screen:
					System.out.println(searchedQualification.QualificationToString());
					// show sharched on form:
					textField_QualificationID.setText(""
							+ (searchedQualification.get_Qualification_id()));
					textField_QualificationDesc.setText(searchedQualification
							.get_Qualification_Desc());

				}

				//

			}
		});
		btnSearchQualification.setBounds(300, 150, 150, 30);
		contentPane.add(btnSearchQualification);

		JLabel Lable_QualificationID = new JLabel("Qualification ID:");
		Lable_QualificationID.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_QualificationID.setBounds(0, 96, 150, 30);
		contentPane.add(Lable_QualificationID);

		textField_QualificationID = new JTextField();
		textField_QualificationID.setBounds(150, 96, 150, 30);
		contentPane.add(textField_QualificationID);
		textField_QualificationID.setColumns(10);

		textField_QualificationDesc = new JTextField();
		textField_QualificationDesc.setColumns(10);
		textField_QualificationDesc.setBounds(450, 96, 150, 30);
		contentPane.add(textField_QualificationDesc);

		JLabel Lable_QualificationDesc = new JLabel("Enter Qualification's Description:");
		Lable_QualificationDesc.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_QualificationDesc.setBounds(300, 96, 150, 30);
		contentPane.add(Lable_QualificationDesc);

		lblQualificationForm = new JLabel("Qualification form:");
		lblQualificationForm.setBounds(32, 23, 546, 47);
		contentPane.add(lblQualificationForm);
	}

	public static void doQualification() throws NullPointerException, IOException {

		QualificationReadintoArray theQualificationRead = new QualificationReadintoArray();

		oldTextOfQualification = theQualificationRead.get_OriginalText();
		// !!!for text
		// oldTextOfQualification = "9	9	9	9	9	9	9	9";
		// System.out.println(oldTextOfQualification);
	}

	public String ReturnOldText() throws NullPointerException, IOException {
		// return Qualification.in
		QualificationReadintoArray theQualificationRead = new QualificationReadintoArray();

		String theOldTextOfQualification = theQualificationRead.get_OriginalText();

		return theOldTextOfQualification;
	}

	public boolean checkIfnotexist() {

		boolean isSearched = false;

		// the Qualification you want to search:
		Qualification searchedQualification = null;
		// if searched:
		boolean notSearched = true;

		int searchByID = Integer.parseInt(textField_QualificationID.getText());

		// start search:
		lblQualificationForm.setText("Searching from  Qualification forms:");
		try {

			QualificationReadintoArray tryEA2 = new QualificationReadintoArray();

			for (int i = 0; i < tryEA2.NumberOfLines; i++) {
				if (tryEA2.get_QualificationByIndex(i).get_Qualification_id() == searchByID) {
					searchedQualification = tryEA2.get_QualificationByIndex(i);
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
			lblQualificationForm.setText(" Qualification(s) have not been Search.");

		}
		// if not find:
		else {
			lblQualificationForm.setText(" Qualification(s) have been Search.");
			// show on screen:
			System.out.println(searchedQualification.QualificationToString());
			// show sharched on form:
			textField_QualificationID.setText(""
					+ (searchedQualification.get_Qualification_id()));
			textField_QualificationDesc
					.setText(searchedQualification.get_Qualification_Desc());

		}

		//

		return notSearched;
	}

	public void cleanAndWriteQualificationToFile() {

	}

	public boolean TextFieldsNotAllFilled() {
		/*
		 * This method is use for check if all the test fields, Not All
		 * Filled,or all filled. if not all filled, return true: even if only
		 * one is empty, return true
		 */
		boolean notfullAllFields;
		notfullAllFields = ((textField_QualificationID.getText().equals("")) || (textField_QualificationDesc
				.getText().equals("")));

		return notfullAllFields;
		//
	}
}
