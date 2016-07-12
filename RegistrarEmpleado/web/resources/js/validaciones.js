function validaciones() {
    var nombre = document.getElementById("txtNombre").value;
    if (nombre == '') {
        return alert('Campo obligatorio vacio!!');
    }

    alert('El Form es valido!!');
    return true;
}


