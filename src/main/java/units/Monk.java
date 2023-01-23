package units;

public class Monk extends Healer{

    public Monk() {
        super("Монах", 12, 7, new int[] {-4, -4}, 30, 5, 1);
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }
}
