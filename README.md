# Ejercicio 1

## Stack

- **IDE** VSCode + Git Hub Copilot
- **Patron** Screenplay
- **Framework de automatización** Serenity BDD
- **Gestion de dependencias** Gradle
- **Cumplir con el princpio de responsabilidad única para las Task**

## Descripción

Realizar una prueba funcional automatizada (Prueba E2E) de un flujo de compra en la
página https://www.demoblaze.com/ que incluya:

- Agregar dos productos al carrito
- Visualizar el carrito
- Completar el formulario de compra
- Finalizar la compra

Para efectos de la revisión de este repositorio, este archivo contiene

- Un archivo `readme.txt` con las instrucciones paso a paso de ejecución.
- Un archivo `conclusiones.txt` con los hallazgos y conclusiones del ejercicio


## Plan de acción para el proyecto

1. **Creación de proyecto**

    Crear el proyecto usando el IDE de Visual Studio Code

2. **Importar los archivos relacionados**

   Importa los archivos en este repositorio

3. **Generación del arquetipo**

    Genera el arquetipo (estructura de carpetas)

    - Asegura el archivo `src/test/resources/features/registro.feature`

4. **Construye el escenario**

    - Construye las historias de usuario basado en los requerimientos de la prueba

5. **Modifica al escenario con base en lo obtenido con las Historias de Usuario**

    El escenario debe plasmar los requerimientos de la prueba

6. **Generación de los Steps Definitions**

    Crea los steps definitions en el Archivos `RegistroStepDefinitions` usando las siguientes notaciones a partir del escenario Gherkin generado
    
    - Hacer una prueba manual E2E para fundamentar los pasos

7. **Generación de los elementos**

    - Define los elementos de la página web a interactuar con base en los pasos definidos
    - Por cada página, localizalos a partir de lo XPaths

8. **Generación de tareas**

    Genera las tareas con prompts

9. **Creación de constantes y hooks**

    Crea las constantes en la carpeta utils, en esta se introducen las constantes con las cuales vamos a efectuar la prueba

10. **Creación de los hooks**

    Crea el archivo de hook para abrir el navegador

11. **Creación del runner**

    Creamos el runner para nuestro escenario

12. **Completitud de los step definitions**

13. **Ejecución del Escenario**

    Ejecuta el escenario para ver las preubas

## Cómo ejecutar la prueba (resumen)

1. Verifica que estés usando **Java 21**.
2. Ejecuta las pruebas con el wrapper de Gradle desde la raíz del proyecto:

   - **Windows (PowerShell/CMD):**
     - `.\gradlew.bat clean test`
   - **Linux/macOS/Git Bash:**
     - `./gradlew clean test`

3. Revisa el reporte HTML generado por Gradle en:
   - `build/reports/tests/test/index.html`

