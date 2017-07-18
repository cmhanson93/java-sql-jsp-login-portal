package logindb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;


public class ItemDBEntry extends Item {       
	private Connection conn;
	//private Boolean connected;
	
	//Constructor
	public ItemDBEntry(){}
	
	public void getConnection() {
		String user = "bc81d0cd864c81";
		String passw = "1c21564d";
		String dbname = "ad_a4bf99e38a2cf9a";
		String url = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/" + dbname;
		
		try {
			System.out.println("User      :  " + user);
			conn = DriverManager.getConnection(url, user, passw);
			System.out.println("SQL Database Connection Successful! :)");
		} 
		catch (SQLException e) { 
			System.out.println("JDBC Driver registration failed... :(");
			e.printStackTrace();
		}
	}
	
	//closes the connection
	public void close()
	{
		try {
			conn.close();
			//connected = false;
			System.out.println("Connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//creates the table
	public void createTable()
	{
		try 
		{
			Statement st = conn.createStatement();
			//query for creating the table
			String createTable = 
					"CREATE TABLE items"
					+ "("
					+ "serialNum int NOT NULL PRIMARY KEY,"
					+ "type varchar(255),"
					+ "title varchar(255),"
					+ "price DOUBLE PRECISION"
					+ ");";
			st.executeUpdate(createTable);
			conn.commit();
			System.out.println("Table created");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//drops the table
	public void dropTable()
	{
		try 
		{
			Statement st = conn.createStatement();
			String dropTable ="DROP TABLE items";
			st.executeUpdate(dropTable);
			conn.commit();
			System.out.println("Table dropped");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inserts books from books list into table
	public void insertItems(List<Item> items)
	{		
		//query for inserting books
		String s ="INSERT INTO items (serialNum,type,title,price) VALUES(?,?,?,?,?)";//:D
		try 
		{
			PreparedStatement pst = conn.prepareStatement(s);
			Iterator<Item> iter = items.iterator();
			//loops through book list adding each one to pst's batch
			while(iter.hasNext())
			{
				Item i = iter.next();
				pst.setInt(1, i.getSerialNum());
				pst.setString(2, i.getType());
				pst.setString(3, i.getTitle());
				pst.setDouble(4, i.getPrice());
				pst.addBatch();
			}
			pst.executeBatch();
			conn.commit();
			pst.clearBatch();
			System.out.println("Insert successful");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//updates books from book list
	public void updateItems(List<Item> items)
	{
		String s ="UPDATE items\n"
				+ "SET type=?,title=?,price=?\n"
				+ "WHERE serialNum=?";//:D
		try 
		{
			PreparedStatement pst = conn.prepareStatement(s);
			Iterator<Item> iter = items.iterator();
			//Boolean hasBatch = 
			
			while(iter.hasNext())
			{
				Item i = iter.next();
				pst.setInt(5, i.getSerialNum());
				pst.setString(1, i.getType());
				pst.setString(2, i.getTitle());
				pst.setDouble(4, i.getPrice());
				pst.addBatch();
			}
			pst.executeBatch();
			conn.commit();
			pst.clearBatch();
			System.out.println("Update successful");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//gets connects of books table and prints them to console
	@SuppressWarnings("null")
	public void printTable() throws IOException
	{
		String s = "SELECT * FROM items";
		Statement st;
		try
		{
			HttpServletResponse response = null;
			PrintWriter out = response.getWriter();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(s);
			while(rs.next()) out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4));
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getItemBySerialNum(int serialNum)
	{
		String s = "SELECT * FROM items WHERE serialNum =?";
		try
		{
			PreparedStatement pst = conn.prepareStatement(s);
			pst.setInt(1, serialNum);
			ResultSet rs = pst.executeQuery();
			rs.next();
			System.out.println(rs.getString(3) + "|" + rs.getDouble(4));
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}	
	public static void main(String args[]) {
		
		ItemDBEntry dbStart = new ItemDBEntry();
		
		dbStart.getConnection();
		
		dbStart.createTable();
	}

}
