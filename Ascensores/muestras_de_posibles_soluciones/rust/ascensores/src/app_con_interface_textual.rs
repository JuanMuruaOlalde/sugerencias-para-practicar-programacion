use std::collections::HashMap;

use crate::manejo_de_ascensores::{Ascensor, Edificio};

pub fn run() {
    let mut este_edificio = crear_edificio();
    mostrar_situacion(&este_edificio);

    println!();
    println!("Alguien pulsa botón de llamada en el piso 4");
    match este_edificio.pulsar_llamada_del_piso(4) {
        Err(e) => println!("{e}"),
        Ok(num_del_ascensor_que_ha_respondido) => {
            mostrar_situacion(&este_edificio);

            println!();
            println!("Alguien pulsa botón del sótano -1 dentro del ascensor {num_del_ascensor_que_ha_respondido}");
            let _ = este_edificio
                .pulsar_boton_dentro_del_ascensor(num_del_ascensor_que_ha_respondido, -1);
            mostrar_situacion(&este_edificio);
        }
    }
}

fn crear_edificio() -> Edificio {
    Edificio::new(
        -2,
        5,
        HashMap::from([
            (1, Ascensor::default()),
            (2, Ascensor::default()),
            (3, Ascensor::default()),
        ]),
    )
}

fn mostrar_situacion(este_edificio: &Edificio) {
    println!();
    let (mas_bajo, mas_alto) = este_edificio.get_piso_mas_bajo_y_piso_mas_alto();
    println!(
        "Los pisos del edificio van desde el {} hasta el {}",
        mas_bajo, mas_alto
    );
    println!(
        "El edificio tiene {} ascensores:",
        este_edificio.get_cuantos_ascensores_tiene()
    );
    for (num_ascensor, ascensor) in este_edificio.get_iter_for_ascensores() {
        println!(
            "  -{num_ascensor}- está en el piso {}",
            ascensor.get_piso_en_el_que_esta()
        );
    }
}
