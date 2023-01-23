package units;

import java.util.ArrayList;

public abstract class Healer extends Hero {
     protected int mana;

    protected Healer(String name, int attack, int defense, int[] damage, int maxHealth, int speed, int mana) {
        super(name, attack, defense, damage, maxHealth, speed);
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<Hero> list) {
        double min = list.get(0).getHealthLevel();
        Hero mostDamaged = list.get(0);
        for (Hero hero : list) {
            if (hero.getHealthLevel() < min) {
                min = hero.getHealthLevel();
                mostDamaged = hero;
            }
        }
        if (mostDamaged.health != mostDamaged.maxHealth) {
            System.out.printf("%s вылечил %s \n", this.name, mostDamaged.name);
            mostDamaged.health = mostDamaged.health - this.damage[0];
            if (mostDamaged.health > mostDamaged.maxHealth) {
                mostDamaged.health = mostDamaged.maxHealth;
            }
        }
    }
}
