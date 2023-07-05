package university.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.toedter.calendar.JDateChooser;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class AddTeacher extends JFrame implements ActionListener{
	JTextField tfName,tfFName,tfAddress,tfPhone,tfEmail,tfX,tfXii,tfAadhar;
	JLabel labelEmpid;
	JDateChooser dcdob;
	JButton submit,cancel;
	@SuppressWarnings("rawtypes")
	JComboBox cbCourse,cbBranch;
	Random ran=new Random();
	long first4=Math.abs(ran.nextLong()% 9000L)+1000L;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	AddTeacher(){
		setSize(900,600);
		setLocation(250,50);
		setLayout(null);
		
		JLabel heading= new JLabel("New Teacher Details");
		heading.setBounds(300, 30, 500, 50);
		heading.setFont(new Font("Elephant",Font.BOLD,30));
		add(heading);
		
		JLabel lblName= new JLabel("Name");
		lblName.setBounds(50, 100, 150, 20);
		lblName.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblName);
		tfName=new JTextField();
		tfName.setBounds(200,100,150,20);
		add(tfName);
		
		JLabel lblFName= new JLabel("Father's Name");
		lblFName.setBounds(450, 100, 150, 20);
		lblFName.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblFName);
		tfFName=new JTextField();
		tfFName.setBounds(600,100,150,20);
		add(tfFName);
		
		JLabel lblEmpid= new JLabel("Employee id");
		lblEmpid.setBounds(50, 150, 150, 20);
		lblEmpid.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblEmpid);
		
		labelEmpid= new JLabel("2023"+first4);
		labelEmpid.setBounds(200, 150, 150, 20);
		labelEmpid.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add( labelEmpid);
		
		JLabel lbldob= new JLabel("Date of Birth");
		lbldob.setBounds(450, 150, 150, 20);
		lbldob.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lbldob);
		dcdob=new JDateChooser();
		dcdob.setBounds(600,150,150,20);
		add(dcdob);
		
		JLabel lblAddress= new JLabel("Address");
		lblAddress.setBounds(50, 200, 150, 20);
		lblAddress.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblAddress);
		tfAddress=new JTextField();
		tfAddress.setBounds(200,200,150,20);
		add(tfAddress);
		
		
		
		JLabel lblPhoneno= new JLabel("Phone Number");
		lblPhoneno.setBounds(450, 200, 150, 20);
		lblPhoneno.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblPhoneno);
		tfPhone=new JTextField();
		tfPhone.setBounds(600, 200, 150, 20);
		add(tfPhone);
		
		JLabel lblEmail= new JLabel("Email");
		lblEmail.setBounds(50, 250, 150, 20);
		lblEmail.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblEmail);
		tfEmail=new JTextField();
		tfEmail.setBounds(200,250,150,20);
		add(tfEmail);
		
		
		
		JLabel lblX= new JLabel("Class X mark(%)");
		lblX.setBounds(450, 250, 150, 20);
		lblX.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblX);
		tfX=new JTextField();
		tfX.setBounds(600, 250, 150, 20);
		add(tfX);

		JLabel lblXii= new JLabel("Class XII mark(%)");
		lblXii.setBounds(50, 300, 150, 20);
		lblXii.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblXii);
		tfXii=new JTextField();
		tfXii.setBounds(200,300,150,20);
		add(tfXii);
		
		JLabel lblAadhar= new JLabel("Adhar number");
		lblAadhar.setBounds(450, 300, 150, 20);
		lblAadhar.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblAadhar);
		tfAadhar=new JTextField();
		tfAadhar.setBounds(600, 300, 150, 20);
		add(tfAadhar);
		
		JLabel lblQua= new JLabel("Qualification");
		lblQua.setBounds(50, 350, 150, 20);
		lblQua.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblQua);
		String course[]= {"BSC","BA","BCOMM","MSC","MA","MCOMM","PHD"};
		cbCourse=new JComboBox(course);
		cbCourse.setBounds(200,350,150,20);
		add(cbCourse);
		
		JLabel lblDept= new JLabel("Department");
		lblDept.setBounds(450, 350, 150, 20);
		lblDept.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		add(lblDept);
		
		String branch[]= {"ITM","IST","DSM","Physics","chemistry","Mathmatics","English",
							"Odia","History","Commerse","MBA","MCA","Hindi","Sanskrit","Botny","Zeeology"};
		cbBranch=new JComboBox(branch);
		cbBranch.setBounds(600,350,150,20);
		add(cbBranch);
		
		submit=new JButton("Submit");
		submit.setBounds(250,450, 100,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Elephant",Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(500,450, 100,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Elephant",Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== submit) {
			String name=tfName.getText();
			String fName=tfFName.getText();
			String empid=labelEmpid.getText();
			String dob=((JTextField)(dcdob.getDateEditor().getUiComponent())).getText();
			String address=tfAddress.getText();
			String phone=tfPhone.getText();
			String email=tfEmail.getText();
			String xPer=tfX.getText();
			String xiiPer=tfXii.getText();
			String aadhar=tfAadhar.getText();
			String highQua=(String)cbCourse.getSelectedItem();
			String dept=(String)cbBranch.getSelectedItem();
			
			Connection con=Conn.getConnection();
			String query="Insert into Teacher values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement pstm=con.prepareStatement(query);
				pstm.setString(1,name);
				pstm.setString(2,fName);
				pstm.setString(3,empid);
				pstm.setString(4,dob);
				pstm.setString(5,address);
				pstm.setString(6,phone);
				pstm.setString(7,email);
				pstm.setString(8,xPer);
				pstm.setString(9,xiiPer);
				pstm.setString(10,aadhar);
				pstm.setString(11,highQua);
				pstm.setString(12,dept);
				int check=pstm.executeUpdate();
				if(check!=0) {
					JOptionPane.showMessageDialog(null,"Teacher Details inserted successfully");
					setVisible(false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			setVisible(false);
		}
		
	}


}
