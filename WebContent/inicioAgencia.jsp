<%@page import="modelo.SagraDelegate"%>
<%@page import="modelo.dao.AutoDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.dto.AutoDTO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <%
            //inicio del scriplet
            String usuario = null;
 			String RFC = null;
 			RFC = (String) session.getAttribute("RFCagencia");
  			usuario = (String) session.getAttribute("usrAge");
  			
  			System.out.println(RFC+"|"+usuario);
  			if(usuario == null || RFC == null){
  				response.sendRedirect("index.html");
  			}
        %>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SAGRA</title>
     <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
   </body>

      <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->

    <link href="css/inicio.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
             <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">SAGRA</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="paginaActiva"><a href="inicioAgencia.html">Autos</a></li>
            <li><a href="registro_Auto.jsp">Agregar Autos</a></li>
            <li><a href="perfilAgencia.jsp">Perfil de la Agencia</a></li>
            <li><a href="index.html">Salir</a></li>
          </ul>

        </div>
      </div>
    </nav>

    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header">Autos en Renta</h1>

          

          <h2 class="sub-header">Lista de Autos</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Placas</th>
                  <th>modelo</th>
                  <th>color</th>
                  <th>marca</th>
                  <th>Año</th>
                  <th>Número de pasajeros</th>
                </tr>
              </thead>
              <tbody>
                <% 
              	SagraDelegate del = new SagraDelegate();
    			List results;
    			AutoDTO aDto = new AutoDTO();
    			aDto.setRFCAgencia(RFC);
    			
    			results = del.listarAutosxAgencia(aDto); 
    			if(results != null){
    				int tam = results.size();
        			System.out.println(tam);

    		        
        			for (int i=0;i<tam;i++) {
        		          AutoDTO dto;
        		          dto = (AutoDTO) results.get(i);
        		          out.print("<tr>");
        		          out.print("<td>"+dto.getPlacas()+"</td>");
        		          out.print("<td>"+dto.getModelo()+"</td>");
        		          out.print("<td>"+dto.getColor()+"</td>");
        		          out.print("<td>"+dto.getMarca()+"</td>");
        		          out.print("<td>"+dto.getAño()+"</td>");
        		          out.print("<td>"+dto.getNumeroPasajeros()+"</td>");
        		          out.print("</tr>");
        		          
        		    }
    				
    			}
    		
              %>
               
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

  
  </body>
</html>
