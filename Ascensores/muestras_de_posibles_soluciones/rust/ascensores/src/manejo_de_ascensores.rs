use std::collections::HashMap;

pub struct Edificio {
    piso_mas_bajo: i16,
    piso_mas_alto: i16,
    ascensores: HashMap<i8, Ascensor>,
}

impl Edificio {
    pub fn new(
        piso_mas_bajo: i16,
        piso_mas_alto: i16,
        ascensores: HashMap<i8, Ascensor>,
    ) -> Edificio {
        Edificio {
            piso_mas_bajo: piso_mas_bajo,
            piso_mas_alto: piso_mas_alto,
            ascensores: ascensores,
        }
    }

    pub fn get_piso_mas_bajo_y_piso_mas_alto(&self) -> (i16, i16) {
        (self.piso_mas_bajo, self.piso_mas_alto)
    }

    pub fn get_cuantos_ascensores_tiene(&self) -> usize {
        self.ascensores.len()
    }

    pub fn get_ascensores<'a>(&'a self) -> impl Iterator<Item = (&i8, &Ascensor)> + 'a {
        self.ascensores.iter()
    }

    pub fn pulsar_llamada_del_piso(&mut self, piso: i16) -> Result<i8, String> {
        let mut distancia_mas_pequeña = i16::MAX;
        let mut num_ascensor_mas_cercano: i8 = 1;
        for (num_ascensor, ascensor) in &self.ascensores {
            let posicion = ascensor.piso_en_el_que_estoy;
            if (piso - posicion).abs() < distancia_mas_pequeña {
                distancia_mas_pequeña = (piso - posicion).abs();
                num_ascensor_mas_cercano = *num_ascensor;
            }
        }
        match self.pulsar_boton_dentro_del_ascensor(num_ascensor_mas_cercano, piso) {
            Ok(_) => Ok(num_ascensor_mas_cercano),
            Err(error) => Err(error),
        }
    }

    pub fn pulsar_boton_dentro_del_ascensor(
        &mut self,
        num_ascensor: i8,
        piso_al_que_se_desea_ir: i16,
    ) -> Result<(), String> {
        if piso_al_que_se_desea_ir >= self.piso_mas_bajo
            && piso_al_que_se_desea_ir <= self.piso_mas_alto
        {
            if let Some(ascensor) = self.ascensores.get_mut(&num_ascensor) {
                ascensor.piso_en_el_que_estoy = piso_al_que_se_desea_ir;
                return Ok(());
            } else {
                return Err(format!(
                    "Este edificio no tiene ascensor {num_ascensor}, solo tiene {} ascensores",
                    self.ascensores.len()
                ));
            };
        } else {
            return Err(format!(
                "Este edificio no tiene piso {piso_al_que_se_desea_ir}, el más bajo es {} y el mas alto {}",
                self.piso_mas_bajo, self.piso_mas_alto
            ));
        };
    }
}

#[derive(Debug)]
pub struct Ascensor {
    piso_en_el_que_estoy: i16,
}

impl Default for Ascensor {
    fn default() -> Self {
        Self {
            piso_en_el_que_estoy: 0,
        }
    }
}

impl Ascensor {
    pub fn get_piso_en_el_que_esta(&self) -> i16 {
        self.piso_en_el_que_estoy
    }
}

#[cfg(test)]
mod test {
    use super::*;

    fn preparar_un_edificio_de_pruebas() -> Edificio {
        let edificio = Edificio {
            piso_mas_bajo: -2,
            piso_mas_alto: 5,
            ascensores: HashMap::from([
                (1, Ascensor::default()),
                (2, Ascensor::default()),
                (3, Ascensor::default()),
            ]),
        };
        return edificio;
    }

    #[test]
    fn no_se_puede_utilizar_un_ascensor_que_no_exista() {
        let mut edificio = preparar_un_edificio_de_pruebas();
        let resultado = edificio.pulsar_boton_dentro_del_ascensor(5, 2);
        assert!(resultado.is_err());
    }

    #[test]
    fn no_se_puede_ir_a_un_piso_que_no_exista() {
        let mut edificio = preparar_un_edificio_de_pruebas();
        let resultado = edificio.pulsar_llamada_del_piso(-8);
        assert!(resultado.is_err());
        let resultado = edificio.pulsar_llamada_del_piso(8);
        assert!(resultado.is_err());
        let resultado = edificio.pulsar_boton_dentro_del_ascensor(1, -8);
        assert!(resultado.is_err());
        let resultado = edificio.pulsar_boton_dentro_del_ascensor(1, 8);
        assert!(resultado.is_err());
    }

    #[test]
    fn pulsar_tecla_de_llamada_trae_algun_ascensor_a_este_piso() {
        let mut edificio = preparar_un_edificio_de_pruebas();
        let _ = edificio.pulsar_llamada_del_piso(3);
        for (_num_ascensor, ascensor) in edificio.ascensores {
            if ascensor.piso_en_el_que_estoy == 3 {
                assert!(true);
                return;
            }
        }
        assert!(false);
    }

    #[test]
    fn pulsar_tecla_de_llamada_trae_el_ascensor_mas_cercano_a_este_piso() {
        let mut edificio = preparar_un_edificio_de_pruebas();

        let _ = edificio.pulsar_boton_dentro_del_ascensor(1, -2);
        let _ = edificio.pulsar_boton_dentro_del_ascensor(2, 4);
        let _ = edificio.pulsar_boton_dentro_del_ascensor(3, 5);

        let _ = edificio.pulsar_llamada_del_piso(3);
        if let Some(ascensor) = edificio.ascensores.get(&2) {
            assert_eq!(ascensor.piso_en_el_que_estoy, 3);
        }

        let _ = edificio.pulsar_boton_dentro_del_ascensor(1, -2);
        let _ = edificio.pulsar_boton_dentro_del_ascensor(2, 2);
        let _ = edificio.pulsar_boton_dentro_del_ascensor(3, 5);

        let _ = edificio.pulsar_llamada_del_piso(3);
        if let Some(ascensor) = edificio.ascensores.get(&2) {
            assert_eq!(ascensor.piso_en_el_que_estoy, 3);
        }
    }
}
