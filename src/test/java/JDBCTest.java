import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)

public class JDBCTest {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/keywords";
    static final String USER = "postgres";
    static final String PASS = "root";
    
    @Test
    public void tst_func()
    {
    	Statement stmt = null;
    	System.out.println("Testing connection to PostgreSQL JDBC");
    	 
    	try {
    		Class.forName("org.postgresql.Driver");
    	} catch (ClassNotFoundException e) {
    		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
    		e.printStackTrace();
    		return;
    	}
    	System.out.println("PostgreSQL JDBC Driver successfully connected");
    	Connection connection = null;
    	 
    	try {
    		connection = DriverManager
    		.getConnection(DB_URL, USER, PASS);
            stmt = connection.createStatement();
            String sql = "INSERT INTO Theme (Theme) "
               + "VALUES ('Hello');";
            stmt.executeUpdate(sql);
     
    	} catch (SQLException e) {
    		System.out.println("Connection Failed");
    		e.printStackTrace();
    		return;
    	}
    	if (connection != null) {
    		System.out.println("You successfully connected to database now");
    	} else {
    		System.out.println("Failed to make connection to database");
    	}

    }
}
