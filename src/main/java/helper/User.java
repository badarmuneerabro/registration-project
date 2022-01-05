package helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User 
{
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	public User()
	{
		
	}
	public User(String email, String firstName, String lastName, String password)
	{
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User insert()
	{
		Connect connect = Connect.getInstance();
		PreparedStatement statement = connect.getPreparedStatement("INSERT INTO USER(EMAIL, FIRST_NAME,"
				+ "LAST_NAME, PASSWORD) VALUES(?, ?, ?, ?);");
		
		try 
		{
			statement.setString(1, getEmail());
			statement.setString(2, getFirstName());
			statement.setString(3, getLastName());
			statement.setString(4, getPassword());
			statement.execute();
			return this;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
