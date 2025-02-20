<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Categories</title>
</head>
<body>
    <h3>List Categories</h3>
    <table border="1">
      <thead>
      <tr>
        <th>No</th>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${listCategories}" var="catalog" varStatus="loop">
      <tr>
        <td>${loop.index+1}</td>
        <td>${catalog.catalogId}</td>
        <td>${catalog.catalogName}</td>
        <td>${catalog.description}</td>
        <td>${catalog.status?"Active":"Inactive"}</td>
        <td>
          <a href="<%=request.getContextPath()%>/categoriesController/initUpdate?catalogId=${catalog.catalogId}">Sửa</a>
          <a href="<%=request.getContextPath()%>/categoriesController/delete?catalogId=${catalog.catalogId}">Xoá</a>
        </td>
      </tr>
      </c:forEach>

      </tbody>
    </table>
    <a href="/">Trang chu</a>
    <a href="<%=request.getContextPath()%>/categoriesController/initCreate">Create new catalog</a>
</body>
</html>
