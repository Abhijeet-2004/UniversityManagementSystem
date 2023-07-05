package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@SuppressWarnings("serial")
public class ExaminationDetails extends JFrame implements ActionListener{
	JButton submit,cancel;
	Choice cRollno,cSem;
	ExaminationDetails(){
		setSize(600,300);
		setLocation(300,200);
		setLayout(null);
		getContentPane().setBackground(Color.yellow);
		
		
		JLabel heading = new JLabel("Check Result");
		heading.setBounds(200, 10, 200, 30);
		heading.setFont(new Font("Serif", Font.BOLD, 25));
		add(heading);
		
		
		JLabel lblRollno = new JLabel("Select Roll number");
		lblRollno.setFont(new Font("Roboto", Font.BOLD, 15));
		lblRollno.setBounds(50, 80, 150, 20);
		add(lblRollno);

		cRollno = new Choice();
		cRollno.setBounds(200, 80, 150, 20);
		add(cRollno);
		
		JLabel lblSem = new JLabel("Select Semester:");
		lblSem.setFont(new Font("Roboto", Font.BOLD, 15));
		lblSem.setBounds(50, 125, 150, 20);
		add(lblSem);

		cSem = new Choice();
		cSem.setBounds(200, 125, 150, 20);
		add(cSem);

		try {
			Connection con = Conn.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select roll from student");
			while (rs.next()) {
				cRollno.add(rs.getString(1));
			}
			
			ResultSet rs1= stmt.executeQuery("Select semester from subject where roll='"+cRollno.getSelectedItem()+"'");
			while(rs1.next()) {
				cSem.add(rs1.getString(1));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cRollno.addItemListener(new ItemListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void itemStateChanged(ItemEvent ie)
			{
				try {
					cSem.hide();
					cSem = new Choice();
					cSem.setBounds(200, 125, 150, 20);
					Connection con = Conn.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs1= stmt.executeQuery("Select semester from subject where roll='"+cRollno.getSelectedItem()+"'");
					while(rs1.next()) {
						cSem.add(rs1.getString(1));
					}
					add(cSem);
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		submit=new JButton("Result");
		submit.setBounds(150,180, 100,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Elephant",Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(300,180, 100,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Elephant",Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			setVisible(false);
			new ShowResult(cRollno.getSelectedItem(),cSem.getSelectedItem());
		}
		else {
			setVisible(false);
		}
	}

}
