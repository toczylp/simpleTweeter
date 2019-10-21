<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h4>LOGIN PAGE</h4>
    <div class="card">
        <div class="card-body">
            <div class="form-group"></div>
    <form:form method="post" modelAttribute="user">
        Email:<br>
        <form:input path="email"/><br>
        Password:<br><form:password path="password"/> <br>
        <input type="submit" class="btn btn-primary" value="Login"/><a href="/signup" class="btn btn-primary">Register</a> </button>
    </form:form>
            <c:if test="${'pwdMismatch'.equals(error)}">
                <div class="alert alert-danger" role="alert">Not correct password!</div>
            </c:if>
        </div>
    </div>
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
            <td>${el.user.lastName}</td>
            <td><a href="/tweet/${el.id}" class="btn btn-primary">Details</a> </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
