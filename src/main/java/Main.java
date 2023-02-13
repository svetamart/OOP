import units.*;

import java.util.*;

public class Main {
    public static final int GANG_SIZE = 10;
    public static List<Hero> greenTeam;
    public static List<Hero> blueTeam;

    public static void main(String[] args) {
        init();

//        blueTeam.forEach(System.out::println);
//        System.out.println();
//        greenTeam.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            ConsoleView.view();
            if (!checkIfAllDead(blueTeam) || !checkIfAllDead(greenTeam)) {
                System.out.println(AnsiColors.ANSI_BLUE + "Ходит команда Blue Team \n" + AnsiColors.ANSI_RESET);
                blueTeam.forEach(n -> n.step(greenTeam));
                System.out.println();
                System.out.println(AnsiColors.ANSI_GREEN + "Ходит команда Green Team \n" + AnsiColors.ANSI_RESET);
                greenTeam.forEach(n -> n.step(blueTeam));
                System.out.println();
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


    private static void init() {
        greenTeam = new ArrayList<>();
        blueTeam = new ArrayList<>();

        int x = 1;
        int y = 1;

        for (int i = 0; i < GANG_SIZE; i++) {
//            switch (new Random().nextInt(3)) {
//                case 0 -> greenTeam.add(new Farmer(greenTeam, x, y++));
//                case 1 -> greenTeam.add(new Rogue(greenTeam, x, y++));
//                case 2 -> greenTeam.add(new Spearman(greenTeam, x, y++));
////                case 3 -> greenTeam.add(new Mage(greenTeam, x, y++));
////                case 4 -> greenTeam.add(new Arbalester(greenTeam, x, y++));
//            }
            switch (new Random().nextInt(7)) {
                case 0 -> greenTeam.add(new Farmer(greenTeam, x, y++));
                case 1 -> greenTeam.add(new Rogue(greenTeam, x, y++));
                case 2 -> greenTeam.add(new Sniper(greenTeam, x, y++));
                case 3 -> greenTeam.add(new Mage(greenTeam, x, y++));
                case 4 -> greenTeam.add(new Arbalester(greenTeam, x, y++));
                case 5 -> greenTeam.add(new Monk(greenTeam, x, y++));
                case 6 -> greenTeam.add(new Spearman(greenTeam, x, y++));
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
//            switch (new Random().nextInt(3)) {
//                case 0 -> blueTeam.add(new Farmer(blueTeam, x, y++));
//                case 1 -> blueTeam.add(new Rogue(blueTeam, x, y++));
//                case 2 -> blueTeam.add(new Spearman(blueTeam, x, y++));
////                case 3 -> blueTeam.add(new Mage(blueTeam, x, y++));
////                case 4 -> blueTeam.add(new Arbalester(blueTeam, x, y++));
//            }
            switch (new Random().nextInt(7)) {
                case 0 -> blueTeam.add(new Farmer(blueTeam, x, y++));
                case 1 -> blueTeam.add(new Rogue(blueTeam, x, y++));
                case 2 -> blueTeam.add(new Sniper(blueTeam, x, y++));
                case 3 -> blueTeam.add(new Mage(blueTeam, x, y++));
                case 4 -> blueTeam.add(new Arbalester(blueTeam, x, y++));
                case 5 -> blueTeam.add(new Monk(blueTeam, x, y++));
                case 6 -> blueTeam.add(new Spearman(blueTeam, x, y++));
            }
        }

        Comparator<Hero> compareBySpeed = Comparator.comparing(Hero::getSpeed).reversed();
        greenTeam.sort(compareBySpeed);
        blueTeam.sort(compareBySpeed);

//        greenTeam = greenTeam.stream().sorted(Comparator.comparingInt(Hero::getSpeed).reversed()).toList();
//        blueTeam = blueTeam.stream().sorted(Comparator.comparingInt(Hero::getSpeed).reversed()).toList();
    }

    public static boolean checkIfAllDead(List<Hero> team) {
        if (team.stream().allMatch(h -> h.getStatus().equals("Dead"))) {
            return true;
        }
        return false;
    }


}

