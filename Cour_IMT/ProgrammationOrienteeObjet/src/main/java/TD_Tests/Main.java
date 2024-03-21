package TD_Tests;

public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture("BMW", "530", 2020);
        voiture.setKm(200000);
        voiture.setPuissance(500);
        System.out.println(voiture);
        
    }
}
