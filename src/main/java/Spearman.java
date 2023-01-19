public class Spearman extends Hero{
    private Spearman(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);
    }

    public Spearman() {
        super("Копейщик", 4, 5, new int[] {1, 3}, 10, 4);
    }
}
