import units.*;

import java.util.ArrayList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        int teamCount = 10;
        Random rand = new Random();

        ArrayList<Hero> teamOne = new ArrayList<>();
        ArrayList<Hero> teamTwo = new ArrayList<>();

        fillTeams(teamOne, rand, teamCount, 1);
        fillTeams(teamTwo, rand, teamCount, 2);

        System.out.println("\nСписок всех персонажей в команде:");
        teamTwo.forEach(System.out::println);

        System.out.println("\nПерсонажи с наименьшим уровнем здоровья:");
        teamTwo.forEach(n -> n.step(teamTwo));

        System.out.println("\nСписок всех персонажей после того, как каждый Маг в команде сделал свой ход:");
        teamTwo.forEach(System.out::println);

    }

    private static void fillTeams(ArrayList<Hero> team, Random rand, int teamCount, int number) {
        for (int i = 0; i < teamCount; i++) {
            int value = rand.nextInt(4);
            if (number == 1) {
                switch (value) {
                    case 0 -> team.add(new Farmer());
                    case 1 -> team.add(new Rogue());
                    case 2 -> team.add(new Sniper());
                    case 3 -> team.add(new Mage());
                }
            } else {
                switch (value) {
                    case 0 -> team.add(new Farmer());
                    case 1 -> team.add(new Arbalester());
                    case 2 -> team.add(new Monk());
                    case 3 -> team.add(new Spearman());
                }
            }
        }
    }
}



//        ArrayList<units.Hero> farmers = new ArrayList<>();
//        farmers.add(new units.Farmer());
//        farmers.add(new units.Farmer());
//        farmers.add(new units.Farmer());
//        farmers.add(new units.Farmer());
//        farmers.add(new units.Farmer());
//
//        ArrayList<units.Hero> rogues = new ArrayList<>();
//        rogues.add(new units.Rogue());
//        rogues.add(new units.Rogue());
//        rogues.add(new units.Rogue());
//        rogues.add(new units.Rogue());
//        rogues.add(new units.Rogue());
//
//        ArrayList<units.Hero> snipers = new ArrayList<>();
//        snipers.add(new units.Sniper());
//        snipers.add(new units.Sniper());
//        snipers.add(new units.Sniper());
//        snipers.add(new units.Sniper());
//        snipers.add(new units.Sniper());
//
//        ArrayList<units.Hero> mages = new ArrayList<>();
//        mages.add(new units.Mage());
//        mages.add(new units.Mage());
//        mages.add(new units.Mage());
//        mages.add(new units.Mage());
//        mages.add(new units.Mage());
//
//        ArrayList<units.Hero> spearmen = new ArrayList<>();
//        spearmen.add(new units.Spearman());
//        spearmen.add(new units.Spearman());
//        spearmen.add(new units.Spearman());
//        spearmen.add(new units.Spearman());
//        spearmen.add(new units.Spearman());
//
//        ArrayList<units.Hero> arbalesters = new ArrayList<>();
//        arbalesters.add(new units.Arbalester());
//        arbalesters.add(new units.Arbalester());
//        arbalesters.add(new units.Arbalester());
//        arbalesters.add(new units.Arbalester());
//        arbalesters.add(new units.Arbalester());
//
//
//        ArrayList<units.Hero> monks = new ArrayList<>();
//        monks.add(new units.Monk());
//        monks.add(new units.Monk());
//        monks.add(new units.Monk());
//        monks.add(new units.Monk());
//        monks.add(new units.Monk());
//
//
//        farmers.forEach(System.out::println);
//        System.out.println();
//        rogues.forEach(i -> System.out.println(i));
//        System.out.println();
//        snipers.forEach(System.out::println);
//        System.out.println();
//        mages.forEach(System.out::println);
//        System.out.println();
//        spearmen.forEach(System.out::println);
//        System.out.println();
//        monks.forEach(System.out::println);
//        System.out.println();
//        arbalesters.forEach(System.out::println);
//
//
//        int teamCount = 50;
//        Random rand = new Random();
//
//        List<units.Hero> team = new ArrayList<>();
//        for (int i = 0; i < teamCount; i++) {
//            int value = rand.nextInt(7);
//
//            switch (value) {
//                case 0 -> team.add(new units.Arbalester());
//                case 1 -> team.add(new units.Farmer());
//                case 2 -> team.add(new units.Mage());
//                case 3 -> team.add(new units.Monk());
//                case 4 -> team.add(new units.Rogue());
//                case 5 -> team.add(new units.Sniper());
//                case 6 -> team.add(new units.Spearman());
//            }
//        }
//
//        System.out.println();
//        getClass(team, "units.Monk");

//    static void getClass(List<units.Hero> team, String name) {
//        for (units.Hero hero : team) {
//            if (name.equals(hero.getClass().getSimpleName())) {
//                System.out.println(hero);
//            }
//        }
//    }

