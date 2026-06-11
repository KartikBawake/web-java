<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List" %>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
	<tr>
		<th>Roll Number</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Marks</th>
	</tr>
	
	<% Configuration cfg = new Configuration();
		cfg.configure("crud.cfg.xml");
		
		try(SessionFactory sf = cfg.buildSessionFactory();
		Session session1 = sf.openSession();){
		
		Query allstu = session.createNamedQuery("allStudents", User.class);
		List<User> allStudents = (List<User>) allstu.getResultList();
		
		for(User objUser: allStudents){	
	%>
		<tr>
			<td><%=objUser.getRoll() %></td>
			<td><%=objUser.getFname() %></td>
			<td><%=objUser.getLname() %></td>
			<td><%=objUser.getMarks() %></td>
		<tr>
	<%
		}}
	%>
	
	</table>
</body>
</html>