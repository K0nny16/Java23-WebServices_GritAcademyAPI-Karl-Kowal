<!DOCTYPE html>
<html>
<head>
    <title>Add a Student!</title>
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>
<h1>Add a new Student!</h1>
<div class="attendance-form">
    <form action="/addStudent" method="POST">
        <label for="fName">First name:</label>
        <input type="text" id="fName" name="fName" required>

        <label for="lName">Last name:</label>
        <input type="text" id="lName" name="lName" required>

        <label for="town">Town:</label>
        <input type="text" id="town" name="town" required>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="text" id="password" name="password" required>

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>