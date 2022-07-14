<div class="form-group mb-2">
    <label for="band">Artista / Banda</label>
    <input type="text" value="${show.band}" class="form-control" name="band" placeholder="ingrese un nombre" required>
</div>
<div class="form-group mb-2">
    <label for="sector">Capacidad</label>
    <input type="number" value="${show.capacity}" class="form-control" name="capacity" placeholder="Capacidad" required>
</div>
<div class="form-group mb-2">
    <label for="price">Precio</label>
    <input type="number" step="0.01" value="${show.price}" class="form-control" name="price" placeholder="Precio de venta" required>
</div>
<div class="form-group mb-2">
    <label for="direction">Dirección</label>
    <input type="text" value="${show.direction}" class="form-control" name="direction" placeholder="Direccion del evento" required>
</div>
<div class="form-group mb-2">
    <label for="observation">Observación</label>
    <input type="textarea" value="${show.observation}" class="form-control" name="observation" placeholder="Observacion de venta">
</div>
<div class="form-group mb-2">
    <label for="event_date">Fecha del evento</label>
    <input type="date" value="${show.eventDate}" class="form-control" name="event_date" placeholder="Fecha del evento" required>
</div>
