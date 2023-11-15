package TD_Interfaces;

public class Camion extends Vehicule implements Motorise, Entreprise{
    @Override
    public void roule() {
        System.out.println("Camion roule");
    }
    public void remplirReservoir(){
        System.out.println("Le reservoir de ce camion se remplit");
    }

    @Override
    public void afficheNomEntreprise() {
        System.out.println("L'entreprise de ce camion est ...");
    }
}
