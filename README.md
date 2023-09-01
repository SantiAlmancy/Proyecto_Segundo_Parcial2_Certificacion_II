# Proyecto Parcial 2

Estudiante: Santiago Becerra
Código: 64647

## Acerca del proyecto
El proyecto fue realizado en Intellij para la ejecución automatizada de tests para la siguiente página web: [Swag Labs](https://www.saucedemo.com/). Se realizó un total de **40 Tests** donde se revisa funciones desde el Login hasta la finalización correcta de la compra de productos.

## Requisitos previos

- Descargar Intellij IDEA: recomendablemente descargar la versión "Community Edition" del siguiente link: [INTELLIJ Link](https://www.jetbrains.com/es-es/idea/download/?section=windows)
- JDK: IntelliJ IDEA es una herramienta de desarrollo Java, por lo que necesita tener instalado un JDK en su sistema. Puede usar Oracle JDK, OpenJDK u otros JDK compatibles. El proyecto utiliza la versión "Oracle OpenJDK Version 20.0.2".
- Google Chrome: las pruebas automatizadas fueron realizadas utilizando el navegador Google Chrome.

## Instrucciones de ejecución
1. Descargar el proyecto del repositorio
2. Abrir el proyecto con Intellij IDEA
3. Revisar que el JDK sea el correcto, el proyecto utiliza: "Oracle OpenJDK Version 20.0.2"
4. Abrir dentro de Intellij la carpeta: src > test > java
5. Dentro de la carpeta java hacer clic derecho y elegir la opción "Run" para cada archivo .java, exceptuando el archivo "BaseTest".
6. El resultado de la ejecución se verá en la consola de la parte inferior, donde se indicará los test que pasaron y aquellos que fallaron.

## Notas Adicionales
Si desea revisar el proyecto más a detalle considerar lo siguiente:
- La carpeta src > test > java: contiene todos los testcases automatizados y BaseTest, que es una clase encargada de encapsular la funcionalidad común y la configuración necesaria para las pruebas
- La carpeta src > main > java > utilities: contiene la configuración del driver que facilita la gestión y configuración de controladores (drivers) del navegador web utilizado (Google Chrome).
- La carpeta src > main > java > pages: contiene todas las acciones y verificaciones que se realizan en cada página de Swag Labs (Tienda virtual testeada).

Se realizó esta división para cumplir con el "Page Object Pattern", un patrón de diseño en Selenium que crea un repositorio de objetos para almacenar todos los elementos web.
