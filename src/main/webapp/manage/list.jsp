<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 30/05/2022
  Time: 8:59 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/manages">
<c:forEach items="${dsl}" var="cl">
    <h1>${cl.id}, ${cl.name}, ${cl.age},${cl.email},${cl.sex},${cl.province}</h1>
</c:forEach>
</form>
</body>
</html>
