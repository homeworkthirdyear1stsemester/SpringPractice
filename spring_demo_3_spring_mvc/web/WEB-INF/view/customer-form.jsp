<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: clack
  Date: 2019-09-03
  Time: 오전 6:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<i>Fill out the form. Asterish (*) means required.</i>
<br/><br/>

<form:form action="processForm" modelAttribute="customer">
    First name : <form:input path="firstName"/>
    <br/><br/>

    Last name (*) : <form:input path="LastName"/>
    <form:errors path="LastName" cssClass="error"/>
    <!-- display error message if you set -->
    <br/><br/>

    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
