 document.addEventListener("DOMContentLoaded", function () {

    let form = document.querySelector("#form-create-capacitacion")
    let rut = document.querySelector("#rut")
    let dia = document.querySelector("#dia")
    let hora = document.querySelector("#hora")
    let lugar = document.querySelector("#lugar")
    let duracion = document.querySelector("#duracion")
    let cantidadAsistentes = document.querySelector("#cantidadAsistentes")

    function validate() {
		
		let vrut = rut.value;
		if (vrut.length<1){
            document.querySelector("#rutHelp").innerHTML = "Rut es obligatorio.";
            return false;			
		}
		
		let diassemanas="-LUNES-MARTES-MIERCOLES-JUEVES-VIERNES-SABADO-DOMINGO-"
        let vdia = dia.value;
        if(diassemanas.search(vdia)===0){
            document.querySelector("#diaHelp").innerHTML = "Debe ser: "+diassemanas;
            return false;
        }
        
        let vhora = hora.value;
        if ((vhora.length!=5) || (vhora.search(':')<1)) {
            document.querySelector("#horaHelp").innerHTML = "El formato debe ser 00:00";
            return false;
        }
        
        let vlugar = lugar.value;
        if (vlugar.length < 10 || vlugar.length > 50) {
         document.querySelector("#lugarHelp").innerHTML = "El lugar debe tener un largo entre 10 y 50 caracteres";
            return false;
        }

        let vduracion = duracion.value;
        if(vduracion.length > 70){
            document.querySelector("#duracionHelp").innerHTML = "El largo no debe ser mayor a 70 caracteres";
            return false;
        }
        
        let vcantidadAsistentes = cantidadAsistentes.value;
        if((vcantidadAsistentes < 1) || (vcantidadAsistentes > 999)){
            document.querySelector("#cantidadAsistentesHelp").innerHTML = "Campo obligatorio, debe ser entre 1 y 999";
            return false;
        }
        
        return true;
    }
    
     form.addEventListener("submit", function (event) {
     if (!validate()) {
        event.preventDefault();
        } else {
        alert('La capacitación ha sido registrada');
        }
    })
});