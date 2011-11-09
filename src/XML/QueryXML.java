/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Negocio.Acabamento;
import Negocio.Canto;
import Negocio.Cor;
import Negocio.Material;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
 * @author Miguel
 */
public class QueryXML {

    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document doc = null;

    public QueryXML(URL xml) throws ParserConfigurationException, SAXException, IOException {
        factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder = factory.newDocumentBuilder();

        String url = "http://dl.dropbox.com/u/3025160/DataBase.xml";
        String path1 = "c:\\norconcept\\DataBase.xml";
        String path2 = "src\\Info\\DataBaseFR.xml";

        /* URL que é enviado pelo interface e pode ser de qualquer lado que esteja o ficheiro da DB*/
        InputStream is = xml.openStream();

        /*URL para dentro do projecto, se ficar este não é preciso a query receber algum parametro */
        String local_string = "/Info/DataBase2.xml";
        URL local_url = this.getClass().getResource(local_string);
        InputStream inputLocal = local_url.openStream();

        doc = builder.parse(inputLocal);
    }

    public void queryTeste() throws SAXException, IOException, XPathExpressionException, ParserConfigurationException {
        XPathExpression expr = null;
        XPathFactory xFactory = XPathFactory.newInstance();
        XPath xpath = xFactory.newXPath();

        expr = xpath.compile("/norconcept/materiais/material/nome_material");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);

        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getTextContent());
        }

    }

    /****************************************/
    /*           TIPO MATERIAIS             */
    /****************************************/
    public ArrayList<String> queryTipoMateriais() throws XPathExpressionException {
        ArrayList<String> tipos_materiais = new ArrayList<String>();

        // procurar os materiais
        XPathExpression expr = null;
        XPathFactory xFactory = XPathFactory.newInstance();
        XPath xpath = xFactory.newXPath();

        expr = xpath.compile("//tipo_material/@tipo");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);

        NodeList nodes = (NodeList) result;

        for (int i = 0; i < nodes.getLength(); i++) {
            tipos_materiais.add(nodes.item(i).getTextContent());
        }

        //System.out.println(r.toString());
        //JOptionPane.showMessageDialog(null, "Materiais:\n"+tipos_materiais.toString());

        return tipos_materiais;
    }

    /****************************************/
    /*             MATERIAIS                */
    /****************************************/
    public ArrayList<String> queryMateriais(String tipo_material) throws XPathExpressionException {
        ArrayList<String> materiais = new ArrayList<String>();

        // procurar os materiais
        XPathExpression expr = null;
        XPathFactory xFactory = XPathFactory.newInstance();
        XPath xpath = xFactory.newXPath();

        expr = xpath.compile("//tipo_material[./@tipo='" + tipo_material + "']/material/tipo_material_nome");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);

        NodeList nodes = (NodeList) result;

        for (int i = 0; i < nodes.getLength(); i++) {
            materiais.add(nodes.item(i).getTextContent());
        }

        //System.out.println(r.toString());
        //JOptionPane.showMessageDialog(null, "Materiais:\n"+materiais.toString());

        return materiais;

    }

    /****************************************/
    /*               CORES                  */
    /****************************************/
    public ArrayList<String> queryCores(String material) {
        ArrayList<String> cores = new ArrayList<String>();

        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            // cores de um determinado material
            String query = "//tipo_material[./@tipo='pedra']/material/cores/cor/cor_nome[../../../tipo_material_nome='" + material + "']";
            expr = xpath.compile(query);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;
            //String s = "";
            //String s2 = "";
            for (int i = 0; i < nodes.getLength(); i++) {
                String nome_cor = nodes.item(i).getTextContent();
                cores.add(nome_cor);
            }

        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query.\n" + "QueryXML:queryCores" + ex.getLocalizedMessage() + "\n" + ex.getMessage());
            Logger.getLogger(QueryXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cores;
    }

    public String queryCoresPrecoString(String material, String cor) {
        String p = "| ";

        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            // cores de um determinado material
            String query = "//tipo_material[./@tipo='pedra']/material/cores/cor/cor_preco[../../../tipo_material_nome='" + material + "' and ../cor_nome='" + cor + "']";
            expr = xpath.compile(query);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;
            //String s = "";
            //String s2 = "";
            for (int i = 0; i < nodes.getLength(); i++) {
                String valor = nodes.item(i).getTextContent();
                String espessura = nodes.item(i).getAttributes().getNamedItem("valor_espessura").getTextContent();
                p += valor + "€ (esp. " + espessura + "cm) | ";
            }
            //JOptionPane.showMessageDialog(null, p + "\n" + query);

        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query.\n" + "QueryXML:queryCores" + ex.getLocalizedMessage() + "\n" + ex.getMessage());
            Logger.getLogger(QueryXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    public String queryCoresUnidade(String material) {
        String unidade = "";

        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            // cores de um determinado material
            String query = "//tipo_material[./@tipo='pedra']/material/cores[../tipo_material_nome='" + material + "']";
            expr = xpath.compile(query);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;
            //String s = "";
            //String s2 = "";
            for (int i = 0; i < nodes.getLength(); i++) {
                String u = nodes.item(i).getAttributes().getNamedItem("unidade").getTextContent();
                unidade = u;
            }
            //JOptionPane.showMessageDialog(null, p + "\n" + query);

        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query.\n" + "QueryXML:queryCores" + ex.getLocalizedMessage() + "\n" + ex.getMessage());
            Logger.getLogger(QueryXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidade;
    }

    public Double queryCoresPreco(String material, String cor, String espessura) {
        Double preco = 0.0;

        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            // cores de um determinado material
            String query = "//tipo_material[./@tipo='pedra']/material/cores/cor/cor_preco[../../../tipo_material_nome='" + material + "' and ../" + cor + "' and @valor_espessura='" + espessura + "']";
            expr = xpath.compile(query);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;
            //String s = "";
            //String s2 = "";
            for (int i = 0; i < nodes.getLength(); i++) {
                String p = nodes.item(i).getTextContent();
                preco = Double.parseDouble(p);
            }
            //JOptionPane.showMessageDialog(null, p + "\n" + query);

        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query.\n" + "QueryXML:queryCoresPreco" + ex.getLocalizedMessage() + "\n" + ex.getMessage());
            Logger.getLogger(QueryXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return preco;
    }

    /****************************************/
    /*             ESPESSURAS               */
    /****************************************/
    public ArrayList<String> queryEspessuras(String material) {
        ArrayList<String> espessuras = new ArrayList<String>();

        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            // cores de um determinado material
            String query = "//tipo_material[./@tipo='pedra']/material/espessuras/espessura[../../tipo_material_nome='" + material + "']";
            expr = xpath.compile(query);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;
            //String s = "";
            //String s2 = "";
            for (int i = 0; i < nodes.getLength(); i++) {
                String valor = nodes.item(i).getAttributes().getNamedItem("valor_espessura").getTextContent();
                //String unidade = nodes.item(i).getAttributes().getNamedItem("unidade").getTextContent();
                //String esp = valor + " " + unidade;
                espessuras.add(valor);
            }

        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query.\n" + "QueryXML:queryEspessuras" + ex.getLocalizedMessage() + "\n" + ex.getMessage());
            Logger.getLogger(QueryXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return espessuras;
    }

    /****************************************/
    /*            ACABAMENTOS               */
    /****************************************/
    public TreeMap<Integer, Acabamento> queryAcabamentos(Integer idMaterial) {
        TreeMap<Integer, Acabamento> r = new TreeMap<Integer, Acabamento>();

        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            // cores de um determinado material
            String query = "//material[@id='" + idMaterial + "']/acabamentos/acabamento";
            expr = xpath.compile(query);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;

            for (int i = 0; i < nodes.getLength(); i++) {
                String nome = nodes.item(i).getTextContent();
                Integer id = Integer.parseInt(nodes.item(i).getAttributes().getNamedItem("id").getTextContent());

                Acabamento a = new Acabamento(id, nome);
                r.put(id, a);
            }

        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query.\n" + "QueryXML:queryAcabamentos" + ex.getLocalizedMessage() + "\n" + ex.getMessage());
            Logger.getLogger(QueryXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        //JOptionPane.showMessageDialog(null, r.toString());
        return r;
    }

    /****************************************/
    /*              CANTOS                  */
    /****************************************/
    public TreeMap<Integer, Canto> queryCantos(Integer idMaterial) {
        TreeMap<Integer, Canto> r = new TreeMap<Integer, Canto>();

        try {
            XPathExpression expr = null;
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();

            // cores de um determinado material
            String query = "//material[@id='" + idMaterial + "']/cantos/canto";
            expr = xpath.compile(query);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;

            //JOptionPane.showMessageDialog(null, query + "\n" + nodes.toString());

            ArrayList<Integer> ids = new ArrayList<Integer>();
            for (int i = 0; i < nodes.getLength(); i++) {
                String idS = nodes.item(i).getAttributes().getNamedItem("id").getTextContent();
                Integer id = Integer.parseInt(idS);

                NodeList filhos_de_canto = nodes.item(i).getChildNodes();

                String nome = "";
                double preco = 0;
                String path = "";
                for (int j = 0; j < filhos_de_canto.getLength(); j++) {
                    if (filhos_de_canto.item(j).getNodeName().equals("nome_canto")) {
                        nome = filhos_de_canto.item(j).getTextContent();
                    }
                    if (filhos_de_canto.item(j).getNodeName().equals("preco_canto")) {
                        preco = Double.parseDouble(filhos_de_canto.item(j).getTextContent());
                    }
                    if (filhos_de_canto.item(j).getNodeName().equals("imagem_canto")) {
                        path = filhos_de_canto.item(j).getTextContent();
                    }
                }
                //JOptionPane.showMessageDialog(null, "NOME: " + nome + "\nPRECO: " + preco);
                Canto c = new Canto(id, nome, preco, path);
                r.put(id, c);
            }

        } catch (XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query.\n" + "QueryXML:queryAcabamentos" + ex.getLocalizedMessage() + "\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR);
            Logger.getLogger(QueryXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {
            String msg = "Erro ao converter um preço! Ficheiro XML não está correto.\n";
            msg += "Erro no canto do material com id: " + idMaterial + "\n";
            JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR);
            System.out.println(msg);
        }

        //JOptionPane.showMessageDialog(null, r.toString());
        return r;
    }
}
