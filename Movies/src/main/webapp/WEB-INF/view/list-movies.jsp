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

    <h1 class="text-center">Lista de peliculas</h1>

    <div class="row justify-content-center mb-2">
        <div class="col-10">
            <div class="row justify-content-end">
                <div class="col-10">

                    <c:if test="${param['result-save']!=null}">
                        <c:if test="${param['result-save']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Película añadida con éxito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-save']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrió un error al Añadir la película
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${param['result-update']!=null}">
                        <c:if test="${param['result-update']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Película actualizada con éxito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-update']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrió un error al actualizar la película
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${param['result-delete']!=null}">
                        <c:if test="${param['result-delete']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Película eliminada con éxito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-delete']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrió un error al eliminar la película
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${param['result-updateImage']!=null}">
                        <c:if test="${param['result-updateImage']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Portada Cambiada Correctmente!
                            </div>
                        </c:if>

                        <c:if test="${param['result-updateImage']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrió un error al actualizar  la Imagen
                            </div>
                        </c:if>
                    </c:if>

                </div>

                <div class="col-2 text-end">
                    <a href="create-movies" class="btn btn-primary">Añadir una nueva película</a>
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
                    <th>Descripción</th>
                    <th>Fecha de publicación</th>
                    <th>Actor</th>
                    <th>Duración</th>
                    <th>Calificación</th>
                    <th>Portada</th>
                    <th>Acciones</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="movie">
                    <tr>
                        <td><c:out value="${movie.id}"/></td>
                        <td><c:out value="${movie.name}"/></td>
                        <td><c:out value="${movie.description}"/></td>
                        <td><c:out value="${movie.publish_date}"/></td>
                        <td><c:out value="${movie.actors}"/></td>
                        <td><c:out value="${movie.duration}"/></td>
                        <td><c:out value="${movie.ranking}"/></td>
                        <td><img src="data:banner/jpeg;base64, ${movie.imageToShow}" style="width: 80px;"> </td>

                        <td>

                            <div class="row justify-content-center">
                                <div class="col-12 mb-2">
                                    <a href="get-movie?id=${movie.id}" class="btn btn-info">
                                        <i class="fa-solid fa-magnifying-glass"></i>Actualizar
                                    </a>
                                </div>

                                <div class="col-12">
                                    <form action="delete-movie" method="post" class="d-inline">

                                        <input type="hidden" name="id" value="${movie.id}">

                                        <button type="submit" class="btn btn-danger">
                                            <i class="fa-solid fa-trash"></i> Eliminar
                                        </button>
                                    </form>
                                </div>

                                <div class="col-12 mt-2">
                                    <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#image${movie.id}">
                                       Gestionar imagen
                                    </button>
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

<!-- Modal -->
<c:forEach items="${list}" var="movie">

<div class="modal fade" id="image${movie.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Gestionar imagen</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-12">
                        <img src="data:banner/jpeg;base64, ${movie.imageToShow}" style="width: 100%;" class="shadow mb-3" >
                    </div>
                </div>
                <form action="updateImage" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${movie.id}">
                    <input type="file" class="form-control" name="image">

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Cambiar Imagen</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</c:forEach>

<jsp:include page="/templates/import-script.jsp" />

</body>
</html>
