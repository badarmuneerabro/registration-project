package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect 
{
	private Connection connection;
	private Statement statement;
	private static Connect connect;
	
	private final String URL = "jdbc:mysql://localhost:3306/test";
	private final String USER = "root";
	private final String PASSWORD = "tiger";
	
	private Connect()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Got connection");
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static Connect getInstance()
	{
		return (connect == null) ? connect = new Connect() : connect;
	}
	
	public PreparedStatement getPreparedStatement(String query)
	{
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}
	
	
}
