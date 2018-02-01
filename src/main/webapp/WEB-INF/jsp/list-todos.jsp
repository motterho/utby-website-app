<html>

<head>
<title>First Web Application</title>
</head>

<body>
	Here are the list of your todos: ${todos}
	<BR />
	
	Your Name is : ${name} Parameter myparam:
	<%=request.getParameter("todos")%>
</body>
</html>