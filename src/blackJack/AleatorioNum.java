package blackJack;

public class AleatorioNum {

    public static int dameAleatorio(int i, int f) {
        return (int) Math.floor(Math.random() * (f - i + 1) + i);
    }
}
