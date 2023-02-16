package units;

import java.util.ArrayList;
import java.util.List;

public class Monk extends Healer{

    public Monk(List<Hero> team, float x, float y, String teamColor, String textColor) {

        super("Монах", 12, 7, new int[] {-4, -4}, 30, 5, "Alive", 1);
        super.team = team;
        super.position = new Vector2(x, y);
        super.teamColor = teamColor;
        super.textColor = textColor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }
}
