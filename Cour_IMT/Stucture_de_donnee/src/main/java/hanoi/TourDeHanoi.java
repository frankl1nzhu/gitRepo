package hanoi;

import java.util.Scanner;

public class TourDeHanoi {

    static int m = 0;
    public static void move(int disks,char N,char M){
        System.out.println("La " + (++m) +" fois : "
                + N +" -> " + M);
    }


    public static void hanoi(int n, char A, char B, char C){
        if (n == 1){
            TourDeHanoi.move(1, A, C);
        } else {
            hanoi(n-1, A, C, B);
            TourDeHanoi.move(n, A, C);
            hanoi(n-1, B, A, C);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("Nombre de disks: ");
        int disk = in.nextInt();
        hanoi(disk, A, B, C);
    }
}