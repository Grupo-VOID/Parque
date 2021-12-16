<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="./assets/css/login.css">
    <title>Iniciar sesion en VOID</title>

    <link rel="shortcut icon" href="/Parque/assets/void1.ico" />
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
    		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
    		crossorigin="anonymous"></script>
</head>

<body>
<% String flash=(String) request.getAttribute("flash"); %>
    <header class="header">
        <p>VOID Experiencias Inmersivas</p>
    </header>
    <nav></nav>

    <section class="login">
        <h1 style="padding-bottom: 1cm">Bienvenido/a, acceso al sistema de atracciones</h1>
        <div class="login_box">
            <form action="login" method="post" class="login_form">

                <input type="text" class="input" name="username" placeholder="Usuario" required
                    aria-required="true">
                <input type="password" class="input" name="password" placeholder="Contraseña" required
                    aria-required="true">

                <div class="submit">
                    <button class="button">Acceder al sistema</button>
                    <c:if test="${flash != null }">
                        <div class="alert alert-danger">
                            <p>
                                <c:out value="${flash}" />
                            </p>
                        </div>
                    </c:if>
                    <a class="forgot_password" href="#">No recuerdo mi contraseña</a>
                </div>
                <div class="login_container">
                    <a href="index.jsp">Entrar como visitante</a>
                    <p class="new_user">¿No tienes una cuenta? <a href="mailto:nohaytal@webmaster.com">Contactate con el webmaster</a>
                    </p>
                </div>


            </form>
        </div>
    </section>
    <footer class="footer">
        <a href=""></a>
        <a href=""></a>
        <a href=""></a>
    </footer>
</body>
</html>