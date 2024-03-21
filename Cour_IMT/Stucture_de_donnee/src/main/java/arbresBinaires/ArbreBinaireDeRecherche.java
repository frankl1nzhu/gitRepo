package arbresBinaires;

public class ArbreBinaireDeRecherche {
    private int contenu ;
    ArbreBinaireDeRecherche filsG , filsD ;
    ArbreBinaireDeRecherche( ArbreBinaireDeRecherche g , int c , ArbreBinaireDeRecherche d ) {
        filsG = g ;
        contenu = c;
        filsD = d ;
    }
    public void afficherInfixe(ArbreBinaireDeRecherche a){
        if (a != null){
            afficherInfixe(a.filsG);
            System.out.println(a.contenu);
            afficherInfixe(a.filsD);
        }
    }

    public ArbreBinaireDeRecherche inserer(int n, ArbreBinaireDeRecherche a){
        if (a == null){
            return new ArbreBinaireDeRecherche(null, n,null);
        } else if (n < a.contenu) {
            a.filsG = inserer(n, a.filsG);
        } else if (n > a.contenu){
            a.filsD = inserer(n, a.filsD);
        } else {
            return null;
        }
        return a;
    }
    public Boolean recherche(int n, ArbreBinaireDeRecherche a){
        if (a == null){
            return false;
        }
        if (n == a.contenu){
            return true;
        } else if (n < a.contenu) {
            return recherche(n, a.filsG);
        } else {
            return recherche(n, a.filsD);
        }
    }

    public int nombreDeNoeuds(ArbreBinaireDeRecherche a){
        if (a==null) {
            return 0;
        }
        if (a.filsG == null && a.filsD==null){
            return 1;
        } else {
            return nombreDeNoeuds(a.filsG) + nombreDeNoeuds(a.filsD) + 1;
        }
    }

    public int sommeDesValeurs(ArbreBinaireDeRecherche a){
        if (a==null) {
            return 0;
        }
        if (a.filsG == null && a.filsD==null){
            return a.contenu;
        } else {
            return a.contenu + sommeDesValeurs(a.filsG) + sommeDesValeurs(a.filsD);
        }
    }



}
