# ejercicio de práctica TDD - Ascensores -

Ver el enunciado del ejercicio general en [github - sugerencias-para-practicar-programacion - Ascensores](https://github.com/JuanMuruaOlalde/sugerencias-para-practicar-programacion/tree/main/Ascensores)

Preparar el entorno de programación (en este ejemplo, Javascript y Node.js). Activar la plataforma de test (Test Harness) que vayamos a utilizar (en este ejemplo, https://jestjs.io/). 

Para ver que la plataforma funciona, se puede hacer un "Hello word" rápido. Escribir y ejecutar tres sencillos test triviales: un test que pasa, un test que falla y un test que detecta una excepción. Luego, estos tres test de prueba se pueden borrar.

````
//Archivo index.js

function estaFuncionLanzaUnaExcepcion() {
    throw new Error("Esto es una prueba de lanzar una excepcion.");
}

export { estaFuncionLanzaUnaExcepcion };
````

````
//Archivo index.test.js

import { estaFuncionLanzaUnaExcepcion } from "./index.js";

test("este test pasa", () => {
    expect(true).toBeTruthy();
});

test("este test falla", () => {
    expect(true).toBeFalsy();
});

test("una funcion de pruebas provoca una excepcion", () => {
    expect(() => estaFuncionLanzaUnaExcepcion()).toThrow(Error);
});
````



nota: Lo que sigue a continuación en este documento es una de las múltiples posibles maneras de realizar el ejercicio. Se ofrece simplemente como muestra ilustrativa de la forma general de proceder. Puede que otra persona, o incluso yo mismo en otro momento, lo hiciera de forma diferente; parecida, pero diferente.


## pasito

Elegimos una funcionalidad: "El ascensor ha de poder ir a un piso concreto."

- Escribimos tests
````
//Archivo ascensor.test.js

import { crearAscensor } from "./ascensor.js";

test("el ascensor puede ir a un piso válido", () => {
    let ascensor = crearAscensor();
    ascensor.irAlPiso(-2);
    expect(ascensor.getPisoEnQueEsta()).toBe(-2);
    ascensor.irAlPiso(5);
    expect(ascensor.getPisoEnQueEsta()).toBe(5);
    ascensor.irAlPiso(0);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    ascensor.irAlPiso(-1);
    expect(ascensor.getPisoEnQueEsta()).toBe(-1);
    ascensor.irAlPiso(3);
    expect(ascensor.getPisoEnQueEsta()).toBe(3);
});
````

Obviamente, el test no se puede ejecutar. Si estuviéramos con un lenguaje compilado, ni siquiera compilaria...
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose ascensor.test.js

 FAIL  ./ascensor.test.js
  ● Test suite failed to run
                                                                                                                                                                           
    Cannot find module './ascensor.js' from 'ascensor.test.js'

      at Resolver._throwModNotFoundError (node_modules/jest-resolve/build/resolver.js:427:11)

Test Suites: 1 failed, 1 total                                                                                                                                             
Tests:       0 total                                                                                                                                                       
Snapshots:   0 total
Time:        0.492 s, estimated 1 s
Ran all test suites matching /ascensor.test.js/i.
````

- Escribimos lo mínimo de código funcional para que el test se pueda ejecutar
````
//Archivo ascensor.js

function crearAscensor() {
    return {
    
        irAlPiso(piso) {},

        getPisoEnQueEsta() {},
        
    };
}

export { crearAscensor };
````

- Comprobamos que el test falla (RED)
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js ascensor.test
(node:15808) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 FAIL  ./ascensor.test.js
  × el ascensor puede ir a un piso válido (3 ms)                                                                                                                           
                                                                                                                                                                           
  ● el ascensor puede ir a un piso válido                                                                                                                                  
                                                                                                                                                                           
    expect(received).toBe(expected) // Object.is equality

    Expected: -2
    Received: undefined

      4 |     let ascensor = crearAscensor();
      5 |     ascensor.irAlPiso(-2);
    > 6 |     expect(ascensor.getPisoEnQueEsta()).toBe(-2);
        |                                         ^
      7 |     ascensor.irAlPiso(5);
      8 |     expect(ascensor.getPisoEnQueEsta()).toBe(5);
      9 |     ascensor.irAlPiso(0);

      at Object.<anonymous> (ascensor.test.js:6:41)

Test Suites: 1 failed, 1 total                                                                                                                                             
Tests:       1 failed, 1 total                                                                                                                                             
Snapshots:   0 total
Time:        0.425 s
Ran all test suites matching /ascensor.test/i.
````

- Escribimos lo mínimo de código funcional para que el test pase
````
//Archivo ascensor.js

function crearAscensor() {
    let piso_en_que_esta = 0;

    return {
        irAlPiso(piso) {
            piso_en_que_esta = piso;
        },

        getPisoEnQueEsta() {
            return piso_en_que_esta;
        },
    };
}

export { crearAscensor };
````

- Comprobamos que el test pasa (GREEN)
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js ascensor.test.js
(node:23760) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (2 ms)                                                                                                                           
                                                                                                                                                                           
Test Suites: 1 passed, 1 total                                                                                                                                             
Tests:       1 passed, 1 total                                                                                                                                             
Snapshots:   0 total
Time:        0.413 s, estimated 1 s
Ran all test suites matching /ascensor.test.js/i.
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
// en este caso no se estima refactorizar nada
````

- Antes de dar por terminado el pasito. Hay que ejecutar por lo menos una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
npm test

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose
(node:16232) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./index.test.js
  √ este test pasa (2 ms)                                                                                                                                                  
  √ una funcion de pruebas provoca una excepcion (7 ms)                                                                                                                     
  ○ skipped este test falla                                                                                                                                                
                                                                                                                                                                           
 PASS  ./ascensor.test.js                                                                                                                                                  
  √ el ascensor puede ir a un piso válido (1 ms)

Test Suites: 2 passed, 2 total
Tests:       3 skipped, 3 passed, 6 total
Snapshots:   0 total
Time:        0.642 s, estimated 1 s
Ran all test suites.
````

## pasito

Elegimos una funcionalidad: "El ascensor tiene un piso mínimo y uno máximo."

- Escribimos tests
````
//añadimos al archivo ascensor.test.js

test("el ascensor se queda quieto donde este si se indica un piso invalido", () => {
    let ascensor = crearAscensor(-2, 5);
    ascensor.irAlPiso(0);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    expect(() => ascensor.irAlPiso(-4)).toThrow(Error);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    expect(() => ascensor.irAlPiso(7)).toThrow(Error);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
});

test("el ascensor se queja si se indica un piso invalido", () => {
    let ascensor = crearAscensor(-2, 5);
    expect(() => ascensor.irAlPiso(-4)).toThrow(Error);
    expect(() => ascensor.irAlPiso(7)).toThrow(Error);
});
````

- Escribimos lo mínimo de código funcional para que esos test se puedan ejecutar
````
//añadimos al archivo ascensor.js

function crearAscensor(piso_mas_bajo, piso_mas_alto) {
````

- Comprobamos que los test fallan (RED)
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose ascensor.test.js
(node:37104) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 FAIL  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (3 ms)                                                                                                                           
  × el ascensor se queda quieto donde este si se indica un piso invalido (1 ms)                                                                                            
  × el ascensor se queja si se indica un piso invalido (1 ms)                                                                                                              
                                                                                                                                                                           
  ● el ascensor se queda quieto donde este si se indica un piso invalido                                                                                                   
                                                                                                                                                                           
    expect(received).toThrow(expected)

    Expected constructor: Error

    Received function did not throw

      19 |     ascensor.irAlPiso(0);
      20 |     expect(ascensor.getPisoEnQueEsta()).toBe(0);
    > 21 |     expect(() => ascensor.irAlPiso(-4)).toThrow(Error);
         |                                         ^
      22 |     expect(ascensor.getPisoEnQueEsta()).toBe(0);
      23 |     expect(() => ascensor.irAlPiso(7)).toThrow(Error);
      24 |     expect(ascensor.getPisoEnQueEsta()).toBe(0);

      at Object.<anonymous> (ascensor.test.js:21:41)

  ● el ascensor se queja si se indica un piso invalido

    expect(received).toThrow(expected)

    Expected constructor: Error

    Received function did not throw

      27 | test("el ascensor se queja si se indica un piso invalido", () => {
      28 |     let ascensor = crearAscensor(-2, 5);
    > 29 |     expect(() => ascensor.irAlPiso(-4)).toThrow(Error);
         |                                         ^
      30 |     expect(() => ascensor.irAlPiso(7)).toThrow(Error);
      31 | });
      32 |

      at Object.<anonymous> (ascensor.test.js:29:41)

Test Suites: 1 failed, 1 total                                                                                                                                             
Tests:       2 failed, 1 passed, 3 total                                                                                                                                   
Snapshots:   0 total
Time:        0.856 s, estimated 1 s
Ran all test suites matching /ascensor.test.js/i.
````

- Escribimos lo mínimo de código funcional para que esos test pasen
````
//añadimos al archivo ascensor.test.js

        irAlPiso(piso) {
            if (piso >= piso_mas_bajo && piso <= piso_mas_alto) {
                piso_en_que_esta = piso;
            } else {
                throw new Error(
                    `No se puede ir al piso ${piso}. El ascensor solo va desde ${piso_mas_bajo} al ${piso_mas_alto}.`
                );
            }
        },
````

- Comprobamos que los test pasan (GREEN)
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose ascensor.test.js
(node:34640) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (3 ms)                                                                                                                           
  √ el ascensor se queda quieto donde este si se indica un piso invalido (9 ms)                                                                                            
  √ el ascensor se queja si se indica un piso invalido                                                                                                                     
                                                                                                                                                                           
Test Suites: 1 passed, 1 total                                                                                                                                             
Tests:       3 passed, 3 total                                                                                                                                             
Snapshots:   0 total
Time:        0.829 s, estimated 1 s
Ran all test suites matching /ascensor.test.js/i.
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
// en este caso no se estima refactorizar nada
````

- Antes de dar por terminado el pasito. Hay que ejecutar por lo menos una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
npm test

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose
(node:25276) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (2 ms)                                                                                                                           
  √ el ascensor se queda quieto donde este si se indica un piso invalido (9 ms)                                                                                            
  √ el ascensor se queja si se indica un piso invalido (1 ms)                                                                                                              
                                                                                                                                                                           
 PASS  ./index.test.js                                                                                                                                                     
  √ este test pasa (1 ms)
  √ una funcion de pruebas provoca una excepcion (7 ms)                                                                                                                     
  ○ skipped este test falla                                                                                                                                                
                                                                                                                                                                           
Test Suites: 2 passed, 2 total                                                                                                                                             
Tests:       1 skipped, 5 passed, 6 total                                                                                                                                  
Snapshots:   0 total
Time:        0.655 s, estimated 1 s
Ran all test suites.
````



## pasito (una alternativa a los dos pasitos anteriores)

nota: Esto es para reflexionar acerca de qué hubiera pasado si hubiéramos elegido la funcionalidad: "El ascensor ha de poder ir a un piso concreto, de entre el mínimo y máximo que tenga."

nota: Los puristas del TDD podrian decir que esa funcionalidad es demasiado grande. Cuanto más pequeño cada paso, mejor.  
Esa funcionalidad se puede separar claramente en dos: "El ascensor ha de poder ir a un piso concreto." y "El ascensor tiene un piso mínimo y uno máximo." (como se ha hecho en los dos pasitos anteriores).  
Pero, en la práctica, las cosas que están lógicamente muy relacionadas también se pueden hacer juntas. Eso sí, siempre y cuando no requieran escribir más de tres o cuatro sencillos test para cubrir toda su casuística.

nota: En este punto del programa, considerar algo más amplio del estilo "El ascensor ha de acudir al piso donde se pulse el botón de  llamada."; se ve claramente que seria excesivo. Requiere la existencia de un edificio que alberga las plantas y el ascensor. Seria un paso demasiado grande para abordarlo en este punto.   
Mejor limitarnos a un solo ente: el ascensor; y a un solo proceso sencillo: que se mueva.


Elegimos una funcionalidad: "El ascensor ha de poder ir a un piso concreto, de entre el mínimo y máximo que tenga."

- Escribimos tests:
````
//Archivo ascensor.test.js

import { crearAscensor } from "./ascensor.js";

test("el ascensor puede ir a un piso válido", () => {
    let ascensor = crearAscensor(-2, 5);
    ascensor.irAlPiso(-2);
    expect(ascensor.getPisoEnQueEsta()).toBe(-2);
    ascensor.irAlPiso(5);
    expect(ascensor.getPisoEnQueEsta()).toBe(5);
    ascensor.irAlPiso(0);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    ascensor.irAlPiso(-1);
    expect(ascensor.getPisoEnQueEsta()).toBe(-1);
    ascensor.irAlPiso(3);
    expect(ascensor.getPisoEnQueEsta()).toBe(3);
});

test("el ascensor se queda quieto donde este si se indica un piso invalido", () => {
    let ascensor = crearAscensor(-2, 5);
    ascensor.irAlPiso(0);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    ascensor.irAlPiso(-4);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    ascensor.irAlPiso(7);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
});

test("el ascensor se queja si se indica un piso invalido", () => {
    let ascensor = crearAscensor(-2, 5);
    expect(() => ascensor.irAlPiso(-4)).toThrow(Error);
    expect(() => ascensor.irAlPiso(7)).toThrow(Error);
});
````

Obviamente, esos test no se pueden ejecutar. Si estuviéramos con un lenguaje compilado, ni siquiera compilarian...
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose ascensor.test.js

 FAIL  ./ascensor.test.js
  ● Test suite failed to run
                                                                                                                                                                           
    Cannot find module './ascensor.js' from 'ascensor.test.js'

      at Resolver._throwModNotFoundError (node_modules/jest-resolve/build/resolver.js:427:11)

Test Suites: 1 failed, 1 total                                                                                                                                             
Tests:       0 total                                                                                                                                                       
Snapshots:   0 total
Time:        0.438 s
Ran all test suites matching /ascensor.test.js/i.
````

- Escribimos lo mínimo de código funcional para que esos test se puedan ejecutar (o compilar, si fuera un lenguaje compilado en vez de interpretado)
````
//Archivo ascensor.js

function crearAscensor(piso_mas_bajo, piso_mas_alto) {
    return {
    
        irAlPiso(piso) {},

        getPisoEnQueEsta() {},
        
    };
}

export { crearAscensor };
````

- Comprobamos que los test fallan (RED)
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose ascensor.test.js
 RUNS  ./ascensor.test.js
(node:20788) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 FAIL  ./ascensor.test.js
  × el ascensor puede ir a un piso válido (3 ms)                                                                                                                           
  × el ascensor se queda quieto donde este si se indica un piso invalido                                                                                                   
  × el ascensor se queja si se indica un piso invalido (1 ms)                                                                                                              
                                                                                                                                                                           
  ● el ascensor puede ir a un piso válido                                                                                                                                  
                                                                                                                                                                           
    expect(received).toBe(expected) // Object.is equality

    Expected: -2
    Received: undefined

      4 |     let ascensor = crearAscensor(-2, 5);
      5 |     ascensor.irAlPiso(-2);
    > 6 |     expect(ascensor.getPisoEnQueEsta()).toBe(-2);
        |                                         ^
      7 |     ascensor.irAlPiso(5);
      8 |     expect(ascensor.getPisoEnQueEsta()).toBe(5);
      9 |     ascensor.irAlPiso(0);

      at Object.<anonymous> (ascensor.test.js:6:41)

  ● el ascensor se queda quieto donde este si se indica un piso invalido

    expect(received).toBe(expected) // Object.is equality

    Expected: 0
    Received: undefined

      18 |     let ascensor = crearAscensor(-2, 5);
      19 |     ascensor.irAlPiso(0);
    > 20 |     expect(ascensor.getPisoEnQueEsta()).toBe(0);
         |                                         ^
      21 |     ascensor.irAlPiso(-4);
      22 |     expect(ascensor.getPisoEnQueEsta()).toBe(0);
      23 |     ascensor.irAlPiso(7);

      at Object.<anonymous> (ascensor.test.js:20:41)

  ● el ascensor se queja si se indica un piso invalido

    expect(received).toThrow(expected)

    Expected constructor: Error

    Received function did not throw

      27 | test("el ascensor se queja si se indica un piso invalido", () => {
      28 |     let ascensor = crearAscensor(-2, 5);
    > 29 |     expect(() => ascensor.irAlPiso(-4)).toThrow(Error);
         |                                         ^
      30 |     expect(() => ascensor.irAlPiso(7)).toThrow(Error);
      31 | });
      32 |

      at Object.<anonymous> (ascensor.test.js:29:41)

Test Suites: 1 failed, 1 total
Tests:       3 failed, 3 total
Snapshots:   0 total
Time:        0.442 s, estimated 1 s
Ran all test suites matching /ascensor.test.js/i.
````

- Escribimos lo mínimo de código funcional para que esos test pasen
````
//añadimos al archivo ascensor.js

    let piso_en_que_esta = 0;

    return {
        irAlPiso(piso) {
            if (piso >= piso_mas_bajo && piso <= piso_mas_alto) {
                piso_en_que_esta = piso;
            } else {
                throw new Error(
                    `No se puede ir al piso ${piso}. El ascensor solo va desde ${piso_mas_bajo} al ${piso_mas_alto}.`
                );
            }
        },

        getPisoEnQueEsta() {
            return piso_en_que_esta;
        },
    };
````

- Comprobamos que esos test pasan (GREEN)

Pero... en el primer intento...
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose ascensor.test.js
(node:17068) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 FAIL  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (3 ms)
  × el ascensor se queda quieto donde este si se indica un piso invalido                                                                                                   
  √ el ascensor se queja si se indica un piso invalido (4 ms)                                                                                                              
                                                                                                                                                                           
  ● el ascensor se queda quieto donde este si se indica un piso invalido                                                                                                   
                                                                                                                                                                           
    No se puede ir al piso -4. El ascensor solo va desde -2 al 5.

       7 |                 piso_en_que_esta = piso;
       8 |             } else {
    >  9 |                 throw new Error(
         |                       ^
      10 |                     `No se puede ir al piso ${piso}. El ascensor solo va desde ${piso_mas_bajo} al ${piso_mas_alto}.`
      11 |                 );
      12 |             }

      at Object.irAlPiso (ascensor.js:9:23)
      at Object.<anonymous> (ascensor.test.js:21:14)

Test Suites: 1 failed, 1 total                                                                                                                                             
Tests:       1 failed, 2 passed, 3 total                                                                                                                                   
Snapshots:   0 total
Time:        0.805 s, estimated 1 s
Ran all test suites matching /ascensor.test.js/i.
````
...se ve que la comprobación de quedarse quieto y de dar un error ¿no se pueden hacer juntas?

- Segundo intento,... ajustar los test...
````
//corregir archivo ascensor.tests.js

test("el ascensor se queda quieto donde este si se indica un piso invalido", () => {
    let ascensor = crearAscensor(-2, 5);
    ascensor.irAlPiso(0);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    expect(() => ascensor.irAlPiso(-4)).toThrow(Error);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
    expect(() => ascensor.irAlPiso(7)).toThrow(Error);
    expect(ascensor.getPisoEnQueEsta()).toBe(0);
});
````

- ...ajustar el código funcional, si procede hacerlo
````
// en este caso no procede
````

- ...y volver a comprobar si los test pasan (GREEN)
````
npm test ascensor.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose ascensor.test.js
(node:34640) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (3 ms)                                                                                                                           
  √ el ascensor se queda quieto donde este si se indica un piso invalido (9 ms)                                                                                            
  √ el ascensor se queja si se indica un piso invalido                                                                                                                     
                                                                                                                                                                           
Test Suites: 1 passed, 1 total                                                                                                                                             
Tests:       3 passed, 3 total                                                                                                                                             
Snapshots:   0 total
Time:        0.829 s, estimated 1 s
Ran all test suites matching /ascensor.test.js/i.
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
// en este caso no se estima refactorizar nada
````

- Antes de dar por terminado el paso. Por lo menos hay que ejecutar una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
npm test

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose
(node:25276) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (2 ms)                                                                                                                           
  √ el ascensor se queda quieto donde este si se indica un piso invalido (9 ms)                                                                                            
  √ el ascensor se queja si se indica un piso invalido (1 ms)                                                                                                              
                                                                                                                                                                           
 PASS  ./index.test.js                                                                                                                                                     
  √ este test pasa (1 ms)
  √ una funcion de pruebas provoca una excepcion (7 ms)                                                                                                                     
  ○ skipped este test falla                                                                                                                                                
                                                                                                                                                                           
Test Suites: 2 passed, 2 total                                                                                                                                             
Tests:       1 skipped, 5 passed, 6 total                                                                                                                                  
Snapshots:   0 total
Time:        0.655 s, estimated 1 s
Ran all test suites.
````


## commit

Tenemos un ascensor que sube y baja. No es mucho, pero por lo menos es algo que funciona y podría ser útil para algo. Lo incorporamos al repositorio de código comunal...

nota: En el camino, antes de este commit hemos podido hacer otros commits de cada pasito en nuestra propia rama local de trabajo. Pero aquí estamos hablando de mergear esa rama local con la principal del repositorio `origin`.



## pasito

Elegimos una funcionalidad: "Viene un ascensor al pulsar el botón de llamada."

- Escribimos tests
````
//Archivo edificio.test.js

import { crearEdificio } from "./edificio.js";

test("acude un ascensor al piso cuando se pulsa el boton de llamada", () => {
    let edificio = crearEdificio(-2, 5);
    expect(edificio.getPisoEnQueEstaElAscensor()).not.toBe(3);
    edificio.pulsarBotonDeLlamadaAscensorEnPiso(3);
    expect(edificio.getPisoEnQueEstaElAscensor()).toBe(3);
});

````

- Escribimos lo mínimo de código funcional para que esos test se puedan ejecutar
````
//Archivo edificio.js

function crearEdificio(piso_mas_bajo, piso_mas_alto) {
    return {
        pulsarBotonDeLlamadaAscensorEnPiso(piso) {},
        getPisoEnQueEstaElAscensor() {},
    };
}

export { crearEdificio };
````

- Comprobamos que el test falla (RED)
````
npm test edificio.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose edificio.test.js
(node:32728) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 FAIL  ./edificio.test.js
  × acude un ascensor al piso cuando se pulsa el boton de llamada (5 ms)                                                                                                   
                                                                                                                                                                           
  ● acude un ascensor al piso cuando se pulsa el boton de llamada                                                                                                          
                                                                                                                                                                           
    expect(received).toBe(expected) // Object.is equality

    Expected: 3
    Received: undefined

      5 |     expect(edificio.getPisoEnQueEstaElAscensor()).not.toBe(3);
      6 |     edificio.pulsarBotonDeLlamadaAscensorEnPiso(3);
    > 7 |     expect(edificio.getPisoEnQueEstaElAscensor()).toBe(3);
        |                                                   ^
      8 | });
      9 |

      at Object.<anonymous> (edificio.test.js:7:51)

