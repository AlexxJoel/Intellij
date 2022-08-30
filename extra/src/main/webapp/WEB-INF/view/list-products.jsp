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
                    <div class="row">
                        <div class="col-8">
                            <select class="form-select" aria-label="Default select example" name="id_products">
                                <option selected>Seleccione un producto</option>
                                <c:forEach items="${list}" var="products">
                                    <c:set var="priceString" scope="session" value="${products.price}"/>
                                    <c:if test="${priceString == 0}">
                                        <option value="${products.id_products}">${products.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-2">

                                <button type="button" class="btn btn-outline-primary form-control p-1" data-bs-toggle="modal" data-bs-target="#exampleModal">+</button>

                        </div>

                        <div class="col-2">
                            <button type="button" class="form-control btn btn-outline-warning p-1  " data-bs-toggle="modal" data-bs-target="#exampleModal1">Gestionar</button>

                        </div>
                    </div>
                    <h3 class="mt-2">MONTO:</h3>
                    <input class="form-control" type="number" min="1" step="0.10" name="price">
                    <button type="submit" class="btn btn-success mt-3"  >Registrar</button>
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
                    <c:set var="i" value="1"/>
                        <c:forEach items="${list}" var="products">
                            <c:set var="statusString" scope="session" value="${products.status}"/>
                            <c:set var="priceString" scope="session" value="${products.price}"/>
                            <c:if test="${priceString != 0}">
                                <tr>
                                    <td><c:out value="${i}"/></td>
                                    <c:set var="i" value="${i+1}"/>
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

<!-- Modal to add products -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registro producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
               <form action="save-name" method="post">
                   <input type="text" class="form-control my-2  "  placeholder="Ingrese nombre del producto"  name="name" required>
                   <button type="submit" class="form-control btn btn-outline-primary my-2">Guardar</button>
                   <button type="button" class="form-control btn btn-outline-dark" data-bs-dismiss="modal">Cerrar</button>
               </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>


<!-- Modal to see products and delete -->
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Lista de producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
            <c:forEach items="${list}" var="products">
               <div class="row  ">
                   <div class="col-6 text-center border-bottom border-dark mb-1">${products.name}</div>
                   <div class="col-3 mb-1">
                        <a class="form-control btn btn-outline-info" href="see-product?id=${products.id_products}">Editar</a>
                   </div>
                   <div class="col-3 mb-1">
                       <form action="delete-product" method="post">
                           <input type="hidden" value="${products.id_products}" name="id">
                           <button class="form-control btn btn-outline-danger">Eliminar</button>
                       </form>
                   </div>

               </div>
            </c:forEach>
            </div>
            <div class="modal-footer">
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


    //--------------------management products-------------------
    <c:if test="${param['result-deleteProduct']!=null}">
    <c:if test="${param['result-deleteProduct']=='ok'}">
    Swal.fire({
        icon: 'success',
        title: 'Éxito',
        text :"Se han borrado  el producto",
        showConfirmButton: false,
        timer: 2000,
    })
    </c:if>

    <c:if test="${param['result-deleteProduct']=='error'}">
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
