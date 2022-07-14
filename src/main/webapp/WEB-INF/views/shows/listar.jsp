<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid bg-light py-3 mb-3">
    <div class="row">
        <div class="col-12">
            <button type="button" class="btn btn-primary btn-sm text-uppercase" data-bs-toggle="modal" data-bs-target="#agregarShowModal">
                <i class="bi bi-plus-circle-dotted"></i> Nuevo show
            </button>
            <%@include file="./components/modal.jsp" %> 
        </div>
    </div>
</div>

<div class="container">
    <div class="row justify-content-center">
        <c:choose>
            <c:when test="${empty shows}">
                <div class="col-lg-10 mb-4">
                    <div class="alert alert-primary text-center" role="alert">
                        <h3>No hay espectáculos cargados</h3>
                    </div>
                </div>
            </c:when>    
            <c:otherwise>
                <div class="col-lg-10 mb-4">
                    <%@include file="./components/resumen.jsp" %> 
                </div>

                <div class="col-lg-10">
                    <%@include file="./components/table.jsp" %> 
                </div>
            </c:otherwise>
        </c:choose>    
    </div>
</div>