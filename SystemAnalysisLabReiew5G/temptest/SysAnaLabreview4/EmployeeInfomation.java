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

public class EmployeeInfomation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfomation frame = new EmployeeInfomation();
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
	public EmployeeInfomation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 230, 150, 30);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setBounds(150, 230, 150, 30);
		contentPane.add(btnDeleteEmployee);
		
		JButton btnUpdateEmployee = new JButton("update Employee");
		btnUpdateEmployee.setBounds(450, 230, 150, 30);
		contentPane.add(btnUpdateEmployee);
		
		JButton btnSearchEmployee = new JButton("Search Employee");
		btnSearchEmployee.setBounds(300, 230, 150, 30);
		contentPane.add(btnSearchEmployee);
	}
}
