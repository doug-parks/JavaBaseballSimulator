/**
 * Created by djp4830 on 4/23/17.
 */
public class Inning {

    public  static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public  static final String ANSI_BLACK = "\u001B[30m";
    public  static final String ANSI_RESET = "\u001B[0m";

    public void playHalfInning(Team team) {
        int outs = 0;
        team.setBatterIndex(0);
        Field field = new Field(); //creates a new field object

        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + team.teamName + " are at bat." + ANSI_RESET);

        while (outs < 3) {
            Player player = team.getNextBatter();
            String currentPlayerName = player.getPlayerName(); //Store playerName in currentPlayer string
            System.out.print(currentPlayerName + " steps up to the plate...");

            int hit = player.bat();

            if (hit > 0) {
                field.runToBase(team, player, hit);
            } else {
                int outType = player.randomOut();
                if (outType == 0){
                    System.out.println("and gets tagged out at first!");
                } else if (outType == 1){
                    System.out.println("and gets struck out!");
                } else if (outType == 2){
                    System.out.println("and hits a ground out!");
                } else if (outType == 3){
                    System.out.println("and hits a fly out!");
                }
                outs++;
            }
        }
    }
}
