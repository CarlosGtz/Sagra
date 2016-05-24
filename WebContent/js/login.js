$(document).ready(function(){
  $("#form").hide();
  $("#btnLogin").click(function(){
    $("#texts").hide();
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

});