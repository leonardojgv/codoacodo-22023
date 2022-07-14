<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>

<table class="table align-middle">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Banda</th>
            <th scope="col">Capacidad</th>
            <th scope="col">Precio</th>
            <th scope="col">Dirección</th>
            <th scope="col">Observación</th>
            <th scope="col">Fecha</th>
            <th scope="col">Acción</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="show" items="${shows}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${show.band}</td>
                <td>${show.capacity}</td>
                <td><fmt:formatNumber value="${show.price}" type="currency"/></td>
                <td>${show.direction}</td>
                <td>${show.observation}</td>
                <td>
                    <fmt:formatDate value="${show.eventDate}" pattern="dd/MM/yyyy" />
                </td>
                <td class="d-flex">
                    <a href="?id=${show.id}" class="btn btn-warning mx-1">
                        <i class="bi bi-pencil-square"></i>
                    </a>
                    <form action="?accion=eliminar&id=${show.id}" method="POST">
                        <button type="submit" class="btn btn-danger mx-1"><i class="bi bi-trash3-fill"></i></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

