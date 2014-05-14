<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="/tlds/mis_etiquetas.tld" prefix="mia"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<html:base ref="site"/>

<title>subida.jsp</title>

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
	<html:form method="post" action="subir_fichero"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Nombre usuario:</td>
				<td><html:text property="nombre_usuario" /></td>
			</tr>
			<tr>
				<td colspan="2"><html:file property="fichero_subido" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2"><html:submit value="Subida"></html:submit></td>
			</tr>
			<tr>
				<td colspan="2">${requestScope.mensaje_subida== null ? ""
					:requestScope.mensaje_subida}</td>
			</tr>
		</table>
	</html:form>

	<div id="capa_ficheros_subidos">
		<table border="1">
			<thead align="center">
				<tr>
					<td colspan="4">LISTADO DE FICHEROS EN SERVIDOR.</td>
				</tr>
				<tr>
					<td>Nombre Fichero</td>
					<td>Fecha subida</td>
					<td>Tamaño (MB.)</td>
					<td>Descargas</td>
				</tr>
			</thead>
			<tbody>
				<mia:calculo_ficherossubidos
					carpeta_usuario="${sessionScope.carpeta}">

				</mia:calculo_ficherossubidos>
			</tbody>
		</table>
	</div>
</body>
</html:html>
