# Sistema de Cuentas Corrientes en Java

## Descripción
Sistema bancario desarrollado en Java que permite gestionar cuentas corrientes con funcionalidades de consulta de saldo, retiros, transferencias y control de estado de cuentas mediante interfaz gráfica con JOptionPane.

## Características del Proyecto

### Funcionalidades Base
- Consulta de datos de cuenta (titular, número, saldo)
- Sistema de retiros con validación de saldo
- Transferencias entre cuentas
- Gestión de múltiples usuarios

## Mejoras Implementadas vs. Código Base

- ✅ Sistema de bloqueo/desbloqueo de cuentas
- ✅ Validaciones de seguridad para operaciones en cuentas bloqueadas
- ✅ Manejo de excepciones 
- ✅ Interfaz de usuario con ventana (Anteriormente en consola)

### Aportes Creativos Implementados

#### 1. **Sistema de Bloqueo/Desbloqueo de Cuentas**
Funcionalidad completa de seguridad bancaria:
- Atributo booleano `estaBloqueada` en la clase Usuario
- Método `setEstaBloqueada(boolean estado)` para cambiar el estado
- Método `estaBloqueada()` para consultar el estado actual
- Opción en el menú principal (opción 4) para gestionar bloqueos
- Toggle automático del estado (si está bloqueada la desbloquea y viceversa)

#### 2. **Validaciones de Seguridad**
Protección de operaciones en cuentas bloqueadas:
- **En retiros**: Verifica que la cuenta no esté bloqueada antes de permitir la operación
- **En transferencias**: Valida que la cuenta origen no esté bloqueada
- Mensajes informativos al usuario cuando se intenta operar con cuenta bloqueada
- Prevención de operaciones no autorizadas

#### 3. **Visualización Mejorada del Estado de Cuenta**
- Método `getDatosCuenta()` actualizado para mostrar el estado
- Uso de operador ternario para determinar si está "BLOQUEADA" o "ACTIVA"
- Información completa en cada consulta:
  - Titular
  - Número de cuenta
  - Saldo actual
  - **Estado de la cuenta** (NUEVO)

#### 4. **Interfaz de Usuario Mejorada**
- Mensajes más claros y profesionales
- Confirmaciones visuales después de cada operación
- Feedback inmediato al bloquear/desbloquear cuentas
- Manejo de cancelación de operaciones (botón cancelar)

#### 5. **Generación Automática de Número de Cuenta**
- Uso de `Random` para generar números de cuenta únicos
- Números largos (tipo `long`) para simular cuentas bancarias reales
- Generación automática en el constructor

## Estructura del Proyecto

```
ejercicio2/
│
├── Usuario.java            # Clase para gestión de usuarios y operaciones
└── CuentaCorriente.java    # Clase principal con menú e interfaz
```

## Clases

### Usuario.java
Gestiona la información y operaciones de cada cuenta:
- **Atributos privados**:
  - `titular`: Nombre del titular
  - `numero_cuenta`: Número único de cuenta (generado aleatoriamente)
  - `saldo`: Saldo actual de la cuenta
  - `estaBloqueada`: Estado de bloqueo de la cuenta

- **Métodos principales**:
  - `setRetiros()`: Procesa retiros con validaciones de saldo y estado
  - `setTransferencia()`: Realiza transferencias entre cuentas
  - `getDatosCuenta()`: Retorna información formateada de la cuenta
  - `setEstaBloqueada()`: Cambia el estado de bloqueo
  - `estaBloqueada()`: Consulta si la cuenta está bloqueada

### CuentaCorriente.java
Clase principal que:
- Crea dos usuarios de ejemplo (Juan Perez y Diana Prince)
- Presenta menú interactivo con 4 opciones + salir
- Gestiona la lógica de navegación y selección
- Maneja excepciones de entrada de datos
- Coordina todas las operaciones bancarias

## Requisitos

- Java JDK 8 o superior
- Biblioteca Swing (javax.swing) para JOptionPane

## Cómo Ejecutar

1. Compilar ambos archivos .java
2. Ejecutar la clase `CuentaCorriente`
3. Seguir el menú interactivo:
   - **Opción 1**: Consultar datos de cuenta
   - **Opción 2**: Realizar retiros
   - **Opción 3**: Realizar transferencias
   - **Opción 4**: Bloquear/Desbloquear cuenta
   - **SALIR**: Terminar el programa

## Flujo de Operaciones

### Consulta de Cuenta (Opción 1)
1. Seleccionar cuenta (1 o 2)
2. Ver datos completos incluyendo estado

### Retiro (Opción 2)
1. Seleccionar cuenta
2. Ingresar monto a retirar
3. Sistema valida:
   - Que la cuenta no esté bloqueada
   - Que el monto sea positivo
   - Que haya saldo suficiente
4. Muestra estado actualizado

### Transferencia (Opción 3)
1. Ingresar monto a transferir (Juan → Diana)
2. Sistema valida:
   - Que la cuenta origen no esté bloqueada
   - Que el monto sea positivo
   - Que haya saldo suficiente
3. Muestra ambas cuentas actualizadas

### Bloqueo/Desbloqueo (Opción 4)
1. Seleccionar cuenta a modificar
2. Sistema cambia automáticamente el estado:
   - Si estaba ACTIVA → pasa a BLOQUEADA
   - Si estaba BLOQUEADA → pasa a ACTIVA
3. Confirma la acción realizada
4. Muestra datos actualizados de la cuenta

## Ejemplo de Operaciones

### Bloqueo de Cuenta
```
Seleccione cuenta para Bloquear/Desbloquear:
1 - Juan Perez
2 - Diana Prince
> 1

[Mensaje] Cuenta de Juan Perez ha sido BLOQUEADA

Titular: Juan Perez
Numero de cuenta: 8736452819273645
Saldo: $22000.0
Estado: BLOQUEADA
```

### Intento de Retiro con Cuenta Bloqueada
```
Monto a retirar: 5000

[Error] Operacion denegada: La cuenta esta bloqueada
```

### Consulta de Cuenta Activa
```
Titular: Diana Prince
Numero de cuenta: 2847361928374651
Saldo: $17800.0
Estado: ACTIVA
```

## Validaciones Implementadas

✅ Verificación de estado de cuenta antes de operaciones  
✅ Validación de montos positivos  
✅ Verificación de saldo suficiente  
✅ Manejo de entradas inválidas (NumberFormatException)  
✅ Prevención de operaciones en cuentas bloqueadas  
✅ Validación de cuentas existentes  

## Seguridad

- Las cuentas bloqueadas **NO** pueden realizar retiros
- Las cuentas bloqueadas **NO** pueden enviar transferencias
- Las cuentas bloqueadas **SÍ** pueden recibir transferencias
- Todos los atributos son privados con acceso controlado

## Autor ✒️

* **Victor Cordoba** - *Creador y desarrollador principal* - [VoctorX](https://github.com/VoctorX)

## Fecha

* 27 de Noviembre del 2025, Programación Orientada a Objetos

## Licencia

Proyecto académico - Uso educativo

---

**Nota**: Este proyecto forma parte de los ejercicios de Get y Set en Java, exactamente al archivo "Ejercicios get y set.pdf", siendo la primera parte del pdf, es decir, paginas 1, 2 y 3
