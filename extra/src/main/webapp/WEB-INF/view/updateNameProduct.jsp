<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="templates/import-head.jsp" />
</head>
<body>




<!-- Modal to edit a  product -->
<div class="modal fade show" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Editar producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="save-name" method="post">
                    <input type="text" class="form-control my-2 "  placeholder="Ingrese nombre del producto"  name="name" value="${product.name}" required>
                    <button type="submit" class="form-control btn btn-outline-primary my-2">Editar</button>
                    <button type="button" class="form-control btn btn-outline-dark" data-bs-dismiss="modal">Cerrar</button>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<jsp:include page="templates/import-script.jsp" />
</body>
</html>
