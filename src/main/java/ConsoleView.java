import units.Vector2;

import java.util.Collections;

public class ConsoleView {
    private static int step = 1;
    private static final String top10 = formateDiv("a") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-b"))) + formateDiv("-c");
    private static final String mid10 = formateDiv("d") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-e"))) + formateDiv("-f");
    private static final String bott10 = formateDiv("g") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-h"))) + formateDiv("-i");

    public static void view(){

        if (ConsoleView.step == 1 ){
            System.out.println(AnsiColors.ANSI_GREEN + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.println("Step " + step + ".");
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getHeroChar(new Vector2(j,i)));
            }
//            System.out.println("|");
            System.out.println();
//            System.out.println(Main.darkSide.get(i).getInfo());
            System.out.println(ConsoleView.mid10);
        }
        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getHeroChar(new Vector2(j,Main.GANG_SIZE)));
        }
//        System.out.println("|");
        System.out.println();
        System.out.println(ConsoleView.bott10);
//        System.out.println("Press Enter");


    }

    private static String formateDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getHeroChar(Vector2 position){
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.blueTeam.get(i).getPosition().isEqual(position)) {
                str = "|" + AnsiColors.ANSI_BLUE + Main.blueTeam.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET + "|"
                        + " ".repeat(3) + AnsiColors.ANSI_GREEN + Main.greenTeam.get(i).getInfo() + AnsiColors.ANSI_RESET
                        + " ".repeat(5) + AnsiColors.ANSI_BLUE + Main.blueTeam.get(i).getInfo() + AnsiColors.ANSI_RESET;
            }


            if (Main.greenTeam.get(i).getPosition().isEqual(position)){
                str = "|" + AnsiColors.ANSI_GREEN + Main.greenTeam.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
            }

        }
        return str;
    }
}
