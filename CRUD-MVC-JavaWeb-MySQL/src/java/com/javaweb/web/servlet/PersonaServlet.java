/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.web.servlet;

import com.javaweb.controlador.PersonaControlador;
import com.javaweb.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abarrime
 */
//@WebServlet(name = "Persona", urlPatterns = {"/persona", "/personaServlet"})
public class PersonaServlet extends HttpServlet {

    public PersonaServlet() {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String listar = "vistas/listar.jsp";
        String agregar = "vistas/agregar.jsp";
        String editar = "vistas/editar.jsp";
        String acceso = "";
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (accion.equalsIgnoreCase("agregar")) {
            acceso = agregar;
        } else if (accion.equalsIgnoreCase("Guardar")) {
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            Persona persona = new Persona(dni, nombre, apellido);
            PersonaControlador personaControlador = new PersonaControlador();
            personaControlador.agregar(persona);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("editar")) {
            //int id = Integer.parseInt(request.getParameter("id"));
            //request.setAttribute("idPersona", id);
            request.setAttribute("idPersona", request.getParameter("id"));
            acceso = editar;
        } else if (accion.equalsIgnoreCase("Actualizar")) {
            int idPersona = Integer.parseInt(request.getParameter("idPersona"));
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            Persona persona = new Persona(idPersona, dni, nombre, apellido);
            PersonaControlador personaControlador = new PersonaControlador();
            personaControlador.editar(persona);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Persona persona = new Persona();
            PersonaControlador personaControlador = new PersonaControlador();
            persona.setIdPersona(id);
            personaControlador.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(acceso);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
