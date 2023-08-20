package jdbc_library_pejm17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookCRUD 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_pejm17", "root","Pratik@123");
		return connection;
	}
	public void saveBook(Book book) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO BOOK VALUES(?,?,?,?,?) ");
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setDouble(4,book.getPrice());
		preparedStatement.setString(5, book.getGenre());
		
		int count=preparedStatement.executeUpdate();
		
		if (count!=0)
		{
			System.out.println("Book Saved Succesfully .");
		}
		else {
			System.out.println("Book is Not Saved .");
		}
		connection.close();
	}
	public void findById(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			System.out.println("Book_ID : "+ resultSet.getInt(1));
			System.out.println("Book_Name : "+resultSet.getString("name"));
			System.out.println("Book_Author : "+ resultSet.getString(3));
			System.out.println("Book_Price : "+ resultSet.getDouble(4));
			System.out.println("Book_Genre : "+resultSet.getString(5));
		}
		
		connection.close();
	}
	public void findByGenre(String genre) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE GENRE=?");
		preparedStatement.setString(1, genre);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next())
		{
			System.out.println("Book_ID : "+ resultSet.getInt(1));
			System.out.println("Book_Name : "+resultSet.getString(2));
			System.out.println("Book_Author : "+ resultSet.getString(3));
			System.out.println("Book_Price : "+ resultSet.getDouble(4));
			System.out.println("Book_Genre : "+resultSet.getString(5));
		}
		connection.close();
	}
	public void findByName(String name) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE NAME=?");
		preparedStatement.setString(1,name );
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next())
		{
			System.out.println("Book_ID : "+ resultSet.getInt(1));
			System.out.println("Book_Name : "+resultSet.getString(2));
			System.out.println("Book_Author : "+ resultSet.getString(3));
			System.out.println("Book_Price : "+ resultSet.getDouble(4));
			System.out.println("Book_Genre : "+resultSet.getString(5));
		}
		connection.close();
	}
	public void findBookByAuthor(String author) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE AUTHOR=?");
		preparedStatement.setString(1,author);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next())
		{
			System.out.println("Book_ID : "+ resultSet.getInt(1));
			System.out.println("Book_Name : "+resultSet.getString(2));
			System.out.println("Book_Author : "+ resultSet.getString(3));
			System.out.println("Book_Price : "+ resultSet.getDouble(4));
			System.out.println("Book_Genre : "+resultSet.getString(5));
			System.out.println("---------------------------------------");
		}
		connection.close();
	}
	
	public void findBookInRange( double first,double last) throws SQLException, ClassNotFoundException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE PRICE BETWEEN ? AND ?");
		preparedStatement.setDouble(1,first);
		preparedStatement.setDouble(2,last);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next())
		{
			System.out.println("Book_ID : "+ resultSet.getInt(1));
			System.out.println("Book_Name : "+resultSet.getString(2));
			System.out.println("Book_Author : "+ resultSet.getString(3));
			System.out.println("Book_Price : "+ resultSet.getDouble(4));
			System.out.println("Book_Genre : "+resultSet.getString(5));
			System.out.println("----------------------------------------");
		}
		connection.close();
	}
	
	public void deleteById(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM BOOK WHERE ID=?");
		preparedStatement.setInt(1, id);
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println(count +" Number of Book's Has been deleted Succesfully ");
		}
		else
		{
			System.out.println("We Don't have Book of this Id");
		}
		connection.close();
		
	}
	public void deleteByName(String name) throws SQLException, ClassNotFoundException
	{
		Connection connection=getConnection();    
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM BOOK WHERE NAME=?");
		preparedStatement.setString(1, name);
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println(count +" Number of Book's Has been deleted Succesfully ");
		}
		else
		{
			System.out.println("We Don't have Book of this Name    ");
		}
		connection.close();
	}
	
	public void deleteByAuthor(String author) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM BOOK WHERE AUTHOR=?");
		preparedStatement.setString(1, author);
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println(count +" Number of Book's Has been deleted Succesfully ");
		}
		else
		{
			System.out.println("We Don't have Book of this Author");
		}
		connection.close();
	}
	public void deleteByGenre(String genre) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM BOOK WHERE GENRE=?");
		preparedStatement.setString(1, genre);
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println(count +" Number of Book's Has been deleted Succesfully ");
		}
		else
		{
			System.out.println("We Don't have Book of this Genre");
		}
		connection.close();
	}
	public void updateNameById(int id,String name) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE BOOK SET NAME=? WHERE ID=?");
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println("Book Name has been updated ");
		}
		else
		{
			System.out.println("Don't Find book of this id or name ");
		}
		connection.close();
	}
	public void updateAuthorById(int id,String author) throws ClassNotFoundException, SQLException 
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE BOOK SET AUTHOR=? WHERE ID=?");
		preparedStatement.setString(1, author);
		preparedStatement.setInt(2, id);
		
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println("Book Name has been updated ");
		}
		else
		{
			System.out.println("Don't Find book of this id or author");
		}
		connection.close();
	}
	public void updateGenreById(int id, String genre) throws ClassNotFoundException, SQLException 
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE BOOK SET GENRE=? WHERE ID=?");
		preparedStatement.setString(1, genre);
		preparedStatement.setInt(2, id);
		
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println("Book Genre has been updated ");
		}
		else
		{
			System.out.println("Don't Find book of this id or genre");
		}
		connection.close();
	}
	public void updatePriceById(int id, double price) throws ClassNotFoundException, SQLException 
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE BOOK SET PRICE=? WHERE ID=?");
		preparedStatement.setDouble(1, price);
		preparedStatement.setInt(2, id);
		
		int count=preparedStatement.executeUpdate();
		if (count!=0) 
		{
			System.out.println("Book Price has been updated ");
		}
		else
		{
			System.out.println("Don't Find book of this id");
		}
		connection.close();
	}

	
}
