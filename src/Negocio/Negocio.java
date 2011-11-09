/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import XML.QueryXML;
import java.io.IOException;
import java.net.URL;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author Miguel
 */
public class Negocio {
/*
    BaseDados _db = new BaseDados();
    QueryXML _q;

    public Negocio(URL xml) {
        try {
            _q = new QueryXML(xml);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao carregar a BD\n" + ex.getLocalizedMessage() + "\n" + ex.getMessage(), "ERRO", JOptionPane.OK_OPTION);
        } catch (SAXException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao carregar a BD\n" + ex.getLocalizedMessage() + "\n" + ex.getMessage(), "ERRO", JOptionPane.OK_OPTION);
        } catch (IOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao carregar a BD\n" + ex.getLocalizedMessage() + "\n" + ex.getMessage(), "ERRO", JOptionPane.OK_OPTION);
        }

    }
*/
    /****************************************/
    /*            MATERIAIS                 */
    /****************************************/
/*    public void carregarMateriais() {
        try {
            _db.setMateriais(_q.queryMateriais());
        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os materiais: Negocio:carregaMaterias\n" + ex.getLocalizedMessage() + "\n" + ex.getMessage(), "ERRO", JOptionPane.OK_OPTION);
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TreeMap<Integer, Material> getMateriais() {
        return _db.getMateriais();
    }
*/
    /****************************************/
    /*              CORES                   */
    /****************************************/
/*    public void carregarCores(Integer idMaterial) {
        if (_db.getCores(idMaterial).isEmpty()) {
            _db.setCores(idMaterial, _q.queryCores(idMaterial));
        }
    }

    public TreeMap<Integer, Cor> getCores(Integer idMaterial) {
        return _db.getCores(idMaterial);
    }
*/
    /****************************************/
    /*            ACABAMENTOS               */
    /****************************************/
/*    public void carregarAcabamentos(Integer idMaterial) {
        if (_db.getAcabamentos(idMaterial).isEmpty()) {
            _db.setAcabamentos(idMaterial, _q.queryAcabamentos(idMaterial));
        }
    }

    public TreeMap<Integer, Acabamento> getAcabamentos(Integer idMaterial) {
        return _db.getAcabamentos(idMaterial);
    }
*/
    /****************************************/
    /*               CANTOS                 */
    /****************************************/
/*    public void carregarCantos(Integer idMaterial) {
        if (_db.getCantos(idMaterial).isEmpty()) {
            _db.setCantos(idMaterial, _q.queryCantos(idMaterial));
        }
    }

    public TreeMap<Integer, Canto> getCantos(Integer idMaterial) {
        return _db.getCantos(idMaterial);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(_db.toString());

        return s.toString();
    }
     * 
     */
}
