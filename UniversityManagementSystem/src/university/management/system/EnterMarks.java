package university.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

@SuppressWarnings("serial")
public class EnterMarks extends JFrame implements ActionListener{
	Choice cRollno;
	@SuppressWarnings("rawtypes")
	JComboBox cbSemester;
	JTextField tfSub1,tfSub2,tfSub3,tfSub4,tfSub5,tfMark1,tfMark2,tfMark3,tfMark4,tfMark5;
	JButton submit,cancel;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	EnterMarks(){
		setSize(1000,550);
		setLocation(150,100);
		setLayout(null);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Ravenshaw-University logo.png"));
		Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(500, 80, 400, 300);
		add(image);
		
		
		JLabel heading = new JLabel("Enter the marks of student");
		heading.setBounds(300, 10, 500, 30);
		heading.setFont(new Font("Elephant", Font.BOLD, 25));
		add(heading);

		JLabel lblRollno = new JLabel("Select Roll number");
		lblRollno.setFont(new Font("Roboto", Font.BOLD, 15));
		lblRollno.setBounds(50, 50, 150, 20);
		add(lblRollno);

		cRollno = new Choice();
		cRollno.setBounds(200, 50, 150, 20);
		add(cRollno);

		try {
			Connection con = Conn.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select roll from student");
			while (rs.next()) {
				cRollno.add(rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblSem=new JLabel("Select semester");
		lblRollno.setFont(new Font("Roboto", Font.BOLD, 15));
		lblSem.setBounds(50, 100, 100, 20);
		add(lblSem);
		
		String semester[]= {"1st semester","2nd semester","3rd semester",
				"4th semester","5th semester","6th semester"};

		cbSemester =new JComboBox(semester);
		cbSemester.setBounds(200, 100, 150, 20);
		cbSemester.setBackground(Color.WHITE);
		
		add(cbSemester);
		
		
		JLabel lblEnterSubject=new JLabel("Enter subject");
		lblEnterSubject.setBounds(100, 150, 100, 20);
		add(lblEnterSubject);
		
		JLabel lblEnterMark=new JLabel("Enter Marks");
		lblEnterMark.setBounds(250, 150, 100, 20);
		add(lblEnterMark);
		
		tfSub1=new JTextField();
		tfSub1.setBounds(50,200,150,20);
		add(tfSub1);
		tfMark1=new JTextField();
		tfMark1.setBounds(250,200,150,20);
		add(tfMark1);
		
		tfSub2=new JTextField();
		tfSub2.setBounds(50,245,150,20);
		add(tfSub2);
		tfMark2=new JTextField();
		tfMark2.setBounds(250,245,150,20);
		add(tfMark2);
		
		tfSub3=new JTextField();
		tfSub3.setBounds(50,290,150,20);
		add(tfSub3);
		tfMark3=new JTextField();
		tfMark3.setBounds(250,290,150,20);
		add(tfMark3);
		
		tfSub4=new JTextField();
		tfSub4.setBounds(50,335,150,20);
		add(tfSub4);
		tfMark4=new JTextField();
		tfMark4.setBounds(250,335,150,20);
		add(tfMark4);
		
		tfSub5=new JTextField();
		tfSub5.setBounds(50,380,150,20);
		add(tfSub5);
		tfMark5=new JTextField();
		tfMark5.setBounds(250,380,150,20);
		add(tfMark5);
		
		
		submit=new JButton("Submit");
		submit.setBounds(100,425, 100,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Elephant",Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(225,425, 100,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Elephant",Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			Connection con=Conn.getConnection();
			String query1="Insert into subject values(?,?,?,?,?,?,?)";
			String query2="Insert into Mark values(?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstm=con.prepareStatement(query1);
				PreparedStatement pstm1=con.prepareStatement(query2);
				pstm.setString(1, cRollno.getSelectedItem());
				pstm.setString(2, (String) cbSemester.getSelectedItem());
				pstm.setString(3, tfSub1.getText());
				pstm.setString(4, tfSub2.getText());
				pstm.setString(5, tfSub3.getText());
				pstm.setString(6, tfSub4.getText());
				pstm.setString(7, tfSub5.getText());
				pstm1.setString(1, cRollno.getSelectedItem());
				pstm1.setString(2, (String) cbSemester.getSelectedItem());
				pstm1.setString(3, tfMark1.getText());
				pstm1.setString(4, tfMark2.getText());
				pstm1.setString(5, tfMark3.getText());
				pstm1.setString(6, tfMark4.getText());
				pstm1.setString(7, tfMark5.getText());
				pstm.executeUpdate();
				pstm1.executeUpdate();
				JOptionPane.showMessageDialog(null,"Mark Details of the given student recorded successfully");
	
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
