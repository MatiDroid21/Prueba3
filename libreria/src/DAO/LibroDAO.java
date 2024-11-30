/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidad.Libro;
import config.Conexion;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mati Droid
 */
public class LibroDAO {

    private Statement st;

    public LibroDAO() {
    }

    public Libro lib(String codLibro) {
        Libro lib = null;
        String sql = "SELECT * FROM libro where codLibro = '" + codLibro + "';";
        try (Statement st = Conexion.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lib = new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("codLibro"),
                        rs.getString("isbn"),
                        rs.getString("autor"),
                        rs.getString("titulo"),
                        rs.getInt("anio")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error buscar libro por codigo -> " + ex.getMessage());
        }
        return lib;
    }

    public ArrayList<Libro> libros() {
        String sql = "SELECT * FROM libro";
        ArrayList<Libro> libros = new ArrayList<Libro>();
        try (Statement st = Conexion.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                libros.add(new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("codLibro"),
                        rs.getString("isbn"),
                        rs.getString("autor"),
                        rs.getString("titulo"),
                        rs.getInt("anio")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error listar libros " + ex.getMessage());
        }
        return libros;
    }

    public void IngresarLibro(Libro lib) {
        try {
            st = Conexion.getConnection().createStatement();
            st.executeUpdate("INSERT INTO libro (codLibro, isbn, autor,titulo, anio)"
                    + "VALUES ('" + lib.getCodLibro() + "','"
                    + lib.getIsbn() + "','"
                    + lib.getAutor()+ "','"
                    + lib.getTitulo() + "',"
                    + lib.getAnio() + ");");
        } catch (SQLException ex) {
            System.out.println("Error en ingresar libro -> " + ex.getMessage());
        }
    }

    public void ModificarLibro(Libro lib) {
        int entero = 0;
        try {
            st = Conexion.getConnection().createStatement();
            st.executeUpdate("SET SQL_SAFE_UPDATES = 0;");
            entero = st.executeUpdate("UPDATE libro set isbn = '" + lib.getIsbn() + "',"
                    + "titulo = '" + lib.getTitulo() + "',"
                    + "autor = '"+lib.getAutor()+"',"
                    + "anio = " + lib.getAnio() + " where codLibro = '" + lib.getCodLibro() + "';");
        } catch (SQLException ex) {
            System.out.println("Error en modificar Libro " + ex.getMessage());
        }
    }

    public void EliminarLibro(String codLibro) {
        try {
            st = Conexion.getConnection().createStatement();
            st.executeUpdate("DELETE from libro where codLibro = '" + codLibro + "';");
            System.out.println("Libro eliminado");
        } catch (SQLException ex) {
            System.out.println("Error en eliminar libro " + ex.getMessage());
        }
    }
}
