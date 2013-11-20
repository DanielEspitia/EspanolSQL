/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Delete {
    public int ident, validador;
     public static int bandera;
    private Variables v = new Variables();
    static boolean siTieneD, siTieneF, siTieneW, Veri, puntoComa, opCorrecto;
    String delete, from, table, where, var1, op, var2, fin;

    public void Analizar_Delete(String cadSQL) {
        //contador
        bandera = 0;
        //Palabras Reservadas en español
        String Reservadas[] = new String[4];
        Reservadas[0] = "borrar";
        Reservadas[1] = "desde";
        Reservadas[2] = "donde";
        Reservadas[3] = "y";
        //Banderas
        siTieneD = false;
        siTieneF = false;
        siTieneW = false;
        Veri = true;
        puntoComa = false;
        opCorrecto = false;

        /*Tokenizar*/
        StringTokenizer tokens = new StringTokenizer(cadSQL.toLowerCase());
        if (tokens.countTokens() == 8) {
            while (tokens.hasMoreTokens()) {
                delete = tokens.nextToken();
                from = tokens.nextToken();
                table = tokens.nextToken();
                where = tokens.nextToken();
                var1 = tokens.nextToken();
                op = tokens.nextToken();
                var2 = tokens.nextToken();
                fin = tokens.nextToken();
            }//fin de while

            for (int i = 0; i < Reservadas.length; i++) {
                if (delete.equals(Reservadas[i]) && delete.equals("borrar")) {
                    siTieneD = true;
                }
                if (from.equals(Reservadas[i]) && from.equals("desde")) {
                    siTieneF = true;
                }
                if (where.equals(Reservadas[i]) && where.equals("donde")) {
                    siTieneW = true;
                }
            }//FIN DE FOR            

            /*Verificar las variables*/
            v.verificar(table);
            if ("PALABRA RESERVADA".equals(v.obtenerVerificacion())) {
                Veri = false;
            }
            v.verificar(var1);
            if ("PALABRA RESERVADA".equals(v.obtenerVerificacion())) {
                Veri = false;
            }

            v.verificar(var2);
            if ("PALABRA RESERVADA".equals(v.obtenerVerificacion())) {
                Veri = false;
            }
            /*Verificar el operador*/
            if ("=".equals(op) || "<".equals(op) || ">".equals(op) || "!=".equals(op) || "<=".equals(op) || ">=".equals(op)) {
                opCorrecto = true;
            }
            /* Verificar final con ; de la condición*/
            if (fin.equals(";")) {
                puntoComa = true;
            }
            /*Imprimir la sentencia escrita*/
            System.out.println("Reservada= " + delete + " \nReservada= " + from + "\nTabla= " + table + "\nReservada= " + where
                    + "\ncondicion= " + var1 + " " + op + " " + var2 + " " + fin);

        } else {
            bandera++;
        }

    }

    public String RevDelete() {
        String msj = "";
        if (bandera < 1) {
            if (siTieneD == true) {
                msj = (delete + ", Si es Palabra Reservada Y coincide con 'BORRAR'");
                System.out.println(msj);
            } else {
                msj = ("¡Error!, se esperaba PALBARA RESERVADA 'BORRAR'");
                System.out.println(msj);
            }
            if (siTieneF == true) {
                msj = (from + ", Si es Palabra Reservada Y coincide con 'DESDE'");
                System.out.println(msj);
            } else {
                msj = ("¡Error!, se esperaba PALBARA RESERVADA 'DESDE'");
                System.out.println(msj);
            }
            if (siTieneW == true) {
                msj = (where + ", Si es Palabra Reservada Y coincide con 'DONDE'");
                System.out.println(msj);
            } else {
                msj = ("¡Error!, se esperaba PALBARA RESERVADA 'DONDE'");
                System.out.println(msj);
            }
            if (Veri == false) {
                msj = ("Revisa el NOMBRE de las Variables, Escribiste una palabra reservada");
                System.out.println(msj);
            }
            if (opCorrecto == false) {
                msj = ("El Operador NO es Correcto, se espera; '=', '<', '>', '!=', '<=', '>='");
                System.out.println(msj);
            }
            if (puntoComa == false) {
                msj = ("Se espera ';' con un espacio antes para finalizar la sentencia");
                System.out.println(msj);
            }
        } else {
            msj = ("La SINTAXIS NO cumple con el Tamaño requerido, \nEjemplo: \n"
                    + "BORRAR DESDE Alumno DONDE Nombre = Juan ;");
            System.out.println(msj);
        }
        if (siTieneD == true && siTieneF == true && siTieneW == true && Veri == true && opCorrecto == true && puntoComa == true) {
            msj = ("SINTÁXIS CORRECTA");
            ident=1;
            System.out.println(msj);
        } else {
            msj = ("SINTÁXIS INCORRECTA");
            System.out.println(msj);
        }
        return msj;
    }
    
    public int obtenerValidador(){
      if(ident==1)
            validador=1;
        else
            validador=0;
        
        System.out.println("Variable: "+validador);
        System.out.println("Identificador: "+ident);
        return validador;
    }
}
