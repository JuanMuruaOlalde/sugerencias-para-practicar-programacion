## Notas a esta versión de posible solución

Esta es una versión desarrollada siguiendo la metodologia TDD: 
- escribir un test (documenta y comprueba la funcionalidad a implementar), 
- escribir el código mínimo para que compile, 
- ejecutar y comprobar que falla (ROJO), 
- escribir el código que permite pasar (implementa la funcionalidad),
- ejecutar y comprobar que todos los test pasan (VERDE),
- pararse un momento a pensar si merece la pena REFACTORIZAR algo.
- (Obviamente, tras refactorizar todos los test han de seguir pasando.)

Normalmente esta metodologia suele conducir hacia arquitecturas más limpias, nomenclatura más clara y mejor cobertura de los casos de test.

Además ayuda a programar de forma más relajada. Ya que nos obliga a focalizarnos en una sola funcionalidad cada vez. (nota: Si vemos o se nos ocurre algo colateral mientras trabajamos, apuntarlo para no olvidarnos; pero no despistarnos. Cuando acabemos con este test, ya escribiremos otro para lo siguiente... ;-)

Es una metodología que cuesta un tanto aprenderla y sentise cómodo con ella. Pero merece la pena hacer el esfuerzo.


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
