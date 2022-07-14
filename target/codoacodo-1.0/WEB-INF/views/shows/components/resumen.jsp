<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>

<div class="row justify-content-center">
    <div class="col-lg-6 mb-3 mb-lg-0">
        <div class="card bg-warning border-0">
            <div class="card-body text-center">
                <h6 class="card-title">Entradas en venta</h6>
                <h1 class="display-6 fw-bold">${totalShows}</h1>
            </div>
        </div>
    </div>
    <div class="col-lg-6 mb-3 mb-lg-0">
        <div class="card bg-info border-0">
            <div class="card-body text-center">
                <h6 class="card-title">Recaudación estimada</h6>
                <h1 class="display-6 fw-bold">
                    <fmt:formatNumber value="${maximumCollection}" type="currency"/>
                </h1>
            </div>
        </div>
    </div>
</div>