Test Suites: 1 failed, 1 total                                                                                                                                             
Tests:       1 failed, 1 total                                                                                                                                             
Snapshots:   0 total
Time:        0.423 s
Ran all test suites matching /edificio.test.js/i.
````

- Escribimos lo mínimo de código funcional para que el test pase
````
//añadimos al archivo edificio.js

import { crearAscensor } from "./ascensor";

function crearEdificio(piso_mas_bajo, piso_mas_alto) {
    let ascensor = crearAscensor(piso_mas_bajo, piso_mas_alto);

    return {
        pulsarBotonDeLlamadaAscensorEnPiso(piso) {
            ascensor.irAlPiso(piso);
        },
        getPisoEnQueEstaElAscensor() {
            return ascensor.getPisoEnQueEsta();
        },
    };
}

export { crearEdificio };
````

- Comprobamos que el test pasa (GREEN)
````
npm test edificio.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose edificio.test.js
(node:31540) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./edificio.test.js
  √ acude un ascensor al piso cuando se pulsa el boton de llamada (2 ms)                                                                                                   
                                                                                                                                                                           
Test Suites: 1 passed, 1 total                                                                                                                                             
Tests:       1 passed, 1 total                                                                                                                                             
Snapshots:   0 total
Time:        0.406 s, estimated 1 s
Ran all test suites matching /edificio.test.js/i.
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
//añadimos al archivo edificio.js

        pulsarBotonDeLlamadaAscensorEnPiso(piso) {
            try {
                ascensor.irAlPiso(piso);
            } catch (error) {
                console.error(error);
            }
        },
