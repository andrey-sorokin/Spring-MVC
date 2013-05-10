<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<HEAD>

<SCRIPT type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</SCRIPT>
</HEAD>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">

	<div align="center">

		<spring:message code="label.feed_back_success.confirmation_message" />
	
		<table width="80%" height="100%" border="2">
			<tr>
				<td width="20%"><spring:message code="label.feed_back_success.first_name" /></td>
				<td>${customer.name}</td>
			</tr>
			<tr>
				<td><spring:message code="label.feed_back_success.second_name" /></td>
				<td>${customer.surName}</td>
			</tr>
			<tr>
			<tr>
				<td><spring:message code="label.feed_back_success.email" /></td>
				<td>${customer.email}</td>
			</tr>
			<tr>
		</table>
	</div>
</body>
</html>