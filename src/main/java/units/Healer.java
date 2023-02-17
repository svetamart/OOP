package units;

import console.AnsiColors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Healer extends Hero {
     protected int mana = 1;

    protected Healer(String name, int attack, int defense, int[] damageRange, int maxHealth, int speed,
                     String status, int mana) {
        super(name, attack, defense, damageRange, maxHealth, speed, status);
        this.mana = mana;
    }

    @Override
    public void step(List<Hero> list) {
        setNum();
        if (this.mana == 0) {
            System.out.println(this.textColor + this.name + AnsiColors.ANSI_RESET + " пропускает ход.");
            this.mana = 1;
            return;
        }
        if (status.equals("Alive")) {
            for (Hero hero : team) {
                if (hero.getStatus().equals("Dead")) {
                    System.out.printf("%s%s%s воскрешает %s%s%s. ", this.textColor, this.name, AnsiColors.ANSI_RESET,
                            hero.textColor, hero.name, AnsiColors.ANSI_RESET);
                    int index = team.indexOf(hero);
                    List<Hero> teamTemp = new ArrayList<>();
                    switch (new Random().nextInt(7)) {
                        case 0 -> teamTemp.add(new Farmer(hero.team, hero.getPosition().x, hero.getPosition().y, hero.getTeamColor(), hero.textColor));
                        case 1 -> teamTemp.add(new Rogue(hero.team, hero.getPosition().x, hero.getPosition().y, hero.getTeamColor(), hero.textColor));
                        case 2 -> teamTemp.add(new Sniper(hero.team, hero.getPosition().x, hero.getPosition().y, hero.getTeamColor(), hero.textColor));
                        case 3 -> teamTemp.add(new Mage(hero.team, hero.getPosition().x, hero.getPosition().y, hero.getTeamColor(), hero.textColor));
                        case 4 -> teamTemp.add(new Arbalester(hero.team, hero.getPosition().x, hero.getPosition().y, hero.getTeamColor(), hero.textColor));
                        case 5 -> teamTemp.add(new Monk(hero.team, hero.getPosition().x, hero.getPosition().y, hero.getTeamColor(), hero.textColor));
                        case 6 -> teamTemp.add(new Spearman(hero.team, hero.getPosition().x, hero.getPosition().y, hero.getTeamColor(), hero.textColor));
                    }
                    Hero revived = teamTemp.get(0);
                    team.set(index, revived);
                    System.out.printf("Он вновь вступает в бой, но теперь как %s%s%s. \n",
                            revived.textColor, revived.name, AnsiColors.ANSI_RESET);
                    this.mana = 0;
                    return;
                }
            }

            List<Hero> targets = team.stream().filter(n -> n.status.equals("Alive"))
                    .sorted(Comparator.comparingInt(Hero::getHealthLevel)).toList();
//            List<Hero> targets = new ArrayList<>();
//            for (Hero hero: list) {
//                if (hero.status.equals("Alive")) {
//                    targets.add(hero);
//                }
//            }
//
//            Comparator<Hero> compareByHealthLevel = Comparator.comparing(Hero::getHealthLevel);
//            targets.sort(compareByHealthLevel);

            if (!targets.isEmpty()) {
                Hero mostDamaged = targets.get(0);
                if (mostDamaged.getHealth() != mostDamaged.maxHealth) {
                    mostDamaged.health = mostDamaged.health - this.damageRange[0];
                    if (mostDamaged.health > mostDamaged.maxHealth) {
                        mostDamaged.health = mostDamaged.maxHealth;
                    }

                    System.out.printf("%s%s%s вылечил %s%s%s. Текущее здоровье %s%s%s: %d/%d. \n",
                            this.textColor, this.name, AnsiColors.ANSI_RESET,
                            mostDamaged.textColor, mostDamaged.name, AnsiColors.ANSI_RESET,
                            mostDamaged.textColor, mostDamaged.name, AnsiColors.ANSI_RESET,
                            mostDamaged.getHealth(), mostDamaged.maxHealth);
                }
            }
        }
    }
}
