package SystemAnalysisLabReview5;
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


public class ItemForm extends JFrame {

	private JPanel contentPane;
	private JTextField ItemPayRate_textField;
	private JTextField ItemPayNo_textField;
	private JTextField ItemPayTitle_textField;
	private String sql="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemForm frame = new ItemForm();
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
	public ItemForm() {
		setTitle("Item Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItempayNo = new JLabel("ItemPay No:");
		lblItempayNo.setBounds(73, 31, 105, 14);
		contentPane.add(lblItempayNo);
		
		JLabel lblEnterItempayRate = new JLabel("Enter ItemPay Rate:");
		lblEnterItempayRate.setBounds(35, 54, 125, 14);
		contentPane.add(lblEnterItempayRate);
		
		JButton AddItemPay_Button = new JButton("Add ItemPay");
		AddItemPay_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});
		AddItemPay_Button.setBounds(10, 79, 140, 23);
		contentPane.add(AddItemPay_Button);
		
		JButton DeleteItemPay_button = new JButton("Delete  ItemPay");
		DeleteItemPay_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItemInfo();
			}
		});
		DeleteItemPay_button.setBounds(158, 79, 140, 23);
		contentPane.add(DeleteItemPay_button);
		
		ItemPayRate_textField = new JTextField();
		ItemPayRate_textField.setColumns(10);
		ItemPayRate_textField.setBounds(181, 51, 86, 20);
		contentPane.add(ItemPayRate_textField);
		
		ItemPayNo_textField = new JTextField();
		ItemPayNo_textField.setColumns(10);
		ItemPayNo_textField.setBounds(181, 28, 86, 20);
		contentPane.add(ItemPayNo_textField);
		
		JLabel lblEnterItempayTitle = new JLabel("Enter ItemPay Title:");
		lblEnterItempayTitle.setBounds(295, 31, 140, 14);
		contentPane.add(lblEnterItempayTitle);
		
		ItemPayTitle_textField = new JTextField();
		ItemPayTitle_textField.setColumns(10);
		ItemPayTitle_textField.setBounds(431, 28, 224, 20);
		contentPane.add(ItemPayTitle_textField);
		
		JButton SearchItemPay_Button = new JButton("Search  ItemPay");
		SearchItemPay_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchItem();
			}
		});
		SearchItemPay_Button.setBounds(308, 79, 168, 23);
		contentPane.add(SearchItemPay_Button);
		
		JButton UpdateItemPay_button = new JButton("Update  ItemPay");
		UpdateItemPay_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateItemInfo();
			}
		});
		UpdateItemPay_button.setBounds(487, 79, 168, 23);
		contentPane.add(UpdateItemPay_button);
	}
	
	
	public void addItem(){
		//System.out.println("add");
		try{
		ItemsPay ItemsPay1=new ItemsPay();
		ItemsPay1.set_ItemPay_No(Integer.parseInt(ItemPayNo_textField.getText()));
		ItemsPay1.set_ItemPay_Title(ItemPayTitle_textField.getText());
		ItemsPay1.set_ItemPay_DeductionPer(Double.parseDouble(ItemPayRate_textField.getText()));
	
		
		ItemsPayAction eA1=new ItemsPayAction();
		sql="insert into ItemsPay values ("+Integer.parseInt(ItemPayNo_textField.getText())+",'"+ItemPayTitle_textField.getText()
				+"',"+Double.parseDouble(ItemPayRate_textField.getText())+")";
		
		//System.out.println("newSql="+sql);
		eA1.insert(sql,ItemsPay1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public void searchItem(){
		
		if((ItemPayNo_textField.getText().trim()).equals("")){
			System.out.println("No ID!");
		}else{
			sql="";
			sql="select * from ItemsPay where ItemPay_No="+Integer.parseInt(ItemPayNo_textField.getText());
			ItemsPayAction eA1=new ItemsPayAction();
			ItemsPay searchResult=new ItemsPay();
			searchResult=eA1.search(sql);
			ItemPayTitle_textField.setText(searchResult.get_ItemPay_Title());
			ItemPayRate_textField.setText(""+searchResult.get_ItemPay_DeductionPer());
			
			
		}
	}
	
	public void deleteItemInfo(){
		try{
			ItemsPay ItemsPay1=new ItemsPay();
			ItemsPay1.set_ItemPay_No(Integer.parseInt(ItemPayNo_textField.getText()));
			
			ItemsPayAction dA1=new ItemsPayAction();
			sql="delete ItemsPay where ItemPay_No="+Integer.parseInt(ItemPayNo_textField.getText());
			
			
			dA1.delete(sql, ItemsPay1);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void updateItemInfo(){
		//System.out.println("add");
		try{
			ItemsPay ItemsPay1=new ItemsPay();
			ItemsPay1.set_ItemPay_No(Integer.parseInt(ItemPayNo_textField.getText()));
			ItemsPay1.set_ItemPay_Title(ItemPayTitle_textField.getText());
			ItemsPay1.set_ItemPay_DeductionPer(Double.parseDouble(ItemPayRate_textField.getText()));

		
		
		
		
		ItemsPayAction ed1=new ItemsPayAction();
		sql="update ItemsPay set ItemPay_title='"+ItemPayTitle_textField.getText().trim()+"',ItemPay_rate="+Double.parseDouble(ItemPayRate_textField.getText())
				+" where ItemPay_No="+Integer.parseInt(ItemPayNo_textField.getText());

		
		
		ed1.update(sql, ItemsPay1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!","Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}

}
