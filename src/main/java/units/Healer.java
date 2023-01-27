package units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Healer extends Hero {
     protected int mana;

    protected Healer(String name, int attack, int defense, int[] damage, int maxHealth, int speed,
                     String status, int mana) {
        super(name, attack, defense, damage, maxHealth, speed, status);
        this.mana = mana;
    }

    @Override
    public void step(List<Hero> list) {
        if (status.equals("Alive")) {
            List<Hero> targets = team.stream().filter(n -> n.status.equals("Alive"))
                    .sorted(Comparator.comparingInt(Hero::getHealthLevel)).collect(Collectors.toList());
            if (!targets.isEmpty()) {
//                targets.forEach(System.out::println);
                Hero mostDamaged = targets.get(0);
//                System.out.println("Most damaged: " + mostDamaged.getName());
                if (mostDamaged.getHealthLevel() != mostDamaged.maxHealth) {
                    System.out.printf("%s вылечил %s. \n", this.name, mostDamaged.name);
                    mostDamaged.health = mostDamaged.health - this.damageRange[0];
                    if (mostDamaged.health > mostDamaged.maxHealth) {
                        mostDamaged.health = mostDamaged.maxHealth;
                    }
                }
            }
        }
    }
}
