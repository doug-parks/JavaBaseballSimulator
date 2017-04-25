import java.util.Random;

/**
 * Created by djp4830 on 4/22/17.
 */
public class Player {
    String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static int bat() { //pulls a random number 0-100, and returns a value 1-4 based on probability

        Random random = new Random(); //create new random number object
        int randomInt = random.nextInt(100); //store random number

        if (randomInt <= 70) { //generates outs
            return 0;
        } else if (randomInt > 70 && randomInt <= 87) { //generates singles
            return 1;
        } else if (randomInt > 87 && randomInt <= 94) { //generates doubles
            return 2;
        } else if (randomInt > 94 && randomInt <= 96) { //generates triples
            return 3;
        } else if (randomInt > 96 && randomInt <= 100) { //generates homeruns
            return 4;
        }
        return 0;
    }

}
