use eframe::egui;
const PIXELS_PER_POINT: f32 = 1.5;

#[derive(Default)]
pub struct MyBocata {
    tipo_de_pan: TipoDePan,
    ingrediente_principal: IngredientePrincipal,
    añadir_cebolla_fresca: bool,
    añadir_cebolla_caramelizada: bool,
    añadir_pimientos: bool,
    añadir_queso: bool,
}

#[derive(PartialEq)]
enum TipoDePan {
    Normal,
    Integral,
    Baguette,
    DeMolde,
}
impl Default for TipoDePan {
    fn default() -> Self {
        TipoDePan::Normal
    }
}
fn texto_del_pan(tipo: &TipoDePan) -> String {
    match tipo {
        TipoDePan::Normal => String::from("normal"),
        TipoDePan::Integral => String::from("integral"),
        TipoDePan::Baguette => String::from("baguette"),
        TipoDePan::DeMolde => String::from("de molde"),
    }
}
#[derive(PartialEq)]
enum IngredientePrincipal {
    Lomo,
    TortillaDeJamonYork,
    TortillaDeAtun,
    TortillaDeQueso,
    Calamares,
}
impl Default for IngredientePrincipal {
    fn default() -> Self {
        IngredientePrincipal::Lomo
    }
}
fn texto_del_ingrediente_principal(tipo: &IngredientePrincipal) -> String {
    match tipo {
        IngredientePrincipal::Lomo => String::from("lomo"),
        IngredientePrincipal::TortillaDeJamonYork => String::from("tortilla de jamón York"),
        IngredientePrincipal::TortillaDeAtun => String::from("tortilla de atún"),
        IngredientePrincipal::TortillaDeQueso => String::from("tortilla de queso"),
        IngredientePrincipal::Calamares => String::from("calamares"),
    }
}

impl MyBocata {
    pub fn titulo_ventana() -> &'static str {
        "Bocatas"
    }
}

impl eframe::App for MyBocata {
    fn update(&mut self, ctx: &egui::Context, _frame: &mut eframe::Frame) {
        ctx.set_pixels_per_point(PIXELS_PER_POINT);
        let mut ingredientes_addicionales: String = String::from("");
        egui::CentralPanel::default().show(ctx, |ui| {
            ui.horizontal(|ui| {
                ui.vertical(|ui| {
                    ui.group(|ui| {
                        ui.label("Elige el tipo de pan");
                        ui.radio_value(
                            &mut self.tipo_de_pan,
                            TipoDePan::Normal,
                            texto_del_pan(&TipoDePan::Normal),
                        );
                        ui.radio_value(
                            &mut self.tipo_de_pan,
                            TipoDePan::Integral,
                            texto_del_pan(&TipoDePan::Integral),
                        );
                        ui.radio_value(
                            &mut self.tipo_de_pan,
                            TipoDePan::Baguette,
                            texto_del_pan(&TipoDePan::Baguette),
                        );
                        ui.radio_value(
                            &mut self.tipo_de_pan,
                            TipoDePan::DeMolde,
                            texto_del_pan(&TipoDePan::DeMolde),
                        );
                    })
                });
                ui.vertical(|ui| {
                    ui.group(|ui| {
                        ui.label("Elige el ingrediente principal.");
                        ui.radio_value(
                            &mut self.ingrediente_principal,
                            IngredientePrincipal::Lomo,
                            texto_del_ingrediente_principal(&IngredientePrincipal::Lomo),
                        );
                        ui.radio_value(
                            &mut self.ingrediente_principal,
                            IngredientePrincipal::TortillaDeJamonYork,
                            texto_del_ingrediente_principal(
                                &IngredientePrincipal::TortillaDeJamonYork,
                            ),
                        );
                        ui.radio_value(
                            &mut self.ingrediente_principal,
                            IngredientePrincipal::TortillaDeAtun,
                            texto_del_ingrediente_principal(&IngredientePrincipal::TortillaDeAtun),
                        );
                        ui.radio_value(
                            &mut self.ingrediente_principal,
                            IngredientePrincipal::TortillaDeQueso,
                            texto_del_ingrediente_principal(&IngredientePrincipal::TortillaDeQueso),
                        );
                        ui.radio_value(
                            &mut self.ingrediente_principal,
                            IngredientePrincipal::Calamares,
                            texto_del_ingrediente_principal(&IngredientePrincipal::Calamares),
                        );
                    })
                });
                ui.vertical(|ui| {
                    ui.group(|ui| {
                        ui.label("¿Algún ingrediente adicional?");
                        ui.checkbox(&mut self.añadir_cebolla_fresca, "cebolla fresca");
                        if self.añadir_cebolla_fresca {
                            ingredientes_addicionales.push_str(", cebolla fresca");
                        };
                        ui.checkbox(
                            &mut self.añadir_cebolla_caramelizada,
                            "cebolla caramelizada",
                        );
                        if self.añadir_cebolla_caramelizada {
                            ingredientes_addicionales.push_str(", cebolla caramelizada");
                        };
                        ui.checkbox(&mut self.añadir_pimientos, "pimientos");
                        if self.añadir_pimientos {
                            ingredientes_addicionales.push_str(", pimientos");
                        };
                        ui.checkbox(&mut self.añadir_queso, "queso");
                        if self.añadir_queso {
                            ingredientes_addicionales.push_str(", queso");
                        };
                    })
                });
            });

            ui.horizontal(|ui| {
                ui.label(format!(
                    "Bocata con pan {}; de {} {}",
                    texto_del_pan(&self.tipo_de_pan),
                    texto_del_ingrediente_principal(&self.ingrediente_principal),
                    ingredientes_addicionales
                ));
            })
        });
    }
}
