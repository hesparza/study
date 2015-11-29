<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Minutes</title>
</head>
<body>

	<h1><spring:message code="add.minutes.add.minutes.exercised"/></h1>
	
	<spring:message code="add.minutes.language"/><a href="?ln=en"><spring:message code="add.minutes.english"/></a> | <a href="?ln=es"><spring:message code="add.minutes.spanish"/></a>
	<br />
	<br />
	<form:form commandName="exercise">
		<table>
			<tr>
				<td><spring:message code="goal.text"/></td>
				<td><form:input path="minutes"/> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="submit" value="<spring:message code="add.minutes.enter.minutes.here"/>" /></td>
			</tr>
		</table>
	</form:form>
	
	<h2><spring:message code="add.minutes.goal.for.the.day"/> ${goal.minutes}</h2>
</body>
</html>