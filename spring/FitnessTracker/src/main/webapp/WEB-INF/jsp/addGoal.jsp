<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="add.goal.title"/></title>
<style type="text/css">
	.error {
		color: #FF0000;
	}
	.errorblock {
		color: #000;
		background-color: #FFEEEE;
		border: 3px solid #FF0000;
		padding: 8px;
		margin: 16px;
	}
</style>
</head>
<body>
	<form:form commandName="goal">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><spring:message code="add.goal.enter.minutes"/></td>
				<td><form:input path="minutes" cssErrorClass="error"/></td>
				<td><form:errors path="minutes" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" Value="<spring:message code="add.goal.accept"/>"/></td>
			</tr>			
		</table>
	</form:form>
</body>
</html>