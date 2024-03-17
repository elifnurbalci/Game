public class Snake extends Obstacle{

    public Snake() {
        super(4,"Snake",randomDamage(3,6),12,0);
    }
    private static int randomDamage(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
