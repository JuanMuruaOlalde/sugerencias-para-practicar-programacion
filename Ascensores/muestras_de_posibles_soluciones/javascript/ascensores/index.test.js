import { estaFuncionDePruebasLanzaUnaExcepcion } from "./index.js";

test("este test pasa", () => {
    expect(true).toBeTruthy();
});

test.skip("este test falla", () => {
    expect(true).toBeFalsy();
});

test("una funcion de pruebas provoca una excepcion", () => {
    expect(() => estaFuncionDePruebasLanzaUnaExcepcion()).toThrow(Error);
});
