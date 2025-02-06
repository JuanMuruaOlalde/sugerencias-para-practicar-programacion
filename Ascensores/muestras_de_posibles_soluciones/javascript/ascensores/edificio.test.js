import { crearEdificio } from "./edificio.js";

test("acude un ascensor al piso cuando se pulsa el boton de llamada", () => {
    let edificio = crearEdificio(-2, 5, 4);

    let posicionesDeLosAscensoresAntesDeLaLlamada =
        edificio.getPosicionesDeLosAscensores();
    expect(posicionesDeLosAscensoresAntesDeLaLlamada).not.toContain(3);

    edificio.pulsarBotonDeLlamadaAlAscensorEnPiso(3);

    let posicionesDeLosAscensoresDespuesDeLaLlamada =
        edificio.getPosicionesDeLosAscensores();
    expect(posicionesDeLosAscensoresDespuesDeLaLlamada).toContain(3);
});
