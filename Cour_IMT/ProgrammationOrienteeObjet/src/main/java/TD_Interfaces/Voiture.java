package TD_Interfaces;

public class Voiture extends Vehicule implements Motorise{
    @Override
    public void roule() {
        System.out.println("Voiture roule");
    }
    public void remplirReservoir(){
        System.out.println("Le reservoir de cette voiture se remplit");
    }
    private boolean sport;
    public boolean isSport() {
        return sport;
    }
    public void setSport(boolean sport) {
        this.sport = sport;
    }
}
