/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class CbSucursal {
    
    Connection connection;
    Conexion conexion = new Conexion();
    Statement st;
    ResultSet rs;
    
    public CbSucursal() {
        
    }
    public ArrayList getListaSucursales() {
        System.out.println("Función getListaSucursales"); 
        ArrayList mListaSucursales = new ArrayList();
        Sucursal sucursal = null;
        
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT idSucursal, nombreSucursal FROM `sucursal`;");
            while(rs.next()) {
                sucursal = new Sucursal ();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                mListaSucursales.add(sucursal);
            }
        }catch(SQLException e ){
            System.out.println(e);
        }
        return mListaSucursales;
    }
    
    
  
}




