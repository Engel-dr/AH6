/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author CesarLopez
 */
public class usuario {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    public void listar() {

        String sql = "select * from alumnos";

        try {
            //Inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void crear(String nombre, String apellido, String edad,String nota_promedio) {

        String sql = "insert alumnos(nombre,apellido,edad,nota_promedio) values (?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
             ps.setString(3, edad);
             ps.setString(4, nota_promedio);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modificar(int id, String nombre, String apellido, String edad,String nota_promedio) {

        String sql = "update alumnos set nombre = ?, apellido = ?" + ", edad = ?,nota_promedio = ? where id_alumno = ?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
             ps.setString(3, edad);
            ps.setString(4, nota_promedio);
             ps.setInt(5, id);
             ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminar(int codigo) {
        String sql = "delete from alumnos where id_alumno=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public usuario consultar(String correo_electronico, String contrasenia) {

        String sql = "select * from usuarios where correo_electronico like ?  or contrasenia like ?;";

        try {
            //Inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+correo_electronico+"%");
            ps.setString(2, "%"+contrasenia+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getInt(8));
               
               
            }
             return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }
    
    public static void main(String[] args) {
        usuario ud = new usuario();
//ud.crear("Pedro", "Quino", "17", "70");
//ud.crear("Sandra", "Lopez", "18", "80");
//ud.crear("Angel", "Donis", "18", "99.2");
//ud.modificar(5, "Pedro", "Velasquez", "17", "85");
//ud.modificar(6, "Ninette", "Rivera", "19", "65");
//ud.modificar(7, "Angel", "Donis", "19", "98");   
   ud.eliminar(6);
    }
}
