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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.xpath.XPathExpressionException;
import mvc.Observer;
import mvc.Subject;

/**
 *
 * @author miguel
 */
public class JPanelEcoLeather extends javax.swing.JPanel implements Observer, Subject {

    private QueryXML _q;
    private QueryXML_Lingua _l;
    private ArrayList<String> cores;
    private int num_linhas_peca = 0;
    private int num_linhas_acabamento = 0;
    private int num_linhas_furos = 0;
    private int num_linhas_rebaixos = 0;
    private String _material = "";
    private String _cor = "";
    private DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String _tipo_material = "";

    /** Creates new form JPanelPedra */
    public JPanelEcoLeather(QueryXML q, QueryXML_Lingua l, String tipo_material) {
        initComponents();

        _q = q;
        _l = l;
        _tipo_material = tipo_material;
        configs();
        configs_lng();
        preencherMateriais();
    }

    private void configs() {

        jLabelMaterial.setName("jLabelMaterial");
        jLabelCor.setName("jLabelCor");
        jLabelEspessuraPreco.setName("jLabelEspessuraPreco");

        jButtonNotas.setName("jButtonNotas");
        jButtonObservacoes.setName("jButtonObservacoes");

        jButtonAdicionarPeca.setName("jButtonAdicionar");
        jButtonAdicionarAcabamento.setName("jButtonAdicionar");
        jButtonAdicionarFuro.setName("jButtonAdicionar");
        jButtonAdicionarRebaixo.setName("jButtonAdicionar");

        jButtonLimparPeca.setName("jButtonLimpar");
        jButtonLimparAcabamento.setName("jButtonLimpar");
        jButtonLimparFuro.setName("jButtonLimpar");
        jButtonLimparRebaixo.setName("jButtonLimpar");

        jLabelPecaTotal.setName("jLabelTotal");
        jLabelAcabamentoTotal.setName("jLabelTotal");
        jLabelFuroTotal.setName("jLabelTotal");
        jLabelRebaixoTotal.setName("jLabelTotal");

    }

