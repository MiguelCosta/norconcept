/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author miguel
 */
public class Espessura {

    private double _valor;
    private String _unidade;

    public Espessura(double valor, String unidade) {
        _valor = valor;
        _unidade = unidade;
    }

    public Espessura(Espessura e) {
        _valor = e.getValor();
        _unidade = e.getUnidade();
    }

    public double getValor() {
        return _valor;
    }

    public String getUnidade() {
        return _unidade;
    }

    public void setValor(double valor) {
        _valor = valor;
    }

    public void setUnidade(String unidade) {
        _unidade = unidade;
    }

    @Override
    public Espessura clone() {
        return new Espessura(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Espessura e = (Espessura) o;
        if (e.getValor() == this.getValor() && e.getUnidade().equalsIgnoreCase(this.getUnidade())) {
            return true;
        }
        return false;
    }
}
