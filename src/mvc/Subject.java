/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author miguel
 */
public interface Subject {

    public void addObserver(Observer o);

    public void removeObserver(Observer o);
    
    public void notifyObservers(String n);
    
    public void notifyObservers(String n, Double d);
    
    public void notifyObservers(String material, String cor);
}
