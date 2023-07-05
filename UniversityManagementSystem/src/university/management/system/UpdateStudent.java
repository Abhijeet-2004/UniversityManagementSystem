package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class UpdateStudent extends JFrame implements ActionListener {
	JTextField tfAddress, tfPhone, tfEmail, tfCourse, tfBranch;
	JLabel labelRollno;
	JButton update, cancel;
	Choice cRollno;

	UpdateStudent() {
		setSize(900, 600);
		setLocation(250, 50);
		setLayout(null);

		JLabel heading = new JLabel("Update Student Details");
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

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(50, 100, 150, 20);
		add(lblName);
		JLabel labelName = new JLabel();
		labelName.setBounds(200, 100, 150, 20);
		add(labelName);

		JLabel lblFName = new JLabel("Father's Name");
		lblFName.setBounds(450, 100, 150, 20);
		add(lblFName);
		JLabel labelFName = new JLabel();
		labelFName.setBounds(600, 100, 150, 20);
		add(labelFName);

		JLabel rollno = new JLabel("Roll Number");
		rollno.setBounds(50, 150, 150, 20);
		add(rollno);

		labelRollno = new JLabel();
		labelRollno.setBounds(200, 150, 150, 20);
		add(labelRollno);

		JLabel lbldob = new JLabel("Date of Birth");
		lbldob.setBounds(450, 150, 150, 20);
		add(lbldob);
		JLabel labeldob = new JLabel();
		labeldob.setBounds(600, 150, 150, 20);
		add(labeldob);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(50, 200, 150, 20);
		add(lblAddress);
		tfAddress = new JTextField();
		tfAddress.setBounds(200, 200, 150, 20);
		add(tfAddress);

		JLabel lblPhoneno = new JLabel("Phone Number");
		lblPhoneno.setBounds(450, 200, 150, 20);
		add(lblPhoneno);
		tfPhone = new JTextField();
		tfPhone.setBounds(600, 200, 150, 20);
		add(tfPhone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 250, 150, 20);
		add(lblEmail);
		tfEmail = new JTextField();
		tfEmail.setBounds(200, 250, 150, 20);
		add(tfEmail);

		JLabel lblX = new JLabel("Class X mark(%)");
		lblX.setBounds(450, 250, 150, 20);
		add(lblX);
		JLabel labelX = new JLabel();
		labelX.setBounds(600, 250, 150, 20);
		add(labelX);

		JLabel lblXii = new JLabel("Class XII mark(%)");
		lblXii.setBounds(50, 300, 150, 20);
		add(lblXii);

		JLabel labelXii = new JLabel();
		labelXii.setBounds(200, 300, 150, 20);
		add(labelXii);

		JLabel lblAadhar = new JLabel("Adhar number");
		lblAadhar.setBounds(450, 300, 150, 20);
		add(lblAadhar);
		JLabel labelAadhar = new JLabel();
		labelAadhar.setBounds(600, 300, 150, 20);
		add(labelAadhar);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(50, 350, 150, 20);
		add(lblCourse);
		tfCourse = new JTextField();
		tfCourse.setBounds(200, 350, 150, 20);
		add(tfCourse);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(450, 350, 150, 20);
		add(lblBranch);

		tfBranch = new JTextField();
		tfBranch.setBounds(600, 350, 150, 20);
		add(tfBranch);

		try {
			Connection con = Conn.getConnection();
			String query = "Select * from student where roll='" + cRollno.getSelectedItem() + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				labelName.setText(rs.getString("name"));
				labelRollno.setText(rs.getString("roll"));
				labelFName.setText(rs.getString("fathers_name"));
				labeldob.setText(rs.getString("dob"));
				labelX.setText(rs.getString("X_Percentage"));
				labelXii.setText(rs.getString("Xii_Percentage"));
				labelAadhar.setText(rs.getString("Aadhar"));
				tfAddress.setText(rs.getString("Address"));
				tfPhone.setText(rs.getString("phone"));
				tfEmail.setText(rs.getString("Email"));
				tfCourse.setText(rs.getString("Course"));
				tfBranch.setText(rs.getString("Branch"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		cRollno.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				try {
					Connection con = Conn.getConnection();
					String query = "Select * from student where roll='" + cRollno.getSelectedItem() + "'";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						labelName.setText(rs.getString("name"));
						labelRollno.setText(rs.getString("roll"));
						labelFName.setText(rs.getString("fathers_name"));
						labeldob.setText(rs.getString("dob"));
						labelX.setText(rs.getString("X_Percentage"));
						labelXii.setText(rs.getString("Xii_Percentage"));
						labelAadhar.setText(rs.getString("Aadhar"));
						tfAddress.setText(rs.getString("Address"));
						tfPhone.setText(rs.getString("phone"));
						tfEmail.setText(rs.getString("Email"));
						tfCourse.setText(rs.getString("Course"));
						tfBranch.setText(rs.getString("Branch"));

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		update = new JButton("Update");
		update.setBounds(250, 450, 100, 30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setFont(new Font("Elephant", Font.BOLD, 15));
		update.addActionListener(this);
		add(update);

		cancel = new JButton("Cancel");
		cancel.setBounds(500, 450, 100, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Elephant", Font.BOLD, 15));
		cancel.addActionListener(this);
		add(cancel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == update) {

			String rollno=labelRollno.getText();
			String address=tfAddress.getText();
			String phone=tfPhone.getText();
			String email=tfEmail.getText();
			String course=tfCourse.getText();
			String branch=tfBranch.getText();
			
			Connection con=Conn.getConnection();
			String query="Update student set address=?,phone=?,email=?,course=?,branch=? where roll=?";
			
			try {
				PreparedStatement pstm=con.prepareStatement(query);
				pstm.setString(1,address);
				pstm.setString(2,phone);
				pstm.setString(3,email);
				pstm.setString(4,course);
				pstm.setString(5,branch);
				pstm.setString(6,rollno);
				
				int check=pstm.executeUpdate();
				if(check!=0) {
					JOptionPane.showMessageDialog(null,"Student Details Updated successfully");
					setVisible(false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			setVisible(false);
		}

	}

	
}
