Examen Final Spring Boot - Microservicios

Este proyecto implementa un sistema distribuido de autenticación, gestión de productos y órdenes utilizando arquitectura de microservicios con Spring Boot. Cada módulo está desacoplado y comunica vía Eureka, Config Server y validación JWT.

Microservicios incluidos

- ms-auth: registro, login y validación de usuarios mediante JWT
- ms-productos: CRUD de productos protegido por roles
- ms-ordenes: creación y lectura de órdenes según rol del usuario

Tecnologías utilizadas
- Java 17
- Spring Boot 3.3.5
- Spring Security
- Spring Data JPA
- JWT (Json Web Token)
- Spring Cloud Config Client
- Spring Cloud Vault
- Eureka Discovery
- H2 Database (modo local)
- Maven
- Lombok
- JUnit 5 + Mockito (pruebas)
- Jacoco (cobertura)

La configuración dinámica se realiza desde config-server apuntando a un repo con los archivos .yml. Las credenciales y secretos (jwt.secret) se gestionan mediante Spring Cloud Vault.
Los tokens JWT se generan y validan vía ms-auth
Los endpoints de ms-productos y ms-ordenes son protegidos por roles:
ADMIN, SUPERADMIN → productos
USUARIO → creación de órdenes
ADMIN, SUPERADMIN → lectura de órdenes
