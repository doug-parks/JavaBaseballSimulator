

/**
 * Created by djp4830 on 4/22/17.
 */
public class BaseballGame {

    Team team1;
    Team team2;

    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RESET = "\u001B[0m";


    public BaseballGame(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void play() {

        int inning = 1;
        boolean gameTied = false;

        do {
            System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[Inning # " + inning + " - " + team1.teamName + ": "
                    + team1.score + " " + team2.teamName + ": " + team2.score + "] " + ANSI_RESET);
            playInning();
            if (team1.score == team2.score) {
                gameTied = true;
            } else {
                gameTied = false;
            }
            inning++;

        } while ((inning < 10 || gameTied));

        if (team1.score > team2.score) {
            System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[" + team1.teamName +
                    " win the game! Final score: " + team1.score + " to " + team2.score + "]");
        } else {
            System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[" + team2.teamName +
                    " win the game! Final score: " + team2.score + " to " + team1.score + "]");
        }
    }

    public void playInning() {
        //create a new inning object
        Inning inning = new Inning();

        //each team plays an inning
        inning.playHalfInning(team1);
        inning.playHalfInning(team2);
    }
}
