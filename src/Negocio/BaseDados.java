/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.TreeMap;

/**
 *
 * @author Miguel
 */
public class BaseDados {

    /*
    private TreeMap<Integer, Material> _materiais;

    public BaseDados() {
        _materiais = new TreeMap<Integer, Material>();
    }

    public BaseDados(TreeMap<Integer, Material> materiais) {
        _materiais = materiais;
    }
*/
    /****************************************/
    /*            MATERIAIS                 */  
    /****************************************/
/*    public TreeMap<Integer, Material> getMateriais() {
        TreeMap<Integer, Material> r = new TreeMap<Integer, Material>();
        for (Material m : _materiais.values()) {
            r.put(m.getId(), m.clone());
        }

        return r;
    }
    
    public void setMateriais(TreeMap<Integer, Material> materiais){
        _materiais = materiais;
    }
*/   
    /****************************************/
    /*               CORES                  */  
    /****************************************/
/*    public TreeMap<Integer, Cor> getCores(Integer idMaterial){
        return _materiais.get(idMaterial).getCores();
    }
    
    public void setCores(Integer idMaterial, TreeMap<Integer, Cor> cores){
        _materiais.get(idMaterial).setCores(cores);
    }
*/    
    /****************************************/
    /*            ACABAMENTOS               */  
    /****************************************/
/*    public TreeMap<Integer, Acabamento> getAcabamentos(Integer idMaterial){
        return _materiais.get(idMaterial).getAcabamentos();
    }

    public void setAcabamentos(Integer idMaterial, TreeMap<Integer, Acabamento> acabamentos){
        _materiais.get(idMaterial).setAcabamentos(acabamentos);
    }
*/    
    /****************************************/
    /*              CANTOS                  */  
    /****************************************/
/*    public TreeMap<Integer, Canto> getCantos(Integer idMaterial){
        return _materiais.get(idMaterial).getCantos();
    }

    public void setCantos(Integer idMaterial, TreeMap<Integer, Canto> cantos){
        _materiais.get(idMaterial).setCantos(cantos);
    }
    
    
    
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Material m : _materiais.values()) {
            s.append(m.toString()).append("\n");
        }

        return s.toString();
    }
  */  
}
