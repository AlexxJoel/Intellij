<%--
  Created by IntelliJ IDEA.
  User: joelh
  Date: 30/08/2022
  Time: 09:07 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="templates/import-head.jsp" />
</head>
<body>

<div class="container mt-5">
    <div class="container mt-5" >
        <div class="row">
            <div class="col-6">
                <form action="save-products" method="post">
                    <h3>PRODUCTO:</h3>
                    <select class="form-select" aria-label="Default select example" name="id_products">
                        <option selected>Seleccione un producto</option>
                        <c:forEach items="${list}" var="products">
                            <c:set var="priceString" scope="session" value="${products.price}"/>
                            <c:if test="${priceString == 0}">
                            <option value="${products.id_products}">${products.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    <h3 class="mt-2">MONTO:</h3>
                    <input class="form-control" type="number" min="1" step="0.10" name="price">
                    <button type="submit" class="btn btn-success mt-3" >Registrar</button>
                </form>
            </div>
            <div class="col-6">
                <h4>Total vendido: ${selling} </h4>
                <h4>Total cancelado: ${canceled} </h4>
                <h4>Total neto: ${neto}</h4>

            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table table-success table-striped table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Producto</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Cancelar</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="products">
                            <c:set var="statusString" scope="session" value="${products.status}"/>
                            <c:set var="priceString" scope="session" value="${products.price}"/>
                            <c:if test="${priceString != 0}">
                                <tr>
                                    <td><c:out value="${products.id_products}"/></td>
                                    <td><c:out value="${products.name}"/></td>
                                    <td><c:out value="${products.price}"/></td>
                                    <c:if test="${statusString == 1}">
                                        <td><c:out value="Activo"/></td>
                                    </c:if>
                                    <c:if test="${statusString == 0}">
                                        <td><c:out value="Cancelado"/></td>
                                    </c:if>
                                    <td>
                                        <c:set var="status" scope="session" value="${products.status}"/>

                                        <form action="update-status" method="post">
                                            <input type="hidden" name="id" value="${products.id_products}">

                                            <c:if test="${status == 1}">
                                                <button class="btn btn-danger" name="state" value="0">Cancelar</button>
                                            </c:if>

                                            <c:if test="${status == 0}">
                                                <button class="btn btn-dark" name="state" value="0" disabled>Cancelar</button>
                                            </c:if>

                                        </form>
                                    </td>
                                </tr>

                            </c:if>



                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
        <div class="d-flex">
            <div class="justify-content-center">
                <form action="reset" method="post">
                    <button class="btn  btn-outline-danger"> Eliminar todos los registros </button>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="templates/import-script.jsp" />
</body>
<script>


    <c:if test="${param['result-save']!=null}">
    <c:if test="${param['result-save']=='ok'}">
    Swal.fire({
        icon: 'success',
        title: 'Añadido',
        text :"Producto registrado de forma correcta",
        showConfirmButton: false,
        timer: 2000,
    })
    </c:if>

    <c:if test="${param['result-save']=='error'}">
    Swal.fire({
        icon: 'error',
        title: 'Fallo!',
        text:"Producto no registrado",
        showConfirmButton: false,
        timer: 2000,
    })
    </c:if>
    </c:if>

    <c:if test="${param['result-update']!=null}">
    <c:if test="${param['result-update']=='ok'}">
    Swal.fire({
        icon: 'success',
        title: 'Actualizado',
        text :"Producto cancelado",
        showConfirmButton: false,
        timer: 2000,
    })
    </c:if>

    <c:if test="${param['result-update']=='error'}">
    Swal.fire({
        icon: 'error',
        title: 'Fallo!',
        text:"El producto no pudo ser cancelado",
        showConfirmButton: false,
        timer: 2000,
    })
    </c:if>
    </c:if>

    <c:if test="${param['result-delete']!=null}">
    <c:if test="${param['result-delete']=='ok'}">
    Swal.fire({
        icon: 'success',
        title: 'Éxito',
        text :"Se han borrado los registros de forma correcta",
        showConfirmButton: false,
        timer: 2000,
    })
    </c:if>

    <c:if test="${param['result-delete']=='error'}">
    Swal.fire({
        icon: 'error',
        title: 'Fallo!',
        text:"No se pudo hacer cambios",
        showConfirmButton: false,
        timer: 2000,
    })
    </c:if>
    </c:if>



</script>


</html>
