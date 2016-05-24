$(document).ready(function(){
  $("#form").hide();
  $("#formAgencia").hide();
  $("#boton_usuarioI").hide();
  $("#boton_agenciaI").hide();
  $("#btnLogin").click(function(){
    $("#texts").hide();
    $("#boton_usuarioI").show();
    $("#boton_agenciaI").show();
    $("#form").show();
  });
  $("#home").click(function(){
    $("#texts").show();
    $("#form").hide();
	$("#formAgencia").hide();
  });
  
  $("#boton_agencia").click(function(){
    	$("#form").hide();
    	$("#formAgencia").show();	
	});
	$("#boton_usuario").click(function(){
    	$("#formAgencia").hide();
    	$("#form").show();	
	});
	
	 $("#boton_agenciaI").click(function(){
	    	$("#form").hide();
	    	$("#formAgencia").show();	
		});
		$("#boton_usuarioI").click(function(){
	    	$("#formAgencia").hide();
	    	$("#form").show();	
		});

});