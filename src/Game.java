import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    private static Characteristic player = null;
    private static Battle battle = null;
    private static String string;
    private static Scanner scanner;
    private static Bench bench;

    public static void main(String[] args) {
        scanner = new Scanner(new InputStreamReader(System.in));
        battle = new Battle();
//        bench = new Bench("Banny",1,50,1,1,1,10);

        System.out.println("Назовите имя персонажа: ");
        String s = scanner.nextLine();
        System.out.println("Приветствуем героя " + s + "!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Куда хотите отпрвиться герой?");
        printNavigation();
        try {
            command(scanner.nextLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printNavigation() {
        String l = "1) В лавку";
        String t = "2) В тёмный лес";
        String g = "3) Выход";
        String[] way = new String[3];
        way[0] = l;
        way[1] = t;
        way[2] = g;
        for (int x = 0; x < way.length; x++)
            System.out.println(way[x]);
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(
                    string,
                    100,
                    10,
                    10,
                    0,
                    5
            );
        }
        switch (string) {
            case ("1"): {
//                commitBench();
                System.out.println("Торговец ещё не вышел на работу.");
                printNavigation();
                command(scanner.nextLine());
            }
            break;
            case ("2"): {
                commitFight();


            }
            break;

            case ("3"):
                System.exit(3);

        }
    }

    private static void commitBench() {
        Thread thread = new Thread();
        bench.sele(Bench.Things.POTION);
        System.out.println("Получено зелье!" + Bench.Things.POTION);
        System.out.println("Куда желаете отправиться дальше?");
        printNavigation();
        try {
            command(scanner.nextLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static void commitFight() {
        battle.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getExperience(), player.getGold_coins(), player.getHealth()));
                System.out.println("Куда желаете отправиться дальше?");
                printNavigation();
                try {
                    command(scanner.nextLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static Characteristic createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }


    public interface FightCallback {
        void fightWin();

        void fightLost();
    }
}


