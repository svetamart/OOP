public class Rogue extends Hero{
    private Rogue(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);
    }

    public Rogue() {
        super("Разбойник", 8, 3, new int[] {2, 4}, 10, 6);
    }
}
