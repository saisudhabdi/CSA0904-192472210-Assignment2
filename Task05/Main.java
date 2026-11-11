
import java.util.*;

class Player {
    String name;
    int points;
    int goalDifference;

    Player(String name, int points, int goalDifference) {
        this.name = name;
        this.points = points;
        this.goalDifference = goalDifference;
    }

    @Override
    public String toString() {
        return name + " - Points: " + points
                + ", Goal Difference: " + goalDifference;
    }
}

class Leaderboard<T> {

    private List<T> players = new ArrayList<>();

    public void addPlayer(T player) {
        players.add(player);
    }

    public void display(Comparator<T> comparator) {
        players.sort(comparator);

        for (T player : players) {
            System.out.println(player);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Leaderboard<Player> leaderboard = new Leaderboard<>();

        leaderboard.addPlayer(new Player("Arun", 20, 8));
        leaderboard.addPlayer(new Player("Bala", 25, 10));
        leaderboard.addPlayer(new Player("Kiran", 20, 12));
        leaderboard.addPlayer(new Player("David", 20, 12));
        leaderboard.addPlayer(new Player("Ravi", 15, 5));

        Comparator<Player> ranking = (p1, p2) -> {
            int result = Integer.compare(p2.points, p1.points);

            if (result == 0) {
                result = Integer.compare(
                        p2.goalDifference, p1.goalDifference);
            }

            if (result == 0) {
                result = p1.name.compareTo(p2.name);
            }

            return result;
        };

        System.out.println("CORRECT LEADERBOARD");
        System.out.println("-------------------");

        leaderboard.display(ranking);

        System.out.println("\nFAULTY COMPARATOR TEST");
        System.out.println("----------------------");

        Comparator<Player> faultyRanking =
                (p1, p2) -> p2.points - p1.points;

        leaderboard.display(faultyRanking);
    }
}
