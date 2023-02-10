<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Meal</title>
</head>
<body>

<title>Meal</title>
<br/>
<h2>Meals</h2>
<br/>
<h2>
    <form method="POST" action='add' name="frmAddMeal">
        <jsp:useBean id="now" class="java.util.Date" scope="page"/>
        DateTime : <input type="datetime-local" name="dateTime" value="<fmt:formatDate type="time" value="${now}" pattern="yyyy-MM-dd HH:mm"/>"  />
        <br/>
        Description : <input type="text" name="descripton" value="<c:out value="${meal.description}" />" />
        <br/>
        Calories : <input type="text" name="calories" value="<c:out value="${meal.calories}" />" />
        <br/>
        <td><button type="submit" class="btn btn-success">Save</button></td>
        <td><input type="submit" name="meals?action=meals"  value="Cancel" /></td>


    </form>
</h2>
</body>
</html>