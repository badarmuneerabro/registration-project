package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect 
{
	private Connection connection;
	private Statement statement;
	
	private final String URL = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";
	private final String USERNAME = "root";
	private final String PASSWORD = "tiger";
	private static Connect connect;
	
	private Connect()
	{
		try
		{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Got Connection!");
			statement = connection.createStatement();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet getAll(String table)
	{
		ResultSet rs = null;
		try {
			rs = statement.executeQuery("SELECT * FROM " + table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public PreparedStatement getPreparedStatement(String query)
	{
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement(query);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pStatement;
	}
	public static Connect getInstance()
	{
		return (connect == null) ? connect = new Connect() : connect;
	}
}
