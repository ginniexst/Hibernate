<%--
  Created by IntelliJ IDEA.
  User: nguyen-giang
  Date: 2025/02/20
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Categories</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/categoriesController/create" method="post">
  <label for="catalogName">Catalog Name</label>
  <input type="text" name="catalogName" id="catalogName" /><br>
  <label for="description">Description</label>
  <input type="text" name="description" id="description" /><br>
  <label for="active">Status</label>
  <input type="radio" id="active" name="status" value="true" /><label for="active">Active</label>
  <input type="radio" id="inactive" name="status" value="false"/><label for="inactive">Inactive</label><br>
  <input type="submit" value="Create" />
</form>
</body>
</html>
