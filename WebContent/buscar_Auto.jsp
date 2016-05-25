<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%
            //inicio del scriplet
            String usuario = null;
  			usuario = (String) session.getAttribute("user");
  			if(usuario == null){
  				response.sendRedirect("index.html");
  			}
        %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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

  <nav class="navbar navbar-inverse navbar-fixed-top" >
      <div class="container-fluid" id="nav">
        <div class="navbar-header" >
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
             <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="inicio.html">SAGRA</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right" id="lista">
            <li><a href="inicio.jsp">Autos en Renta</a></li>
            <li class="paginaActiva"><a href="#">Busqueda Personalizada</a></li>
            <li><a href="perfilAgencia.jsp">Perfil</a></li>
            <li><a href="ServletLogout">Salir</a></li>
          </ul>
         
        </div>
      </div>
    </nav>

    <div class="container">
      <div class="row">
        <h2 class="sub-header">Busqueda Personalizada</h2>
        <div class="table-responsive">
            <form class="form-horizontal">
			  <fieldset>
			    <legend>Buscar</legend>
			    <div class="form-group">
			      <label for="inputModelo" class="col-lg-2 control-label">Modelo</label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputModelo" placeholder="Modelo">
			      </div>
			    </div>
			    <div class="form-group">
			      <label for="inputColor" class="col-lg-2 control-label">Color</label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputColor" placeholder="Color">
			      </div>
			    </div>
				<div class="form-group">
			      <label for="inputMarca" class="col-lg-2 control-label">Marca</label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputMarca" placeholder="Marca">
			      </div>
			    </div>
			    <div class="form-group">
			      <label for="inputAnio" class="col-lg-2 control-label">Año</label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputAnio" placeholder="Año">
			      </div>
			    </div>
			   
			    <div class="form-group">
			      <label for="select" class="col-lg-2 control-label">Número de Pasajeros</label>
			      <div class="col-lg-10">
			        <select class="form-control" id="select">
			          <option>1</option>
			          <option>2</option>
			          <option>3</option>
			          <option>4</option>
			        </select>
			        <br>
			    
			      </div>
			    </div>

			    <div class="form-group">
			      <label for="inputTauto" class="col-lg-2 control-label">Tipo de Auto</label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputTauto" placeholder="Tipo de Auto">
			      </div>
			    </div>
			    <div class="form-group">
			      <div class="col-lg-10 col-lg-offset-2">
			        <button type="submit" class="btn btn-primary">Agregar</button>
			      </div>
			    </div>
			  </fieldset>
			</form>
           
          </div>
        </div>
      </div>
    </div>

  
  </body>
</html>

