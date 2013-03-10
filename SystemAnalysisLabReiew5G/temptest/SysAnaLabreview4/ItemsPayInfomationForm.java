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

public class ItemsPayInfomationForm extends JFrame {

	private JLabel lblItemsPayForm;
	private JPanel contentPane;
	private JTextField textField_ItemsPay_No;
	private JTextField ItemsPay_DeductionPer;
	private JTextField textField_ItemsPay_Title;
	static Scanner inFile;
	//static PrintWriter outFile;
	static String string1;
	static String oldTextOfItemsPay;
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
					ItemsPayInfomationForm frame = new ItemsPayInfomationForm();
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
	public ItemsPayInfomationForm() {
		setTitle("ItemsPay Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAddItemsPay = new JButton("Add ItemsPay");
		btnAddItemsPay.setBounds(0, 171, 150, 30);
		btnAddItemsPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//
				// check if already exist:

				// add variable:

				String fItemsPay_No = textField_ItemsPay_No.getText();
				String fItemsPay_Lname = textField_ItemsPay_Title
						.getText();
				String fItemsPay_Fname = ItemsPay_DeductionPer.getText();

				//
				System.out.println("try");

				// add ItemsPay here:

	/*			// teest on screen:
				try {
					System.out.println(ReturnOldText());
				} catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					outFile = new PrintWriter("ItemsPay2.in");
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
					lblItemsPayForm.setText("Please fill all the testField.");
				} else {

					if (checkIfnotexist()) {

						//
						lblItemsPayForm
								.setText("ItemsPay is new,now added:");
						try {
							FileWriter fstream;
							fstream = new FileWriter("ItemsPay.in", true);
							BufferedWriter fbw = new BufferedWriter(fstream);
							String TempItemsPayString = fItemsPay_No + "	"
									+ fItemsPay_Lname + "	"
									+ fItemsPay_Fname;

							fbw.append(TempItemsPayString);
							fbw.newLine();
							System.out.println(TempItemsPayString);

							addTimes++;
							fbw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lblItemsPayForm.setText(addTimes
								+ " ItemsPay(s) have been added.");
					}// end noExistSearchedItemsPay

					else {
						lblItemsPayForm
								.setText("You can not add this ItemsPay, because this ID of ItemsPay is already used.");
					}
				}

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddItemsPay);

		JButton btnDeleteItemsPay = new JButton("Delete ItemsPay");
		btnDeleteItemsPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// deleting a ItemsPay:
				// searching what you want to delete:

				// the ItemsPay you want to search:
				ItemsPay searchedItemsPay = null;
				ItemsPay searchedItemsPay2 = null;
				// if searched:
				boolean Cope_and_noDeleteItemsPay = false;
				boolean FindAndDeleted = false;

				int searchByID = Integer.parseInt(textField_ItemsPay_No
						.getText());

				// start search:
				lblItemsPayForm
						.setText("Please enter a ID of ItemsPay you want to delete:");
				try {

					ItemsPayReadintoArray tryEA2D = new ItemsPayReadintoArray();

					FileWriter fstreamD;
					fstreamD = new FileWriter("ItemsPay.in");
					BufferedWriter fbwD = new BufferedWriter(fstreamD);
					// copy:
					for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
						if (tryEA2D.get_ItemsPayByIndex(i)
								.get_ItemPay_No() != searchByID) {
							if (tryEA2D.get_ItemsPayByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_ItemPay_No() == searchByID) {
								if (i < tryEA2D.NumberOfLines - 2) {
									Cope_and_noDeleteItemsPay = true;

									fbwD.append(tryEA2D
											.get_ItemsPayByIndex(i)
											.ItemPayToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteItemsPay = true;

									fbwD.append(tryEA2D
											.get_ItemsPayByIndex(i)
											.ItemPayToString());
									fbwD.newLine();
								}
							}// if the last line deleted, no newline added to
								// last second.
							else {

								if (i < tryEA2D.NumberOfLines - 1) {
									Cope_and_noDeleteItemsPay = true;

									fbwD.append(tryEA2D
											.get_ItemsPayByIndex(i)
											.ItemPayToString());
									fbwD.newLine();
								} else {
									Cope_and_noDeleteItemsPay = true;

									fbwD.append(tryEA2D
											.get_ItemsPayByIndex(i)
											.ItemPayToString());
									fbwD.newLine();
								}

							}

						} else {
							FindAndDeleted = true;
							searchedItemsPay2 = tryEA2D
									.get_ItemsPayByIndex(i);
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
					lblItemsPayForm
							.setText(" The ItemsPay have   been deleted.");

					// show on screen:
					System.out.println(searchedItemsPay2.ItemPayToString());
					// show sharched on form:
					textField_ItemsPay_No.setText(""
							+ (searchedItemsPay2.get_ItemPay_No()));
					ItemsPay_DeductionPer.setText(searchedItemsPay2
							.get_ItemPay_DeductionPer());
					textField_ItemsPay_Title.setText(searchedItemsPay2
							.get_ItemPay_Title());

					//

				}
				// if not find:
				else {
					lblItemsPayForm
							.setText("This ItemsPay not find in the file.");
					ItemsPay_DeductionPer.setText("");
					textField_ItemsPay_Title.setText("");

				}

				//

				// ###################################
				// begin delete:
				// remove all text in the file:
				// FileWriter filewriter1=new FileWriter("ItemsPay.in");
				// try:

				//

			}
		});
		btnDeleteItemsPay.setBounds(150, 171, 150, 30);
		contentPane.add(btnDeleteItemsPay);

		JButton btnUpdateItemsPay = new JButton("update ItemsPay");
		btnUpdateItemsPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// begin update:

				String fItemsPay_No = textField_ItemsPay_No.getText();
				String fItemsPay_Lname = textField_ItemsPay_Title
						.getText();
				String fItemsPay_Fname = ItemsPay_DeductionPer.getText();

				// deleting a ItemsPay:
				// searching what you want to delete:

				// the ItemsPay you want to search:
				ItemsPay searchedItemsPay = null;
				ItemsPay searchedItemsPay2 = null;
				ItemsPay searchedItemsPay3 = null;
				// if searched:
				boolean Cope_and_noDeleteItemsPay = false;
				boolean FindAndupdated = false;

				int searchByID = Integer.parseInt(textField_ItemsPay_No
						.getText());

				// start search:
				lblItemsPayForm
						.setText("Please enter a ID of ItemsPay you want to updated:");
				// check if all field is filled:
				if (TextFieldsNotAllFilled()) {
					lblItemsPayForm.setText("Please fill all the testField.");
				} else// if filled all fields,this else is to the end of mouse
						// action:
				{

					try {

						ItemsPayReadintoArray tryEA2D = new ItemsPayReadintoArray();

						FileWriter fstreamD;
						fstreamD = new FileWriter("ItemsPay.in");
						BufferedWriter fbwD = new BufferedWriter(fstreamD);
						// copy:
						for (int i = 0; i < tryEA2D.NumberOfLines; i++) {
							// /
							if (tryEA2D.get_ItemsPayByIndex(
									tryEA2D.NumberOfLines - 1)
									.get_ItemPay_No() != searchByID) {
								if (tryEA2D.get_ItemsPayByIndex(i)
										.get_ItemPay_No() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeleteItemsPay = true;

										fbwD.append(tryEA2D
												.get_ItemsPayByIndex(i)
												.ItemPayToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeleteItemsPay = true;

										fbwD.append(tryEA2D
												.get_ItemsPayByIndex(i)
												.ItemPayToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fItemsPay_No + "	"
											+ fItemsPay_Lname + "	"
											+ fItemsPay_Fname);
									FindAndupdated = true;
									fbwD.newLine();
								}

							} else// if last line is changed:
							{

								if (tryEA2D.get_ItemsPayByIndex(i)
										.get_ItemPay_No() != searchByID) {

									if (i < tryEA2D.NumberOfLines - 1) {
										Cope_and_noDeleteItemsPay = true;

										fbwD.append(tryEA2D
												.get_ItemsPayByIndex(i)
												.ItemPayToString());
										fbwD.newLine();
									} else {
										Cope_and_noDeleteItemsPay = true;

										fbwD.append(tryEA2D
												.get_ItemsPayByIndex(i)
												.ItemPayToString());
										fbwD.newLine();
									}

								} else {
									fbwD.append(fItemsPay_No + "	"
											+ fItemsPay_Lname + "	"
											+ fItemsPay_Fname);
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
						lblItemsPayForm
								.setText(" The ItemsPay have   been updated.");

						// show on screen:

						//

					}
					// if not find:
					else {
						lblItemsPayForm
								.setText("This ItemsPay not find in the file.");
						ItemsPay_DeductionPer.setText("");
						textField_ItemsPay_Title.setText("");

					}

					//

					// ###################################
					// begin delete:
					// remove all text in the file:
					// FileWriter filewriter1=new FileWriter("ItemsPay.in");
					// try:

					//

					// end update
				}
			}
		});
		btnUpdateItemsPay.setBounds(450, 171, 150, 30);
		contentPane.add(btnUpdateItemsPay);

		JButton btnSearchItemsPay = new JButton("Search ItemsPay");
		btnSearchItemsPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// the ItemsPay you want to search:
				ItemsPay searchedItemsPay = null;
				// if searched:
				boolean notSearched = true;

				int searchByID = Integer.parseInt(textField_ItemsPay_No
						.getText());

				// start search:
				lblItemsPayForm.setText("Searching from  ItemsPay forms:");
				try {

					ItemsPayReadintoArray tryEA2 = new ItemsPayReadintoArray();

					for (int i = 0; i < tryEA2.lineCounter("ItemsPay.in"); i++) {
						if (tryEA2.get_ItemsPayByIndex(i).get_ItemPay_No() == searchByID) {
							searchedItemsPay = tryEA2
									.get_ItemsPayByIndex(i);
							notSearched = false;// if searched any one time:

						}
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// if find:
				if (notSearched) {
					lblItemsPayForm
							.setText(" ItemsPay(s) have not been Search.");

					ItemsPay_DeductionPer.setText("");
					textField_ItemsPay_Title.setText("");

				}
				// if not find:
				else {
					lblItemsPayForm
							.setText(" ItemsPay(s) have been Search.");
					// show on screen:
					System.out.println(searchedItemsPay.ItemPayToString());
					// show sharched on form:
					textField_ItemsPay_No.setText(""
							+ (searchedItemsPay.get_ItemPay_No()));
					ItemsPay_DeductionPer.setText(searchedItemsPay
							.get_ItemPay_DeductionPer());
					textField_ItemsPay_Title.setText(searchedItemsPay
							.get_ItemPay_Title());

				}

				//

			}
		});
		btnSearchItemsPay.setBounds(300, 171, 150, 30);
		contentPane.add(btnSearchItemsPay);

		JLabel Lable_ItemsPay_No = new JLabel("ItemsPay ID:");
		Lable_ItemsPay_No.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_ItemsPay_No.setBounds(150, 69, 150, 30);
		contentPane.add(Lable_ItemsPay_No);

		textField_ItemsPay_No = new JTextField();
		textField_ItemsPay_No.setBounds(300, 69, 150, 30);
		contentPane.add(textField_ItemsPay_No);
		textField_ItemsPay_No.setColumns(10);

		ItemsPay_DeductionPer = new JTextField();
		ItemsPay_DeductionPer.setColumns(10);
		ItemsPay_DeductionPer.setBounds(300, 136, 150, 30);
		contentPane.add(ItemsPay_DeductionPer);

		JLabel Lable_ItemsPay_DeductionPer = new JLabel("Enter  Deduction (%):");
		Lable_ItemsPay_DeductionPer.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_ItemsPay_DeductionPer.setBounds(137, 136, 163, 30);
		contentPane.add(Lable_ItemsPay_DeductionPer);

		JLabel Lable_ItemsPay_Title = new JLabel(
				"Enter ItemsPay's Title:");
		Lable_ItemsPay_Title.setHorizontalAlignment(SwingConstants.RIGHT);
		Lable_ItemsPay_Title.setBounds(150, 102, 150, 30);
		contentPane.add(Lable_ItemsPay_Title);

		textField_ItemsPay_Title = new JTextField();
		textField_ItemsPay_Title.setColumns(10);
		textField_ItemsPay_Title.setBounds(300, 102, 150, 30);
		contentPane.add(textField_ItemsPay_Title);

		lblItemsPayForm = new JLabel("Note:Don't input 100 and 101 items, because they are done by computer autometiclly:");
		lblItemsPayForm.setBounds(31, 11, 546, 47);
		contentPane.add(lblItemsPayForm);
	}

	public static void doItemsPay() throws NullPointerException, IOException {

		ItemsPayReadintoArray theItemsPayRead = new ItemsPayReadintoArray();

		oldTextOfItemsPay = theItemsPayRead.get_OriginalText();
		// !!!for text
		// oldTextOfItemsPay = "9	9	9	9	9	9	9	9";
		// System.out.println(oldTextOfItemsPay);
	}

	public String ReturnOldText() throws NullPointerException, IOException {
		// return ItemsPay.in
		ItemsPayReadintoArray theItemsPayRead = new ItemsPayReadintoArray();

		String theOldTextOfItemsPay = theItemsPayRead.get_OriginalText();

		return theOldTextOfItemsPay;
	}

	public boolean checkIfnotexist() {

		boolean isSearched = false;

		// the ItemsPay you want to search:
		ItemsPay searchedItemsPay = null;
		// if searched:
		boolean notSearched = true;

		int searchByID = Integer.parseInt(textField_ItemsPay_No.getText());

		// start search:
		lblItemsPayForm.setText("Searching from  ItemsPay forms:");
		try {

			ItemsPayReadintoArray tryEA2 = new ItemsPayReadintoArray();

			for (int i = 0; i < tryEA2.NumberOfLines; i++) {
				if (tryEA2.get_ItemsPayByIndex(i).get_ItemPay_No() == searchByID) {
					searchedItemsPay = tryEA2.get_ItemsPayByIndex(i);
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
			lblItemsPayForm.setText(" ItemsPay(s) have not been Search.");

		}
		// if not find:
		else {
			lblItemsPayForm.setText(" ItemsPay(s) have been Search.");
			// show on screen:
			System.out.println(searchedItemsPay.ItemPayToString());
			// show sharched on form:
			textField_ItemsPay_No.setText(""
					+ (searchedItemsPay.get_ItemPay_No()));
			ItemsPay_DeductionPer.setText(searchedItemsPay
					.get_ItemPay_DeductionPer());
			textField_ItemsPay_Title.setText(searchedItemsPay
					.get_ItemPay_Title());

		}

		//

		return notSearched;
	}

	public void cleanAndWriteItemsPayToFile() {

	}

	public boolean TextFieldsNotAllFilled() {
		/*
		 * This method is use for check if all the test fields, Not All
		 * Filled,or all filled. if not all filled, return true: even if only
		 * one is empty, return true
		 */
		boolean notfullAllFields;
		notfullAllFields = ((textField_ItemsPay_No.getText().equals(""))
				|| (textField_ItemsPay_Title.getText().equals("")) || (ItemsPay_DeductionPer
				.getText().equals("")));

		return notfullAllFields;
		//
	}
	public  int lineCounter(String filename) throws IOException,NullPointerException
    {
       int lineCount_int = 0;
       File inFile = new File(filename);
       try
       {
          Scanner file = new Scanner(inFile);
          while((file.hasNext()))
          {
             String t = file.nextLine();
             lineCount_int++;
          }
       }
       catch(IOException e)
       {
       }
       return lineCount_int;
    }
     
}
