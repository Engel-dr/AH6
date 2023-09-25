/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CesarLopez
 */
public class conexion {
 Connection con;
    String url="jdbc:mysql://localhost:3306/alumnos";
    String user="root";
    String pass="";
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
           
        } catch (Exception e) {
            System.out.println("error:");
            System.out.println(e);
        }      
        return con;   
    }
public static void main(String[] args) {
       conexion con = new conexion();
        System.out.println(con.Conectar());
}    
}
