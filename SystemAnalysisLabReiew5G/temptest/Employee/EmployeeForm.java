package Employee;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField ID_textField;
	private JTextField FN_textField;
	private JTextField Position_textField;
	private JTextField Qa_textField;
	private JLabel lblEnterEmployeesName;
	private JLabel lblEnterEmployeesSin;
	private JLabel lblEnterEmployeesHiredate;
	private JLabel lblEnterEmployeesDepartment;
	private JTextField DepartID_textField;
	private JTextField HR_textField;
	private JTextField SSN_textField;
	private JTextField LN_textField;
	String sql;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
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
	public EmployeeForm() {
		setTitle("Employee Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(96, 75, 95, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEnterEmployeesFirst = new JLabel("Enter Employee's First Name:");
		lblEnterEmployeesFirst.setBounds(18, 100, 191, 14);
		contentPane.add(lblEnterEmployeesFirst);
		
		JLabel lblEnterEmployeesPosition = new JLabel("Enter Employee's Position:");
		lblEnterEmployeesPosition.setBounds(28, 125, 209, 14);
		contentPane.add(lblEnterEmployeesPosition);
		
		JLabel lblEnterEmployeesQualification = new JLabel("Enter Employee's Qualification:");
		lblEnterEmployeesQualification.setBounds(10, 150, 207, 14);
		contentPane.add(lblEnterEmployeesQualification);
		
		ID_textField = new JTextField();
		ID_textField.setBounds(217, 66, 86, 20);
		contentPane.add(ID_textField);
		ID_textField.setColumns(10);
		
		FN_textField = new JTextField();
		FN_textField.setBounds(217, 94, 86, 20);
		contentPane.add(FN_textField);
		FN_textField.setColumns(10);
		
		Position_textField = new JTextField();
		Position_textField.setBounds(217, 119, 86, 20);
		contentPane.add(Position_textField);
		Position_textField.setColumns(10);
		
		Qa_textField = new JTextField();
		Qa_textField.setBounds(217, 144, 86, 20);
		contentPane.add(Qa_textField);
		Qa_textField.setColumns(10);
		
		lblEnterEmployeesName = new JLabel("Enter Employee's Name:");
		lblEnterEmployeesName.setBounds(357, 75, 176, 14);
		contentPane.add(lblEnterEmployeesName);
		
		lblEnterEmployeesSin = new JLabel("Enter Employee's SIN:");
		lblEnterEmployeesSin.setBounds(367, 100, 169, 14);
		contentPane.add(lblEnterEmployeesSin);
		
		lblEnterEmployeesHiredate = new JLabel("Enter Employee's HireDate:");
		lblEnterEmployeesHiredate.setBounds(344, 125, 189, 14);
		contentPane.add(lblEnterEmployeesHiredate);
		
		lblEnterEmployeesDepartment = new JLabel("Enter Employee's Department ID:");
		lblEnterEmployeesDepartment.setBounds(313, 150, 204, 14);
		contentPane.add(lblEnterEmployeesDepartment);
		
		DepartID_textField = new JTextField();
		DepartID_textField.setColumns(10);
		DepartID_textField.setBounds(527, 153, 86, 20);
		contentPane.add(DepartID_textField);
		
		HR_textField = new JTextField();
		HR_textField.setColumns(10);
		HR_textField.setBounds(527, 128, 86, 20);
		contentPane.add(HR_textField);
		
		SSN_textField = new JTextField();
		SSN_textField.setColumns(10);
		SSN_textField.setBounds(527, 103, 86, 20);
		contentPane.add(SSN_textField);
		
		LN_textField = new JTextField();
		LN_textField.setColumns(10);
		LN_textField.setBounds(527, 75, 86, 20);
		contentPane.add(LN_textField);
		
		JButton Add_Button = new JButton("Add Employee");
		Add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Add_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("mouseClicked");
				addEmployeeInfo();
			}
		});
		Add_Button.setBounds(39, 175, 122, 23);
		contentPane.add(Add_Button);
		
		JButton Delete_Button = new JButton("Delete Employee");
		Delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteEmployeeInfo();
			}
		});
		Delete_Button.setBounds(191, 175, 128, 23);
		contentPane.add(Delete_Button);
		
		JButton Search_Button = new JButton("Search Employee");
		Search_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Search_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchEmployeeInfo();
			}
		});
		Search_Button.setBounds(329, 175, 137, 23);
		contentPane.add(Search_Button);
		
		JButton Update_Button = new JButton("Update Employee");
		Update_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateEmployeeInfo();
			}
		});

		
		Update_Button.setBounds(476, 175, 137, 23);
		contentPane.add(Update_Button);
		
		JLabel lblNewLabel = new JLabel("DD-MM-YYYY");
		lblNewLabel.setBounds(623, 132, 77, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void addEmployeeInfo(){
		//System.out.println("add");
		try{
		EmployeeInfoBean employeeInfoBean1=new EmployeeInfoBean();
		employeeInfoBean1.setEmp_id(Integer.parseInt(ID_textField.getText()));
		employeeInfoBean1.setEmp_fname(FN_textField.getText().trim());
		employeeInfoBean1.setEmp_lname(LN_textField.getText().trim());
		employeeInfoBean1.setEmp_Ssn(SSN_textField.getText().trim());
		employeeInfoBean1.setEmp_position(Integer.parseInt(Position_textField.getText()));
		employeeInfoBean1.setEmp_hireDate(HR_textField.getText());
		employeeInfoBean1.setEmp_QualId(Integer.parseInt(Qa_textField.getText()));
		employeeInfoBean1.setD_id(Integer.parseInt(DepartID_textField.getText()));
		
		
		
		
		EmployeeInfoBeanAction eA1=new EmployeeInfoBeanAction();
		sql="insert into EmployeeInfo values ("+Integer.parseInt(ID_textField.getText())+",'"+FN_textField.getText()
				+"','"+LN_textField.getText()+"','"+SSN_textField.getText()+"',"+Integer.parseInt(Position_textField.getText())
				+",to_date('"+HR_textField.getText()+"','DD-MM-YYYY'),"+Integer.parseInt(Qa_textField.getText())+","
				+Integer.parseInt(DepartID_textField.getText())+")";
		
		//System.out.println("newSql="+sql);
		eA1.insert(sql,employeeInfoBean1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public void searchEmployeeInfo(){
		
		if((ID_textField.getText().trim()).equals("")){
			System.out.println("No ID!");
		}else{
			sql="";
			sql="select * from EmployeeInfo where emp_id="+Integer.parseInt(ID_textField.getText());
			EmployeeInfoBeanAction eA1=new EmployeeInfoBeanAction();
			EmployeeInfoBean searchResult=new EmployeeInfoBean();
			searchResult=eA1.search(sql);
			FN_textField.setText(searchResult.getEmp_fname());
			HR_textField.setText(searchResult.getEmp_hireDate());
			LN_textField.setText(searchResult.getEmp_lname());
			SSN_textField.setText(searchResult.getEmp_Ssn());
			Position_textField.setText(""+searchResult.getEmp_position());
			Qa_textField.setText(""+searchResult.getEmp_QualId());
			DepartID_textField.setText(""+searchResult.getD_id());
		}
	}
	
	public void deleteEmployeeInfo(){
		try{
			EmployeeInfoBean employeeInfoBean1=new EmployeeInfoBean();
			employeeInfoBean1.setEmp_id(Integer.parseInt(ID_textField.getText()));
			
			EmployeeInfoBeanAction eA1=new EmployeeInfoBeanAction();
			sql="delete EmployeeInfo where emp_id="+Integer.parseInt(ID_textField.getText());
			
			//System.out.println("newSql="+sql);
			eA1.delete(sql, employeeInfoBean1);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void updateEmployeeInfo(){
		//System.out.println("add");
		try{
		EmployeeInfoBean employeeInfoBean1=new EmployeeInfoBean();
		employeeInfoBean1.setEmp_id(Integer.parseInt(ID_textField.getText()));
		employeeInfoBean1.setEmp_fname(FN_textField.getText().trim());
		employeeInfoBean1.setEmp_lname(LN_textField.getText().trim());
		employeeInfoBean1.setEmp_Ssn(SSN_textField.getText().trim());
		employeeInfoBean1.setEmp_position(Integer.parseInt(Position_textField.getText()));
		employeeInfoBean1.setEmp_hireDate(HR_textField.getText());
		employeeInfoBean1.setEmp_QualId(Integer.parseInt(Qa_textField.getText()));
		employeeInfoBean1.setD_id(Integer.parseInt(DepartID_textField.getText()));
		
		
		
		
		EmployeeInfoBeanAction eA1=new EmployeeInfoBeanAction();
		sql="update EmployeeInfo set emp_fname='"+FN_textField.getText()+"',emp_lname='"+LN_textField.getText()
				+"',emp_Ssn='"+SSN_textField.getText()+"',emp_position="+Integer.parseInt(Position_textField.getText())
				+",emp_hireDate=to_date('"+HR_textField.getText()+"','DD-MM-YYYY'),emp_QualId="+Integer.parseInt(Qa_textField.getText())
				+",d_id="+Integer.parseInt(DepartID_textField.getText())+" where emp_id="+Integer.parseInt(ID_textField.getText());

		
		//System.out.println("newSql="+sql);
		eA1.update(sql, employeeInfoBean1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
