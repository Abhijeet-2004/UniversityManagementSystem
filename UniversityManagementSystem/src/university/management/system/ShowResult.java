package university.management.system;

import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ShowResult  extends JFrame implements ActionListener{
	JButton back;
	ShowResult(String rollno,String semester){
		setSize(600,500);
		setLocation(300,100);
		
		setLayout(null);
		getContentPane().setBackground(Color.yellow);
		
		
		JLabel heading1 = new JLabel("RAVENSHAW  UNIVERSITY");
		heading1.setBounds(50, 10, 500, 30);
		heading1.setFont(new Font("Elephant", Font.BOLD, 30));
		add(heading1);
		
		JLabel heading2 = new JLabel("Result Of Examination-2023");
		heading2.setBounds(180, 50, 500, 30);
		heading2.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		add(heading2);
		
		JLabel lblRoll = new JLabel("Roll Number");
		lblRoll.setBounds(50, 100, 100, 20);
		lblRoll.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		add(lblRoll);
		
		JLabel lblRollData = new JLabel();
		lblRollData.setBounds(240, 100, 100, 20);
		lblRollData.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		lblRollData.setText(rollno);
		add(lblRollData);
		

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(50, 150, 100, 20);
		lblName.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		add(lblName);
		JLabel labelName= new JLabel();
		labelName.setBounds(240, 150, 300, 20);
		labelName.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		add(labelName);
		JLabel lblSem = new JLabel("Semester");
		lblSem.setBounds(50, 200, 100, 20);
		lblSem.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		add(lblSem);
		JLabel labelSem= new JLabel();
		labelSem.setBounds(240, 200, 300, 20);
		labelSem.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		labelSem.setText(semester);
		add(labelSem);
		JLabel lblsubheader=new JLabel("Subjects");
		lblsubheader.setBounds(50, 225, 300, 20);
		lblsubheader.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblsubheader);
		
		JLabel lblMarkHeader=new JLabel("Marks");
		lblMarkHeader.setBounds(400, 225, 300, 20);
		lblMarkHeader.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblMarkHeader);
		
		JLabel lblsub1=new JLabel();
		lblsub1.setBounds(50, 250, 300, 20);
		lblsub1.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblsub1);
		JLabel lblsub2=new JLabel();
		lblsub2.setBounds(50, 275, 300, 20);
		lblsub2.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblsub2);
		JLabel lblsub3=new JLabel();
		lblsub3.setBounds(50, 300, 300, 20);
		lblsub3.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblsub3);
		JLabel lblsub4=new JLabel();
		lblsub4.setBounds(50, 325, 300, 20);
		lblsub4.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblsub4);
		JLabel lblsub5=new JLabel();
		lblsub5.setBounds(50, 350, 300, 20);
		lblsub5.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblsub5);
		
		JLabel lblM1=new JLabel();
		lblM1.setBounds(400, 250, 300, 20);
		lblM1.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblM1);
		JLabel lblM2=new JLabel();
		lblM2.setBounds(400, 275, 300, 20);
		lblM2.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblM2);
		JLabel lblM3=new JLabel();
		lblM3.setBounds(400, 300, 300, 20);
		lblM3.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblM3);
		JLabel lblM4=new JLabel();
		lblM4.setBounds(400, 325, 300, 20);
		lblM4.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblM4);
		JLabel lblM5=new JLabel();
		lblM5.setBounds(400, 350, 300, 20);
		lblM5.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblM5);
		JLabel lblTotal=new JLabel("Total Mark");
		lblTotal.setBounds(50, 375, 300, 20);
		lblTotal.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(lblTotal);
		JLabel labelTmark=new JLabel();
		labelTmark.setBounds(400, 375, 300, 20);
		labelTmark.setFont(new Font("Roboto", Font.ROMAN_BASELINE, 15));
		add(labelTmark);

		
		back=new JButton("Back");
		back.setBounds(225,400,100,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Elephant",Font.BOLD,15));
		back.addActionListener(this);
		add(back);
		
		Connection con=Conn.getConnection();
		try {
			Statement s1=con.createStatement();
			ResultSet rs=s1.executeQuery("Select name from student where roll='"+rollno+"'");
			rs.next();
			labelName.setText(rs.getString("name"));
			
			Statement s2=con.createStatement();
			Statement s3=con.createStatement();
			ResultSet rs2=s2.executeQuery("Select * from subject where roll='"+rollno+"' and semester='"+semester+"'");
			ResultSet rs3=s3.executeQuery("Select * from mark where roll='"+rollno+"' and semester='"+semester+"'");
			rs2.next();
			rs3.next();
			
			int marks[]=new int[5];
			marks[0]=Integer.parseInt(rs3.getString(3));
			marks[1]=Integer.parseInt(rs3.getString(4));
			marks[2]=Integer.parseInt(rs3.getString(5));
			marks[3]=Integer.parseInt(rs3.getString(6));
			marks[4]=Integer.parseInt(rs3.getString(7));
				lblsub1.setText(rs2.getString(3));
				lblsub2.setText(rs2.getString(4));
				lblsub3.setText(rs2.getString(5));
				lblsub4.setText(rs2.getString(6));
				lblsub5.setText(rs2.getString(7));
				lblM1.setText(rs3.getString(3));
				lblM2.setText(rs3.getString(4));
				lblM3.setText(rs3.getString(5));
				lblM4.setText(rs3.getString(6));
				lblM5.setText(rs3.getString(7));
				
			int total=0;
			for(int ele:marks) {
				total+=ele;
			}
			labelTmark.setText(Integer.toString(total));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
	
	
}
