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

<title>My JSP 'articulos.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="Servlet_Articulos" method="post">
		<table>
			<tr>
				<td>Codigo Articulo</td>
				<td><input type="text" name="codigo_articulo"
					value="${requestScope.articulo.codigoArticulo}" /></td>
			</tr>
			<tr>
				<td>Descripcion</td>
				<td><input type="text" name="descripcion"
					value="${requestScope.articulo.descripcionArticulo}" /></td>
			</tr>
			<tr>
				<td>Precio unidad</td>
				<td><input type="text" name="precio_unidad"
					value="${requestScope.articulo.precioUnidadArticulo}" /></td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><input type="text" name="stock"
					value="${requestScope.articulo.cantidad}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Comprobar articulo" /></td>
			</tr>
		</table>
	</form>
	${requestScope.error_proceso}

</body>
</html>
