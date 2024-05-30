mod archivo_de_texto_plano;

fn main() {
    let path_archivo = String::from("./resources/archivo_para_pruebas.txt");
    let (personas, log) = archivo_de_texto_plano::leer_datos_del_archivo(&path_archivo);

    println!();
    println!("==============================================================================");
    for mensaje in log {
        println!("{}", mensaje);
    }
    println!("==============================================================================");
    println!("Las personas que se han leido son:");
    println!("----------------------------------");
    for persona in personas {
        println!("{}", persona);
        println!("--------------------------------------");
    }
    println!("==============================================================================");
}
