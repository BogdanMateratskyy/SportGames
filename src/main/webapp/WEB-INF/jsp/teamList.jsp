<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Teams</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<h1>Team List</h1>
	<br />
	<br />
	<div>
		<table border="1">
			<caption>List of all existing team</caption>
			<tr>
				<th>TEAM_ID</th>
				<th>NAME</th>
				<th>CLUB</th>
			</tr>
			<c:forEach items="${teamList}" var="team">
				<tr>
					<td>${team.id}</td>
					<td>${team.teamName}</td>
					<td>${team.clubId}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>