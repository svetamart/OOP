package units;
import java.util.List;

public class Arbalester extends Archer{

   public Arbalester(List<Hero> team, int x, int y) {
        super("Арбалетчик", 6, 3, new int[] {2, 3}, 10, 4, "Alive", 16);
       super.team = team;
       super.position = new Vector2(x, y);}
}
