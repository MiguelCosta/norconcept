/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Miguel
 */
public class Canto {

    private Integer _id;
    private String _nome;
    private double _preco;
    private String _path_imagem;

    public Canto(Integer id, String nome, double preco, String path_imagem) {
        _id = id;
        _nome = nome;
        _preco = preco;
        _path_imagem = path_imagem;
    }
    
    public Canto (Canto c){
        _id = c.getId();
        _nome = c.getNome();
        _preco = c.getPreco();
        _path_imagem = c.getPathImagem();
    }

    public Integer getId() {
        return _id;
    }

    public String getNome() {
        return _nome;
    }

    public double getPreco() {
        return _preco;
    }
    
    public String getPathImagem(){
        return _path_imagem;
    }

    @Override
    public String toString() {
        return _nome + " - " + _id;
    }
    
    @Override
    public Canto clone(){
        return new Canto(this);
    }
}
