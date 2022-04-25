package mod2;
import java.sql.*;
/*
 * Manages connected Database
 */
public class DatabaseManager {
	
	//Log In
	 private String url = "jdbc:mysql://localhost:3306/my325db?useSSL=false"; //Path to Database
	 private String user = "root"; //Username to Database 
	 private String password = "admin"; //Password to Database
	 
	 //Insert into Table
	 public void insert(String name, String address) {
		 String query = " insert into my325_tbl (name, address)"
				 + " values (?, ?)";
				 try ( Connection con = DriverManager.getConnection(url, user, password);
				 Statement st = con.createStatement();)
				 {
				 
				 // create the mysql insert preparedstatement
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 preparedStmt.setString (1, name);
				 preparedStmt.setString (2, address);
				 // execute the preparedstatement
				 preparedStmt.execute();
				 
				 } catch (SQLException ex) {
				 System.err.println("Got an exception! "); 
				 System.err.println(ex.getMessage()); 
				 }

	 }
	 
	 //Display Table
	 public String printTable() {
		 String output = "";
		 String query = "SELECT * FROM my325_tbl";
		 try (Connection con = DriverManager.getConnection(url, user, password);
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(query)) {
		 //parse the result of the query and print
		 while (rs.next()) {
		
			 output = output + rs.getString(2) + " lives at " + rs.getString(3) + "\n";
		 }
		 } catch (SQLException ex) {
		 //if things go badly
		 System.err.println("Got an exception! "); 
		 System.err.println(ex.getMessage()); 
		 }
		return output; 
	 }
		 
	 //Delete from Table based on Name
	 public void deleteFromTable(String text) {
		 String sql = "delete from my325_tbl where name='" + text + "'";
		 try (Connection con = DriverManager.getConnection(url, user, 
		password); 
		 Statement st = con.createStatement();) {
		 
		 st.executeUpdate(sql);
		 System.out.println("Record deleted successfully");
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }

	 }
}
