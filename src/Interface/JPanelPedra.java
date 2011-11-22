/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelPedra.java
 *
 * Created on 2/Nov/2011, 17:18:17
 */
package Interface;

import Config.StringHtml;
import XML.QueryXML;
import XML.QueryXML_Lingua;
import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.xpath.XPathExpressionException;
import mvc.Observer;
import mvc.Subject;

/**
 *
 * @author miguel
 */
public class JPanelPedra extends javax.swing.JPanel implements Observer, Subject {
    
    private QueryXML _q;
    private QueryXML_Lingua _l;
    private ArrayList<String> cores;
    private int num_linhas_peca = 0;
    private int num_linhas_rodape = 0;
    private int num_linhas_furos = 0;
    private int num_linhas_rebaixos = 0;
    private String _material = "";
    private String _cor = "";
    private DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String _tipo_material = "";

    /** Creates new form JPanelPedra */
    public JPanelPedra(QueryXML q, QueryXML_Lingua l, String tipo_material) {
        initComponents();
        
        _q = q;
        _l = l;
        _tipo_material = tipo_material;
        configs_lng();
        preencherMateriais();
    }
    
    private void configs_lng() {
        
        String material = _l.queryText("pedra", "jLabelMaterial");
        String material_desc = _l.queryText("pedra", "jLabelMaterial_desc");
        String cor = _l.queryText("pedra", "jLabelCor");
        String cor_desc = _l.queryText("pedra", "jLabelCor_desc");
        String preco = _l.queryText("pedra", "jLabelEspessuraPreco");
        String notas = _l.queryText("pedra", "jButtonNotas");
        String notas_desc = _l.queryText("pedra", "jButtonNotas_desc");
        String observacoes = _l.queryText("pedra", "jButtonObservacoes");
        String observacoes_desc = _l.queryText("pedra", "jButtonObservacoes_desc");
        String adicionar = _l.queryText("pedra", "jButtonAdicionar");
        String adicionar_desc = _l.queryText("pedra", "jButtonAdicionar_desc");
        String limpar = _l.queryText("pedra", "jButtonLimpar");
        String limpar_desc = _l.queryText("pedra", "jButtonLimpar_desc");
        String scrollPanePecas = _l.queryText("pedra", "jScrollPanePecas");
        String pecaTotal = _l.queryText("pedra", "jLabelPecaTotal_desc");
        
        
        jLabelMaterial.setText(material);
        jLabelMaterial.setToolTipText(StringHtml.html_toolTipText(material_desc));
        jLabelCor.setText(cor);
        jLabelCor.setToolTipText(StringHtml.html_toolTipText(cor_desc));
        jLabelEspessuraPreco.setToolTipText(StringHtml.html_toolTipText(preco));
        jButtonNotas.setText(notas);
        jButtonNotas.setToolTipText(StringHtml.html_toolTipText(notas_desc));
        jButtonObservações.setText(observacoes);
        jButtonObservações.setToolTipText(StringHtml.html_toolTipText(observacoes_desc));
        jButtonAdicionarPeca.setText(adicionar);
        jButtonAdicionarPeca.setToolTipText(adicionar_desc);
        jButtonLimparPeca.setText(limpar);
        jButtonLimparPeca.setToolTipText(limpar_desc);
        jScrollPanePecas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, scrollPanePecas, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jLabelPecaTotal.setToolTipText(pecaTotal);
    }
    
