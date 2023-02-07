//Добавить поведение (метод step) для лучников.
//        1.Если стрел больше нуля заглушка выстрел и уменьшение количества стрел
//        2.Проверить есть ли крестьяне и свободны ли хоть один из них.
//        Если да, то вернуть одну стрелу и сбросить флаг свободен у крестьянина.
//        3.Крестьяне должны уметь поднимать свой статус "свободен"
//        4.Сделать так, чтобы по нажатию Enter программа повторяла вывод на экран состояние персонажей и вызов метода step.

import units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        int teamCount = 10;
        Random rand = new Random();

        ArrayList<Hero> teamOneTemp = new ArrayList<>();
        ArrayList<Hero> teamTwoTemp = new ArrayList<>();

//        fillTeams(teamOneTemp, rand, teamCount, 1);
//        fillTeams(teamTwoTemp, rand, teamCount, 2);
//
//        ArrayList<Hero> teamOne = new ArrayList<>(sortTeams(teamOneTemp));
//        ArrayList<Hero> teamTwo = new ArrayList<>(sortTeams(teamTwoTemp));
//
//
//        Scanner scanner = new Scanner(System.in);
//
//        boolean enterPressed = true;
//
//        while (enterPressed) {
//            String enter = scanner.nextLine();
//            if(enter.equals("")) {
//                System.out.println("\nСписок всех персонажей в команде:");
//                teamTwo.forEach(System.out::println);
//                System.out.println();
//                teamTwo.forEach(n -> n.step(teamTwo));
//                System.out.println();
//            }
//            else {
//                enterPressed = false;
//            }
//        }
//    }
//
//    private static void fillTeams(ArrayList<Hero> team, Random rand, int teamCount, int number) {
//        for (int i = 0; i < teamCount; i++) {
//            int value = rand.nextInt(4);
//            if (number == 1) {
//                switch (value) {
//                    case 0 -> team.add(new Farmer());
//                    case 1 -> team.add(new Rogue());
//                    case 2 -> team.add(new Sniper());
//                    case 3 -> team.add(new Mage());
//                }
//            } else {
//                switch (value) {
//                    case 0 -> team.add(new Farmer());
//                    case 1 -> team.add(new Arbalester());
//                    case 2 -> team.add(new Monk());
//                    case 3 -> team.add(new Spearman());
//                }
//            }
//        }
//    }
//
//    private static ArrayList<Hero> sortTeams(ArrayList<Hero> teamTemp) {
//        ArrayList<Hero> farmers = new ArrayList<>();
//        ArrayList<Hero> players = new ArrayList<>();
//        ArrayList<Hero> team = new ArrayList<>();
//        for (Hero hero : teamTemp) {
//            if (hero.getClass().getSimpleName().equals("Farmer")) {
//                farmers.add(hero);
//            }
//            else {
//                players.add(hero);
//            }
//        }
//        team.addAll(players);
//        team.addAll(farmers);
//        return team;
    }
}
