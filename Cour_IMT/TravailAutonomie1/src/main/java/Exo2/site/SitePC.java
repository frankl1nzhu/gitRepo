package Exo2.site;

import Exo2.Commande;
import Exo2.machine.Machine;
import Exo2.machine.PC;

public class SitePC implements Site{
    @Override
    public Machine creerMachine() {
        return new PC();
    }

    @Override
    public void traiterCommandes(Commande commandes) {
        Machine machine = creerMachine();
        machine.assembler();
        System.out.println("Traiter commande à site PC...");
    }
}
