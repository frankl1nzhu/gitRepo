public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public void construct(){
        builder.reset();
        builder.buildEcaille();
        builder.buildBras();
        builder.buildYeux();
        builder.buildGluant();
        builder.buildPoils();
        builder.buildRegime();
    }
}
