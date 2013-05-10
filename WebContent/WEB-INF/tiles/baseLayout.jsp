<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<script src="resources/scripts/jquery-1.8.3.min.js"></script>
<script src="resources/scripts/jquery-ui-1.9.2.min.js"></script>
<link rel="stylesheet"
	href="resources/demos/css/ui-lightness/jquery-ui-1.9.2.custom.min.css" />

<script>
	history.forward();
</script>

<script type="text/javascript">
	function noBack() {
		window.history.forward()
	}
	noBack();
	window.onload = noBack;
	window.onpageshow = function(evt) {
		if (evt.persisted)
			noBack()
	}
	window.onunload = function() {
		void (0)
	}
</script>

<script>
	$(function() {
		$("#menu").menu();
	});
</script>

<style>
.ui-menu {
	width: 300px;
}
</style>

</head>
<body onload="noBack();" onpageshow="if(event.persisted)noBack();"
	onunload="">
	<table width="100%" height="100%" border="8" cellpadding="2"
		cellspacing="2" align="center">
		<tr>
			<td width="100%" height="10%" colspan="2"><tiles:insertAttribute
					name="header" /></td>
		</tr>
		<tr>
			<td width="20%" height="85%"><tiles:insertAttribute name="menu" />
			</td>
			<td width="80%" height="85%"><tiles:insertAttribute name="body" />
			</td>
		</tr>
		<tr>
			<td width="100%" height="5%" colspan="2"><tiles:insertAttribute
					name="footer" /></td>
		</tr>
	</table>
</body>
</html>
