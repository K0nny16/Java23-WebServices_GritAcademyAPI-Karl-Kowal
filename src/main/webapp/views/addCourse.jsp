<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add a Course!</title>
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>
<h1>Create a new Course!</h1>
<c:if test="${not empty errorMessage}">
    <div class="error">${errorMessage}</div>
</c:if>
<div class="attendance-form">
    <form action="/addCourse" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="YHP">YHP:</label>
            <input type="text" id="YHP" name="YHP" required>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>