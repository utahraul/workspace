package com.atrium.modelo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Datos_DAO extends DefaultHandler {

	private String etiqueta_leida;
	private Datos_DTO datos;

	public Datos_DAO() {
		datos = new Datos_DTO();
	}

	public Datos_DTO leer_Datos() {
		try {
			XMLReader lector = XMLReaderFactory.createXMLReader();
			lector.setContentHandler(this);
			lector.parse(this.getClass()
					.getResource("/com/atrium/vista/datos.xml").getFile());
		} catch (SAXException e) {
			e.printStackTrace();
			datos = null;
		} catch (IOException e) {
			e.printStackTrace();
			datos = null;
		}
		return datos;
	}

	public boolean escribir_Datos(Datos_DTO datos_nuevos) {
		boolean valido = true;
		try {
			// LEEMOS EL XML Y SE CREA LA ESTRUCTURA DOM
			DocumentBuilderFactory fact_dom = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder lector = fact_dom.newDocumentBuilder();
			// OBTENEMOS EL OBJETO QUE TIENE SU CONTENIDO PARA MODIFICARLO
			Document documento_DOM = lector.parse(this.getClass()
					.getResource("/com/atrium/vista/datos.xml").getFile());

			// COGEMOS LA ETIQUETA QUE CONTIENE EL ATRIBUTO A CAMBIAR
			Node elemento_xml = documento_DOM.getElementsByTagName("nombre")
					.item(0);
			elemento_xml.setTextContent(datos_nuevos.getNombre());

			elemento_xml = documento_DOM.getElementsByTagName("apellido").item(
					0);
			elemento_xml.setTextContent(datos_nuevos.getApellido());

			elemento_xml = documento_DOM.getElementsByTagName("calle").item(0);
			elemento_xml.setTextContent(datos_nuevos.getCalle());

			elemento_xml = documento_DOM.getElementsByTagName("ciudad").item(0);
			elemento_xml.setTextContent(datos_nuevos.getCiudad());

			// ESCRIBIMOS EL DOCUMENTO MODIFICADO
			TransformerFactory fact = TransformerFactory.newInstance();
			Transformer flujo_escritura = fact.newTransformer();
			// QUE CONTENIDO VAMOS A ESCRIBIR
			DOMSource entrada_datos = new DOMSource(documento_DOM);
			// DONDE LO VAMOS A ESCRIBIR
			StreamResult apuntador = new StreamResult(this.getClass()
					.getResource("/com/atrium/vista/datos.xml").getFile());
			// ESCRIBIMOS
			flujo_escritura.transform(entrada_datos, apuntador);

		} catch (Exception e) {
			valido = false;
		}
		return valido;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		etiqueta_leida = localName;
	}

	@Override
	public void characters(char[] texto, int inicio, int tamaño)
			throws SAXException {
		String texto_eti = new String(texto, inicio, tamaño);
		if (texto_eti.indexOf("\n") == -1) {
			if (etiqueta_leida.equals("fecha")) {
				datos.setFecha(texto_eti);
			}
			if (etiqueta_leida.equals("autor")) {
				datos.setAutor(texto_eti);
			}
			if (etiqueta_leida.equals("nombre")) {
				datos.setNombre(texto_eti);
			}
			if (etiqueta_leida.equals("apellido")) {
				datos.setApellido(texto_eti);
			}
			if (etiqueta_leida.equals("calle")) {
				datos.setCalle(texto_eti);
			}
			if (etiqueta_leida.equals("ciudad")) {
				datos.setCiudad(texto_eti);
			}
		}
	}

}
