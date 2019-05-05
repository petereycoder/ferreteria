package Conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class ConexionBD {
 
    private Connection conexion;

    
    public ConexionBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/don_cheto","root","");
            if(conexion!=null){
                System.out.println("Conexion establecida");
            }
                    }
        catch(Exception e){
            System.out.println("Error"+e);
        }
    
    }
    public Connection getConexionBD(){
    return conexion;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    
    

