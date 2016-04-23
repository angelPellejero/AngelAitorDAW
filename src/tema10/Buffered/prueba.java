/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema10.Buffered;

import com.sun.javafx.util.Utils;
import jdk.nashorn.internal.objects.NativeString;



/**
 *
 * @author Ángel
 */
public class prueba {

    public static void main(String[] args) {
        String a = "000010C   ABADIA DEL ROSARIO                                ABADIA DEL ROSARIOA\n";
        String aux[];
       aux=Utils.split(a, " ");
       StringBuilder sb = new StringBuilder("");
       sb.append(NativeString.substr(aux, aux[1], aux[aux.length-1]));
       System.out.println(sb.toString());
    }
}
