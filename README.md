# Customer Service API

Este proyecto es un servicio REST desarrollado con Spring Boot para la gestión de clientes. Proporciona endpoints para crear, listar y obtener estadísticas de clientes.

## Requisitos Previos

- Java 17
- MySQL 8.0 o superior
- Gradle 7.x o superior
- Postman u otra herramienta para pruebas de API REST

## Configuración del Entorno

### 1. Base de Datos

1. Asegúrate de tener MySQL instalado y en ejecución en tu sistema
2. El proyecto está configurado para crear automáticamente la base de datos `periferia-customers`
3. Si deseas crear la base de datos manualmente, ejecuta:

```sql
CREATE DATABASE IF NOT EXISTS `periferia-customers`;

USE `periferia-customers`;

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    identity_document VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    date_of_birth DATE NOT NULL,
    time_zone VARCHAR(50) NOT NULL
);
```

### 2. Configuración de la Aplicación

1. Clona el repositorio
2. Verifica que el archivo `application.properties` contenga la siguiente configuración:

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/periferia-customers?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Dependencias Gradle

El proyecto utiliza Gradle como sistema de construcción. Las principales dependencias están definidas en el archivo `build.gradle`:

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    runtimeOnly 'com.mysql:mysql-connector-j'
}
```

## Ejecutar la Aplicación

1. Navega hasta el directorio raíz del proyecto
2. Ejecuta:

```bash
# En sistemas Unix/Linux/MacOS
./gradlew bootRun

# En Windows
gradlew.bat bootRun
```

Para construir el proyecto:

```bash
# En sistemas Unix/Linux/MacOS
./gradlew clean build

# En Windows
gradlew.bat clean build
```

La aplicación estará disponible en `http://localhost:8080`

## Endpoints Disponibles

### 1. Crear nuevo cliente
- **URL**: `/api/customers/new`
- **Método**: POST
- **Body**:

```json
{
    "fullName": "John Doe",
    "identityDocument": "1234567890",
    "email": "john.doe@example.com",
    "dateOfBirth": "1990-01-01",
    "timeZone": "America/New_York"
}
```
- **Respuesta exitosa**: Status 201 (CREATED)

### 2. Obtener todos los clientes ordenados por nombre
- **URL**: `/api/customers/all`
- **Método**: GET
- **Respuesta**: Lista de clientes ordenada por nombre

### 3. Obtener clientes ordenados por edad
- **URL**: `/api/customers/allByAge`
- **Método**: GET
- **Respuesta**: Lista de clientes ordenada por edad

### 4. Obtener promedio de edad de clientes
- **URL**: `/api/customers/ageAverageCustomers`
- **Método**: GET
- **Respuesta**: 

```json
{
    "customerCount": 10,
    "averageAge": 35.5
}
```

## Pruebas con Postman

1. Importa la siguiente colección de Postman:
   - [Customer Service Collection](URL_de_tu_colección)

2. Prueba los endpoints en el siguiente orden:
   - Crear un nuevo cliente (POST)
   - Verificar la lista de clientes (GET /all)
   - Obtener la lista ordenada por edad (GET /allByAge)
   - Consultar el promedio de edad (GET /ageAverageCustomers)

## Pruebas con cURL

### Crear nuevo cliente

```bash
curl -X POST http://localhost:8080/api/customers/new \
-H "Content-Type: application/json" \
-d '{
    "fullName": "John Doe",
    "identityDocument": "1234567890",
    "email": "john.doe@example.com",
    "dateOfBirth": "1990-01-01",
    "timeZone": "America/New_York"
}'
```

### Obtener todos los clientes

```bash
curl http://localhost:8080/api/customers/all
```

### Obtener clientes ordenados por edad

```bash
curl http://localhost:8080/api/customers/allByAge
```

### Obtener promedio de edad

```bash
curl http://localhost:8080/api/customers/ageAverageCustomers
```

## Solución de Problemas Comunes

1. **Error de conexión a la base de datos**
   - Verifica que MySQL esté en ejecución
   - Confirma las credenciales en application.properties
   - Asegúrate de que el puerto 3306 esté disponible

2. **Error al crear cliente**
   - Verifica que el email sea único
   - Asegúrate de que el documento de identidad sea único
   - Confirma el formato correcto de la fecha (YYYY-MM-DD)

3. **Problemas con Gradle**
   - Verifica que tienes Java 17 configurado correctamente
   - Ejecuta `./gradlew --version` para verificar la instalación
   - Limpia el cache de Gradle con `./gradlew clean`

## Contribuir

1. Fork el repositorio
2. Crea una rama para tu característica (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles.
