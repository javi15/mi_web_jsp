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
import net.Coneccion.model.DbConnection;
import net.Coneccion.model.VacantesDB;
import net.vacantes.model.Vacantes;

/**
 *
 * @author javier
 */
public class vacanteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("ver")){
            this.verDetalle(request,response);
        }
        if(action.equals("lista")){
        this.verTodas(request, response);
    }
    }
    protected void verTodas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //int idVacante = Integer.parseInt(request.getParameter("id"));
        DbConnection conn = new DbConnection();
        VacantesDB vctDB = new VacantesDB(conn);
        List<Vacantes> lista = vctDB.getAll();
        conn.desconnet();
        request.setAttribute("vacantes", lista);
        RequestDispatcher rm;
        rm = request.getRequestDispatcher("/vacantes.jsp");
        rm.forward(request, response);

    }

    protected void verDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idVacante = Integer.parseInt(request.getParameter("id"));
        DbConnection conn = new DbConnection();
        VacantesDB vctDB = new VacantesDB(conn);
        Vacantes vct = vctDB.getById(idVacante);
        conn.desconnet();
        request.setAttribute("vct", vct);
        RequestDispatcher rm;
        rm = request.getRequestDispatcher("/detalle.jsp");
        rm.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nombreParametro = request.getParameter("nombre");
       String descripcionParametro = request.getParameter("descripcion");
       String detalleParametro = request.getParameter("detalle");
       
       Vacantes vct = new Vacantes(0);
       vct.setNombre(nombreParametro);
       vct.setDescripcion(descripcionParametro);
       vct.setDetalle(detalleParametro);
       
       System.out.println(vct);
       
       DbConnection conn = new DbConnection();
       VacantesDB vctDB = new VacantesDB(conn);
       boolean status = vctDB.insert(vct);
       
       String msj = "";
       if(status){
        msj = "Guardado con exito";
       }
       else{
        msj = "Error al guardar la info";
       }
       conn.desconnet();
       RequestDispatcher rm;
       
       request.setAttribute("message", msj);
       rm = request.getRequestDispatcher("/mensaje.jsp");
       rm.forward(request, response);
    }

   

}
