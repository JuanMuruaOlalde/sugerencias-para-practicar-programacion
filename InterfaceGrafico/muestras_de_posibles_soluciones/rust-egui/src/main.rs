use eframe::egui;

mod hello_benzirpi;
use crate::hello_benzirpi::HelloBenzirpi;

fn main() -> eframe::Result<()> {
    let opciones = eframe::NativeOptions {
        viewport: egui::ViewportBuilder::default()
            .with_inner_size([800.0, 600.0])
            .with_icon(egui::IconData::default()),
        ..eframe::NativeOptions::default()
    };
    eframe::run_native(
        HelloBenzirpi::name(),
        opciones,
        Box::new(|_cc| Ok(Box::<HelloBenzirpi>::default())),
    )
}
