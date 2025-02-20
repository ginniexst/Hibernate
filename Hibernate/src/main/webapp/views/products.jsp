<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen-giang
  Date: 2025/02/20
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h3>List Products</h3>
<table border="1">
  <thead>
  <tr>
    <th>No</th>
    <th>Product Id</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Status</th>
    <th>Category</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listProducts}" var="product" varStatus="loop">
    <tr>
      <td>${loop.index+1}</td>
      <td>${product.productId}</td>
      <td>${product.productName}</td>
      <td>${product.price}</td>
      <td>${product.status?"Active":"Inactive"}</td>
      <td>${product.catalog.catalogName}</td>
      <td>
        <a href="<%=request.getContextPath()%>/categoriesController/initUpdate?catalogId=${catalog.catalogId}">Sửa</a>
        <a href="<%=request.getContextPath()%>/categoriesController/delete?catalogId=${catalog.catalogId}">Xoá</a>
      </td>
    </tr>
  </c:forEach>

  </tbody>
</table>
<a href="/">Trang chu</a>
<a href="<%=request.getContextPath()%>/productsController/initCreate">Create new product</a>

</body>
</html>
