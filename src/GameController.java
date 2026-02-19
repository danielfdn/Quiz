import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameController {
    private final int TOTAL_QUESTIONS = 10;
    FileHandler fileHandler = new FileHandler();

    public void menuAuswertung() throws IOException {
        Player player = Menu.createPlayer();

        while(true) {
            int menuAuswahl = Menu.anzeigen(player);
            boolean quitGame = false;
            switch(menuAuswahl) {
                case 1:
                    fileHandler.setFileHighscore(spielen((player)));
                    break;
                case 2:
                    Menu.highscoreAusgeben(player, fileHandler);
                    break;
                case 3:
                    Menu.regelwerk();
                    break;
                default:
                    System.out.println("Bitte triff eine gültige Eingabe\n");
                    break;
                case 4: quitGame = true;
            }
            if(quitGame)
                break;
            else
                continue;
        }
    }

    public int spielen(@org.jetbrains.annotations.NotNull Player player) {
        int localHighscore;
        while(true) {
            localHighscore = 0;
            for (int i = 0; i < TOTAL_QUESTIONS; i++) {
                if (QuestionManager.frageStellen(i, fileHandler.fragenAuslesen(player.getLevel()), fileHandler)) {
                    player.setScore(localHighscore += player.getLevel().level);
                }
                System.out.println("Punktzahl " + player.getName() + ": " + localHighscore);
            }

            String userInput = (IO.readln("Ihr erreichter highscore für diese Runde beträgt: " + localHighscore + ".\nMöchten Sie die Runde wiederholen (j/n)"));
            if(userInput.equalsIgnoreCase("j"))
                continue;
            else
                break;
        }

            return localHighscore;
    }
}