````

- Antes de dar por terminado el pasito. Hay que ejecutar por lo menos una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
npm test

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose
(node:1800) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./ascensor.test.js
  √ el ascensor puede ir a un piso válido (2 ms)                                                                                                                           
  √ el ascensor se queda quieto donde este si se indica un piso invalido (10 ms)                                                                                           
  √ el ascensor se queja si se indica un piso invalido (1 ms)                                                                                                              
                                                                                                                                                                           
 PASS  ./edificio.test.js                                                                                                                                                  
  √ acude un ascensor al piso cuando se pulsa el boton de llamada (1 ms)
                                                                                                                                                                           
 PASS  ./index.test.js                                                                                                                                                     
  √ este test pasa (1 ms)
  √ una funcion de pruebas provoca una excepcion (5 ms)                                                                                                                    
  ○ skipped este test falla                                                                                                                                                
                                                                                                                                                                           
Test Suites: 3 passed, 3 total                                                                                                                                             
Tests:       1 skipped, 6 passed, 7 total                                                                                                                                  
Snapshots:   0 total
Time:        0.75 s, estimated 1 s
Ran all test suites.
````

## pasito

Elegimos una funcionalidad: "El edificio tiene más de un ascensor."

- Escribimos tests
````
//bueno... en este caso se trata más bien de modificar un test existente.

