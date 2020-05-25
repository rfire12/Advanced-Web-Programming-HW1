<!DOCTYPE html>
<html>
  <head>
    <link href="/css/bootstrap.css" rel="stylesheet" />
    <script src="/js/bootstrap.js"></script>
    <link href="/css/main.css" rel="stylesheet" />
    <title>${mode_title} estudiante</title>
  </head>
  <body>
    <form class="edit-form" method=${method} action="/students">
      <div class="form-group">
        <label for="exampleInputEmail1">Matricula</label>
        <input
          type="text"
          class="form-control"
          name="matricula"
          id="matricula"
          placeholder="Introduzca su matricula"
          value="${student.id}"
          ${id_enabled}
        />
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Nombre</label>
        <input
          type="text"
          class="form-control"
          id="nombre"
          name="nombre"
          placeholder="Introduzca su nombre"
          value="${student.firstName}"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Apellido</label>
        <input
          type="text"
          class="form-control"
          id="apellido"
          name="apellido"
          placeholder="Introduzca su apellido"
          value="${student.lastName}"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Telefono</label>
        <input
          type="tel"
          class="form-control"
          id="telefono"
          name="telefono"
          placeholder="Introduzca su telefono"
          value="${student.phoneNumber}"
        />
      </div>
      <button type="submit" class="btn btn-primary">${mode_title}</button>
    </form>
  </body>
</html>