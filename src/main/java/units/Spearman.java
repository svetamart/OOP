package units;

import java.util.List;

public class Spearman extends Melee{
    public Spearman(List<Hero> team, float x, float y, String teamColor, String textColor) {

        super("Копейщик", 4, 5, new int[] {1, 3}, 10, 4, "Alive");
        super.team = team;
        super.position = new Vector2(x, y);
        super.teamColor = teamColor;
        super.textColor = textColor;
    }
}


