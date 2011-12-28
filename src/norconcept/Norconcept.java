/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package norconcept;

import Interface.JAppletMain;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
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
        
        centerOnScreen(window);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        theApplet.init();
        
    }
    
    public static void centerOnScreen(final Component target) {
        if (target != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension dialogSize = target.getSize();
            
            if (dialogSize.height > screenSize.height) {
                dialogSize.height = screenSize.height;
            }
            if (dialogSize.width > screenSize.width) {
                dialogSize.width = screenSize.width;
            }
            
            target.setLocation((screenSize.width - dialogSize.width) / 2,
                    (screenSize.height - dialogSize.height) / 2);
        }
    }
}
