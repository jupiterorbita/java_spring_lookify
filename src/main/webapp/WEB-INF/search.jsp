<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
tr, th, td {
outline: 1px solid grey;
}
td {
padding: 2px 8px}
.red {
color: red;}
body * {
text-align: center;
margin-left: 20px;}
</style>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>searched artist</title>
</head>
<body>
	<h3>songs by <c:out value="${query}"/></h3>
	<p class="red"> <c:out value="${deleted}"/></p>
	<a href="/new">Add New</a> &nbsp; &nbsp; &nbsp; 
	<a href="/top5">Top Songs</a>
	<p></p>
		<form action="/search" method="post">
			<input type="text" name="query" placeholder="search artists" required="required" pattern="[A-Za-z0-9]{1,20}" />
			<input type="submit" value="Search Artists" />
		</form>
	<p></p>
	
	<h3><c:out value="${notFound}"/></h3>
	
	<c:if test="${foundSongs.size() > 0}">
		
			<p> foundSongs is not empty!</p>
		
		
		<div>
			<table>
			<thead>
				<tr>
					<th>id</th>
					<th>artist</th>
					<th>title</th>
					<th>rating</th>
					<th>created_at</th>
					<th>updated_at</th>
					<th>ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${foundSongs}" var="s">					
					<tr>
						<td><c:out value="${s.id}"/></td>
						<td><c:out value="${s.artist}"/></td>
						<td>
							<a href="/songs/${s.id}"><c:out value="${s.title}"/></a></td>
						<td><c:out value="${s.rating}"/></td>
						<td><c:out value="${s.createdAt}"/></td>
						<td><c:out value="${s.updatedAt}"/></td>
						<td>
							<a href="/edit/${s.id}">EDIT</a>
							<a href="/delete_link/${s.id }">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		
	</c:if>
	</div>

</body>
</html>