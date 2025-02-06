import { crearUnAscensor } from "./ascensor";

function crearEdificio(piso_mas_bajo, piso_mas_alto, cantidad_de_ascensores) {
    let ascensores = [];
    for (let i = 0; i < cantidad_de_ascensores; i++) {
        ascensores.push(crearUnAscensor(piso_mas_bajo, piso_mas_alto));
    }

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
}

export { crearEdificio };
