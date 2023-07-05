package university.management.system;
import java.awt.Choice;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class StudentLeaveDetails extends JFrame implements ActionListener{
	Choice cRollno;
	JTable table;
	JButton search,print,cancel;
	StudentLeaveDetails(){
		setSize(1000,600);
		setLocation(150,75);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Search by Roll number");
		heading.setBounds(50,25, 200, 20);
		add(heading);
		
		cRollno=new Choice();
		cRollno.setBounds(250, 25, 150, 20);
		add(cRollno);
		
		try {
			Connection con=Conn.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select roll from student");
			while(rs.next()) {
				cRollno.add(rs.getString(1));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		table=new JTable();
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,100, 1000, 450);
		add(jsp);
		
		try {
			Connection con=Conn.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from studentLeave");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		search=new JButton("Search");
		search.setBounds(50, 70, 100, 25);
		search.setBackground(Color.BLACK);
		search.setForeground(Color.WHITE);
		search.addActionListener(this);
		add(search);
		
		print=new JButton("Print");
		print.setBounds(350, 70, 100, 25);
		print.setBackground(Color.BLACK);
		print.setForeground(Color.WHITE);
		print.addActionListener(this);
		add(print);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(700, 70, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==search) {
			String query="Select *from StudentLeave where roll='"+cRollno.getSelectedItem()+"'";
			Connection con=Conn.getConnection();
			try {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==print) {
			try {
				table.print();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==cancel) {
			setVisible(false);
		}
	}	
	

}
