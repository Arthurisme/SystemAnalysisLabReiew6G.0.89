package SystemAnalysisLabReiew6G;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DepartmentForm extends JFrame {

	private JPanel contentPane;
	private JTextField Location_textField;
	private JTextField DepartmentId_textField;
	private JTextField DepartmentName_textField;
	private String sql="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentForm frame = new DepartmentForm();
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
	public DepartmentForm() {
		setTitle("Department Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Department ID:");
		lblNewLabel.setBounds(190, 14, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Department's Location:");
		lblNewLabel_1.setBounds(128, 76, 181, 14);
		contentPane.add(lblNewLabel_1);
		
		Location_textField = new JTextField();
		Location_textField.setBounds(299, 73, 128, 20);
		contentPane.add(Location_textField);
		Location_textField.setColumns(10);
		
		DepartmentId_textField = new JTextField();
		DepartmentId_textField.setBounds(298, 11, 129, 20);
		contentPane.add(DepartmentId_textField);
		DepartmentId_textField.setColumns(10);
		
		JLabel lblDepartmentsName = new JLabel("Enter Department's Name:");
		lblDepartmentsName.setBounds(141, 42, 181, 14);
		contentPane.add(lblDepartmentsName);
		
		DepartmentName_textField = new JTextField();
		DepartmentName_textField.setBounds(298, 39, 129, 20);
		contentPane.add(DepartmentName_textField);
		DepartmentName_textField.setColumns(10);
		
		JButton Add_Button = new JButton("Add Department");
		Add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDepartment();
			}
		});
		Add_Button.setBounds(10, 101, 140, 23);
		contentPane.add(Add_Button);
		
		JButton DeleteDepartmentButton = new JButton("Delete Department");
		DeleteDepartmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDepartmentInfo();
			}
		});
		DeleteDepartmentButton.setBounds(158, 101, 140, 23);
		contentPane.add(DeleteDepartmentButton);
		
		JButton SearchDepartmentButton = new JButton("Search Department");
		SearchDepartmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchDepartment();
			}
		});
		SearchDepartmentButton.setBounds(308, 101, 168, 23);
		contentPane.add(SearchDepartmentButton);
		
		JButton UpdateDepartment_Button = new JButton("Update Department");
		UpdateDepartment_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateDepartmentInfo();
			}
		});
		UpdateDepartment_Button.setBounds(487, 101, 168, 23);
		contentPane.add(UpdateDepartment_Button);
	}
	
	public void addDepartment(){
		//System.out.println("add");
		try{
		Department Department1=new Department();
		Department1.set_Department_id(Integer.parseInt(DepartmentId_textField.getText()));
		Department1.set_Department_Name(DepartmentName_textField.getText());
		Department1.set_Department_Location(Location_textField.getText());

		
		
		
		
		DepartmentAction eA1=new DepartmentAction();
		sql="insert into Department values ("+Integer.parseInt(DepartmentId_textField.getText())+",'"+DepartmentName_textField.getText()
				+"','"+Location_textField.getText()+"')";
		
		//System.out.println("newSql="+sql);
		eA1.insert(sql,Department1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public void searchDepartment(){
		
		if((DepartmentId_textField.getText().trim()).equals("")){
			System.out.println("No ID!");
		}else{
			sql="";
			sql="select * from Department where d_id="+Integer.parseInt(DepartmentId_textField.getText());
			DepartmentAction eA1=new DepartmentAction();
			Department searchResult=new Department();
			searchResult=eA1.search(sql);
			DepartmentName_textField.setText(searchResult.get_Department_Name());
			Location_textField.setText(searchResult.get_Department_Location());
			
		}
	}
	
	public void deleteDepartmentInfo(){
		try{
			Department Department1=new Department();
			Department1.set_Department_id(Integer.parseInt(DepartmentId_textField.getText()));
			
			DepartmentAction dA1=new DepartmentAction();
			sql="delete Department where d_id="+Integer.parseInt(DepartmentId_textField.getText());
			
			
			dA1.delete(sql, Department1);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void updateDepartmentInfo(){
		//System.out.println("add");
		try{
		Department Department1=new Department();
		Department1.set_Department_id(Integer.parseInt(DepartmentId_textField.getText()));
		Department1.set_Department_Name(DepartmentName_textField.getText().trim());
		Department1.set_Department_Location(Location_textField.getText().trim());

		
		
		
		
		DepartmentAction ed1=new DepartmentAction();
		sql="update Department set d_name='"+DepartmentName_textField.getText().trim()+"',d_location='"+Location_textField.getText().trim()
				+"' where d_id="+Integer.parseInt(DepartmentId_textField.getText());

		
		
		ed1.update(sql, Department1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}

}
