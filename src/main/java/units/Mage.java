package units;

import java.util.ArrayList;
import java.util.List;

public class Mage extends Healer{

    public Mage(List<Hero> team, float x, float y, String teamColor, String textColor) {
        super("Колдун", 17, 12, new int[] {-5, -5}, 30, 9, "Alive", 1);
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
