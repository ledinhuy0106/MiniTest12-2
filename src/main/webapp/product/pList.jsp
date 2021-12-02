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
<body>
<h1>Danh sach</h1>
<a href="/products?action=create">Create product</a>
<c:forEach items="${products}" var="product">
  <h2>${product.id},${product.name},${product.price},${product.quantity}</h2>
</c:forEach>
</body>
</html>
