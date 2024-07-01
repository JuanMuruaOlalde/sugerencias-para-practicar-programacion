use core::fmt;

use chrono::{DateTime, FixedOffset};
use num_format::{Locale, ToFormattedString};

fn main() {
    let lista_de_numeros: Vec<i32> = vec![
        34, 76, 295, 17, 861, 5, 95, 127, 3, 99, 26, 49, 117, 532, 15, 88, 2, 31,
    ];
    println!("La lista original: {:?}", lista_de_numeros);

    let lista_doblada: Vec<i32> = lista_de_numeros.iter().map(|&x| x * 2).collect();
    println!("La lista multiplicada por dos: {:?}", lista_doblada);

    let suma: i32 = lista_de_numeros.iter().sum();
    let suma_formateada = suma.to_formatted_string(&Locale::es);
    println!("La suma de la lista original es: {}", suma_formateada);

    let (numeros_pares, numeros_impares): (Vec<i32>, Vec<i32>) =
        lista_de_numeros.iter().partition(|&x| x % 2 == 0);
    println!("Solo los impares: {:?}", numeros_impares);
    println!("Solo los pares: {:?}", numeros_pares);

    let lista_incrementada: Vec<f32> = lista_de_numeros.iter().map(|&x| x as f32 * 1.30).collect();
    let lista_formateada: Vec<String> = lista_incrementada
        .iter()
        .map(|&x| format!("{:.2}", x))
        .collect();
    println!("La lista incrementada un 30%: {:?}", lista_formateada);

    let mut lecturas_de_la_estacion_metereologica: Vec<MedicionMetereologica> = Vec::new();
    lecturas_de_la_estacion_metereologica.push(MedicionMetereologica {
        fecha: DateTime::parse_from_rfc3339("2024-06-28T16:30:00+00:02").unwrap(),
        temperatura_max_celsius: 7.7,
        temperatura_min_celsius: 3.0,
        humedad_max_porcentaje: 54,
        humedad_min_porcentaje: 28,
        lluvia_litrospormetrocuadrado: 0.0,
    });
    lecturas_de_la_estacion_metereologica.push(MedicionMetereologica {
        fecha: DateTime::parse_from_rfc3339("2024-07-28T16:27:00+00:02").unwrap(),
        temperatura_max_celsius: 18.3,
        temperatura_min_celsius: 5.0,
        humedad_max_porcentaje: 74,
        humedad_min_porcentaje: 15,
        lluvia_litrospormetrocuadrado: 13.6,
    });
    lecturas_de_la_estacion_metereologica.push(MedicionMetereologica {
        fecha: DateTime::parse_from_rfc3339("2024-08-28T16:42:00+00:02").unwrap(),
        temperatura_max_celsius: 31.0,
        temperatura_min_celsius: 11.6,
        humedad_max_porcentaje: 84,
        humedad_min_porcentaje: 38,
        lluvia_litrospormetrocuadrado: 9.2,
    });
    let temperaturas_maximas: Vec<f32> = lecturas_de_la_estacion_metereologica
        .iter()
        .map(|x| x.temperatura_max_celsius)
        .collect();
    let suma_de_temperaturas_maximas: f32 = temperaturas_maximas.iter().sum();
    let temperatura_max_media =
        suma_de_temperaturas_maximas / lecturas_de_la_estacion_metereologica.len() as f32;
    println!(
        "La temperatura máxima ha tenido una media de {:.1}°C",
        temperatura_max_media
    );
    let temperaturas_minimas: Vec<f32> = lecturas_de_la_estacion_metereologica
        .iter()
        .map(|x| x.temperatura_min_celsius)
        .collect();
    let suma_de_temperaturas_minimas: f32 = temperaturas_minimas.iter().sum();
    let temperatura_min_media =
        suma_de_temperaturas_minimas / lecturas_de_la_estacion_metereologica.len() as f32;
    println!(
        "La temperatura mínima ha tenido una media de {:.1}°C",
        temperatura_min_media
    );
    println!("----------------------------------------------");
    for lectura in lecturas_de_la_estacion_metereologica {
        println!("{}", lectura);
    }
    println!("----------------------------------------------");
}

pub struct MedicionMetereologica {
    fecha: DateTime<FixedOffset>,
    temperatura_max_celsius: f32,
    temperatura_min_celsius: f32,
    humedad_max_porcentaje: u8,
    humedad_min_porcentaje: u8,
    lluvia_litrospormetrocuadrado: f32,
}
impl fmt::Display for MedicionMetereologica {
    fn fmt(&self, formatter: &mut fmt::Formatter) -> fmt::Result {
        write!(
            formatter,
            "{} : temperatura max {:>4.1}°C min {:>4.1}°C : humedad max {:>3}% min {:>3}% : lluvia {:>5.2} l/m2",
            self.fecha,
            self.temperatura_max_celsius,
            self.temperatura_min_celsius,
            self.humedad_max_porcentaje,
            self.humedad_min_porcentaje,
            self.lluvia_litrospormetrocuadrado
        )
    }
}
