/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.*;

/**
 *
 * @author Mati Droid
 */
public class Conexion {
    public static Connection getConnection() throws SQLException{
        Connection cn = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", null);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("ERROR!!!!");
        }
        System.out.println("Conectado");
        return cn;
    }
}
