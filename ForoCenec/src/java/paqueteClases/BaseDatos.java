/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteClases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Vector;

/**
 *
 * @author alumno
 */
public class BaseDatos {
    static Connection c = null;
    static Statement stmt = null;
    public static void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");    
            c=DBConnector.getInstance("jdbc:mysql://localhost:3306/foro", "root", "").getConnection(); 
        }
        catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
    }
    public static void crearTablaUsuarios(){
        try{
            conectar();
            stmt = c.createStatement();
            String sql="CREATE TABLE IF NOT EXISTS `USUARIOS_IGNACIO`(\n" +
            "  `USUARIO` VARCHAR(255) NOT NULL DEFAULT 'NULL',\n" +
            "  `CONTRASEÑA` VARCHAR(255) NOT NULL DEFAULT 'NULL'\n" +
            ");";
            stmt.executeUpdate(sql);
            /*String sql1="INSERT INTO USUARIOS_IGNACIO(USUARIO,CONTRASEÑA)"+"VALUES('admin','admin')";
            stmt.executeUpdate(sql1);*/
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
            
        }
    }
    public static void crearTablaComentarios(){
        try{
            conectar();
            stmt = c.createStatement();
            String sql="CREATE TABLE IF NOT EXISTS COMENTARIOS_IGNACIO("
              + "ID INT AUTO_INCREMENT PRIMARY KEY,"
              + "FECHA DATE,"
              + "HORA TIME,"
              + "USUARIO VARCHAR(50),"
              + "COMENTARIO VARCHAR(250))";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            /*String sql1="INSERT INTO COMENTARIOS_IGNACIO(USUARIO,COMENTARIO,FECHA,HORA)"+"VALUES('admin','Bienvenidos al foro','2015-05-27','13:14:25')";
            stmt.executeUpdate(sql1);*/
        }
        catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
            
        }
    }
    public static void resgistrarUsuario(String usuarioNuevo, String passwordNueva){
        try {
            conectar();         
            stmt = c.createStatement();
            String sql1="INSERT INTO USUARIOS_IGNACIO(USUARIO,CONTRASEÑA)"+"VALUES('"+usuarioNuevo+"','"+passwordNueva+"');";
            stmt.executeUpdate(sql1);
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            
        }
    }
    public static boolean validarUsuario(String usuarioExistente, String passwordExistente){
        boolean logging = false;
        try{
            conectar();
            stmt = c.createStatement();
            String sql="SELECT * FROM USUARIOS_IGNACIO WHERE USUARIO='"+usuarioExistente+"' AND CONTRASEÑA='"+passwordExistente+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                logging = true;
            }
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);            
        }
        return logging;
    }
    public static void annadirComentario(Date fechaComentario,Time horaComentario, String usuarioComentario, String comentarioNuevo){
       try{
            conectar();
            stmt = c.createStatement();           
            String sql="INSERT INTO COMENTARIOS_IGNACIO(USUARIO,COMENTARIO,FECHA,HORA) VALUES('"+usuarioComentario+"','"+comentarioNuevo+"','"+fechaComentario+"','"+horaComentario+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);            
        } 
    }
    public static Vector cogerComentario(){
        BaseDatos.crearTablaUsuarios();
        BaseDatos.crearTablaComentarios();
        Vector comentarios = new Vector();
        try{
            conectar();
            stmt = c.createStatement();           
            String sql="SELECT * FROM COMENTARIOS_IGNACIO";
            ResultSet rs = stmt.executeQuery(sql);            
            while (rs.next()){
                Date fecha = rs.getDate("FECHA");
                String hora = rs.getString("HORA");
                String usuario = rs.getString("USUARIO");
                String comentario = rs.getString("COMENTARIO");   
                Comentario miComentario = new Comentario(usuario, hora, fecha, comentario);
                comentarios.add(miComentario);                       
            }            
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);            
        }
        
        return comentarios;
    }
}
