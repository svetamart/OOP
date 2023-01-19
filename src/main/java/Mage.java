public class Mage extends Hero{

    int mana;
    private Mage(String name, int attack, int defense, int[] damage, int health, int speed, int mana) {
        super(name, attack, defense, damage, health, speed);
        this.mana = mana;
    }

    public Mage() {
        super("Колдун", 17, 12, new int[] {-5, -5}, 30, 9);
        this.mana = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }
}
