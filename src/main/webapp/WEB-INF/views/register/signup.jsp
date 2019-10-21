<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Password" uri="http://www.springframework.org/tags/form" %>
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
            <div class="form-group">
    <form:form method="post" modelAttribute="user">
        Email:<br>
        <form:input path="email"/><br>
        <form:errors path="email" element="div" class="alert alert-danger" role="alert"/>
        First Name:<br>
        <form:input path="firstName"/><br>
        <from:errors path="firstName" element="div" class="alert alert-danger" role="alert"/>
        Last Name:<br>
        <form:input path="lastName"/><br>
        <form:errors path="lastName" element="div" class="alert alert-danger" role="alert"/>
        Password:<br>
        <form:password path="password"/><br>
        <form:errors path="password" element="div" class="alert alert-danger" role="alert"/>
        <input type="submit" class="btn btn-primary" value="SIGNUP"/>
    </form:form>
        </div>
        </div>
    </div>
</div>
</body>
</html>
