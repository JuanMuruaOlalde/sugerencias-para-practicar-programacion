use eframe::egui;

#[derive(Default)]
pub struct HelloBenzirpi {
    nombre_tecleado: String,
    nombre_para_saludar: String,
}

impl HelloBenzirpi {
    pub fn titulo_ventana() -> &'static str {
        "Hello..."
    }
}

impl eframe::App for HelloBenzirpi {
    /// egui llama a esta función update para repintar el interface de usuario.
    /// Suele hacerlo unas 60 veces por segundo.
    fn update(&mut self, ctx: &egui::Context, _frame: &mut eframe::Frame) {
        egui::CentralPanel::default().show(ctx, |ui| {
            ui.horizontal(|ui| {
                ui.label("Teclear aquí un nombre:");
                ui.text_edit_singleline(&mut self.nombre_tecleado);
                if ui.button("Clic aquí para saludar").clicked() {
                    self.nombre_para_saludar = self.nombre_tecleado.to_owned();
                };
                if self.nombre_para_saludar.is_empty() {
                    ui.label("");
                } else {
                    ui.label(format!("Hola, {}.", &self.nombre_para_saludar));
                }
            });
        });
    }
}
