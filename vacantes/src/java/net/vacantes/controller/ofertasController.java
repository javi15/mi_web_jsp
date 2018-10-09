/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.vacantes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.Coneccion.model.VacantesDB;
import net.vacantes.model.Vacantes;

/**
 *
 * @author javier
 */
@WebServlet(name = "ofertasController", urlPatterns = {"/ofertas"})
public class ofertasController extends HttpServlet {   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        net.Coneccion.model.DbConnection conn = new net.Coneccion.model.DbConnection();
        VacantesDB vctDB = new VacantesDB(conn);
        List<Vacantes> lista = vctDB.getUltimos();
        conn.desconnet();        
        request.setAttribute("ultimas", lista);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }


}
