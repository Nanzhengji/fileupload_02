<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>文件上传</title>
</head>
<body>
	<form action="fileuploadServlet"  method="post" enctype="multipart/form-data">
		file name:<input type="text" name="myfile"><br/>
		<input type="file" name="pic"> <br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>