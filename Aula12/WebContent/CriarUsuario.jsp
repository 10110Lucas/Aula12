<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="UTF-8">
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Explorer.biz - Criar Usuario</title>
	    
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<!-- Barra superior com os menus de navegação -->
		<c:import url="Menu.jsp"/>
	    <!-- Container Principal -->
	    <div id="main" class="container">
	        <h3 class="page-header">Bem Vindo!</h3>
	        <!-- Formulario para inclusao de paises -->
	        <form action="controller.do" method="post">
	            <!-- area de campos do form -->
	            <div class="row">
	                <div class="form-group col-md-6">
	                    <label for="Login">Login</label>
	                    <input type="email" class="form-control" name="Login" id="Login"
	                    required maxlength="20" placeholder=" exemplo@exp.com   maximo 20 caracteres">
	                </div>
	            </div>
	            <div class="row">
	                <div class="form-group col-md-6">
	                    <label for="Senha">Senha</label>
	                    <input type="password" class="form-control" name="Senha" id="Senha" 
	                    required maxlength="12" placeholder=" maximo 12 caractere">
	                </div>
	            </div>
	            <hr />
	            <div id="actions" class="row">
	                <div class="col-md-12">
	                    <button type="submit" class="btn btn-primary" name="command" value="CriarUsuario">Criar</button>
	                    <a href="Login.jsp" class="btn btn-default">Cancelar</a>
	                </div>
	            </div>
	        </form>
	    </div>
	    <script src="js/jquery.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	</body>
</html>







