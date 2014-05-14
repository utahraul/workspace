<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<html:base ref="site" />

<title>listas.jsp</title>

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
	<html:form action="listas_accion" method="post">
		<table>
			<tr>
				<td>Paises</td>
				<td><html:select property="pais_seleccionado" 
						onchange="actualizar_provincias();">
						<html:optionsCollection property="lista_paises" value="value"
							label="texto" />
					</html:select></td>
				<td>Provincias</td>
				<td><html:select property="provincia_seleccionada">
						<html:optionsCollection property="lista_provincias" value="value"
							label="texto" />
					</html:select></td>
			</tr>
		</table>
	</html:form>
</body>
</html:html>
