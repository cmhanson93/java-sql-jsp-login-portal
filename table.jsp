<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inventory</title>
		<link rel="stylesheet" type="text/css" href="item.css">
	</head>
	<body>
		<div>
		<h1>Inventory</h1>
		<form method="post">

			<table style="width:950px">
				<tr>
				<th>ID</th>
				<th>TYPE</th>
				<th>TITLE</th>
				<th>PRICE</th>
				</tr>
				<%
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost/test";
				String username="bc81d0cd864c81";
				String password="1c21564d";
				String query="select * from items";
				Connection conn=DriverManager.getConnection(url,username,password);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
				
				%>
				    <tr><td><%=rs.getInt("serialNum") %></td></tr>
				    <tr><td><%=rs.getString("type") %></td></tr>
				    <tr><td><%=rs.getString("title") %></td></tr>
				        <%
				
				}
				%>
			</table>
				    <%
				    rs.close();
				    stmt.close();
				    conn.close();
				    }
				catch(Exception e)
				{
				    e.printStackTrace();
				    }
				%>

</form>
</div>
</body>
</html>