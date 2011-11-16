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

import XML.QueryXML;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import mvc.Observer;
import mvc.Subject;

/**
 *
 * @author miguel
 */
public class JPanelPedraRodape extends javax.swing.JPanel implements Subject, Observer {

    private String _material;
    private String _cor;
    private QueryXML _q;
    private DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    // para não estar a fazer uma query sempre, fica aqui os precos com as cores
    private HashMap<String, Double> cores_e_precos;
    private String cor_rodape = "";

    /** Creates new form JPanelPedraPeca */
    public JPanelPedraRodape(QueryXML q, String material, String cor) {
        initComponents();
        _q = q;
        _material = material;
        _cor = cor;
        configs();
        valores();
    }

    private void configs() {
        SpinnerNumberModel modelSpinnerC = new SpinnerNumberModel(0, 0, 100000, 1);
        jSpinnerComprimento.setModel(modelSpinnerC);

        jLabelCor.setToolTipText("Selecione a cor na caixa ao lado.");
        jLabelComprimento.setToolTipText("Indique o comprimento que pretende.");
    }

    private void valores() {
        cores_e_precos = _q.queryRodapes_NomeEPreco(_material);

        for (String s : cores_e_precos.keySet()) {
            jComboBoxCor.addItem(s);
        }
    }

    public void actualizarTotal() {
        try {
            int comp = Integer.parseInt(jSpinnerComprimento.getValue().toString());

            Double preco_metro = cores_e_precos.get(cor_rodape);

            Double dim = comp / 100.0;

            Double preco_total = dim * preco_metro;

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

        jLabelCor = new javax.swing.JLabel();
        jLabelComprimento = new javax.swing.JLabel();
        jComboBoxCor = new javax.swing.JComboBox();
        jSpinnerComprimento = new javax.swing.JSpinner();
        jLabelTOTAL = new javax.swing.JLabel();
        jLabelTOTALValor = new javax.swing.JLabel();
        jLabelRodapePreco = new javax.swing.JLabel();

        jLabelCor.setText("Cor:");

        jLabelComprimento.setText("Comp. (cm):");

        jComboBoxCor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCorItemStateChanged(evt);
            }
        });

        jSpinnerComprimento.setMaximumSize(new java.awt.Dimension(36, 26));
        jSpinnerComprimento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerComprimentoStateChanged(evt);
            }
        });

        jLabelTOTAL.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabelTOTAL.setText("TOTAL (€):");

        jLabelTOTALValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTOTALValor.setText("€");

        jLabelRodapePreco.setText("€/m");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRodapePreco)
                .addGap(18, 18, 18)
                .addComponent(jLabelComprimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerComprimento, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
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
                    .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCor)
                    .addComponent(jLabelTOTALValor)
                    .addComponent(jLabelTOTAL)
                    .addComponent(jLabelRodapePreco)
                    .addComponent(jLabelComprimento)
                    .addComponent(jSpinnerComprimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinnerComprimentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerComprimentoStateChanged
        actualizarTotal();
        notifyObservers("rodape");
    }//GEN-LAST:event_jSpinnerComprimentoStateChanged

    private void jComboBoxCorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCorItemStateChanged
        cor_rodape = jComboBoxCor.getSelectedItem().toString();

        Double d = cores_e_precos.get(cor_rodape);
        String valor = d.toString() + " €/m";
        jLabelRodapePreco.setText(valor);

        actualizarTotal();
        notifyObservers("rodape");
    }//GEN-LAST:event_jComboBoxCorItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxCor;
    private javax.swing.JLabel jLabelComprimento;
    private javax.swing.JLabel jLabelCor;
    private javax.swing.JLabel jLabelRodapePreco;
    private javax.swing.JLabel jLabelTOTAL;
    private javax.swing.JLabel jLabelTOTALValor;
    private javax.swing.JSpinner jSpinnerComprimento;
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
        actualizarTotal();
    }

    @Override
    public void update(String material, String cor) {
        _material = material;
        _cor = cor;
        actualizarTotal();
    }
}
