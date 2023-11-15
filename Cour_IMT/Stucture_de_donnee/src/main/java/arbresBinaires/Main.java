package arbresBinaires;

public class Main {
    public static void main(String[] args) {

        /*Arbre arbre1 = new Arbre(new Arbre(new Arbre(null,20,null),10,
                new Arbre(null,30,null) ), 5, new Arbre(null,4,null));

        System.out.println("Afficher Infixe");
        arbre1.afficherInfixe(arbre1);
        System.out.println("****************************");

        System.out.println("Afficher post-fixe");
        arbre1.afficherPostfixe(arbre1);
        System.out.println("****************************");

        System.out.println("Afficher Préfixe");
        arbre1.afficherPrefixe(arbre1);
        System.out.println("****************************");

        System.out.println("Nombre de feuilles : " + arbre1.nombreDeFeuille(arbre1));
        System.out.println("Nombre de noeud : " + arbre1.nombreDeNoeud(arbre1));
        System.out.println("Somme des noeuds: " + arbre1.somme(arbre1));
        */


        //Arbre binaire de recherche
        ArbreBinaireDeRecherche a = new ArbreBinaireDeRecherche(null, 20, null);
        a.inserer(5,a);
        a.inserer(3,a);
        a.inserer(12,a);
        a.inserer(8,a);
        a.inserer(6,a);
        a.inserer(13,a);
        a.inserer(25,a);
        a.inserer(21,a);
        a.inserer(28,a);

        a.afficherInfixe(a);
        System.out.println(a.recherche(5,a));
        System.out.println(a.nombreDeNoeuds(a));
        System.out.println(a.sommeDesValeurs(a));
    }
}
