<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of Sellers</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Sellers</h2>	
	<table>
		<tr>
			<td>Name</td>
			<td>Personnel Number</td>
			<td colspan="2"></td>
		</tr>
		<c:forEach items="${sellers}" var="seller">
			<tr>
			<td>${seller.name}</td>
			<td>${seller.personnelNumber}</td>				
			<td><a href="<c:url value='/edit-seller-${seller.personnelNumber}' />">Edit</a></td>
			<td><a href="<c:url value='/delete-seller-${seller.personnelNumber}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/createSeller' />">Create New Seller</a>
	<a href="<c:url value='/' />">Home</a>
</body>
</html>