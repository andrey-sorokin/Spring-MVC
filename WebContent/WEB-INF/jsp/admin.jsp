<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h3>
		<spring:message code="label.username" />
		: ${username}
	</h3>

	<a href="<c:url value="/j_spring_security_logout" />"> <spring:message
			code="label.logout" /></a>
</div>
