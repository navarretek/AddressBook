<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addAddress</title>
</head>
<body>
	<form action = "addAddressServlet" method="post">
Street: <input type ="text" name = "street">
House Number: <input type = "text" name = "houseNumber">
Country: <input type = "text" name = "country"> 
City: <input type = "text" name = "city"> 
Add Resident:

<table>
<c:forEach items="${requestScope.allResidents}" var="currentlist">
<tr>
 <td><input type="radio" name="id" value="${currentlist.residentId}"></td>
 <tr><td colspan="3">Resident Name: ${currentlist.residentName}</td></tr>
 <tr><td colspan="3">Date of Birth: ${currentlist.dateOfBirth}</td></tr>
 
 </c:forEach>
</table>

<input type = "submit" value="Add Address">
</form> 
</body>
</html>