test("acude un ascensor al piso cuando se pulsa el boton de llamada", () => {
    let edificio = crearEdificio(-2, 5);

    let posicionesDeLosAscensoresAntesDeLaLlamada =
        edificio.getPosicionesDeLosAscensores();
    expect(posicionesDeLosAscensoresAntesDeLaLlamada).not.toContain(3);

    edificio.pulsarBotonDeLlamadaAlAscensorEnPiso(3);

    let posicionesDeLosAscensoresDespuesDeLaLlamada =
        edificio.getPosicionesDeLosAscensores();
    expect(posicionesDeLosAscensoresDespuesDeLaLlamada).toContain(3);
});
````

- Escribimos lo mínimo de código funcional para que el test se pueda ejecutar
````
    TypeError: edificio.getPosicionesDeLosAscensores is not a function

      3 | test("acude un ascensor al piso cuando se pulsa el boton de llamada", () => {
      4 |     let edificio = crearEdificio(-2, 5);
    > 5 |     let posicionesDeLosAscensores = edificio.getPosicionesDeLosAscensores();
        |                                              ^
      6 |     expect(posicionesDeLosAscensores).not.toContain(3);
      7 |     edificio.pulsarBotonDeLlamadaAscensorEnPiso(3);
      8 |     expect(posicionesDeLosAscensores).toContain(3);

      at Object.<anonymous> (edificio.test.js:5:46)
````

````
//modificamos el nombre de la función en el archivo edificio.js

        getPosicionesDeLosAscensores() {
            return ascensor.getPisoEnQueEsta();
        },
````

- Comprobamos que los test fallan (RED)
````
npm test edificio.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose edificio.test.js
(node:31048) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 FAIL  ./edificio.test.js
  × acude un ascensor al piso cuando se pulsa el boton de llamada (3 ms)                                                                                                   
                                                                                                                                                                           
  ● acude un ascensor al piso cuando se pulsa el boton de llamada                                                                                                          
                                                                                                                                                                           
    expect(received).toContain(expected) // indexOf

    Expected value:  3
    Received number: 0

       6 |     expect(posicionesDeLosAscensores).not.toContain(3);
       7 |     edificio.pulsarBotonDeLlamadaAscensorEnPiso(3);
    >  8 |     expect(posicionesDeLosAscensores).toContain(3);
         |                                       ^
       9 | });
      10 |

      at Object.<anonymous> (edificio.test.js:8:39)

