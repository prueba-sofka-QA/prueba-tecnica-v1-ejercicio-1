Prueba técnica V1 Ejercicio 1

Stack

IDE: VSCode + Github Copilot
Patron: Screenplay
Framework de automatización: Serenity BDD
Gestion de dependencias: Gradle

Descripción

Realizar una prueba funcional automatizada (Prueba E2E) de un flujo de compra en la
página https://www.demoblaze.com/ que incluya:

Agregar dos productos al carrito
Visualizar el carrito
Completar el formulario de compra
Finalizar la compra

¿Cómo ejecutar esta Prueba Automatizada?

1. Verifica que tienes en tu equipo la versión de Java 21

2. Ejecuta las pruebas con el Wrapper desde la raíz del pryoecto,
usando en la terminal el siguiente comando

Para Windows (PowerShell/CMD):
.\gradlew.bat clean test

Para Linux/macOS/Git Bash:
./gradlew clean test

El comando procederá a correr la prueba automatizada cumpliendo con los pasos estipulados
en la prueba

3. Para ver el reporte en formato de Serenity ir a

target\site\serenity\index.html

Si quieres ver el reporte en Gradle ir a:

build\reports\tests\test\index.html
