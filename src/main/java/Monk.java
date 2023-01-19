public class Monk extends Hero{

    int mana;
    private Monk(String name, int attack, int defense, int[] damage, int health, int speed, int mana) {
        super(name, attack, defense, damage, health, speed);
        this.mana = mana;
    }

    public Monk() {
        super("Монах", 12, 7, new int[] {-4, -4}, 30, 5);
        this.mana = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }
}
