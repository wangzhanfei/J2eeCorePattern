<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<!-- 使用el表达式将products赋值给tag:buildtable -->
<tag:buildtable products="${products}"></tag:buildtable>
<body>
	This is my JSP page.
	<br>
</body>
</html>
