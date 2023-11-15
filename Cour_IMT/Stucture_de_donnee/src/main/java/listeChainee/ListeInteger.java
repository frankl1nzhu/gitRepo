package listeChainee;
public class ListeInteger {
    int contenu;
    ListeInteger suivant;
    public static void afficher(ListeInteger a){
        if (a != null){
            System.out.println(a.contenu);
            afficher(a.suivant);
        }
    }
    ListeInteger(int x, ListeInteger a){
        contenu = x;
        suivant = a;
    }


    public int getContenu() {
        return contenu;
    }

    public ListeInteger getSuivant() {
        return suivant;
    }

}
