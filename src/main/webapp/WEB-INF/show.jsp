<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
body *{
margin-left: 20px;}</style>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>song id: <c:out value="${s.id}"/></title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	
	<p>
		Title: <c:out value="${s.title}"></c:out>
	</p>
	<p>
		Artist: <c:out value="${s.artist}"></c:out>
	</p>
	<p>
		Rating: <c:out value="${s.rating}"></c:out>
	</p>
	<p>
		createdAt: <c:out value="${s.createdAt}"></c:out>
	</p>
	
	<a href="/delete_link/${s.id}">DELETE link</a><br/><br/>
	
	<form action="/delete/${s.id}" method="POST">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
	
	
</body>
</html>