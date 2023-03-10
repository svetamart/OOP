package units;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends Hero{

    protected int delivery;

    public Farmer(List<Hero> team, float x, float y, String teamColor, String textColor) {
        super("Крестьянин", 1, 1, new int[] {1, 1}, 1, 3, "Alive");
        this.delivery = 1;
        super.team = team;
        super.position = new Vector2(x, y);
        super.teamColor = teamColor;
        super.textColor = textColor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Delivery: " + this.delivery;
    }

    @Override
    public void step(List<Hero> list) {
        setNum();
        if (status.equals("Alive")) {
            delivery = 1;
        }
    }
}
