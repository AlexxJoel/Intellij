<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="templates/import-head.jsp" />
</head>
<body>

<div class="container mt-5">
    <div class="card">
        <form action="save-name" method="post">
            <input type="text" class="form-control my-2 "  placeholder="Ingrese nombre del producto"  name="name" value="${product.name}" required>
            <button type="submit" class="form-control btn btn-outline-primary my-2">Editar</button>
        </form>

    </div>
</div>






<jsp:include page="templates/import-script.jsp" />
</body>
</html>
