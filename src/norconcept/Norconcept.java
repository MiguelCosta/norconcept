/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package norconcept;

import Interface.JAppletMain2;
import XML.QueryXML;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author Miguel
 */
public class Norconcept {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JAppletMain2 m = new JAppletMain2();
        m.init();
        /*
        try {
            QueryXML q = new QueryXML();
            q.queryTeste();
            q.queryMateriais();
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Norconcept.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Norconcept.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Norconcept.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Norconcept.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
