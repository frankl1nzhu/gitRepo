package TD_Maps;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Etudiant {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("Last name by jackson")
    private String nom;
    @JSONField(name = "First name by fastjson")
    private String prenom;
    private HashMap<String, Integer> notes = new HashMap<>();
    public void ajouterNote(String matiere, int note){
        notes.put(matiere, note);
    }

    public String afficheBulletin(){
        double res = 0.0;
        for (Map.Entry<String, Integer> entry: notes.entrySet()){
            res += entry.getValue();
        }
        res /= notes.size();
        return this.id+ " "+ this.nom +" "+ this.prenom + " " + this.notes + " Moyenne = " + res ;
    }

    @Override
    public String toString() {
        int res = 0;
        for (Map.Entry<String, Integer> entry: notes.entrySet()){
            res += entry.getValue();
        }
        res /= notes.size();
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", note moyenne=" + res +
                '}';
    }

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
