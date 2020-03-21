/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.dao;

import com.javaweb.interfaces.CRUD;
import com.javaweb.modelo.Persona;
import com.serviciowebcrud.jdbc.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abarrime
 */
public class PersonaDAO implements CRUD {

    public PersonaDAO() {

    }

    @Override
    public List<Persona> listar() {
        List<Persona> listadoPersonas = new ArrayList<>();
        String sql = "select * from persona";
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idPersona = resultSet.getInt(1);
                String dni = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                Persona persona = new Persona(idPersona, dni, nombre, apellido);
                listadoPersonas.add(persona);
            }
        } catch (SQLException ex) {

        }
        return listadoPersonas;
    }

    @Override
    public Persona listarPorIdPersona(int idPersona) {
        Persona persona = new Persona();
        String sql = "select * from persona where id_persona = " + idPersona;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                persona.setIdPersona(resultSet.getInt(1));
                persona.setDni(resultSet.getString(2));
                persona.setNombre(resultSet.getString(3));
                persona.setApellido(resultSet.getString(4));
            }
        } catch (SQLException ex) {

        }
        return persona;
    }

    @Override
    public boolean agregar(Persona persona) {
        boolean valorRetorno = false;
        int filasAfectadas = 0;
        String sql = "insert into persona(id_persona, dni, nombre, apellido) values(?, ?, ?, ?)";
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, persona.getIdPersona());
            statement.setString(2, persona.getDni());
            statement.setString(3, persona.getNombre());
            statement.setString(4, persona.getApellido());
            filasAfectadas = statement.executeUpdate();

            valorRetorno = filasAfectadas == 1;

        } catch (SQLException ex) {

        }
        return valorRetorno;
    }

    @Override
    public boolean editar(Persona persona) {
        boolean valorRetorno = false;
        int filasAfectadas = 0;
        String sql = "update persona set dni = ?, nombre = ?, apellido = ? where id_persona = " + persona.getIdPersona();
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, persona.getDni());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            filasAfectadas = statement.executeUpdate();

            valorRetorno = filasAfectadas == 1;

        } catch (SQLException ex) {

        }
        return valorRetorno;
    }

    @Override
    public boolean eliminar(int idPersona) {
        boolean valorRetorno = false;
        String sql = "delete from persona where id_persona =" + idPersona;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            valorRetorno = statement.execute();
            if (valorRetorno) {
                valorRetorno = true;
            }
        } catch (SQLException ex) {

        }
        return valorRetorno;
    }

}
