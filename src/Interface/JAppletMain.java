/*
 * JAppletMain.java
 * Author: Miguel Costa
 * Created on 26/Out/2011, 16:29:25
 */
package Interface;

import Config.StringHtml;
import Info.pdf;
import XML.QueryXML;
import XML.QueryXML_Lingua;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.xml.xpath.XPathExpressionException;
import mvc.Observer;
import mvc.Subject;

/**
 *
 * @author Miguel
 */
public class JAppletMain extends javax.swing.JApplet implements Observer, Subject {
    
    QueryXML _q;
    QueryXML_Lingua _l;
    DecimalFormat df = new DecimalFormat("#.##");
    Double _valor = 0.0;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    Loading _loading = new Loading();

    /**
     * Initializes the applet JAppletMain
     */
    @Override
    public void init() {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*
                 * Metal Nimbus CDE/Motif GTK+
                 */
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                //JOptionPane.showMessageDialog(rootPane, "Tema: "+info.getName());
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JAppletMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAppletMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAppletMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAppletMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the applet
         */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                
                @Override
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
        }

        // meu código
        _loading.setTitle("Loading...");
        //_loading.setDefaultCloseOperation(1);
        _loading.repaint();
        
        loading();
        
        carregarBD();
        preencherTipoMateriais();
        configs_lng();
        jRadioButtonPT.setSelected(true);
        loading_no();
    }
    
    private void carregarBD() {

        //URL base = getDocumentBase();
        //URL xmlBD = new URL(base, "DataBase.xml");

        //JOptionPane.showConfirmDialog(rootPane, "URL: " + base.toString());
        //JOptionPane.showConfirmDialog(rootPane, "URL: " + xmlBD.toString());

        _q = new QueryXML();
        _l = new QueryXML_Lingua();
        
    }

    // <editor-fold defaultstate="collapsed" desc="Lingua">   
    private void configs_lng() {
        String tm = _l.queryText("main", "jLabelTipoMaterial");
        String tm_desc = _l.queryText("main", "jLabelTipoMaterial_desc");
        String v_s_iva = _l.queryText("main", "jLabelTotal_desc_semIVA");
        String v_c_iva = _l.queryText("main", "jLabelTotal_desc_comIVA");
        String iva = _l.queryText("main", "jLabelTotal_desc_IVA");
        String imagens = _l.queryText("main", "jButtonImagens");
        String imagens_desc = _l.queryText("main", "jButtonImagens_desc");
        String iva_label = _l.queryText("main", "iva");
        
        jLabelTipoMaterial.setText(tm);
        jLabelTipoMaterial.setToolTipText(StringHtml.html_toolTipText(tm_desc));
        jLabelTotal.setToolTipText(StringHtml.html_toolTipText(v_s_iva));
        jLabelTotalValor.setToolTipText(StringHtml.html_toolTipText(v_s_iva));
        jLabelTotalComIVA.setToolTipText(StringHtml.html_toolTipText(v_c_iva));
        jLabelTotalValorComIVA.setToolTipText(StringHtml.html_toolTipText(v_c_iva));
        jLabelValorIVA.setToolTipText(StringHtml.html_toolTipText(iva));
        
        jButtonImagens.setText(imagens);
        jButtonImagens.setToolTipText(StringHtml.html_toolTipText(imagens_desc));
        jLabelIVA.setText(iva_label);
        
    }
    // </editor-fold>  

    /**
     * PREENCHER COMBO BOX
     */
    private void preencherTipoMateriais() {
        loading();
        jComboBoxTipoMaterial.removeAllItems();
        jComboBoxTipoMaterial.addItem("");
        try {
            ArrayList<String> tipo_materiais = _q.queryTipoMateriais();
            
            for (String s : tipo_materiais) {
                jComboBoxTipoMaterial.addItem(s);
                System.out.println(s);
            }
        } catch (XPathExpressionException ex) {
            Logger.getLogger(JAppletMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        loading_no();
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabelTipoMaterial = new javax.swing.JLabel();
        jComboBoxTipoMaterial = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonPT = new javax.swing.JRadioButton();
        jRadioButtonFR = new javax.swing.JRadioButton();
        jLabelPT_img = new javax.swing.JLabel();
        jLabelFR_img = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelTotalValor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTipoMaterial = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTotalComIVA = new javax.swing.JLabel();
        jLabelTotalValorComIVA = new javax.swing.JLabel();
        jComboBoxIVA = new javax.swing.JComboBox();
        jLabelIVA = new javax.swing.JLabel();
        jLabelValorIVA = new javax.swing.JLabel();
        jButtonImagens = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTipoMaterial.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelTipoMaterial.setText("Escolha o tipo de material:");

        jComboBoxTipoMaterial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoMaterialItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoMaterial, 0, 341, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipoMaterial)
                    .addComponent(jComboBoxTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(178, 178, 178));

        jPanel3.setBackground(new java.awt.Color(178, 178, 178));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jRadioButtonPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(jRadioButtonPT, gridBagConstraints);

        jRadioButtonFR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFRActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jRadioButtonFR, gridBagConstraints);

        jLabelPT_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pt.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jLabelPT_img, gridBagConstraints);

        jLabelFR_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fr.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jLabelFR_img, gridBagConstraints);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jLabelLogo))
                .addContainerGap())
        );

        jPanel3.getAccessibleContext().setAccessibleName("Lingua");

        jLabelTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalValor.setText("€");

        jScrollPane1.setBackground(new java.awt.Color(249, 70, 5));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(665, 353));

        jPanelTipoMaterial.setBackground(new java.awt.Color(208, 192, 190));
        jPanelTipoMaterial.setAutoscrolls(true);

        javax.swing.GroupLayout jPanelTipoMaterialLayout = new javax.swing.GroupLayout(jPanelTipoMaterial);
        jPanelTipoMaterial.setLayout(jPanelTipoMaterialLayout);
        jPanelTipoMaterialLayout.setHorizontalGroup(
            jPanelTipoMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );
        jPanelTipoMaterialLayout.setVerticalGroup(
            jPanelTipoMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelTipoMaterial);

        jLabelTotal.setText("TOTAL (s/ IVA)");

        jLabelTotalComIVA.setFont(new java.awt.Font("Ubuntu", 1, 14));
        jLabelTotalComIVA.setText("TOTAL (c/ IVA)");

        jLabelTotalValorComIVA.setFont(new java.awt.Font("Ubuntu", 1, 14));
        jLabelTotalValorComIVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalValorComIVA.setText("€");

        jComboBoxIVA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "23 %", "19.6 %", "5.5 %" }));
        jComboBoxIVA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxIVAItemStateChanged(evt);
            }
        });

        jLabelIVA.setText("IVA:");

        jLabelValorIVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorIVA.setText("€");

        jButtonImagens.setText("Imagens");
        jButtonImagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImagensActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 10));
        jLabel1.setForeground(new java.awt.Color(107, 169, 255));
        jLabel1.setText("Copyright by Miguel Costa");

        jButton1.setText("PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                        .addComponent(jLabelTotalComIVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalValorComIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButtonImagens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelIVA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValorIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalValor)
                            .addComponent(jLabelTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelValorIVA)
                            .addComponent(jComboBoxIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIVA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalValorComIVA)
                            .addComponent(jLabelTotalComIVA)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonImagens)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))))
        );
    }// </editor-fold>//GEN-END:initComponents

    /*
     * MUDA O TIPO DE MATERIAL
     */
    private void jComboBoxTipoMaterialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoMaterialItemStateChanged
        loading();
        
        String tipo_material = materialSeleccionado();
        _q.setTipoMaterial(tipo_material);
        jComboBoxTipoMaterial.setToolTipText(tipo_material);
        
        if (tipo_material.equalsIgnoreCase("Mármores e Granitos")) {
            _valor = 0.0;
            actualizarPrecos();
            if (jPanelTipoMaterial.getComponents().length > 0) {
                jPanelTipoMaterial.removeAll();
            }
            
            JPanelPedra j = new JPanelPedra(_q, _l, tipo_material);
            j.addObserver(this);
            jPanelTipoMaterial.add(j);
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            
            jPanelTipoMaterial.setLayout(new BoxLayout(jPanelTipoMaterial, BoxLayout.X_AXIS));
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            addObserver(j);

            //JOptionPane.showMessageDialog(rootPane, "Tipo Material entrou: " + tipo_material);
        } else if (tipo_material.equalsIgnoreCase("Silestone ECO Leather e Volcano - Lambrim e Balcão")) {
            _valor = 0.0;
            actualizarPrecos();
            if (jPanelTipoMaterial.getComponents().length > 0) {
                jPanelTipoMaterial.removeAll();
            }
            
            JPanelEcoLeatherLambrimBalcao j = new JPanelEcoLeatherLambrimBalcao(_q, _l, tipo_material);
            j.addObserver(this);
            jPanelTipoMaterial.add(j);
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            
            jPanelTipoMaterial.setLayout(new BoxLayout(jPanelTipoMaterial, BoxLayout.X_AXIS));
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            addObserver(j);
        } else if (tipo_material.equalsIgnoreCase("Silestone ECO Leather e Volcano - Ladrilhos")) {
            _valor = 0.0;
            actualizarPrecos();
            if (jPanelTipoMaterial.getComponents().length > 0) {
                jPanelTipoMaterial.removeAll();
            }
            
            JPanelEcoLeatherLadrilhos j = new JPanelEcoLeatherLadrilhos(_q, _l, tipo_material);
            j.addObserver(this);
            jPanelTipoMaterial.add(j);
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            
            loading_no();
            
            jPanelTipoMaterial.setLayout(new BoxLayout(jPanelTipoMaterial, BoxLayout.X_AXIS));
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            addObserver(j);
        } else if (tipo_material.equalsIgnoreCase("Silestone ECO Polido - Lambrim e Balcão")) {
            _valor = 0.0;
            actualizarPrecos();
            if (jPanelTipoMaterial.getComponents().length > 0) {
                jPanelTipoMaterial.removeAll();
            }
            
            JPanelEcoPolidoLambrimBalcao j = new JPanelEcoPolidoLambrimBalcao(_q, _l, tipo_material);
            j.addObserver(this);
            jPanelTipoMaterial.add(j);
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            
            jPanelTipoMaterial.setLayout(new BoxLayout(jPanelTipoMaterial, BoxLayout.X_AXIS));
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            addObserver(j);
        } else if (tipo_material.equalsIgnoreCase("Silestone ECO Polido - Ladrilhos")) {
            _valor = 0.0;
            actualizarPrecos();
            if (jPanelTipoMaterial.getComponents().length > 0) {
                jPanelTipoMaterial.removeAll();
            }
            
            JPanelEcoPolidoLadrilhos j = new JPanelEcoPolidoLadrilhos(_q, _l, tipo_material);
            j.addObserver(this);
            jPanelTipoMaterial.add(j);
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            
            loading_no();
            
            jPanelTipoMaterial.setLayout(new BoxLayout(jPanelTipoMaterial, BoxLayout.X_AXIS));
            jPanelTipoMaterial.repaint();
            jPanelTipoMaterial.revalidate();
            addObserver(j);
        } else {
            jLabelTotalValor.setText("0");
            if (jPanelTipoMaterial.getComponents().length > 0) {
                jPanelTipoMaterial.removeAll();
            }
            JPanelNada j = new JPanelNada(_l);
            jPanelTipoMaterial.add(j);
            jPanelTipoMaterial.setLayout(new BoxLayout(jPanelTipoMaterial, BoxLayout.X_AXIS));
            observers.add(j);
            
        }
        
        jPanelTipoMaterial.revalidate();
        
        jPanelTipoMaterial.repaint();
        
        loading_no();
        this.repaint();
    }//GEN-LAST:event_jComboBoxTipoMaterialItemStateChanged
    private void jRadioButtonPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPTActionPerformed
        loading();
        jRadioButtonPT.setSelected(true);
        jRadioButtonFR.setSelected(false);
        
        this.repaint();
        
        _l.setLingua("pt");
        configs_lng();
        notifyObservers("lng");
        
        loading_no();
    }//GEN-LAST:event_jRadioButtonPTActionPerformed
    
    private void jRadioButtonFRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFRActionPerformed
        _loading.setVisible(true);
        System.out.println("Loading...");
        jRadioButtonPT.setSelected(false);
        jRadioButtonFR.setSelected(true);
        
        this.repaint();
        
        _l.setLingua("fr");
        configs_lng();
        
        notifyObservers("lng");
        
        loading_no();
    }//GEN-LAST:event_jRadioButtonFRActionPerformed
    
    private void jComboBoxIVAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxIVAItemStateChanged
        actualizarPrecos();
    }//GEN-LAST:event_jComboBoxIVAItemStateChanged
    
    private void jButtonImagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagensActionPerformed
        JFrameImagens mine = new JFrameImagens(_q, _l);
        mine.setTitle("Imagens");
        mine.setDefaultCloseOperation(1);
        mine.setVisible(true);
    }//GEN-LAST:event_jButtonImagensActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pdf.main(null);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonImagens;
    private javax.swing.JComboBox jComboBoxIVA;
    private javax.swing.JComboBox jComboBoxTipoMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFR_img;
    private javax.swing.JLabel jLabelIVA;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelPT_img;
    private javax.swing.JLabel jLabelTipoMaterial;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalComIVA;
    private javax.swing.JLabel jLabelTotalValor;
    private javax.swing.JLabel jLabelTotalValorComIVA;
    private javax.swing.JLabel jLabelValorIVA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTipoMaterial;
    private javax.swing.JRadioButton jRadioButtonFR;
    private javax.swing.JRadioButton jRadioButtonPT;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * *********** Funcões auxiliaures ******************
     */
    private String materialSeleccionado() {
        String m = "";
        try {
            m += jComboBoxTipoMaterial.getSelectedItem().toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro");
        }
        return m;
    }
    
    public void actualizarPrecos() {
        jLabelTotalValor.setText(df.format(_valor).toString() + " €");
        String i = jComboBoxIVA.getSelectedItem().toString();
        Double iva = 0.23;
        if (i.equalsIgnoreCase("23 %")) {
            iva = 0.23;
        } else if (i.equalsIgnoreCase("19.6 %")) {
            iva = 0.196;
        } else if (i.equalsIgnoreCase("5.5 %")) {
            iva = 0.05;
        }
        
        Double iva_valor = _valor * iva;
        Double preco = _valor + iva_valor;
        jLabelValorIVA.setText(df.format(iva_valor).toString() + " €");
        jLabelTotalValorComIVA.setText(df.format(preco).toString() + " €");
    }
    
    @Override
    public void update(String n) {
    }
    
    @Override
    public void update(String material, String cor) {
    }
    
    @Override
    public void update(String n, Double v) {
        _valor = v;
        actualizarPrecos();
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
    
    public void loading() {
        _loading.setVisible(true);
        System.out.println("Loading...");
        centerOnScreen(_loading);
    }
    
    public void loading_no() {
        _loading.setVisible(false);
        System.out.println("Ready");
        _loading.setVisible(false);
    }
    
    public static void centerOnScreen(final Component target) {
        if (target != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension dialogSize = target.getSize();
            
            if (dialogSize.height > screenSize.height) {
                dialogSize.height = screenSize.height;
            }
            if (dialogSize.width > screenSize.width) {
                dialogSize.width = screenSize.width;
            }
            
            target.setLocation((screenSize.width - dialogSize.width) / 2,
                    (screenSize.height - dialogSize.height) / 2);
        }
    }
}
