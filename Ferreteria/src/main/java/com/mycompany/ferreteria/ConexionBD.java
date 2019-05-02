/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ferreteria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author pedro
 */
public class ConexionBD {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/Don_Cheto";
    static final String USERNAME = "root";
    static final String PASSWORD = "admin";
    private Connection conexion;
    private Statement instruccion;
    private ResultSet resultados;
    public boolean conectado = false;
    
    public ConexionBD() throws SQLException, ClassNotFoundException{
        Class.forName(DRIVER);
        conexion = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        instruccion = conexion.createStatement();
        
        conectado = true;
    }
    
    public ResultSet setQuery(String query) throws SQLException, IllegalStateException{
        if(!conectado)
            throw new IllegalStateException("Sin conexión a Base de Datos");
        
        resultados = instruccion.executeQuery(query);
        
        return resultados;
    }
    
    public void DesconectarBase(){
        if(conectado){
            try{
                resultados.close();
                instruccion.close();
                conexion.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            finally{
                conectado = false;
            }
        }
    }
}
