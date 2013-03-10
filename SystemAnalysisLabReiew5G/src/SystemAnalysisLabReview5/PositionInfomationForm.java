package SystemAnalysisLabReview5;

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

public class PositionInfomationForm extends JFrame {

	private JLabel lblPositionForm;
	private JPanel contentPane;
	private JTextField textField_PositionID;
	private JTextField textField_PositionDesc;
	static Scanner inFile;
	//static PrintWriter outFile;
	static String string1;
	static String oldTextOfPosition;
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
					PositionInfomationForm frame = new PositionInfomationForm();
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
	public PositionInfomationForm() {
		setTitle("Position Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAddPosition = new JButton("Add Position");
		btnAddPosition.setBounds(0, 137, 150, 30);
		btnAddPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//
				// check if already exist:

				// add variable:

				String fPosition_id = textField_PositionID.getText();

				String fPosition_Desc = textField_PositionDesc.getText();

				//
				System.out.println("try");

				// add Position here:

				// teest on screen:
		/*		try {
					System.out.println(ReturnOldText());
				} catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					outFile = new PrintWriter("Position2.in");
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
					lblPositionForm.setText("Please fill all the testField.");
				} else {

					if (checkIfnotexist()) {

						//
						lblPositionForm.setText("Position is new,now added:");
						try {
							FileWriter fstream;
							fstream = new FileWriter("Position.in", true);
							BufferedWriter fbw = new BufferedWriter(fstream);
							String TempPositionString = fPosition_id + "	"
									 + fPosition_Desc;

							fbw.append(TempPositionString);
							fbw.newLine();
							System.out.println(TempPositionString);

							addTimes++;
							fbw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lblPositionForm.setText(addTimes
								+ " Position(s) have been added.");
					}// end noExistSearchedPosition

					else {
						lblPositionForm
								.setText("You can not add this Position, because this ID of Position is already used.");
					}
				}

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddPosition);

		JButton btnDeletePosition = new JButton("Delete Position");
		btnDeletePosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// deleting a Position:
				// searching what you want to delete:

				// the Position you want to search:
				Position searchedPosition = null;
				Position searchedPosition2 = null;
				// if searched:
				boolean Cope_and_noDeletePosition = false;
				boolean FindAndDeleted = false;

				int searchByID = Integer.parseInt(textField_PositionID
						.getText());

				// start search:
				lblPositionForm
						.setText("Please enter a ID of Position you want to delete:");
				try {

					PositionReadintoArray tryEA2D = new PositionReadintoArray();

					FileWriter fstreamD;
					fstreamD = new FileWriter("Position.in");
					BufferedWriter fbwD = new BufferedWriter(fstreamD);
					// copy:
					for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
						if (tryEA2D.get_PositionByIndex(i).get_Position_id() != searchByID) {
							if (tryEA2D.get_PositionByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_Position_id() == searchByID) {
								if (i < tryEA2D.NumberOfLines - 2) {
									Cope_and_noDeletePosition = true;

									fbwD.append(tryEA2D.get_PositionByIndex(i)
											.PositionToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeletePosition = true;

									fbwD.append(tryEA2D.get_PositionByIndex(i)
											.PositionToString());
									fbwD.newLine();
								}
							}// if the last line deleted, no newline added to
								// last second.
							else {

								if (i < tryEA2D.NumberOfLines - 1) {
									Cope_and_noDeletePosition = true;

									fbwD.append(tryEA2D.get_PositionByIndex(i)
											.PositionToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeletePosition = true;

									fbwD.append(tryEA2D.get_PositionByIndex(i)
											.PositionToString());
									fbwD.newLine();
								}

							}

						} else {
							FindAndDeleted = true;
							searchedPosition2 = tryEA2D.get_PositionByIndex(i);
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
					lblPositionForm
							.setText(" The Position have   been deleted.");

					// show on screen:
					System.out.println(searchedPosition2.PositionToString());
					// show sharched on form:
					textField_PositionID.setText(""
							+ (searchedPosition2.get_Position_id()));
					textField_PositionDesc.setText(searchedPosition2
							.get_Position_Desc());

					//

				}
				// if not find:
				else {
					lblPositionForm
							.setText("This Position not find in the file.");
					textField_PositionDesc.setText("");

				}

				//

				// ###################################
				// begin delete:
				// remove all text in the file:
				// FileWriter filewriter1=new FileWriter("Position.in");
				// try:

				//

			}
		});
		btnDeletePosition.setBounds(150, 137, 150, 30);
		contentPane.add(btnDeletePosition);

		JButton btnUpdatePosition = new JButton("update Position");
		btnUpdatePosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// begin update:

				String fPosition_id = textField_PositionID.getText();

				String fPosition_Desc = textField_PositionDesc.getText();

				// deleting a Position:
				// searching what you want to delete:

				// the Position you want to search:
				Position searchedPosition = null;
				Position searchedPosition2 = null;
				Position searchedPosition3 = null;
				// if searched:
				boolean Cope_and_noDeletePosition = false;
				boolean FindAndupdated = false;

				int searchByID = Integer.parseInt(textField_PositionID
						.getText());

				// start search:
				lblPositionForm
						.setText("Please enter a ID of Position you want to updated:");
				// check if all field is filled:
				if (TextFieldsNotAllFilled()) {
					lblPositionForm.setText("Please fill all the testField.");
				} else// if filled all fields,this else is to the end of mouse
						// action:
				{

					try {

						PositionReadintoArray tryEA2D = new PositionReadintoArray();

						FileWriter fstreamD;
						fstreamD = new FileWriter("Position.in");
						BufferedWriter fbwD = new BufferedWriter(fstreamD);
						// copy:
						for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
							// /
							if (tryEA2D.get_PositionByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_Position_id() != searchByID) {
								if (tryEA2D.get_PositionByIndex(i)
										.get_Position_id() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeletePosition = true;

										fbwD.append(tryEA2D
												.get_PositionByIndex(i)
												.PositionToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeletePosition = true;

										fbwD.append(tryEA2D
												.get_PositionByIndex(i)
												.PositionToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fPosition_id + "	"

									+ fPosition_Desc);
									FindAndupdated = true;
									fbwD.newLine();
								}

							} else// if last line is changed:
							{

								if (tryEA2D.get_PositionByIndex(i)
										.get_Position_id() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeletePosition = true;

										fbwD.append(tryEA2D
												.get_PositionByIndex(i)
												.PositionToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeletePosition = true;

										fbwD.append(tryEA2D
												.get_PositionByIndex(i)
												.PositionToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fPosition_id + "	"

									+ fPosition_Desc);
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
						lblPositionForm
								.setText(" The Position have   been updated.");

						// show on screen:

						//

					}
					// if not find:
					else {
						lblPositionForm
								.setText("This Position not find in the file.");
						textField_PositionDesc.setText("");

					}

					//

					// ###################################
					// begin delete:
					// remove all text in the file:
					// FileWriter filewriter1=new FileWriter("Position.in");
					// try:

					//

					// end update
				}
			}
		});
		btnUpdatePosition.setBounds(450, 137, 150, 30);
		contentPane.add(btnUpdatePosition);

		JButton btnSearchPosition = new JButton("Search Position");
		btnSearchPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// the Position you want to search:
				Position searchedPosition = null;
				// if searched:
				boolean notSearched = true;

				int searchByID = Integer.parseInt(textField_PositionID
						.getText());

				// start search:
				lblPositionForm.setText("Searching from  Position forms:");
				try {

					PositionReadintoArray tryEA2 = new PositionReadintoArray();

					for (int i = 0; i < tryEA2.lineCounter("Position.in"); i++) {
						if (tryEA2.get_PositionByIndex(i).get_Position_id() == searchByID) {
							searchedPosition = tryEA2.get_PositionByIndex(i);
							notSearched = false;// if searched any one time:

						}
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// if find:
				if (notSearched) {
					lblPositionForm
							.setText(" Position(s) have not been Search.");

					textField_PositionDesc.setText("");

				}
				// if not find:
				else {
					lblPositionForm.setText(" Position(s) have been Search.");
					// show on screen:
					System.out.println(searchedPosition.PositionToString());
					// show sharched on form:
					textField_PositionID.setText(""
							+ (searchedPosition.get_Position_id()));
					textField_PositionDesc.setText(searchedPosition
							.get_Position_Desc());

				}

				//

			}
		});
		btnSearchPosition.setBounds(300, 137, 150, 30);
		contentPane.add(btnSearchPosition);

		JLabel Lable_PositionID = new JLabel("Position ID:");
		Lable_PositionID.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_PositionID.setBounds(0, 96, 150, 30);
		contentPane.add(Lable_PositionID);

		textField_PositionID = new JTextField();
		textField_PositionID.setBounds(150, 96, 150, 30);
		contentPane.add(textField_PositionID);
		textField_PositionID.setColumns(10);

		textField_PositionDesc = new JTextField();
		textField_PositionDesc.setColumns(10);
		textField_PositionDesc.setBounds(450, 96, 150, 30);
		contentPane.add(textField_PositionDesc);

		JLabel Lable_PositionDesc = new JLabel("Enter Position's Description:");
		Lable_PositionDesc.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_PositionDesc.setBounds(300, 96, 150, 30);
		contentPane.add(Lable_PositionDesc);

		lblPositionForm = new JLabel("Position form:");
		lblPositionForm.setBounds(32, 23, 546, 47);
		contentPane.add(lblPositionForm);
	}

	public static void doPosition() throws NullPointerException, IOException {

		PositionReadintoArray thePositionRead = new PositionReadintoArray();

		oldTextOfPosition = thePositionRead.get_OriginalText();
		// !!!for text
		// oldTextOfPosition = "9	9	9	9	9	9	9	9";
		// System.out.println(oldTextOfPosition);
	}

	public String ReturnOldText() throws NullPointerException, IOException {
		// return Position.in
		PositionReadintoArray thePositionRead = new PositionReadintoArray();

		String theOldTextOfPosition = thePositionRead.get_OriginalText();

		return theOldTextOfPosition;
	}

	public boolean checkIfnotexist() {

		boolean isSearched = false;

		// the Position you want to search:
		Position searchedPosition = null;
		// if searched:
		boolean notSearched = true;

		int searchByID = Integer.parseInt(textField_PositionID.getText());

		// start search:
		lblPositionForm.setText("Searching from  Position forms:");
		try {

			PositionReadintoArray tryEA2 = new PositionReadintoArray();

			for (int i = 0; i < tryEA2.NumberOfLines; i++) {
				if (tryEA2.get_PositionByIndex(i).get_Position_id() == searchByID) {
					searchedPosition = tryEA2.get_PositionByIndex(i);
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
			lblPositionForm.setText(" Position(s) have not been Search.");

		}
		// if not find:
		else {
			lblPositionForm.setText(" Position(s) have been Search.");
			// show on screen:
			System.out.println(searchedPosition.PositionToString());
			// show sharched on form:
			textField_PositionID.setText(""
					+ (searchedPosition.get_Position_id()));
			textField_PositionDesc
					.setText(searchedPosition.get_Position_Desc());

		}

		//

		return notSearched;
	}

	public void cleanAndWritePositionToFile() {

	}

	public boolean TextFieldsNotAllFilled() {
		/*
		 * This method is use for check if all the test fields, Not All
		 * Filled,or all filled. if not all filled, return true: even if only
		 * one is empty, return true
		 */
		boolean notfullAllFields;
		notfullAllFields = ((textField_PositionID.getText().equals("")) || (textField_PositionDesc
				.getText().equals("")));

		return notfullAllFields;
		//
	}
}
