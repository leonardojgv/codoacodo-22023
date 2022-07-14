<div class="modal fade" id="agregarShowModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="agregarShowModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">
                    <i class="bi bi-plus-circle-dotted me-3"></i> Nuevas entradas
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <%@include file="formularioInputs.jsp" %> 
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-success"><i class="bi bi-save"></i> Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
