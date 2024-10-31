### Análisis del Código de laboratorio 02

Analizando el código fuente del laboratorio 02, se identificaron los siguientes  3 problemas relacionados con los principios SOLID:

1. La clase SystemManager tenía múltiples responsabilidades.
    - **Principio SOLID violado**: Responsabilidad Única (SRP).
    - **Descripción**: La clase SystemManager se encargaba de verificar inventario, procesar pagos, actualizar el estado del pedido y notificar al cliente. Esto viola el principio de responsabilidad única, ya que una clase debe tener una única razón para cambiar.

2. SystemManager no estaba abierta para la extensión pero cerrada para la modificación.
    - **Principio SOLID violado**: Abierto/Cerrado (OCP).
    - **Descripción**: La clase SystemManager requería modificaciones para agregar nuevos tipos de pedidos, lo cual va en contra del principio de abierto/cerrado que establece que las entidades de software deben estar abiertas para la extensión, pero cerradas para la modificación.

3. SystemManager dependía de implementaciones concretas.
    - **Principio SOLID violado**: Inversión de Dependencias (DIP).
    - **Descripción**: La clase SystemManager dependía directamente de implementaciones concretas como: paymentService, expressPaymentService, database, y emailService, en lugar de depender de abstracciones.

#### Se realizaron los siguientes cambios para resolver los problemas identificados:

1. Dividir SystemManager en varias clases con responsabilidades únicas. Esto mejora la mantenibilidad y escalabilidad del código al asegurar que cada clase tenga una única responsabilidad.

2. Utilizar interfaces y clases concretas para permitir la extensión sin modificar SystemManager, facilita la adición de nuevos tipos de pedidos sin modificar la clase principal, mejorando la extensibilidad del sistema.

3. Introducir interfaces para los servicios y modificar SystemManager para depender de estas interfaces, esto aumenta la flexibilidad y facilita la prueba unitaria del código al permitir la inyección de dependencias.

#### Beneficios de los Cambios

1. Cada clase tiene una única responsabilidad, lo que facilita su mantenimiento y escalabilidad.

2. El sistema es más fácil de extender sin necesidad de modificar las clases existentes, lo que mejora la flexibilidad y reduce el riesgo de introducir errores.

3. El código es más flexible y fácil de probar, ya que las dependencias pueden ser inyectadas y sustituidas fácilmente.
