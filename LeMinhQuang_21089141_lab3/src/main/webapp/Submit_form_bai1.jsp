<%@ page import="entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Information</title>
</head>
<body>
	<h2>Student Information</h2>

	<%
	Student student = (Student) request.getAttribute("student");
	if (student != null) {
	%>
	<p>
		<strong>First Name:</strong>
		<%=student.getFname()%></p>
	<p>
		<strong>Last Name:</strong>
		<%=student.getLname()%></p>
	<p>
		<strong>Date of Birth:</strong>
		<%=student.getDay()%>
		/
		<%=student.getMonth()%>
		/
		<%=student.getYear()%></p>
	<p>
		<strong>Email:</strong>
		<%=student.getEmail()%></p>
	<p>
		<strong>Mobile Number:</strong>
		<%=student.getMobileNumber()%></p>
	<p>
		<strong>Gender:</strong>
		<%=student.getGender()%></p>
	<p>
		<strong>Address:</strong>
		<%=student.getAddress()%></p>
	<p>
		<strong>City:</strong>
		<%=student.getCity()%></p>
	<p>
		<strong>Pin Code:</strong>
		<%=student.getPinCode()%></p>
	<p>
		<strong>State:</strong>
		<%=student.getState()%></p>
	<p>
		<strong>Country:</strong>
		<%=student.getCountry()%></p>
	<p>
		<strong>Hobbies:</strong>
		<%=student.getHobbies()%></p>
	<p>
		<strong>Course:</strong>
		<%=student.getCourse()%></p>

	<h3>Qualifications</h3>
	<table border="1">
		<thead>
			<tr>
				<th>Examination</th>
				<th>Board</th>
				<th>Percentage</th>
				<th>Year of Passing</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Class X</td>
				<td><%=student.getClassXBoard()%></td>
				<td><%=student.getClassXPercentage()%></td>
				<td><%=student.getClassXYear()%></td>
			</tr>
			<tr>
				<td>Class XII</td>
				<td><%=student.getClassXIIBoard()%></td>
				<td><%=student.getClassXIIPercentage()%></td>
				<td><%=student.getClassXIIYear()%></td>
			</tr>
			<tr>
				<td>Graduation</td>
				<td><%=student.getGraduationBoard()%></td>
				<td><%=student.getGraduationPercentage()%></td>
				<td><%=student.getGraduationYear()%></td>
			</tr>
			<tr>
				<td>Masters</td>
				<td><%=student.getMastersBoard()%></td>
				<td><%=student.getMastersPercentage()%></td>
				<td><%=student.getMastersYear()%></td>
			</tr>
		</tbody>
	</table>
	<%
	} else {
	%>
	<p>No student data available.</p>
	<%
	}
	%>
</body>
</html>
