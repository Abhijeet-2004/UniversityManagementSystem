package university.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	JButton login,cancel;
	JTextField tfUserName;
	JPasswordField tfPassword;
	Login(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel lblUserName=new JLabel("Username");
		lblUserName.setBounds(40, 30, 100, 20);
		add(lblUserName);
		
		tfUserName= new JTextField();
		tfUserName.setBounds(150, 30, 100, 20);
		add(tfUserName);
		
		JLabel lblPassword=new JLabel("Password");
		lblPassword.setBounds(40, 80, 100, 20);
		add(lblPassword);
		
		tfPassword= new JPasswordField();
		tfPassword.setBounds(150, 80, 100, 20);
		add(tfPassword);
		
		login=new JButton("Login");
		login.setBounds(40,150, 100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Elephant",Font.BOLD,15));
		login.addActionListener(this);
		add(login);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(180,150, 100,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Elephant",Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		
		setSize(600,275);
		setLocation(325,200);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) {
			String getName=tfUserName.getText();
			@SuppressWarnings("deprecation")
			String getPass=tfPassword.getText();
			
			String query="Select * from login where username=? and password=? ";
			Connection con=Conn.getConnection();
			try {
				PreparedStatement pstm=con.prepareStatement(query);
				pstm.setString(1,getName);
				pstm.setString(2,getPass);
				
				ResultSet rs=pstm.executeQuery();
				if(rs.next()) {
					setVisible(false);
					new Project();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==cancel) {
			setVisible(false);
		}
	}

}
