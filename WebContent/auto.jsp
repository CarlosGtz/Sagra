<%@page import="modelo.dto.AutoDTO"%>
<%@page import="modelo.SagraDelegate"%>
<%@page import="modelo.dao.AutoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//inicio del scriplet
	String usuario = null;
	String RFC = null;
	RFC = (String) session.getAttribute("RFCagencia");
	usuario = (String) session.getAttribute("usrAge");
	if (usuario == null || RFC == null) {
		response.sendRedirect("index.html");
	}
	String placas = request.getParameter("placas");
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
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
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
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="true"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SAGRA</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="inicioAgencia.jsp">Autos</a></li>
				<li class="paginaActiva"><a href="registro_Auto.jsp">Agregar
						Autos</a></li>
				<li><a href="perfilAgencia.jsp">Perfil de la Agencia</a></li>
				<li><a href="ServletLogout">Salir</a></li>
			</ul>

		</div>
	</div>
	</nav>
	<% 
		SagraDelegate del = new SagraDelegate();
		AutoDTO dto = new AutoDTO();
		dto.setPlacas(placas);
		AutoDTO dtoRes = del.leerAuto(dto);
		
		
	%>


	<div class="container">
		<div class="row">
			<div class="col-lg-12">

				<h2 class="sub-header">Modificar Autos</h2>
				<div class="table-responsive">
					<form class="form-horizontal" action="UpdaterAuto" method="post"
						enctype="multipart/form-data">
						<fieldset>
							<input type="hidden" name="id" class="form-control"  required value="<%out.print(dtoRes.getId());%>">
							<div class="form-group">
								<div class="col-lg-10">
									<img src="img/<%out.println(placas); %>" width="200" height="200"
									class="img-responsive" alt="Generic placeholder thumbnail">								
								</div>
							</div>
							<div class="form-group">
								<label for="inputModelo" class="col-lg-2 control-label">Modelo</label>
								<div class="col-lg-10">
									<input type="text" name="modelo" class="form-control"
										id="inputModelo"  required value="<%out.print(dtoRes.getModelo());%>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPlacas" class="col-lg-2 control-label">Placas</label>
								<div class="col-lg-10">
									<input type="hidden" name="placas" class="form-control"
										id="inputPlacas"  required value="<%out.print(placas);%>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputColor" class="col-lg-2 control-label">Color</label>
								<div class="col-lg-10">
									<input type="text" name="color" class="form-control"
										id="inputColor"  required value="<%out.print(dtoRes.getColor());%>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputMarca" class="col-lg-2 control-label">Marca</label>
								<div class="col-lg-10">
									<input type="text" name="marca" class="form-control"
										id="inputMarca"  required value="<%out.print(dtoRes.getMarca());%>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputAnio" class="col-lg-2 control-label">Año</label>
								<div class="col-lg-10">
									<input type="text" name="anio" class="form-control"
										id="inputAnio"  required value="<%out.print(dtoRes.getAño());%>">
								</div>
							</div>

							<div class="form-group">
								<label for="select" class="col-lg-2 control-label">Número
									de Pasajeros</label>
								<div class="col-lg-10">
									<select name="numero" class="form-control" id="select" required value="<%out.print(dtoRes.getNumeroPasajeros());%>"> 
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
									</select> <br>

								</div>
							</div>

							<div class="form-group">
								<label for="inputTauto" class="col-lg-2 control-label">Tipo
									de Auto</label>
								<div class="col-lg-10">
									<input type="number" name="tipo" class="form-control"
										id="inputTauto"  required value="<%out.print(dtoRes.getTipo());%>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputTauto" class="col-lg-2 control-label">Costo</label>
								<div class="col-lg-10">
									<input type="number"  step="any" name="costo" class="form-control"
										id="inputTauto"  required value="<%out.print(dtoRes.getCosto());%>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputTauto" class="col-lg-2 control-label">Foto</label>
								<div class="col-lg-10">
									<input type="file" name="foto" class="form-control"
										id="inputTauto" accept="image/*" placeholder="Tipo de Auto"
										>
								</div>
							</div>

							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-2">
									<button type="submit" class="btn btn-primary">Modificar</button>
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




