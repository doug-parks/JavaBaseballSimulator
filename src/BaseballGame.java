

/**
 * Created by djp4830 on 4/22/17.
 */
public class BaseballGame {

    Team team1;
    Team team2;

    public  static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public  static final String ANSI_BLACK = "\u001B[30m";
    public  static final String ANSI_RESET = "\u001B[0m";


    public BaseballGame(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void play() {

        int inningCounter = 1;
        boolean gameTied = false;

        do {
            System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[Inning # " + inningCounter + " - " + team1.teamName + ": "
                    + team1.score + " " + team2.teamName + ": " + team2.score + "] " + ANSI_RESET);
            playInning(inningCounter);
            if (team1.score == team2.score) {
                gameTied = true;
            } else {
                gameTied = false;
            }
            inningCounter++;

        } while ((inningCounter < 10 || (inningCounter == 10 && gameTied)));

        if (team1.score > team2.score) {
            System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[" + team1.teamName +
                    " win the game! Final score: " + team1.score + " to " + team2.score + "]" + ANSI_RESET);
        } else if (team1.score < team2.score){
            System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[" + team2.teamName +
                    " win the game! Final score: " + team2.score + " to " + team1.score + "]" + ANSI_RESET);
        } else if (team1.score == team2.score){
            System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[" + team2.teamName +
                    " win the game! Final score: " + team2.score + " to " + team1.score + "]" + ANSI_RESET);
        }
    }

    public void playInning(int inningCounter) {
        //create a new inning object
        Inning inning = new Inning();

        //each team plays an inning
        if (team1.home) {
            inning.playHalfInning(team2);
            if ((inningCounter ==9) && (team2.score < team1.score)){
                //do nothing here, game ends early
            } else {
                inning.playHalfInning(team1);
            }
        } else {
            inning.playHalfInning(team1);
            if ((inningCounter ==9) && (team1.score < team2.score)){
                //do nothing here, game ends early
            } else {
                inning.playHalfInning(team2);
            }
        }
    }
}
