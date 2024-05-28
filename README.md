

# API Endpoints CPIM-PERU

Esta API proporciona funcionalidades para la gestión de usuarios, incluyendo el registro de nuevos usuarios y la obtención de información de usuario existente.

## Requisitos

Antes de utilizar esta API, asegúrate de tener instalado lo siguiente en tu sistema:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)


## Instalación
- **Clona este repositorio en tu máquina local:**
```bash
git clone https://github.com/Elmer-Rosario-2027/CPIM-PERU.git
```

## Registro de Usuario

Registra un nuevo usuario en el sistema.

```bash
POST: http://localhost:8080/users/create
```
- **URL:** `/users/create`
- **Método:** `POST`
- **Cuerpo de la Petición:**

```json
{
    "name": "Elmer Rosario",
    "email": "elmer@dominio.cl",
    "password": "123456789",
    "phones": [
        {
            "number": "123456789",
            "citycode": "1",
            "contrycode": "51"
        }
    ]
}
```

- **Respuesta Exitosa (Código 201):**
```json
{
  "id": "e4c5d5b8-ecc2-4d48-853c-9856722d05b9",
  "name": "Elmer Soriano",
  "email": "elmerrosario@dominio.cl",
  "created": "2024-05-27T23:41:40.742+00:00",
  "modified": "2024-05-27T23:41:40.742+00:00",
  "lastLogin": "2024-05-27T23:41:40.742+00:00",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbG1lcnJvc2FyaW9AZG9taW5pby5jbCIsImV4cCI6MTcxNjg4OTMwMCwiaWF0IjoxNzE2ODUzMzAwfQ.zhtSJZxHqE1F3oSNbo9xAcVP_pwqvPnBvRwS6Q8Vm70",
  "active": true,
  "phones": [
    {
      "id": 1,
      "number": "99999999",
      "citycode": "1",
      "contrycode": "51"
    }
  ]
}
```


- **Respuesta de error (Código 400):**
```json
{
  "mensaje": "El correo ya está registrado"
}
```

## Obtener usuario

Obtiene un usuario registrado en el sistema.

```bash
GET: http://localhost:8080/users/get?email=elmerrosario@dominio.clo
```
- **URL:** `/users/get?email=elmerrosario@dominio.cl`
- **Método:** `GET`
- **Encabezado de Autorización:** `Bearer {token_de_acceso}`
- **Respuesta Exitosa (Código 200):**
```json
{
  "id": "b03d3d7d-1444-443c-a9c6-411b52242a8c",
  "name": "Elmer Rosario",
  "email": "elmerrosario@dominio.cl",
  "created": "2024-05-27T23:47:35.020+00:00",
  "modified": "2024-05-27T23:47:35.020+00:00",
  "lastLogin": "2024-05-27T23:47:35.020+00:00",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbG1lcnJvc2FyaW9AZG9taW5pby5jbCIsImV4cCI6MTcxNjg4OTY1NSwiaWF0IjoxNzE2ODUzNjU1fQ.Tb8JS35NR9zVrIjvRqrcG7N8pEphgAjgOAO6xywXytg",
  "phones": [
    {
      "id": 1,
      "number": "999999999",
      "citycode": "1",
      "contrycode": "51"
    }
  ],
  "active": true
}
```


- **Respuesta de error (Código 400):**
```json
{
  "mensaje": "Usuario con correo elmerrosarioXD@dominio.clo no encontrado"
}
```
# Tecnologías Utilizadas

Este proyecto utiliza las siguientes tecnologías:

## Spring Boot

Spring Boot es un marco de trabajo de Java que simplifica el desarrollo de aplicaciones Java, proporcionando configuraciones predeterminadas y convenciones sobre configuración para acelerar el proceso de desarrollo.

- **Sitio Web:** [Spring Boot](https://spring.io/projects/spring-boot)

## Spring Data JPA

Spring Data JPA es parte del ecosistema Spring y proporciona una abstracción sobre la capa de persistencia de datos, permitiendo el acceso a bases de datos relacionales utilizando objetos Java y consultas JPA.

- **Sitio Web:** [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

## Spring Security

Spring Security es un marco de seguridad que proporciona autenticación y autorización para aplicaciones Java. Se integra fácilmente con otras tecnologías de Spring y proporciona una capa de seguridad robusta para proteger las aplicaciones.

- **Sitio Web:** [Spring Security](https://spring.io/projects/spring-security)

## H2 Database

Base de datos en memoria utilizada para desarrollo y pruebas.

- **Sitio Web:** [H2 Database](https://www.h2database.com/html/main.html)

h2database readme

## Maven

Maven es una herramienta de gestión de proyectos que se utiliza para construir y gestionar proyectos Java. Proporciona un mecanismo para gestionar dependencias, compilar el código fuente, empaquetar y distribuir las aplicaciones.

- **Sitio Web:** [Maven](https://maven.apache.org/)

## Java

Java es un lenguaje de programación de propósito general y orientado a objetos ampliamente utilizado en el desarrollo de aplicaciones empresariales. Es conocido por su portabilidad, seguridad y robustez.

- **Sitio Web:** [Java](https://www.oracle.com/java/)

## Git

Git es un sistema de control de versiones distribuido ampliamente utilizado para el desarrollo de software colaborativo. Se utiliza para realizar un seguimiento de los cambios en el código fuente, colaborar con otros desarrolladores y gestionar versiones del software.

- **Sitio Web:** [Git](https://git-scm.com/)

Estas tecnologías se combinan para crear una aplicación web moderna y robusta. Para obtener más información sobre cómo se utilizan estas tecnologías en este proyecto específico, consulta la documentación y el código fuente.

¡Gracias por utilizar nuestra aplicación!
