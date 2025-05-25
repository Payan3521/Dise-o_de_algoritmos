# Recursividad

## ¿Qué es la Recursividad?

La recursividad es un concepto fundamental en programación donde una función se llama a sí misma para resolver un problema. Es una técnica poderosa que permite resolver problemas complejos dividiéndolos en subproblemas más pequeños y similares.

## Características Principales

1. **Caso Base**: Es la condición que detiene la recursión. Sin un caso base, la función se llamaría indefinidamente.
2. **Caso Recursivo**: Es la parte donde la función se llama a sí misma con un problema más pequeño.

## Ejemplo Clásico: Factorial

```python
def factorial(n):
    # Caso base
    if n == 0 or n == 1:
        return 1
    # Caso recursivo
    return n * factorial(n-1)
```

## Ventajas de la Recursividad

1. **Código más limpio y legible**
2. **Solución elegante para problemas complejos**
3. **Ideal para estructuras de datos recursivas (árboles, grafos)**

## Desventajas

1. **Mayor consumo de memoria** (pila de llamadas)
2. **Posible desbordamiento de pila** con recursiones muy profundas
3. **Puede ser menos eficiente** que soluciones iterativas

## Ejemplos Comunes

### 1. Fibonacci
```python
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)
```

### 2. Recorrido de Árbol
```python
def recorrer_arbol(nodo):
    if nodo is None:
        return
    print(nodo.valor)
    recorrer_arbol(nodo.izquierdo)
    recorrer_arbol(nodo.derecho)
```

## Tipos de Recursividad

1. **Recursividad Directa**: La función se llama a sí misma directamente.
2. **Recursividad Indirecta**: Dos o más funciones se llaman entre sí.
3. **Recursividad de Cola**: La llamada recursiva es la última operación.

## Mejores Prácticas

1. Siempre definir un caso base claro
2. Asegurar que cada llamada recursiva se acerca al caso base
3. Considerar el uso de recursividad de cola cuando sea posible
4. Evaluar si una solución iterativa podría ser más eficiente

## Aplicaciones Comunes

- Algoritmos de ordenamiento (quicksort, mergesort)
- Estructuras de datos (árboles, grafos)
- Problemas de backtracking
- Procesamiento de expresiones matemáticas
- Análisis sintáctico

## Consideraciones de Rendimiento

Para optimizar el rendimiento en recursividad:

1. Usar memorización para evitar cálculos repetidos
2. Implementar recursividad de cola cuando sea posible
3. Considerar la conversión a iterativo para problemas con mucha profundidad
4. Monitorear el uso de la pila de llamadas

## Ejemplo de Memorización

```python
def fibonacci_memo(n, memo={}):
    if n in memo:
        return memo[n]
    if n <= 1:
        return n
    memo[n] = fibonacci_memo(n-1, memo) + fibonacci_memo(n-2, memo)
    return memo[n]
```
