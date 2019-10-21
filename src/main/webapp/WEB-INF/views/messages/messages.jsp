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
    <h5>Send new message</h5>
    <div class="card">
        <div class="card-body">
            <div class="form-group"></div>
            <form:form method="post" modelAttribute="new_message">
                Text:<br>
                <form:textarea path="message" cols="40" rows="3"/><br>
                <form:select path="recipient" items="${users}" itemValue="id" itemLabel="email"/>
                <form:hidden path="sender.id"/>
                <input type="submit" class="btn btn-primary" value="Send"/>
            </form:form>
            <c:if test="${param.errorMsg.equals('recipientError')}"><div class="p-3 mb-2 bg-danger text-white">Recipient must be different then Sender</div></c:if>
        </div>
    </div>
</div>
<div class="container border border-secondary">
    <span class="border border-info bg-info">Received Messages</span>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Sender</th>
            <th>Created</th>
            <th>Message</th>
            <th>Option</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${received_message}" var="el">
            <c:if test="${el.readFlag==false}">
                <tr>
                <th>${el.sender.email}</th>
                <th>${el.created}</th>
                <th>${el.message}</th>
                <th><a href="/message/read/${el.id}" class="btn btn-primary">Read</a> </th>
                </tr>
            </c:if>
            <c:if test="${el.readFlag==true}">
                <tr>
                    <td>${el.sender.email}</td>
                    <td>${el.created}</td>
                    <td>${el.message}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="container border border-secondary">
    <span class="border border-info bg-info">Sent Messages</span>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Receipient</th>
            <th>Created</th>
            <th>Message</th>
            <th>Option</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sent_message}" var="el">
            <c:if test="${el.readFlag==false}">
                <tr>
                    <th>${el.recipient.email}</th>
                    <th>${el.created}</th>
                    <th>${el.message}</th>
                </tr>
            </c:if>
            <c:if test="${el.readFlag==true}">
                <tr>
                    <td>${el.sender.email}</td>
                    <td>${el.created}</td>
                    <td>${el.message}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
