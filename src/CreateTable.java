import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws SQLException, IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			
			Statement st=con.createStatement();
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter table Name");
			String tname=br.readLine();
			String sql="create table "+ tname + "(eno number,ename varchar2(15),esal number)";
//			String sql = "CREATE TABLE" + tname  +
//	                   "(id INTEGER not NULL, " +
//	                   " first VARCHAR(255), " + 
//	                   " last VARCHAR(255), " + 
//	                   " age INTEGER, " + 
//	                   " PRIMARY KEY ( id ))"; 
			st.executeUpdate(sql);
			System.out.println("table created successfully");
			con.close();
			System.out.println("connection closed suceesfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
