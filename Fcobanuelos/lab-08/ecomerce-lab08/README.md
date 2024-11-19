## E-comerce Laboratorio 08 - Swagger Hub

## Link de Swagger Hub: https://app.swaggerhub.com/apis/FRANCISCOBANUELOS/E-comerce-lab08/1.0.0

## Descripción General
Esta API proporciona una solución RESTful para gestionar usuarios, pedidos y soporte al cliente en una plataforma de comercio electrónico. La especificación está diseñada siguiendo los principios de **API First** y documentada con **OpenAPI 3.0**.
---
## Reflexión sobre el Diseño e Implementación
### 1. Desafíos Enfrentados
#### a. Palabras Reservadas en SQL
Durante la implementación, se encontraron conflictos con palabras reservadas como `user` y `order`. Esto requirió ajustar los nombres de las entidades y las tablas para evitar errores en la base de datos.
#### b. Organización de Endpoints
Separar los controladores en categorías lógicas fue clave para mantener la API modular y fácil de mantener. Esto implicó mapear cada funcionalidad de forma clara y consistente.
#### c. Documentación Swagger
Asegurar que cada controlador y endpoint tuviera descripciones detalladas, ejemplos y respuestas adecuadas fue un reto que se superó utilizando `springdoc-openapi`.
---
### 2. Principios Aplicados
#### a. API First
El diseño de la API comenzó con la creación de su especificación en OpenAPI. Esto permitió alinear a todos los stakeholders antes de escribir el código, reduciendo la posibilidad de cambios importantes en etapas posteriores.
#### b. Modularidad
La API se dividió en tres controladores:
- **User Controller**: Para la gestión de usuarios.
- **Order Controller**: Para el manejo de pedidos.
- **Support Controller**: Para el soporte al cliente.
#### c. Escalabilidad
La arquitectura permite extender la funcionalidad con facilidad, como añadir nuevos endpoints o integrar autenticación avanzada en el futuro.
---
### 3. Conocimientos Adquiridos
- **Diseño API First**: Priorizar la especificación de la API mejora la colaboración entre equipos y reduce los errores.
- **Manejo de palabras reservadas**: La importancia de revisar las restricciones de SQL y ajustar los nombres de tablas y entidades.
- **Swagger como herramienta clave**: Documentar con Swagger no solo mejora la usabilidad, sino que también reduce la curva de aprendizaje para nuevos desarrolladores.
---
### 4. Mejoras Futuras
#### a. Autenticación y Seguridad
Implementar OAuth 2.0 o JWT para proteger los endpoints críticos.
#### b. Gestión de Errores
Incluir respuestas más detalladas para manejar errores, como códigos personalizados para casos específicos.
#### c. Métricas
Añadir endpoints para métricas y análisis de uso, como el número de pedidos realizados por usuario o los tickets más comunes.
#### d. Pruebas
Ampliar las pruebas unitarias e integrar pruebas de integración para garantizar la calidad en entornos de producción.


