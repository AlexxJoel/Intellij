<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Actualizar persona</title>
    <jsp:include page="/templates/import-head.jsp" />

</head>
<body>

<%--
<jsp:include page="/templates/menu.jsp" />
--%>




<div class="container mt-3">

    <h1 class="text-center">Modificar canción</h1>

    <div class="row justify-content-center">
        <div class="col-4">

            <form action="update-movie" method="post" enctype="multipart/form-data">

                <input type="hidden" class="form-control" name="id" value="${movieX.id}">

                <div class="mb-3">
                    <label  class="form-label">Nombre: </label>
                    <input type="text" class="form-control" name="name" value="${movieX.name}">
                </div>

                <div class="mb-3">
                    <label  class="form-label">Descripción: </label>
                    <input type="text" class="form-control"  name="description" value="${movieX.description}">
                </div>

                <div class="mb-3">
                    <label  class="form-label">Fecha de publicación: </label>
                    <input type="date" class="form-control"  name="publish_date" value="${movieX.publish_date}" >
                </div>

                <div class="mb-3">
                    <label  class="form-label">Actor: </label>
                    <input type="text" class="form-control"  name="actors" value="${movieX.actors}">
                </div>

                <div class="mb-3">
                    <label  class="form-label">Duración: </label>
                    <input type="number" class="form-control"  name="duration" value="${movieX.duration}">
                </div>

                <div class="mb-3">
                    <label  class="form-label">Calificación: </label>
                    <input type="text" class="form-control"  name="ranking" value="${movieX.ranking}">
                </div>


                <button type="submit" class="btn btn-primary">Registrar</button>
                <button type="reset" class="btn btn-danger">Cancelar</button>

            </form>


        </div>
    </div>
</div>
<jsp:include page="/templates/import-script.jsp" />
</body>
</html>
