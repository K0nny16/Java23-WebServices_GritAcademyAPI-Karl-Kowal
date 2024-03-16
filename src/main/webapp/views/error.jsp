<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/errorStyle.css">
</head>
<body>
<h1>Error!</h1>
<div class="error-message">
    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>
    <c:if test="${empty error}">
        <p>An unknown error occurred.</p>
    </c:if>
</div>
</body>
</html>
