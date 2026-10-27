# Ahorra Joven — API REST con Spring Boot

API REST educativa para administrar metas de ahorro juveniles y movimientos financieros. No está conectada a entidades bancarias ni procesa pagos reales.

## Tecnologías
- Java 17 o superior
- Spring Boot 3.5.6
- Spring Web (REST Controller)
- Spring Data JPA (Repositories)
- H2 (base de datos local persistente en archivo)
- Bean Validation
- IntelliJ IDEA HTTP Client para probar los endpoints (`demo/requests.http`)

## Estructura del proyecto
- `demo/src/main/java/com/example/demo/AhorroController.java`: endpoints REST.
- `demo/src/main/java/com/example/demo/MetaAhorro.java`: entidad de metas.
- `demo/src/main/java/com/example/demo/Movimiento.java`: entidad de movimientos.
- `demo/src/main/java/com/example/demo/MetaAhorroRepository.java`: repositorio JPA de metas.
- `demo/src/main/java/com/example/demo/MovimientoRepository.java`: repositorio JPA de movimientos.
- `demo/src/main/java/com/example/demo/ApiExceptionHandler.java`: respuestas de error de la API.
- `demo/src/main/resources/application.properties`: configuración del servidor y base de datos H2.
- `demo/requests.http`: peticiones para probar la API directamente desde IntelliJ IDEA.
- `INICIAR_AHORRA_JOVEN.bat`: inicio rápido en Windows.

## Ejecutar en Windows
1. Instala un JDK 17 o superior.
2. Abre el proyecto en IntelliJ IDEA: `File > Open` y selecciona la carpeta `demo` (la que contiene `pom.xml`).
3. Espera a que IntelliJ importe las dependencias Maven. La primera vez necesita internet.
4. Abre `src/main/java/com/example/demo/DemoApplication.java` y pulsa el triángulo verde junto a `main`.
5. Espera el mensaje de que Spring Boot arrancó en el puerto 8080.
6. Abre `requests.http` y pulsa `Run` encima de `1. Verificar que la API está funcionando`.

También puedes ejecutar `INICIAR_AHORRA_JOVEN.bat` desde Windows. Para detener el servidor, usa `Ctrl+C` en la terminal.

## Probar con IntelliJ IDEA (sin Postman)
1. Abre `demo/requests.http`.
2. Ejecuta las solicitudes de arriba hacia abajo usando el enlace `Run` que aparece sobre cada solicitud.
3. Ejecuta primero la solicitud 3, que crea una meta y guarda el ID automáticamente en `metaId`.
4. Las solicitudes siguientes reutilizan ese ID. La variable `movimientoId` se crea al ejecutar la solicitud 6.
5. Las solicitudes 12 y 13 son opcionales y eliminan datos de prueba; ejecútalas al final si deseas limpiar.

El HTTP Client integrado está disponible en IntelliJ IDEA. En ediciones o versiones que no muestren `Run` sobre el archivo, comprueba que el plugin HTTP Client esté habilitado o utiliza una versión de IntelliJ que incluya HTTP Client.

## Endpoints
| Método | Ruta | Función |
|---|---|---|
| GET | `/api/estado` | Comprobar el estado de la API |
| GET / POST | `/api/metas` | Listar o crear metas |
| GET / PUT / DELETE | `/api/metas/{id}` | Consultar, actualizar o eliminar una meta |
| POST | `/api/metas/{id}/aportes` | Añadir ahorro a una meta y registrar un movimiento |
| GET / POST | `/api/movimientos` | Listar o registrar movimientos |
| GET / DELETE | `/api/movimientos/{id}` | Consultar o eliminar un movimiento |
| GET | `/api/resumen` | Resumen de metas y movimientos |

Los tipos de movimiento válidos son `INGRESO`, `GASTO` y `APORTE`. Los importes se expresan en COP y las fechas usan formato `YYYY-MM-DD`.

## Publicar en GitHub
1. Entra a https://github.com y crea un repositorio nuevo llamado `ahorra-joven`.
2. Créalo vacío: no marques las opciones para agregar README, `.gitignore` ni licencia porque ya están en esta carpeta.
3. Abre la terminal de IntelliJ (`View > Tool Windows > Terminal`) en la carpeta raíz `demo-arreglado`, donde está este README.
4. Ejecuta estos comandos, uno por uno, cambiando `TU-USUARIO` por tu usuario real de GitHub y usando la URL del repositorio que acabas de crear:

```bash
git init
git add .
git commit -m "Entrega API REST Ahorra Joven"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/ahorra-joven.git
git push -u origin main
```

Si el proyecto ya tiene un remoto configurado, compruébalo con `git remote -v` antes de ejecutar `git remote add origin`. Si aparece un remoto incorrecto, actualízalo con `git remote set-url origin URL-REAL-DEL-REPOSITORIO`.

5. Actualiza la página del repositorio de GitHub y verifica que aparezcan `README.md`, `demo/` y `INICIAR_AHORRA_JOVEN.bat`.
6. Copia la URL del repositorio para entregarla junto con el proyecto.

No subas contraseñas, tokens ni datos personales. La base H2 se guarda localmente en `demo/data/` y debe mantenerse fuera de Git; el `.gitignore` del proyecto excluye esa carpeta.

## Nota de entrega
Antes de entregar, ejecuta la aplicación y prueba al menos el estado, crear meta, añadir aporte, registrar ingreso/gasto y consultar resumen. El proyecto se preparó para esta configuración, pero la compilación debe verificarse en tu computador con JDK 17+ y conexión a internet la primera vez.
