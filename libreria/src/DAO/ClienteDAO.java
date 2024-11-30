/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidad.Cliente;
import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Mati Droid
 */
public class ClienteDAO {
    private Statement st;

    public ClienteDAO() {
    }
    
    public Cliente cli(String rut){
        Cliente cli = null;
        String sql = "SELECT * FROM cliente where rut = '"+rut+"';";
        try(Statement st = Conexion.getConnection().createStatement()){
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cli = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("rut"),
                        rs.getString("nomcli"),
                        rs.getString("ap_patcli"),
                        rs.getString("ap_matcli"),
                        rs.getString("direccion"),
                        rs.getString("correo")        
                );
            }
        }catch(SQLException ex){
            System.out.println("Error en buscar cliente x rut: "+ex.getMessage());
        }
        return cli;
    }
    
    public ArrayList<Cliente> clientes(){
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try(Statement st = Conexion.getConnection().createStatement()){
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                clientes.add(new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("rut"),
                    rs.getString("nomcli"),
                    rs.getString("ap_patcli"),
                    rs.getString("ap_matcli"),
                    rs.getString("direccion"),
                    rs.getString("correo")
                ));
            }
        }catch(SQLException ex){
            System.out.println("Error en listarClientes "+ex.getMessage());
        }
        return clientes;
    }
    
    public void IngresarCliente(Cliente cli){
        try{
            st = Conexion.getConnection().createStatement();
            st.executeUpdate("INSERT INTO cliente (rut, nomcli, ap_patcli, ap_matcli, direccion, correo) " +
                 "VALUES ('" + cli.getRut() + "', '" +
                             cli.getNombre() + "', '" +
                             cli.getAppaterno() + "', '" +
                             cli.getApmaterno() + "', '" +
                             cli.getDireccion() + "', '" +
                             cli.getCorreo() + "')");
        }catch(SQLException ex){
            System.out.println("Error en ingresar Cliente "+ex.getMessage());
        }
    }
    
    public void ModificarCliente(Cliente cli){
        int entero = 0;
        try{
            st = Conexion.getConnection().createStatement();
            entero = st.executeUpdate("UPDATE cliente set nomcli = '"+cli.getNombre()+"',"
                                                        +"ap_patcli = '"+cli.getAppaterno()+"', "
                                                        +"ap_matcli = '"+cli.getApmaterno()+"',"
                                                        +"direccion = '"+cli.getDireccion()+"',"
                                                        +"correo = '"+cli.getCorreo()+"' where rut = '"+cli.getRut()+"';");
        }catch(SQLException ex){
            System.out.println("Error en modificar cliente "+ex.getMessage());
        }
    }
    
    public void EliminarCliente(String rut){
        try{
            st = Conexion.getConnection().createStatement();
            st.executeUpdate("DELETE from cliente where rut = '"+rut+"';");
            System.out.println("Cliente eliminado");
        }catch(SQLException ex){
            System.out.println("Error en eliminar cliente "+ex.getMessage());
        }
    }
}
