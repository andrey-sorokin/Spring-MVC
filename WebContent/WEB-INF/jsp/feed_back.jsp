<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
textarea#styled {
	width: 600px;
	height: 120px;
	border: 3px solid #cccccc;
	padding: 5px;
	font-family: Tahoma, sans-serif;
	background-image: url(bg.gif);
	background-position: bottom right;
	background-repeat: no-repeat;
}
</style>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>

	<form:form autocomplete="off" method="POST" commandName="customer">

		<form:errors path="*" cssClass="errorblock" element="div" />
		<div align="center">
			<table>
				<tr>
					<td><spring:message code="label.feed_back.first_name" /></td>
					<td><form:input path="name" autocomplete="off" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.feed_back.second_name" /></td>
					<td><form:input path="surName" autocomplete="off" /></td>
					<td><form:errors path="surName" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td><spring:message code="label.feed_back.email" /></td>
					<td><form:input path="email" autocomplete="off" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td><spring:message code="label.feed_back.category" /></td>
					<td><form:select path="category">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${categoryList}" />
						</form:select></td>
					<td><form:errors path="category" cssClass="error" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.feed_back.message" /></td>
					<td><form:textarea  name="styled-textarea" id="styled" path="message" autocomplete="off" /></td>
					<td><form:errors path="message" cssClass="error" /></td>
				</tr>

				<tr>
					<td colspan="3"><input type="submit" /></td>
				</tr>
			</table>
	</form:form>
	</div>
</body>
</html>