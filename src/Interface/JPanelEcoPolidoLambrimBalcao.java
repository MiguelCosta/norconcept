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
import javax.swing.JOptionPane;
import mvc.Observer;
import mvc.Subject;

/**
 *
 * @author miguel
 */
public class JPanelEcoPolidoLambrimBalcao extends javax.swing.JPanel implements Observer, Subject {

    private QueryXML _q;
    private QueryXML_Lingua _l;
    private ArrayList<String> cores;
    private int num_linhas_peca = 0;
    private int num_linhas_acabamento = 0;
    private int num_linhas_furos = 0;
    private int num_linhas_rodamaos = 0;
    private int num_linhas_rebaixos = 0;
    private String _material = "Lambrim e Balcão";
    private String _cor = "";
    private DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String _tipo_material = "Silestone Eco Polido - Lambrim e Balcão";

    /** Creates new form JPanelPedra */
    public JPanelEcoPolidoLambrimBalcao(QueryXML q, QueryXML_Lingua l, String tipo_material) {
        initComponents();

        _q = q;
        _l = l;
        _tipo_material = tipo_material;
        configs();
        configs_lng();
        preencherCores();
    }

    private void preencherCores() {
        cores = _q.queryCores(_material);
        for (String s : cores) {
            jComboBoxCor.addItem(s);
        }


    }

    private void configs() {

        jLabelCor.setName("jLabelCor");
        jLabelEspessuraPreco.setName("jLabelEspessuraPreco");

        jButtonNotas.setName("jButtonNotas");
        jButtonObservacoes.setName("jButtonObservacoes");

        jButtonAdicionarPeca.setName("jButtonAdicionar");
        jButtonAdicionarAcabamento.setName("jButtonAdicionar");
        jButtonAdicionarFuro.setName("jButtonAdicionar");
        jButtonAdicionarRodamao.setName("jButtonAdicionar");

        jButtonLimparPeca.setName("jButtonLimpar");
        jButtonLimparAcabamento.setName("jButtonLimpar");
        jButtonLimparFuro.setName("jButtonLimpar");
        jButtonLimparRodamao.setName("jButtonLimpar");

        jLabelPecaTotal.setName("jLabelTotal");
        jLabelAcabamentoTotal.setName("jLabelTotal");
        jLabelFuroTotal.setName("jLabelTotal");
        jLabelRodamaoTotal.setName("jLabelTotal");

    }

    public void configs_lng() {
        // material e cor
        jLabelCor.setText(_l.queryText("ecoleatherLambrimBalcao", "jLabelCor"));
        jLabelCor.setToolTipText(_l.queryText("ecoleatherLambrimBalcao", "jLabelCor_desc"));

        // butões de adicionar
        jButtonAdicionarPeca.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonAdicionar"));
        jButtonAdicionarAcabamento.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonAdicionar"));
        jButtonAdicionarFuro.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonAdicionar"));
        jButtonAdicionarRodamao.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonAdicionar"));

        // butões de limpar
        jButtonLimparPeca.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonLimpar"));
        jButtonLimparAcabamento.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonLimpar"));
        jButtonLimparFuro.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonLimpar"));
        jButtonLimparRodamao.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonLimpar"));

        // Label total
        jLabelPecaTotal.setText(_l.queryText("ecoleatherLambrimBalcao", "jLabelTotal"));
        jLabelAcabamentoTotal.setText(_l.queryText("ecoleatherLambrimBalcao", "jLabelTotal"));
        jLabelFuroTotal.setText(_l.queryText("ecoleatherLambrimBalcao", "jLabelTotal"));
        jLabelRodamaoTotal.setText(_l.queryText("ecoleatherLambrimBalcao", "jLabelTotal"));

        jLabelPecaTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleatherLambrimBalcao", "jLabelPecaTotal_desc")));
        jLabelAcabamentoTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleatherLambrimBalcao", "jLabelAcabamentoTotal")));
        jLabelFuroTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleatherLambrimBalcao", "jLabelFuroTotal")));
        jLabelRodamaoTotal.setToolTipText(StringHtml.html_toolTipText(_l.queryText("ecoleatherLambrimBalcao", "jLabelRodamaoTotal")));

        // Notas e observações
        jButtonNotas.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonNotas"));
        jButtonObservacoes.setText(_l.queryText("ecoleatherLambrimBalcao", "jButtonObservacoes"));

        jButtonNotas.setToolTipText(_l.queryText("ecoleatherLambrimBalcao", "jButtonNotas_desc"));
        jButtonObservacoes.setToolTipText(_l.queryText("ecoleatherLambrimBalcao", "jButtonObservacoes_desc3"));

        //PanelScrool
        jScrollPanePecas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleatherLambrimBalcao", "jScrollPanePecas"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jScrollPaneAcabamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleatherLambrimBalcao", "jScrollPaneAcabamentos"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jScrollPaneFuros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleatherLambrimBalcao", "jScrollPaneFuros"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jScrollPaneRodamaos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, _l.queryText("ecoleatherLambrimBalcao", "jScrollPaneRodamao"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));


    }

