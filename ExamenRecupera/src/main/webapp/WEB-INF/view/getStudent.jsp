<%--
  Created by IntelliJ IDEA.
  User: CA2-PC-
  Date: 28/06/2022
  Time: 12:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List person</title>
    <jsp:include page="/WEB-INF/templates/head.jsp"/>


</head>
<body>
<jsp:include page="/WEB-INF/templates/navbar.jsp"/>

<div class="container mt-3">

    <h1 class="text-center">Registrar de Alumnos</h1>

    <div class="container">
        <div class="card">
            <form action="StudentServlet?accion=update" method="post">

                <input type="hidden" class="form-control" name="id" value="${obj.id_students}">


                <div class="card-body p-3  px-5">
                    <div class="row">
                        <div class="col-12">
                            <label>Nombre del alumno </label>
                            <input type="text" name="name" class="form-control" value="${obj.name}">
                        </div>
                    </div>

                    <div class="row my-3">
                        <div class="col-12">
                            <h3 class="text-center">Ingrese las calificaciones</h3>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-4">
                            <label>Calf 1:</label>
                            <input type="number" min="0" max="10" name="cal1" class="form-control" value="${obj.qual1}">
                        </div>
                        <div class="col-4">
                            <label>Calf 2:</label>
                            <input type="number" min="0" max="10" name="cal2" class="form-control" value="${obj.qual2}">
                        </div>
                        <div class="col-4">
                            <label>Calf 3:</label>
                            <input type="number" min="0" max="10" name="cal3" class="form-control" value="${obj.qual3}">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-4">
                            <label>Calf 4:</label>
                            <input type="number" min="0" max="10" name="cal4" class="form-control" value="${obj.qual4}">
                        </div>
                        <div class="col-4">
                            <label>Calf 5:</label>
                            <input type="number" min="0" max="10" name="cal5" class="form-control" value="${obj.qual5}">
                        </div>
                    </div>

                    <div class="row mt-4">
                        <div class="col-5 d-flex justify-content-start">
                            <button type="reset" class="btn btn-danger " name="accion" value="add">Cancelar</button>
                        </div>
                        <div class="col-5 d-flex justify-content-end">
                            <button type="submit" class="btn btn-primary ">Actualizar</button>
                        </div>
                    </div>



                </div>
            </form>
        </div>
    </div>




</div>



<jsp:include page="/WEB-INF/templates/footer.jsp"/>

</body>
</html>
