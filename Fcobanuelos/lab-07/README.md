# LABORATORIO 07 - PATRONES DE DISEÑO - IRONHACK
# API de Gestión de Productos con Patrones de diseño

## Descripción
Esta API es una aplicación para gestionar productos en una tienda en línea o inventario. La API demuestra el uso de varios patrones de diseño comunes en el desarrollo de software.
Se utilizan los patrones de diseño Singleton, Factory, Async y Observer para abordar problemas de diseño típicos de forma modular y escalable.

## Patrones de diseño y su uso

## 1. Singleton
Se utilizo el patrón Singleton en la clase ConfigSingleton para gestionar la configuración global de la tienda(como el nombre de la tienda). Esto asegura que solo exista una instancia de configuración en toda la aplicación, facilitando la gestion centralizada y evitando conflictos de acceso.

- **Clase**: ConfigSingleton
- **Métodos**: getInstance(), getConfig(), setConfig()
- **Funcionalidad**: Gestión de la configuración global de la tienda y ofrecer un punto de acceso único a la configuración.

## 2. Factory
Se implemento el patron factory en la case ProductFactory para crear diferentes tipos de productos basandose en un parametro de entrada. Esto permite que la API sea facilmente extensible, permitiendo la adicion de nuevos tipos de productos sin modificar el código existente.

- **Clase**: 
  - Product (interfaz)
  - ElectronicProduct: Producto de tipo electronico.
  - ClothingProduct: Producto de tipo ropa.
  - ProductFactory: Fabrica para crear productos.
- **Funcionalidad**: Crear diferentes tipos de productos basados en un parametro de entrada.
- **Métodos**: createProduct()

## 3. Observer
El patron observer se implementa en las clases ProductStatusPublisher y ProductStatusListener, esto permite que los componentes interesados sean notificados cuando cambia el estado de un producto, por ejemplo cuando un producto se marca como "disponible" o "agotado".

- **Clase**: 
  - ProductStatusPublisher: Publicador de eventos de cambio de estado de productos.
  - ProductStatusListener: Escuchador de eventos de cambio de estado de productos.
  - ProductStatusChangeEvent: Evento de cambio de estado de productos.
- **Funcionalidad**: Notificar a los componentes interesados cuando cambia el estado de un producto. Mejorando la modularidad y evitando el acoplamiento fuerte entre componentes.

## 4. Async
El patrón Async se utiliza para ejecutar tareas en segundo plano, como la actualización de inventario. Esto evita que la API bloquee el flujo principal mientras se completan estas tareas, mejorando la capacidad de respuesta y el rendimiento de la apñicación.

- **Clase**: 
  - AsyncService: Servicio para ejecutar tareas en segundo plano.
- **Funcionalidad**: Ejecutar tareas en segundo plano, como la actualización de inventario.


