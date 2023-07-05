package university.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
@SuppressWarnings("serial")
public class Project extends JFrame implements ActionListener {
	Project(){
		setSize(1275,675);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2=i1.getImage().getScaledInstance(1275, 600, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		
		JMenuBar mb=new JMenuBar();
		
		//New information
		JMenu newInfromation=new JMenu("New Infromation");
		newInfromation.setForeground(Color.PINK);
		mb.add(newInfromation);
		JMenuItem facultyInfo=new JMenuItem("New Faculty Infromation");
		facultyInfo.setBackground(Color.WHITE);
		facultyInfo.addActionListener(this);
		newInfromation.add(facultyInfo);
		
		JMenuItem studentInfo=new JMenuItem("New Student Infromation");
		studentInfo.setBackground(Color.WHITE);
		studentInfo.addActionListener(this);
		newInfromation.add(studentInfo);
		
		
		//Details
		JMenu details=new JMenu("View Details");
		details.setForeground(Color.BLUE);
		mb.add(details);
		
		JMenuItem facultyDetails=new JMenuItem("Faculty Details");
		facultyDetails.setBackground(Color.WHITE);
		facultyDetails.addActionListener(this);
		details.add(facultyDetails);
				
		JMenuItem studentDeatails=new JMenuItem("Student Details");
		studentDeatails.setBackground(Color.WHITE);
		studentDeatails.addActionListener(this);
		details.add(studentDeatails);	
		
		//Leave
		JMenu leave=new JMenu("Apply Leave");
		leave.setForeground(Color.PINK);
		mb.add(leave);
				
		JMenuItem facultyLeave=new JMenuItem("Faculty Leave");
		facultyLeave.setBackground(Color.WHITE);
		facultyLeave.addActionListener(this);
		leave.add(facultyLeave);
						
		JMenuItem studentLeave=new JMenuItem("Student Leave");
		studentLeave.setBackground(Color.WHITE);
		studentLeave.addActionListener(this);
		leave.add(studentLeave);
		
		//Leave Details
		JMenu leaveDetails=new JMenu("Leave Details");
		leaveDetails.setForeground(Color.BLUE);
		mb.add(leaveDetails);
						
		JMenuItem facultyLeaveDetails=new JMenuItem("Faculty leave details");
		facultyLeaveDetails.setBackground(Color.WHITE);
		facultyLeaveDetails.addActionListener(this);
		leaveDetails.add(facultyLeaveDetails);
								
		JMenuItem studentLeaveDetails=new JMenuItem("Student leave details");
		studentLeaveDetails.setBackground(Color.WHITE);
		studentLeaveDetails.addActionListener(this);
		leaveDetails.add(studentLeaveDetails);
		
		//Examination Details
		JMenu examination=new JMenu("Examination");
		examination.setForeground(Color.PINK);
		mb.add(examination);
		JMenuItem examinationDetails=new JMenuItem("Examination Result");
		examinationDetails.setBackground(Color.WHITE);
		examinationDetails.addActionListener(this);
		examination.add(examinationDetails);
										
		JMenuItem enterMarks=new JMenuItem("Enter marks");
		enterMarks.setBackground(Color.WHITE);
		enterMarks.addActionListener(this);
		examination.add(enterMarks);
		
		
		//Update information
		JMenu updateInfo=new JMenu("Update Details");
		updateInfo.setForeground(Color.BLUE);
		mb.add(updateInfo);

		JMenuItem updateFacultyInfo=new JMenuItem("Update faculty infromation");
		updateFacultyInfo.setBackground(Color.WHITE);
		updateFacultyInfo.addActionListener(this);
		updateInfo.add(updateFacultyInfo);
												
		JMenuItem updateStudentInfo=new JMenuItem("Update student infromation");
		updateStudentInfo.setBackground(Color.WHITE);
		updateStudentInfo.addActionListener(this);
		updateInfo.add(updateStudentInfo);	
		
		
		//Utility
		JMenu utility=new JMenu("Utility");
		utility.setForeground(Color.PINK);
		mb.add(utility);
								
		JMenuItem notepad=new JMenuItem("Notepad");
		notepad.setBackground(Color.WHITE);
		notepad.addActionListener(this);
		utility.add(notepad);
										
		JMenuItem calc=new JMenuItem("Calculator");
		calc.setBackground(Color.WHITE);
		calc.addActionListener(this);
		utility.add(calc);
		
		//Exit
		JMenu exit=new JMenu("Exit");
		exit.setForeground(Color.BLUE);
		exit.addActionListener(this);
		mb.add(exit);
		
		JMenuItem ex=new JMenuItem("Exit");
		ex.setBackground(Color.WHITE);
		ex.addActionListener(this);
		exit.add(ex);
		
		
		setJMenuBar(mb);
		
		setVisible(true);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		String msg=ae.getActionCommand();
		if(msg.equals("Exit")) {
			setVisible(false);
		}
		else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(msg.equals("New Student Infromation")){
			new AddStudent();
		}
		else if(msg.equals("New Faculty Infromation")) {
			new AddTeacher();
		}
		else if(msg.equals("Faculty Details")) {
			new TeacherDetails();
		}
		else if(msg.equals("Student Details")) {
			new StudentDetails();
		}
		else if(msg.equals("Faculty Leave")) {
			new TeacherLeave();
		}
		else if(msg.equals("Student Leave")) {
			new StudentLeave();
		}
		else if(msg.equals("Faculty leave details")) {
			new TeacherLeaveDetails();
		}
		else if(msg.equals("Student leave details")) {
			new StudentLeaveDetails();
		}
		else if(msg.equals("Update faculty infromation")) {
			new UpdateTeacher();
		}
		else if(msg.equals("Update student infromation")) {
			new UpdateStudent();
		}
		else if(msg.equals("Enter marks")) {
			new EnterMarks();
		}
		else if(msg.equals("Examination Result")) {
			new ExaminationDetails();
		}
		
	}
}
