public class Monstre implements Product{
    private int yeux;
    private int bras;
    private boolean ecailles;
    private boolean poils;
    private boolean gluant;
    private String regime;
    public Product createClone(){
        Product p = null;
        try{
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

    public int getYeux() {
        return yeux;
    }

    public void setYeux(int yeux) {
        this.yeux = yeux;
    }

    public int getBras() {
        return bras;
    }

    public void setBras(int bras) {
        this.bras = bras;
    }

    public boolean isEcailles() {
        return ecailles;
    }

    public void setEcailles(boolean ecailles) {
        this.ecailles = ecailles;
    }

    public boolean isPoils() {
        return poils;
    }

    @Override
    public String toString() {
        return "Monstre{" +
                "yeux=" + yeux +
                ", bras=" + bras +
                ", ecailles=" + ecailles +
                ", poils=" + poils +
                ", gluant=" + gluant +
                ", regime='" + regime + '\'' +
                '}';
    }

    public void setPoils(boolean poils) {
        this.poils = poils;
    }

    public boolean isGluant() {
        return gluant;
    }

    public void setGluant(boolean gluant) {
        this.gluant = gluant;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }
}
