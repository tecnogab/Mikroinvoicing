package ar.com.jgt.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class ReadXML {

	Document dom;
	DocumentBuilderFactory dbf;
	DocumentBuilder db;

	public ReadXML() {

	}

	public void metodo1() {
		dbf = DocumentBuilderFactory.newInstance();
		try {
			db = dbf.newDocumentBuilder();
			dom = db.parse(System.getProperty("user.dir") + "/xml/test.xml");
			Element rootElement = dom.getDocumentElement();
			NodeList nodeList = rootElement.getElementsByTagName("persona");

			if (nodeList != null && nodeList.getLength() > 0) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					Element element = (Element) nodeList.item(i);
					if (element.hasAttribute("sexo"))
						System.out.println(element.getAttribute("sexo"));
					NodeList nodeList2 = element.getElementsByTagName("nombre");
					if (nodeList2 != null && nodeList2.getLength() > 0) {
						Element el = (Element) nodeList2.item(0);
						System.out.println("Nombre: " + el.getFirstChild().getNodeValue());
					}
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Document crearXML() {
		Document l_document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			l_document = implementation.createDocument(null, "xml", null);

			// Creación de elementos
			// creamos el elemento principal casa
			Element casa = l_document.createElement("Casa");
			// creamos un nuevo elemento. Casa contiene habitaciones
			Element habitacion = l_document.createElement("Habitacion");
			// creamos un nuevo elemento. Habitación tiene color
			Element color = l_document.createElement("Color");
			// Ingresamos la info. El color de esta habitación es azul
			Text valorColor = l_document.createTextNode("Azul");

			// Asignamos la versión de nuestro XML
			l_document.setXmlVersion("1.0");
			// Añadimos la casa al documento
			l_document.getDocumentElement().appendChild(casa);
			// Añadimos el elemento hijo a la raíz
			casa.appendChild(habitacion);
			// Añadimos elemento
			habitacion.appendChild(color);
			// Añadimos valor
			color.appendChild(valorColor);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return l_document;
	}

	// Volcamos XML al fichero
	public static void guardaConFormato(Document p_document, String p_URI) {
		try {
			TransformerFactory transFact = TransformerFactory.newInstance();

			// Formateamos el fichero. Añadimos sangrado y la cabecera de XML
			transFact.setAttribute("indent-number", new Integer(3));
			Transformer l_trans = transFact.newTransformer();
			l_trans.setOutputProperty(OutputKeys.INDENT, "yes");
			l_trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

			// Hacemos la transformación
			StringWriter l_sw = new StringWriter();
			StreamResult l_sr = new StreamResult(l_sw);
			DOMSource l_domSource = new DOMSource(p_document);
			l_trans.transform(l_domSource, l_sr);

			// Mostrar información a guardar por consola (opcional)
			// Result console = new StreamResult(System.out);
			// trans.transform(domSource, console);
			try {
				// Creamos fichero para escribir en modo texto
				PrintWriter l_writer = new PrintWriter(new FileWriter(p_URI));
				// Escribimos todo el árbol en el fichero
				l_writer.println(l_sw.toString());
				// Cerramos el fichero
				l_writer.close();
			} catch (IOException p_IOException) {
				p_IOException.printStackTrace();
			}
		} catch (Exception p_exception) {
			p_exception.printStackTrace();
		}
	}
	
//	public static void AnadirCaracteristica(String URI){
//	    try {
//	        //Obtenemos el document del fichero XML existente
//	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//	        DocumentBuilder db = dbf.newDocumentBuilder();
//	        document = db.parse(new File(URI));
//	        document.getDocumentElement().normalize();
//	    } catch (ParserConfigurationException e) {
//	        e.printStackTrace();
//	    } catch (SAXException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//
//	    //Creamos un nuevo elemento en la casa
//	    Element terraza = document.createElement("Terraza");
//	    //Le añadimos una característica
//	    Element tamano = document.createElement("Tamano");
//	    //Le añadimos su valor
//	    Text valor = document.createTextNode("20m2");
//
//	    //Añadimos la información a la casa ya existente
//	    NodeList nodoRaiz = document.getDocumentElement().getElementsByTagName("Casa");
//	    nodoRaiz.item(0).appendChild(terraza);
//	    terraza.appendChild(tamano);
//	    tamano.appendChild(valor);
//
//	    //Guardamos la nueva estructura la fichero XML
//	}

}
