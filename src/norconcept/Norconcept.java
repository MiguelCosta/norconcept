/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package norconcept;

import Interface.JAppletMain;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author Miguel
 */
public class Norconcept {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        JAppletMain theApplet = new JAppletMain();

        JFrame window = new JFrame("Norconcept");
        
        window.setSize(700, 650);

        window.add(theApplet, BorderLayout.CENTER);

        window.setVisible(true);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        theApplet.init();

    }
}
