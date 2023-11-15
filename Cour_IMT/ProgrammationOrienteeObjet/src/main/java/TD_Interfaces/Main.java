package TD_Interfaces;

public class Main {
    public static void main(String[] args) {
        Voiture v1 = new Voiture() ;
        v1.roule();

        Motorise v3 = new Voiture() ;
        v3.remplirReservoir();
        System.out.println(v3.kmMax);
        System.out.println(Motorise.kmMax);

        Vehicule v4 = new Voiture() ;
        v4.remplirReservoir();

        Velo velo = new Velo();
        velo.roule();

        Camion camion = new Camion();
        camion.roule();
        camion.afficheNomEntreprise();

        StationService stationService = new StationService();
        stationService.faireLePlein(camion);
        stationService.faireLePlein(velo);
    }
}
