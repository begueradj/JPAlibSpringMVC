<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
        <h1>List of users</h1>	
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
        </tr>
        </c:forEach>
</body>
</html>