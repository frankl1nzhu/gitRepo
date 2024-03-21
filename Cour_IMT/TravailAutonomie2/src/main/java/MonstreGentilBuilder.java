public class MonstreGentilBuilder implements Builder{
    private Monstre monstre;
    public void reset() {
        this.monstre = new Monstre();
    }
    public void buildEcaille(){
        monstre.setEcailles(false);
    }
    public void buildBras(){
        monstre.setBras(2);
    }
    public void buildYeux(){
        monstre.setYeux(2);
    }
    public void buildGluant(){
        monstre.setGluant(false);
    }
    public void buildPoils(){
        monstre.setPoils(true);
    }
    public void buildRegime(){
        monstre.setRegime("Normal");
    }
    public Monstre getResult() {
        return monstre;
    }

}
