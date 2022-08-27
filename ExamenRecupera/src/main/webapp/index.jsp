<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/WEB-INF/templates/head.jsp"/>
</head>
<style>
    .divider:after,
    .divider:before {
        content: "";
        flex: 1;
        height: 1px;
        background: #eee;
    }
    .h-custom {
        height: calc(100% - 73px);
    }
    @media (max-width: 450px) {
        .h-custom {
            height: 100%;
        }
    }
</style>
<body>
<jsp:include page="/WEB-INF/templates/navbar.jsp"/>

<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="AdminServlet" method="post">


                    <div class="form-outline mb-4">
                      <h3 class="display-3">Inicio de sesión</h3>
                    </div>

                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="text" id="form3Example3" class="form-control form-control-lg"
                               placeholder="Ingresa usuario"  name="user" required/>
                        <label class="form-label" for="form3Example3">Usuario</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" id="form3Example4" class="form-control form-control-lg"
                               placeholder="Ingresa contraseña" name="pass"  required/>
                        <label class="form-label" for="form3Example4" >Contraseña</label>
                    </div>


                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg" name="accion" value="access"
                            style="padding-left: 2.5rem; padding-right: 2.5rem;">Ingresar</button>

                    </div>

                </form>





            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/templates/footer.jsp"/>
<script>

    <c:if test="${param['result-access']!=null}">
        <c:if test="${param['result-access']=='ok'}">
            Swal.fire({
                icon: 'success',
                title: 'Bienvenido',
                text :"Datos correctos",
                showConfirmButton: false,
                timer: 1000,
            }).then(() => {
                window.location.href = "AdminServlet?accion=start"
            })
        </c:if>

        <c:if test="${param['result-access']=='error'}">
            Swal.fire({
                icon: 'error',
                title: 'Fallo!',
                text:"Datos incorrectos",
                showConfirmButton: false,
                timer: 1500,
            })
        </c:if>

        <c:if test="${param['result-access']=='end'}">
        Swal.fire({
            icon: 'success',
            title: 'Sesión cerrada',
            text :"Bye",
            showConfirmButton: false,
            timer: 1000,
        })
        </c:if>
    </c:if>








</script>

</body>

</html>