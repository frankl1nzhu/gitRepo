import java.util.ArrayList;
import java.util.List;

public class VehiculeDeTransports extends Vehicule{
    private List<Vehicule> vehiculesEmbarques;
    public VehiculeDeTransports(String nom) {
        super(nom);
        this.vehiculesEmbarques = new ArrayList<>();
    }
    public void ajouterVehicule(Vehicule vehicule) {
        vehiculesEmbarques.add(vehicule);
    }
    public int getNombreTotalPassagers() {
        int total = getNombrePassagers();
        for (Vehicule vehicule : vehiculesEmbarques) {
            if (vehicule instanceof VehiculeDeTransports) {
                total += ((VehiculeDeTransports) vehicule).getNombreTotalPassagers();
            } else {
                total += vehicule.getNombrePassagers();
            }
        }
        return total;
    }
    public List<Vehicule> getVehiculesEmbarques() {
        return vehiculesEmbarques;
    }
    public void setVehiculesEmbarques(List<Vehicule> vehiculesEmbarques) {
        this.vehiculesEmbarques = vehiculesEmbarques;
    }
}