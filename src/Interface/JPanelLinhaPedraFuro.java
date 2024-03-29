/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelPedraPeca.java
 *
 * Created on 8/Nov/2011, 12:33:43
 */
package Interface;

import Config.StringHtml;
import XML.QueryXML;
import XML.QueryXML_Lingua;
import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import mvc.Observer;
import mvc.Subject;

/**
 *
 * @author miguel
 */
public class JPanelLinhaPedraFuro extends javax.swing.JPanel implements Subject, Observer {

    private String _material;
    private QueryXML _q;
    private QueryXML_Lingua _l;
    private DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    // para não estar a fazer uma query sempre, fica aqui os precos com as cores
    private HashMap<String, Double> furos_e_precos = new HashMap<String, Double>();
    private String furo = "";

    /** Creates new form JPanelPedraPeca */
    public JPanelLinhaPedraFuro(QueryXML q, QueryXML_Lingua l, String material) {
        initComponents();
        _q = q;
        _l = l;
        _material = material;
        configs();
        valores();
        configs_lng();
    }

    private void configs() {
        SpinnerNumberModel modelSpinnerC = new SpinnerNumberModel(0, 0, 100000, 1);
        jSpinnerNumero.setModel(modelSpinnerC);

        jLabelFuro.setName("jLabelFuro");
        jLabelFuroPreco.setName("valor");
        jLabelComprimento.setName("valor");
        jLabelTOTAL.setName("jLabelTOTAL");
        jLabelTOTALValor.setName("valor");
    }

    private void configs_lng() {
        for (Component c : this.getComponents()) {
            if (c instanceof JLabel && !c.getName().equals("valor")) {
                JLabel j = (JLabel) c;
                String texto = _l.queryText("pedraFuro", j.getName());
                String desc = StringHtml.html_toolTipText(_l.queryText("pedraFuro", j.getName() + "_desc"));
                j.setText(texto);
                j.setToolTipText(desc);
            }
        }
    }

    private void valores() {
        furos_e_precos.clear();
        furos_e_precos = _q.queryFuros_NomeEPreco(_material);

        jComboBoxFuro.removeAllItems();
        for (String s : furos_e_precos.keySet()) {
            jComboBoxFuro.addItem(s);
        }
    }

    public void actualizarTotal() {
        try {
            int numero = Integer.parseInt(jSpinnerNumero.getValue().toString());

            Double preco_furo = furos_e_precos.get(furo);

            Double preco_total = numero * preco_furo;

            jLabelTOTALValor.setText(df.format(preco_total).toString());
        } catch (Exception e) {
        }
    }

    public Double getTotal() {
        Double valor = 0.0;
        try {
            String v = jLabelTOTALValor.getText();
            v = v.replace(",", ".");
            valor = Double.parseDouble(v);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: getTotal() em JPanelPedraLinha.java" + e.getMessage());
        }
        return valor;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFuro = new javax.swing.JLabel();
        jLabelComprimento = new javax.swing.JLabel();
        jComboBoxFuro = new javax.swing.JComboBox();
        jSpinnerNumero = new javax.swing.JSpinner();
        jLabelTOTAL = new javax.swing.JLabel();
        jLabelTOTALValor = new javax.swing.JLabel();
        jLabelFuroPreco = new javax.swing.JLabel();

        setBackground(new java.awt.Color(41, 41, 41));

        jLabelFuro.setBackground(new java.awt.Color(204, 204, 204));
        jLabelFuro.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabelFuro.setForeground(new java.awt.Color(204, 204, 204));
        jLabelFuro.setText("Furo:");

        jLabelComprimento.setBackground(new java.awt.Color(204, 204, 204));
        jLabelComprimento.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabelComprimento.setForeground(new java.awt.Color(204, 204, 204));
        jLabelComprimento.setText("n.º:");

        jComboBoxFuro.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jComboBoxFuro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFuroItemStateChanged(evt);
            }
        });

        jSpinnerNumero.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jSpinnerNumero.setMaximumSize(new java.awt.Dimension(36, 26));
        jSpinnerNumero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerNumeroStateChanged(evt);
            }
        });

        jLabelTOTAL.setBackground(new java.awt.Color(204, 204, 204));
        jLabelTOTAL.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabelTOTAL.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTOTAL.setText("TOTAL (€):");

        jLabelTOTALValor.setBackground(new java.awt.Color(204, 204, 204));
        jLabelTOTALValor.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabelTOTALValor.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTOTALValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTOTALValor.setText("€");

        jLabelFuroPreco.setBackground(new java.awt.Color(204, 204, 204));
        jLabelFuroPreco.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabelFuroPreco.setForeground(new java.awt.Color(204, 204, 204));
        jLabelFuroPreco.setText("€/furo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFuro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFuro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFuroPreco)
                .addGap(32, 32, 32)
                .addComponent(jLabelComprimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabelTOTAL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTOTALValor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFuro)
                    .addComponent(jLabelTOTALValor)
                    .addComponent(jLabelTOTAL)
                    .addComponent(jLabelFuroPreco)
                    .addComponent(jSpinnerNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComprimento)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinnerNumeroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerNumeroStateChanged
        actualizarTotal();
        notifyObservers("furo");
    }//GEN-LAST:event_jSpinnerNumeroStateChanged

    private void jComboBoxFuroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFuroItemStateChanged
        try {
            furo = jComboBoxFuro.getSelectedItem().toString();
            jComboBoxFuro.setToolTipText(furo);
            Double d = furos_e_precos.get(furo);
            String valor = d.toString() + " €";
            jLabelFuroPreco.setText(valor);

            actualizarTotal();
            notifyObservers("furo");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jComboBoxFuroItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxFuro;
    private javax.swing.JLabel jLabelComprimento;
    private javax.swing.JLabel jLabelFuro;
    private javax.swing.JLabel jLabelFuroPreco;
    private javax.swing.JLabel jLabelTOTAL;
    private javax.swing.JLabel jLabelTOTALValor;
    private javax.swing.JSpinner jSpinnerNumero;
    // End of variables declaration//GEN-END:variables

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
        //JOptionPane.showMessageDialog(jLabelComprimento, "Vai notificar! Valor: " + d);
        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            Observer observer = it.next();
            observer.update(n);
        }
    }

    @Override
    public void notifyObservers(String material, String cor) {
    }

    @Override
    public void update(String n) {
        if (n.equalsIgnoreCase("lng")) {
            configs_lng();
        }
        actualizarTotal();
    }

    @Override
    public void update(String material, String cor) {
        _material = material;
        valores();
        actualizarTotal();
    }

    @Override
    public void notifyObservers(String n, Double d) {
    }

    @Override
    public void update(String n, Double v) {
    }
}
