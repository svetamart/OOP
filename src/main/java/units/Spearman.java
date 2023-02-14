package units;

import java.util.List;

public class Spearman extends Melee{
    public Spearman(List<Hero> team, int x, int y) {

        super("Копейщик", 4, 5, new int[] {1, 3}, 10, 4, "Alive");
        super.team = team;
        super.position = new Vector2(x, y);
    }
}


