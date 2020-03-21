/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.controlador;

import com.javaweb.dao.PersonaDAO;
import com.javaweb.interfaces.CRUD;
import com.javaweb.modelo.Persona;
import java.util.List;

/**
 *
 * @author abarrime
 */
public class PersonaControlador {

    private final CRUD personaDAO;

    public PersonaControlador() {
        this.personaDAO = new PersonaDAO();
    }

    public List<Persona> listar() {
        return this.personaDAO.listar();
    }

    public Persona listarPorIdPersona(int idPersona) {
        return this.personaDAO.listarPorIdPersona(idPersona);
    }

    public boolean agregar(Persona persona) {
        return this.personaDAO.agregar(persona);
    }

    public boolean editar(Persona persona) {
        return this.personaDAO.editar(persona);
    }

    public boolean eliminar(int idPersona) {
        return this.personaDAO.eliminar(idPersona);
    }

}
