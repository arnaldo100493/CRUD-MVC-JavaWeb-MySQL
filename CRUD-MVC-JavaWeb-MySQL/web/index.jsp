<%-- 
    Document   : index
    Created on : 19/03/2020, 10:53:39 PM
    Author     : abarrime
--%>

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
        <title>Bienvenidos</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Bienvenidos</h1>
        </div>
        <div class="container mt-4">
            <a href="./persona?accion=listar" class="btn btn-primary">Listar Personas</a>
            <a href="./persona?accion=agregar" class="btn btn-success" style="margin-left: 10px;">Nueva Persona</a>
        </div>
        <hr/>
    </body>
</html>
