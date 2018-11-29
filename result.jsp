<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>文件上传结果页</title>
</head>
<body>
<%
	String message =(String) request.getAttribute("message");
%>
${message}
</body>
</html>