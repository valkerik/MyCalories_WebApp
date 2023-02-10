<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Meals</h2>


    <a href="meals?action=add"><h2>Add Meal</h2></a>

    <table border="1" cellspacing="0" cellpadding="10">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <jsp:useBean id="mealsListExcess" scope="request" type="java.util.List"/>
        <c:forEach var="meal" items="${mealsListExcess}">
            <tr style="color: ${meal.isExcess() ? 'red' : 'green'}">

                <td><fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedDateTime}" /></td>
                <td>${meal.getDescription()}</td>
                <td>${meal.getCalories()}</td>
                <td><a href="meals?action=edit&id=${meal.getId()}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>

<br/>
<br/>

</body>
</html>
