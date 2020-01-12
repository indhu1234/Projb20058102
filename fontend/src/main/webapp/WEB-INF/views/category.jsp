<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="admin/addcategory" method="post">
<table>
<tr>
<td>Enter Category Name</td>
<td><input type="text" name="catname"></td>
</tr>
<tr>
<td>Enter Category Description </td>
<td><input type="text" name="catdesc">
</tr>
<tr>
<td><input type="submit" value="Add Category"></td>
</tr>
</table>
</form>

			</br></br>
			<table align="center" border="1">
				<tr>
					<td>Category ID</td>
					<td>Category Name</td>
					<td>Category Desc</td>
					<td>Operation</td>
				</tr>
				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.catid}</td>
						<td>${category.catname}</td>
						<td>${category.desc}</td>
						<td>
						<a href="<c:url value="/editcategory/${category.catid}"/>"class="btn btn-success">Edit</a>
							<a href="<c:url value="/deletecategory/${category.catid}"/>"class="btn btn-danger">Delete</a>
					</tr>
				</c:forEach>

			</table>

</body>
</html>