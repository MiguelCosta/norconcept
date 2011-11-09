/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author miguel
 */
public class MaterialPedra extends Material{
    
    private String _nome;
    private TreeMap<Double, Espessura> _espessuras;
    private HashMap<String, Cor> _cores;
    private HashMap<String, Rodape> _rodapes;
    private HashMap<String, Furo> _furos;
    private HashMap<String, Rebaixo> _rebaixos;
    private HashMap<String, Colocao> _colocacoes;
    
    private ArrayList<String> _notas;
    private ArrayList<String> _obs;
    
    public MaterialPedra(String nome, TreeMap<Double, Espessura> espessuras, HashMap<String, Cor> cores,
            HashMap<String, Rodape> rodapes, HashMap<String, Furo> furos, HashMap<String, Rebaixo> rebaixos,
            HashMap<String, Colocao> colocacoes, ArrayList<String> notas, ArrayList<String> obs
            ){
        _nome = nome;
        _espessuras = espessuras;
        _cores = cores;
        _rodapes = rodapes;
        _furos = furos;
        _rebaixos = rebaixos;
        _colocacoes = colocacoes;
        _notas = notas;
        _obs = obs;
        
    } 
    
    
}
