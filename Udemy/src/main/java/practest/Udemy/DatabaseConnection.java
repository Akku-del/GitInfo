package practest.Udemy;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class DatabaseConnection extends Base {

	private String url="jdbc:mysql://localhost:3306/dbname";
	String dbURL = "jdbc:sqlserver://localhost\\sqlexpress;user=sa;password=secret";
	String oracleUrl="jdbc:oracle:thin:@localhost:1521:serviceName";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rset=null;
    public void databaseConnection() throws Exception
    {
    	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    	//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
    	//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    	conn=DriverManager.getConnection(url, "root", "root");
    	stmt=conn.createStatement();
    	rset=stmt.executeQuery("Select * from table");
    			while (rset.next())
    			{
    				rset.getString(1);
    			}
    			
    			rset.close();
    			stmt.close();
    			conn.close();
    }

}
