package TD_Lambda_Stream;

public class Bar {
    private String Nom;
    private String Ville;
    public Bar(String nom, String ville) {
        super();
        Nom = nom;
        Ville = ville;
    }
    public String getNom() {
        return Nom;
    }
    public String getVille() {
        return Ville;
    }
    @Override
    public String toString() {
        return "Bar [Nom=" + Nom + ", Ville=" + Ville + "]";
    }

}
