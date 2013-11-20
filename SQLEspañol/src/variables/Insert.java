/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import java.util.StringTokenizer;

/**
 *
 * @author Juan L
 */
public class Insert{

    public static boolean iguales;
    public static int bandera, bandera2, bandera3;
    public static String letra = "";
    public int ident, validador;

    public void verificarinsert(String cadena) {
        //Palabras reservadas////////////////////////////////////////////777
        bandera = 0;
        bandera2 = 0;
        bandera3 = 0;
        String comparador;
        String insert = "", into = "", nombre = "", par1 = "",
                par2 = "", columnas = "", entradas = "", values = "", par3 = "", 
par4 = "";
        int cont = 0;
        int contp = 0;

        String Reservadas[] = new String[3];
        Reservadas[0] = "insertar";
        Reservadas[1] = "dentro";
        Reservadas[2] = "valorando";

        //Codigo de tokenizer
        comparador = cadena.toLowerCase();
        StringTokenizer tokens = new StringTokenizer(comparador, " \n");
        if (tokens.countTokens() == 10) {
            while (tokens.hasMoreTokens()) {
                insert = tokens.nextToken();
                into = tokens.nextToken();
                nombre = tokens.nextToken();
                par1 = tokens.nextToken();
                columnas = tokens.nextToken();
                par2 = tokens.nextToken();
                values = tokens.nextToken();
                par3 = tokens.nextToken();
                entradas = tokens.nextToken();
                par4 = tokens.nextToken();
            }//fin de while

            StringTokenizer tokens1 = new StringTokenizer(columnas, ",");
            int cantidad = tokens1.countTokens();

            StringTokenizer tokens2 = new StringTokenizer(entradas, ",");
            int cantidad1 = tokens2.countTokens();

            if (cantidad == cantidad1) {
                iguales = true;
            }
            else{
                
            }

            for (int i = 0; i < Reservadas.length; i++) {
                if (insert.equals(Reservadas[i]) && insert.equals("insertar")) {
                    cont++;
                }
                if (into.equals(Reservadas[i]) && into.equals("dentro")) {
                    cont = cont + 10;
                }
                if (values.equals(Reservadas[i]) && values.equals("valorando")) 
{
                    cont = cont + 100;
                }

////////////////////////////////////////////////////////////////////////////////
            }//fin de for para comparar con el arreglo
            if (par1.charAt(0) == '(' && par3.charAt(0) == '(' && par4.charAt(0) 
== ')' && par2.charAt(0) == ')') {
                cont = cont + 5;
            }

            Variables variable = new Variables();
            variable.verificar(nombre);
            if (variable.obtenerVerificacion() == "PALABRA RESERVADA") {
                bandera3++;
            }//find e nombre tabla
            variable.verificar(columnas);
            if (variable.obtenerVerificacion() == "PALABRA RESERVADA") {
                bandera3++;
            }//fin de nombre campos
            variable.verificar(entradas);
            if (variable.obtenerVerificacion() == "PALABRA RESERVADA") {
                bandera3++;
            }//fin de entradas

            //System.out.println("i=" + insert + "\n" + "i=" + into + "\n" + "n=" + nombre + "\n"
            //      + "par1=" + par1 + "\n" + "columnas=" + columnas + "\n" + "par2=" + par2 + "\n"
            //    + "values=" + values + "\n" + "par3=" + par3 + "\n" + "entradas=" + entradas + "\n"
            //  + "par4=" + par4);
        } else {
            contp++;
        }//else del if de comparar tamaño de cadena
        bandera = cont;
        bandera2 = contp;
    }//fin de metodo Verificar

    public String obtenerVerificacion() {
        String msj = "";
        ident=0;
////////////////////////////////////////////////////////////////////////////////
        if (iguales == true) {
            if (bandera3 < 1) {
                if (bandera2 < 1) {
                    if (bandera == 116) {
                        ident=1;
                        msj = "Tienes todo correcto";
                    }
                    if (bandera == 0 || bandera == 115) {
                        msj = "No Iniciaste con un insert";
                    }
                    if (bandera == 1 || bandera == 106) {
                        msj = "Se esperaba un into despues del insert";
                    }
                    if (bandera == 11 || bandera == 16) {
                        msj = "No usaste un value para asignar valores";
                    }
                    if (bandera == 111) {
                        msj = "Te falto un parentesis";
                    }
                    if (bandera == 110) {
                        msj = "No Iniciaste con insert y te equivocaste en un parentesis";
                    }
                    if (bandera == 101) {
                        msj = "Se esperaba un into despues de insert y te equivocaste en un parentesis";
                    }

                }//fin de if para comparar tamaño de cadena
                else {
                    msj = "No cumple la sintaxis(tamaño)";
                }
            } else {
                msj = "Una de tus variables es palabra RESERVADA, checa porfavor que no sean tus variables palabras reservadas";
            }

        }
        else {
            msj = "No concuerdan entradas ni numero de columnas";
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
