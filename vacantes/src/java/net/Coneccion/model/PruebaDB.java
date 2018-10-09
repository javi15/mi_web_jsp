/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Coneccion.model;

import net.vacantes.model.Usuario;

/**
 *
 * @author javier
 */
public class PruebaDB {
    public static void main(String[] args) {
        DbConnection conn = new DbConnection();
        UsuarioDB user = new UsuarioDB(conn);
    //    Usuario usuarios = user.login('admin', '1234');
    Usuario u = user.login("admin", "1234");
        System.out.println(u);
    }
}