    // <editor-fold defaultstate="collapsed" desc="getTotal">
    public Double getTotal() {
        Double valor = 0.0;
        try {
            String furo = jLabelFuroTotalValor.getText();
            String pecas = jLabelPecaTotalValor.getText();
            String rodapes = jLabelAcabamentoTotalValor.getText();
            String rodamaos = jLabelRodamaoTotalValor.getText();
            String rebaixos = jLabelRebaixoTotalValor.getText();
            furo = furo.replace(",", ".");
            pecas = pecas.replace(",", ".");
            rodapes = rodapes.replace(",", ".");
            rodamaos = rodamaos.replace(",", ".");
            rebaixos = rebaixos.replace(",", ".");
            valor += Double.parseDouble(furo);
            valor += Double.parseDouble(pecas);
            valor += Double.parseDouble(rodapes);
            valor += Double.parseDouble(rodamaos);
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
        jScrollPaneRodamaos = new javax.swing.JScrollPane();
        jPanelRodamaos = new javax.swing.JPanel();
        jPanelRodamaosOp = new javax.swing.JPanel();
        jButtonAdicionarRodamao = new javax.swing.JButton();
        jButtonLimparRodamao = new javax.swing.JButton();
        jLabelRodamaoTotalValor = new javax.swing.JLabel();
        jLabelRodamaoTotal = new javax.swing.JLabel();
        jButtonNotas = new javax.swing.JButton();
        jButtonObservacoes = new javax.swing.JButton();
        jScrollPaneRebaixos = new javax.swing.JScrollPane();
        jPanelRebaixos = new javax.swing.JPanel();
        jPanelRebaixosOp = new javax.swing.JPanel();
        jButtonAdicionarRebaixo = new javax.swing.JButton();
        jButtonLimparRebaixo = new javax.swing.JButton();
        jLabelRebaixoTotalValor = new javax.swing.JLabel();
        jLabelRebaixoTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(178, 178, 178));
        setAutoscrolls(true);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
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

        jScrollPaneRodamaos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rodamaos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        jPanelRodamaos.setBorder(null);
        jPanelRodamaos.setAutoscrolls(true);
        jPanelRodamaos.setLayout(new java.awt.GridBagLayout());
        jScrollPaneRodamaos.setViewportView(jPanelRodamaos);

        jPanelRodamaosOp.setBackground(new java.awt.Color(217, 216, 215));

        jButtonAdicionarRodamao.setText("Adicionar");
        jButtonAdicionarRodamao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarRodamaoActionPerformed(evt);
            }
        });

        jButtonLimparRodamao.setText("Limpar");
        jButtonLimparRodamao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparRodamaoActionPerformed(evt);
            }
        });

        jLabelRodamaoTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRodamaoTotalValor.setText("0.0");

        jLabelRodamaoTotal.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabelRodamaoTotal.setText("TOTAL (€)");

        javax.swing.GroupLayout jPanelRodamaosOpLayout = new javax.swing.GroupLayout(jPanelRodamaosOp);
        jPanelRodamaosOp.setLayout(jPanelRodamaosOpLayout);
        jPanelRodamaosOpLayout.setHorizontalGroup(
            jPanelRodamaosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRodamaosOpLayout.createSequentialGroup()
                .addComponent(jButtonAdicionarRodamao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimparRodamao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(jLabelRodamaoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRodamaoTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelRodamaosOpLayout.setVerticalGroup(
            jPanelRodamaosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRodamaosOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonAdicionarRodamao)
                .addComponent(jButtonLimparRodamao)
                .addComponent(jLabelRodamaoTotalValor)
                .addComponent(jLabelRodamaoTotal))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                        .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelEspessuraPreco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonNotas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonObservacoes))
                    .addComponent(jScrollPanePecas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jPanelPecaOp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneAcabamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jPanelAcabamentoOp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneFuros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jPanelFurosOp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneRodamaos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jPanelRodamaosOp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneRebaixos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jPanelRebaixosOp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCor)
                    .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEspessuraPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonObservacoes)
                    .addComponent(jButtonNotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jScrollPaneRodamaos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRodamaosOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneRebaixos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRebaixosOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Eventos e variáveis">    
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

        if (jComboBoxCor.getSelectedItem() == null) {
            return;
        }
        _cor = jComboBoxCor.getSelectedItem().toString();
        if (_material.equals("Ladrilhos")) {
            jLabelEspessuraPreco.setText("");
        } else {
            jLabelEspessuraPreco.setText(_q.queryCoresPrecoString(_material, _cor));
        }

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
        JPanelEcoLeatherLambrimBalcaoAcabamento r = new JPanelEcoLeatherLambrimBalcaoAcabamento(_q, _l, _material);
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

    private void jButtonAdicionarRodamaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarRodamaoActionPerformed
        JPanelEcoLeatherLambrimRodamao r = new JPanelEcoLeatherLambrimRodamao(_q, _l, _material);
        r.addObserver(this);
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = num_linhas_rodamaos;
        jPanelRodamaos.add(r, gridBagConstraints);

        num_linhas_rodamaos++;

        this.addObserver(r);
        jPanelRodamaos.repaint();
        jPanelRodamaos.revalidate();
        notifyObservers(_material, getTotal());
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonAdicionarRodamaoActionPerformed

    private void jButtonLimparRodamaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparRodamaoActionPerformed
        jPanelRodamaos.removeAll();
        jPanelRodamaos.repaint();
        jPanelRodamaos.revalidate();
        jLabelRodamaoTotalValor.setText("0.0");
        num_linhas_rodamaos = 0;
        notifyObservers(_material, getTotal());
    }//GEN-LAST:event_jButtonLimparRodamaoActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimparRebaixoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarAcabamento;
    private javax.swing.JButton jButtonAdicionarFuro;
    private javax.swing.JButton jButtonAdicionarPeca;
    private javax.swing.JButton jButtonAdicionarRebaixo;
    private javax.swing.JButton jButtonAdicionarRodamao;
    private javax.swing.JButton jButtonLimparAcabamento;
    private javax.swing.JButton jButtonLimparFuro;
    private javax.swing.JButton jButtonLimparPeca;
    private javax.swing.JButton jButtonLimparRebaixo;
    private javax.swing.JButton jButtonLimparRodamao;
    private javax.swing.JButton jButtonNotas;
    private javax.swing.JButton jButtonObservacoes;
    private javax.swing.JComboBox jComboBoxCor;
    private javax.swing.JLabel jLabelAcabamentoTotal;
    private javax.swing.JLabel jLabelAcabamentoTotalValor;
    private javax.swing.JLabel jLabelCor;
    private javax.swing.JLabel jLabelEspessuraPreco;
    private javax.swing.JLabel jLabelFuroTotal;
    private javax.swing.JLabel jLabelFuroTotalValor;
    private javax.swing.JLabel jLabelPecaTotal;
    private javax.swing.JLabel jLabelPecaTotalValor;
    private javax.swing.JLabel jLabelRebaixoTotal;
    private javax.swing.JLabel jLabelRebaixoTotalValor;
    private javax.swing.JLabel jLabelRodamaoTotal;
    private javax.swing.JLabel jLabelRodamaoTotalValor;
    private javax.swing.JPanel jPanelAcabamentoOp;
    private javax.swing.JPanel jPanelAcabamentos;
    private javax.swing.JPanel jPanelFuros;
    private javax.swing.JPanel jPanelFurosOp;
    private javax.swing.JPanel jPanelPecaOp;
    private javax.swing.JPanel jPanelPecas;
    private javax.swing.JPanel jPanelRebaixos;
    private javax.swing.JPanel jPanelRebaixosOp;
    private javax.swing.JPanel jPanelRodamaos;
    private javax.swing.JPanel jPanelRodamaosOp;
    private javax.swing.JScrollPane jScrollPaneAcabamentos;
    private javax.swing.JScrollPane jScrollPaneFuros;
    private javax.swing.JScrollPane jScrollPanePecas;
    private javax.swing.JScrollPane jScrollPaneRebaixos;
    private javax.swing.JScrollPane jScrollPaneRodamaos;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

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
                JPanelEcoLeatherLambrimBalcaoAcabamento l = (JPanelEcoLeatherLambrimBalcaoAcabamento) c;
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

    public void actualizarTotalRodamao() {
        Double d = 0.0;
        for (Component c : jPanelRodamaos.getComponents()) {
            try {
                JPanelEcoLeatherLambrimRodamao j = (JPanelEcoLeatherLambrimRodamao) c;
                d += j.getTotal();
            } catch (Exception e) {
            }
        }

        jLabelRodamaoTotalValor.setText(df.format(d));
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
        } else if (enviou.equalsIgnoreCase("rodamao")) {
            actualizarTotalRodamao();
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
