package game;

import console.AnsiColors;
import console.ConsoleView;
import units.*;

import java.util.*;

public class GameRounds {

    public static final int GANG_SIZE = 10;
    public static List<Hero> greenTeam;
    public static List<Hero> blueTeam;
    public static List<Hero> heroes;

    public static void init() {
        greenTeam = new ArrayList<>();
        blueTeam = new ArrayList<>();
        heroes = new ArrayList<>();

        int x = 1;
        int y = 1;

        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> greenTeam.add(new Farmer(greenTeam, x, y++, "green", AnsiColors.ANSI_GREEN));
                case 1 -> greenTeam.add(new Mage(greenTeam, x, y++, "green", AnsiColors.ANSI_GREEN));
                case 2 -> greenTeam.add(new Arbalester(greenTeam, x, y++, "green", AnsiColors.ANSI_GREEN));
                case 3 -> greenTeam.add(new Spearman(greenTeam, x, y++, "green", AnsiColors.ANSI_GREEN));
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> blueTeam.add(new Farmer(blueTeam, x, y++, "blue", AnsiColors.ANSI_BLUE));
                case 1 -> blueTeam.add(new Rogue(blueTeam, x, y++, "blue", AnsiColors.ANSI_BLUE));
                case 2 -> blueTeam.add(new Sniper(blueTeam, x, y++, "blue", AnsiColors.ANSI_BLUE));
                case 3 -> blueTeam.add(new Monk(blueTeam, x, y++, "blue", AnsiColors.ANSI_BLUE));
            }
        }

        heroes.addAll(greenTeam);
        heroes.addAll(blueTeam);

    }

    public static void round(Scanner scanner) {
        boolean running = true;
        while (running) {
            ConsoleView.view();
            if (!checkIfAllDead(blueTeam) || !checkIfAllDead(greenTeam)) {
                heroes.sort(Comparator.comparing(Hero::getSpeed, Comparator.reverseOrder()).thenComparing(Hero::getNum));
                for (Hero hero: heroes) {
                    if (hero.getTeamColor().equals("green")) {
                        hero.step(blueTeam);
                    }
                    else if (hero.getTeamColor().equals("blue")) {
                        hero.step(greenTeam);
                    }
                }
                scanner.nextLine();

            }

            if (checkIfAllDead(blueTeam)) {
                System.out.println(AnsiColors.ANSI_GREEN + "Победила команда Green Team");
                running = false;
            }
            if (checkIfAllDead(greenTeam)) {
                System.out.println(AnsiColors.ANSI_BLUE + "Победила команда Blue Team");
                running = false;
            }
            if (checkIfAllDead(blueTeam) && checkIfAllDead(greenTeam)) {
                System.out.println("Ни в одной из команд не осталось воинов");
                running = false;
            }
        }
    }

    public static boolean checkIfAllDead(List<Hero> team) {
        if (team.stream().allMatch(h -> h.getStatus().equals("Dead"))) {
            return true;
        }
        return false;
    }
}
