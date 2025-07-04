# Microservicio CRUD en Spring Boot con MariaDB

Este proyecto es un microservicio desarrollado en **Spring Boot** que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad **Producto**. La aplicación utiliza **MariaDB** como base de datos relacional y está diseñada para ser fácilmente desplegada mediante contenedores **Docker** y gestionada con **Docker Compose**. Además, incluye **pruebas unitarias**, **de integración**, **reporte de cobertura JaCoCo** y **documentación en Postman** para garantizar su correcto funcionamiento.

---

## Características

- CRUD completo sobre la entidad Producto.
- Base de datos relacional MariaDB.
- Contenerización con Docker.
- Orquestación de servicios con Docker Compose.
- Pruebas unitarias (JUnit + Mockito).
- Pruebas de integración con Testcontainers.
- Reporte de cobertura con JaCoCo.
- Documentación y pruebas con Postman.

---

## Requisitos previos

- Java 17
- Docker y Docker Compose instalados
- Maven Wrapper (`./mvnw`)
- WSL2 (en caso de uso en Windows)

---

## Uso

El microservicio expone una API REST para interactuar con la entidad. A continuación, se describen los endpoints principales:

- `POST /api/productos/crear`: Crear un nuevo producto.
- `GET /api/productos/listar`: Obtener todos los productos.
- `GET /api/productos/obtener/{codigo}`: Obtener un producto por su código.
- `PUT /api/productos/actualizar/{codigo}`: Actualizar un producto por su código.
- `DELETE /api/productos/eliminar/{codigo}`: Eliminar un producto por su código.

---

## Tecnologías utilizadas

- Spring Boot
- MariaDB
- Docker
- Docker Compose
- JUnit 5
- Mockito
- Testcontainers
- JaCoCo
- Postman

---

## Autor

Daniela Villalba Torres

‣⵰灳楲杮氭獩ੴ‣⵰灳楲杮氭獩ੴ