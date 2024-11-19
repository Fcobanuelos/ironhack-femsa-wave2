# **Optimización de Código: Laboratorio 10**

## **Introducción**
El objetivo de este ejercicio es optimizar fragmentos de código en diferentes lenguajes (JavaScript, Java, y C#) para mejorar su rendimiento. Las optimizaciones se realizaron aplicando técnicas como reducción de operaciones redundantes, minimización de manipulaciones de recursos externos, y optimización de estructuras de datos y consultas.

---

## **Fragmentos de Código Original y Optimizado**

### **Fragmento de Código 1: JavaScript**
**Código Original**
```javascript
function updateList(items) {
  let list = document.getElementById("itemList");
  list.innerHTML = "";
  for (let i = 0; i < items.length; i++) {
    let listItem = document.createElement("li");
    listItem.innerHTML = items[i];
    list.appendChild(listItem);
  }
}
```

**Problemas Identificados**:
- Manipulación excesiva del DOM en cada iteración, causando múltiples reflows y repaints.

**Código Optimizado**
```javascript
function updateList(items) {
  let list = document.getElementById("itemList");
  let fragment = document.createDocumentFragment();
  list.innerHTML = "";
  
  items.forEach(item => {
    let listItem = document.createElement("li");
    listItem.innerHTML = item;
    fragment.appendChild(listItem);
  });

  list.appendChild(fragment);
}
```

**Optimización Aplicada**:
- Uso de `DocumentFragment` para realizar las modificaciones en memoria antes de actualizar el DOM, reduciendo las operaciones costosas.

---

### **Fragmento de Código 2: Java**
**Código Original**
```java
public class ProductLoader {
    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        for (int id = 1; id <= 100; id++) {
            products.add(database.getProductById(id));
        }
        return products;
    }
}
```

**Problemas Identificados**:
- 100 consultas individuales a la base de datos, causando alta sobrecarga.

**Código Optimizado**
```java
public class ProductLoader {
    public List<Product> loadProducts() {
        return database.getProductsInRange(1, 100);
    }
}
```

**Optimización Aplicada**:
- Uso de una consulta en bloque (`getProductsInRange`) para recuperar los productos en una sola operación, reduciendo el tiempo de ejecución y la carga del servidor.

---

### **Fragmento de Código 3: C#**
**Código Original**
```csharp
public List<int> ProcessData(List<int> data) {
    List<int> result = new List<int>();
    foreach (var d in data) {
        if (d % 2 == 0) {
            result.Add(d * 2);
        } else {
            result.Add(d * 3);
        }
    }
    return result;
}
```

**Problemas Identificados**:
- Cálculos redundantes y operaciones condicionales para cada elemento en el bucle.

**Código Optimizado**
```csharp
public List<int> ProcessData(List<int> data) {
    return data.Select(d => d % 2 == 0 ? d * 2 : d * 3).ToList();
}
```

**Optimización Aplicada**:
- Uso de LINQ para procesar los datos en una sola pasada, mejorando la claridad y reduciendo la complejidad computacional.

---

## **Informe de Optimización**

### **Problemas Comunes Detectados**
1. **JavaScript**: Manipulación excesiva del DOM.
2. **Java**: Consultas redundantes a la base de datos.
3. **C#**: Cálculos repetitivos en el bucle.

### **Soluciones Implementadas**
1. **JavaScript**: Uso de `DocumentFragment` para minimizar operaciones de reflow/repaint.
2. **Java**: Consulta en bloque para reducir interacciones con la base de datos.
3. **C#**: Uso de LINQ para simplificar el procesamiento de datos.

### **Resultados Esperados**
1. Mejora del rendimiento en aplicaciones web con listas extensas.
2. Reducción de la carga en el servidor y tiempo de respuesta de la base de datos.
3. Código más claro, eficiente y fácil de mantener.

---

## **Conclusión**
Estas optimizaciones demuestran cómo identificar y resolver problemas comunes de rendimiento mediante ajustes específicos en el código. Al implementar técnicas como procesamiento en bloque, manipulación eficiente del DOM y simplificación de bucles, se logran mejoras significativas en tiempo de ejecución y escalabilidad.
