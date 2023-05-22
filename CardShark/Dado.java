import java.util.Random;

public class Dado {
    private int caras;
    private Random random;

    public Dado() {
        caras = 5;
        random = new Random();
    }

    public int lanzar() {
        return random.nextInt(caras) + 1;
    }
}