Test Suites: 1 failed, 1 total                                                                                                                                             
Tests:       1 failed, 1 total                                                                                                                                             
Snapshots:   0 total
Time:        0.42 s, estimated 1 s
Ran all test suites matching /edificio.test.js/i.
````

- Escribimos lo mínimo de código funcional para que el test pase
````
//modificamos y añadimos en el archivo edificio.js

    let ascensores = [
        crearAscensor(piso_mas_bajo, piso_mas_alto),
        crearAscensor(piso_mas_bajo, piso_mas_alto),
        crearAscensor(piso_mas_bajo, piso_mas_alto),
        crearAscensor(piso_mas_bajo, piso_mas_alto),
    ];

    return {
        pulsarBotonDeLlamadaAlAscensorEnPiso(piso) {
            try {
                ascensores.at(0).irAlPiso(piso);
            } catch (error) {
                console.error(error);
            }
        },
        getPosicionesDeLosAscensores() {
            return ascensores.map((x) => x.getPisoEnQueEsta());
        },
    };
````

- Comprobamos que el test pasa (GREEN)
````
npm test edificio.test.js

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose edificio.test.js
(node:30336) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./edificio.test.js
  √ acude un ascensor al piso cuando se pulsa el boton de llamada (2 ms)                                                                                                   
                                                                                                                                                                           
