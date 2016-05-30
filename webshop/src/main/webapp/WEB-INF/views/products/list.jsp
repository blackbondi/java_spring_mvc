<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of Products</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Products</h2>	
	<table>
		<tr>
			<td>Name</td>
			<td>Number</td>
			<td>Count</td>
			<td colspan="2"></td>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
			<td>${product.name}</td>	
			<td>${product.number}</td>		
			<td>${product.count}</td>	
			<td><a href="<c:url value='/edit-product-${product.number}' />">Edit</a></td>
			<td><a href="<c:url value='/delete-product-${product.number}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/addProduct' />">Add New Product</a>
	<a href="<c:url value='/' />">Home</a>
</body>
</html>