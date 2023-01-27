package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rogue extends Hero{
    public Rogue(List<Hero> team, int x, int y) {
        super("Разбойник", 8, 3, new int[] {2, 4}, 10, 6, "Alive");
        super.team = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(List<Hero> list) {
        if (status.equals("Alive")) {
            List<Hero> targets = list.stream().filter(n -> n.getStatus().equals("Alive")).toList();
            if (!targets.isEmpty()) {
                Hero target = targets.get(new Random().nextInt(targets.size()));
                System.out.printf("%s нанес удар %s. \n", this.name, target.name);
                target.health = target.health - this.damage;
                if (target.health <= 0) {
                    target.die();
                }
            }
        }
    }
}
