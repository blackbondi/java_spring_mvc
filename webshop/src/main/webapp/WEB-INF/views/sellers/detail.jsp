<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Creating/Editing Seller</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>
	<h2>Creating/Editing Seller</h2>
 
	<form:form method="POST" modelAttribute="seller">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    			
			<tr>
				<td><label for="personnelNumber">Peronnel Number: </label> </td>
				<td><form:input path="personnelNumber" id="personnelNumber"/></td>
				<td><form:errors path="personnelNumber" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">					
					<input type="submit" value="Save"/>					
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to the <a href="<c:url value='/listAllSellers' />">list of all sellers</a>
</body>
</html>