package recherche;

import java.util.Scanner;

public class RechercheBinaireTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] t = {1,5,9,12,15,21,29,31};
        System.out.println("Le nombre à rechercher est ");
        int f = in.nextInt();
        int result = RechercheBinaire.RechercheBinaire(t, 1, 8, f);

        if (result < 0){
            System.out.println("Le nombre n'est pas dans le tableau");
        } else {
            System.out.println("L'indice de " + f + " est " + result);
        }
    }
}
