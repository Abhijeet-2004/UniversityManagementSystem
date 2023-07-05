package university.management.system;
import java.sql.*;
public class Conn {
static Connection c;
	public static Connection getConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","xyz@123");
		return c;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return c;
	}
}
