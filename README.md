# BankApp

* Creacíon de una api para un Banco digital, la cual permitira la creación de cuentas, prestamos, transacciones y plazos fijos 
* Desarrollada como **REST API** documentada con **SWAGGER**.

### Instalación 🔧

* Clonar el repositorio
* Crear Schema con nombre "bancoapp"
* Cambiar username y password en application.properties

* Levantar el proyecto con el IDE
* En caso de fallo hacer un Maven Build para que baje las dependencias necesarias.
* logear en la base de datos.
* Acceder a la interfaz de Swagger: http://localhost:8080/swagger-ui.html#

## Autorización ⚙️

* El proyecto esta estructurado por Roles, existen dos disponibles **ROLE_ADMIN** y **ROLE_USER**.
* Al inicio del proyecto se crean automáticamente en la Base de Datos 2 usuarios, uno que tiene ambos roles y uno que tiene solo el ROLE_USER.
* Los datos del usuario con ambos roles son los siguientes: username: "admin", password: "q1w2e3r4"
* Cuando se produce una respuesta exitosa logeando se devuelve un Token JWT que debe ser usado en la parte superior de SWAGGER en el boton **Authorize**
* Antes de escribir el Token se debe escribir: "Bearer" un espacio y pegar el Token.
* Este proceso permite automaticamente mandar el token por el header y acceder a los endpoints.
* Tambien se puede crear un usuario nuevo y posteriormente realizar el **Login**.


### Pruebas de EndPoints 🔩

* Las pruebas se realizan desde la interfaz gráfica de **SWAGGER**
* Una vez autorizado se puede acceder a los endpoints de cada uno de los controladores.

## Despliegue 📦

* Deployment pendiente...

## Construido con 🛠️

* Backend: Java - Spring Boot
* Base de datos: MySQL

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Carolina Perez** - *Backend* - [carop2580](https://github.com/Juan-ci)
* **Johana Martinez** - *Backend* - [JohanaMM](https://github.com/JohanaMM)
* **Juan Caballero** - *Backend* - [Juan-ci](https://github.com/Juan-ci)
* **Victor Montivero** - *Backend* - [Vortorexi2017 ](https://github.com/Vortorexi2017)


## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invita una cerveza 🍺 o un café ☕ a alguien del equipo. 
* Da las gracias públicamente 🤓.

