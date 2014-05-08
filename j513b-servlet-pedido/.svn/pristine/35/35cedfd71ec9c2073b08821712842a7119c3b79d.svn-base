<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="javascript/funciones.js"></script>
</head>

<body>
	<form action="Servlet_Login" method="post"
		onsubmit="return validar_login();">
		<table>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre_usuario"
					id="nombre_usuario" value="Juan" /></td>
			</tr>
			<tr>
				<td>Clave</td>
				<td><input type="password" name="clave_usuario"
					id="clave_usuario" value="admin" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="boton" value="Comprobar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
