<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
body * {
margin-left:20px;
}
</style>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Add New Song</title>
</head>
<body>
	<h2>Add New Song</h2>
	<a href="/dashboard">Back</a>
	<p></p>
	
	<div>
		<form:form action="/create" 
			method="POST" 
			modelAttribute="song">
			<p>
				<form:label path="title">title</form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</p>
			<p>
				<form:label path="artist">artist</form:label>
				<form:errors path="artist"></form:errors>
				<form:input path="artist"/>
			</p>
			<p>
				<form:label path="rating">rating</form:label>
				<form:errors path="rating"></form:errors>
				<form:input type="number" max="10" min="1" path="rating"/>
			</p>
			<input type="submit" value="Create"/>
		</form:form>
	</div>
	
	
</body>
</html>