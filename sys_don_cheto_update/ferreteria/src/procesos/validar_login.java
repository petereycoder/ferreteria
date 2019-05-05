/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root
 */
public class validar_login {

    ConexionBD conect = new ConexionBD();
    Connection login_DB = conect.getConexionBD();
    boolean validar = false;

    

    public validar_login(String nombre, String pass) throws SQLException {
        Statement s = login_DB.createStatement();
        ResultSet rs = s.executeQuery("select * from empleados");
        while (rs.next()) {
           
            if(rs.getString(2).equals(nombre) && rs.getString(3).equals(pass)){
           System.out.println("los datos coinciden");
            validar=true;
            }
                
        }
        login_DB.close();
    }
    public boolean getValidar() {
        return validar;
    }

}
