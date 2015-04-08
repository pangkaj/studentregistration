<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="edu.daffodils.studentmanagement.model.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table title="List Of Persons" border="1">
		<tr>
			<th>Name</th>
			<th>RegId</th>
		</tr>
		<%
			List<Student> studentLists = (List) request.getAttribute("students");
			for (Student student : studentLists) {
		%>
		<tr>
			<td><%=student.getFullName()%></td>
			<td><%=student.getRegID()%></td>
		</tr>
		<%
			}
 		%>

	</table>
</body>
</html>