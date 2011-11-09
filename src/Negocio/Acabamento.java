/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Miguel
 */
public class Acabamento {

    private Integer _id;
    private String _nome;

    public Acabamento(Integer id, String nome) {
        _id = id;
        _nome = nome;
    }

    public Acabamento(Acabamento a) {
        _id = a.getId();
        _nome = a.getNome();
    }

    public Integer getId() {
        return _id;
    }

    public String getNome() {
        return _nome;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(_id).append(" - ").append(_nome);
        return s.toString();
    }
    
    @Override
    public Acabamento clone(){
        return new Acabamento(this);
    }
}
