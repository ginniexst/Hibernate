<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen-giang
  Date: 2025/02/20
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productsController/create" method="post">
    <label for="productId">Product Id</label>
    <input type="text" name="productId" id="productId" /><br>
    <label for="productName">Product Name</label>
    <input type="text" name="productName" id="productName" /><br>
    <label for="price">Price</label>
    <input type="number" name="price" id="price" /><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" /><label for="active">Active</label>
    <input type="radio" id="inactive" name="status" value="false"/><label for="inactive">Inactive</label><br>
    <label>Category</label><br>
    <select name="catalog.catalogId" id="catalogId">
        <c:forEach items="${listCategories}" var="catalog">
            <option value="${catalog.catalogId}">${catalog.catalogName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Create" />
</form>
</body>
</html>
