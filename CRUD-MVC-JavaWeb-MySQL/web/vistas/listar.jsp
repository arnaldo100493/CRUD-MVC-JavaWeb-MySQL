<%-- 
    Document   : listar
    Created on : 19/03/2020, 11:04:04 PM
    Author     : abarrime
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.javaweb.modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="com.javaweb.controlador.PersonaControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="resources/css/estilos.css">
        <script type="text/javascript" src="resources/js/formulario.js"></script>
        <title>Listar Personas</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Listar Personas</h1>
        </div>
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h5>Listado de Personas</h5>
                    <hr/>
                    <a href="./persona?accion=agregar" class="btn btn-success">Nueva Persona</a>
                    <a href="index.jsp" class="btn btn-info" style="margin-left: 10px;">Volver</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr class="text-center">
                                <th>ID</th>
                                <th>DNI</th>
                                <th>NOMBRES</th>
                                <th>APELLIDOS</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <%
                            PersonaControlador personaControlador = new PersonaControlador();
                            List<Persona> listadoPersonas = personaControlador.listar();
                            Iterator<Persona> iterator = listadoPersonas.iterator();
                            Persona persona = null;
                            while (iterator.hasNext()) {
                                persona = iterator.next();

                        %>
                        <tbody>
                            <tr class="text-center">
                                <td><%=persona.getIdPersona()%></td>
                                <td><%=persona.getDni()%></td>
                                <td><%=persona.getNombre()%></td>
                                <td><%=persona.getApellido()%></td>
                                <td>
                                    <a href="./persona?accion=editar&id=<%=persona.getIdPersona()%>" class="btn btn-warning">Editar</a>
                                    <a href="#" class="btn btn-danger" style="margin-left: 10px;">Eliminar</a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