    public void configs_lng() {
        // material e cor
        jLabelMaterial.setText(_l.queryText("ecoleather", "jLabelMaterial"));
        jLabelMaterial.setToolTipText(_l.queryText("ecoleather", "jLabelMaterial_desc"));
        jLabelCor.setText(_l.queryText("ecoleather", "jLabelCor"));
        jLabelCor.setToolTipText(_l.queryText("ecoleather", "jLabelCor_desc"));

        // butões de adicionar
        jButtonAdicionarPeca.setText(_l.queryText("ecoleather", "jButtonAdicionar"));
        jButtonAdicionarAcabamento.setText(_l.queryText("ecoleather", "jButtonAdicionar"));
        jButtonAdicionarFuro.setText(_l.queryText("ecoleather", "jButtonAdicionar"));
        jButtonAdicionarRebaixo.setText(_l.queryText("ecoleather", "jButtonAdicionar"));

        // butões de limpar
        jButtonLimparPeca.setText(_l.queryText("ecoleather", "jButtonLimpar"));
        jButtonLimparAcabamento.setText(_l.queryText("ecoleather", "jButtonLimpar"));
        jButtonLimparFuro.setText(_l.queryText("ecoleather", "jButtonLimpar"));
        jButtonLimparRebaixo.setText(_l.queryText("ecoleather", "jButtonLimpar"));

        // Label total
        jLabelPecaTotal.setText(_l.queryText("ecoleather", "jLabelTotal"));
        jLabelAcabamentoTotal.setText(_l.queryText("ecoleather", "jLabelTotal"));
        jLabelFuroTotal.setText(_l.queryText("ecoleather", "jLabelTotal"));
        jLabelRebaixoTotal.setText(_l.queryText("ecoleather", "jLabelTotal"));

        jLabelPecaTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleather", "jLabelPecaTotal_desc")));
        jLabelAcabamentoTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleather", "jLabelAcabamentoTotal")));
        jLabelFuroTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleather", "jLabelFuroTotal")));
        jLabelRebaixoTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleather", "jLabelRebaixoTotal")));

        // Notas e observações
        jButtonNotas.setText(_l.queryText("ecoleather", "jButtonNotas"));
        jButtonObservacoes.setText(_l.queryText("ecoleather", "jButtonObservacoes"));

        jButtonNotas.setToolTipText(_l.queryText("ecoleather", "jButtonNotas_desc"));
        jButtonObservacoes.setToolTipText(_l.queryText("ecoleather", "jButtonObservacoes_desc3"));

        //PanelScrool
        jScrollPanePecas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleather", "jScrollPanePecas"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jScrollPaneAcabamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleather", "jScrollPaneAcabamentos"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jScrollPaneFuros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleather", "jScrollPaneFuros"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jScrollPaneRebaixos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleather", "jScrollPaneRebaixos"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));


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
            Logger.getLogger(JPanelEcoLeather.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="getTotal">
    public Double getTotal() {
        Double valor = 0.0;
        try {
            String furo = jLabelFuroTotalValor.getText();
            String pecas = jLabelPecaTotalValor.getText();
            String rodapes = jLabelAcabamentoTotalValor.getText();
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
        jPanelAcabamentoOp = new javax.swing.JPanel();
        jButtonAdicionarAcabamento = new javax.swing.JButton();
        jButtonLimparAcabamento = new javax.swing.JButton();
        jLabelAcabamentoTotalValor = new javax.swing.JLabel();
        jLabelAcabamentoTotal = new javax.swing.JLabel();
        jScrollPanePecas = new javax.swing.JScrollPane();
        jPanelPecas = new javax.swing.JPanel();
        jScrollPaneAcabamentos = new javax.swing.JScrollPane();
        jPanelAcabamentos = new javax.swing.JPanel();
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
        jButtonObservacoes = new javax.swing.JButton();

        setBackground(new java.awt.Color(178, 178, 178));
        setAutoscrolls(true);

        jLabelMaterial.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelMaterial.setText("Escolha o material:");

        jComboBoxMaterial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMaterialItemStateChanged(evt);
            }
        });

        jLabelCor.setFont(new java.awt.Font("Tahoma", 1, 11));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
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

        jPanelAcabamentoOp.setBackground(new java.awt.Color(217, 216, 215));

        jButtonAdicionarAcabamento.setText("Adicionar");
        jButtonAdicionarAcabamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarAcabamentoActionPerformed(evt);
            }
        });

        jButtonLimparAcabamento.setText("Limpar");
        jButtonLimparAcabamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparAcabamentoActionPerformed(evt);
            }
        });

        jLabelAcabamentoTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAcabamentoTotalValor.setText("0.0");

        jLabelAcabamentoTotal.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabelAcabamentoTotal.setText("TOTAL (€)");

        javax.swing.GroupLayout jPanelAcabamentoOpLayout = new javax.swing.GroupLayout(jPanelAcabamentoOp);
        jPanelAcabamentoOp.setLayout(jPanelAcabamentoOpLayout);
        jPanelAcabamentoOpLayout.setHorizontalGroup(
            jPanelAcabamentoOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcabamentoOpLayout.createSequentialGroup()
                .addComponent(jButtonAdicionarAcabamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimparAcabamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(jLabelAcabamentoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAcabamentoTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelAcabamentoOpLayout.setVerticalGroup(
            jPanelAcabamentoOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcabamentoOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonAdicionarAcabamento)
                .addComponent(jButtonLimparAcabamento)
                .addComponent(jLabelAcabamentoTotalValor)
                .addComponent(jLabelAcabamentoTotal))
        );

        jScrollPanePecas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Peças", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        jPanelPecas.setBorder(null);
        jPanelPecas.setAutoscrolls(true);
        jPanelPecas.setLayout(new java.awt.GridBagLayout());
        jScrollPanePecas.setViewportView(jPanelPecas);

        jScrollPaneAcabamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acabamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        jPanelAcabamentos.setBorder(null);
        jPanelAcabamentos.setAutoscrolls(true);
        jPanelAcabamentos.setLayout(new java.awt.GridBagLayout());
        jScrollPaneAcabamentos.setViewportView(jPanelAcabamentos);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
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

        jButtonObservacoes.setText("Observações");
        jButtonObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObservacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelRebaixosOp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneRebaixos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jPanelFurosOp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneFuros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jPanelAcabamentoOp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneAcabamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jPanelPecaOp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPanePecas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNotas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonObservacoes))
                    .addComponent(jLabelEspessuraPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaterial)
                            .addComponent(jLabelCor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCor, 0, 234, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMaterial)
                    .addComponent(jComboBoxMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCor)
                    .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEspessuraPreco)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNotas)
                    .addComponent(jButtonObservacoes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPanePecas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPecaOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAcabamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAcabamentoOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    jComboBoxMaterial.setToolTipText(StringHtml.html_toolTipText(_material));

    this.notifyObservers(_material, _cor);
    this.repaint();
    this.revalidate();
    this.repaint();
}//GEN-LAST:event_jComboBoxMaterialItemStateChanged

    private void jButtonAdicionarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPecaActionPerformed

        JPanelPedraPeca l = new JPanelPedraPeca(_q, _l, _material, _cor);
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
        this.repaint();
        jPanelPecas.repaint();
    }//GEN-LAST:event_jButtonAdicionarPecaActionPerformed

    private void jComboBoxCorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCorItemStateChanged
        _material = jComboBoxMaterial.getSelectedItem().toString();
        if (jComboBoxCor.getSelectedItem() == null) {
            return;
        }
        _cor = jComboBoxCor.getSelectedItem().toString();
        jLabelEspessuraPreco.setText(_q.queryCoresPrecoString(_material, _cor));
        jComboBoxCor.setToolTipText(StringHtml.html_toolTipText(_cor));

        this.notifyObservers(_material, _cor);
        this.repaint();
        this.revalidate();
        this.repaint();
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

    private void jButtonAdicionarAcabamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAcabamentoActionPerformed
        JPanelEcoLeatherAcabamento r = new JPanelEcoLeatherAcabamento(_q, _l, _material);
        r.addObserver(this);
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = num_linhas_acabamento;
        jPanelAcabamentos.add(r, gridBagConstraints);

        num_linhas_acabamento++;

        this.addObserver(r);
        jPanelAcabamentos.repaint();
        jPanelAcabamentos.revalidate();
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonAdicionarAcabamentoActionPerformed

    private void jButtonLimparAcabamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparAcabamentoActionPerformed
        jPanelAcabamentos.removeAll();
        jPanelAcabamentos.repaint();
        jPanelAcabamentos.revalidate();
        jLabelAcabamentoTotalValor.setText("0.0");
        num_linhas_acabamento = 0;
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonLimparAcabamentoActionPerformed

    private void jButtonAdicionarFuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarFuroActionPerformed
        JPanelPedraFuro f = new JPanelPedraFuro(_q, _l, _material);
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
    }//GEN-LAST:event_jButtonLimparFuroActionPerformed

    private void jButtonAdicionarRebaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarRebaixoActionPerformed
        JPanelPedraRebaixo r = new JPanelPedraRebaixo(_q, _l, _material);
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

        String texto = StringHtml.html_list(notas, "Notas:");

        JOptionPane.showMessageDialog(null, texto, "Notas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonNotasActionPerformed

    private void jButtonObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObservacoesActionPerformed
        ArrayList<String> obss = _q.queryObss(_material);

        String texto = StringHtml.html_list_numeric(obss, "Observações:");

        JOptionPane.showMessageDialog(null, texto, "Observações", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonObservacoesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarAcabamento;
    private javax.swing.JButton jButtonAdicionarFuro;
    private javax.swing.JButton jButtonAdicionarPeca;
    private javax.swing.JButton jButtonAdicionarRebaixo;
    private javax.swing.JButton jButtonLimparAcabamento;
    private javax.swing.JButton jButtonLimparFuro;
    private javax.swing.JButton jButtonLimparPeca;
    private javax.swing.JButton jButtonLimparRebaixo;
    private javax.swing.JButton jButtonNotas;
    private javax.swing.JButton jButtonObservacoes;
    private javax.swing.JComboBox jComboBoxCor;
    private javax.swing.JComboBox jComboBoxMaterial;
    private javax.swing.JLabel jLabelAcabamentoTotal;
    private javax.swing.JLabel jLabelAcabamentoTotalValor;
    private javax.swing.JLabel jLabelCor;
    private javax.swing.JLabel jLabelEspessuraPreco;
    private javax.swing.JLabel jLabelFuroTotal;
    private javax.swing.JLabel jLabelFuroTotalValor;
    private javax.swing.JLabel jLabelMaterial;
    private javax.swing.JLabel jLabelPecaTotal;
    private javax.swing.JLabel jLabelPecaTotalValor;
    private javax.swing.JLabel jLabelRebaixoTotal;
    private javax.swing.JLabel jLabelRebaixoTotalValor;
    private javax.swing.JPanel jPanelAcabamentoOp;
    private javax.swing.JPanel jPanelAcabamentos;
    private javax.swing.JPanel jPanelFuros;
    private javax.swing.JPanel jPanelFurosOp;
    private javax.swing.JPanel jPanelPecaOp;
    private javax.swing.JPanel jPanelPecas;
    private javax.swing.JPanel jPanelRebaixos;
    private javax.swing.JPanel jPanelRebaixosOp;
    private javax.swing.JScrollPane jScrollPaneAcabamentos;
    private javax.swing.JScrollPane jScrollPaneFuros;
    private javax.swing.JScrollPane jScrollPanePecas;
    private javax.swing.JScrollPane jScrollPaneRebaixos;
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

    public void actualizarTotalAcabamentos() {
        Double d = 0.0;
        for (Component c : jPanelAcabamentos.getComponents()) {
            try {
                JPanelEcoLeatherAcabamento l = (JPanelEcoLeatherAcabamento) c;
                d += l.getTotal();
            } catch (Exception e) {
            }
        }

        jLabelAcabamentoTotalValor.setText(df.format(d));
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
            notifyObservers("lng");
        }

        if (enviou.equalsIgnoreCase("peca")) {
            actualizarTotalPecas();
            //JOptionPane.showMessageDialog(jLabelCor, "peca");
        } else if (enviou.equalsIgnoreCase("acabamento")) {
            actualizarTotalAcabamentos();
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
        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            Observer observer = it.next();
            observer.update("lng");
        }
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
