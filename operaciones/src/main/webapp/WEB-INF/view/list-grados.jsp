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
  <title>lista de operaciones</title>
  <jsp:include page="/templates/import-head.jsp" />

</head>
<body>
<%--
<jsp:include page="/templates/menu.jsp" />
--%>
<div class="container mt-3">

  <h1 class="text-center">OPERACIONES GRADOS</h1>


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
          <th>OPERACIÓN</th>
          <th>DATOS</th>
          <th>RESULTADO</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="op">
          <tr>
            <td><c:out value="${op.id}"/></td>
            <td><c:out value="${op.operation}"/></td>
            <td><c:out value="${op.data}"/></td>
            <td><c:out value="${op.result}"/></td>
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
