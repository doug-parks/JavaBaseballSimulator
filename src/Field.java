/**
 * Created by djp4830 on 4/24/17.
 */
public class Field {

    public static final String ANSI_RED = "\u001B[31m";
    public  static final String ANSI_GREEN = "\u001B[32m";
    public  static final String ANSI_BLUE = "\u001B[34m";
    public  static final String ANSI_WHITE = "\u001B[37m";
    public  static final String ANSI_RESET = "\u001B[0m";

    Player[] bases = new Player[4];

    public void runToBase(Team team, Player player, int hit) {

        switch (hit) {
            case 1:
                baseUpdateSingle(team, player);
                break;
            case 2:
                baseUpdateDouble(team, player);
                break;
            case 3:
                baseUpdateTriple(team, player);
                break;
            case 4:
                baseUpdateHomeRun(team, player);
                break;
        }
    }

    private boolean manOnFirst() {
        if (bases[1] != null) return true; //returns true if there is a batter on first
        else return false;
    }

    private boolean manOnSecond() { //returns true if there is a batter on second
        if (bases[2] != null) return true;
        else return false;
    }

    private boolean manOnThird() { //returns true if there is a batter on third
        if (bases[3] != null) return true;
        else return false;
    }

    public void baseUpdateSingle(Team team, Player player) { //shifts the players around the bases for a single
        System.out.println("and hits a single!");

        if (manOnThird()) {
            playerScored(bases[3].getPlayerName(), team, player);
            bases[3] = null;
        }
        if (manOnSecond()) {
            bases[3] = bases[2];
            System.out.println("\t\t" + bases[3].getPlayerName() + " runs to third base");
            bases[2] = null;
        }
        if (manOnFirst()) {
            bases[2] = bases[1];
            System.out.println("\t\t" + bases[2].getPlayerName() + " sprints to second base");
            bases[1] = null;
        }
        bases[1] = player;
        System.out.println("\t\t" + bases[1].getPlayerName() + " sprints to first base");
    }

    public void baseUpdateDouble(Team team, Player player) { //shifts the players around the bases for a double
        System.out.println("and hits a double!");

        if (manOnThird()) {
            playerScored(bases[3].getPlayerName(), team, player);
            bases[3] = null;
        }
        if (manOnSecond()) {
            playerScored(bases[2].getPlayerName(), team, player);
            bases[2] = null;
        }
        if (manOnFirst()) {
            bases[3] = bases[1];
            System.out.println("\t\t" + bases[3].getPlayerName() + " slides into third base");
            bases[1] = null;
        }
        bases[2] = player;
        System.out.println("\t\t" + bases[2].getPlayerName() + " jogs to second base");

    }

    public void baseUpdateTriple(Team team, Player player) { //shifts the players around the bases for a triple
        System.out.println("and hits a triple!");

        if (manOnThird()) {
            playerScored(bases[3].getPlayerName(), team, player);
            bases[3] = null;
        }
        if (manOnSecond()) {
            playerScored(bases[2].getPlayerName(), team, player);
            bases[2] = null;
        }
        if (manOnFirst()) {
            playerScored(bases[1].getPlayerName(), team, player);
            bases[1] = null;
        }
        bases[3] = player;
        System.out.println("\t\t" + bases[3].getPlayerName() + " sprints to third base");
    }

    public void baseUpdateHomeRun(Team team, Player player) { //shifts the players around the bases for a homerun
        System.out.println("and hits a... " + //generates some red/white/blue text in the console cuz AMERICA
                ANSI_RED + "\n\t\tH " +
                ANSI_WHITE + " O " +
                ANSI_BLUE + " M " +
                ANSI_RED + " E " +
                ANSI_WHITE + " R " +
                ANSI_BLUE + " U " +
                ANSI_RED + " N " +
                ANSI_WHITE + " ! " + ANSI_RESET);

        if (manOnThird()) {
            playerScored(bases[3].getPlayerName(), team, player);
            bases[3] = null;
        }
        if (manOnSecond()) {
            playerScored(bases[2].getPlayerName(), team, player);
            bases[2] = null;
        }
        if (manOnFirst()) {
            playerScored(bases[1].getPlayerName(), team, player);
            bases[1] = null;
        }
        bases[3] = player;
        playerScored(player.getPlayerName(), team, player);
    }

    public void playerScored(String scoringPlayer, Team team, Player player) { //generates text when a player scores
        System.out.println("\t\t" + scoringPlayer + " sprints home! \n" + "\t\t" + ANSI_GREEN + team.teamName
                + " have scored!" + ANSI_RESET);
        team.score++;
    }
}
