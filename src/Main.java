import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {

        players.add(new Player("Anna", 30));
        players.add(new Player("Anna", 29));
        players.add(new Player("Anna", 28));
        players.add(new Player("Anna", 27));

        Scanner scanner = new Scanner(System.in);

        Comparator<Player> comparator = null;
        Comparator<Player> comparatorS = null;

        while (true) {
            System.out.println("""
                    1. sort by name
                    2. sort by age
                    3. print""");

            String type = null;

            switch (scanner.nextInt()) {
                case 1:
                    type = "name";
                    comparatorSort(type);
                    break;
                case 2:
                    type = "age";
                    comparatorSort(type);
                    break;
                case 3:
                    for (Player player : players) {
                        System.out.println(player);
                    }
            }

            if (type != null) {
                System.out.println("""
                        S
                        1. name
                        2. age""");
                switch (scanner.nextInt()) {
                    case 1:
                        comparatorSort(type, "name");
                        break;
                    case 2:
                        comparatorSort(type, "age");
                        break;
                }
            }

        }


    }

    public static void comparatorSort(String type) {

        Comparator<Player> comparator = comparatorSelection(type);

        Collections.sort(players, comparator);
    }

    public static void comparatorSort(String type, String sType) {

        Comparator<Player> comparator = comparatorSelection(type);
        Comparator<Player> comparatorS = comparatorSelection(sType);

        Collections.sort(players, comparator.thenComparing(comparatorS));
    }

    public static Comparator<Player> comparatorSelection(String type) {
        return switch (type) {
            case "name" -> new NameComparator();
            case "age" -> new AgeComparator();
            default -> null;
        };
    }
}
