/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidad.Venta;
import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Mati Droid
 */
public class VentaDAO {
    
    private Statement st;

    public VentaDAO() {
    }
    
    public Venta ven(String codVenta){
        Venta ven = null;
        String sql = "SELECT * FROM venta WHERE codVenta = '"+codVenta+"';";
        try(Statement st = Conexion.getConnection().createStatement()){
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                ven = new Venta(
                        rs.getInt("id_venta"),
                        rs.getString("codVenta"),
                        rs.getString("cliente"),
                        rs.getString("libro"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha_venta"),
                        rs.getInt("neto"),
                        rs.getInt("total")
  
                );
            }
        }catch(SQLException ex){
            System.out.println("Error en buscar venta x codigo "+ex.getMessage());
        }
        return ven;
    }
    
    public ArrayList<Venta> ventas(){
        String sql = "SELECT * FROM venta";
        ArrayList<Venta> ventas = new ArrayList<Venta>();
        try(Statement st = Conexion.getConnection().createStatement()){
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ventas.add(new Venta(
                        rs.getInt("id_venta"),
                        rs.getString("codVenta"),
                        rs.getString("cliente"),
                        rs.getString("libro"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha_venta"),
                        rs.getInt("neto"),
                        rs.getInt("total")
                ));
            }
        }catch(SQLException ex){
            System.out.println("Error en listar ventas -> "+ex.getMessage());
        }
        return ventas;
    }
    
    public void IngresarVenta(Venta ven){
        try{
            st = Conexion.getConnection().createStatement();
            st.executeUpdate("INSERT INTO venta (codVenta, cliente, libro, cantidad, fecha_venta, neto, total)"
                    + "Values('"+ven.getCodVenta()+"', '"+
                                ven.getCliente()+"', '"+
                                ven.getLibro()+"', "+
                                ven.getCantidad()+", NOW(),"+
                                ven.getNeto()+", "+
                                ven.getTotal()+");");
            
        }catch(SQLException ex){
            System.out.println("Error en Ingresar Venta -> "+ex.getMessage());
        }
    }
    
    public void ModificarVenta(Venta ven) {
    int entero = 0;
    try {
        st = Conexion.getConnection().createStatement();
        entero = st.executeUpdate("UPDATE venta SET cliente = '" + ven.getCliente() + "', "
                                  + "libro = '" + ven.getLibro() + "', "
                                  + "cantidad = " + ven.getCantidad() + ", "
                                  + "neto = " + ven.getNeto() + ", "
                                  + "total = " + ven.getTotal() + " "
                                  + "WHERE codVenta = '" + ven.getCodVenta() + "';");
    } catch (SQLException ex) {
        System.out.println("Error en modificar venta: " + ex.getMessage());
    }
}
    
    public void EliminarVenta(String codVenta){
        try{
            st = Conexion.getConnection().createStatement();
            st.executeUpdate("DELETE FROM venta where codVenta = '"+codVenta+"';");
            System.out.println("Venta Eliminada");
        }catch(SQLException ex){
            System.out.println("Error eliminar la venta -> "+ex.getMessage());
        }
    }

}
