package units;

import java.util.ArrayList;
import java.util.List;

public class Sniper extends Archer{

    public Sniper(List<Hero> team, int x, int y) {
        super("Снайпер", 10, 8, new int[] {6, 8}, 15, 9, "Alive", 32);
        super.team = team;
        super.position = new Vector2(x, y);
    }
}
