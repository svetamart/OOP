package units;

import console.AnsiColors;

import java.util.ArrayList;
import java.util.List;

public abstract class Archer extends Hero{
    int shots;
    int maxShots;
    protected Archer(String name, int attack, int defense, int[] damageRange,
                     int maxHealth, int speed, String status, int maxShots) {
        super(name, attack, defense, damageRange, maxHealth, speed, status);
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
        setNum();
        if (this.status.equals("Alive")) {
            List<Farmer> farmers = new ArrayList<>();
            for (Hero hero : team) {
                if (hero.role.equals("Farmer") && hero.status.equals("Alive")) {
                    farmers.add((Farmer) hero);
                }
            }

//            List<Hero> targets = list.stream().filter(n -> n.status.equals("Alive")).toList();
            List<Hero> targets = new ArrayList<>();
            for (Hero hero: list) {
                if (hero.status.equals("Alive")) {
                    targets.add(hero);
                }
            }

            if (shots > 0 && !targets.isEmpty()) {
                shots--;
                Hero target = targets.get(((int) getTarget(targets)[1]));
                float targetDistance = getTarget(targets)[0];
                System.out.printf("%s%s%s выстрелил в %s%s%s. \n",
                        this.textColor, this.name, AnsiColors.ANSI_RESET,
                        target.textColor, target.name, AnsiColors.ANSI_RESET);

                float constMin = 12;
                float constMax = 4;
                float attackPower;

                if (targetDistance <= constMax) {
                    attackPower = damageRange[1];
                }
                else if (targetDistance >= constMin) {
                    attackPower = damageRange[0];
                }
                else {
                    attackPower = damageRange[0] +
                            ((targetDistance - constMax) / (constMin - constMax)) * (damageRange[1] - damageRange[0]);
                }

                target.takeDamage(attackPower, this);

                for (Farmer hero : farmers) {
                    if (hero.delivery == 1) {
                        shots++;
                        System.out.printf("%s%s%s принес стрелу %s%s%s. \n",
                                this.textColor, hero.name, AnsiColors.ANSI_RESET,
                                this.textColor, this.name, AnsiColors.ANSI_RESET);
                        hero.delivery = 0;
                        break;
                    }
                }
            } else if (shots <= 0) {
                System.out.printf("%s%s%s не может стрелять. Закончились стрелы. \n", this.textColor, this.name, AnsiColors.ANSI_RESET);
            }
        }
    }
}
