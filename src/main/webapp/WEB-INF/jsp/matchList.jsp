<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Match list</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<h1>Match List</h1>
	<br />
	<br />
	<div>
		<table border="1">
			<caption>Match table for tournament</caption>
			<tr>
				<th>TOURNAMENT</th>
				<th>SPORT</th>
				<th>MATCH_ID</th>
				<th>DATE_OF_MATCH</th>
				<th>HOST_TEAM</th>
				<th>HT_SCORE</th>
				<th>GT_SCORE</th>
				<th>GUEST_TEAM</th>
			</tr>
			<c:forEach items="${matchList}" var="match">

				<tr>
					<td>${match.tournamentId}</td>
					<td>${match.sportId}</td>
					<td>${match.id}</td>
					<td>${match.dateOfMatch}</td>
					<td>${match.homeTeamId}</td>
					<td>${match.homeTeamScore}</td>
					<td>${match.awayTeamScore}</td>
					<td>${match.awayTeamId}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>