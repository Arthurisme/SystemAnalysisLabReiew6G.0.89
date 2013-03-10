package beta2;
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


public class QualificationForm extends JFrame {

	private JPanel contentPane;
	private JTextField QualificationDesc_textField;
	private JTextField QualificationId_textField;
	private String sql="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QualificationForm frame = new QualificationForm();
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
	public QualificationForm() {
		setTitle("Qualification Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQualificationId = new JLabel("Qualification Id:");
		lblQualificationId.setBounds(49, 52, 93, 14);
		contentPane.add(lblQualificationId);
		
		JLabel lblQualificationDescription = new JLabel("Qualification Description:");
		lblQualificationDescription.setBounds(10, 77, 146, 14);
		contentPane.add(lblQualificationDescription);
		
		QualificationDesc_textField = new JTextField();
		QualificationDesc_textField.setBounds(166, 74, 371, 20);
		contentPane.add(QualificationDesc_textField);
		QualificationDesc_textField.setColumns(10);
		
		QualificationId_textField = new JTextField();
		QualificationId_textField.setBounds(166, 49, 86, 20);
		contentPane.add(QualificationId_textField);
		QualificationId_textField.setColumns(10);
		
		JButton AddQualification_Button = new JButton("Add Qualification");
		AddQualification_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addQualification();
			}
		});
		AddQualification_Button.setBounds(10, 118, 131, 23);
		contentPane.add(AddQualification_Button);
		
		JButton DeleteQualification_button = new JButton("Delete Qualification");
		DeleteQualification_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteQualificationInfo();
			}
		});
		DeleteQualification_button.setBounds(144, 118, 146, 23);
		contentPane.add(DeleteQualification_button);
		
		JButton SearchQualification_button = new JButton("Search Qualification");
		SearchQualification_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchQualification();
			}
		});
		SearchQualification_button.setBounds(300, 118, 151, 23);
		contentPane.add(SearchQualification_button);
		
		JButton Updatequalification_button = new JButton("Update Qualification");
		Updatequalification_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateQualificationInfo();
			}
			
		});
		Updatequalification_button.setBounds(461, 118, 165, 23);
		contentPane.add(Updatequalification_button);
	}
	
	public void addQualification(){
		//System.out.println("add");
		try{
		QualificationBean QualificationBean1=new QualificationBean();
		QualificationBean1.setQualificaiton_Id(Integer.parseInt(QualificationId_textField.getText()));
		QualificationBean1.setQualification_description(QualificationDesc_textField.getText());
		

		
		
		
		
		QualificationBeanAction eA1=new QualificationBeanAction();
		sql="insert into Qualification values ("+Integer.parseInt(QualificationId_textField.getText())+",'"+QualificationDesc_textField.getText()
				+"')";
		
		//System.out.println("newSql="+sql);
		eA1.insert(sql,QualificationBean1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public void searchQualification(){
		
		if((QualificationId_textField.getText().trim()).equals("")){
			System.out.println("No ID!");
		}else{
			sql="";
			sql="select * from Qualification where QualId="+Integer.parseInt(QualificationId_textField.getText());
			QualificationBeanAction eA1=new QualificationBeanAction();
			QualificationBean searchResult=new QualificationBean();
			searchResult=eA1.search(sql);
			QualificationDesc_textField.setText(searchResult.getQualification_description());
			
			
		}
	}
	
	public void deleteQualificationInfo(){
		try{
			QualificationBean QualificationBean1=new QualificationBean();
			QualificationBean1.setQualificaiton_Id(Integer.parseInt(QualificationId_textField.getText()));
			
			QualificationBeanAction dP1=new QualificationBeanAction();
			sql="delete Qualification where QualId="+Integer.parseInt(QualificationId_textField.getText());
			
			
			dP1.delete(sql, QualificationBean1);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void updateQualificationInfo(){
		//System.out.println("add");
		try{
		QualificationBean QualificationBean1=new QualificationBean();
		QualificationBean1.setQualificaiton_Id(Integer.parseInt(QualificationId_textField.getText()));
		QualificationBean1.setQualification_description(QualificationDesc_textField.getText().trim());
		
		
		QualificationBeanAction eP1=new QualificationBeanAction();
		sql="update Qualification set QualDesc='"+QualificationDesc_textField.getText().trim()
				+"' where QualId="+Integer.parseInt(QualificationId_textField.getText());

		
		
		eP1.update(sql, QualificationBean1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}

}