Test Suites: 1 passed, 1 total                                                                                                                                             
Tests:       1 passed, 1 total                                                                                                                                             
Snapshots:   0 total
Time:        0.476 s, estimated 1 s
Ran all test suites matching /edificio.test.js/i.
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
// Se ve oportuno renombrar función de `crearAscensor(...)` a `crearUnAscensor(...)`
// por ejemplo, así queda más claro en la sentencia:

    let ascensores = [
        crearUnAscensor(piso_mas_bajo, piso_mas_alto),
        crearUnAscensor(piso_mas_bajo, piso_mas_alto),
        crearUnAscensor(piso_mas_bajo, piso_mas_alto),
        crearUnAscensor(piso_mas_bajo, piso_mas_alto),
    ];
    
    
// También se ve oportuno poder elegir el número de ascensores en el creador del edificio:

test("acude un ascensor al piso cuando se pulsa el boton de llamada", () => {
    let edificio = crearEdificio(-2, 5, 4);


function crearEdificio(piso_mas_bajo, piso_mas_alto, cantidad_de_ascensores) {
    let ascensores = [];
    for (let i = 0; i < cantidad_de_ascensores; i++) {
        ascensores.push(crearUnAscensor(piso_mas_bajo, piso_mas_alto));
    }

````

- Antes de dar por terminado el pasito. Hay que ejecutar por lo menos una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
npm test

> ascensores@1.0.0 test
> node --experimental-vm-modules node_modules/jest/bin/jest.js --verbose
(node:13680) ExperimentalWarning: VM Modules is an experimental feature and might change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

 PASS  ./edificio.test.js
  √ acude un ascensor al piso cuando se pulsa el boton de llamada (4 ms)                                                                                                   
                                                                                                                                                                           
 PASS  ./ascensor.test.js                                                                                                                                                  
  √ el ascensor puede ir a un piso válido (2 ms)
  √ el ascensor se queda quieto donde este si se indica un piso invalido (7 ms)                                                                                            
  √ el ascensor se queja si se indica un piso invalido                                                                                                                     
                                                                                                                                                                           
 PASS  ./index.test.js                                                                                                                                                     
  √ este test pasa (1 ms)
  √ una funcion de pruebas provoca una excepcion (9 ms)                                                                                                                    
  ○ skipped este test falla                                                                                                                                                
                                                                                                                                                                           
Test Suites: 3 passed, 3 total                                                                                                                                             
Tests:       1 skipped, 6 passed, 7 total                                                                                                                                  
Snapshots:   0 total
Time:        0.852 s, estimated 1 s
Ran all test suites.
````

## pasito

Elegimos una funcionalidad: "Cuando se pulsa un botón dentro de un ascensor concreto, ese ascensor va al piso indicado."

nota: Primero habia pensado en la funcionalidad del pasito siguiente (la de "Cuando pulsa el botón de llamada en un piso, viene el ascensor más cercano a ese piso en ese momento."). Pero al ir a escribir tests me he dado cuenta de que para el tema de la cercania, necesito poder situar con precisión todos los ascensores del edificio.

- Escribimos tests
````
````

- Escribimos lo mínimo de código funcional para que esos test se puedan ejecutar
````
````

- Comprobamos que los test fallan (RED)
````
````

- Escribimos lo mínimo de código funcional para que esos test pasen
````
````

- Comprobamos que los test pasan (GREEN)
````
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
````

- Antes de dar por terminado el pasito. Hay que ejecutar por lo menos una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
````



## pasito

Elegimos una funcionalidad: "Cuando pulsa el botón de llamada en un piso, viene el ascensor más cercano a ese piso en ese momento."

- Escribimos tests
````
````

- Escribimos lo mínimo de código funcional para que esos test se puedan ejecutar
````
````

- Comprobamos que los test fallan (RED)
````
````

- Escribimos lo mínimo de código funcional para que esos test pasen
````
````

- Comprobamos que los test pasan (GREEN)
````
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
````

- Antes de dar por terminado el pasito. Hay que ejecutar por lo menos una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
````


## commit

Tenemos un edificio con varios ascensores con la funcionalidad básica para usarlos. Se podria tener mejores algoritmos de gestión de los ascensores, pero por lo menos es algo que funciona y podria ser útil para algo. Lo incorporamos al repositorio de código comunal...

nota: En el camino, antes de este commit hemos podido hacer otros commits de cada pasito en nuestra propia rama local de trabajo. Pero aquí estamos hablando de mergear esa rama local con la principal del repositorio `origin`.


## pasito



## pasito...

Elegimos una funcionalidad: "."

- Escribimos tests
````
````

- Escribimos lo mínimo de código funcional para que esos test se puedan ejecutar
````
````

- Comprobamos que los test fallan (RED)
````
````

- Escribimos lo mínimo de código funcional para que esos test pasen
````
````

- Comprobamos que los test pasan (GREEN)
````
````

- Revisamos el trabajo y ajustamos lo que proceda ajustar (REFACTOR)
````
````

- Antes de dar por terminado el pasito. Hay que ejecutar por lo menos una vez todos los test del programa; para comprobar que todos pasan y no hemos roto nada de lo ya existente.
````
````

