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



//        ArrayList<Hero> farmers = new ArrayList<>();
//        farmers.add(new Farmer());
//        farmers.add(new Farmer());
//        farmers.add(new Farmer());
//        farmers.add(new Farmer());
//        farmers.add(new Farmer());
//
//        ArrayList<Hero> rogues = new ArrayList<>();
//        rogues.add(new Rogue());
//        rogues.add(new Rogue());
//        rogues.add(new Rogue());
//        rogues.add(new Rogue());
//        rogues.add(new Rogue());
//
//        ArrayList<Hero> snipers = new ArrayList<>();
//        snipers.add(new Sniper());
//        snipers.add(new Sniper());
//        snipers.add(new Sniper());
//        snipers.add(new Sniper());
//        snipers.add(new Sniper());
//
//        ArrayList<Hero> mages = new ArrayList<>();
//        mages.add(new Mage());
//        mages.add(new Mage());
//        mages.add(new Mage());
//        mages.add(new Mage());
//        mages.add(new Mage());
//
//        ArrayList<Hero> spearmen = new ArrayList<>();
//        spearmen.add(new Spearman());
//        spearmen.add(new Spearman());
//        spearmen.add(new Spearman());
//        spearmen.add(new Spearman());
//        spearmen.add(new Spearman());
//
//        ArrayList<Hero> arbalesters = new ArrayList<>();
//        arbalesters.add(new Arbalester());
//        arbalesters.add(new Arbalester());
//        arbalesters.add(new Arbalester());
//        arbalesters.add(new Arbalester());
//        arbalesters.add(new Arbalester());
//
//
//        ArrayList<Hero> monks = new ArrayList<>();
//        monks.add(new Monk());
//        monks.add(new Monk());
//        monks.add(new Monk());
//        monks.add(new Monk());
//        monks.add(new Monk());
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
//        List<Hero> team = new ArrayList<>();
//        for (int i = 0; i < teamCount; i++) {
//            int value = rand.nextInt(7);
//
//            switch (value) {
//                case 0 -> team.add(new Arbalester());
//                case 1 -> team.add(new Farmer());
//                case 2 -> team.add(new Mage());
//                case 3 -> team.add(new Monk());
//                case 4 -> team.add(new Rogue());
//                case 5 -> team.add(new Sniper());
//                case 6 -> team.add(new Spearman());
//            }
//        }
//
//        System.out.println();
//        getClass(team, "Monk");

//    static void getClass(List<Hero> team, String name) {
//        for (Hero hero : team) {
//            if (name.equals(hero.getClass().getSimpleName())) {
//                System.out.println(hero);
//            }
//        }
//    }

