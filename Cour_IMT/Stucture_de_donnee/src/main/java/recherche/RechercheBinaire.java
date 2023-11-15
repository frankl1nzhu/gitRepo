package recherche;

public class RechercheBinaire {
    public static int RechercheBinaire(int[] s, int i, int j, int f){
        if (i > j){
            return -1;
        }

        int k = (i+j)/2;

        if (f > s[j-1] || f < s[i-1]){
            return -1;
        }

        if(f == s[k]){
            return k;
        } else if (f < s[k]) {
            j = k-1;
        } else {
            i = k+1;
        }

        return RechercheBinaire(s, i, j, f);
    }
}
