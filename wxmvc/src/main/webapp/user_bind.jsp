<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信与员工号绑定</title>
</head>
<body>
<form action="userBindServlet" method="GET"><br/>
<h2>微信与员工号绑定</h2>
请输入您的姓名: &nbsp&nbsp&nbsp&nbsp<input name="name" /><br/>
请输入您的员工号:&nbsp&nbsp<input name="employee_id" /><br/>
<input type="hidden" name="user_alias" value="<%=request.getParameter("user_alias")%>" /><br/><br/>
<input type="submit" value="提交"></input>
</form>

</body>
</html>