
package variables;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;


/**
 *
 * @author Jorge
 */
public class Select{

    public int ident, validador;
    static String cadena,comparador;
    static String select, campo, from, tabla, where, condicionCampo, Operador, valor;
    static int cont,contador,bandera=0, contWhere=0;
    static boolean falta;
    static String letra = "";
    
    public void AnalizarSeleccionar(String Cadena){
        
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
       
         falta=true;
         cont=0;
         contador=0;
         contWhere=0;
        
        cadena = Cadena;
        comparador = cadena.toLowerCase();
        
        StringTokenizer tokens = new StringTokenizer(comparador, " \n");
        
        if (tokens.countTokens() > 3 ) {
            //System.out.println("entra1");
            //Select SIMPLE sin where
            if (tokens.countTokens()>=4) {
                //System.out.println("entra2");
                while (tokens.hasMoreTokens()&& contador==0) {
                select = tokens.nextToken();
                campo = tokens.nextToken();
                from = tokens.nextToken();
                tabla = tokens.nextToken();
                contador++;
                }//fin de while

            for (int i = 0; i < Reservadas.length; i++) {
                //System.out.println("entra"+(3+i));
                if (select.equals(Reservadas[i]) && select.equals("seleccionar")) {
                    //System.out.println("Si esta SELECT");
                    cont++;
                    falta=false;
                }
                if (from.equals(Reservadas[i]) && from.equals("de")) {
                    //System.out.println("Si esta FROM");
                    cont++;
                    falta=true;
                }
            }//fin de for para comparar con el arreglo
            
            if (cont == 2) {
                System.out.println("Sintaxis: CUMPLE con SELECCIONAR y DE");
                bandera=1;
            } else {
                if (falta==true) {
                    System.out.println("Sintaxis: NO CUMPLE falta SELECCIONAR");
                    bandera=2;
                }else{
                    System.out.println("Sintaxis: NO CUMPLE falta DE");
                    bandera=3;
                }     
            }
            
            Variables variable = new Variables();
            
                if (!campo.equals("*")) {
                    variable.verificar(campo);
                    System.out.println("Campo --> "+variable.obtenerVerificacion());
                }else{
                    System.out.println("Campo --> Variable VALIDA ");
                }
                
                variable.verificar(tabla);
                System.out.println("Tabla --> "+variable.obtenerVerificacion());
                
          }//Fin de Select SIMPLE 
            
            System.out.println("i=" + select + "\n" +"n=" + campo +  "\n" + "i=" + from + "\n" + "n=" + tabla);
           
         
            //select nombre from ventas where nombre = juan
            
            StringTokenizer tokens2 = new StringTokenizer(comparador, " \n");
            //System.out.println(comparador);
            //System.out.println(tokens2.countTokens());
            
        if (tokens2.countTokens()==8) {
            
            String temp=tokens2.nextToken();
            contWhere++;
             //System.out.println("si entro 8");
             //Select COMPLEJO  con where
                while (tokens2.hasMoreTokens()) {
                    //System.out.println(temp);
                  
                    if (!temp.equals("donde") && contWhere <= 4) {
                        temp=tokens2.nextToken();
                        contWhere++;
                    }else{
                       where =temp;
                       condicionCampo = tokens2.nextToken();
                       Operador = tokens2.nextToken();
                       valor = tokens2.nextToken();
                    }   
                }//fin de while

            for (int i = 0; i < Reservadas.length; i++) {
                if (where.equals(Reservadas[i]) && where.equals("donde")) {
                   //System.out.println("Si esta WHERE");
                    cont++;
                    falta=true;
                }                
            }//fin de for para comparar con el arreglo
            
            if (cont == 3) {
                System.out.println("Sintaxis: CUMPLE con SELECCIONAR, DE y DONDE");
                bandera=4;
            } else {
                if (cont == 2 && falta==false) {
                    //System.out.println("Sintaxis: NO CUMPLE falta WHERE");
                    bandera=5;
                }    
            }
            
            Variables variable = new Variables();
           
                    variable.verificar(condicionCampo);
                    System.out.println("Campo Condicion --> "+variable.obtenerVerificacion());
                
            if ("=".equals(Operador)||"!=".equals(Operador)||">".equals(Operador)||"<".equals(Operador)||">=".equals(Operador)||"<=".equals(Operador)) {
                System.out.println("Operador --> Valido");
            }else{
                System.out.println("Operador --> NO Valido");
                bandera=6;
            }
            
            System.out.println("i=" + where + "\n" +"n=" + condicionCampo +  "\n" + "i=" + Operador + "\n" + "n=" + valor);
            
         }else if (tokens2.countTokens()!=4 && tokens2.countTokens()!=8) {
              bandera=7;
         }
                  
     }//fin de if para comparar tamaño de cadena
         
        else {
            System.out.println("Consulta No Correcta");
        }//else del if de comparar tamaño de cadena

    }//fin de metodo
    
    public String obtenerSelect(){
        ident=0;
        String msj=" ";
        if(bandera==1){
             msj="Sintaxis: CUMPLE con SELECCIONAR y DE";
             ident=1;
        }
        else
        if(bandera==2){
             msj="Sintaxis: NO CUMPLE falta SELECCIONAR";
        }
        else
            if(bandera==3){
                msj="Sintaxis: NO CUMPLE falta DE";
            }
           else
                if(bandera==4){
                   msj="Sintaxis: CUMPLE con SELECCIONAR, DE y DONDE";
                   ident=1;
                }
        else
                    if(bandera==5){
                msj="Sintaxis: NO CUMPLE falta DONDE";
                    }
        else
                    if(bandera==6){
                msj="Sintaxis: Se esperaba un Operador en la comparacion";
                    }
        else
                    if(bandera==7){
                msj="Sintaxis: Error faltan campos para utilizar DONDE";
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
}//fin de class
