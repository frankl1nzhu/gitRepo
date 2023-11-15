package TD_Interfaces;

public class Velo extends Vehicule{
    @Override
    public void roule() {
        System.out.println("Velo roule");
    }
    public void remplirReservoir(){
        System.out.println("Le velo n'a pas de reservoir");
    }
}
