<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="add.goal.title"/></title>
</head>
<body>
	<form:form commandName="goal">
		<table>
			<tr>
				<td><spring:message code="add.goal.enter.minutes"/></td>
				<td><form:input path="minutes"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" Value="<spring:message code="add.goal.accept"/>"/></td>
			</tr>			
		</table>
	</form:form>
</body>
</html>