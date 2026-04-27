<div align="center">

# 🏫 Escuela Rural — Sistema de Gestión Académica

### Spring Boot · JPA · Hibernate · Thymeleaf · MySQL · Maven

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate_JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

</div>

---

## 📌 ¿Qué hace este proyecto?

Aplicación web MVC para la gestión académica de una escuela rural. Permite administrar alumnos, profesores, cursos y matrículas con persistencia en base de datos relacional usando **JPA/Hibernate** a través de Spring Boot. La interfaz web está construida con Thymeleaf renderizado en el servidor.

---

## 🏗️ Arquitectura MVC con JPA

```
[Thymeleaf Views]
       │
       ▼
[Spring Controllers]   ← Reciben requests HTTP
       │
       ▼
[Service Layer]        ← Lógica de negocio
       │
       ▼
[JPA Repositories]     ← Spring Data JPA
       │
       ▼
[Hibernate ORM]        ← Mapeo objeto-relacional
       │
       ▼
[MySQL Database]       ← Persistencia de datos
```

---

## ✨ Funcionalidades

- 👨‍🎓 Gestión de **alumnos**: registro, edición, baja y consulta
- 👩‍🏫 Gestión de **profesores**: asignación a cursos
- 📚 Gestión de **cursos**: creación y administración
- 📋 **Matrículas**: inscripción de alumnos en cursos
- 🔗 Relaciones JPA: `@OneToMany`, `@ManyToMany` entre entidades

---

## 🗂️ Estructura del proyecto

```
EscuelaRural_JPA/
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/escuela/
    │   │       ├── controller/    # Controladores Spring MVC
    │   │       ├── model/         # Entidades JPA (@Entity)
    │   │       ├── repository/    # Interfaces Spring Data JPA
    │   │       └── service/       # Lógica de negocio
    │   └── resources/
    │       ├── templates/         # Vistas Thymeleaf
    │       └── application.properties
    └── test/
```

---

## 🗄️ Modelo de datos

```
Alumno (N) ──── (N) Matricula ──── (N) Curso (N) ──── (1) Profesor
  - nombre              - alumno_id       - nombre          - nombre
  - rut                 - curso_id        - nivel           - especialidad
  - nivel               - fecha           - anio
```

---

## ⚙️ Requisitos

- Java 17+
- Maven 3.8+
- MySQL 8+

---

## 🚀 Instalación y ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/LujoMontero/EscuelaRural_JPA.git
cd EscuelaRural_JPA

# 2. Crear la base de datos
mysql -u root -p
CREATE DATABASE escuela_rural;
EXIT;

# 3. Configurar application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/escuela_rural
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# 4. Ejecutar la aplicación
mvn spring-boot:run

# 5. Abrir en el navegador
open http://localhost:8080
```

---

## 💡 Conceptos JPA aplicados

| Concepto | Uso en el proyecto |
|---|---|
| `@Entity` | Mapeo de clases Java a tablas MySQL |
| `@OneToMany` | Relación Profesor → Cursos |
| `@ManyToMany` | Relación Alumnos ↔ Cursos (matrícula) |
| `@JoinColumn` | Definición de foreign keys |
| `JpaRepository` | CRUD automático sin SQL manual |
| `@Transactional` | Integridad en operaciones de escritura |

---

## 👨‍💻 Autor

**Luis Montero** · [GitHub](https://github.com/LujoMontero) · [LinkedIn](https://www.linkedin.com/in/luis-montero-if/)
