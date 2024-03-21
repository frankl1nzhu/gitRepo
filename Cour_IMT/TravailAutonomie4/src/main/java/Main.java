public class Main {
    public static void main(String[] args) {
        VehiculeDeTransports bateau = new VehiculeDeTransports("Bateau");
        VehiculeDeTransports bus = new VehiculeDeTransports("Bus");
        VehiculeDeTransports voiture = new VehiculeDeTransports("Voiture");
        Passager passagerPieton = new Passager("Passager piéton");
        Passager passagerVoiture = new Passager("Passager voiture");
        bus.ajouterPassager(passagerPieton);
        voiture.ajouterPassager(passagerVoiture);
        bateau.ajouterVehicule(bus);
        bateau.ajouterVehicule(voiture);
        System.out.println("Nombre total de passagers du bateau : " + bateau.getNombreTotalPassagers());

        afficherDetails(bateau, 0);
    }
    public static void afficherDetails(Vehicule vehicule, int niveau) {
        for (int i = 0; i < niveau; i++) {
            System.out.print("\t");
        }
        System.out.println("Véhicule : " + vehicule.getNom());

        for (int i = 0; i < niveau; i++) {
            System.out.print("\t");
        }
        System.out.println("Nombre de passagers : " + vehicule.getNombrePassagers());

        if (vehicule instanceof VehiculeDeTransports) {
            for (Vehicule vehicule1 : ((VehiculeDeTransports) vehicule).getVehiculesEmbarques()) {
                afficherDetails(vehicule1, niveau + 1);
            }
        }
    }
}
