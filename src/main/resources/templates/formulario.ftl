<!DOCTYPE html>
<html>
<head>
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <script src="/js/bootstrap.js"></script>
    <link href="/css/main.css" rel="stylesheet"/>
    <title>${mode_title} estudiante</title>
</head>
<body>
<form class="edit-form" method=${method} action=${action}>
    <div class="form-group">
        <label for="exampleInputEmail1">Matricula</label>
        <input
                type="text"
                class="form-control"
                name="id"
                id="id"
                placeholder="Introduzca su matricula"
                value="${student.id?c}"
        />
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Nombre</label>
        <input
                type="text"
                class="form-control"
                id="firstName"
                name="firstName"
                placeholder="Introduzca su nombre"
                value="${student.firstName}"
        />
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Apellido</label>
        <input
                type="text"
                class="form-control"
                id="lastName"
                name="lastName"
                placeholder="Introduzca su apellido"
                value="${student.lastName}"
        />
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Telefono</label>
        <input
                type="tel"
                class="form-control"
                id="phoneNumber"
                name="phoneNumber"
                placeholder="Introduzca su telefono"
                value="${student.phoneNumber}"
        />
    </div>
    <button type="submit" class="btn btn-primary">${mode_title}</button>
</form>
</body>
</html>