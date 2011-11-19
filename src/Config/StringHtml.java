/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class StringHtml {

    public static String tiraEspacos(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static String html_toolTipText(String text) {
        StringBuilder s = new StringBuilder();
        s.append("<html><table width=\"200\"><tr><td>");
        s.append(tiraEspacos(text));
        s.append("</td></tr></table></html>");

        return s.toString();
    }

    public static String html_list(ArrayList<String> text, String titulo) {
        StringBuilder s = new StringBuilder();
        s.append("<html><table width=\"600\"><tr><td>");

        if (titulo != null && !titulo.equalsIgnoreCase("")) {
            s.append("<h3>").append(titulo).append("</h3>");
        }

        s.append("<ul>");
        for (String t : text) {
            s.append("<li>").append(tiraEspacos(t)).append("</li>");
        }
        s.append("</ul></td></tr></table></html>");

        return s.toString();
    }
    
    public static String html_list_numeric(ArrayList<String> text, String titulo) {
        StringBuilder s = new StringBuilder();
        s.append("<html><table width=\"600\"><tr><td>");

        if (titulo != null && !titulo.equalsIgnoreCase("")) {
            s.append("<h3>").append(tiraEspacos(titulo)).append("</h3>");
        }

        s.append("<ol>");
        for (String t : text) {
            s.append("<li>").append(tiraEspacos(t)).append("</li>");
        }
        s.append("</ol></td></tr></table></html>");

        return s.toString();
    }
}
