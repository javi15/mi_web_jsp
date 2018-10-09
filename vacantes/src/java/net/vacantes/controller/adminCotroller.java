/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.vacantes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.Coneccion.model.UsuarioDB;
import net.Coneccion.model.DbConnection;
import net.vacantes.model.Usuario;
/**
 *
 * @author javier
 */
public class adminCotroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibir parametros
    String action = request.getParameter("action");
    
    //Recuperar session activa
    HttpSession session = request.getSession();
    RequestDispatcher rd;
    String msg = "";
        
        
        switch(action){
        case "login":
            //Aqui no existe todavia una session para el usuario lo mandamos al forn de login.
            if(session.getAttribute("usuario") == null){
                request.setAttribute("message", msg);
                rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            } else {
            
                //ya esta logeado
                rd = request.getRequestDispatcher("/admin.jsp");
                rd.forward(request,response);
            
            }
            
            break;
            
            case "logout":
            session.invalidate();
            response.sendRedirect(request.getContextPath()+ "/ofertas");
            break;
            
            case "crear":
                if(session.getAttribute("usuario") == null){
                    msg = "Acceso Denegado";
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request,response);
                
                } else {
                
                    rd = request.getRequestDispatcher("/frmvacante.jsp");
                    rd.forward(request,response);
                }
                break;
    
    }
    }

   
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recibir paramentro
    String userParam = request.getParameter("user");
    String passParam = request.getParameter("pass");
    String msg = "";
    // Recuperar instancia del obj HttpSession
    HttpSession session = request.getSession();
    
    DbConnection conn = new DbConnection();
    UsuarioDB userDB = new UsuarioDB(conn);
    
    //Buscar si el usuario es correcto
    Usuario usuario = userDB.login(userParam, passParam);
    conn.desconnet();
    
    RequestDispatcher rd;
    if(usuario.getId() > 0){
    /* Creamos una variable de session con el registro de usuario (Bean)
    verificamos el administrador de applicaciones de tomtac */
    session.setAttribute("usuario", usuario);
    rd = request.getRequestDispatcher("/admin.jsp");
    rd.forward(request,response);
    } else {
    msg = "Usuario o Pass incorrectos";
    request.setAttribute("messege", msg);
    rd = request.getRequestDispatcher("/login.js");
    rd.forward(request,response);
    }
    
    }

    

}
