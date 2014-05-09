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

<title>My JSP 'pedido.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/cabecera.css">
<link rel="stylesheet" type="text/css" href="css/cuerpo.css">
<link rel="stylesheet" type="text/css" href="css/pie.css">

<script type="text/javascript" src="javascript/funciones_cabecera.js"></script>

</head>

<body>
	<jsp:include page="/jsp/pedido/cabecera.jsp" />
	<jsp:include page="/jsp/pedido/cuerpo.jsp" />
	<jsp:include page="/jsp/pedido/pie.jsp" />
</body>
</html>
