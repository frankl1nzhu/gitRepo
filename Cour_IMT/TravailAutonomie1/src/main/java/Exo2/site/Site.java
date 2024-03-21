package Exo2.site;

import Exo2.Commande;
import Exo2.machine.Machine;

public interface Site {
    Machine creerMachine();
    void traiterCommandes(Commande commandes);
}
