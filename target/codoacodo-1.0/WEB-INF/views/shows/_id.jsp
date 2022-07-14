<div class="container-fluid bg-light py-3">
    <div class="d-flex justify-content-between">
        <a href="${pageContext.request.contextPath}/shows" class="btn btn-light text-uppercase fw-bold">
            <i class="bi bi-arrow-left"></i> volver
        </a>

        <form action="?accion=eliminar&id=${show.id}" method="POST">
            <button type="submit" class="btn btn-danger"><i class="bi bi-trash3-fill"></i> Eliminar</button>
        </form>
    </div>
</div>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-8 py-3 text-center">
            <h3>EDITAR</h3>
        </div>
        <div class="col-lg-8">
            <form action="?accion=modificar&id=${show.id}" method="POST" class="was-validated">
                <%@include file="./components/formularioInputs.jsp" %>
                <div class="text-center border-top mt-3 py-3">
                    <button type="submit" class="btn btn-success"><i class="bi bi-save"></i> Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>