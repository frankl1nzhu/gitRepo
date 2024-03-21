public class MonstreTresEffrayantBuilder implements Builder {
    private Monstre monstre;
    public void reset() {
        this.monstre = new Monstre();
    }
    public void buildEcaille(){
        monstre.setEcailles(true);
    }
    public void buildBras(){
        monstre.setBras(10);
    }
    public void buildYeux(){
        monstre.setYeux(3);
    }
    public void buildGluant(){
        monstre.setGluant(true);
    }
    public void buildPoils(){
        monstre.setPoils(false);
    }
    public void buildRegime(){
        monstre.setRegime("Vegan");
    }
    public Monstre getResult() {
        return monstre;
    }
}
