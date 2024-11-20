## Parte 1: Diseño de la Infraestructura de la Nube
**Diseño de arquitectura básica:**
- **Instancias de cómputo (AWS EC2):**
    - Implementar un grupo de instancias EC2 dentro de un Auto Scaling Group para asegurar escalabilidad.
    - Utilizar Amazon Machine Images (AMI) para estandarizar las configuraciones del servidor.
    - Configurar instancias en diferentes zonas de disponibilidad para alta disponibilidad.
- **Almacenamiento (AWS S3):**
    - Utilizar un bucket S3 para:
        - Almacenar archivos estáticos como imágenes, videos, y contenido de frontend.
        - Configurar versiones para mantener un historial de archivos.
        - Habilitar el cifrado SSE (Server-Side Encryption) para proteger los datos.
- **Configuraciones de red (AWS VPC):**
    - Crear una VPC con subredes públicas y privadas.
    - En las subredes públicas, incluir:
        - ELB (Elastic Load Balancer) para distribuir tráfico.
    - En las subredes privadas, incluir:
        - Instancias EC2 y bases de datos.
    - Configurar grupos de seguridad para limitar el acceso a las instancias y permitir únicamente tráfico necesario.

- ## Parte 2: Configuración de IAM
**Roles y políticas de IAM:**
1. **Rol para desarrolladores:**
    - Permisos de lectura/escritura en S3 y acceso a CloudWatch para monitoreo.
    - Restricciones a regiones específicas y limitación a ciertos servicios.
2. **Rol para administradores:**
    - Permisos de administración completos en la cuenta de AWS, pero restringidos para realizar operaciones destructivas en producción (como eliminar buckets S3).
3. **Rol para servidores de aplicaciones (EC2):**
    - Acceso a S3 para leer contenido estático.
    - Permisos mínimos para interactuar con bases de datos o colas (por ejemplo, SQS).
      **Adhesión al principio del mínimo privilegio:**
- Crear políticas personalizadas que otorguen únicamente permisos específicos y auditarlas regularmente.
- Configurar alertas para detectar cambios en políticas o accesos sospechosos.
---
## Parte 3: Estrategia de Gestión de Recursos
1. **Escalamiento automático:**
    - Configurar Auto Scaling Groups para agregar o eliminar instancias EC2 basado en métricas (uso de CPU, memoria, etc.).
    - Definir políticas de escalamiento predictivo y reactivo.
2. **Equilibrio de carga:**
    - Configurar un Application Load Balancer (ALB) para distribuir tráfico HTTP/S entre instancias EC2.
    - Habilitar certificados SSL para seguridad del tráfico.
3. **Optimización de costos:**
    - Utilizar AWS Budgets para definir límites de gasto y recibir alertas cuando se alcancen ciertos umbrales.
    - Usar instancias reservadas o savings plans para servicios de uso constante.
    - Implementar políticas de apagado automático para recursos no utilizados.
---
## Parte 4: Implementación Teórica
**Descripción de la arquitectura:**
- **ELB:** Distribuye el tráfico de los usuarios entre las instancias EC2 disponibles.
- **Instancias EC2:** Procesan solicitudes dinámicas y ejecutan la lógica de negocio. Acceden a los buckets S3 para recursos estáticos.
- **S3:** Almacena contenido estático y archivos de respaldo.
- **Auto Scaling Group:** Garantiza la escalabilidad automática dependiendo de la carga.
- **VPC:** Asegura que las comunicaciones entre los servicios sean privadas y seguras.
- **IAM:** Administra el acceso seguro a los recursos mediante roles y políticas específicas.
  **Flujo de datos:**
1. El usuario realiza una solicitud que llega al ELB.
2. ELB redirige la solicitud a una instancia EC2.
3. EC2 procesa la solicitud y accede al bucket S3 para contenido estático si es necesario.
4. Los datos procesados son enviados de vuelta al usuario.
---
## Parte 5: Discusión y Evaluación
**Elección de servicios:**
- **AWS EC2:** Flexible y escalable para ejecutar aplicaciones dinámicas.
- **AWS S3:** Ideal para almacenamiento duradero y rentable.
- **AWS VPC:** Ofrece un entorno seguro para alojar servicios en la nube.
  **Impacto de las políticas de IAM:**
- Las políticas diseñadas aseguran que solo las personas o servicios con los permisos necesarios accedan a los recursos, minimizando riesgos de seguridad.
  **Revisión de estrategia de gestión de recursos:**
- **Escalabilidad:** Auto Scaling y ELB garantizan que la infraestructura pueda manejar picos de tráfico.
- **Rentabilidad:** AWS Budgets y la optimización de recursos no utilizados reducen costos innecesarios.
---
## Conclusión
Este laboratorio teórico integra un enfoque completo de diseño de arquitectura en la nube, combinando seguridad, escalabilidad y optimización de costos. A través del uso de servicios de AWS, garantiza una infraestructura eficiente y segura que puede adaptarse a las necesidades de una aplicación moderna.
