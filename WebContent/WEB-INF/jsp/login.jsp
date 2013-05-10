<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<c:if test="${not empty error}">
	<div class="errorblock">
		Your login attempt was not successful, try again.<br /> Caused :
		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	</div>
</c:if>

<form autocomplete="off" name='f' action="<c:url value='j_spring_security_check' />"
	method='POST'>
	<div align="center">
		<table>
			<tr>
				<td><spring:message code="label.user" />:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td><spring:message code="label.password" />:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
		</table>

		<input value=<spring:message code="label.submit"/> type="submit" /> <input
			value=<spring:message code="label.reset"/> type="reset" />

	</div>
</form>
