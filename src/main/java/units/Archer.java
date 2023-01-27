package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Archer extends Hero{
    int shots;
    int maxShots;
    protected Archer(String name, int attack, int defense, int[] damage,
                     int maxHealth, int speed, String status, int maxShots) {
        super(name, attack, defense, damage, maxHealth, speed, status);
        this.maxShots = maxShots;
        this.shots = maxShots;
    }



    @Override
    public String toString() {
        return super.toString() + ", Shots: " + shots;
    }

    @Override
    public String getInfo() {

        if (this.status.equals("Alive")) {
            return super.getInfo() + "   \uD83C\uDFF9 " + shots;
        }
        return super.getInfo();
    }

    @Override
    public void step(List<Hero> list) {
        if (this.status.equals("Alive")) {
            List<Farmer> farmers = new ArrayList<>();
            for (Hero hero : team) {
                if (hero.role.equals("Farmer") && hero.status.equals("Alive")) {
                    farmers.add((Farmer) hero);
                }
            }

            List<Hero> targets = list.stream().filter(n -> n.status.equals("Alive")).toList();

            if (shots > 0 && !targets.isEmpty()) {
                shots--;
                Hero target = targets.get(new Random().nextInt(targets.size()));
                    System.out.printf("%s выстрелил в %s. \n", this.name, target.name);
                    target.health = target.health - this.damage;
                    if (target.health <= 0) {
                        target.die();
                    }
                    for (Farmer hero : farmers) {
                        if (hero.delivery == 1) {
                            shots++;
                            System.out.printf("%s принес стрелу %s. \n",
                                    hero.name, this.name);
                            hero.delivery = 0;
                            break;
                        }
                    }
                } else {
                    System.out.printf("У %s закончились стрелы. \n", this.name);
                }
            }
    }
}
