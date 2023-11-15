package TD_Tests;

public class Voiture {
    private String marque;
    private String modele;
    private int annee;
    private int km;
    private int puissance;

    public Voiture(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", km=" + km +
                ", puissance=" + puissance +
                '}';
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Voiture(String marque, String modele, int annee, int km, int puissance) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.km = km;
        this.puissance = puissance;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getKm() {
        return km;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
