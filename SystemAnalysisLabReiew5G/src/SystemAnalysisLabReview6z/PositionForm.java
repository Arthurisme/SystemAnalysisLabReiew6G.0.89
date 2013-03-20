package SystemAnalysisLabReview6z;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PositionForm extends JFrame {

	private JPanel contentPane;
	private JTextField PositionDesc_textField;
	private JTextField PositionId_textField;
	private String sql="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PositionForm frame = new PositionForm();
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
	public PositionForm() {
		setTitle("Postion Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPositionId = new JLabel("Position Id:");
		lblPositionId.setBounds(166, 41, 93, 14);
		contentPane.add(lblPositionId);
		
		JLabel lblPositionDescription = new JLabel("Position Description:");
		lblPositionDescription.setBounds(127, 66, 146, 14);
		contentPane.add(lblPositionDescription);
		
		JButton AddPosition_button = new JButton("Add Position");
		AddPosition_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPosition();
			}
		});
		AddPosition_button.setBounds(10, 113, 117, 23);
		contentPane.add(AddPosition_button);
		
		PositionDesc_textField = new JTextField();
		PositionDesc_textField.setColumns(10);
		PositionDesc_textField.setBounds(269, 63, 122, 20);
		contentPane.add(PositionDesc_textField);
		
		PositionId_textField = new JTextField();
		PositionId_textField.setColumns(10);
		PositionId_textField.setBounds(269, 38, 122, 20);
		contentPane.add(PositionId_textField);
		
		JButton DeletePosition_button = new JButton("Delete Position");
		DeletePosition_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletePositionInfo();
			}
		});
		DeletePosition_button.setBounds(137, 113, 131, 23);
		contentPane.add(DeletePosition_button);
		
		JButton SearchPosition_button = new JButton("Search Position");
		SearchPosition_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPosition();
			}
		});
		SearchPosition_button.setBounds(278, 113, 146, 23);
		contentPane.add(SearchPosition_button);
		
		JButton UpdatePosition_button = new JButton("Update Position");
		UpdatePosition_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePositionInfo();
			}
		});
		UpdatePosition_button.setBounds(451, 113, 146, 23);
		contentPane.add(UpdatePosition_button);
	}
	
	public void addPosition(){
		//System.out.println("add");
		try{
		Position Position1=new Position();
		Position1.set_Position_id(Integer.parseInt(PositionId_textField.getText()));
		Position1.set_Position_Desc(PositionDesc_textField.getText());

		
		
		PositionAction eA1=new PositionAction();
		sql="insert into Position values ("+Integer.parseInt(PositionId_textField.getText())+",'"+PositionDesc_textField.getText()
				+"')";
		
		//System.out.println("newSql="+sql);
		eA1.insert(sql,Position1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public void searchPosition(){
		
		if((PositionId_textField.getText().trim()).equals("")){
			System.out.println("No ID!");
		}else{
			sql="";
			sql="select * from Position where PositionId="+Integer.parseInt(PositionId_textField.getText());
			PositionAction eA1=new PositionAction();
			Position searchResult=new Position();
			searchResult=eA1.search(sql);
			PositionId_textField.setText(""+searchResult.get_Position_id());
			PositionDesc_textField.setText(searchResult.get_Position_Desc());
			
		}
	}
	
	public void deletePositionInfo(){
		try{
			Position Position1=new Position();
			Position1.set_Position_id(Integer.parseInt(PositionId_textField.getText()));
			
			PositionAction dP1=new PositionAction();
			sql="delete Position where PositionId="+Integer.parseInt(PositionId_textField.getText());
			
			
			dP1.delete(sql, Position1);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void updatePositionInfo(){
		//System.out.println("add");
		try{
		Position Position1=new Position();
		Position1.set_Position_id(Integer.parseInt(PositionId_textField.getText()));
		Position1.set_Position_Desc(PositionDesc_textField.getText().trim());
		
		
		PositionAction eP1=new PositionAction();
		sql="update Position set PosDesc='"+PositionDesc_textField.getText().trim()
				+"' where PositionId="+Integer.parseInt(PositionId_textField.getText());

		
		
		eP1.update(sql, Position1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}


}
