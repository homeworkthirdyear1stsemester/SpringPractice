<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: clack
  Date: 2019-08-30
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<!-- modelAttribute는 controller의 addAttribute에 이름과 동일해야한다 -->
<form:form action="processForm" modelAttribute="student">
    First name : <form:input path="firstName"/>
    <br/><br/>

    Last name : <form:input path="lastName"/>
    <br/><br/>

    Country:
    <form:select path="country">
        <form:option value="Korea" label="Korea"/>
        <form:option value="Brazil" label="Brazil"/>
        <form:option value="Germany" label="Germany"/>
        <form:option value="France" label="France"/>
    </form:select>
    <br/><br/>

    <input type="submit" value="Submit"/>
</form:form>
<!-- path에 이름에 set을 mapping해서 넣어준다 -->
</body>
</html>
