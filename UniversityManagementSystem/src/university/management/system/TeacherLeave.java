package university.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
@SuppressWarnings("serial")
public class  TeacherLeave extends JFrame implements ActionListener{
	Choice cEmpid,cTime;
	JDateChooser dcDate;
	JTextField tfReason;
	JButton submit,cancel;
	 TeacherLeave(){
		setSize(475,500);
		setLocation(400,100);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading= new JLabel("Apply Leave (Teacher) ");
		heading.setBounds(60, 30, 400, 30);
		heading.setFont(new Font("Elephant",Font.BOLD,30));
		add(heading);
		
		JLabel lblEmpid=new JLabel("Search by employee id");
		lblEmpid.setBounds(50,100, 200, 20);
		add(lblEmpid);
		
		cEmpid=new Choice();
		cEmpid.setBounds(250,100, 150, 20);
		add(cEmpid);
		
		try {
			Connection con=Conn.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select empid from teacher");
			while(rs.next()) {
				cEmpid.add(rs.getString(1));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblDate= new JLabel("Date");
		lblDate.setBounds(50, 150, 150, 20);
		add(lblDate);
		dcDate=new JDateChooser();
		dcDate.setBounds(250,150,150,20);
		add(dcDate);
		
		JLabel lblTime= new JLabel("Time Duration");
		lblTime.setBounds(50, 200, 150, 20);
		add(lblTime);
		cTime= new Choice();
		cTime.setBounds(250,200,150,20);
		cTime.add("Full Day");
		cTime.add("Half Day");
		add(cTime);
		
		JLabel lblReason= new JLabel("Reason of leave");
		lblReason.setBounds(50, 250, 150, 20);
		add(lblReason);
		
		tfReason=new JTextField();
		tfReason.setBounds(250, 250, 150, 75);
		add(tfReason);
		
		
		submit=new JButton("Submit");
		submit.setBounds(100,350, 100,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Elephant",Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(250,350, 100,30);
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
			String empid=cEmpid.getSelectedItem();
			String date=((JTextField)dcDate.getDateEditor().getUiComponent()).getText();
			String duration=cTime.getSelectedItem();
			String reason=tfReason.getText();
			
			Connection con=Conn.getConnection();
			String query="Insert into TeacherLeave values(?,?,?,?)";
			
			try {
				PreparedStatement pstm=con.prepareStatement(query);
				pstm.setString(1,empid);
				pstm.setString(2,date);
				pstm.setString(3,duration);
				pstm.setString(4,reason);
				
				int check=pstm.executeUpdate();
				if(check!=0) {
					JOptionPane.showMessageDialog(null,"Leave request recorded successfully");
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
