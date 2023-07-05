package university.management.system;
import java.awt.Image;

import javax.swing.*;
@SuppressWarnings("serial")
public class Splash extends JFrame{
	Splash(){
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		Image i2=i1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		setVisible(true);
		setLocation(100,50);
		setSize(1100,600);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(false);
		//next frame
		new Login();
	}
	
public static void main(String[] args) {
	new Splash();
}
}
