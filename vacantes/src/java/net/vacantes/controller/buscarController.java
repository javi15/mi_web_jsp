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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.Coneccion.model.VacantesDB;
import net.vacantes.model.Vacantes;
import net.Coneccion.model.DbConnection;

/**
 *
 * @author javier
 */
public class buscarController extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String q = request.getParameter("query");
        List<Vacantes> lista = null;
        DbConnection conn = new DbConnection();
        VacantesDB vctDB = new VacantesDB(conn);
        lista = vctDB.getByQuery(q);
        conn.desconnet();
        RequestDispatcher rd;
        request.setAttribute("vacantes", lista);
        rd = request.getRequestDispatcher("/vacantes.jsp");
        rd.forward(request, response);
    }


}