    private void preencherMateriais() {
        try {
            jComboBoxMaterial.removeAllItems();
            //jComboBoxMaterial.addItem("");
            ArrayList<String> materiais = _q.queryMateriais(_tipo_material);
            
            for (String s : materiais) {
                jComboBoxMaterial.addItem(s);
            }
            
        } catch (XPathExpressionException ex) {
            Logger.getLogger(JPanelPedra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="getTotal">
    public Double getTotal() {
        Double valor = 0.0;
        try {
            String furo = jLabelFuroTotalValor.getText();
            String pecas = jLabelPecaTotalValor.getText();
            String rodapes = jLabelRodapeTotalValor.getText();
            String rebaixos = jLabelRebaixoTotalValor.getText();
            furo = furo.replace(",", ".");
            pecas = pecas.replace(",", ".");
            rodapes = rodapes.replace(",", ".");
            rebaixos = rebaixos.replace(",", ".");
            valor += Double.parseDouble(furo);
            valor += Double.parseDouble(pecas);
            valor += Double.parseDouble(rodapes);
            valor += Double.parseDouble(rebaixos);
            
        } catch (Exception e) {
        }
        
        return valor;
    }
    // </editor-fold>

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMaterial = new javax.swing.JLabel();
        jComboBoxMaterial = new javax.swing.JComboBox();
        jLabelCor = new javax.swing.JLabel();
        jComboBoxCor = new javax.swing.JComboBox();
        jLabelEspessuraPreco = new javax.swing.JLabel();
        jPanelPecaOp = new javax.swing.JPanel();
        jButtonAdicionarPeca = new javax.swing.JButton();
        jButtonLimparPeca = new javax.swing.JButton();
        jLabelPecaTotalValor = new javax.swing.JLabel();
        jLabelPecaTotal = new javax.swing.JLabel();
        jPanelRodapeOp = new javax.swing.JPanel();
        jButtonAdicionarRodape = new javax.swing.JButton();
        jButtonLimparRodape = new javax.swing.JButton();
        jLabelRodapeTotalValor = new javax.swing.JLabel();
        jLabelRodapeTotal = new javax.swing.JLabel();
        jScrollPanePecas = new javax.swing.JScrollPane();
        jPanelPecas = new javax.swing.JPanel();
        jScrollPaneRodapes = new javax.swing.JScrollPane();
        jPanelRodapes = new javax.swing.JPanel();
        jScrollPaneFuros = new javax.swing.JScrollPane();
        jPanelFuros = new javax.swing.JPanel();
        jPanelFurosOp = new javax.swing.JPanel();
        jButtonAdicionarFuro = new javax.swing.JButton();
        jButtonLimparFuro = new javax.swing.JButton();
        jLabelFuroTotalValor = new javax.swing.JLabel();
        jLabelFuroTotal = new javax.swing.JLabel();
        jScrollPaneRebaixos = new javax.swing.JScrollPane();
        jPanelRebaixos = new javax.swing.JPanel();
        jPanelRebaixosOp = new javax.swing.JPanel();
        jButtonAdicionarRebaixo = new javax.swing.JButton();
        jButtonLimparRebaixo = new javax.swing.JButton();
        jLabelRebaixoTotalValor = new javax.swing.JLabel();
        jLabelRebaixoTotal = new javax.swing.JLabel();
        jButtonNotas = new javax.swing.JButton();
        jButtonObservações = new javax.swing.JButton();

        setBackground(new java.awt.Color(178, 178, 178));
        setAutoscrolls(true);

        jLabelMaterial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMaterial.setText("Escolha o material:");

        jComboBoxMaterial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMaterialItemStateChanged(evt);
            }
        });

        jLabelCor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCor.setText("Escolha a cor:");

