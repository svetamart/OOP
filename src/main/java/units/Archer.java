package units;

import java.util.ArrayList;

public abstract class Archer extends Hero{
    int shots;
    int maxShots;
    protected Archer(String name, int attack, int defense, int[] damage, int maxHealth, int speed, int maxShots) {
        super(name, attack, defense, damage, maxHealth, speed);
        this.maxShots = maxShots;
        this.shots = maxShots;
    }


    @Override
    public String toString() {
        return super.toString() + ", Shots: " + shots;
    }

    @Override
    public void step(ArrayList<Hero> list) {
        ArrayList<Farmer> farmers = new ArrayList<>();
        for (Hero hero: list) {
            if(hero.role.equals("Farmer")) {
                farmers.add((Farmer) hero);
            }
        }
        if (shots > 0) {
            shots--;
            System.out.printf("%s выстрелил. У него осталось %d стрел. \n", this.name, this.shots);
            for (Farmer hero: farmers) {
                if (hero.delivery == 1) {
                    shots++;
                    System.out.printf("%s принес стрелу %s. Теперь у %s %d стрел. \n",
                            hero.name, this.name, this.name, this.shots);
                    hero.delivery = 0;
                    break;
                }
            }
        }
        else {
            System.out.printf("У %s закончились стрелы. \n", this.name);
        }

    }
}
