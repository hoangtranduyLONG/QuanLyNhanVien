<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 30/05/2022
  Time: 11:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List employee
<c:forEach items="${ds}" var="st">
    <h1>${st.id}, ${st.name}, ${st.status}</h1>
</c:forEach>
</body>
</html>
