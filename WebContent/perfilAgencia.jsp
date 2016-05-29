<%@page import="modelo.dto.UsuarioAgenciaDTO"%>
<%@page import="modelo.SagraDelegate"%>
<%@page import="modelo.dao.AutoDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.dto.AgenciaDTO"%>
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
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<li><a href="registro_Auto.jsp">Agregar Autos</a></li>
				<li class="paginaActiva"><a href="#">Perfil de la Agencia</a></li>
				<li><a href="ServletLogout">Salir</a></li>
			</ul>

		</div>
	</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Datos Perfil</h1>

				<form id="centro_registro" class="form-horizontal " role="form"
					action="Updater" method="post">
					<%
						SagraDelegate del = new SagraDelegate();
						AgenciaDTO dto = new AgenciaDTO();
						UsuarioAgenciaDTO dtoU = new UsuarioAgenciaDTO();
						dtoU.setUsuario(usuario);
						dto.setRFC(RFC);
						AgenciaDTO dtoRes;
						UsuarioAgenciaDTO dtoURes;

						dtoRes = del.leerAgecia(dto);
						dtoURes = del.leerUsuarioAgencia(dtoU);
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Nombre Agencia:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"nombreEmp\" class=\"form-control\" id=\"nombre\" value=\""
										+ dtoRes.getNombre() + "\">" + " </div></div>");
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Razon Sosial:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"raz_soc\" class=\"form-control\"  value=\""
										+ dtoRes.getRazonSocial() + "\">" + " </div></div>");
						
						out.print("<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Cuenta:</label>"
								+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"nocuenta\" class=\"form-control\"  value=\""
								+ dtoRes.getCuenta() + "\">" + " </div></div>");
						out.print("<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Clabe:</label>"
								+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"clabe\" class=\"form-control\"  value=\""
								+ dtoRes.getClabe() + "\">" + " </div></div>");
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Direccion:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"direccion\" class=\"form-control\"  value=\""
										+ dtoRes.getContacto_direccion() + "\">" + " </div></div>");
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Telefono:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"telefono\" class=\"form-control\"  value=\""
										+ dtoRes.getContacto_telefono() + "\">" + " </div></div>");
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Sitio web:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"website\" class=\"form-control\"  value=\""
										+ dtoRes.getContacto_sitioweb() + "\">" + " </div></div>");
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Usuario:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"usuarioEmp\" class=\"form-control\"  value=\""
										+ dtoURes.getUsuario() + "\">" + " </div></div>");
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Password:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"password\" name = \"pass\" class=\"form-control\"  value=\""
										+ dtoURes.getPass() + "\">" + " </div></div>");
						out.print("<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Nombre:</label>"
								+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"usuarioNom\" class=\"form-control\"  value=\""
								+ dtoURes.getNombre() + "\">" + " </div></div>");
						out.print(
								"<div class=\"form-group\"><label class=\"control-label col-sm-2\" for=\"nombre\">Apellidos:</label>"
										+ "<div class=\"col-sm-10\"><input type=\"text\" name = \"apellidos\" class=\"form-control\"  value=\""
										+ dtoURes.getApellidos() + "\">" + " </div></div>");
						
					%>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Modificar</button>
						</div>
					</div>
				</form>



			</div>
		</div>
	</div>


</body>
</html>
