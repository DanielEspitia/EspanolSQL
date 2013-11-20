/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan L
 */
public class Variables {

    /**
     * @param args the command line arguments
     */
    public static int bandera;
    public int identificador, validador;
    public static String letra;
   // private Numeros n= new Numeros();
    
    public void verificar(String cad) {
       
        bandera=0;
        letra="";
        // TODO code application logic here
        String identificador, comparador;
        int contador = 0, contador2=0, operacional=0;
        int vacio = 0;
        int inicio_num = 0;
        int reservadas = 0;

       
        identificador = cad;
       
        comparador = identificador.toLowerCase();
        //JOptionPane.showMessageDialog(null, identificador);


        String Reservadas[] = new String[115];
        Reservadas[0] = "añadir";
        Reservadas[1] = "todo";
        Reservadas[2] = "alterar";
        Reservadas[3] = "y";
        Reservadas[4] = "ninguno";
        Reservadas[6] = "como";
        Reservadas[7] = "ascendente";
        Reservadas[8] = "respaldo";
        Reservadas[9] = "inicio";
        Reservadas[10] = "entre";
        Reservadas[11] = "romper";
        Reservadas[12] = "por";
        Reservadas[13] = "cascada";
        Reservadas[14] = "caso";
        Reservadas[15] = "checar";
        Reservadas[16] = "cerrar";
        Reservadas[17] = "agrupar";
        Reservadas[18] = "columna";
        Reservadas[19] = "realizar";
        Reservadas[20] = "calcular";
        Reservadas[21] = "construir";
        Reservadas[22] = "continuar";
        Reservadas[23] = "convertir";
        Reservadas[24] = "crear";
        Reservadas[25] = "cruzar";
        Reservadas[26] = "actualizar";
        Reservadas[27] = "actual_fecha";
        Reservadas[28] = "actual_hora";
        Reservadas[29] = "actual_fecha_hora";
        Reservadas[30] = "actual_usuario";
        Reservadas[31] = "base_datos";
        Reservadas[32] = "defecto";
        Reservadas[33] = "borrar";
        Reservadas[34] = "descendente";
        Reservadas[35] = "disco";
        Reservadas[36] = "distinguir";
        Reservadas[37] = "eliminar";
        Reservadas[38] = "contrario";
        Reservadas[39] = "fin";
        Reservadas[40] = "excepto";
        Reservadas[41] = "ejecutar";
        Reservadas[42] = "existir";
        Reservadas[43] = "salida";
        Reservadas[44] = "externo";
        Reservadas[45] = "archivo";
        Reservadas[46] = "para";
        Reservadas[47] = "foranea";
        Reservadas[48] = "desde";
        Reservadas[49] = "completo";
        Reservadas[50] = "funcion";
        Reservadas[51] = "saltar";
        Reservadas[52] = "conceder";
        Reservadas[53] = "grupo";
        Reservadas[54] = "tomar";
        Reservadas[55] = "identidad";
        Reservadas[56] = "si";
        Reservadas[57] = "en";
        Reservadas[58] = "indice";
        Reservadas[59] = "interior";
        Reservadas[60] = "insertar";
        Reservadas[61] = "intersectar";
        Reservadas[62] = "dentro";
        Reservadas[63] = "es";
        Reservadas[64] = "unir";
        Reservadas[65] = "llave";
        Reservadas[66] = "izquierdo";
        Reservadas[67] = "parecido";
        Reservadas[68] = "cargar";
        Reservadas[69] = "no_agrupar";
        Reservadas[70] = "no";
        Reservadas[71] = "nulo";
        Reservadas[72] = "de";
        Reservadas[73] = "apagar";
        Reservadas[74] = "encender";
        Reservadas[75] = "abrir";
        Reservadas[76] = "opcion";
        Reservadas[77] = "o";
        Reservadas[78] = "orden";
        Reservadas[79] = "sobre";
        Reservadas[80] = "porcentaje";
        Reservadas[81] = "procedimiento";
        Reservadas[82] = "publico";
        Reservadas[83] = "leer";
        Reservadas[84] = "referente";
        Reservadas[85] = "restaurar";
        Reservadas[86] = "restriccion";
        Reservadas[87] = "retornar";
        Reservadas[88] = "revertir";
        Reservadas[89] = "revocar";
        Reservadas[90] = "derecha";
        Reservadas[91] = "deshacer";
        Reservadas[92] = "guardar";
        Reservadas[93] = "esquema";
        Reservadas[94] = "seleccionar";
        Reservadas[95] = "sesion_usuario";
        Reservadas[96] = "establecer";
        Reservadas[97] = "algunos";
        Reservadas[98] = "sistema_usuario";
        Reservadas[99] = "tabla";
        Reservadas[100] = "entonces";
        Reservadas[101] = "a";
        Reservadas[102] = "transaccion";
        Reservadas[103] = "disparador";
        Reservadas[104] = "truncar";
        Reservadas[105] = "unico";
        Reservadas[106] = "actualizar";
        Reservadas[107] = "usar";
        Reservadas[108] = "usuario";
        Reservadas[109] = "valores";
        Reservadas[110] = "vista";
        Reservadas[111] = "cuando";
        Reservadas[112] = "donde";
        Reservadas[113] = "mientras";
        Reservadas[114] = "con";
        
        for (int i = 0; i < Reservadas.length; i++) {
            if (comparador.equals(Reservadas[i])) {
                reservadas++;
            }
        }

        if (identificador.length() == 0) {
            vacio++;
        } else if (Character.isDigit(identificador.charAt(0))) {
            inicio_num++;
           
        }//fin de if-else que verifica que en la caja de texto no este vacia
        //Y tambien verifica que el identificador no comience con un digito



        for (int i = 0; i < identificador.length(); i++) {
            if(identificador.charAt(0)=='@'&& Character.isDigit(identificador.charAt(1))){
            contador++;
                
            }
            else
              if(identificador.charAt(0)=='@'&& !Character.isLetter(identificador.charAt(1))){
            contador++;   
            }
            else
                if ( (Character.isLetter(identificador.charAt(i)) || Character.isDigit(identificador.charAt(i)) || identificador.charAt(0) == '@') 
                    || (identificador.charAt(0) == '=' || identificador.charAt(0) == '<' || identificador.charAt(0) == '>' || identificador.charAt(0) == '(' || identificador.charAt(0) == ')' || identificador.charAt(0) == '\'' || identificador.charAt(0) == '*')
                    || (identificador.charAt(0) == '<' && identificador.charAt(1) == '=') 
                    || (identificador.charAt(0) == '>' && identificador.charAt(1) == '=') 
                    || (identificador.charAt(0) == '!' && identificador.charAt(1) == '=')  ) {
                  
                } else {
                contador2++;
                letra = letra + " " + identificador.charAt(i);
            }
        } //Validador de todos los caracteres validos





        if (reservadas >= 1) {
            bandera=1;
         
        } else if (contador >= 1) {
            bandera=2;
            
        } else if (vacio >= 1) {
            bandera=3;
           
        } else if (inicio_num >= 1) {
            bandera=4;
            
        } else if (contador2 >= 1) {
           bandera=5;
           
        } else if (operacional >= 1) {
           bandera=7;
           
        } else {
            bandera=6;
           
        }
        //if-else que permiten la impresión de acuerdo al caso dado

    }
    
    public String obtenerVerificacion(){
        String msj=" ";
         identificador=0;
        if(bandera==1){
              msj="PALABRA RESERVADA";
              
        }
        else
            if(bandera==2){
                msj="Variable NO VALIDA porque despues de @ existe un Digito o Signo";
                identificador++;
            }
           else
                if(bandera==3){
                    msj="Caja de Texto Vacia";
                    identificador++;
                }
        else
                    if(bandera==4){
                        msj="Variable NO VALIDA porque inicia con un Digito";
                        identificador++;
                    }
        else
                        if(bandera==5){
                           msj= "Variable NO VALIDA por el caracter '"  + letra + "";
                           identificador++;
                        }
        else
                            if(bandera==6){
                                msj="VALIDA";
                            }
        else
                             if(bandera==7){
                           msj= "Operador Lógico";
                        }
        
        return msj;
        
    }
    
    public int obtenerValidador(){
      if(identificador>0)
            validador=1;
        else
            validador=0;
        
        System.out.println("Variable: "+validador);
        System.out.println("Identificador: "+identificador);
        return validador;
    }
}
