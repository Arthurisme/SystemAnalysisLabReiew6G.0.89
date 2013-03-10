package SysAnaLabreview4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class A_This_Is_The_Main_Run_Here_Testing_TheLabReview4 extends JFrame {
	static double copyvalue = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_This_Is_The_Main_Run_Here_Testing_TheLabReview4 frame = new A_This_Is_The_Main_Run_Here_Testing_TheLabReview4();
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
	public A_This_Is_The_Main_Run_Here_Testing_TheLabReview4() {

		try {
			testFilesExist();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setTitle("Pay Roll Application Lab Review 4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 340);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu jMenu1 = new JMenu("InputDate");
		menuBar.add(jMenu1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Employee");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// show employee infor form:
				EmployeeInfomationForm theEmployeeForm = new EmployeeInfomationForm();
				theEmployeeForm.setVisible(true);

			}
		});
		jMenu1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Department");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// show Department information form:
				DepartmentInfomationForm theDepartmentForm = new DepartmentInfomationForm();
				theDepartmentForm.setVisible(true);
			}
		});
		jMenu1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Position");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				// show Department information form:
				PositionInfomationForm thePositionForm = new PositionInfomationForm();
				thePositionForm.setVisible(true);
			}
		});
		jMenu1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Qualification");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				// show Qualification infor form:
				QualificationInfomationForm theQualificationForm = new QualificationInfomationForm();
				theQualificationForm.setVisible(true);

			}
		});
		jMenu1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Items Pay");
		mntmNewMenuItem_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// show ItemsPay infor form:
				ItemsPayInfomationForm theItemsPayForm = new ItemsPayInfomationForm();
				theItemsPayForm.setVisible(true);
			}
		});
		jMenu1.add(mntmNewMenuItem_6);

		JMenu jMenu2 = new JMenu("OutputPayRoll");
		menuBar.add(jMenu2);

		JMenuItem jMenuItem6 = new JMenuItem("OutputPayStub");
		jMenuItem6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				// output employee pay:

				CalculateEmployeePayForm TheEmpPayForm = new CalculateEmployeePayForm();
				TheEmpPayForm.setVisible(true);

			}
		});
		jMenu2.add(jMenuItem6);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ListAllEmployeePayStub");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				// open the list of emp and pay details:

				ListAllEmployeePayStub theListAllEmpPay;
				try {
					theListAllEmpPay = new ListAllEmployeePayStub();

					theListAllEmpPay.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		jMenu2.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGap(0, 388, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGap(0, 275, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);

	}

	public void testFilesExist() throws IOException {
		// check if the file exist:
		File filetryyy = new File("tryyy.in");
		boolean existstryyy = filetryyy.exists();
		if (!existstryyy) {
			// build the file:
			FileWriter fstream;
			fstream = new FileWriter("tryyy.in");
			// BufferedWriter fbw = new BufferedWriter(fstream);
			fstream.close();
			// It returns false if File or directory does not exist

			System.out
					.println("the file or directory  you are searching does not exist : "
							+ existstryyy);

		} else {
			// It returns true if File or directory exists
			System.out
					.println("the file or  directory you are searching does exist : "
							+ existstryyy);
		}
		// #End check if the file exist:try
		
		File fileEmployee = new File("Employee.in");
		boolean existsEmployee = fileEmployee.exists();
		if (!existsEmployee) {
			// build the file:
			FileWriter fstream;
			fstream = new FileWriter("Employee.in");
			// BufferedWriter fbw = new BufferedWriter(fstream);
			fstream.close();
			// It returns false if File or directory does not exist

			System.out
					.println("the file or directory  you are searching does not exist : "
							+ existsEmployee);

		} else {
			// It returns true if File or directory exists
			System.out
					.println("the file or  directory you are searching does exist : "
							+ existsEmployee);
		}
		// #End check if the file exist:employee
		File fileDepartment = new File("Department.in");
		boolean existsDepartment = fileDepartment.exists();
		if (!existsDepartment) {
			// build the file:
			FileWriter fstream;
			fstream = new FileWriter("Department.in");
			// BufferedWriter fbw = new BufferedWriter(fstream);
			fstream.close();
			// It returns false if File or directory does not exist

			System.out
					.println("the file or directory  you are searching does not exist : "
							+ existsDepartment);

		} else {
			// It returns true if File or directory exists
			System.out
					.println("the file or  directory you are searching does exist : "
							+ existsDepartment);
		}
		// #End check if the file exist:Department
		File ItemsPay = new File("ItemsPay.in");
		boolean existsItemsPay = ItemsPay.exists();
		if (!existsItemsPay) {
			// build the file:
			FileWriter fstream;
			fstream = new FileWriter("ItemsPay.in");
			// BufferedWriter fbw = new BufferedWriter(fstream);
			fstream.close();
			// It returns false if File or directory does not exist

			System.out
					.println("the file or directory  you are searching does not exist : "
							+ existsItemsPay);

		} else {
			// It returns true if File or directory exists
			System.out
					.println("the file or  directory you are searching does exist : "
							+ existsItemsPay);
		}
		// #End check if the file exist:ItemsPay
		
		File filePosition = new File("Position.in");
		boolean existsPosition = filePosition.exists();
		if (!existsPosition) {
			// build the file:
			FileWriter fstream;
			fstream = new FileWriter("Position.in");
			// BufferedWriter fbw = new BufferedWriter(fstream);
			fstream.close();
			// It returns false if File or directory does not exist

			System.out
					.println("the file or directory  you are searching does not exist : "
							+ existsPosition);

		} else {
			// It returns true if File or directory exists
			System.out
					.println("the file or  directory you are searching does exist : "
							+ existsPosition);
		}
		// #End check if the file exist:Position
		
		File fileQualification = new File("Qualification.in");
		boolean existsQualification = fileQualification.exists();
		if (!existsQualification) {
			// build the file:
			FileWriter fstream;
			fstream = new FileWriter("Qualification.in");
			// BufferedWriter fbw = new BufferedWriter(fstream);
			fstream.close();
			// It returns false if File or directory does not exist

			System.out
					.println("the file or directory  you are searching does not exist : "
							+ existsQualification);

		} else {
			// It returns true if File or directory exists
			System.out
					.println("the file or  directory you are searching does exist : "
							+ existsQualification);
		}
		// #End check if the file exist:Qualification
		
		

	}
}
