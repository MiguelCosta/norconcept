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
public class JPanelPedraRebaixo extends javax.swing.JPanel implements Subject, Observer {

    private String _material;
    private QueryXML _q;
    private QueryXML_Lingua _l;
    private DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    // para não estar a fazer uma query sempre, fica aqui os precos com as cores
    private HashMap<String, Double> rebaixos_e_precos = new HashMap<String, Double>();
    private String rebaixo = "";

    /** Creates new form JPanelPedraPeca */
    public JPanelPedraRebaixo(QueryXML q, QueryXML_Lingua l, String material) {
        initComponents();
        _q = q;
        _l = l;
        _material = material;
        configs();
        configs_lng();
        valores();
    }

    private void configs() {
        SpinnerNumberModel modelSpinnerC = new SpinnerNumberModel(0, 0, 100000, 1);
        jSpinnerNumero.setModel(modelSpinnerC);

        jLabelRebaixo.setName("jLabelRebaixo");
        jLabelNumero.setName("valor");
        jLabelTOTAL.setName("jLabelTOTAL");
        jLabelTOTALValor.setName("valor");
        jLabelRebaixoPreco.setName("valor");
    }

    private void configs_lng() {
        for (Component c : this.getComponents()) {
            if (c instanceof JLabel && !c.getName().equals("valor")) {
                JLabel j = (JLabel) c;
                String texto = _l.queryText("pedraRebaixo", j.getName());
                String desc = StringHtml.html_toolTipText(_l.queryText("pedraRebaixo", j.getName() + "_desc"));
                j.setText(texto);
                j.setToolTipText(desc);
            }
        }
    }

    private void valores() {
        jComboBoxRebaixo.removeAllItems();
        rebaixos_e_precos.clear();
        rebaixos_e_precos = _q.queryRebaixos_NomeEPreco(_material);
        for (String s : rebaixos_e_precos.keySet()) {
            jComboBoxRebaixo.addItem(s);
        }
    }

    public void actualizarTotal() {
        try {
            int numero = Integer.parseInt(jSpinnerNumero.getValue().toString());

            Double preco_rebaixo = rebaixos_e_precos.get(rebaixo);

            Double preco_total = numero * preco_rebaixo;

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

        jLabelRebaixo = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jComboBoxRebaixo = new javax.swing.JComboBox();
        jSpinnerNumero = new javax.swing.JSpinner();
        jLabelTOTAL = new javax.swing.JLabel();
        jLabelTOTALValor = new javax.swing.JLabel();
        jLabelRebaixoPreco = new javax.swing.JLabel();

        jLabelRebaixo.setText("Rebaixo:");

        jLabelNumero.setText("n.º:");

        jComboBoxRebaixo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRebaixoItemStateChanged(evt);
            }
        });

        jSpinnerNumero.setMaximumSize(new java.awt.Dimension(36, 26));
        jSpinnerNumero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerNumeroStateChanged(evt);
            }
        });

        jLabelTOTAL.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabelTOTAL.setText("TOTAL (€):");

        jLabelTOTALValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTOTALValor.setText("€");

        jLabelRebaixoPreco.setText("€");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRebaixo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxRebaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRebaixoPreco)
                .addGap(18, 18, 18)
                .addComponent(jLabelNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
                    .addComponent(jComboBoxRebaixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRebaixo)
                    .addComponent(jLabelTOTALValor)
                    .addComponent(jLabelTOTAL)
                    .addComponent(jLabelRebaixoPreco)
                    .addComponent(jLabelNumero)
                    .addComponent(jSpinnerNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinnerNumeroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerNumeroStateChanged
        actualizarTotal();
        notifyObservers("rebaixo");
    }//GEN-LAST:event_jSpinnerNumeroStateChanged

    private void jComboBoxRebaixoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRebaixoItemStateChanged

        try {
            rebaixo = jComboBoxRebaixo.getSelectedItem().toString();
            jComboBoxRebaixo.setToolTipText(rebaixo);
            Double d = rebaixos_e_precos.get(rebaixo);
            String valor = d.toString() + " €";
            jLabelRebaixoPreco.setText(valor);

            actualizarTotal();
            notifyObservers("rebaixo");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jComboBoxRebaixoItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxRebaixo;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRebaixo;
    private javax.swing.JLabel jLabelRebaixoPreco;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(String n) {
        if (n.equalsIgnoreCase("lng")) {
            configs_lng();
            return;
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