        jComboBoxCor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCorItemStateChanged(evt);
            }
        });

        jLabelEspessuraPreco.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelEspessuraPreco.setText("precos");

        jPanelPecaOp.setBackground(new java.awt.Color(217, 216, 215));

        jButtonAdicionarPeca.setText("Adicionar");
        jButtonAdicionarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPecaActionPerformed(evt);
            }
        });

        jButtonLimparPeca.setText("Limpar");
        jButtonLimparPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparPecaActionPerformed(evt);
            }
        });

        jLabelPecaTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPecaTotalValor.setText("0.0");

        jLabelPecaTotal.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabelPecaTotal.setText("TOTAL (€)");

        javax.swing.GroupLayout jPanelPecaOpLayout = new javax.swing.GroupLayout(jPanelPecaOp);
        jPanelPecaOp.setLayout(jPanelPecaOpLayout);
        jPanelPecaOpLayout.setHorizontalGroup(
            jPanelPecaOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPecaOpLayout.createSequentialGroup()
                .addComponent(jButtonAdicionarPeca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimparPeca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(jLabelPecaTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPecaTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelPecaOpLayout.setVerticalGroup(
            jPanelPecaOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPecaOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonAdicionarPeca)
                .addComponent(jButtonLimparPeca)
                .addComponent(jLabelPecaTotalValor)
                .addComponent(jLabelPecaTotal))
        );

        jPanelRodapeOp.setBackground(new java.awt.Color(217, 216, 215));

        jButtonAdicionarRodape.setText("Adicionar");
        jButtonAdicionarRodape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarRodapeActionPerformed(evt);
            }
        });

        jButtonLimparRodape.setText("Limpar");
        jButtonLimparRodape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparRodapeActionPerformed(evt);
            }
        });

        jLabelRodapeTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRodapeTotalValor.setText("0.0");

        jLabelRodapeTotal.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabelRodapeTotal.setText("TOTAL (€)");

        javax.swing.GroupLayout jPanelRodapeOpLayout = new javax.swing.GroupLayout(jPanelRodapeOp);
        jPanelRodapeOp.setLayout(jPanelRodapeOpLayout);
        jPanelRodapeOpLayout.setHorizontalGroup(
            jPanelRodapeOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRodapeOpLayout.createSequentialGroup()
                .addComponent(jButtonAdicionarRodape)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimparRodape)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(jLabelRodapeTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRodapeTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelRodapeOpLayout.setVerticalGroup(
            jPanelRodapeOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRodapeOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonAdicionarRodape)
                .addComponent(jButtonLimparRodape)
                .addComponent(jLabelRodapeTotalValor)
                .addComponent(jLabelRodapeTotal))
        );

        jScrollPanePecas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Peças", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        jPanelPecas.setBorder(null);
        jPanelPecas.setAutoscrolls(true);
        jPanelPecas.setLayout(new java.awt.GridBagLayout());
        jScrollPanePecas.setViewportView(jPanelPecas);

        jScrollPaneRodapes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rodapés", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        jPanelRodapes.setBorder(null);
        jPanelRodapes.setAutoscrolls(true);
        jPanelRodapes.setLayout(new java.awt.GridBagLayout());
        jScrollPaneRodapes.setViewportView(jPanelRodapes);

        jScrollPaneFuros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Furos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        jPanelFuros.setBorder(null);
        jPanelFuros.setAutoscrolls(true);
        jPanelFuros.setLayout(new java.awt.GridBagLayout());
        jScrollPaneFuros.setViewportView(jPanelFuros);

        jPanelFurosOp.setBackground(new java.awt.Color(217, 216, 215));

        jButtonAdicionarFuro.setText("Adicionar");
        jButtonAdicionarFuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarFuroActionPerformed(evt);
            }
        });

        jButtonLimparFuro.setText("Limpar");
        jButtonLimparFuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparFuroActionPerformed(evt);
            }
        });

        jLabelFuroTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFuroTotalValor.setText("0.0");

        jLabelFuroTotal.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabelFuroTotal.setText("TOTAL (€)");

        javax.swing.GroupLayout jPanelFurosOpLayout = new javax.swing.GroupLayout(jPanelFurosOp);
        jPanelFurosOp.setLayout(jPanelFurosOpLayout);
        jPanelFurosOpLayout.setHorizontalGroup(
            jPanelFurosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFurosOpLayout.createSequentialGroup()
                .addComponent(jButtonAdicionarFuro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimparFuro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(jLabelFuroTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFuroTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelFurosOpLayout.setVerticalGroup(
            jPanelFurosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFurosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonAdicionarFuro)
                .addComponent(jButtonLimparFuro)
                .addComponent(jLabelFuroTotalValor)
                .addComponent(jLabelFuroTotal))
        );

        jScrollPaneRebaixos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rebaixos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        jPanelRebaixos.setBorder(null);
        jPanelRebaixos.setAutoscrolls(true);
        jPanelRebaixos.setLayout(new java.awt.GridBagLayout());
        jScrollPaneRebaixos.setViewportView(jPanelRebaixos);

        jPanelRebaixosOp.setBackground(new java.awt.Color(217, 216, 215));

        jButtonAdicionarRebaixo.setText("Adicionar");
        jButtonAdicionarRebaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarRebaixoActionPerformed(evt);
            }
        });

        jButtonLimparRebaixo.setText("Limpar");
        jButtonLimparRebaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparRebaixoActionPerformed(evt);
            }
        });

        jLabelRebaixoTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRebaixoTotalValor.setText("0.0");

        jLabelRebaixoTotal.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabelRebaixoTotal.setText("TOTAL (€)");

        javax.swing.GroupLayout jPanelRebaixosOpLayout = new javax.swing.GroupLayout(jPanelRebaixosOp);
        jPanelRebaixosOp.setLayout(jPanelRebaixosOpLayout);
        jPanelRebaixosOpLayout.setHorizontalGroup(
            jPanelRebaixosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRebaixosOpLayout.createSequentialGroup()
                .addComponent(jButtonAdicionarRebaixo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimparRebaixo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(jLabelRebaixoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRebaixoTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelRebaixosOpLayout.setVerticalGroup(
            jPanelRebaixosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRebaixosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonAdicionarRebaixo)
                .addComponent(jButtonLimparRebaixo)
                .addComponent(jLabelRebaixoTotalValor)
                .addComponent(jLabelRebaixoTotal))
        );

        jButtonNotas.setText("Notas");
        jButtonNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNotasActionPerformed(evt);
            }
        });

        jButtonObservações.setText("Observações");
        jButtonObservações.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObservaçõesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelEspessuraPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCor, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(jLabelMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCor, 0, 234, Short.MAX_VALUE)))
                    .addComponent(jScrollPaneRebaixos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jScrollPaneRodapes, javax.swing.GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jScrollPanePecas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jPanelPecaOp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRodapeOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneFuros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jPanelFurosOp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRebaixosOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNotas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonObservações)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMaterial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEspessuraPreco)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonObservações)
                    .addComponent(jButtonNotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPanePecas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPecaOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneRodapes, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRodapeOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneFuros, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFurosOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneRebaixos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRebaixosOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Eventos e variáveis">
private void jComboBoxMaterialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMaterialItemStateChanged
    materialSeleccionado();
    jComboBoxMaterial.setToolTipText(_material);
    //jPanelPecas.removeAll();
    //jPanelPecas.repaint();
    //jPanelPecas.revalidate();
    this.notifyObservers(_material, _cor);
    this.repaint();
    this.revalidate();
}//GEN-LAST:event_jComboBoxMaterialItemStateChanged
    
    private void jButtonAdicionarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPecaActionPerformed
        
        JPanelPedraPeca l = new JPanelPedraPeca(_q, _material, _cor);
        l.addObserver(this);
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = num_linhas_peca;
        jPanelPecas.add(l, gridBagConstraints);
        
        num_linhas_peca++;
        
        this.addObserver(l);
        jPanelPecas.repaint();
        jPanelPecas.revalidate();
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonAdicionarPecaActionPerformed
    
    private void jComboBoxCorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCorItemStateChanged
        _material = jComboBoxMaterial.getSelectedItem().toString();
        if (jComboBoxCor.getSelectedItem() == null) {
            return;
        }
        _cor = jComboBoxCor.getSelectedItem().toString();
        jLabelEspessuraPreco.setText(_q.queryCoresPrecoString(_material, _cor));
        jComboBoxCor.setToolTipText(_cor);
        //jPanelPecas.removeAll();
        //jPanelPecas.repaint();
        //jPanelPecas.revalidate();
        this.notifyObservers(_material, _cor);
        this.repaint();
        this.revalidate();
        //JOptionPane.showMessageDialog(this, "FIM" + _material + _cor);
    }//GEN-LAST:event_jComboBoxCorItemStateChanged
    
    private void jButtonLimparPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparPecaActionPerformed
        jPanelPecas.removeAll();
        jPanelPecas.repaint();
        jPanelPecas.revalidate();
        jLabelPecaTotalValor.setText("0.0");
        num_linhas_peca = 0;
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonLimparPecaActionPerformed
    
    private void jButtonAdicionarRodapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarRodapeActionPerformed
        JPanelPedraRodape r = new JPanelPedraRodape(_q, _material, _cor);
        r.addObserver(this);
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = num_linhas_rodape;
        jPanelRodapes.add(r, gridBagConstraints);
        
        num_linhas_rodape++;
        
        this.addObserver(r);
        jPanelRodapes.repaint();
        jPanelRodapes.revalidate();
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonAdicionarRodapeActionPerformed
    
    private void jButtonLimparRodapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparRodapeActionPerformed
        jPanelRodapes.removeAll();
        jPanelRodapes.repaint();
        jPanelRodapes.revalidate();
        jLabelRodapeTotalValor.setText("0.0");
        num_linhas_rodape = 0;
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonLimparRodapeActionPerformed
    
    private void jButtonAdicionarFuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarFuroActionPerformed
        JPanelPedraFuro f = new JPanelPedraFuro(_q, _material, _cor);
        f.addObserver(this);
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = num_linhas_furos;
        jPanelFuros.add(f, gridBagConstraints);
        
        num_linhas_furos++;
        
        this.addObserver(f);
        jPanelFuros.repaint();
        jPanelFuros.revalidate();
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonAdicionarFuroActionPerformed
    
    private void jButtonLimparFuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparFuroActionPerformed
        jPanelFuros.removeAll();
        jPanelFuros.repaint();
        jPanelFuros.revalidate();
        jLabelFuroTotalValor.setText("0.0");
        num_linhas_furos = 0;
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonLimparFuroActionPerformed
    
    private void jButtonAdicionarRebaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarRebaixoActionPerformed
        JPanelPedraRebaixo r = new JPanelPedraRebaixo(_q, _material, _cor);
        r.addObserver(this);
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = num_linhas_rebaixos;
        jPanelRebaixos.add(r, gridBagConstraints);
        
        num_linhas_rebaixos++;
        
        this.addObserver(r);
        jPanelRebaixos.repaint();
        jPanelRebaixos.revalidate();
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonAdicionarRebaixoActionPerformed
    
    private void jButtonLimparRebaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparRebaixoActionPerformed
        jPanelRebaixos.removeAll();
        jPanelRebaixos.repaint();
        jPanelRebaixos.revalidate();
        jLabelRebaixoTotalValor.setText("0.0");
        num_linhas_rebaixos = 0;
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonLimparRebaixoActionPerformed
    
    private void jButtonNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotasActionPerformed
        ArrayList<String> notas = _q.queryNotas(_material);
        String texto = "<html><table width=\"600\"><tr><td>";
        for (String s : notas) {
            texto += "<li>" + s + "</li>";
        }
        texto += "</ul></td></tr></table></html>";
        
        JOptionPane.showMessageDialog(null, texto, "Notas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonNotasActionPerformed
    
    private void jButtonObservaçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObservaçõesActionPerformed
        ArrayList<String> obss = _q.queryObss(_material);
        String texto = "<html><table width=\"600\"><tr><td><ol>";
        for (String s : obss) {
            texto += "<li>" + s + "</li>";
        }
        texto += "</ol></td></tr></table></html>";
        
        JOptionPane.showMessageDialog(null, texto, "Observações", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonObservaçõesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarFuro;
    private javax.swing.JButton jButtonAdicionarPeca;
    private javax.swing.JButton jButtonAdicionarRebaixo;
    private javax.swing.JButton jButtonAdicionarRodape;
    private javax.swing.JButton jButtonLimparFuro;
    private javax.swing.JButton jButtonLimparPeca;
    private javax.swing.JButton jButtonLimparRebaixo;
    private javax.swing.JButton jButtonLimparRodape;
    private javax.swing.JButton jButtonNotas;
    private javax.swing.JButton jButtonObservações;
    private javax.swing.JComboBox jComboBoxCor;
    private javax.swing.JComboBox jComboBoxMaterial;
    private javax.swing.JLabel jLabelCor;
    private javax.swing.JLabel jLabelEspessuraPreco;
    private javax.swing.JLabel jLabelFuroTotal;
    private javax.swing.JLabel jLabelFuroTotalValor;
    private javax.swing.JLabel jLabelMaterial;
    private javax.swing.JLabel jLabelPecaTotal;
    private javax.swing.JLabel jLabelPecaTotalValor;
    private javax.swing.JLabel jLabelRebaixoTotal;
    private javax.swing.JLabel jLabelRebaixoTotalValor;
    private javax.swing.JLabel jLabelRodapeTotal;
    private javax.swing.JLabel jLabelRodapeTotalValor;
    private javax.swing.JPanel jPanelFuros;
    private javax.swing.JPanel jPanelFurosOp;
    private javax.swing.JPanel jPanelPecaOp;
    private javax.swing.JPanel jPanelPecas;
    private javax.swing.JPanel jPanelRebaixos;
    private javax.swing.JPanel jPanelRebaixosOp;
    private javax.swing.JPanel jPanelRodapeOp;
    private javax.swing.JPanel jPanelRodapes;
    private javax.swing.JScrollPane jScrollPaneFuros;
    private javax.swing.JScrollPane jScrollPanePecas;
    private javax.swing.JScrollPane jScrollPaneRebaixos;
    private javax.swing.JScrollPane jScrollPaneRodapes;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

    private void materialSeleccionado() {
        String nome_material = jComboBoxMaterial.getSelectedItem().toString();
        
        if (nome_material.equalsIgnoreCase("") || nome_material == null) {
            return;
        }
        
        cores = _q.queryCores(nome_material);
        jComboBoxCor.removeAllItems();
        for (String s : cores) {
            jComboBoxCor.addItem(s);
        }
        _material = nome_material;
    }

    // <editor-fold defaultstate="collapsed" desc="Actualizar">
    public void actualizarTotalPecas() {
        Double d = 0.0;
        for (Component c : jPanelPecas.getComponents()) {
            try {
                JPanelPedraPeca l = (JPanelPedraPeca) c;
                d += l.getTotal();
            } catch (Exception e) {
            }
        }
        
        jLabelPecaTotalValor.setText(df.format(d));
    }
    
    public void actualizarTotalRodapes() {
        Double d = 0.0;
        for (Component c : jPanelRodapes.getComponents()) {
            try {
                JPanelPedraRodape l = (JPanelPedraRodape) c;
                d += l.getTotal();
            } catch (Exception e) {
            }
        }
        
        jLabelRodapeTotalValor.setText(df.format(d));
    }
    
    public void actualizarTotalFuros() {
        Double d = 0.0;
        for (Component c : jPanelFuros.getComponents()) {
            try {
                JPanelPedraFuro l = (JPanelPedraFuro) c;
                d += l.getTotal();
            } catch (Exception e) {
            }
        }
        
        jLabelFuroTotalValor.setText(df.format(d));
    }
    
    public void actualizarTotalRebaixos() {
        Double d = 0.0;
        for (Component c : jPanelRebaixos.getComponents()) {
            try {
                JPanelPedraRebaixo j = (JPanelPedraRebaixo) c;
                d += j.getTotal();
            } catch (Exception e) {
            }
        }
        
        jLabelRebaixoTotalValor.setText(df.format(d));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Notify Observer">
    @Override
    public void update(String enviou) {
        if (enviou.equalsIgnoreCase("lng")) {
            configs_lng();
        }
        if (enviou.equalsIgnoreCase("peca")) {
            actualizarTotalPecas();
            //JOptionPane.showMessageDialog(jLabelCor, "peca");
        } else if (enviou.equalsIgnoreCase("rodape")) {
            actualizarTotalRodapes();
        } else if (enviou.equalsIgnoreCase("furo")) {
            actualizarTotalFuros();
        } else if (enviou.equalsIgnoreCase("rebaixo")) {
            actualizarTotalRebaixos();
        }
        notifyObservers(_material, getTotal());
    }
    
    @Override
    public void update(String material, String cor) {
    }
    
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }
    
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    
    @Override
    public void notifyObservers(String n) {
    }
    
    @Override
    public void notifyObservers(String material, String cor) {
        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            Observer observer = it.next();
            observer.update(material, cor);
        }
    }
    
    @Override
    public void notifyObservers(String n, Double d) {
        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            Observer observer = it.next();
            observer.update(n, d);
        }
    }
    
    @Override
    public void update(String n, Double v) {
    }
    // </editor-fold>
}
