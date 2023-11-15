package listeChainee;

public class ListeIntegerTest {
    public static void main(String[] args) {
        ListeInteger head = new ListeInteger(20, null);
        ListeInteger newnoeud = new ListeInteger(8, null);
        newnoeud.suivant = head;
        head = newnoeud;
        int contenu = head.getContenu();
        ListeInteger.afficher(head);
        ListeInteger p = head;
        ListeInteger q = head.suivant;
        ListeInteger r = q.suivant;
        int myval= q.contenu;
        System.out.println(myval);
    }

}
