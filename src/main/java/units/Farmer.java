package units;

import java.util.ArrayList;

public class Farmer extends Hero{

    protected int delivery;

    public Farmer() {
        super("Крестьянин", 1, 1, new int[] {1, 1}, 1, 3);
        this.delivery = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Delivery: " + this.delivery;
    }

    @Override
    public void step(ArrayList<Hero> list) {
        delivery = 1;
    }
}
