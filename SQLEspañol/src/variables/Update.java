/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import java.util.StringTokenizer;

/**
 *
 * @author Daniel
 */
public class Update {
    
    public int ident, validador;
    public static int bandera, bandera2, verificacion;
    public String Reservadas[] = new String[4];
        
    
   public void verificarUpdate(String cadena) {
        Reservadas[0] = "actualizar";
        Reservadas[1] = "establecer";
        Reservadas[2] = "donde";
        Reservadas[3] = "y";
        
        Variables v=new Variables();
        verificacion=0;
        bandera=0;
        String cad=cadena;
        String comparador, palabra, verificador="";
        
       
                
       // comparador = cadena.toLowerCase();
        comparador = cad.toLowerCase();
        StringTokenizer tokens = new StringTokenizer(comparador, " ");
        while(tokens.hasMoreTokens()){
            palabra=tokens.nextToken();
            if (bandera==0){
                if(palabra.equals(Reservadas[0])){
                   // System.out.println("Si hay Actualizar");  
                    bandera++;
                }
                else{ //actualizar
                break;
                }
            }
            else
            if(bandera==1){
                v.verificar(palabra);
                verificador=v.obtenerVerificacion();
                if("VALIDA".equals(verificador)){
                   // System.out.println("SI fue palabra valida");  
                    bandera++;
                }
                else{
                    break;
                }
              } //fin bandera 1
            else
                if(bandera==2){
                    if(palabra.equals(Reservadas[1])){
                    //System.out.println("Si hay Establecer");  
                    bandera++;
                    }
                  else
                    {
                       break;
                    }
                }//fin de bandera 2
            else
                if(bandera==3){
                     v.verificar(palabra);
                     verificador=v.obtenerVerificacion();
                 if( "VALIDA".equals(verificador)){
                  //  System.out.println("SI fue palabra valida");  
                    bandera++;
                }
                else{
                   break;
                }   
             }//fin bandera 3   
            else
               if(bandera==4){
                   //System.out.println("Igual:"+palabra);
                   if(("=".equals(palabra))||("!=".equals(palabra))||("<".equals(palabra))||(">".equals(palabra))||("<=".equals(palabra))||(">=".equals(palabra))){
                      // System.out.println("Si hay un signo de comparacion");
                       bandera++;
                   }
                   else
                   {
                     break;
                   }
               }//fin bandera 4
            else
              if(bandera==5){
                  v.verificar(palabra);
                     verificador=v.obtenerVerificacion();
                 if( "VALIDA".equals(verificador)){
        //             System.out.println("Valor Correcto");
                     bandera++;
                 }
                 else{
                     break;
                 }
              }//fin bandera 5 
            else
            if(bandera==6){
               if(palabra.equals(Reservadas[2])){
              //      System.out.println("Si hay Donde");  
                    bandera++;
                    }
                  else
                    {
                      break;
                    }                
            }//fin bandera 6
            else
            if(bandera==7){
               
                     v.verificar(palabra);
                     verificador=v.obtenerVerificacion();
                 if( "VALIDA".equals(verificador)){
              //      System.out.println("SI fue palabra valida");  
                    bandera++;
                }
                else{
//                    System.out.println("Inserto una variable invalida despues de donde");
                   break;
                }   
             }//fin bandera 7   
            else
               if(bandera==8){
                 //  System.out.println("Igual:"+palabra);
                   if(("=".equals(palabra))||("!=".equals(palabra))||("<".equals(palabra))||(">".equals(palabra))||("<=".equals(palabra))||(">=".equals(palabra))){
   //                    System.out.println("Si hay un signo de comparacion");
                       bandera++;
                   }
                   else
                   {
                    break;
                   }
               }//fin bandera 8
            else
              if(bandera==9){
                  v.verificar(palabra);
                     verificador=v.obtenerVerificacion();
                 if( "VALIDA".equals(verificador)){
     //                System.out.println("Valor Correcto");
                     bandera++;
                 }
                 else{
                   break;
                 }
              }//fin bandera 9 
        }
       
        System.out.println(bandera);
    }
    
    public String obtenerUpdate(){
        ident=0;
        String msj=" ";
        if(bandera==0){
             msj="Error Se esperaba un Actualizar al principio de la sentencia";
        }
        else
        if(bandera==1){
             msj="Inserto una variable invalida despues de actualizar";
        }
        else
            if(bandera==2){
                msj="Se esperaba un Establecer depues del nombre de la tabla";
            }
           else
                if(bandera==3){
                   msj="Inserto una variable invalida despues de establecer";
                }
        else
                    if(bandera==4){
                msj="Se esperaba un signo de comparacion despues de la variable a cambiar";
                    }
        else
                        if(bandera==5){
                          msj="Se esperaba un valor asignado a la variable de Establecer";
                        }
        else
                            if(bandera==6){
                                msj="Se esperaba un Donde para establecer la tupla a modificar";
                            }
         else
                            if(bandera==7){
                              msj="Inserto una variable invalida despues de donde";
                            }
         else
                            if(bandera==8){
                                 msj="Se esperaba un signo de comparacion despues de la variable a cambiar";
                            }
         else
                            if(bandera==9){
                               msj="Se esperaba un valor nuevo"; 
                            }
                           if(bandera==10){
                               verificacion=1;
                               msj="Sintaxis Correcta";
                               ident=1;
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
