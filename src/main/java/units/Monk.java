package units;

import java.util.ArrayList;
import java.util.List;

public class Monk extends Healer{

    public Monk(List<Hero> team, int x, int y) {

        super("Монах", 12, 7, new int[] {-4, -4}, 30, 5, "Alive", 1);
        super.team = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }
}
