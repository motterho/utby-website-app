<html>

<head>
<style type="text/css">
	label{
	    display: table-cell;
	    text-align: right;
	}
	input {
	  display: table-cell;
	}
	div.row{
	    display:table-row;
	}
</style>
<title>First Web Application</title>
</head>

<body>
	<font color="red">${errorMessage}</font>
	<form method="post">
	<div>
      <div class="row"><label>Name:</label><input type="text" name="name" /></div>
      <div class="row"><label>Password:</label><input type="password" name="password" /></div><br/>
      <div class="row"><input type="submit" /></div>
  	</div>
		<!-- 
		Name : <input type="text" name="name" /><br/>
		Password : <input type="password" name="password" /> 
		<input type="submit" />
		 -->
	</form>
</body>

</html>