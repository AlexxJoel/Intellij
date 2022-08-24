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
    <jsp:include page="/templates/import-head.jsp" />

</head>
<body>
<%--
<jsp:include page="/templates/menu.jsp" />
--%>
<div class="container mt-3">

    <h1 class="text-center">Lista de canciones</h1>

    <div class="row justify-content-center mb-2">
        <div class="col-10">
            <div class="row justify-content-end">
                <div class="col-10">

                    <c:if test="${param['result-save']!=null}">
                        <c:if test="${param['result-save']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Usuario registrada con exito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-save']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrio un error al crear el usuario
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${param['result-update']!=null}">
                        <c:if test="${param['result-update']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Usuario actualizada con exito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-update']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrio un error al actualizar el usuario
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${param['result-delete']!=null}">
                        <c:if test="${param['result-delete']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Usuario eliminada con exito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-delete']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrio un error al elimnar el usuario
                            </div>
                        </c:if>
                    </c:if>

                </div>

                <div class="col-2 text-end">
                    <a href="create-song" class="btn btn-primary">Registrar una nueva canción</a>
                </div>

            </div>
        </div>
    </div>


    <div class="row justify-content-center">
        <div class="col-10">
            <table class="table table-hover table-bordered table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Álbum</th>
                    <th>Genero</th>
                    <th>Duración</th>
                    <th>Artista</th>
                    <th>Año de lanzamiento</th>
                    <th>Acciones</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="song">
                    <tr>
                        <td><c:out value="${song.id}"/></td>
                        <td><c:out value="${song.name}"/></td>
                        <td><c:out value="${song.album}"/></td>
                        <td><c:out value="${song.genero}"/></td>
                        <td><c:out value="${song.duration}"/></td>
                        <td><c:out value="${song.artist}"/></td>
                        <td><c:out value="${song.year}"/></td>
                        <td>

                            <div class="row justify-content-center">
                                <div class="col-6">
                                    <a href="get-song?id=${song.id}" class="btn btn-info">
                                        <i class="fa-solid fa-magnifying-glass"></i> Cosultar
                                    </a>
                                </div>

                                <div class="col-6">
                                    <form action="delete-song" method="post" class="d-inline">

                                        <input type="hidden" name="id" value="${song.id}">

                                        <button type="submit" class="btn btn-danger">
                                            <i class="fa-solid fa-trash"></i> Eliminar
                                        </button>
                                    </form>
                                </div>

                            </div>


                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


</div>

<jsp:include page="/templates/import-script.jsp" />

</body>
</html>
