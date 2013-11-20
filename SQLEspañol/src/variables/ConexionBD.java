
package variables;

import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.*;

/**
 *
 * @author JORGE
 */
public class ConexionBD {
    
    private final static String drv = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//Driver
    //private final static String db = "jdbc:sqlserver://localhost;databaseName=CentroEducativo;user=sa;password=mndz;";//Eligiendo La Base de Datos
    private static String db = "jdbc:sqlserver://localhost;";//Base de Datos
    private static String user = "user=";//Usuario
    private static String pass = "password=";//Password
    private static String database="databaseName=";//Base de Datos
    private static String UsarBase="";//Usar Base de Datos
    
    static private Connection ct;
    static private Statement st;
    
    static public ResultSet rs = null;
    
    static public DefaultTreeModel modelo;

    public ConexionBD(){
        try {
            Class.forName(drv);//Se establece y carga el Driver con el que vamos a Trabajar
            System.out.println("Driver cargado correctamente...");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar driver");
        }
        try {
            user+=SQLEspañol.CajaUsuario.getText()+";";
            pass+=SQLEspañol.CajaPass.getText()+";";
            db+=user+pass;
            
            ct = DriverManager.getConnection(db);//Se establece la conexion con la Base de Datos Selecciona, proporcionando el usuario y la contraseña con la cual trabajamos en SGBD
            System.out.println("Conexion Establesida Exitosamente...");//Toma por defaul la Base de Datos MASTER
            SQLEspañol.btnBases.setEnabled(true);
        } catch (SQLException e) {
            System.out.println("Error al Establecer Conexion");
        }
        try {
            st = ct.createStatement();
            System.out.println("Statement Correctamente Creado...");
        } catch (SQLException e) {
            System.out.println("Error al Crear Statement");
        }
    }

 static public void Mostrar(){
        //int contador=1;
        try {

            rs = st.executeQuery("SELECT name, database_id, create_date FROM sys.databases;");

            while(rs.next()){
                System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3));
                SQLEspañol.ListaBases.addItem(rs.getString(1));
                //System.out.println(SQLEspañol.ListaBases.getItemAt(contador));
                //contador++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 static public void SeleccionarBD(String NameBD){
        
     database="databaseName="+NameBD+";";
     UsarBase=NameBD;
     //System.out.println(NameBD);
     try {
            db = "jdbc:sqlserver://localhost;";
            db+=database+user+pass;
            System.out.println(db);
            
            ct = DriverManager.getConnection(db);//Se establece la conexion con la Base de Datos Selecciona, proporcionando el usuario y la contraseña con la cual trabajamos en SGBD
            System.out.println("Conexion Establesida Exitosamente con "+NameBD+"...");
            
        } catch (SQLException e) {
            System.out.println("Error al Establecer Conexion");
        }
    }
 
 
 static public void MostrarTablas(){
        
     try {
         System.out.println("USE "+UsarBase+";");
            st.execute("USE "+UsarBase+";");
           
            rs = st.executeQuery("SELECT TABLE_NAME, TABLE_CATALOG FROM information_schema.tables");

            while(rs.next()){
                System.out.println(rs.getString(1)+"|"+rs.getString(2));                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    ConexionBD.MostrarArbol();
    }
 
 static public void MostrarArbol(){
        
     int hijoNum=0;
     int contador=0;
     
     try {
         
        modelo=(DefaultTreeModel)SQLEspañol.Arbol.getModel();
                
        DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)SQLEspañol.Arbol.getCellRenderer();
        render.setOpenIcon(new ImageIcon("src/base.png"));
        render.setClosedIcon(new ImageIcon("src/base2.png"));
        render.setLeafIcon(new ImageIcon("src/tabla.png"));
        
        // Construccion de los datos del arbol
        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode)SQLEspañol.Arbol.getModel().getRoot();//Obtenemos la Raiz del arbol
        
        DefaultMutableTreeNode base = new DefaultMutableTreeNode(UsarBase);
        modelo.insertNodeInto(base, raiz, 0);
            
        rs=null;
        rs = st.executeQuery("SELECT TABLE_NAME FROM information_schema.tables");
            
            while(rs.next()){
                contador++;
           }
            DefaultMutableTreeNode tabla []=new DefaultMutableTreeNode[contador];
            //System.out.println("contador: "+contador);
         
         rs=null;   
         rs = st.executeQuery("SELECT TABLE_NAME FROM information_schema.tables");
         
            while(rs.next()){
                tabla[hijoNum] = new DefaultMutableTreeNode(rs.getString(1));
                modelo.insertNodeInto(tabla[hijoNum], base, hijoNum);
                System.out.println(rs.getString(1));
                hijoNum++;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}