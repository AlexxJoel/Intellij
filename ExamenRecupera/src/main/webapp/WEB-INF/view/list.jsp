<%--
  Created by IntelliJ IDEA.
  User: CA2-PC-
  Date: 28/06/2022
  Time: 12:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    //String user=(String)(session.getAttribute("id_user"));
    //String pass=(String)(session.getAttribute("name"));
    //if(user != null && pass !=null){
%>

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

    <h1 class="text-center">Lista de Alumnos</h1>

    <div class="row justify-content-center mb-2">
        <div class="col-10">
            <div class="row justify-content-end">
                <div CLASS="col-2">
                    <a href="AdminServlet?accion=end&result-access=end" class="btn btn-outline-dark">Cerrar sesión</a>
                </div>
                <div class="col-8">
                </div>
                <div class="col-2 text-end">
                    <a href="StudentServlet?accion=createStudent" class="btn btn-primary">Registrar alumno</a>
                </div>

            </div>
        </div>
    </div>


    <div class="row justify-content-center">
        <div class="col-10  border-top border-success">
            <c:forEach items="${list}" var="student">
                <div class="row">
                    <div class="col-3  border-bottom border-success py-1">
                        <h4 class="text-center">Nombre</h4>
                        <p class="text-center"><c:out value="${student.name}"/></p>
                    </div>

                    <div class="col-3  border-bottom border-success py-1">
                        <h4  class="text-center">Calificaciones</h4>
                       <div class="d-flex justify-content-around">
                           <span class="text-center"><c:out value="${student.qual1}"/></span>
                           <span class="text-center"><c:out value="${student.qual2}"/></span>
                           <span class="text-center"><c:out value="${student.qual3}"/></span>
                           <span class="text-center"><c:out value="${student.qual4}"/></span>
                           <span class="text-center"><c:out value="${student.qual5}"/></span>
                       </div>

                    </div>

                    <div class="col-3  border-bottom border-success py-1">
                        <h4  class="text-center">Promedio</h4>
                        <p class="text-center"> <c:out value="${student.average}"/></p>
                    </div>

                    <div class="col-3  border-bottom border-success py-1">

                        <h4  class="text-center">Acciones</h4>

                        <div class="d-flex justify-content-around">
                            <a href="StudentServlet?accion=getStudent&id=${student.id_students}" class="btn btn-info">
                                <i class="fa-solid fa-magnifying-glass"></i>Actualizar
                            </a>


                            <c:set var="status" scope="session" value="${student.status}"/>

                            <form action="StudentServlet?accion=status" method="post">
                                <input type="hidden" name="id" value="${student.id_students}">

                                <c:if test="${status == 1}">
                                <button class="btn btn-outline-danger" name="state" value="0">Desactivar</button>
                                </c:if>

                                <c:if test="${status == 0}">
                                    <button class="btn btn-outline-primary" name="state" value="1">Activar</button>
                                </c:if>

                            </form>



                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<script>


    <c:if test="${param['result-save']!=null}">
    <c:if test="${param['result-save']=='ok'}">
    Swal.fire({
        icon: 'success',
        title: 'Añadido',
        text :"Se registro de manera correcta",
        showConfirmButton: false,
        timer: 1000,
    })
    </c:if>

    <c:if test="${param['result-save']=='error'}">
    Swal.fire({
        icon: 'error',
        title: 'Fallo!',
        text:"No registrado",
        showConfirmButton: false,
        timer: 1500,
    })
    </c:if>
    </c:if>

    <c:if test="${param['result-update']!=null}">
    <c:if test="${param['result-update']=='ok'}">
    Swal.fire({
        icon: 'success',
        title: 'Actualizado',
        text :"Se Actualizo de manera correcta",
        showConfirmButton: false,
        timer: 1000,
    })
    </c:if>

    <c:if test="${param['result-update']=='error'}">
    Swal.fire({
        icon: 'error',
        title: 'Fallo!',
        text:"No actualizo",
        showConfirmButton: false,
        timer: 1500,
    })
    </c:if>
    </c:if>

    <c:if test="${param['result-delete']!=null}">
    <c:if test="${param['result-delete']=='ok'}">
    Swal.fire({
        icon: 'success',
        title: 'Estado cambiado',
        text :"Se cambio el estado de manera correcta",
        showConfirmButton: false,
        timer: 1000,
    })
    </c:if>

    <c:if test="${param['result-delete']=='error'}">
    Swal.fire({
        icon: 'error',
        title: 'Fallo!',
        text:"No se pudo desactivar",
        showConfirmButton: false,
        timer: 1500,
    })
    </c:if>
    </c:if>



</script>


<jsp:include page="/WEB-INF/templates/footer.jsp"/>


</body>
</html>
<%// }else{
    //System.out.println("No hay sesión iniciada!");
    //request.getRequestDispatcher("/index.jsp").forward(request,response);

//}
%>
