package Exo2;

import Exo2.site.Site;
import Exo2.site.SitePC;
import Exo2.site.SiteServeur;

public class Main {
    public static void main(String[] args) {
        Commande commande1 = new Commande("PC");
        Site sitePC = new SitePC();
        sitePC.traiterCommandes(commande1);

        System.out.println("**************************");

        Commande commande2 = new Commande("Serveur");
        Site siteServeur = new SiteServeur();
        siteServeur.traiterCommandes(commande2);
    }
}
