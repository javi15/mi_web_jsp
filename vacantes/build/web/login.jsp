<%-- 
    Document   : login
    Created on : Jun 14, 2018, 10:01:06 AM
    Author     : javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	<title> JAVA JSP y Servlet </title>
</head>

	<body>
        <!-- Barra de nav -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
              <a class="navbar-brand" href="ofertas">Java JSP y Servelet</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item  flase">
        <a class="nav-link" href="ofertas">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="admin.jsp">administracion</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="frmvacante.jsp">Nuevo Anuncio</a>
      </li>
    </ul>
      <form method="post" action="buscar" class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" name="query" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
              
        </nav>
        
        <!-- Contenido -->
        <div class="container">
        <h1>Login</h1>
        <br>
        
        <form action="admin" method="post">
  <div class="form-group">
    <label for="exampleFormControlInput1">Nombre</label>
    <input type="text" name="user" class="form-control" id="exampleFormControlInput1" placeholder="UserName">
  </div>
            <div class="form-group">
    <label for="exampleFormControlInput1">Password</label>
    <input type="text" name="pass" class="form-control" id="exampleFormControlInput1" placeholder="pass">
  </div>
            <p class="text-danger">${messege}</p>
  
            <button class="btn btn-primary" type="submit">Login</button>
</form>
            <!-- footer -->
            <br>
    <footer>
     <p class="text-center" id="dates"></p>
        <script src="js/date.js"></script>
    </footer>
        </div>
        
        <!-- JavaScript de Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>
