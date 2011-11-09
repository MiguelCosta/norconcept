/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.HashMap;

/**
 *
 * @author Miguel
 */
public class Cor {

    private String _nome;
    private String _unidade;
    // a 1º Double é o valor da espessura, o 2º double é o preço correspondente
    private HashMap<Double, Double> _preco_cores;

    public Cor(String nome, String unidade, HashMap<Double, Double> preco_cores) {
        _nome = nome;
        _unidade = unidade;
        _preco_cores = preco_cores;
    }

    public Cor(Cor c) {
        _nome = c.getNome();
        _unidade = c.getUnidade();
        _preco_cores = c.getPreco_Cores();
    }

    public String getNome() {
        return _nome;
    }

    public String getUnidade() {
        return _unidade;
    }

    public HashMap<Double, Double> getPreco_Cores() {
        HashMap<Double, Double> r = new HashMap<Double, Double>();
        for (Double d : _preco_cores.keySet()) {
            r.put(d, _preco_cores.get(d));
        }
        return r;
    }

    @Override
    public Cor clone() {
        return new Cor(this);
    }
}
