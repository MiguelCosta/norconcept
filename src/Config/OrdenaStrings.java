/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.util.Comparator;

/**
 *
 * @author miguel
 */
public class OrdenaStrings implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.compareTo(s2) < 0) {
            return -1;
        }
        if (s1.compareTo(s2) == 0) {
            return 0;
        }
        return 1;
    }
}
