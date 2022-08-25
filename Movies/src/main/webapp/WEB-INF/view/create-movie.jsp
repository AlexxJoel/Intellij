
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Añadir pelicula</title>
  <jsp:include page="/templates/import-head.jsp" />

<body>


<%--
<jsp:include page="/templates/menu.jsp" />
--%>
<div class="container mt-3">

  <h1 class="text-center">Añadir película</h1>

  <div class="row justify-content-center">
    <div class="col-4">

      <form action="save-movie" method="post" enctype="multipart/form-data">

        <div class="mb-3">
          <label  class="form-label">Nombre: </label>
          <input type="text" class="form-control" name="name">
        </div>

        <div class="mb-3">
          <label  class="form-label">Descripción: </label>
          <input type="text" class="form-control"  name="description">
        </div>

        <div class="mb-3">
          <label  class="form-label">Fecha de publicación: </label>
          <input type="date" class="form-control"  name="publish_date">
        </div>

        <div class="mb-3">
          <label  class="form-label">Actor: </label>
          <input type="text" class="form-control"  name="actors">
        </div>

        <div class="mb-3">
          <label  class="form-label">Duración: </label>
          <input type="number" class="form-control"  name="duration">
        </div>

        <div class="mb-3">
          <label  class="form-label">Calificación: </label>
          <input type="text" class="form-control"  name="ranking">
        </div>

        <div class="mb-3">
          <label  class="form-label">Ingrese portada: </label>
          <input type="file" class="form-control"  name="image">
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
