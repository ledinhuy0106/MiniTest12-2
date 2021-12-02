<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UyLe
  Date: 12/2/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body align="center">
<h1>Danh sach</h1>
<form action="/products">
    <input type="text" name="name" placeholder="Enter name">
    <button>Search</button>
</form>

<a href="/products?action=create">Create product</a><br><br>
<a href="/products?action=orderByQuantity">Oder By Quantity</a>
<c:forEach items="${products}" var="product">
    <h2>${product.id},${product.name},${product.price},${product.quantity},
        <a href="/products?action=edit&id=${product.id}">Edit</a>,
        <a onclick="return confirm('Are you sure?')"
           href="/products?action=delete&id=${product.id}">delete</a>
    </h2>
</c:forEach>
</body>
</html>
