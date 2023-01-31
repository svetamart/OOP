package units;

import java.util.List;

public class Spearman extends Hero{
    public Spearman(List<Hero> team, int x, int y) {

        super("Копейщик", 4, 5, new int[] {1, 3}, 10, 4, "Alive");
        super.team = team;
        super.position = new Vector2(x, y);
    }

//    @Override
//    public void step(List<Hero> list) {
//        if (status.equals("Alive")) {
//            List<Hero> targets = list.stream().filter(n -> n.getStatus().equals("Alive")).toList();
//            if (!targets.isEmpty()) {
//                Hero target = targets.get((getTarget(targets).get(1).intValue()));
//                System.out.printf("%s метнул копье в %s. \n", this.name, target.name);
//                target.health = target.health - this.damage;
//                if (target.health <= 0) {
//                    target.die();
//                }
//            }
//        }
//    }
}


