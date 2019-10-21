<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Password" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h5>Add new tweet</h5>
    <div class="card">
        <div class="card-body">
            <div class="form-group"></div>
            <form:form method="post" modelAttribute="tweet">
                Text:<br>
                <form:textarea path="text" cols="40" rows="3"/><br>
                <form:hidden path="user.id"/>
                <input type="submit" class="btn btn-primary" value="Tweet"/>
            </form:form>
        </div>
    </div>
</div>
<div class="container">
    <h5>Message Page</h5>
    <div class="card">
        <a href="/message/user/${tweet.user.id}" class="btn btn-primary">Read Messages</a>

    </div>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Tweet</th>
            <th>Created</th>
            <th>Last Name</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tweets}" var="el">
            <tr>
                <td>${el.text}</td>
                <td>${el.created}</td>
                <td>${el.user.email}</td>
                <td><a href="/tweet/${el.id}" class="btn btn-primary">Details</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
