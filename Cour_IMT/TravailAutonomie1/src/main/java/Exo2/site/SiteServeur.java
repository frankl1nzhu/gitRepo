package Exo2.site;

import Exo2.Commande;
import Exo2.machine.Machine;
import Exo2.machine.Serveur;

public class SiteServeur implements Site{
    @Override
    public Machine creerMachine() {
        return new Serveur();
    }

    @Override
    public void traiterCommandes(Commande commandes) {
        Machine machine = creerMachine();
        machine.assembler();
        System.out.println("Traiter commande à site serveur...");
    }
}
