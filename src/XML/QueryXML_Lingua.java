/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author miguel
 */
public class QueryXML_Lingua {

    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document doc = null;
    String _lingua = "pt";

    // <editor-fold defaultstate="collapsed" desc="QueryXML">
    public QueryXML_Lingua() {
        {
            InputStream inputLocal = null;
            try {
                factory = DocumentBuilderFactory.newInstance();
                factory.setNamespaceAware(true);
                builder = factory.newDocumentBuilder();
                String local_string = "/Info/Linguas.xml";
                URL local_url = this.getClass().getResource(local_string);
                inputLocal = local_url.openStream();
                doc = (Document) builder.parse(inputLocal);
            } catch (SAXException ex) {
                Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    inputLocal.close();
                } catch (IOException ex) {
                    Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public QueryXML_Lingua(URL xml) {
        {
            InputStream is = null;
            try {
                factory = DocumentBuilderFactory.newInstance();
                factory.setNamespaceAware(true);
                builder = factory.newDocumentBuilder();
                is = xml.openStream();
                String local_string = "/Info/Linguas.xml";
                URL local_url = this.getClass().getResource(local_string);
                InputStream inputLocal = local_url.openStream();
                doc = (Document) builder.parse(inputLocal);
            } catch (SAXException ex) {
                Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="text">
    public String queryText(String panel, String label) {
        String texto = "";
        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            String q = "//lingua/" + panel + "/" + label + "[../../@lingua='" + _lingua + "']";
            expr = xpath.compile(q);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;

            for (int i = 0; i < nodes.getLength(); i++) {
                texto = nodes.item(i).getTextContent();
            }

        } catch (XPathExpressionException ex) {
            Logger.getLogger(QueryXML_Lingua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }// </editor-fold>

    public String getLingua(){
        return _lingua;
    }
    
    public void setLingua(String lingua) {
        _lingua = lingua;
    }
}
