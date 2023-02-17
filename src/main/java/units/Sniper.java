package units;

import java.util.ArrayList;
import java.util.List;

public class Sniper extends Archer{

    public Sniper(List<Hero> team, float x, float y, String teamColor, String textColor) {
        super("Снайпер", 10, 8, new int[] {6, 8}, 15, 9, "Alive", 32);
        super.team = team;
        super.position = new Vector2(x, y);
        super.teamColor = teamColor;
        super.textColor = textColor;
    }
}
