package TD_Interfaces;

public class StationService {
    public void faireLePlein(Motorise vehicule){
        vehicule.remplirReservoir();
    }
    public void faireLePlein(Object o) {
        System.out.println("Pas de reservoir");
    }
}
