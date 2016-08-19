<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>
<html>
<body>
<h2>${id}</h2>
<h2>${user.userName}</h2>
<script src="<%=path%>/static/script/jquery-1.7.2.js" type="text/javascript"></script>
</body>
</html>
