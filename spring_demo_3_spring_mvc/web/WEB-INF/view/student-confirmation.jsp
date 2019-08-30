<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: clack
  Date: 2019-08-30
  Time: 오후 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
The Student is confirmed : ${student.firstName} ${student.lastName}
<!-- getter를 호출 한다 -->
<br/><br/>

Country : ${student.country}
<br/><br/>

Favorite Language : ${student.favoriteLanguage}
<br/><br/>

Operating System :
<ul>
    <c:forEach var="operatingSystemListItem" items="${student.operatingSystem}">
        <li>${operatingSystemListItem}</li>
    </c:forEach>
</ul>

</body>
</html>
