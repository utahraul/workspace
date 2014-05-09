<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<fmt:setBundle basename="${sessionScope.idioma_elegido}" />

<div id="capa_imagen">
	<img id="imagen_ajax_articulos" src="" />
</div>

<div id="capa_cabecera">
	<form>
		<table>
			<tr>
				<td><fmt:message key="formu.eti.codigocliente" /></td>
				<td><input type="text" id="cod_cliente" name="cod_cliente"
					size="5" value="" maxlength="5" /></td>
				<td><fmt:message key="formu.eti.nombrecliente" /></td>
				<td><input type="text" id="nombre_cliente"
					name="nombre_cliente" size="25" value="" maxlength="35" /></td>
				<td><fmt:message key="formu.eti.telefono" /></td>
				<td><input type="text" id="telefono" name="telefono" size="9"
					readonly="readonly" value="" /></td>
			</tr>
			<tr>
				<td><fmt:message key="formu.eti.cifnif" /></td>
				<td><input type="text" id="cif" name="cif" size="9"
					readonly="readonly" value="" /></td>
				<td><fmt:message key="formu.eti.calle" /></td>
				<td><input type="text" id="calle" name="calle" size="25"
					readonly="readonly" value="" /></td>
				<td><fmt:message key="formu.eti.ciudad" /></td>
				<td><input type="text" id="ciudad" name="ciudad"
					readonly="readonly" value="" /></td>
			</tr>
			<tr>
				<td><fmt:message key="formu.eti.provincia" /></td>
				<td><input type="text" id="provincia" name="provincia" size="9"
					readonly="readonly" value="" /></td>
				<td><fmt:message key="formu.eti.email" /></td>
				<td><input type="text" id="email" name="email" size="25"
					readonly="readonly" value="" /></td>
				<td><fmt:message key="formu.eti.codpostal" /></td>
				<td><input type="text" id="cod_postal" name="cod_postal"
					readonly="readonly" value="" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><fmt:message key="formu.bot.confirmarcliente" var="bot" />
					<input type="button" value="${bot}" id="boton_confirmar"
					onclick="actualizar_cli_ajax();" class="boton" /></td>
				<td><fmt:message key="formu.bot.listadoclientes" var="bot" />
					<input type="button" value="${bot}" id="boton_mostrar"
					onclick="mostrar_ayuda(true);" class="boton" /></td>
				<td><fmt:message key="formu.bot.anularcliente" var="bot" /> <input
					type="button" value="${bot}" id="boton_anular"
					onclick="limpiar_cabecera();" class="boton" /></td>
			</tr>
		</table>
	</form>
</div>

<div id="capa_error_cliente">
	<table>
		<tr>
			<td>
				<div id="error_cliente"></div>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="formu.bot.ocultarmensaje" var="bot" /> <input
				type="button" value="${bot}" onclick="cerrar_mensaje(false);"
				class="boton" /></td>
		</tr>
	</table>
</div>