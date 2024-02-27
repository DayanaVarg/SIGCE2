# SIGCE con Spring Boot
## Descripción General
Este proyecto consiste es un sistema de información construido con Spring Boot. Tiene como finalidad gestionar las citaciones a comité de evaluacióon y seguimiento. Proporciona procesos para la gestión tanto de estudiantes, instructores, y administrativos, 
así mismo el manejo de autentificación de usuario, y toda la gestión de citaciones a comité y gestión de comités.

## Inicio Rápido
Para ejecutar el proyecto localmente, sigue estos pasos
### 1. Clona el repositorio:
```
git clone https://github.com/DayanaVarg/SIGCE2.git
```
### 2. Abre el proyecto en tu IDE preferido.
### 3. Configura la conexión a la base de datos en el archivo application.properties.
### 4 . Construye y ejecuta la aplicación Spring Boot.

# Procesos de SIGCE
## Operaciones de Funcionario
### 1. Obtener datos de usuario logeado
- Ruta: **GET funcionario/actualizarUsu**
- Descripción: Obtiene la información del usuario (funcionario) logeado.
### 2. Actualizar datos
- Ruta: **POST funcionario/actualizarUs**
- Descripción: Actualiza la información del funcionario logeado.
- Parámetros de la solicitud:
  - Nombre_Fun (String): Nombre del funcionario.
  * Apellido_Fun (String): Apelido del funcionario.
  * Correo_Fun (String): Correo del funcionario.
  * Password_Fun (String): Contraseña del funcionario

## Operaciones de Aprendiz
### 1. Añadir aprendiz
- Ruta: **POST funcionario/registrarAprendices** ó **POST aprendiz/registrarAprendices** ó **POST instructor/registrarAprendices**
- Descripción: Permite el registro de un nuevo aprendiz.
- Parámetros de la solicitud:
  - identificacion_Apr (String): Identificación del aprendiz.
  - tipoIde_Apr (String): Tipo de identificación del aprendiz.
  - nombre_Apr (String): Nombre del funcionario.
  * apellido_Apr (String): Apelido del funcionario.
  * correo_Apr (String): Correo del funcionario.
  * password_Apr (String): Contraseña del funcionario.
  * Fk_id_Ficha (Ficha): Número de ficha a la que pertenece.
### 2. Listar Aprendices
- Ruta: **GET funcionario/listarAprendices**
- Descripción: Obtiene por medio de una lista la información de todos los aprendices que estén activos.
### 3. Listar Aprendices Inactivos
- Ruta: **GET funcionario/aprendicesInac**
- Descripción: Obtiene por medio de una lista la información de todos los aprendices que estén inactivos.

### 4. Obtener datos de aprendiz en especifico
- Ruta: **GET funcionario/actualizarApr**
- Descripción: Obtiene la información del aprendiz a consultar.
- Parámetros de la solicitud:
  - identificacion_Apr (String): Identificación del aprendiz.

### 5. Actualizar aprendiz
- Ruta: **POST funcionario/actualizarA**
- Descripción: Actualiza la información del aprendiz consultado.
- Parámetros de la solicitud:
  - tipoIde_Apr (String): Tipo de identificación del aprendiz.
  - correo_Apr (String): Correo del funcionario.
  * Fk_id_Ficha (Ficha): Número de ficha a la que pertenece.

