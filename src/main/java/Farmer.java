public class Farmer extends Hero{

    int delivery;

    private Farmer(String name, int attack, int defense, int[] damage, int health, int speed, int delivery) {
        super(name, attack, defense, damage, health, speed);
        this.delivery = delivery;
    }

    public Farmer() {
        super("Крестьянин", 1, 1, new int[] {1, 1}, 1, 3);
        this.delivery = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Delivery: " + this.delivery;
    }
}
