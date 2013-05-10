<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<spring:message code="label.screen3" />
</div>

<table width="100%" border=2>

	<c:forEach var="imageURL" items="${imageList}">
		<tr>

			<td>
				<table width="100%">
					<tr>
						<td align="center" valign="middle"><img src="${imageURL.url}" />
					</tr>
				</table>
			</td>

			<td align="center" valign="top">
				<h3>
					<p>
						<b> ${imageURL.second_name} ${imageURL.first_name}
							${imageURL.middle_name} </b>
					</p>
				</h3>
				<p style="margin-bottom: 10px;"></p>

				<table width="100%">
					<tr>
					    <th>Position</th>
						<th>Subject</th>
						<th>Education</th>
						<th>Category</th>
						<th>Specialization</th>
					</tr>

					<tr>
					    <td align="center" valign="top">${imageURL.administration}</td>
						<td align="center" valign="top">${imageURL.subject}</td>
						<td align="center" valign="top">${imageURL.education}</td>
						<td align="center" valign="top">${imageURL.category}</td>
						<td align="center" valign="top">${imageURL.specialization}</td>
					</tr>
				</table>

			</td>

		</tr>
	</c:forEach>

</table>