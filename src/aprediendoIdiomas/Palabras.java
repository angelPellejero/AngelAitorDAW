package aprediendoIdiomas;

public class Palabras {

    private String español, ingles, frances;

    public Palabras(String español, String ingles, String frances) {
        this.español = español;
        this.ingles = ingles;
        this.frances = frances;
    }

    public String getEspañol() {
        return español;
    }

    public String getIngles() {
        return ingles;
    }

    public String getFrances() {
        return frances;
    }

    public void setEspañol(String español) {
        this.español = español;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public void setFrances(String frances) {
        this.frances = frances;
    }

}
