//Login.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="Validate.jsp" method="post">
        <label for="user_id">User ID:</label>
        <input type="text" id="user_id" name="user_id" required><br>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>


//Validate.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Validation</title>
</head>
<body>

<%
String user_id= request.getParameter("user_id");
String password= request.getParameter("password");

String JDBC="jdbc:mysql://localhost:3306/user_database";
String dbUser="root";
String dbPassword="hello";

try 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	try (Connection con = DriverManager.getConnection(JDBC,dbUser,dbPassword);
			PreparedStatement st= con.prepareStatement("Select * from users where user_id=? and password=?"))
	{
		st.setString(1, user_id);
		st.setString(2, password);
		try(ResultSet rs=st.executeQuery())
		{
			if(rs.next())
			{
				response.sendRedirect("Success.jsp?user_id="+user_id);
			}
			else
			{
				response.sendRedirect("Error.jsp");
			}
		}
	}
}
catch (ClassNotFoundException e)
{
	out.println("JDBC Driver not found. Please add the JDBC library to your project.");
	e.printStackTrace();
}
catch(SQLException e)
{
	out.println("Error connectiong to the database:"+e.getMessage());
	e.printStackTrace();
}
%>
</body>
</html>


//Success.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Successful</title>
</head>
<body>
<h2>Login Successful</h2>
<p>Welcome, <%=request.getParameter("user_id") %></p>
</body>
</html>

//Error.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Error</title>
</head>
<body>
<h2>Login Error</h2>
<p>Invalid user Id or password.Please try again.</p>
</body>
</html>
