<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Tweet Info</title>
</head>
<body>
<div class="container">
    <h3>Tweet Info</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Tweet id</th>
            <th>Text</th>
            <th>Created</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${tweet.id}</td>
            <td>${tweet.text}</td>
            <td>${tweet.created}</td>
            <td>${tweet.user.email}</td>
            <td>${tweet.user.firstName}</td>
            <td>${tweet.user.lastName}</td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container">
    <h3>Add comment</h3>
    <div class="card">
        <div class="card-body">
            <div class="form-group"></div>
            <form:form method="post" modelAttribute="comment">
                Text:<br>
                <form:input path="text"/><br>
                <form:errors path="text" element="div" class="alert alert-danger" role="alert"/>
                <form:select path="user.id" items="${users}" itemLabel="email" itemValue="id"/>
                <form:hidden path="tweet.id"/>
                <input type="submit" class="btn btn-primary" value="Comment"/>
            </form:form>
        </div>
    </div>
</div>
<div class="container">
    <h3>Comments</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Created</th>
            <th>Comment</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${comments}" var="el">
        <tr>
            <td>${el.created}</td>
            <td>${el.text}</td>
            <td>${el.user.email}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
