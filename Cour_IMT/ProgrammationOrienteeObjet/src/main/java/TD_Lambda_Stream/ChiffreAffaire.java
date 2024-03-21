package TD_Lambda_Stream;

public class ChiffreAffaire {
    private Bar bar;
    private int annee;
    private int montant;
    public ChiffreAffaire(Bar bar, int annee, int montant) {
        super();
        this.bar = bar;
        this.annee = annee;
        this.montant = montant;
    }
    public Bar getBar() {
        return bar;
    }
    public int getAnnee() {
        return annee;
    }
    public int getMontant() {
        return montant;
    }
    @Override
    public String toString() {
        return "ChiffreAffaire [bar=" + bar + ", annee=" + annee + ", montant=" +
                montant + "]";
    }
}
