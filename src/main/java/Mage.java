public class Mage extends Healer{

    public Mage() {
        super("Колдун", 17, 12, new int[] {-5, -5}, 30, 9, 1);
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }

}
