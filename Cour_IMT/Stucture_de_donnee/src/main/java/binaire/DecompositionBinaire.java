package binaire;

import java.util.Scanner;

public class DecompositionBinaire {

    public static void afficheBin(int n){
        String result = "";
        if (n == 0){
            System.out.println("Vide");
        }
        while (n > 0){
            result = n % 2 + result;
            n = n / 2;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Le nombre à transformer: ");
        int input = in.nextInt();
        afficheBin(input);
    }
}
