## Notas a esta versión de posible solución

Esta es una versión con "excepciones": si se realiza una operación no-posible, esta lanza una excepción.

**Aviso**: Es mala idea usar el tratamiento de excepciones como mecanismo de control de la lógica de la aplicación. El tratamiento de excepciones es para lo que es: para lidiar con situaciones excepcionales que no suceden habitualmente en el funcionamiento normal del programa.

Otras (mejores) maneras de manejar la lógica de las operaciones no-posibles:

- Usar preguntas. Para saber si una operación va a ser o no va a ser posible. Antes de intentar realizarla.

- Usar respuestas (retorno de estado). Para saber si la operación se ha podido llevar a cabo o no. Y, en caso de no, saber qué ha fallado.


## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
