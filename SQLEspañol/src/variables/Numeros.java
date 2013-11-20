/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author Daniel
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class Numeros {

   public  int bandera, ident, validador;
   public static    String identificador, letra1 = "";
   public static      int contador;
//   public static     int puntos = 0;
   public static     String letra = "";
   public static     String letra2 = "";
   public static     String letra3 = "";
   public static     String letra4 = "";
    //public static String letra = "";
    
    public void checarNum(String num) {
        
         bandera=0;
          contador = 0;
        int puntos = 0;
        // TODO code application logic here
    

        identificador = num;



        for (int i = 0; i < identificador.length(); i++) {
            if (Character.isLetter(identificador.charAt(i))||identificador.charAt(i)=='*'||identificador.charAt(i)=='+'||identificador.charAt(i)=='['||identificador.charAt(i)==']'
                    ||identificador.charAt(i)=='-'||identificador.charAt(i)==','||identificador.charAt(i)=='$'||identificador.charAt(i)=='#'||identificador.charAt(i)=='"'||identificador.charAt(i)=='!'||identificador.charAt(i)=='='
                    ||identificador.charAt(i)==')'||identificador.charAt(i)=='/'||identificador.charAt(i)=='&'||identificador.charAt(i)=='='||identificador.charAt(i)=='?'
                    ||identificador.charAt(i)=='¿'||identificador.charAt(i)=='¡') {
                contador++;
                letra = "Número No Válido";
                //System.exit(0);
                break;
            }//Detecta caracteres en los numeros
            else if (Character.isDigit(identificador.charAt(i)) || identificador.charAt(i) == '.') {
                if (Character.isDigit(identificador.charAt(i))) {

                    letra2 = "ENTERO";
                }//ESte deteca los enteros

                if (identificador.charAt(i) == '.') {
                    puntos++;

                }


            } //Validador de todos los caracteres validos



        }
        
        System.out.println(puntos);
       
        if (puntos == 0) {
            bandera=1;
           // JOptionPane.showMessageDialog(null, "" + letra2);
        }
        if (puntos >= 2) {
            bandera=2;
          //  JOptionPane.showMessageDialog(null, "Error de puntos");
        }
        if (puntos == 1) {
            bandera=3;
           // JOptionPane.showMessageDialog(null, "Decimal");
        }
         if(contador>=1){
            bandera=4;
        }
    }
    
    public String obtenerNum(){
        String msj=" ";
        ident=0;
        if(bandera==1){
              msj=""+letra2;
        }
        else
            if(bandera==2){
                msj="Error de puntos";
                ident++;
            }
           else
                if(bandera==3){
                    msj="DECIMAL";
                }
        else
                    if(bandera==4){
                        msj=""+letra;
                        ident++;
                    }
        
        
        return msj;
        
    }
      public int obtenerValidador(){
     if(ident>0)
            validador=1;
        else
            validador=0;
        
        System.out.println("Numero: "+validador);
        
        return validador;
    }
}