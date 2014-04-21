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

<title>Consultar Artículos</title>

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
	<form action="servlet/Servlet_Articulos" method="post">
		<table>
			<tr>
				<td>Código Artículo:</td>
				<td><input type="text" name="codigo_articulo" value="${param.codigo_articulo}" /></td>
				
			</tr>
			<tr>
				<td>Descripción Artículo:</td>
				<td><input type="text" name="descripcion" value="${param.descripcion}"/></td>
				
			</tr>
						<tr>
				<td>Precio Unidad Artículo:</td>
				<td><input type="text" name="precio_unidad" value="${param.precio_unidad}"/></td>
				
			</tr>
						<tr>
				<td>Cantidad Artículo:</td>
				<td><input type="text" name="stock" value="${param.stock}"/></td>
				
			</tr>
			<tr align="center">
				<th colspan="2"><input type="submit" value="Comprobar Artículo" /></th>
			</tr>
		</table>
	</form>
</body>
</html>




