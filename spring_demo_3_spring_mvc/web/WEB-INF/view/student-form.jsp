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
        <form:options items="${student.countryOptions}"/>
        <!-- items에 get 함수로 호출하여서 해당 component에 있는 것들을 넣어준다 -->
        <!-- collection에 있는 것만 해당 한다 -->
    </form:select>
    <br/><br/>

    Favorite Language :
    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
    Python <form:radiobutton path="favoriteLanguage" value="Python"/>
    JavaScript <form:radiobutton path="favoriteLanguage" value="JavaScript"/>
    <br/><br/>

    Operating System :
    Linux <form:checkbox path="operatingSystem" value="Linux"/>
    MS Windows <form:checkbox path="operatingSystem" value="MS Windows"/>
    Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
    <br/><br/>

    <input type="submit" value="Submit"/>
</form:form>
<!-- path에 이름에 set을 mapping해서 넣어준다 -->
</body>
</html>