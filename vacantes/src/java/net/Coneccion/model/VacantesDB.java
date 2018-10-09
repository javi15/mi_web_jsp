/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Coneccion.model;

import static java.lang.String.format;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.vacantes.model.Vacantes;

/**
 *
 * @author javier
 */
public class VacantesDB {
    DbConnection conn;

    public VacantesDB(DbConnection conn) {
        this.conn = conn;
    }
    
    public boolean insert(Vacantes vct){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "insert into vacante value(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, vct.getId());
            ps.setString(2, format.format(vct.getFechapublicacion()));
            ps.setString(3, vct.getNombre());
            ps.setString(4, vct.getDescripcion());
            ps.setString(5, vct.getDetalle());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VacantesDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Vacantes> getUltimos(){

try{
String sql = "SELECT * FROM vacante ORDER BY id DESC LIMIT 3";
PreparedStatement ps = conn.getConnection().prepareStatement(sql);
ResultSet rs = ps.executeQuery();
List<Vacantes> list = new LinkedList<>();
Vacantes vct;
while(rs.next()){
    vct = new Vacantes(rs.getInt("id"));
    vct.setFechapublicacion(rs.getDate("fechaPublicacion"));
    vct.setNombre(rs.getString("nombre"));
    vct.setDescripcion(rs.getString("descripcion"));
    vct.setDetalle(rs.getString("detalle"));
    list.add(vct);   

    }
    return list;
    } catch (SQLException e){
    
    System.out.println("ERROR" + e);
    return null;
    }
    }
    
    
    public Vacantes getById(int IdVacante){
    
    try{
        String sql = "SELECT * FROM vacante where id=? limit 1";
        PreparedStatement ps = conn.getConnection().prepareStatement(sql);
        ps.setInt(1, IdVacante);
        ResultSet rs = ps.executeQuery();
        Vacantes vct = new Vacantes(0);
        while(rs.next()){
            vct.setId(rs.getInt("id"));
            vct.setFechapublicacion(rs.getDate("fechaPublicacion"));
            vct.setNombre(rs.getString("nombre"));
            vct.setDescripcion(rs.getString("descripcion"));
            vct.setDetalle(rs.getString("detalle"));
        }
    return vct;
    }
    catch(SQLException e){
        System.out.println("ERROR" + e.getMessage());
        return null;
    }
    }
    
      public List<Vacantes> getAll(){

try{
String sql = "SELECT * FROM vacante ORDER BY id DESC";
PreparedStatement ps = conn.getConnection().prepareStatement(sql);
ResultSet rs = ps.executeQuery();
List<Vacantes> list = new LinkedList<>();
Vacantes vct;
while(rs.next()){
    vct = new Vacantes(rs.getInt("id"));
    vct.setFechapublicacion(rs.getDate("fechaPublicacion"));
    vct.setNombre(rs.getString("nombre"));
    vct.setDescripcion(rs.getString("descripcion"));
    vct.setDetalle(rs.getString("detalle"));
    list.add(vct);   

    }
    return list;
    } catch (SQLException e){
    
    System.out.println("ERROR" + e.getMessage());
    return null;
    }
    }
      
         public List<Vacantes> getByQuery(String query){

try{
String sql = "SELECT * FROM vacante WHERE (descripcion like ? or nombre like ?) ORDER BY id DESC";
PreparedStatement ps = conn.getConnection().prepareStatement(sql);
ps.setString(1, "%"+ query +"%");
ps.setString(2, "%"+ query +"%");
ResultSet rs = ps.executeQuery();
List<Vacantes> list = new LinkedList<>();
Vacantes vct;
while(rs.next()){
    vct = new Vacantes(rs.getInt("id"));
    vct.setFechapublicacion(rs.getDate("fechaPublicacion"));
    vct.setNombre(rs.getString("nombre"));
    vct.setDescripcion(rs.getString("descripcion"));
    vct.setDetalle(rs.getString("detalle"));
    list.add(vct);   

    }
    return list;
    } catch (SQLException e){
    
    System.out.println("ERROR" + e.getMessage());
    return null;
    }
    }
}
    

