# Ejemplo Código de Tres Direcciones
## Ejecutar con:
```sh
java -jar ThreeWayCode.jar
```

## o tambien
```sh
java -jar ThreeWayCode.jar input.txt
```

### Ejemplo archivo input.txt
```txt
x = 12 * (id1 * 12) + 10;
y = 100 - (-id1 + 12) + 10;
z = (100 + 2 * (-9 + 1) + id) * id;
```

### Tal entrada genera la siguiente salida:
```txt
t1 = id1 * 12
t2 = 12 * t1
t3 = t2 + 10
x = t3

t4 = -id1
t5 = t4 + 12
t6 = 100 - t5
t7 = t6 + 10
y = t7

t8 = -9
t9 = t8 + 1
t10 = 2 * t9
t11 = 100 + t10
t12 = t11 + id
t13 = t12 * id
z = t13
```

### Soporta:
Números enteros o identificadores(caracteres alfanumericos), sumas, restas, multiplicaciones, divisiones, y agrupación con parentesis.