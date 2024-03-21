import java.util.ArrayList;
import java.util.List;

public class Vehicule {
    private String nom;
    private List<Passager> passagers;
    public Vehicule() {
    }
    public Vehicule(String nom) {
        this.nom = nom;
        this.passagers = new ArrayList<>();
    }
    public void ajouterPassager(Passager passager) {
        passagers.add(passager);
    }
    public int getNombrePassagers() {
        return passagers.size();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Passager> getPassagers() {
        return passagers;
    }

    public void setPassagers(List<Passager> passagers) {
        this.passagers = passagers;
    }
}
