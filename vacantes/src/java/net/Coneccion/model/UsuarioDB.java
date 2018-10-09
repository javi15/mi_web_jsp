/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Coneccion.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.vacantes.model.Usuario;
import net.vacantes.model.Vacantes;

/**
 *
 * @author javier
 */
public class UsuarioDB {
    DbConnection conn;

    public UsuarioDB(DbConnection conn) {
        this.conn = conn;
    }
    
    public Usuario login (String user, String pass){
           
        try{
        String sql = "select * from usuario where username=? and pass=md5(?) and status='activo' limit 1";
        PreparedStatement ps = conn.getConnection().prepareStatement(sql);
        ps.setString(1,user);
        ps.setString(2,pass);
        ResultSet rs = ps.executeQuery();
        Usuario usu = new Usuario(0);
        while(rs.next()){
            usu.setId(rs.getInt("id"));            
            usu.setNombre(rs.getString("nombre"));
            usu.setEmail(rs.getString("email"));
            usu.setUsername(rs.getString("username"));
            usu.setPassword(rs.getString("pass"));
            usu.setStatus(rs.getString("status"));
            usu.setPerfil(rs.getString("perfil"));
        }
    return usu;
    }
    catch(SQLException e){
        System.out.println("ERROR" + e.getMessage());
        return null;
    }
    }
}
