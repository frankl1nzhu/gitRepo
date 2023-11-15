package TD_Maps;

import com.alibaba.fastjson.JSONObject;

public class Main {
    public static void main(String[] args) {
        Etudiant etudiant = new Etudiant(1, "LF", "AM");
        etudiant.ajouterNote("Math", 5);
        etudiant.ajouterNote("Anglais", 1);
        System.out.println(etudiant.afficheBulletin());

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(etudiant);
        System.out.println(jsonObject);

    }
}
