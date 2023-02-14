package units;

import java.util.List;

public class Rogue extends Melee{
    public Rogue(List<Hero> team, int x, int y) {
        super("Разбойник", 8, 3, new int[] {2, 4}, 10, 6, "Alive");
        super.team = team;
        super.position = new Vector2(x, y);
    }

}
