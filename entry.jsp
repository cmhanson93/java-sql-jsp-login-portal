<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inventory</title>
		<link rel="stylesheet" type="text/css" href="item.css">
	</head>
	<body>
		<div>
		<h1>Welcome to the data entry table!</h1>
		<h3>Please complete each field below. Upon submit, values will be updated in the database.</h3>
		<form method="post" action="logindb.MainEntryServlet">

			<table style="width:950px">
				<tr>
				<th>TYPE</th>
				<th>TITLE</th>
				<th>PRICE</th>
				</tr>
					<tr>
				    	<td><input type="radio" name="type1" value="Blouse" checked>Blouse<br/>
				    		<input type="radio" name="type1" value="Trouser">Trouser<br/>
				    		<input type="radio" name="type1" value="Shoes">Shoes</td>
				    	<td><input type="text" name="title1" required></td>
				    	<td><input type="text" name="price1" required></td>		
				    </tr>
				    <tr>
				    	<td><input type="radio" name="type2" value="Blouse" checked>Blouse<br/>
				    		<input type="radio" name="type2" value="Trouser">Trouser<br/>
				    		<input type="radio" name="type2" value="Shoes">Shoes</td>
				    	<td><input type="text" name="title2" required></td>
				    	<td><input type="text" name="price2" required></td>		
				    </tr>
				    <tr>
				    	<td><input type="radio" name="type3" value="Blouse" checked>Blouse<br/>
				    		<input type="radio" name="type3" value="Trouser">Trouser<br/>
				    		<input type="radio" name="type3" value="Shoes">Shoes</td>
				    	<td><input type="text" name="title3" required></td>
				    	<td><input type="text" name="price3" required></td>		
				    </tr>
				    <tr>
				    	<td><input type="radio" name="type4" value="Blouse" checked>Blouse<br/>
				    		<input type="radio" name="type4" value="Trouser">Trouser<br/>
				    		<input type="radio" name="type4" value="Shoes">Shoes</td>
				    	<td><input type="text" name="title4" required></td>
				    	<td><input type="text" name="price4" required></td>		
				    </tr>
				    <tr>
				    	<td><input type="radio" name="type5" value="Blouse" checked>Blouse<br/>
				    		<input type="radio" name="type5" value="Trouser">Trouser<br/>
				    		<input type="radio" name="type5" value="Shoes">Shoes</td>
				    	<td><input type="text" name="title5" required></td>
				    	<td><input type="text" name="price5" required></td>		
				    </tr>
				 
			</table>
				    

</form>
</div>
</body>
</html>