
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registrar-cancion</title>
  <jsp:include page="/templates/import-head.jsp" />

<body>


<%--
<jsp:include page="/templates/menu.jsp" />
--%>
<div class="container mt-3">

  <h1 class="text-center">Crear canción</h1>

  <div class="row justify-content-center">
    <div class="col-4">

      <form action="create-song" method="post">

        <div class="mb-3">
          <label  class="form-label">Nombre: </label>
          <input type="text" class="form-control" name="name">
        </div>

        <div class="mb-3">
          <label  class="form-label">Álbum: </label>
          <input type="text" class="form-control"  name="album">
        </div>

        <div class="mb-3">
          <label  class="form-label">Género: </label>
          <input type="text" class="form-control"  name="genero">
        </div>

        <div class="mb-3">
          <label  class="form-label">Duración: </label>
          <input type="number" class="form-control"  name="duration">
        </div>


        <div class="mb-3">
          <label  class="form-label">Artista: </label>
          <input type="text" class="form-control"  name="artist">
        </div>

        <div class="mb-3">
          <label  class="form-label">Año de lanzamiento: </label>
          <input type="date" class="form-control"  name="year" required>
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
