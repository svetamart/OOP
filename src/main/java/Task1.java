import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Hero> farmers = new ArrayList<>();
        farmers.add(new Farmer());
        farmers.add(new Farmer());
        farmers.add(new Farmer());
        farmers.add(new Farmer());
        farmers.add(new Farmer());

        ArrayList<Hero> rogues = new ArrayList<>();
        rogues.add(new Rogue());
        rogues.add(new Rogue());
        rogues.add(new Rogue());
        rogues.add(new Rogue());
        rogues.add(new Rogue());

        ArrayList<Hero> snipers = new ArrayList<>();
        snipers.add(new Sniper());
        snipers.add(new Sniper());
        snipers.add(new Sniper());
        snipers.add(new Sniper());
        snipers.add(new Sniper());

        ArrayList<Hero> mages = new ArrayList<>();
        mages.add(new Mage());
        mages.add(new Mage());
        mages.add(new Mage());
        mages.add(new Mage());
        mages.add(new Mage());

        ArrayList<Hero> spearmen = new ArrayList<>();
        spearmen.add(new Spearman());
        spearmen.add(new Spearman());
        spearmen.add(new Spearman());
        spearmen.add(new Spearman());
        spearmen.add(new Spearman());

        ArrayList<Hero> arbalesters = new ArrayList<>();
        arbalesters.add(new Arbalester());
        arbalesters.add(new Arbalester());
        arbalesters.add(new Arbalester());
        arbalesters.add(new Arbalester());
        arbalesters.add(new Arbalester());


        ArrayList<Hero> monks = new ArrayList<>();
        monks.add(new Monk());
        monks.add(new Monk());
        monks.add(new Monk());
        monks.add(new Monk());
        monks.add(new Monk());


        farmers.forEach(System.out::println);
        System.out.println();
        rogues.forEach(i -> System.out.println(i));
        System.out.println();
        snipers.forEach(System.out::println);
        System.out.println();
        mages.forEach(System.out::println);
        System.out.println();
        spearmen.forEach(System.out::println);
        System.out.println();
        monks.forEach(System.out::println);
        System.out.println();
        arbalesters.forEach(System.out::println);


        int teamCount = 50;
        Random rand = new Random();

        List<Hero> team = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int value = rand.nextInt(7);

            switch (value) {
                case 0 -> team.add(new Arbalester());
                case 1 -> team.add(new Farmer());
                case 2 -> team.add(new Mage());
                case 3 -> team.add(new Monk());
                case 4 -> team.add(new Rogue());
                case 5 -> team.add(new Sniper());
                case 6 -> team.add(new Spearman());
            }
        }

        getInfo(team, "Sniper");
    }

    static void getInfo(List<Hero> team, String name) {
        for (Hero hero : team) {
            if (name.equals(hero.getClass().getSimpleName())) {
                System.out.println(hero);
            }
        }
    }
}
