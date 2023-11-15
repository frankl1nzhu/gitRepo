package arbresBinaires;


public class Arbre {
    private int contenu;
    private Arbre fg;
    private Arbre fd;
    public void afficherInfixe(Arbre arbre){
        if (arbre != null){
            afficherInfixe(arbre.fg);
            System.out.println(arbre.contenu);
            afficherInfixe(arbre.fd);
        }
    }
    public void afficherPostfixe(Arbre arbre){
        if (arbre != null){
            afficherPostfixe(arbre.fg);
            afficherPostfixe(arbre.fd);
            System.out.println(arbre.contenu);
        }
    }
    public void afficherPrefixe(Arbre arbre){
        if (arbre != null){
            System.out.println(arbre.contenu);
            afficherPrefixe(arbre.fg);
            afficherPrefixe(arbre.fd);
        }
    }
    public int nombreDeFeuille(Arbre arbre){
        if(arbre.fg == null && arbre.fd == null){
            return 1;
        } else {
            return Math.max(1,nombreDeFeuille(arbre.fg)+nombreDeFeuille(arbre.fd));
        }
    }
    public int nombreDeNoeud(Arbre arbre){
        if (arbre == null) return 0;
        if (arbre.fg == null && arbre.fd == null){
            return 1;
        } else {
            return 1 + nombreDeNoeud(arbre.fg) + nombreDeNoeud(arbre.fd);
        }
    }

    public int somme(Arbre arbre){
        if (arbre.fg == null && arbre.fd == null){
            return arbre.contenu;
        } else {
            return arbre.contenu + somme(arbre.fg) + somme(arbre.fd);
        }
    }
    public Arbre(Arbre fg, int contenu, Arbre fd) {
        this.contenu = contenu;
        this.fg = fg;
        this.fd = fd;
    }
}
