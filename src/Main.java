import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        //create team objects (name, home status, score
        Team team1 = new Team("Dolphins", true, 0);
        Team team2 = new Team("Salmons", false, 0);

        //assign players to team 1 object
        team1.players.add(new Player("Baseball jones"));
        team1.players.add(new Player("Tractor-pull jones"));
        team1.players.add(new Player("Football jones"));
        team1.players.add(new Player("Foosball jones"));
        team1.players.add(new Player("Hockeyball jones"));
        team1.players.add(new Player("Bikeball jones"));
        team1.players.add(new Player("Soccerball jones"));
        team1.players.add(new Player("Racquetball jones"));
        team1.players.add(new Player("Basketball jones"));

        //assign players to team 2 object
        team2.players.add(new Player("Baseball johnson"));
        team2.players.add(new Player("Basketball johnson"));
        team2.players.add(new Player("Football johnson"));
        team2.players.add(new Player("Foosball johnson"));
        team2.players.add(new Player("Hockeyball johnson"));
        team2.players.add(new Player("Bikeball johnson"));
        team2.players.add(new Player("Soccerball johnson"));
        team2.players.add(new Player("Racquetball johnson"));
        team1.players.add(new Player("Tractor-pull johnson"));

        //create new game object
        BaseballGame game = new BaseballGame(team1, team2);
        game.play();
    }
}
