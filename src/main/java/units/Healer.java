package units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Healer extends Hero {
     protected int mana;

    protected Healer(String name, int attack, int defense, int[] damageRange, int maxHealth, int speed,
                     String status, int mana) {
        super(name, attack, defense, damageRange, maxHealth, speed, status);
        this.mana = mana;
    }

    @Override
    public void step(List<Hero> list) {
        if (status.equals("Alive")) {
//            List<Hero> targets = team.stream().filter(n -> n.status.equals("Alive"))
//                    .sorted(Comparator.comparingInt(Hero::getHealthLevel)).collect(Collectors.toList());

            List<Hero> targets = new ArrayList<>();
            for (Hero hero: list) {
                if (hero.status.equals("Alive")) {
                    targets.add(hero);
                }
            }

            Comparator<Hero> compareByHealthLevel = Comparator.comparing(Hero::getHealthLevel);
            targets.sort(compareByHealthLevel);


            if (!targets.isEmpty()) {
//                targets.forEach(System.out::println);
                Hero mostDamaged = targets.get(0);
//                System.out.println("Most damaged: " + mostDamaged.getName());
                if (mostDamaged.getHealth() != mostDamaged.maxHealth) {
                    System.out.printf("%s вылечил %s. Текущее здоровье %s: %d/%d. \n",
                            this.name, mostDamaged.name, mostDamaged.name, mostDamaged.getHealth(), mostDamaged.maxHealth);
                    mostDamaged.health = mostDamaged.health - this.damageRange[0];
                    if (mostDamaged.health > mostDamaged.maxHealth) {
                        mostDamaged.health = mostDamaged.maxHealth;
                    }
                }
            }
        }
    }
}
