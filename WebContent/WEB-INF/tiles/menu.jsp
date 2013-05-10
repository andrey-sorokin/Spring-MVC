<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul id="menu">
	<li><a href="<c:url value="welcome"/>"><spring:message
				code="label.link_welcome" /></a></li>
	<li><a href="<c:url value="link1"/>"><spring:message
				code="label.link1" /></a></li>
	<li><a href="<c:url value="link2"/>"><spring:message
				code="label.link2" /></a></li>
	<li><a href="<c:url value="link3"/>"><spring:message
				code="label.link3" /></a></li>
	<li><a href="#"><spring:message code="label.topic1" /></a>
		<ul>
			<li><a href="<c:url value="dummy"/>"><spring:message
						code="label.link1" /></a></li>

			<li><a href="<c:url value="dummy"/>"><spring:message
						code="label.link2" /></a></li>
		</ul></li>
	<li><a href="<c:url value="feed_back"/>"><spring:message
				code="label.link4" /></a></li>
	<li><a href="#"><spring:message code="label.topic2" /></a>
		<ul>
			<li><a href="#"><spring:message code="label.topic3" /></a>
				<ul>
					<li><a href="<c:url value="dummy"/>"><spring:message
								code="label.link1" /></a></li>
					<li><a href="<c:url value="dummy"/>"><spring:message
								code="label.link2" /></a></li>
					<li><a href="<c:url value="dummy"/>"><spring:message
								code="label.link3" /></a></li>
				</ul></li>
			<li><a href="<c:url value="dummy"/>"><spring:message
						code="label.link1" /></a></li>
		</ul></li>
	<li><a href="<c:url value="admin"/>"><spring:message
				code="label.admin" /></a></li>
</ul>