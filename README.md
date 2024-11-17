# Uber Ride Sharing

Este es un proyecto de ejemplo para una aplicación de viajes compartidos (ride-sharing) similar a Uber, que consta de un **backend** desarrollado en Java con **Spring Boot** y un **frontend** desarrollado en **HTML, CSS, y JavaScript**. El backend está diseñado para ser desplegado en **AWS**, y la comunicación se realiza mediante **AWS API Gateway**.

## Índice
- [Introducción](#introducción)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Decisiones Arquitecturales](#decisiones-arquitecturales)
- [Cómo Ejecutar el Proyecto](#cómo-ejecutar-el-proyecto)
- [Despliegue en AWS](#despliegue-en-aws)
  - [Configuración de AWS API Gateway](#configuración-de-aws-api-gateway)
  - [Configuración de AWS EC2](#configuración-de-aws-ec2)
- [Ejecución Local](#ejecución-local)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Introducción

Este proyecto está diseñado para demostrar cómo se puede construir una aplicación moderna de viajes compartidos, incluyendo tanto un backend basado en microservicios como un frontend ligero y fácil de implementar. El backend maneja la lógica de negocio, mientras que el frontend proporciona una interfaz simple para que los usuarios soliciten y vean viajes.

## Estructura del Proyecto

```
uber/
|
├── backend/                  # Carpeta para el backend en Spring Boot
│   ├── src/                  # Código fuente del backend
│   ├── pom.xml               # Archivo de configuración Maven del backend
│   └── ...                   # Otros archivos del backend
|
└── frontend/                 # Carpeta para el frontend
    ├── index.html            # Página principal de la aplicación
    ├── styles.css            # Archivo CSS para los estilos
    ├── script.js             # Archivo JavaScript para la lógica del cliente
    └── ...                   # Otros archivos del frontend
```

## Tecnologías Utilizadas
- **Backend**: Java, Spring Boot, Maven
- **Frontend**: HTML, CSS, JavaScript
- **Base de Datos**: H2 (para desarrollo y pruebas)
- **Cloud**: AWS (EC2, API Gateway)

## Decisiones Arquitecturales

1. **Arquitectura Separada de Backend y Frontend**:
   - El proyecto está estructurado para tener una clara separación entre el backend y el frontend. Esto permite un despliegue independiente, lo cual facilita la escalabilidad y la integración con servicios en la nube.

2. **Uso de API Gateway**:
   - **AWS API Gateway** se utiliza para exponer el backend al mundo exterior. Esto agrega una capa de seguridad, escalabilidad y control sobre cómo se manejan las solicitudes externas.

3. **Despliegue en AWS EC2**:
   - El backend está desplegado en una instancia de **AWS EC2**, lo cual permite un control total sobre el entorno, haciéndolo flexible y adecuado para pruebas de alto tráfico.

4. **Consumo del API en el Frontend**:
   - El **frontend** está diseñado para ser muy ligero y se comunica con el backend a través de **fetch()** para interactuar con los endpoints REST expuestos por API Gateway.

## Cómo Ejecutar el Proyecto

### Prerrequisitos

- **Java 17**
- **Maven**
- **Node.js** (para ejecutar un servidor de desarrollo estático para el frontend)
- **AWS CLI** (para desplegar recursos en AWS)

### Ejecución Local del Backend

1. **Navegar al directorio `backend`**:
   ```sh
   cd backend
   ```

2. **Compilar y ejecutar la aplicación**:
   ```sh
   mvn spring-boot:run
   ```
   El backend estará disponible en `http://localhost:8080`.

### Ejecución Local del Frontend

1. **Navegar al directorio `frontend`**:
   ```sh
   cd frontend
   ```

2. **Ejecutar un servidor estático** (usando `http-server`):
   ```sh
   npx http-server
   ```
   El frontend estará disponible en `http://localhost:8081` (puede variar el puerto).

### Configuración del API Gateway y EC2 en AWS

#### Configuración de AWS API Gateway

1. **Crear una API REST** en AWS API Gateway.
2. **Definir Recursos y Métodos**:
   - Crear recursos como `/rides` y definir los métodos `GET` y `POST`.
3. **Integrar la API con el Backend**:
   - Configurar la integración para que el API Gateway envíe las solicitudes a la instancia EC2 donde está desplegado el backend.
4. **Habilitar CORS** para permitir solicitudes desde el frontend.

#### Configuración de AWS EC2

1. **Crear una Instancia EC2**:
   - Crear una nueva instancia de EC2 (puedes usar Amazon Linux 2 o Ubuntu).
2. **Instalar Dependencias**:
   - Instalar Java y Maven en la instancia.
   - Clonar el repositorio y compilar el backend:
     ```sh
     git clone <URL_DEL_REPO>
     cd uber/backend
     mvn clean install
     ```
3. **Ejecutar la Aplicación**:
   - Ejecutar el backend para que escuche en el puerto `8080`:
     ```sh
     mvn spring-boot:run
     ```
4. **Configurar Grupos de Seguridad**:
   - Asegurarse de que la instancia EC2 tenga permisos para recibir solicitudes HTTP en el puerto `8080`.

## Ejecución Local

El proyecto se puede ejecutar completamente en local para probarlo antes de implementarlo en la nube:

1. **Backend**: Se ejecuta con `mvn spring-boot:run` en el puerto `8080`.
2. **Frontend**: Se sirve localmente usando `http-server` o abriendo directamente `index.html` en un navegador.
3. **Interacción entre Frontend y Backend**: Asegúrate de que el archivo `script.js` contenga la URL correcta (`http://localhost:8080/api`) para pruebas locales.
